package service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.Hiber;

public interface HiberService {

	// 1.begin 起始页 2.sezi每页显示条数
	public List<Hiber> getAll(@Param("b") int begin, @Param("s") int sezi);

	// 获取数据库的总条数
	public int conut();

	// 根据ID查询对象信息

	public Hiber findById(int id);

	// 修改方法传对象
	public int update(Hiber h);
}
