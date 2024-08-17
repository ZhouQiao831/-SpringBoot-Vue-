package com.example.jsfspringboot.mapper;

import com.example.jsfspringboot.dao.Huiyuan;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface HuiyuanMapper {
@Insert("insert into huiyuan (cardno,name,createTime,sex,year,phone,height,weight,buytime,shengyutime,hyimg,pass) VALUES (#{cardno},#{name},#{createTime},#{sex},#{year},#{phone},#{height},#{weight},#{buytime},#{shengyutime},#{hyimg},#{pass})")
int inserthuiyuan(Huiyuan huiyuan);
@Select("select * from huiyuan where cardno like concat('%',#{cardno},'%')  limit #{pageNum} ,#{pageSize}")
    List<Huiyuan> selecthuiyuan(String cardno,Integer pageNum,Integer pageSize);
@Select("select count(*) from huiyuan where cardno like concat('%',#{cardno},'%')")
Integer selecttotal(String cardno);
@Update("update  huiyuan set cardno=#{cardno},name=#{name},createTime=#{createTime},sex=#{sex},year=#{year},phone=#{phone},height=#{height},weight=#{weight},buytime=#{buytime},shengyutime=#{shengyutime},hyimg=#{hyimg},pass=#{pass} where id=#{id}")
int updatehuiyuan(Huiyuan huiyuan);
@Delete("delete from huiyuan where id = #{id}")
    int deletehuiyuan(String id);
@Select("select * from huiyuan where cardno=#{cardno} and pass=#{pass}")
    List<Huiyuan> select(String cardno,String pass);
}
