package com.example.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.base.utils.ConvertUtil;
import com.example.product.cmd.ListProductByCdCmd;
import com.example.product.cmd.ListProductStyleByCdCmd;
import com.example.product.dao.ProductDao;
import com.example.product.dao.ProductStyleDao;
import com.example.product.dto.ProductDTO;
import com.example.product.dto.ProductStyleDTO;
import com.example.product.po.Product;
import com.example.product.po.ProductStyle;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;
	@Autowired
	ProductStyleDao productStyleDao;
	@Override
	public List<ProductDTO> listProductByCd(ListProductByCdCmd cmd) {
		List<Product> products = productDao.listByCd(cmd);

		List<ProductDTO> list = new ArrayList<ProductDTO>();
		if(products != null && !products.isEmpty()) {
			for(Product product : products) {
				list.add(ConvertUtil.convert(product, ProductDTO.class));
			}
		}
		return list;
	}
	@Override
	public ProductDTO findProductByCd(ListProductByCdCmd cmd) {
		Product product = productDao.findByCd(cmd);
		if(product == null) {
			return null;
		}
		return ConvertUtil.convert(product, ProductDTO.class);
	}
	@Override
	public Long findProductCountByCd(ListProductByCdCmd cmd) {
		return productDao.findCountByCd(cmd);
	}
	@Override
	public List<ProductStyleDTO> listProductStyleByCd(ListProductStyleByCdCmd cmd) {
		List<ProductStyle> productStyles = productStyleDao.listByCd(cmd);
		
		List<ProductStyleDTO> list = new ArrayList<ProductStyleDTO>();
		if(productStyles != null && !productStyles.isEmpty()) {
			for(ProductStyle r : productStyles) {
				list.add(ConvertUtil.convert(r, ProductStyleDTO.class));
			}
		}
		return list;
	}
	@Override
	public ProductStyleDTO findProductStyleByCd(ListProductStyleByCdCmd cmd) {
		ProductStyle productStyle = productStyleDao.findByCd(cmd);
		if(productStyle == null) {
			return null;
		}
		return ConvertUtil.convert(productStyle, ProductStyleDTO.class);
	}
	@Override
	public Long findProductStyleCountByCd(ListProductStyleByCdCmd cmd) {
		return productStyleDao.findCountByCd(cmd);
	}
	
	
}
