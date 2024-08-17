package com.example.jsfspringboot.service;

import com.example.jsfspringboot.dao.Baoming;
import com.example.jsfspringboot.mapper.BaomingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaomingService {
@Autowired
    private BaomingMapper baomingMapper;
public  int baoming(Baoming baoming){
   return baomingMapper.add(baoming);
}
}
