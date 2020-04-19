package blog.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import blog.models.Post;
import blog.services.PostService;

@Controller
public class HomeController {
	
	@Autowired
	private PostService postService;
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Post> latest5Posts = postService.findLatest5();
		model.addAttribute("latest5Posts", latest5Posts);
		
		List<Post> latest3Posts = latest5Posts.stream()
				.limit(3).collect(Collectors.toList());
		model.addAttribute("latest3Posts", latest3Posts);
		
		return "index";
	}
}
