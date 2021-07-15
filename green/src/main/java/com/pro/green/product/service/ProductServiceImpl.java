package com.pro.green.product.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pro.green.product.dao.ProductDAO;
import com.pro.green.product_M.vo.ProductVO2;


@Service("productService")
@Transactional(propagation = Propagation.REQUIRED)
public class ProductServiceImpl  implements ProductService{
	@Autowired
	ProductDAO productDAO;
	
	@Override	
	public List<ProductVO2> listProduct(String p_group) throws Exception{
		List<ProductVO2> productsList =  productDAO.selectAllProductsList(p_group);
        return productsList;
	}
	
	@Override
	public ProductVO2 viewProduct(String productId) throws Exception {
		ProductVO2 productVO = productDAO.selectProduct(productId);
		return productVO;
	}
}