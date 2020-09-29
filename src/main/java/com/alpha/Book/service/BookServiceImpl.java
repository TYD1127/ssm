package com.alpha.Book.service;

import com.alpha.Book.dao.BookMapper;
import com.alpha.Book.pojo.Books;
import com.alpha.Book.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    //调用dao层的操作，设置一个set接口，方便Spring管理
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public int addUser(User user) {
        return bookMapper.addUser(user);
    }

    public int addBook(Books book) {
        return bookMapper.addBook(book);
    }

    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    public Books queryByName(String name) {

        return bookMapper.queryByName(name);
    }

    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    public Books checkName(String name) {

        return bookMapper.checkName(name);
    }
}