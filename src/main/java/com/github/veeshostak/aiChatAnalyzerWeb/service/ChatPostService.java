package com.github.veeshostak.aiChatAnalyzerWeb.service;
import java.util.List;

import com.github.veeshostak.aiChatAnalyzerWeb.entity.ChatPost;

// Interface

public interface ChatPostService {

	public List<ChatPost> getChatPosts();
	
	
	public void saveChatPost(ChatPost theChatPost);

	public ChatPost getChatPost(int theId);

	public void deleteChatPost(int theId);

	public List<ChatPost> searchChatPosts(String theSearchName);
	
}
