package com.alpha.Book.controller;

import com.alpha.Book.pojo.Books;
import com.alpha.Book.pojo.User;
import com.alpha.Book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("unchecked")
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        return "allBook";
    }

//    @RequestMapping("/toAddBook")
//    public String toAddPaper() {
//        return "addBook";
//    }

    /*@RequestMapping("/addBook")
    public String addPaper(Books books) {
        System.out.println(books);
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }*/

    /**
     * 跳转 添加/更新 页面
     *
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook( Model model, Integer id) {
        if (id != null) {
            Books books = bookService.queryBookById(id);
            System.out.println(books);
            model.addAttribute("book", books);
            model.addAttribute("title", "修改书籍信息");

        } else {
            model.addAttribute("title", "添加书籍");
        }

        return "updateBook";
    }

    /**
     * 根据id添加或更新 book
     *
     * @param model
     * @param book
     * @return
     */
    @RequestMapping("/updateBook")
    public String updateBook(Model model, Books book) {
        System.out.println(book);
        if (book.getBookID() == null) {
            bookService.addBook(book);
            model.addAttribute("msg", "添加成功");
        } else {

            bookService.updateBook(book);
            Books books = bookService.queryBookById(book.getBookID());
            model.addAttribute("msg", "修改成功");
        }
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        return "allBook";
    }

    @RequestMapping("/del/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    /**
     * 根据Name查询书籍
     *
     * @param query
     * @param model
     * @return
     */
    @RequestMapping("/queryBook")
    public String queryBook(String query, Model model) {
        Books books = bookService.queryByName(query);
        List<Books> list = new ArrayList();
        if (books == null) {
            list = bookService.queryAllBook();
            model.addAttribute("error", "书籍名称不存在");
        } else {
            list.add(books);
        }
        model.addAttribute("list", list);
        return "allBook";
    }



    /**
     * 根据用户名查询
     */
    @RequestMapping("/checkName")
    @ResponseBody
    public String checkName(String uname) {
        String msg = "";
        if (!uname.equals("")) {
            Books query = bookService.checkName(uname);
            if (null == query) {
                msg = "用户不存在";
            } else {
                msg = "用户名正确";
            }
        }
        return msg;
    }

}
