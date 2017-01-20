package ua.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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

import ua.entity.ProductCategory;
import ua.entity.ProductCountry;
import ua.entity.ProductCreator;
import ua.form.ProductForm;
import ua.form.filter.ProductFilterForm;
import ua.implementation.editor.CategoryEditor;
import ua.implementation.editor.CountryEditor;
import ua.implementation.editor.CreatorEditor;
import ua.servise.ProductCategoryService;
import ua.servise.ProductCountrySevise;
import ua.servise.ProductCreatorService;
import ua.servise.ProductService;
import ua.servise.validator.ProductFormValidator;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductCountrySevise productCountrySevise;
	
	@Autowired
	private ProductCategoryService productCategoryService;
	
	@Autowired
	private ProductCreatorService productCreatorService;
	
	
	@InitBinder("form")
	protected void initBinder(WebDataBinder binder){
	   binder.registerCustomEditor(ProductCountry.class, new CountryEditor(productCountrySevise));
	   binder.registerCustomEditor(ProductCategory.class, new CategoryEditor(productCategoryService));
	   binder.registerCustomEditor(ProductCreator.class, new CreatorEditor(productCreatorService));
	   binder.setValidator(new ProductFormValidator(productService));
	}
	
	@ModelAttribute("form")
	public ProductForm getForm(){
		return new ProductForm();
	}
	
	@ModelAttribute("filter")
	public ProductFilterForm getFilter(){
		return new ProductFilterForm();
	}
		
	@RequestMapping("/admin/product")
	public String showProduct(Model model,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") ProductFilterForm form){
		model.addAttribute("page", productService.findAll(form, pageable));
		model.addAttribute("productcountries", productCountrySevise.findAll());
		model.addAttribute("productCategories", productCategoryService.findAll());
		model.addAttribute("productCreators", productCreatorService.findAll());
		return "adminProduct";
	}
		
	@RequestMapping(value="/admin/product", method=RequestMethod.POST)
	public String save(@ModelAttribute("form") @Valid ProductForm form, 
			BindingResult br, Model model,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") ProductFilterForm filter){
		if(br.hasErrors()){
			model.addAttribute("page", productService.findAll(filter, pageable));
			model.addAttribute("productcountries", productCountrySevise.findAll());
			model.addAttribute("productCategories", productCategoryService.findAll());
			model.addAttribute("productCreators", productCreatorService.findAll());
			return "adminRecipe";
		}
		productService.save(form);
		return "redirect:/admin/product"+getParams(pageable, filter);
	}
	
	
	@RequestMapping(value="/admin/product/update/{id}")
	public String update(Model model, @PathVariable int id,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") ProductFilterForm form){
		model.addAttribute("form", productService.findForForm(id));
		model.addAttribute("page", productService.findAll(form, pageable));
		model.addAttribute("countries", productCountrySevise.findAll());
		model.addAttribute("categories", productCategoryService.findAll());
		model.addAttribute("creators", productCreatorService.findAll());
		return "adminProduct";
	}
	
	@RequestMapping(value="/admin/product/delete/{id}")
	public String delete(@PathVariable int id,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") ProductFilterForm form){
		productService.delete(id);
		return "redirect:/admin/product"+getParams(pageable, form);
	}
	
	private String getParams(Pageable pageable, ProductFilterForm form){
		StringBuilder buffer = new StringBuilder();
		buffer.append("?page=");
		buffer.append(String.valueOf(pageable.getPageNumber()+1));
		buffer.append("&size=");
		buffer.append(String.valueOf(pageable.getPageSize()));
		if(pageable.getSort()!=null){
			buffer.append("&sort=");
			Sort sort = pageable.getSort();
			sort.forEach((order)->{
				buffer.append(order.getProperty());
				if(order.getDirection()!=Direction.ASC)
				buffer.append(",desc");
			});
		}
		return buffer.toString();
	}
	
}
