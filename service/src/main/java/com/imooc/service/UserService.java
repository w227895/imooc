package com.imooc.service;

import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBo;

/**
 * @description:
 * @author: kb
 * @create: 2020-09-09 19:04
 **/
public interface UserService {

    public boolean queryUsernameIsExist(String username);

    public Users createUser(UserBo userBo);
}

