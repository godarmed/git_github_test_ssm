package com.leo.service.students;

import com.github.pagehelper.PageHelper;
import com.leo.entity.Students;
import com.leo.mapper.StudentsMapper;
import com.leo.util.Params;
import com.leo.util.StudentsParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentsServiceImpl implements StudentsService {
    @Autowired
    private StudentsMapper studentsMapper;

    @Override
    @Transactional
    public int deleteByPrimaryKey(Integer xh) {
        return studentsMapper.deleteByPrimaryKey(xh);
    }

    @Override
    @Transactional
    public int insert(Students record) {
        if(studentsMapper.selectByPrimaryKey(record.getXh()) != null){
            return 0;
        }
        return studentsMapper.insert(record);
    }

    @Override
    @Transactional
    public int insertSelective(Students record) {
        return studentsMapper.insertSelective(record);
    }

    @Override
    @Transactional
    public Students selectByPrimaryKey(Integer xh) {
        return studentsMapper.selectByPrimaryKey(xh);
    }

    @Override
    @Transactional
    public List<Students> selectStudents(StudentsParams params){
        if(params == null || params.getPageNum() == null){
            params = new StudentsParams(1,6);
        }
        PageHelper.startPage(params.getPageNum(),params.getPageSize(),params.getOrderBy());
        return studentsMapper.selectStudents(params);
    }

    @Override
    @Transactional
    public int updateByPrimaryKeySelective(Students record) {
        return studentsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional
    public int updateByPrimaryKey(Students record) {
        return studentsMapper.updateByPrimaryKey(record);
    }
}
