package com.example.MuruganStores.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MuruganStores.Model.Chair;
import com.example.MuruganStores.Repository.ChairRepository;

@Service
public class ChairServiceImpl implements ChairService {
	
	@Autowired
	private ChairRepository respo;

	@Override
	public List<Chair> showAllDetails() {
		
		return respo.findAll();
	}

	@Override
	public Chair addNewChairs(Chair chair) {
		
		return respo.save(chair);
	}

	@Override
	public Optional<Chair> searchChairs(Integer chairno) {
		
		return respo.findById(chairno);
	}

	@Override
	public void deletePage(Integer chairno) {
		
		respo.deleteById(chairno);
		
	}

	@Override
	public List<Chair> searchChairs(String chairs) {
	
		return respo.findByChairname(chairs);
	}

	@Override
	public List<Chair> searchChairsAndStore(String ch, String sto) {
		
		return respo.findByChairnameAndStorename(ch, sto);
	}
	
	

}
