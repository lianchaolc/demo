package com.pp.learn.demo.user.userDaoimpl;

import com.pp.learn.demo.entity.User;
import com.pp.learn.demo.user.userDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/****
 * 用户的接口实现类
 * 2018_12_!6
 * lc
 */
@Component
public class userDaoimpl implements userDao {
    @Autowired
    ///链接数据库注解
    @Qualifier("sqliteJdbcTemplate")
    JdbcTemplate jdbcTemplate;

    private static final Logger logger = LoggerFactory.getLogger(userDaoimpl.class);

    ///  sql语句
 //查询所有
    private  static final   String    SELECT_ALLFORUSER="SELECT * FROM  user_info";
//    查询的那条
    private  static  final  String  SELECT_USERINFOFORUSRID ="SELECT  * FROM  user_info  WHERE userid=?";
    // 新增的某一条数据
    private  static  final  String   AddINFO="INSERT INTO user_info(userid,username,userpassword,userpw,userphone,userstate) VALUES(?,?,?,?,?,?)";
     // 删除某一条数据
    private  static  String  DELETEUSER =" delete FROM user_info  WHERE  inspectno in (\"+ insNos+\")\" ";

//  更新代码
    private static String  updataUserinfo="update user_info set username = ?, userpassword = ?,userpw=?,userphone=?,user=userstate=? where inspectno = ?";
    /***
     * 查询所有
     * @return
     */
    @Override
    public List<Map<String, Object>> getAlluser() {
        String sql = SELECT_ALLFORUSER;
        logger.error("======"+sql);
        return jdbcTemplate.queryForList(sql);
    }

    /***
     * 查询单条通过id
     * @param userid
     * @return
     */
    @Override
    public  List<Map<String, Object>> getUserinfoByuserid(String userid) {
        String sql = SELECT_USERINFOFORUSRID;
        return jdbcTemplate.queryForList(SELECT_USERINFOFORUSRID,userid);
    }

//
//    @Override
//    public List<Map<String, Object>> addUserinfoByUserid(String userid) {
//        String  sql=AddINFO;
//        return jdbcTemplate.queryForList(sql);
//    }





    /***
     *新增一条数据
     */

    @Override
    public void addUserInfoById(List<User> inspectDetailDOList) {
        jdbcTemplate.batchUpdate(AddINFO, new BatchPreparedStatementSetter() {//新增的表
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                User mUser = inspectDetailDOList.get(i);
//                ps.setInt(1, mUser.getUserid());
                ps.setString(2, mUser.getUsername());
                ps.setString(3, mUser.getUserpassword());
                ps.setString(4, mUser.getUserpw());
                ps.setString(5,  mUser.getUserphone());
                ps.setInt(6, mUser.getUserstate());
            }

            @Override
            public int getBatchSize() {
                return inspectDetailDOList.size();
            }
        });
    }
    /**
     * 删除一条数据
     * @param insNos
     */
    @Override
    @Transactional(rollbackFor= Exception.class)
    public void delDataByInsNos(String insNos) {
        DELETEUSER =" delete FROM user_info  WHERE  user_info.username in (\"+ insNos+\") ";
        jdbcTemplate.execute(DELETEUSER);
    }

    @Override
    public void updateInspectnoState(List<User> inspectDetailDOList) {
        User   mUser =new User();
        jdbcTemplate.update(updataUserinfo,mUser.getUsername(), mUser.getUserpassword(),
                mUser.getUserpassword(), mUser.getUserpw(),mUser.getUserphone(), mUser.getUserstate()
              );
    }


    /***
     * 更心某一条数据
     * @param username
     * @param userpassword
     * @param userpw
     * @param userphone
     * @param userstate
     */



}
