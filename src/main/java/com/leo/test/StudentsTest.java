package com.leo.test;

import com.leo.service.students.StudentsService;
import com.leo.util.StudentsParams;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class StudentsTest {
    @Autowired
    private StudentsService studentsService;

    @Test
    public void selectStudentById(){
        System.out.println(studentsService.selectByPrimaryKey(101));
    }

    @Test
    public void selectAllStudents(){
        StudentsParams studentsParams = new StudentsParams(1,6);
        studentsParams.setAddress("树");
        System.out.println(studentsService.selectStudents(studentsParams));
    }
}
