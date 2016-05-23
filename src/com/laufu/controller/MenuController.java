package com.laufu.controller;

import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.laufu.service.MenuService;

@Controller
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value="showMenus",method=RequestMethod.GET)
	public String getAllSring(HttpServletRequest request,Model model){
		
		return "";
	}
	
	@RequestMapping(value="addMenus",method= RequestMethod.POST)
	public String addMenu(){
		
		return "";
	}
	
	public String updateMenu(){
		
		return "";
	}
	
	@RequestMapping(value="/myBlog/testAjax")
	public void testAjax(HttpServletRequest request,Model model){
		String msg = (String) request.getAttribute("test");
		System.out.println(msg);
		model.addAttribute("rep", "hhhhhhhhh");
	}
	
//	public Stringa
	
	@RequestMapping(value = "/myBlog/ajaxtest")
    public @ResponseBody
    String getTime() {
 
        Random rand = new Random();
        float r = rand.nextFloat() * 100;
        String result = "<br>Next Random # is <b>" + r + "</b>. Generated on <b>" + new Date().toString() + "</b>";
        System.out.println("Debug Message from CrunchifySpringAjaxJQuery Controller.." + new Date().toString());
        return result;
    }
}
