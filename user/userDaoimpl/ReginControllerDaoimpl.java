package com.pp.learn.demo.user.userDaoimpl;

import com.pp.learn.demo.entity.User;
import com.pp.learn.demo.entity.UserInfoRegin;
import com.pp.learn.demo.user.ReginControllerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/***
 * 新增注册数据
 *
 *
 *     private   String   UserinfoReginId;//  用户的id
 private   String   UserinfoReginIPhone;//  用户的账号
 private   String   UserInfoReginPassWord;//  用户的密码
 */
public class ReginControllerDaoimpl implements ReginControllerDao {
    @Autowired
    ///链接数据库注解
    @Qualifier("sqliteJdbcTemplate")
    JdbcTemplate jdbcTemplate;

    private static final String AddINFO = "INSERT INTO user_info(UserinfoReginId,UserinfoReginIPhone,UserInfoReginPassWord) VALUES(?,?,?,?)";

    /***| 注册页面新增一条注册数据
     *
     * @param inspectDetailDOList
     */
    @Override
    public void addUserInfoById(List<UserInfoRegin> inspectDetailDOList) {
        jdbcTemplate.batchUpdate(AddINFO, new BatchPreparedStatementSetter() {//新增的表
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                UserInfoRegin mUserInfoRegin = inspectDetailDOList.get(i);
//                ps.setInt(1, mUser.getUserid());
                ps.setString(2, mUserInfoRegin.getUserinfoReginId());
                ps.setString(3, mUserInfoRegin.getUserinfoReginIPhone());
                ps.setString(4, mUserInfoRegin.getUserInfoReginPassWord());

            }

            @Override
            public int getBatchSize() {
                return 0;
            }
        });
    }
}
