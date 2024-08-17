package com.example.jsfspringboot.service;

import com.example.jsfspringboot.dao.Qicai;
import com.example.jsfspringboot.dao.Yuangong;
import com.example.jsfspringboot.mapper.QicaiMapper;
import com.example.jsfspringboot.mapper.YuangongMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QicaiService {
    @Autowired
    private QicaiMapper qicaiMapper;
    public  int addyg(Qicai qicai){
        return qicaiMapper.insertqc(qicai);
    }
    public  int updateyg(Qicai qicai){
        return qicaiMapper.updateqc(qicai);
    }

}
