package com.pp.learn.demo.service;

import com.pp.learn.demo.domain.bo.CommonBO;

import java.util.List;
import java.util.Map;

/***
 * 人员的服务查询
 */
public  interface  UserService {
    /**
     * 查询所有数据库信息
     * @return
     */
     List<Map<String, Object>> getAlluser();

    /***
     * 查询一个人的额信息通过id
     * @return
     */
     List<Map<String, Object>> getUserinfobyid(String userid);


    /***
     * 增加一条数据
     */
    CommonBO addUserInfoById(List<Map<String, Object>> param);
}
