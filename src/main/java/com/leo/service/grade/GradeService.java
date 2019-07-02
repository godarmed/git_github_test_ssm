package com.leo.service.grade;

import com.leo.entity.Grade;

import java.util.List;

public interface GradeService {
    int deleteByPrimaryKey(Short gid);

    int insert(Grade record);

    int insertSelective(Grade record);

    Grade selectByPrimaryKey(Short gid);

    List<Grade> selectGrades();

    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKey(Grade record);
}
