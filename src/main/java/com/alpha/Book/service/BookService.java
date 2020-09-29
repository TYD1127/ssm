package com.alpha.Book.service;

import com.alpha.Book.pojo.Books;
import com.alpha.Book.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//BookService:底下需要去实现,调用dao层
public interface BookService {
    //    添加用户
    int addUser(User user);

    //增加一个Book
    int addBook(Books book);

    //根据id删除一个Book
    int deleteBookById(int id);

    //更新Book
    int updateBook(Books books);

    //根据id查询,返回一个Book
    Books queryBookById(int id);

    //根据name查询,返回一个Book
    Books queryByName(String name);

    //查询全部Book,返回list集合
    List<Books> queryAllBook();

    //    验证名字是否存在
    Books checkName(String name);
}