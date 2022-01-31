package com.te.SpringAssement.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="Product")
public class ProductDetails implements Serializable {

	@Id
	@Column(name="p_id")
	private int id;
	@Column(name="p_name")
	private String name;
	@Column(name="p_brand")
	private String brand;
	@Column(name="p_price")
	private double price;
	@Column(name="e_password")
	private String password;
}
