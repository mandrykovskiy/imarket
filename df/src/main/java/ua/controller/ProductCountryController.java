package ua.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.entity.ProductCountry;
import ua.form.filter.CountryFilterForm;
import ua.servise.ProductCountrySevise;
import ua.servise.validator.ProductCountryValidator;

@Controller
public class ProductCountryController {
	@Autowired
	private ProductCountrySevise productCountrySevise;
	// countrycontroller + admincountry + impl
	
	@ModelAttribute("productCountry")
	public ProductCountry getCountry(){
		return new ProductCountry();
	}
	
	@ModelAttribute("filter")
	public CountryFilterForm getFilter(){
		return new CountryFilterForm();
	}
	
	@InitBinder("country")
	protected void initBinder(WebDataBinder binder){
	   binder.setValidator(new ProductCountryValidator(productCountrySevise));
	}
	
	@RequestMapping("/admin/country")
	public String show(Model model,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") CountryFilterForm form){
		model.addAttribute("page", productCountrySevise.findAll(pageable, form));
		return "adminCountry";
	}
	
	@RequestMapping("/admin/productCountry")
	public String showProduct(Model model){
		model.addAttribute("productCountries", productCountrySevise.findAll());
		return "productCountry";
	}
	@RequestMapping("/admin/productCountry/delete/{id}")
	public String delete(@PathVariable int id){
		productCountrySevise.delete(id);
		return "redirect:/admin/productCountry";
	}
	
	@RequestMapping("/admin/productCountry/update/{id}")
	public String updateCountry(@PathVariable int id, Model model){
		model.addAttribute("productCountry", productCountrySevise.findOne(id));
		return "productCountry";
	}
	
//	@RequestMapping(value= "/admin/productCountry", method=RequestMethod.POST)
//	public String save(@RequestParam String name){
//		productCountrySevise.save(name);
//		return "redirect:/admin/productCountry";
//	}
	
	@RequestMapping(value= "/admin/productCountry", method=RequestMethod.POST)
	public String showProductCountry(@ModelAttribute("productCountry") @Valid ProductCountry productCountry, BindingResult br, Model model){
		if(br.hasErrors()){
			model.addAttribute("productCountries", productCountrySevise.findAll());
			return "adminCountry";
		}
		productCountrySevise.save(productCountry);
		return "redirect:/admin/productCountry";
	}
}
