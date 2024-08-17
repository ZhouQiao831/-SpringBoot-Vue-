package com.example.jsfspringboot.service;

import com.example.jsfspringboot.dao.Subject;
import com.example.jsfspringboot.mapper.SubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {
@Autowired
    private SubjectMapper subjectMapper;
public  int addservice(Subject subject){
    return  subjectMapper.add(subject);
}
    public  int updateservice(Subject subject){
        return  subjectMapper.update(subject);
    }

}
