package com.te.SpringAssement.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.SpringAssement.bean.ProductDetails;
import com.te.SpringAssement.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao dao;

	@Override
	public ProductDetails authenticate(int id, String password) {
		if (id <= 0) {
			return null;
		}

		return dao.authenticate(id, password);
	}

	@Override
	public boolean addData(ProductDetails details) {
		return dao.addData(details);
	}

	@Override
	public boolean deleteData(int id) {
		if (id <= 0) {
			return false;
		}
		return dao.deleteData(id);
	}

	@Override
	public ProductDetails getData(int id) {
		if (id <= 0) {
			return null;
		}
		return dao.getData(id);
	}

	@Override
	public Boolean updateData(ProductDetails details, int id) {
		return dao.updateData(details, id);
	}

	

	@Override
	public List<ProductDetails> getAll() {
		
		return dao.getAll();
	}

	

	
}
