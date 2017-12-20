package com.github.veeshostak.aiChatAnalyzerWeb.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.veeshostak.aiChatAnalyzerWeb.entity.ChatPost;
import com.github.veeshostak.aiChatAnalyzerWeb.service.ChatPostService;

@Controller
@RequestMapping("/chat-post")
public class ChatPostController {
	
	// inject ChatPostServie using Field Injection. @Qualifier("chatPostServiceUsers")
	@Autowired
	private ChatPostService chatPostService;
	
	// =============================
	
	@GetMapping("/list")
	public String listChatPosts(Model theModel) {
		
		// get chatPosts from the customer service
		List<ChatPost> theChatPosts = chatPostService.getChatPosts();
		
		// add the chatPosts to the model
		theModel.addAttribute("chatPosts", theChatPosts);
		
		return "list-chat-posts";
	}
	
	@PostMapping("/search")
	 public String searchChatPosts(@RequestParam("theSearchName") String theSearchName,
                                   Model theModel) {

		// search chatPost from the service
		List<ChatPost> theChatPosts = chatPostService.searchChatPosts(theSearchName);
		        
		// add the chatPosts to the model
		theModel.addAttribute("chatPosts", theChatPosts);
		
		return "list-chat-posts";
   }


}

