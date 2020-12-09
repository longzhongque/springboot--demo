package net.xdclass.forum.controller;

import com.sun.org.apache.bcel.internal.generic.IfInstruction;
import net.xdclass.forum.domain.User;
import net.xdclass.forum.service.UserService;
import net.xdclass.forum.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "userServlet",urlPatterns = {"/user"})
public class UserServlet extends BaseServlet{
    private UserService userService = new UserServiceImpl();

    /**
     * method=login
     */
    public void login(HttpServletRequest request, HttpServletResponse response){
        String phone = request.getParameter("phone");
        String pwd = request.getParameter("pwd");
        User user = userService.login(phone,pwd);
        if(user!=null){
        request.getSession().setAttribute("loginUser",user);
        }else {
            request.setAttribute("msg","用户名或密码错误");
        }
    }
    /**
     * 退出登录
     */
    public void logout(HttpServletRequest request,HttpServletResponse response){
        request.getSession().invalidate();
    }

    public void register(HttpServletRequest request,HttpServletResponse response){
        System.out.println("调用注册接口");
        User user = new User();
        Map<String,String[]> map = request.getParameterMap();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        int i = userService.register(user);
        if(i>0){
            System.out.println("注册成功");
        }else {
            System.out.println("注册失败");
        }
    }

    public void list(HttpServletRequest request,HttpServletResponse response){
        System.out.println("打印USER列表");
        List<User> users = userService.list();
        System.out.println(users.toString());
    }


}
