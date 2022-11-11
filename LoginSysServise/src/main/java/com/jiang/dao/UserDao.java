package com.jiang.dao;

import com.jiang.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Select("select * from tb_account where id = #{id}")
    User getById(Integer id);

    @Select("select * from tb_account where name = #{name}")
    User getByName(String name);

    @Select("select * from tb_account where email = #{email}")
    User getByEmail(String email);

    @Select("select * from tb_account where name = #{name} and pw = #{pw}")
    User loginByName(String name, String pw);

    @Select("select * from tb_account where email = #{email} and pw = #{pw}")
    User loginByEmail(String email, String pw);

    @Insert("insert into tb_account(name,email,pw,submission_date)values(#{name},#{email},#{pw},#{submission_date})")
    Integer insert(String name, String email, String pw, String submission_date);

}
