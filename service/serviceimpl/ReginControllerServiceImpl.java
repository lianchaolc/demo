package com.pp.learn.demo.service.serviceimpl;

import com.pp.learn.demo.domain.bo.CommonBO;
import com.pp.learn.demo.entity.User;
import com.pp.learn.demo.entity.UserInfoRegin;
import com.pp.learn.demo.service.ReginControllerService;
import com.pp.learn.demo.user.ReginControllerDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/****
 * 注册接口实现
 * 2019——3——27
 * lc
 */
public class ReginControllerServiceImpl implements ReginControllerService {


@Autowired
private ReginControllerDao  mReginControllerDao;

    @Override
    public CommonBO addUserInfoById(List<Map<String, Object>> param) {
        List<UserInfoRegin> inspectDetailDOList = new ArrayList<UserInfoRegin>();
        User mUser;

        for (Map<String, Object> map : param){
            UserInfoRegin  mUserInfoRegin = new UserInfoRegin();
            mUserInfoRegin.setUserinfoReginId(map.get("UserinfoReginId").toString());// 存放用户的id
            mUserInfoRegin.setUserinfoReginIPhone(map.get("UserinfoReginIPhone").toString());// 存放用户的id
            mUserInfoRegin.setUserInfoReginPassWord("UserInfoReginPassWord");// 存放用户的密码
            inspectDetailDOList.add(mUserInfoRegin);
        }
        CommonBO  mCommonBO=new CommonBO();
        mReginControllerDao.addUserInfoById(inspectDetailDOList);// 添加数据


//            //更新表单状态和时间
//            updateInspectnoState(inspectno,2, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        return mCommonBO;
    }
}