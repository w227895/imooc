package com.imooc.controller;

import com.imooc.pojo.bo.UserBo;
import com.imooc.service.UserService;
import com.imooc.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: kb
 * @create: 2020-09-09 19:12
 **/
@Api(value = "注册登录",tags = {"用于注册登录的相关接口"})
@RestController
@RequestMapping("passport")
public class PassportController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户名是否存在",notes = "用户名是否存在",httpMethod = "GET")
    @GetMapping("/usernameIsExist")
    public IMOOCJSONResult usernameIsExist(@RequestParam String username) {
        if (org.apache.commons.lang3.StringUtils.isBlank(username)) {
            return IMOOCJSONResult.errorMsg("用户名不能为空");
        }
        boolean isExist = userService.queryUsernameIsExist(username);
        if (isExist) {
            return IMOOCJSONResult.errorMsg("用户名已经存在");
        }
        return IMOOCJSONResult.ok();
    }

    @PostMapping("/regist")
    @ApiOperation(value = "用户注册",notes = "用户注册",httpMethod = "POST")
    public IMOOCJSONResult register(@RequestBody UserBo userBo) {
        String username=userBo.getUsername();
        String password=userBo.getPassword();
        String confirmPassword=userBo.getConfirmPassword();
        if (org.apache.commons.lang3.StringUtils.isBlank(username)||
                org.apache.commons.lang3.StringUtils.isBlank(password)||
                org.apache.commons.lang3.StringUtils.isBlank(confirmPassword)) {
            return IMOOCJSONResult.errorMsg("用户名或者密码不能为空");
        }
        boolean isExist = userService.queryUsernameIsExist(username);
        if (isExist) {
            return IMOOCJSONResult.errorMsg("用户名已经存在");
        }
        if(password.length()<6){
            return IMOOCJSONResult.errorMsg("密码长度不能少于6");
        }
        if(!password.equals(confirmPassword)){
            return IMOOCJSONResult.errorMsg("两次密码不一致");
        }
        userService.createUser(userBo);
        return IMOOCJSONResult.ok();
    }
}

