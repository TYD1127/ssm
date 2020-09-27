package com.alpha.service;

import com.alpha.pojo.Books;
import org.springframework.stereotype.Service;

import java.util.List;

//BookService:底下需要去实现,调用dao层
public interface BookService {
    //增加一个Book
    int addBook(Books book);
    //根据id删除一个Book
    int deleteBookById(int id);
    //更新Book
    int updateBook(Books books);
    //根据id查询,返回一个Book
    Books queryBookById(int id);
    //根据name查询,返回一个Book
    Books queryByName(String  name);
    //查询全部Book,返回list集合
    List<Books> queryAllBook();
//    验证名字是否存在
    Books checkName(String name);
}