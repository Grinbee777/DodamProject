package com.dodam.service;

import java.util.List;

import com.dodam.service.domain.Poo;

public interface PooService {
	
	int insertPoo(Poo poo) throws Exception;
	
	Poo getPoo(int pNo) throws Exception;
	
	List<Poo> getPooList(int dsNo) throws Exception;
	
	int updatePoo(Poo poo) throws Exception;
	
	int deletePoo(int no) throws Exception;
}
