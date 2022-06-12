package com.hscrm.mapper;

import com.hscrm.domain.Emp;

/**
 * ClassName：
 * Description：
 *
 * @author：坏人曹怼怼
 * @date：2022/2/21 14:45
 */
public interface EmpMapper {
    /**
     * 添加员工
     */
    int addEmp(Emp emp);

    /**
     * 通过用户名查找员工
     */
    Emp findEmpByUsername(String username);


    /**
     * 通过EID找到员工
     */
    Emp findEmpByEid(int eid);

    /**
     * 修改密码
     */
    int updatePasswd(Emp emp);
}
