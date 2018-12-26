package com.pp.learn.demo.HellowController;

import com.pp.learn.demo.Result;
import com.pp.learn.demo.domain.ResultGenerator;
import com.pp.learn.demo.domain.bo.CommonBO;
import com.pp.learn.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class HellowController {

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String hello() {
        return "hello Spring boot";
    }
//@RestController 注解： 该注解是 @Controller 和 @ResponseBody 注解的合体版

    /***
     * 返回页面数据
     * @return
     */
    @RequestMapping("/getService")
    public String getServiceData() {

        return null;
    }

    /***
     * 返回json数据员后台服务
     * @return
     */
    @RequestMapping("/getUserinfo")
    @ResponseBody
    public List<String> getUserinfo() {
        ArrayList<String> sss = new ArrayList<>();
        sss.add("高峰");
        sss.add("张扬");
        return sss;

    }

    @GetMapping("/getAlluser")
    public Result getuserinfo() {
        return ResultGenerator.genSuccessResult(userService.getAlluser());
    }

    /***
     * 查询单条数据结果
     */
    @GetMapping("/getUserInfobyId")
    public Result getUserInfobyId(String userid) {
        return ResultGenerator.genSuccessResult(userService.getUserinfobyid("1"));
    }

    /***
     * 增加数据
     */
//    @PostMapping("/continueScanMsg")
//    public    Result  addUserInfoById(String   userid,String username, String   userpassword, String userpw,
//                                      String userphone,String userstate){
//
//        return ResultGenerator.genSuccessResult(userService.addUserInfoById(1,"2","2","3","4",5));;
//    }

//    @PostMapping("/addUserInfoById")
//    @PostMapping(value ="/addUserInfoById",consumes = "application/json")
//    @RequestMapping(value = "/addUserInfoById", method = RequestMethod.POST)

    @RequestMapping( value = "/addUserInfoById", method = RequestMethod.POST )

//    public String addUserInfoById( @RequestParam Map<String, Object> param ) {
    public Result addUserInfoById(@RequestBody List<Map<String, Object>> param) {

        CommonBO commonBO = userService.addUserInfoById(param);//  封装的实体类
        if (commonBO.getFlag()) {
            return ResultGenerator.genFailResult(commonBO.getMsg());
        }
        return ResultGenerator.genSuccessResult();

    }

}