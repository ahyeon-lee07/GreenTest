package com.pro.green.product.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pro.green.product.dao.ProductDAO;
import com.pro.green.product.vo.ProductVO;


@Service("productService")
@Transactional(propagation = Propagation.REQUIRED)
public class ProductServiceImpl  implements ProductService{
	@Autowired
	ProductDAO productDAO;
	
	public List<ProductVO> HardCase() throws Exception{
		List<ProductVO> productsList =  productDAO.selectAllProductsList();
        return productsList;
	}
}