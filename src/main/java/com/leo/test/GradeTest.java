package com.leo.test;

import com.leo.service.grade.GradeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class GradeTest {
    @Autowired
    private GradeService gradeService;

    @Test
    public void selectGradeByGid(){
        System.out.println(gradeService.selectByPrimaryKey(Short.valueOf("1")));
    }

    @Test
    public void selectGrades(){
        System.out.println(gradeService.selectGrades());
    }
}
