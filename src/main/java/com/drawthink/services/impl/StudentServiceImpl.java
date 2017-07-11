package com.drawthink.services.impl;

import com.drawthink.dao.StudentMapper;
import com.drawthink.entity.Student;
import com.drawthink.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author drawthink
 * @date 2017/7/11 0011
 * @Description: TODO(用一句话描述该文件做什么)
 */

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper stuDao;

    @Override
    public String queryStudentNameById(String id) {
        Student stu  = stuDao.selectByPrimaryKey(id);
        if(null != stu){
            return stu.getStuName();
        }
        return "没找到对应学生姓名!";
    }

    @Override
    public List<Student> queryAllStudent() {
        return stuDao.queryAllStudent();
    }
}
