package com.drawthink.services;

import com.drawthink.entity.Student;

import java.util.List;

/**
 * @author drawthink
 * @date 2017/7/11 0011
 * @Description: TODO(用一句话描述该文件做什么)
 */
public interface StudentService {

    String queryStudentNameById(String id);

    List<Student> queryAllStudent();
}
