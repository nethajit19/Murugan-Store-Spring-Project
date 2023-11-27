package com.example.MuruganStores.Service;

import java.util.List;
import java.util.Optional;

import com.example.MuruganStores.Model.Chair;

public interface ChairService {
	
	List<Chair> showAllDetails();
	
	Chair addNewChairs(Chair chair);
	
	Optional<Chair> searchChairs(Integer chairno);
	
	void deletePage(Integer chairno);
	
	List<Chair> searchChairs(String chairs);
	
	List<Chair> searchChairsAndStore(String ch,String sto);

}
