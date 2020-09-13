package com.imooc.service;

import com.imooc.pojo.Stu;

/**
 * @description:
 * @author: kb
 * @create: 2020-09-08 21:21
 **/
public interface StuService {
    public Stu getStuInfo(int id);

    public void saveStu();

    public void updateStu(int id);

    public void deleteStu(int id);
}

