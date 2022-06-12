package com.hscrm.service.impl;

import com.hscrm.domain.Emp;
import com.hscrm.mapper.EmpMapper;
import com.hscrm.service.EmpService;
import com.hscrm.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName：
 * Description：
 *
 * @author：坏人曹怼怼
 * @date：2022/2/21 15:00
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    /**
     * 注册
     * @param emp
     * @return
     */
    @Override
    public int addEmp(Emp emp) {
        try {
            Emp empByUsername = empMapper.findEmpByUsername(emp.getUsername());
            if (empByUsername == null){
                int i = empMapper.addEmp(emp);
                return i;
            }else {
                //用户已被注册
                return -1;
            }
        }catch (Exception e){
            //注册失败
            return -2;
        }
    }

    /**
     * 登录
     * @param emp
     * @return
     */
    @Override
    public int login(Emp emp) {
        try {
            Emp emp1 = empMapper.findEmpByUsername(emp.getUsername());
            if (emp1.getPasswd().equals(emp.getPasswd())){
                //密码正确
                return emp1.getEid();
            }
            //用户输入密码错误
            return -1;
        }catch (Exception e){
            //用户未注册  用户名输入错误
            return -2;
        }
    }

    /**
     * 通过EID查找用户名
     * @param emp
     * @return
     */
    @Override
    public Emp fidEmpBYEid(Emp emp) {
        Emp empByEid = empMapper.findEmpByEid(emp.getEid());
        empByEid.setPasswd("");
        return empByEid;
    }

    /**
     * 修改密码
     */
    @Override
    public int updatePasswd(Emp emp, String newpasswd) {
        Emp empByEid = empMapper.findEmpByEid(emp.getEid());
        //验证旧密码是否正确
        if (empByEid.getPasswd().equals(emp.getPasswd())){
            emp.setPasswd(MD5Util.toMd5(newpasswd));
            int i = empMapper.updatePasswd(emp);
            return i;
        }
        return -1;
    }
}
