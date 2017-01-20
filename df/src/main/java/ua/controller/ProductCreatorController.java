package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.servise.ProductCreatorService;

@Controller
public class ProductCreatorController {
	@Autowired
	private ProductCreatorService productCreatorService;
	
	@RequestMapping("/admin/productCreator")
	public String showProduct(Model model){
		model.addAttribute("productCreators", productCreatorService.findAll());
		return "productCreator";
	}
	@RequestMapping("/admin/productCreator/delete/{id}")
	public String delete(@PathVariable int id){
		productCreatorService.delete(id);
		return "redirect:/admin/productCreator";
	}
	
//	@RequestMapping(value= "/admin/productCreator", method=RequestMethod.POST)
//	public String save(@RequestParam String name){
//		productCreatorService.save(name);
//		return "redirect:/admin/productCreator";
//	}
}
