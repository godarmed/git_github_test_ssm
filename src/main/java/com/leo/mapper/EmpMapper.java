package com.leo.mapper;

import com.leo.entity.Emp;
import com.leo.util.Params;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
    List<Emp> selectEmpAll(Params params);
    Emp selectEmpById(Integer id);
    void saveEmp(Emp emp);
    void deleteEmp(Integer id);
    void updateEmp(Emp emp);
}
