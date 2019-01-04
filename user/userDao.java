package com.pp.learn.demo.user;

import com.pp.learn.demo.entity.User;

import java.util.List;
import java.util.Map;

/***
 * 3  获取的userdao接口  主要目的规范写法
 * 2018_12_16\
 *lc
 */

    public interface userDao {
    /***
     * 获取所有的用户信息
     * @return
     */
    public List<Map<String, Object>> getAlluser();

    /**
     * 通过id 获取特定人员信息
     */
    public  List<Map<String, Object>> getUserinfoByuserid(String userid);


    /***
     *  传送一个userid增加数原
     * @param inspectDetailDOList
     * @return
     */
    void addUserInfoById(List<User> inspectDetailDOList);


    /***
     * 通过一条数据进行删除数据
     */
    void delDataByInsNos(String insNos);

    /***
     * 更新数据状态
     *
     */
    void updateInspectnoState(String userid,String username,String userpassword,String userpw,String userphone,String userstate);
}
