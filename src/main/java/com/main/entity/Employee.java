package com.main.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name="EmpInfo")
public class Employee {

	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String names;         
	 
	private String email; 
	  
	private String address;
	
	private String mobile;
	
	private String gender;
	
	
	private String password;
	
	
	
	
	
	
	
}
