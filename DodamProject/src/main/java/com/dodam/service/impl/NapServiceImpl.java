package com.dodam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dodam.dao.NapDao;
import com.dodam.service.NapService;
import com.dodam.service.domain.Nap;

@Service("napServiceImpl")
public class NapServiceImpl implements NapService {
	
	@Autowired
	private NapDao napDao;
	public void setNapDao(NapDao napDao){
		this.napDao = napDao;
	}
	
	public NapServiceImpl() {
		System.out.println(":::::"+getClass().getName()+" 생성!");
	}

	@Override
	public int insertNap(Nap nap) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Nap getNap(int nNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Nap> getNapList(int dsNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateNap(Nap nap) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteNap(int No) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getNState(int dsNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
