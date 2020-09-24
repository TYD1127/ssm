package com.alpha.controller;

import com.alpha.pojo.Books;
import com.alpha.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Model model, Integer id) {
        if(id != null){
            Books books = bookService.queryBookById(id);
            System.out.println(books);
            model.addAttribute("book",books );
        }
        return "updateBook";
    }

    /**
     * 根据id添加或更新 book
     * @param model
     * @param book
     * @return
     */
    @RequestMapping("/updateBook")
    public String updateBook(Model model, Books book) {
        System.out.println(book);
        if(book.getBookID() == null){
            bookService.addBook(book);
        }else{
            bookService.updateBook(book);
            Books books = bookService.queryBookById(book.getBookID());
            model.addAttribute("books", books);
        }
        return "redirect:/book/allBook";
    }
    @RequestMapping("/del/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }
}
