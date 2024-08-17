package com.example.jsfspringboot.Controller;

import com.example.jsfspringboot.dao.Qicai;
import com.example.jsfspringboot.dao.Yuangong;
import com.example.jsfspringboot.mapper.QicaiMapper;
import com.example.jsfspringboot.service.QicaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/qicai")
public class QicaiController {
    @Autowired
    private QicaiMapper qicaiMapper;
    @Autowired
    private QicaiService qicaiService;
    @GetMapping("/index")
    public Map<String ,Object> index(@RequestParam String name,@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        Map<String ,Object > res=new HashMap<>();
        pageNum=(pageNum-1)*pageSize;
        List<Qicai> data=qicaiMapper.selectqc(name,pageNum,pageSize);
        Integer total=qicaiMapper.selecttotal(name);
        res.put("data",data);
        res.put("total",total);
        return  res;
    }
    @PostMapping("/save")
    public Map<String,Object> save(@RequestBody Qicai qicai){
        Map<String,Object> res=new HashMap<>();
        System.out.println(qicai.getId());
        if(qicai.getId()==null){
            if(qicaiService.addyg(qicai) == 1){
                res.put("code",200);
                res.put("msg","新增成功");
            }

        }else{
            if(qicaiService.updateyg(qicai) == 1){
                res.put("code",200);
                res.put("msg","修改成功");
            }
        }
        return res;
    }
    @GetMapping("/delete")
    public Map<String,Object> shanchu(@RequestParam String id){
        Map<String,Object> res=new HashMap<>();
        if(qicaiMapper.shanchuqc(id) == 1){
            res.put("code",200);
            res.put("msg","删除成功");
        }
        return res;
    }
}
