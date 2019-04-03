package com.piercarlo.fishstore.RESTAPI.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
 
@Service("productService")
public class ProductService implements ProductRespository{
	

    //private static List<Product> products;
     
    //static{
    //    products = populateDummyProducts();
    //}
 
	@Autowired
    private ProductRespository productRepository;

	public List<Product> listAllProducts(){
		return (List<Product>) productRepository.findAll();
	}
	
	@Override
	public <S extends Product> S save(S entity) {
		return productRepository.save(entity);

	}

	@Override
	public <S extends Product> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Product> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Product> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Product entity) {
		productRepository.delete(entity);
		
	}

	@Override
	public void deleteAll(Iterable<? extends Product> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	
	
	/*
	 * public static List<Product> listAllProducts() { return products; }
	 * 
	 * public Product findById(int id) { for(Product product : products){
	 * if(product.getId()==(id)){ return product; } } return null; }
	 * 
	 * public boolean isProductExist(Product product) { return
	 * findById(product.getId())!=null; }
	 * 
	 * public void saveProduct(Product product) { products.add(product); }
	 * 
	 * public void updateProduct(int id,Product product) { int index =
	 * products.indexOf(findById(id)); products.set(index, product); }
	 * 
	 * public void deleteProduct(int id) { int index =
	 * products.indexOf(findById(id)); products.remove(index); }
	 * 
	 * private static List<Product> populateDummyProducts(){ List<Product> products
	 * = new ArrayList<Product>(); products.add(new Product(0,"Sam",30));
	 * products.add(new Product(1,"Tom",40)); products.add(new
	 * Product(2,"Jerome",45)); products.add(new Product(3,"Silvia",50)); return
	 * products; }
	 */	
}
