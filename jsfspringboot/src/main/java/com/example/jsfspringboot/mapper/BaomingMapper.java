package com.example.jsfspringboot.mapper;

import com.example.jsfspringboot.dao.Baoming;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BaomingMapper {
    @Insert("insert into baoming (kcid,kcname,time,jiaolian,huiyuanid,huiyuanname) VALUES (#{kcid},#{kcname},#{time},#{jiaolian},#{huiyuanid},#{huiyuanname})")
    Integer add(Baoming baoming);
    @Select("select * from baoming where huiyuanid=#{huiyuanid}")
    List<Baoming> select(String huiyuanid);
    @Select("select * from baoming where kcid=#{kcid}")
    List<Baoming> select1(String kcid);
    @Delete("delete from baoming where id=#{id}")
    Integer shanchu(String id);
}
