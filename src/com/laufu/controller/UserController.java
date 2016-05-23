package com.laufu.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.laufu.domain.Pager;
import com.laufu.domain.User;
import com.laufu.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService service;

	/**
	 * 显示添加页
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/add")
	public String add(Model model) {
		model.addAttribute("user", new User());
		return "update";
	}

	/**
	 * 保存数据操作
	 * 
	 * @param u
	 * @return
	 */
	@RequestMapping("/update")
	public String update(User u) {

		if (u.getId() > 0) {
			// 更新
			service.update(u);
		} else {
			// 插入
			service.insert(u);
		}
		return "redirect:/list.html";
	}

	/**
	 * 添加100000条记录测试
	 * 
	 * @return
	 */
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String test() {
		long t = new Date().getTime();
		for (int i = 0; i < 100000; i++) {
			User u = new User();
			u.setUsername("test" + i);
			u.setPassword("password" + i);
			u.setEmail("aaa@com.cn");
			int roleid = i % 2;
			u.setRoleId(roleid);
			service.insert(u);
		}
		long time = new Date().getTime() - t;
		System.out.println("添加100000条记录，花费时间:" + time + "ms，平均每条" + time
				/ 100000 + "ms");
		return "redirect:/list.html";
	}

	/**
	 * 显示修改页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/edit")
	public String get(Integer id, Model model) {

		model.addAttribute("user", service.getUserById(id));
		return "update";
	}

	/**
	 * 删除操作
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/del")
	public String del(Integer id) {
		service.delete(id);
		return "redirect:/list.html";
	}

	/**
	 * 显示分页数据
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String index(HttpServletRequest request, Model model) {
		int pageSize = 20;
		int page = request.getParameter("page") == null ? 1 : Integer
				.valueOf(request.getParameter("page"));
		if (page < 1)
			page = 1;
		Pager p = service.getList(page, pageSize);

		model.addAttribute("pager", p.getPagerStr());
		model.addAttribute("list", p.getItems());
//		return "list";
//		new ModelAndView("redirect:/login.jsp",map);
		return "redirect:/list.jsp";
	}

	@RequestMapping(value="/selectUser",method= RequestMethod.GET)
	public String selectAll(HttpServletRequest request,Model model){
		int pageSize = 20;
		int page = request.getParameter("page") == null ? 1 : Integer
				.valueOf(request.getParameter("page"));
		if (page < 1)
			page = 1;
		Pager p = service.getList(page, pageSize);

		model.addAttribute("pager", p.getPagerStr());
//		model.addAttribute("list", p.getItems());
		
		JSONArray jsonObject = JSONArray.fromObject(p.getItems());
//		System.out.println(jsonObject.toString());
		
		model.addAttribute("list", "{Rows : "+jsonObject.toString()+",Total:" + p.getTotalCount() +"}");
		return "/demos/grid/frozen/listUsers";
	}
	
	@RequestMapping(value="/loginSys",method= RequestMethod.POST)
	public String login(User u){
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
		User user =null;
		user = service.loginSys(u);
		if (user == null) {
//			model.addAttribute("msg","用户名或密码错误！");
			return "redirect:/LoginWeb/indexLogin.jsp";
		}
		return "redirect:/view/index.jsp";
	}
}
