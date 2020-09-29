package com.alpha.Book.dao;

import com.alpha.Book.pojo.Books;
import com.alpha.Book.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {

    //增加一个Book
    int addBook(Books book);

    int addUser(User user);

    //根据id删除一个Book
    int deleteBookById(@Param("bookID") int id);

    //更新Book
    int updateBook(Books books);

    //根据id查询,返回一个Book
    Books queryBookById(@Param("bookId") int id);

    //用户登陆
    User loginByName(User name);

    //查询全部Book,返回list集合
    List<Books> queryAllBook();

    //根据name查询,返回一个Book
    Books queryByName(String Name);

    //用户名称检查
    Books checkName(String name);
}