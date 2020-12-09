package net.xdclass.forum.controller;

import net.xdclass.forum.domain.Reply;
import net.xdclass.forum.domain.Topic;
import net.xdclass.forum.domain.User;
import net.xdclass.forum.dto.PageDTO;
import net.xdclass.forum.service.TopicService;
import net.xdclass.forum.service.impl.TopicServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "topicServlet",urlPatterns = {"/topic"})
public class TopicServlet extends BaseServlet {

    private TopicService topicService = new TopicServiceImpl();

    /**
     * 默认分页大小
     */
    private static final int pageSize = 2;


    /**
     * http://localhost:8080/topic?method=list&c_id=2&page=2
     *
     * topic分页接口
     * @param request
     * @param response
     */
    public void list(HttpServletRequest request, HttpServletResponse response){

        int cId = Integer.parseInt(request.getParameter("c_id"));

        //默认第一页
        int page=1;

        String currentPage = request.getParameter("page");

        if(currentPage !=null && currentPage !=""){
            page = Integer.parseInt(currentPage);
        }


        PageDTO<Topic> pageDTO =  topicService.listTopicPageByCid(cId,page,pageSize);

        System.out.println(pageDTO.toString());


        request.setAttribute("topicPage" ,pageDTO);

    }


    /**
     * http://localhost:8080/topic?method=findDetailById&topic_id=1&page=1
     *
     * 查看主题的全部回复
     * @param request
     * @param response
     */
    public void  findDetailById(HttpServletRequest request,HttpServletResponse response){

        //获取topicid
        int topicId = Integer.parseInt(request.getParameter("topic_id"));

        //默认第一页
        int page=1;

        String currentPage = request.getParameter("page");

        if(currentPage !=null && currentPage !=""){
            page = Integer.parseInt(currentPage);
        }

        //处理浏览量
        String sessionReadKey = "is_read"+topicId;
        Boolean isRead = (Boolean) request.getSession().getAttribute(sessionReadKey);
        if(isRead == null){
            request.getSession().setAttribute(sessionReadKey,true);
            topicService.addOnePV(topicId);
        }

        Topic topic = topicService.findById(topicId);

        PageDTO<Reply> pageDTO =  topicService.findReplyPageByTopicId(topicId,page,pageSize);

        System.out.println(pageDTO.toString());

        request.setAttribute("topic" ,topic);
        request.setAttribute("replyPage",pageDTO);
    }

    /**
     * 发布主题
     */
    public void addTopic(HttpServletRequest request,HttpServletResponse response){
        User loginUser = (User)request.getSession().getAttribute("loginUser");
        if(loginUser==null){
            request.setAttribute("msg","请登录");
            System.out.println("loginUser null");
            return;
        }

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        int cId = Integer.parseInt(request.getParameter("c_id"));

        int rows = topicService.addTopic(loginUser,title,content,cId);
        if (rows==1){
            System.out.println("发布成功");
        }else {
            System.out.println("xxxxxxxxxxxx");
        }

    }

    /**
     * 盖楼
     * http://localhost:8080/topic?method=replyByTopicId&topic_id=9
     */
    public void replyByTopicId(HttpServletRequest request,HttpServletResponse response){
        User longUser = (User)request.getSession().getAttribute("loginUser");
        if(longUser == null){
            request.setAttribute("msg","请登录");
            return;
        }

        int topicId = Integer.parseInt(request.getParameter("topic_id"));
        String content = request.getParameter("content");

        int rows = topicService.replyByTopicId(longUser,topicId,content);
        if (rows==1){
            System.out.println("发布成功");
        }else {
            System.out.println("xxxxxxxxxxx");
        }

    }













}
