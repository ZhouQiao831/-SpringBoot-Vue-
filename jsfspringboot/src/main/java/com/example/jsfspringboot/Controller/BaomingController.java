package com.example.jsfspringboot.Controller;

import com.example.jsfspringboot.dao.Baoming;
import com.example.jsfspringboot.dao.Huiyuan;
import com.example.jsfspringboot.mapper.BaomingMapper;
import com.example.jsfspringboot.service.BaomingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/baoming")
public class BaomingController {
@Autowired
private BaomingMapper baomingMapper;
@Autowired
private BaomingService baomingService;
    @PostMapping("/add")
    public Map<String,Object> baoming(@RequestBody Baoming baoming){
    Map<String,Object> res=new HashMap<>();
if(baomingService.baoming(baoming) == 1){
    res.put("code",200);
    res.put("msg","报名成功");
}
    return res;
}
    @GetMapping("/index")
    public Map<String, Object> selectall(@RequestParam String huiyuanid) {
        Map<String, Object> res = new HashMap<>();

        List<Baoming> data = baomingMapper.select(huiyuanid);
        System.out.println(data);
        res.put("code", 200);
        res.put("data", data);
        return res;
    }
    @GetMapping("/index1")
    public Map<String, Object> selectall1(@RequestParam String kcid) {
        Map<String, Object> res = new HashMap<>();

        List<Baoming> data = baomingMapper.select1(kcid);
        System.out.println(data);
        res.put("code", 200);
        res.put("data", data);
        return res;
    }
    @GetMapping("/shanchu")
    public Map<String, Object> shanchu(@RequestParam String id) {
        Map<String, Object> res = new HashMap<>();

       if(baomingMapper.shanchu(id) == 1){
           res.put("code", 200);
           res.put("data", "退课成功");

       }
        return res;
    }
}

