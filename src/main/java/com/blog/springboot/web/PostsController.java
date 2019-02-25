package com.blog.springboot.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.springboot.mapper.PostsMapper;
import com.blog.springboot.pojo.Posts;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class PostsController {
	@Autowired
	PostsMapper postsMapper;

	@RequestMapping("/adminAddPosts")
	public String listPosts(Posts posts) throws Exception {
		posts.setTime(new Date());
		postsMapper.save(posts);
		return "redirect:adminListPosts";
	}

	@RequestMapping("/adminDeletePosts/{id}")
	public String deletePosts(@PathVariable(value = "id") int id) throws Exception {
		postsMapper.delete(id);
		return "redirect:/adminListPosts";
	}

	@RequestMapping("/adminUpdatePosts")
	public String updatePosts(Posts posts) throws Exception {
		postsMapper.update(posts);
		return "redirect:/adminListPosts";
	}

	@RequestMapping("/adminEditPosts/{id}")
	public String listPosts(@PathVariable(value = "id") int id, Model model) throws Exception {
		Posts posts = postsMapper.getPosts(id);
		model.addAttribute("p", posts);
		return "adminEditPosts";
	}

	@RequestMapping("/adminListPosts")
	public String listPosts(Model model, @RequestParam(value = "start", defaultValue = "0") int start,
			@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
		PageHelper.startPage(start, size, "id asc");
		List<Posts> ps = postsMapper.findAll();
		PageInfo<Posts> page = new PageInfo<Posts>(ps);
		model.addAttribute("page", page);

		return "adminListPosts";
	}

}
