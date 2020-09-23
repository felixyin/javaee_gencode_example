/**
 * Copyright &copy; 2015-2020 <a href="http://www.qdqtrj.com/">前途软件</a> All rights reserved.
 */
package com.qtrj.modules.test.manytomany.mapper;

import com.qtrj.core.persistence.BaseMapper;
import com.qtrj.core.persistence.annotation.MyBatisMapper;
import com.qtrj.modules.test.manytomany.entity.StudentCourse;

/**
 * 学生课程记录MAPPER接口
 * @author lgf
 * @version 2018-06-12
 */
@MyBatisMapper
public interface StudentCourseMapper extends BaseMapper<StudentCourse> {
	
}