package com.example.supportportal.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
@Entity
@Data
public class Post  extends Audit implements Serializable  {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	
	
	private String content,description;
	
	@Column(unique = true)
	private String title;
	
	
	@OneToMany(mappedBy = "post") 
	@JsonIgnoreProperties({"applications","hibernateLazyInitializer"})
	private List<Comment> comments=new ArrayList<Comment>();

}
