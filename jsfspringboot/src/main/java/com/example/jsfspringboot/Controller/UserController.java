package com.example.jsfspringboot.Controller;

import com.example.jsfspringboot.dao.Huiyuan;
import com.example.jsfspringboot.dao.User;
import com.example.jsfspringboot.mapper.HuiyuanMapper;
import com.example.jsfspringboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
@Autowired
    private UserMapper userMapper;
@Autowired
private HuiyuanMapper huiyuanMapper;
    @GetMapping("/login")
    public Map<String,Object> login(@RequestParam  String username, @RequestParam String password,@RequestParam int type){


        Map<String,Object> res=new HashMap<>();

        if( type == 1){
            List<User> data=userMapper.select(username,password);
            if(data.isEmpty()){
                res.put("code",500);
                res.put("msg","该用户不存在");

            }else{
                res.put("code",200);
                res.put("data",data);
                res.put("msg","登录成功");


            }

        }
        return res;
    }
    @GetMapping("/hylogin")
    public Map<String,Object> login1(@RequestParam  String cardno, @RequestParam String pass,@RequestParam int type){


        Map<String,Object> res=new HashMap<>();

        if( type == 2){
            List<Huiyuan> data=huiyuanMapper.select(cardno,pass);
            if(data.isEmpty()){
                res.put("code",500);
                res.put("msg","该用户不存在");

            }else{
                res.put("code",200);
                res.put("data",data);
                res.put("msg","登录成功");


            }

        }
        return res;
    }
}
