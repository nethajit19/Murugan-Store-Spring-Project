package com.example.MuruganStores.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.MuruganStores.Model.Chair;
import com.example.MuruganStores.Service.ChairService;

@CrossOrigin("http://127.0.0.1:5500/")
		
@RestController
public class ChairRestController {
	
	@Autowired
	private ChairService serv;
	
	@GetMapping("/api/chairs")
	public List<Chair> showAllDetails()
	{
		return serv.showAllDetails();
	
	}
	
	@GetMapping("/api/chair/{id}")
	public Optional<Chair> searchChairs(@PathVariable("id") int chairno)
	{
		return serv.searchChairs(chairno);
	}
	
	@PostMapping("/api/chair")
	public Chair addChairs(@RequestBody Chair chairs)
	{
		Optional<Chair> opt=serv.searchChairs(chairs.getChairno());
		
		if(opt.isEmpty())
		{
			return serv.addNewChairs(chairs);
			
		}
		
		else
		{
			return new Chair();
		}
	}
	
	@PutMapping("/api/chair")
	public Chair updatePage(@RequestBody Chair chairss)
	{
		Optional<Chair> opt=serv.searchChairs(chairss.getChairno());
		
		if(opt.isPresent())
		{
			return serv.addNewChairs(chairss);
		}
		
		else
		{
			return new Chair();
		}
	}
	
	@DeleteMapping("api/chair/{id}")
	public Optional<Chair> deleteChairs(@PathVariable ("id") int chaieeno)
	{
		Optional<Chair> opt=serv.searchChairs(chaieeno);
		
		if(opt.isPresent())
		{
			serv.deletePage(chaieeno);
			return opt;
		}
		
		else
		{
			return Optional.ofNullable(new Chair());
		}
	}
	
	
	
	
	

}
