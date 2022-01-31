package com.te.SpringAssement.Services;

import java.util.List;

import com.te.SpringAssement.bean.ProductDetails;



public interface ProductService {
	public ProductDetails authenticate(int id,String password);

	public boolean addData(ProductDetails details);

	public boolean deleteData(int id);
	
	public ProductDetails getData(int id);
	
	public Boolean updateData(ProductDetails details, int id);
	
//	public EmployeeDetails getall();

	public List<ProductDetails> getAll();

	


}
