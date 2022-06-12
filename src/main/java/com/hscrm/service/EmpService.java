package com.hscrm.service;

import com.hscrm.domain.Emp;

/**
 * ClassName：
 * Description：
 *
 * @author：坏人曹怼怼
 * @date：2022/2/21 14:59
 */
public interface EmpService {
    /**
     * 添加员工(注册)
     */
    int addEmp(Emp emp);

    /**
     * 通过用户名查找员工（登录）
     */
    int login(Emp emp);

    /**
     * 通过用户名查找员工
     * @return
     */
    Emp fidEmpBYEid(Emp emp);

    int updatePasswd(Emp emp,String newpasswd);
}
