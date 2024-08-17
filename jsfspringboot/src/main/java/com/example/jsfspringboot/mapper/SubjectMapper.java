package com.example.jsfspringboot.mapper;

import com.example.jsfspringboot.dao.Subject;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SubjectMapper {
    @Select("select * from subject where name like concat ('%',#{name},'%') limit #{pageNum}, #{pageSize}")
    List<Subject> select(String name,Integer pageNum,Integer pageSize);
    @Select("select count(*) from subject where name like concat('%',#{name},'%')")
    Integer selectcount(String name);
    @Insert("insert into subject (name,time,timelong,jiaolian,jiaolianid) VALUES (#{name},#{time},#{timelong},#{jiaolian},#{jiaolianid})")
    Integer add(Subject subject);
    @Update("update subject set name=#{name},time=#{time},timelong=#{timelong},jiaolian=#{jiaolian},jiaolianid=#{jiaolianid} where id=#{id}")
    Integer update(Subject subject);
    @Delete("delete from subject where id=#{id}")
    Integer delete(String id);

}
