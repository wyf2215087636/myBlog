package com.blog.springboot.web;

import java.util.Date;
import java.util.List;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.springboot.mapper.PostsMapper;
import com.blog.springboot.pojo.Admin;
import com.blog.springboot.pojo.Posts;
import com.blog.springboot.util.Data;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class AdminController {
	@Autowired
	PostsMapper postsMapper;
	
	@RequestMapping("/admin")
	public String admin(Model model, @RequestParam(value = "start", defaultValue = "0") int start,
			@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
		
		PageHelper.startPage(start, 5, "id desc");
		List<Posts> ps = postsMapper.getAllPosts();
		PageInfo<Posts> page = new PageInfo<Posts>(ps);
		model.addAttribute("page", page);
		
		PageHelper.startPage(start, size, "popularity desc");
		List<Posts> psForPopularitye = postsMapper.getAllPosts();
		PageInfo<Posts> pagePopularity = new PageInfo<Posts>(psForPopularitye);
		model.addAttribute("pagePopularity", pagePopularity);
		return "admin";
	}
	
	@RequestMapping("/deletePosts/{id}")
	public String deleletPosts(@PathVariable("id")int id) {
		int num = postsMapper.delete(id);
		if(num == 1) {
			System.out.println("删除文章成功");
		}
		
		return "redirect:/admin";
	}
	
	@RequestMapping("/adminlogin")
	public String adminlogin() {
		return "login";
	}
	
	@ResponseBody
	@RequestMapping("/loginload")
	public Data loginsuccess(String adminname,String adminpass,HttpServletRequest request,Model model) {
		System.out.println("我进来了");
		System.out.println("管理员账号:"+adminname);
		System.out.println("管理员密码:"+adminpass);
		Admin admin = new Admin();
		admin.setAdminname(adminname);
		admin.setAdminpass(adminpass);
		Admin oneAdmin = postsMapper.getOneAdmin(admin);
		if(oneAdmin==null) {
			return new Data(-1,"管理员账号不存在");
		}else {
			if(oneAdmin.getAdminname().equals(admin.getAdminname())) {
				if(oneAdmin.getAdminpass().equals(admin.getAdminpass())) {
					admin.setLogin_time(new Date());
					postsMapper.updateAdmin(admin);
					HttpSession session = request.getSession();
					session.setAttribute("admin", oneAdmin.getAdminname());
					session.setAttribute("admin_img", oneAdmin.getAdmin_img());
					model.addAttribute("session",session);
					return new Data(1,"登陆成功");
				}else {
					return new Data(-1,"密码输入错误");
				}
			}else 
				return new Data(-1,"管理员账号不存在");
		}
		
	}
	
	
	@RequestMapping("/adminInfo")
	public String admininfo(HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		Object adminname = session.getAttribute("admin");
		System.out.println(adminname);
		Admin admin = new Admin();
		admin.setAdminname(adminname.toString());
		Admin admin_info = postsMapper.getOneAdmin(admin);
		model.addAttribute("admin",admin_info);
		return "/yzm";
	}
	

}
