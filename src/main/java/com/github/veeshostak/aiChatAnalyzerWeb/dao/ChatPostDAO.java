package com.github.veeshostak.aiChatAnalyzerWeb.dao;

import java.util.List;

import com.github.veeshostak.aiChatAnalyzerWeb.entity.ChatPost;

public interface ChatPostDAO {

	public List<ChatPost> getChatPosts();
	
	
	public void saveChatPost(ChatPost theChatPost);

	public ChatPost getChatPost(int theId);

	public void deleteChatPost(int theId);

	public List<ChatPost> searchChatPosts(String theSearchName);
	
}
