package net.xdclass.forum.controller;

import net.xdclass.forum.domain.Category;
import net.xdclass.forum.service.CategoryService;
import net.xdclass.forum.service.impl.CategoryServiceImpl;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(name = "categoryServlet",urlPatterns = {"/category"})
public class CategoryServlet extends BaseServlet {
    /**
     *返回全部分类
     */
    public void list(HttpServletRequest req, HttpServletResponse res){
        CategoryService categoryService = new CategoryServiceImpl();
        List<Category> categories = categoryService.list();
        System.out.println(categories.toString());
        System.out.println("输出成功");

    }
}
