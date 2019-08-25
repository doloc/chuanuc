package com.hkl.chuanuc.entity;
// Generated Aug 25, 2019 6:12:29 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * OrderDetail generated by hbm2java
 */
@Entity
@Table(name = "order_detail", catalog = "shopify")
public class OrderDetail implements java.io.Serializable {

	private OrderDetailId id;
	private Order order;
	private Product product;
	private long basePrice;
	private long sellPrice;
	private long discountPrice;
	private short quantity;
	private short refundCount;
	private String note;

	public OrderDetail() {
	}

	public OrderDetail(OrderDetailId id, Order order, Product product, long basePrice, long sellPrice,
			long discountPrice, short quantity, short refundCount, String note) {
		this.id = id;
		this.order = order;
		this.product = product;
		this.basePrice = basePrice;
		this.sellPrice = sellPrice;
		this.discountPrice = discountPrice;
		this.quantity = quantity;
		this.refundCount = refundCount;
		this.note = note;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "id", nullable = false)),
			@AttributeOverride(name = "orderId", column = @Column(name = "order_id", nullable = false)),
			@AttributeOverride(name = "productId", column = @Column(name = "product_id", nullable = false)) })
	public OrderDetailId getId() {
		return this.id;
	}

	public void setId(OrderDetailId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", nullable = false, insertable = false, updatable = false)
	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", nullable = false, insertable = false, updatable = false)
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name = "base_price", nullable = false)
	public long getBasePrice() {
		return this.basePrice;
	}

	public void setBasePrice(long basePrice) {
		this.basePrice = basePrice;
	}

	@Column(name = "sell_price", nullable = false)
	public long getSellPrice() {
		return this.sellPrice;
	}

	public void setSellPrice(long sellPrice) {
		this.sellPrice = sellPrice;
	}

	@Column(name = "discount_price", nullable = false)
	public long getDiscountPrice() {
		return this.discountPrice;
	}

	public void setDiscountPrice(long discountPrice) {
		this.discountPrice = discountPrice;
	}

	@Column(name = "quantity", nullable = false)
	public short getQuantity() {
		return this.quantity;
	}

	public void setQuantity(short quantity) {
		this.quantity = quantity;
	}

	@Column(name = "refund_count", nullable = false)
	public short getRefundCount() {
		return this.refundCount;
	}

	public void setRefundCount(short refundCount) {
		this.refundCount = refundCount;
	}

	@Column(name = "note", nullable = false, length = 65535)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}