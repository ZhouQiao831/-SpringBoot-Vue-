package com.example.jsfspringboot.Controller;

import com.example.jsfspringboot.dao.Subject;
import com.example.jsfspringboot.mapper.SubjectMapper;
import com.example.jsfspringboot.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/subject")
public class SubjectController {
  @Autowired
  private SubjectMapper subjectMapper;
   @Autowired
   private SubjectService subjectService;
    @GetMapping("/index")
    public Map<String,Object> index(@RequestParam String name,@RequestParam Integer pageNum, @RequestParam Integer pageSize){
      pageNum=(pageNum-1)*pageSize;
      Map<String ,Object> res=new HashMap<>();
        List<Subject> data=subjectMapper.select(name,pageNum,pageSize);
        Integer total=subjectMapper.selectcount(name);
        res.put("data",data);
        res.put("total",total);
        return res;

  }
  @PostMapping("/save")
  private Map<String,Object> save(@RequestBody Subject subject){
    Map<String,Object> res=new HashMap<>();
      if(subject.getId()==null){
        if(subjectService.addservice(subject) == 1){
          res.put("code",200);
          res.put("msg","新增成功");
        }

      }else{
        if(subjectService.updateservice(subject) == 1){
          res.put("code",200);
          res.put("msg","修改成功");
        }
      }
      return  res;
  }
  @GetMapping("/shanchu")
  public Map<String,Object> shanchu(@RequestParam String id){
      Map<String,Object> res=new HashMap<>();
      if(subjectMapper.delete(id) == 1){
       res.put("code",200);
        res.put("msg","删除成功");

      }
      return  res;
  }
}
