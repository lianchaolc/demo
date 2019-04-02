package com.pp.learn.demo.HellowController;

import com.pp.learn.demo.Result;
import com.pp.learn.demo.domain.ResultGenerator;
import com.pp.learn.demo.domain.bo.CommonBO;
import com.pp.learn.demo.entity.UserInfoRegin;

import com.pp.learn.demo.service.ReginControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/****
 * 2019324
 * lc
 * 注册时的网络存储
 * 用于 ppshop的注册存储
 */
@RestController
@RequestMapping("UserInfoRegin")
public class ReginController {
//  自动写入注解
@Autowired
 private ReginControllerService mReginControllerService;


@RequestMapping( value = "/addUserInfoById", method = RequestMethod.POST )
public Result addUserInfoById(@RequestBody List<Map<String, Object>> param) {

    CommonBO commonBO = mReginControllerService.addUserInfoById(param);//  封装的实体类
    if (commonBO.getFlag()) {
        return ResultGenerator.genFailResult(commonBO.getMsg());
    }
    return ResultGenerator.genSuccessResult();

}
}
