package com.example.product.service;

import java.util.List;

import com.example.product.cmd.ListProductByCdCmd;
import com.example.product.cmd.ListProductStyleByCdCmd;
import com.example.product.dto.ProductDTO;
import com.example.product.dto.ProductStyleDTO;

public interface ProductService {
	//product
	List<ProductDTO> listProductByCd(ListProductByCdCmd cmd);
	ProductDTO findProductByCd(ListProductByCdCmd cmd);
	Long findProductCountByCd(ListProductByCdCmd cmd);
	
	//productStyle
	List<ProductStyleDTO> listProductStyleByCd(ListProductStyleByCdCmd cmd);
	ProductStyleDTO findProductStyleByCd(ListProductStyleByCdCmd cmd);
	Long findProductStyleCountByCd(ListProductStyleByCdCmd cmd);

}
