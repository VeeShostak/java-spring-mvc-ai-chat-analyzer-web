package com.github.veeshostak.aiChatAnalyzerWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.veeshostak.aiChatAnalyzerWeb.dao.ChatPostDAO;
import com.github.veeshostak.aiChatAnalyzerWeb.entity.ChatPost;

@Service
public class ChatPostServiceUsers implements ChatPostService {

	// inject ChatPostDAO using Field Injection. Accomplished by using 
	// Java Reflection technology ( It allows an executing Java program to examine or "introspect" upon
	// itself, and manipulate internal properties of the program). No need for setter injection methods or constructor injection)
	@Autowired
	@Qualifier("chatPostDAOuser") // if we have multiple ChatPost implementations, tell Spring which bean id to use
	private ChatPostDAO chatPostDAO;
	
	// delegate calls to dao
	
	@Override
	@Transactional
	public List<ChatPost> getChatPosts() {
		return chatPostDAO.getChatPosts();
	}

	@Override
	@Transactional
	public void saveChatPost(ChatPost theChatPost) {

		chatPostDAO.saveChatPost(theChatPost);
	}

	@Override
	@Transactional
	public ChatPost getChatPost(int theId) {
		return chatPostDAO.getChatPost(theId);
	}

	@Override
	@Transactional
	public void deleteChatPost(int theId) {
		
		chatPostDAO.deleteChatPost(theId);
	}

	@Override
    @Transactional
    public List<ChatPost> searchChatPosts(String theSearchName) {

        return chatPostDAO.searchChatPosts(theSearchName);
    }

	
}






