package com.dodam.service;

import java.util.List;

import com.dodam.service.domain.Nap;

public interface NapService {
	
	int insertNap(Nap nap) throws Exception;
	
	Nap getNap(int nNo) throws Exception;
	
	List<Nap> getNapList(int dsNo) throws Exception;

	int updateNap(Nap nap) throws Exception;

	int deleteNap(int No) throws Exception;
	
	String getNState(int dsNo) throws Exception;
}
