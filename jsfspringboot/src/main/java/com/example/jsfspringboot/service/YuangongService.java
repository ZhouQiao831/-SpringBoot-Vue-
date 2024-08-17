package com.example.jsfspringboot.service;

import com.example.jsfspringboot.dao.Yuangong;
import com.example.jsfspringboot.mapper.YuangongMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YuangongService {
@Autowired
    private YuangongMapper yuangongMapper;
 public  int addyg(Yuangong yuangong){
    return yuangongMapper.addhy(yuangong);
 }
    public  int updateyg(Yuangong yuangong){
        return yuangongMapper.updateyg(yuangong);
    }

}
