package com.github.veeshostak.aiChatAnalyzerWeb.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	@Column(name="uid") // , nullable = false
	private String uid;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="created_at")
	private String createdAt;
	
	
	// One to Many bidirectional (one user has many chatposts), back populate user column in user_chat_posts table
	@OneToMany(fetch=FetchType.LAZY,
			mappedBy="userId", // mappedBy, which var represents the parent class in our child class. (child has a userId var)
			cascade= CascadeType.ALL
			)
	private List<ChatPost> chatPosts;
	
	// =========
	
	public User() {
		
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public List<ChatPost> getChatPosts() {
		return chatPosts;
	}

	public void setChatPosts(List<ChatPost> chatPosts) {
		this.chatPosts = chatPosts;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", email=" + email + ", password=" + password + ", createdAt=" + createdAt
				+ ", chatPosts=" + chatPosts + "]";
	}
	
	
}