package com.leo.mapper;

import com.leo.entity.Grade;

import java.util.List;

public interface GradeMapper {
    int deleteByPrimaryKey(Short gid);

    int insert(Grade record);

    int insertSelective(Grade record);

    Grade selectByPrimaryKey(Short gid);

    List<Grade> selectGrades();

    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKey(Grade record);
}