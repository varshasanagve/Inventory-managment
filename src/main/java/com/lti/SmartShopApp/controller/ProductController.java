package com.lti.SmartShopApp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController; 
import com.lti.SmartShopApp.exception.ResourceNotFoundException;
import com.lti.SmartShopApp.model.Product;
import com.lti.SmartShopApp.service.ProductService;

@RestController
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	ProductService productService;
	
	@PostMapping("/addproduct")
	public Product addProduct(@RequestBody Product product) {
		logger.info("In addProduct method of ProductController");
		return productService.addProduct(product);
	}
	@GetMapping("/getproductbyid/{id}")
	public Product getProductById(@PathVariable long id){
		logger.info("In getProduct method of ProductController");
		return productService.getProduct(id);
	}
	@PutMapping("/updateproduct")
	public Product updateProduct(@RequestBody Product product) throws ResourceNotFoundException {
		logger.info("In UpdateProduct method of ProductController");
		return productService.updateProduct(product);
	}
	@GetMapping("/getstock")
	public List<Product> getstock(){
		logger.info("In getStock method of ProductController");
		return productService.getstock();
	}
	@GetMapping("/getstockbyproductname/{pname}")
	public List<Product> getstockByProductName(@PathVariable String pname){
		logger.info("In getstockByProductName method of ProductController");
		return productService.getstockByProductName(pname);
	}
	@GetMapping("/getstockbycategoryname/{category}")
	public List<Product> getstockByCategoryName(@PathVariable String category){
		logger.info("In getstockByCategoryName method of ProductController");
		return productService.getstockByCategoryName(category);
	}
	@DeleteMapping("/deletelessrated")
	public String deleteLessRated() {
		logger.info("In deleteLessRated method of ProductController, ");
		return productService.deleteLessRated();
	}
	@PutMapping("/caltotalprice")
	public String calTotalPrice() {
		logger.info("In calTotalPrice method of ProductController, ");
		return productService.calTotalPrice();
	}
	
	
	 
    
	

}
