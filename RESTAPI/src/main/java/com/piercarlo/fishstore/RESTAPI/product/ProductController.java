package com.piercarlo.fishstore.RESTAPI.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
    ProductService productService; //Service which will do all data retrieval/manipulation work
	
	
    @RequestMapping(value =  "/products" , method = RequestMethod.GET)
    public ResponseEntity<?> listProducts() {
    	List<Product> products = productService.listAllProducts();
    	if (!products.isEmpty() && products != null) {
            return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
        }
    	return new ResponseEntity<>("No products found",HttpStatus.NOT_FOUND);
        
    }
    
    
	
	 @RequestMapping(value = "/products" , method = RequestMethod.POST) 
	 public	 ResponseEntity<?> newProduct(@RequestBody Product product){ 
		 if(productService.findById(product.getId()).equals(null)) { 
			 return new ResponseEntity<>("Unable to create. A product with id " +product.getId
					 ()+" already exist.\")", HttpStatus.CONFLICT); 
		 }
		 productService.save(product); 
		 return new ResponseEntity<>("Product created",HttpStatus.CREATED);
	 }
	 
	 
	 @RequestMapping(value = "/products/{id}" , method = RequestMethod.GET) 
	 public ResponseEntity<?> listProduct(@PathVariable("id") Long id) { 
		 //Product product = productService.findById(id);
		 Optional<Product> product = productService.findById(id);
		 if(id != null && product.isPresent()) {
			 return new ResponseEntity<>(product,HttpStatus.OK); 
		 } 
		 return new ResponseEntity<>("No product with id "+id+" was found",HttpStatus.NOT_FOUND);
	 }

	 
	 @RequestMapping(value = "/products/{id}" , method = RequestMethod.PUT) 
	 public ResponseEntity<?> updateProduct(@PathVariable("id") Long id,@RequestBody Product product) throws Exception { 
		 try {
			 Product productInDb = productService.findById(id).get();
		 	if (id != null && !productInDb.equals(null)) {
				 productInDb.setName(product.getName());
				 productInDb.setQuantity(product.getQuantity());
				 productService.save(productInDb); 
				 return new ResponseEntity<>("Product with id " +id+" changed.", HttpStatus.OK);
			 }
		 }catch(Exception e){
			 return new ResponseEntity<>("No product with id "+id+" was found",HttpStatus.NOT_FOUND);
		 }
		 return new ResponseEntity<>("No product with id "+id+" was found",HttpStatus.NOT_FOUND);
}
	  
	 @RequestMapping(value = "/products/{id}" , method = RequestMethod.DELETE)
	 public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
		 try {
			 Product productInDb = productService.findById(id).get();
		 	if (id != null && !productInDb.equals(null)) {
				 productService.delete(productInDb); 
				 return new ResponseEntity<>("Product with id " +id+" deleted.", HttpStatus.OK);
			 }
		 }catch(Exception e){
			 return new ResponseEntity<>("No product with id "+id+" was found",HttpStatus.NOT_FOUND);
		 }
		 return new ResponseEntity<>("No product with id "+id+" was found",HttpStatus.NOT_FOUND);
}

    
    
    
}
