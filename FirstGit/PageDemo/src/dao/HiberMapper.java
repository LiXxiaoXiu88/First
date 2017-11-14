package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.Hiber;

public interface HiberMapper {

	public List<Hiber> getAll(@Param("b") int begin, @Param("s") int sezi);

	/**
	 * 末页
	 */
	public int conut();

	// 根据ID查询对象信息

	public Hiber findById(int id);

	// 修改方法传对象
	public int update(Hiber h);

}
