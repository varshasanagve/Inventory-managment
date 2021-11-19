package com.lti.SmartShopApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lti.SmartShopApp.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	/*
	 * @Query("select * from product where name = ?1") public List<Product>
	 * getByProductName(String name);
	 * 
	 * @Query("select * from product where category = ?1") public List<Product>
	 * getByCategory(String cat);
	 */
	
	/*
	 * @Modifying
	 * 
	 * @Query("delete from product where rating <2") long deletelessrated();
	 * 
	 * @Modifying
	 * 
	 * @Query("update product set totalprice = unitprice * quantity") long
	 * calTotalPrice();
	 */
	
}
