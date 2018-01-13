package com.github.veeshostak.aiChatAnalyzerWeb.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.veeshostak.aiChatAnalyzerWeb.entity.ChatPost;

// @repository required for DAO
// component scan will find  the repository, handle exception translation
@Repository 
public class ChatPostDAOuser implements ChatPostDAO {
	
	private SessionFactory sessionFactory;
	
	@Autowired // spring finds the implementation of sessionFactory (only 1 so no need for qualifier)
	public ChatPostDAOuser(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
			
	@Override
	public List<ChatPost> getChatPosts() {
		
		// get the current hibernate session (Note: session factory was injected using @autowired)
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<ChatPost> theQuery = 
				currentSession.createQuery("FROM ChatPost c ORDER BY c.createdAt ASC, c.userQuery ASC", ChatPost.class);
		
		// execute query and get list
		List<ChatPost> chatPosts = theQuery.getResultList();
				
		// return the results		
		return chatPosts;
	}

	@Override
	public void saveChatPost(ChatPost theChatPost) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		// spring saveOrUpdate() determines to save or update
		// save: insert new ChatPost if new pk
		// update: update existing ChatPost if pk exists
		
		
		currentSession.saveOrUpdate(theChatPost);
		
	}

	@Override
	public ChatPost getChatPost(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// retrieve from db using the primary key
		ChatPost theChatPost = currentSession.get(ChatPost.class, theId);
		
		return theChatPost;
	}

	@Override
	public void deleteChatPost(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete from db with pk(id)
		Query<?> theQuery = 
				currentSession.createQuery("delete from ChatPost where id=:chatPostId");
		theQuery.setParameter("chatPostId", theId);
		
		theQuery.executeUpdate();
	}

	@Override
	public List<ChatPost> searchChatPosts(String theSearchName) {
	
	    // get the current hibernate session
	    Session currentSession = sessionFactory.getCurrentSession();
	    
	    Query<ChatPost> theQuery = null;
	    
	    if (theSearchName != null && theSearchName.trim().length() > 0) {
	
	        // search for user_query or response
	    	
	        // the "like" clause and the "%" wildcard characters,
	    		// allow us to search for substrings (ex. pat returns paterson, patel, ...)
	        theQuery =currentSession.createQuery("FROM ChatPost c WHERE user_query LIKE :theName or response LIKE :theName", ChatPost.class);
	        theQuery.setParameter("theName", "%" + theSearchName + "%");
	
	    }
	    else {
	        // theSearchName is empty, get all ChatPosts
	        theQuery =currentSession.createQuery("FROM ChatPost", ChatPost.class);
	    }
	    
	    // execute query and get result list
	    List<ChatPost> chatPosts = theQuery.getResultList();
	                 
	    return chatPosts;
	    
	}

}



