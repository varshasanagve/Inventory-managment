package com.lti.SmartShopApp.service;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lti.SmartShopApp.exception.ResourceNotFoundException;
import com.lti.SmartShopApp.model.Product;
import com.lti.SmartShopApp.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;

	public Product addProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}

	public Product getProduct(long productid) {
		return productRepository.getById(productid);
	}

	public Product updateProduct(Product product) throws ResourceNotFoundException {
		Product prod = productRepository.findById(product.getId()).orElseThrow(
				() -> new ResourceNotFoundException("product not found for this id :: " + product.getId()));
		if (product.getName() != null)
			prod.setName(product.getName());
		if (product.getCategory() != null)
			prod.setCategory(product.getCategory());
		if (product.getQantity() != 0)
			prod.setQantity(product.getQantity());
		if (product.getRating() != 0)
			prod.setRating(product.getRating());
		if (product.getUnitprice() != 0)
			prod.setUnitprice(product.getUnitprice());
		return productRepository.save(prod);
	}

	public List<Product> getstock() {
		return productRepository.findAll();
	}

	public List<Product> getstockByProductName(String pname) {
		return productRepository.findAll().stream().filter(p -> p.getName().equals(pname)).toList();
	}

	public List<Product> getstockByCategoryName(String category) {
		return productRepository.findAll().stream().filter(p -> p.getCategory().equals(category)).toList();
	}

	public String deleteLessRated() {
		List<Product> allProducts = productRepository.findAll();
		int counter = 0;
		for (Product p : allProducts) {
			if (p.getRating() < 2) {
				counter++;
				productRepository.deleteById(p.getId());
			}
		}
		String message = counter + " Products Deleted";
		return message;
	}

	public String calTotalPrice() {
		List<Product> allProducts = productRepository.findAll();
		for (Product p : allProducts) {
			p.setTotalprice(p.getQantity() * p.getUnitprice());
			productRepository.save(p);
		}
		String message = allProducts.size() + " Products Updated";
		return message;
	}

}
