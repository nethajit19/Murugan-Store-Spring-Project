package com.example.MuruganStores.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.MuruganStores.Model.Chair;
import com.example.MuruganStores.Service.ChairService;

@Controller
public class ChairController {
	
	@Autowired
	private ChairService servu;
	
	@GetMapping("/")
	public String homePage()
	{
		return "index";
	}
	
	@GetMapping("/murugan/view")
	public String viewPage(Model model)
	{
		model.addAttribute("muruganchairs",servu.showAllDetails());
		return "/chair/view";
	}
	
	@GetMapping("/murugan/add")
	public String addPage(Model model)
	{
		model.addAttribute("chairobj", new Chair());
		return "/chair/add";
	}
	
	@PostMapping("/murugan/add")
	public String updatePage(@ModelAttribute("chairobj") Chair chairs)
	{
		Optional<Chair> opt=servu.searchChairs(chairs.getChairno());
		
		if(opt.isEmpty())
		{
			servu.addNewChairs(chairs);
			return "redirect:/murugan/view";
		}
		
		else
		{
			return "redirect:/murugan/add?failed";
		}
	}
	
	
	@GetMapping("/murugan/edit/{id}")
	public String editPage(@PathVariable("id") int ChairNo ,Model model )
	{
		model.addAttribute("chairobj", servu.searchChairs(ChairNo));
		return "/chair/edit";
	}
	
	@PostMapping("/murugan/edit")
	public String submitPage(@ModelAttribute("chairobj") Chair chairs)
	{
		servu.addNewChairs(chairs);
		return "redirect:/murugan/view";
			
	}
	
	@GetMapping("/murugan/delete/{id}")
	public String deleetPage(@PathVariable("id") int chairnoo)
	{
		servu.deletePage(chairnoo);
		return "redirect:/murugan/view";
	}
	
	
	@GetMapping("/murugan/view/chairname-wise")
	public String searchChairNames(@RequestParam("key") String chairrrsno,Model model)
	{
		model.addAttribute("muruganchairs", servu.searchChairs(chairrrsno));
		return "/chair/view";
	}
	
	@GetMapping("/murugan/view/chairname-storename-wise")
	public String searchChairnameAndStoreeName(@RequestParam("key") String pro,@RequestParam("hint") String ppro , Model model)
	{
		model.addAttribute("muruganchairs", servu.searchChairsAndStore(pro, ppro));
		return "/chair/view";
	}
	
	

	
	

}
