package kr.co.jacksomung.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {
	
	@RequestMapping(value="/product/list.do", method=RequestMethod.GET)
	public String productList() {
		return "product/product";
	}
	
	@RequestMapping(value="/product/detail.do", method=RequestMethod.GET)
	public String productDetail() {
		return "product/detailPd";
	}
	
	@RequestMapping(value="/product/cart.do", method=RequestMethod.GET)
	public String productCart() {
		return "product/cart";
	}
}
