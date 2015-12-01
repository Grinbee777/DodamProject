package com.dodam.dao;

import java.util.List;

import com.dodam.service.domain.Nap;

public interface NapDao {
	int insertNap(Nap nap);
	Nap getNap(int nNo);
	List<Nap> getNapList(int dsNo);
	//Nap버튼클릭시 insert인지 update인지판별하기위한 코드값 확인을 위함
	String getNState(int dsNo);
	int updateNap(Nap nap);
	//fNo전달시 1개만 삭제 dsNo전달시 일괄삭제가능
	int deleteNap(int No);
}
