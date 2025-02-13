package org.ncu.ecommerce_app.controllers;

import java.util.List;

import org.ncu.ecommerce_app.entities.Product;
import org.ncu.ecommerce_app.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/ecommerce-app")
public class ProductController {
	@Autowired 
	private ProductService productService;
	
	@GetMapping(value = "/products")
	public List<Product> fetchProducts(){
		return productService.getSoretedProducts();
	}

	@PostMapping(value = "/save")
	public String saveproduct(@RequestBody Product product) {
		productService.insertProduct(null);
		return "Product saved sucessfully";

	}
	@DeleteMapping(value = "/delete/{id}")
	public String delteProduct(@PathVariable int id){
		productService.deleteProductByid(id);
		return "product deleted sucessfulley";
    }
}
