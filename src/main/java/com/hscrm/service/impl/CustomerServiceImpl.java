package com.hscrm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hscrm.domain.Customer;
import com.hscrm.mapper.CustomerMapper;
import com.hscrm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName：
 * Description：
 *
 * @author：坏人曹怼怼
 * @date：2022/2/22 10:28
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 添加用户
     * @param customer
     * @return
     */
    @Override
    public int addCustomer(Customer customer) {
        int i = customerMapper.addCustomer(customer);
        return i;
    }

    /**
     * 删除用户
     * @param cid
     * @return
     */
    @Override
    public int deleteCustomer(int cid) {
        int i = customerMapper.deleteCustomer(cid);
        return i;
    }

    /**
     * 修改用户
     * @param customer
     * @return
     */
    @Override
    public int updateCustomer(Customer customer) {
        int i = customerMapper.updateCustomer(customer);
        return i;
    }

    /**
     * 查找所有用户
     * @return
     */
    @Override
    public PageInfo<Customer> findAllCustomer(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Customer> allCustomer = customerMapper.findAllCustomer();
        PageInfo<Customer> PageInfo = new PageInfo<>(allCustomer);
        return PageInfo;
    }

    /**
     * 通过Cid查找单个用户
     * @param cid
     * @return
     */
    @Override
    public Customer findOneCustomer(int cid) {
        Customer customer = customerMapper.findOneCustomer(cid);
        return customer;
    }

    @Override
    public List<Customer> findAllCustomer2() {
        List<Customer> allCustomer = customerMapper.findAllCustomer();
        return allCustomer;
    }
}
