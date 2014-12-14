package org.wpattern.frameworks.hibernate4.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.wpattern.frameworks.hibernate4.keys.OrderDetailKey;
import org.wpattern.frameworks.hibernate4.utils.BaseBean;

@Entity
@Table(name="\"Order Details\"")
public class OrderDetailEntity extends BaseBean {

	private static final long serialVersionUID = 4145513888438234634L;

	@Id
	private OrderDetailKey id;

	private BigDecimal unitPrice;

	private Integer quantity;

	private Float discount;

	public OrderDetailEntity() {
	}

	public OrderDetailEntity(OrderDetailKey id, BigDecimal unitPrice,
			Integer quantity, Float discount) {
		this.id = id;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.discount = discount;
	}

	public OrderDetailKey getId() {
		return this.id;
	}

	public void setId(OrderDetailKey id) {
		this.id = id;
	}

	public BigDecimal getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getDiscount() {
		return this.discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

}
