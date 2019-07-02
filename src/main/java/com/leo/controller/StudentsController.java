package com.leo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.github.pagehelper.PageInfo;
import com.leo.entity.Grade;
import com.leo.entity.Students;
import com.leo.service.grade.GradeService;
import com.leo.service.students.StudentsService;
import com.leo.util.StudentsParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentsController {
    @Autowired
    private StudentsService studentsService;

    @Autowired
    private GradeService gradeService;

    @RequestMapping(value = "/selectStudents")
    public String selectStudentsAll(Model model,StudentsParams params) {
        //获得学生列表
        List<Students> studentsList = studentsService.selectStudents(params);
        //获得学生分页数据
        PageInfo<Students> studentsPageInfo = new PageInfo(studentsList);
        //获得年级列表
        List<Grade> grades = gradeService.selectGrades();
        //获得年级分页数据
        PageInfo<Grade> gradesPageInfo = new PageInfo(grades);
        //添加年级列表
        model.addAttribute("gradesPageInfo",gradesPageInfo);
        //添加分页数据
        model.addAttribute("studentsPageInfo",studentsPageInfo);
        //添加查询条件
        model.addAttribute("params",params);
        return "students/list";
    }

    //save StudentsInfo
    @RequestMapping(value = "/savePageStudents")
    public String toSavePage(Model model) {
        List<Grade> grades = gradeService.selectGrades();
        model.addAttribute("grades",grades);
        return "students/save";
    }

    @RequestMapping(value = "/saveStudents")
    public String save(Students students) {
        studentsService.insert(students);
        return "redirect:/students/selectStudents";
    }

    //update StudentsInfo
    @RequestMapping(value = "/updatePageStudents/{studentsId}")
    public String toUpdatePage(@PathVariable Integer studentsId, Model model) {
        //获得年级列表
        List<Grade> grades = gradeService.selectGrades();
        //获得学生信息
        Students students = studentsService.selectByPrimaryKey(studentsId);
        //添加年级列表
        model.addAttribute("grades",grades);
        //添加学生信息
        model.addAttribute("students",students);
        return "students/edit";
    }

    @RequestMapping(value = "/updateStudents")
    public String update(Students students) {
        studentsService.updateByPrimaryKey(students);
        return "redirect:/students/selectStudents";
    }

    //delete StudentsInfo
    @RequestMapping(value = "/deleteStudentsById/{studentsId}")
    public String deleteById(@PathVariable Integer studentsId) {
        studentsService.deleteByPrimaryKey(studentsId);
        return "redirect:/students/selectStudents";
    }

    //delete more student
    @RequestMapping(value = "/deleteMoreStudents")
    @ResponseBody
    public String deleteMoreStudents(@RequestBody JSONObject deleteXhs) {
        Iterator<String> xhs = deleteXhs.keySet().iterator();
        int i = 0;
        while(xhs.hasNext()){
            i = studentsService.deleteByPrimaryKey(Integer.valueOf(deleteXhs.getString(xhs.next())));
        }
        return i!=0?deleteXhs.toString():"";
    }
}
