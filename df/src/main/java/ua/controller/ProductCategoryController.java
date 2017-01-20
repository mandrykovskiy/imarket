package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.servise.ProductCategoryService;


@Controller
public class ProductCategoryController {
	
	@Autowired
	private ProductCategoryService productCategoryService;
	
	@RequestMapping("/admin/productCategory")
	public String showProduct(Model model){
		model.addAttribute("productCategories", productCategoryService.findAll());
		return "productCategory";
	}
	@RequestMapping("/admin/productCategory/delete/{id}")
	public String delete(@PathVariable int id){
		productCategoryService.delete(id);
		return "redirect:/admin/productCategory";
	}
	
//	@RequestMapping(value= "/admin/productCategory", method=RequestMethod.POST)
//	public String save(@RequestParam String name){
//		productCategoryService.save(name);
//		return "redirect:/admin/productCategory";
//	}
}
