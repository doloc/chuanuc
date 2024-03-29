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
 * Shipping generated by hbm2java
 */
@Entity
@Table(name = "shipping", catalog = "shopify", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Shipping implements java.io.Serializable {

	private Byte id;
	private String name;
	private long cost;
	private boolean available;
	private Set<Order> orders = new HashSet<Order>(0);

	public Shipping() {
	}

	public Shipping(String name, long cost, boolean available) {
		this.name = name;
		this.cost = cost;
		this.available = available;
	}

	public Shipping(String name, long cost, boolean available, Set<Order> orders) {
		this.name = name;
		this.cost = cost;
		this.available = available;
		this.orders = orders;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Byte getId() {
		return this.id;
	}

	public void setId(Byte id) {
		this.id = id;
	}

	@Column(name = "name", unique = true, nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "cost", nullable = false)
	public long getCost() {
		return this.cost;
	}

	public void setCost(long cost) {
		this.cost = cost;
	}

	@Column(name = "available", nullable = false)
	public boolean isAvailable() {
		return this.available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "shipping")
	public Set<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

}
