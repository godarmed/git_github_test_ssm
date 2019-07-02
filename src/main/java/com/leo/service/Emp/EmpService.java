package com.leo.service.Emp;

import com.leo.entity.Emp;
import com.leo.util.Params;

import java.util.List;

public interface EmpService {
    List<Emp> selectEmpAll(Params params);
    Emp selectEmpById(Integer id);
    void saveEmp(Emp emp);
    void deleteEmp(Integer id);
    void updateEmp(Emp emp);
}
