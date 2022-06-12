package com.hscrm.controller;

import com.hscrm.domain.Emp;
import com.hscrm.service.EmpService;
import com.hscrm.util.MD5Util;
import com.hscrm.util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName：
 * Description：
 *
 * @author：坏人曹怼怼
 * @date：2022/2/21 15:13
 */
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    /**
     * 登录
     * @param emp
     * @return
     */
    @RequestMapping("/crm/reg")
    public ResponseEntity<Integer> reg(Emp emp){
        //密码加密
        emp.setPasswd(MD5Util.toMd5(emp.getPasswd()));

        int i = empService.addEmp(emp);
        ResponseEntity<Integer> responseEntity = new ResponseEntity<>();
        responseEntity.setCode(200);
        responseEntity.setMessage("OK");
        responseEntity.setData(i);
        return responseEntity;
    }

    /**
     * 登录
     * @param emp
     * @return
     */
    @RequestMapping("/crm/login")
    public ResponseEntity<Integer> login(Emp emp){
        //密码加密
        emp.setPasswd(MD5Util.toMd5(emp.getPasswd()));

        int i = empService.login(emp);
        ResponseEntity<Integer> responseEntity = new ResponseEntity<>();
        responseEntity.setCode(200);
        responseEntity.setMessage("OK");
        responseEntity.setData(i);
        return responseEntity;
    }

    /**
     * 通过用户ID找到员工
     * @param emp
     * @return
     */
    @RequestMapping("/crm/findEmpByEid")
    public ResponseEntity<Emp> findEmpByEid(Emp emp){
        Emp emp1 = empService.fidEmpBYEid(emp);
        ResponseEntity<Emp> responseEntity = new ResponseEntity<>();
        responseEntity.setCode(200);
        responseEntity.setMessage("OK");
        responseEntity.setData(emp1);
        return responseEntity;
    }

    @RequestMapping("/crm/updatepasswd")
    public ResponseEntity<Integer> updatePasswd(Emp emp,String newpasswd){
        emp.setPasswd(MD5Util.toMd5(emp.getPasswd()));
        int i = empService.updatePasswd(emp, newpasswd);
        ResponseEntity<Integer> responseEntity = new ResponseEntity<>();
        responseEntity.setCode(200);
        responseEntity.setMessage("OK");
        responseEntity.setData(i);
        return responseEntity;
    }
}
