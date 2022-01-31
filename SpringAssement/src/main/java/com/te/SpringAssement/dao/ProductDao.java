package com.te.SpringAssement.dao;

import java.util.List;
import com.te.SpringAssement.bean.ProductDetails;

public interface ProductDao {
	public ProductDetails authenticate(int id, String password);

	public boolean addData(ProductDetails details);

	public boolean deleteData(int id);

	public ProductDetails getData(int id);
	
	public boolean updateData(ProductDetails details, int id);
	
	public List<ProductDetails> getAll();
	


}
