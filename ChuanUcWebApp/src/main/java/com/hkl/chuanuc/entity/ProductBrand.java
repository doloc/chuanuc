package com.hkl.chuanuc.entity;
// Generated Aug 25, 2019 6:12:29 PM by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * ProductBrand generated by hbm2java
 */
@Entity
@Table(name = "product_brand", catalog = "shopify", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class ProductBrand implements java.io.Serializable {

	private Short id;
	private String name;
	private boolean available;
	private Set<Product> products = new HashSet<Product>(0);

	public ProductBrand() {
	}

	public ProductBrand(String name, boolean available) {
		this.name = name;
		this.available = available;
	}

	public ProductBrand(String name, boolean available, Set<Product> products) {
		this.name = name;
		this.available = available;
		this.products = products;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Short getId() {
		return this.id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	@Column(name = "name", unique = true, nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "available", nullable = false)
	public boolean isAvailable() {
		return this.available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productBrand")
	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
