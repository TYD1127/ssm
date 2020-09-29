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

import java.util.List;

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

    //请求转发返回
    @RequestMapping("/backed")
    public String backed() {
        return "index";
    }

    //用户登陆
    @RequestMapping("/login")
    public String login(User user, Model model) {
        String msg = "";
        System.out.println(user.getUname());
        if (user.getUname() == "" || user.getUpwd() == "") {
            msg = "用户名或密码不能为空";
            model.addAttribute("msg", msg);
        } else {
            User user1 = bookService.loginByName(user);
            if (null != user1) {
                if (user1.getUpwd().equals(user.getUpwd())) {
                    msg = "登陆成功"+user1.getUname();
                    model.addAttribute("msg", msg);
                    List<Books> list = bookService.queryAllBook();
                    model.addAttribute("list", list);
                    return "allBook";
                }
                msg = "密码错误";
                model.addAttribute("msg", msg);
                return "index";
            }
            msg = "请确认用户名";
        }
        model.addAttribute("msg", msg);
        return "index";
    }

    //用户注册
    @RequestMapping("/regController")
    public String regController(User user, Model model) {
        String msg = "";
        if (user.getUname() == "" || user.getUpwd() == "") {
            msg = "注册失败用户名或密码不能为空";
        } else {
            bookService.addUser(user);
            msg = "注册成功";
            model.addAttribute("msg", msg);
            return "index";
        }
        model.addAttribute("msg", msg);
        return "reg";
    }

    //注册用户名检查
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
