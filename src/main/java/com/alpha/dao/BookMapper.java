package com.alpha.dao;

import com.alpha.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {

    //增加一个Book
    int addBook(Books book);

    //根据id删除一个Book
    int deleteBookById(@Param("bookID") int id);

    //更新Book
    int updateBook(Books books);

    //根据id查询,返回一个Book
    Books queryBookById(@Param("bookId") int id);

    //查询全部Book,返回list集合
    List<Books> queryAllBook();
    //根据name查询,返回一个Book
    Books queryByName(String Name);

    Books checkName(String name);
}