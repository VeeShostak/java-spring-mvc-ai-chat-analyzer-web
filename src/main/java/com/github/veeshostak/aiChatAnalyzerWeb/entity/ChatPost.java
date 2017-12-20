package com.github.veeshostak.aiChatAnalyzerWeb.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name="user_chat_posts")
public class ChatPost {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="user_query")
	private String userQuery;
	
	@Column(name="response")
	private String response;
	
	@Column(name="machine_responded")
	private boolean machineResponded;
	
	@Column(name="created_at")
	private Timestamp createdAt;
	
	// Bidirectional - ManyToOne - many chatPosts to one user.
	// Foreign Key, know what user the chatPost belongs to
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 	CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="user_id") // name of column on this table(user_chat_posts) that has the Foreign Key
	private User userId;
	
	
	
	// =========
	
	public ChatPost() {
		
	}


	
	public User getUserId() {
		return userId;
	}



	public void setUserId(User userId) {
		this.userId = userId;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUserQuery() {
		return userQuery;
	}


	public void setUserQuery(String userQuery) {
		this.userQuery = userQuery;
	}


	public String getResponse() {
		return response;
	}


	public void setResponse(String response) {
		this.response = response;
	}


	public boolean getMachineResponded() {
		return machineResponded;
	}


	public void setMachineResponded(boolean machineResponded) {
		this.machineResponded = machineResponded;
	}


	public Timestamp getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	
	


	@Override
	public String toString() {
		return "ChatPost [id=" + id + ", userQuery=" + userQuery + ", response=" + response + ", machineResponded="
				+ machineResponded + ", createdAt=" + createdAt + "]";
	}
	
	
}
