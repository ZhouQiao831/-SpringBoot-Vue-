package com.example.jsfspringboot.Controller;

import com.example.jsfspringboot.dao.Menu;
import com.example.jsfspringboot.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuMapper menuMapper;

    @GetMapping("/index")
    public Map<String,Object> menu(@RequestParam String type){
        Map<String,Object> res=new HashMap<>();
        List<Menu> data=menuMapper.selectmenu(type);
        res.put("code",200);
        res.put("data",data);
        return res;
    }
}
