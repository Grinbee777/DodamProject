package com.dodam.dao;

import java.util.List;

import com.dodam.service.domain.Poo;

public interface PooDao {
	int insertPoo(Poo poo);
	Poo getPoo(int pNo);
	List<Poo> getPooList(int dsNo);
	int updatePoo(Poo poo);
	//fNo전달시 1개만 삭제 dsNo전달시 일괄삭제가능
	int deletePoo(int no);
}
