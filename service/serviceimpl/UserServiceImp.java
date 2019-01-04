package com.pp.learn.demo.service.serviceimpl;

import com.pp.learn.demo.domain.bo.CommonBO;
import com.pp.learn.demo.entity.User;
import com.pp.learn.demo.service.UserService;
import com.pp.learn.demo.user.userDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/****
 * 服务的实现接口类
 */
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private userDao userDao;


    private static final Logger logger = LoggerFactory.getLogger(UserServiceImp.class);

    @Override
    public List<Map<String, Object>> getAlluser() {
        List<Map<String, Object>> list = userDao.getAlluser();
        logger.info("{},getAll读取完毕,共{}条",  list.size());
        return list;
    }


    @Override
    public List<Map<String, Object>> getUserinfobyid(String userid) {
        List<Map<String, Object>> list = userDao.getUserinfoByuserid(userid);
        return list;
    }

    /***
     * 新增的一条数据
     * @param param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
        public CommonBO addUserInfoById(List<Map<String, Object>> param) {
            List<User> inspectDetailDOList = new ArrayList<User>();
            User mUser;

            for (Map<String, Object> map : param){
                User  muser = new User();

//                muser.setUserid(Integer.valueOf(map.get("userid").toString()));
                muser.setUsername(map.get("username").toString());
                muser.setUserpassword(map.get("userpassword").toString());
                muser.setUserpw(map.get("userpw").toString());
                muser.setUserphone(map.get("userphone").toString());
                muser.setUserstate(Integer.valueOf(map.get("userstate").toString()));
                inspectDetailDOList.add(muser);//放到集合中
            }
//            String inspectno = inspectDetailDOList.get(0).getInspectno();

//            CommonBO commonBO = checkInspectno(inspectno);
//            if(commonBO.getFlag()){
//                return commonBO;
//            }

            CommonBO  mCommonBO=new CommonBO();
            userDao.addUserInfoById(inspectDetailDOList);// 添加数据


//            //更新表单状态和时间
//            updateInspectnoState(inspectno,2, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

            return mCommonBO;
//        }
    }

    @Override
    @Transactional(rollbackFor= Exception.class)
    public void delDataByInsNos(String insNos) {
        userDao.delDataByInsNos(insNos);
//        formDao.delDetailByInsNos(insNos);//删除明细
//        formDao.delDataByInsNos(insNos);//删除单条
        logger.info("***************************"+insNos);
    }
    @Override

    @Transactional(rollbackFor = Exception.class)
    public void updateInspectnoState(String userid, String username, String userpassword, String userpw, String userphone, String userstate) {

    }


    /**
     * 更新
     * @param param
     * @return
     */



}
