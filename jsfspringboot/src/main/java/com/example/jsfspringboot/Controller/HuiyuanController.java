package com.example.jsfspringboot.Controller;

import com.example.jsfspringboot.dao.Huiyuan;
import com.example.jsfspringboot.dao.Yuangong;
import com.example.jsfspringboot.mapper.HuiyuanMapper;
import com.example.jsfspringboot.service.HuiyuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/huiyuan")
public class HuiyuanController {
    @Autowired
    private HuiyuanService huiyuanService;
    @Autowired
    private HuiyuanMapper huiyuanMapper;

    @PostMapping("/add")
    public Map<String, Object> inserthy(@RequestBody Huiyuan huiyuan) {

        Map<String, Object> res = new HashMap<>();
        if (huiyuanService.huiyuan(huiyuan) == 1) {
            res.put("code", 200);
            res.put("msg", "新增成功");
        } else {
            res.put("code", 500);
            res.put("msg", "新增失败");

        }
        return res;
    }

    @GetMapping("/index")
    public Map<String, Object> selectall(@RequestParam String cardno, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        Map<String, Object> res = new HashMap<>();
        pageNum = (pageNum - 1) * pageSize;
        List<Huiyuan> data = huiyuanMapper.selecthuiyuan(cardno, pageNum, pageSize);
        System.out.println(data);
        Integer total=huiyuanMapper.selecttotal(cardno);
        res.put("code", 200);
        res.put("data", data);
        res.put("total",total);
        return res;
    }

    @PostMapping("/update")
    public Map<String, Object> updatehy(@RequestBody Huiyuan huiyuan) {

        Map<String, Object> res = new HashMap<>();
        if (huiyuanService.huiyuanupdate(huiyuan) == 1) {
            res.put("code", 200);
            res.put("msg", "修改成功");
        } else {
            res.put("code", 500);
            res.put("msg", "修改失败");

        }
        return res;
    }
    @GetMapping("/delete")
    public  Map<String, Object> shanchuhy(@RequestParam String id){
        Map<String,Object> res=new HashMap<>();
        if(huiyuanMapper.deletehuiyuan(id) == 1){
            res.put("code",200);
            res.put("msg","删除成功");
        }
        return res;
    }

}
