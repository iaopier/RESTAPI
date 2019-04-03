package com.piercarlo.fishstore.RESTAPI.product;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Access(AccessType.FIELD)
public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "quantity", nullable = false)
	private int quantity;
	
	public Product() {
		this.id = 0;
        this.name = null;
        this.quantity = 0;
    }
	
	public Product(long id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }
	
	
	public long getId() {
		return id;
	}

	
	public String getName() {
		return name;
	}
	
	
	public int getQuantity() {
		return quantity;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
