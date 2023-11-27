package com.example.MuruganStores.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MuruganStores.Model.Chair;

public interface ChairRepository extends JpaRepository<Chair,Integer> {
	
	List<Chair> findByChairname(String chairname);
	
	List<Chair> findByChairnameAndStorename(String chairname,String storename);
	
	

}
