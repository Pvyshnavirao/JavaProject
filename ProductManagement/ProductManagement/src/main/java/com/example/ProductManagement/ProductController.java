package com.example.ProductManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;







@RestController
@RequestMapping("/product")
public class ProductController {
	
@Autowired
private ProductService productservice;

//PostMapping("/saveProduct")

//public ResponseEntity<Product>  saveProduct( @Validated @RequestBody Product product){
	
//return new ResponseEntity<>(productservice.saveProduct(product),HttpStatus.CREATED);
//}
//post mapping not working for nulls
 @PostMapping("/saveProduct")
public ResponseEntity<Product> saveProduct(@Validated @RequestBody Product product) {
    if (product.getName() == null || product.getPrice() == null || product.getDescription() == null) {
        throw new InvalidDataException("Product data cannot be null");
    }
    return new ResponseEntity<>(productservice.saveProduct(product), HttpStatus.CREATED);
}

@PutMapping("/{id}")
public Product chnageMethod(@PathVariable Integer id, @RequestBody Product product) {
    if (product.getName() == null || product.getPrice() == null || product.getDescription() == null) {
        throw new InvalidDataException("Product data cannot be null");
    }
    return productservice.ChangeMethod(id, product);
    
}

//@PutMapping("/{id}")
//public  Product ChnageMethd(@PathVariable Integer  id , @RequestBody Product product) {
	//return productservice.ChangeMethod(id , product);
	//
//}
@GetMapping("/")
public ResponseEntity<List<Product>> getAllProducts(){
    List<Product> list = productservice.getAllProduct();

    if (list.isEmpty()) {
        throw new ProductNotFoundException("No products found");
    } else {
        return ResponseEntity.ok(list);
    }
}


//not working for nulls
@GetMapping("/{id}")
public ResponseEntity<Product> getProductById( @Validated @PathVariable Integer id) {
    Product product = productservice.getById(id);
    if (product == null) {
        throw new ProductNotFoundException("Product Not Found with ");
    } else {
        return ResponseEntity.ok(product);
    }
}


//not working for nulls
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer id){
		
		String message = productservice.deleteproduct(id);
		if (message == null) {
			 throw new ProductNotFoundException("Product with "+id+"not found");
		}
		else {
			return ResponseEntity.ok(message);
		
		}
	//return new ResponseEntity<String>(productservice.deleteproduct(id), HttpStatus.OK);
	
}
	
}




