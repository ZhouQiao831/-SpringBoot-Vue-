package com.example.jsfspringboot.mapper;

import com.example.jsfspringboot.dao.Yuangong;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface YuangongMapper {
@Select("select * from yuangong where name like concat('%',#{name},'%') limit #{pageNum}, #{pageSize}")
    List<Yuangong> selecthy(String name, Integer pageNum, Integer pageSize);
@Select("select count(*) from yuangong where name like concat('%',#{name},'%')")
    Integer selectcount(String name);
@Insert("insert into yuangong (name,sex,year,ruzhitime,zhiwu,remark) VALUES (#{name},#{sex},#{year},#{ruzhitime},#{zhiwu},#{remark})")
Integer addhy(Yuangong yuangong);
@Update("update yuangong set name=#{name},sex=#{sex},year=#{year},ruzhitime=#{ruzhitime},zhiwu=#{zhiwu},remark=#{remark} where id =#{id} ")
    Integer updateyg(Yuangong yuangong);
@Delete("delete from yuangong where id =#{id}")
    Integer deleteyg(String id);
@Select("select * from yuangong where zhiwu='健身教练'")
    List<Yuangong> selectjl();
}
