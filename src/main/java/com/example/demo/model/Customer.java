package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
		
	@Id
	private Integer id;
	
		private String name;
		private int age;
		
		public Customer() {}
		
		public Customer(Integer id, String name, int age) {
			super();
			this.id=id;
			this.name = name;
			this.age = age;
		}
		
}
