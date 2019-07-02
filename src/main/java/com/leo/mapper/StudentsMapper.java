package com.leo.mapper;

import com.leo.entity.Students;
import com.leo.util.StudentsParams;

import java.util.List;

public interface StudentsMapper {
    int deleteByPrimaryKey(Integer xh);

    int insert(Students record);

    int insertSelective(Students record);

    Students selectByPrimaryKey(Integer xh);

    List<Students> selectStudents(StudentsParams params);

    int updateByPrimaryKeySelective(Students record);

    int updateByPrimaryKey(Students record);
}