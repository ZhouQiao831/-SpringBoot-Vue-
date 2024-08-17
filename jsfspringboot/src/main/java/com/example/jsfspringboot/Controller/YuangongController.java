package com.example.jsfspringboot.Controller;

import com.example.jsfspringboot.dao.Yuangong;
import com.example.jsfspringboot.mapper.YuangongMapper;
import com.example.jsfspringboot.service.YuangongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/yuangong")
public class YuangongController {

    @Autowired
    private YuangongMapper yuangongMapper;
    @Autowired
    private YuangongService yuangongService;
    @GetMapping("/index")
    public Map<String,Object> index(@RequestParam  String name,@RequestParam  Integer pageNum,@RequestParam  Integer pageSize){
        Map<String,Object> res=new HashMap<>();
        pageNum = (pageNum - 1) * pageSize;
        List<Yuangong> data=yuangongMapper.selecthy(name,pageNum,pageSize);
System.out.println(data);
        Integer total=yuangongMapper.selectcount(name);
        res.put("code",200);
        res.put("data",data);
        res.put("total",total);
        return res;

    }
    @PostMapping("/save")
    public Map<String,Object> save(@RequestBody Yuangong yuangong){
        Map<String,Object> res=new HashMap<>();
        System.out.println(yuangong.getId());
        if(yuangong.getId()==null){
            if(yuangongService.addyg(yuangong) == 1){
                res.put("code",200);
                res.put("msg","新增成功");
            }

        }else{
            if(yuangongService.updateyg(yuangong) == 1){
                res.put("code",200);
                res.put("msg","修改成功");
            }
        }
        return res;
    }
    @GetMapping("/delete")
    public Map<String,Object> shanchu(@RequestParam String id){
        Map<String,Object> res=new HashMap<>();
        if(yuangongMapper.deleteyg(id) == 1){
            res.put("code",200);
            res.put("msg","删除成功");
        }
        return res;
    }
    @GetMapping("/jl")
    public  Map<String, Object> chajl(){
        Map<String,Object> res=new HashMap<>();
List<Yuangong> data=yuangongMapper.selectjl();
        res.put("code",200);
res.put("data",data);


        return res;
    }

}
