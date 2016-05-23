package com.laufu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.code.kaptcha.Constants;
import com.laufu.domain.User;
import com.laufu.service.LoginService;
import com.laufu.util.common.GlobalValue;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	/**
	 * 登录验证
	 * @param user 登录用户
	 * @param session 用于存储用户信息
	 * @param verifyCode 验证码
	 * @param request 返回信息
	 * @return
	 */
	@RequestMapping(value="/login")
	public String loginSys(@ModelAttribute("user")User user,HttpSession session,String verifyCode,HttpServletRequest request){
		String code = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);        //获取生成的验证码  
        System.out.println(verifyCode + "," + code);  
        if(verifyCode.equals(code)) {  
            System.out.println("验证通过 ");  
        }  
		if (loginService.loginSys(user) != null) {
			session.setAttribute("user", user);
			GlobalValue.user = user;
			return "indexLogin";
		}
		return "indexLogin";
	}
}
