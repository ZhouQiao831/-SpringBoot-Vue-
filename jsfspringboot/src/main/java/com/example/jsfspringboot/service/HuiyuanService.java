package com.example.jsfspringboot.service;

import com.example.jsfspringboot.dao.Huiyuan;
import com.example.jsfspringboot.mapper.HuiyuanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HuiyuanService {
@Autowired
    private HuiyuanMapper huiyuanMapper;
public int huiyuan(Huiyuan huiyuan){
    return huiyuanMapper.inserthuiyuan(huiyuan);
}
public int huiyuanupdate(Huiyuan huiyuan){
    return huiyuanMapper.updatehuiyuan(huiyuan);
}
}
