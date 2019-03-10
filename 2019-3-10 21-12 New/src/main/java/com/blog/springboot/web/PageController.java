package com.blog.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@RequestMapping("/admin_list")
	public String admin() {
		return "forward:/adminListPosts";
	}

	@RequestMapping("/admin_edit")
	public String adminEdit() {
		return "forward:/adminEditPosts";
	}

	@RequestMapping("/admin_delete/{id}")
	public String adminDelete(@PathVariable(value = "id") int id) {
		return "forward:/adminDeletePosts/" + id;
	}

	@RequestMapping("/user_list")
	public String user() {
		return "forward:/userListPosts";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

}
