package com.laufu.controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.laufu.blogbeans.Blog;
import com.laufu.service.BlogService;
//import com.laufu.service.TestBlogService;
import com.laufu.util.tools.StringUtil;

@Controller
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	@RequestMapping(value="/myBlog/blogMainPage")
	public String blogMainPage(HttpServletRequest request,Model model){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", 0);
		map.put("max", 100);
		List<Blog> list = blogService.getListBlog(map);
		model.addAttribute("list", list);
		return  "/mainPage";
	}
	
	@RequestMapping(value="/myBlog/detail")
	public String getDetail(@RequestParam String id,PrintWriter printWriter,Model model){
		
//		Map<String, Object> map = new HashMap<String, Object>();
		Blog blog = blogService.selectBlogById(Integer.valueOf(id));
//		map.put("blog", blog);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("blog", blog);
//		model.addAttribute("blog", blog);
		System.out.println(jsonObject.toString());
		printWriter.print(jsonObject.toString());
		printWriter.flush();
		printWriter.close();
		
		model.addAttribute("blog", blog);
		
		return "blogDetail";
	}
	
	/**
	 * 添加文章
	 * @param blog
	 * @param model
	 */
	@RequestMapping(value="/myBlog/addBlog")
	public @ResponseBody String addBlog(@RequestParam Blog blog,Model model){
		blog.setCreateDate(new Date());
		blog.setContext(StringUtil.htmlspecialchars(blog.getContext()));
		if (blogService.insertBlog(blog) == 1) {
			return "成功";
		}
		model.addAttribute("msg", "添加成功");
		return "失败";
	}
	
	@RequestMapping(value="/view/saveBlog")
	public  ModelAndView saveBlog(@ModelAttribute("blog") Blog blog,ModelAndView  view){
		Map<String, Object> map = new HashMap<String, Object>();
		blog.setCreateDate(new Date());
		blog.setLastModify(new Date());
		blog.setContext(StringUtil.htmlspecialchars(blog.getContext()));
		blogService.insertBlog(blog) ;
		map.put("blog", blog);
		
//		RedirectView redirectView = new RedirectView("/view/manage/article/addArticle.jsp");
		view.setViewName("redirect:/view/manage/article/addArticle.jsp");
//		redirectView.set
		view.addObject("blog", blog);
//		view.setView(redirectView);
		
//		return new ModelAndView("redirect:/view/manage/article/addArticle.jsp",map);
//		return "redirect:/view/manage/article/addArticle.jsp";//
		return view;
	}
	
	@RequestMapping(value="/view/insertArticle", method = RequestMethod.POST)
	@ResponseBody
	public  Map<String, String> insertArticle(@RequestBody  Blog blog){//@ModelAttribute("blog") 
		System.out.println("come in");
		Map<String, String> map = new HashMap<String, String>(); 
		
		blog.setCreateDate(new Date());
		blog.setLastModify(new Date());
		blog.setContext(StringUtil.htmlspecialchars(blog.getContext()));
		
		if(blogService.insertBlog(blog)  == 0){
			 map.put("success", "false");
		}else{
			 map.put("success", "true");
		}
		return map;
	}
	
	@RequestMapping(value = "/view/addAjax")
	public @ResponseBody  Map<String, String> addAjax(){
	    Map<String, String> map = new HashMap<String, String>(1);  
	    map.put("success", "true");  
	    return map;  
	}
	
	/**
	 * 
	 * @param blog
	 * @return
	 */
	@RequestMapping(value="/view/updateArticle", method = RequestMethod.POST)
	@ResponseBody
	public  Map<String, String> updateArticle(@RequestBody  Blog blog){
		Map<String, String> map = new HashMap<String, String>(); 
		blog.setCreateDate(new Date());
		blog.setLastModify(new Date());
		blog.setContext(StringUtil.htmlspecialchars(blog.getContext()));
		
		if(blogService.insertBlog(blog)  == 0){
			 map.put("success", "false");
		}else{
			 map.put("success", "true");
		}
		return map;
	}
	
	/**
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/view/getBlog")
	public String getBlog(HttpServletRequest request,Model model){
		int id = Integer.parseInt(request.getParameter("id"));
		Blog blog = blogService.selectBlogById(id);
		model.addAttribute("blog", blog);
		return "/manage/article/editArticle";
	}
}
