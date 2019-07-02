package com.leo.service.grade;

import com.github.pagehelper.PageHelper;
import com.leo.entity.Grade;
import com.leo.mapper.GradeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeMapper gradeMapper;

    @Override
    public int deleteByPrimaryKey(Short gid) {
        return 0;
    }

    @Override
    public int insert(Grade record) {
        return 0;
    }

    @Override
    public int insertSelective(Grade record) {
        return 0;
    }

    @Override
    public Grade selectByPrimaryKey(Short gid) {
        return gradeMapper.selectByPrimaryKey(gid);
    }

    @Override
    public List<Grade> selectGrades() {
        PageHelper.startPage(1,10,"gname ASC");
        List<Grade> grades = gradeMapper.selectGrades();
        return grades;
    }

    @Override
    public int updateByPrimaryKeySelective(Grade record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Grade record) {
        return 0;
    }
}
