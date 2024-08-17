package com.example.jsfspringboot.mapper;

import com.example.jsfspringboot.dao.Qicai;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QicaiMapper {
    @Select("select * from qicai where name like concat ('%',#{name},'%') limit #{pageNum},#{pageSize}")
    List<Qicai> selectqc(String name,Integer pageNum,Integer pageSize);
    @Select("select count(*) from qicai where name like concat ('%',#{name},'%')")
    Integer selecttotal(String name);
    @Insert("insert into qicai (name,location,remark,status) VALUES (#{name},#{location},#{remark},#{status})")
    Integer insertqc(Qicai qicai);
    @Update("update qicai SET name =#{name},location=#{location},remark=#{remark},status=#{status} where id=#{id}")
    Integer updateqc(Qicai qicai);
    @Delete("delete from qicai where id=#{id}")
    Integer shanchuqc(String id);
}
