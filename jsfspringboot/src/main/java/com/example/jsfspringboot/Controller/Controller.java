package com.example.jsfspringboot.Controller;

import com.example.jsfspringboot.mapper.HuiyuanMapper;
import com.example.jsfspringboot.mapper.QicaiMapper;
import com.example.jsfspringboot.mapper.SubjectMapper;
import com.example.jsfspringboot.mapper.YuangongMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/shouye")
public class Controller {
    @Autowired
    private HuiyuanMapper huiyuanMapper;
    @Autowired
    private QicaiMapper qicaiMapper;
    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
    private YuangongMapper yuangongMapper;
    @GetMapping("/index")
    public Map<String,Object> index(){
        Map<String,Object> res=new HashMap<>();
        Integer qicaishu=qicaiMapper.selecttotal("");
        Integer huiyuanshu=huiyuanMapper.selecttotal("");
        Integer subjectshu=subjectMapper.selectcount("");
        Integer yuangong=yuangongMapper.selectcount("");
       Integer all=yuangong+huiyuanshu;
        res.put("code",200);
        res.put("qicaishu",qicaishu);
        res.put("huiyuanshu",huiyuanshu);
        res.put("subjectshu",subjectshu);
        res.put("yuangong",yuangong);
        res.put("all",all);
        return res;

    }
}
