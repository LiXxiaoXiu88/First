package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pojo.Hiber;
import dao.HiberMapper;

@Service
public class HiberServiceImpl implements HiberService {

	@Autowired
	private HiberMapper hm;

	public HiberMapper getHm() {
		return hm;
	}

	public void setHm(HiberMapper hm) {
		this.hm = hm;
	}

	public List<Hiber> getAll(int begin, int sezi) {

		return hm.getAll(begin, sezi);
	}

	public int conut() {

		return hm.conut();
	}
	

	public int update(Hiber h) {

		return hm.update(h);
	}

	@Override
	public Hiber findById(int id) {
		
		return hm.findById(id);
	}

}
