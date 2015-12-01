package com.dodam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dodam.dao.PooDao;
import com.dodam.service.PooService;
import com.dodam.service.domain.Poo;

@Service("pooServiceImpl")
public class PooServiceImpl implements PooService {
	
	@Autowired
	private PooDao pooDao;
	public void setPooDao(PooDao pooDao){
		this.pooDao = pooDao;
	}
	
	public PooServiceImpl() {
		System.out.println(":::::"+getClass().getName()+" 생성!");
	}

	@Override
	public int insertPoo(Poo poo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Poo getPoo(int pNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Poo> getPooList(int dsNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updatePoo(Poo poo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePoo(int no) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
