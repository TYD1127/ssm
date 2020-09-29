package com.alpha.Book.controller;

import com.alpha.Book.pojo.Books;
import com.alpha.Book.pojo.User;
import com.alpha.Book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author TangYaD
 * @Date 2020/9/28 13:27
 * @Version 1.0
 */
@Controller
public class viewController {
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    //跳转注册页面
    @RequestMapping("/reg")
    public String reg() {
        return "reg";
    }

    //请求转发返回登陆
    @RequestMapping("/backed")
    public String backed() {
        return "forward:index.jsp";
    }

    @RequestMapping("/regController")
    public String regController(User user, Model model) {
        String msg = "";
        if (user.getUname() == "" || user.getUpwd() == "") {
            msg = "注册失败用户名或密码不能为空";
        } else {
            bookService.addUser(user);
            msg = "注册成功";
        }
        model.addAttribute("msg", msg);
        return "reg";
    }


    @RequestMapping("/regcheckName")
    @ResponseBody
    public String checkName(String uname) {
        String msg = "";
        if (!uname.equals("")) {
            Books query = bookService.checkName(uname);
            if (null == query) {
                msg = "ok";
            } else {
                msg = "此用户名已被占用";
            }
        }
        return msg;
    }
}
