package org.wpattern.frameworks.hibernate4.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.wpattern.frameworks.hibernate4.utils.BaseBean;

@Entity
@Table(name="Orders")
public class OrderEntity extends BaseBean {

	private static final long serialVersionUID = -3431193482596298108L;

	@Id
	@GeneratedValue
	@Column(name = "OrderID")
	private Long id;

	private String customerId;

	private Long employeeId;

	private Date orderDate;

	private Date requiredDate;

	private Date shippedDate;

	private Long shipVia;

	private BigDecimal freight;

	private String shipName;

	private String shipAddress;

	private String shipCity;

	private String shipRegion;

	private String shipPostalCode;

	private String shipCountry;

	public OrderEntity() {
	}

	public OrderEntity(String customerId, Long employeeId, Date orderDate, Date requiredDate,
			Date shippedDate, Long shipVia, BigDecimal freight, String shipName, String shipAddress,
			String shipCity, String shipRegion, String shipPostalCode, String shipCountry) {
		this.customerId = customerId;
		this.employeeId = employeeId;
		this.orderDate = orderDate;
		this.requiredDate = requiredDate;
		this.shippedDate = shippedDate;
		this.shipVia = shipVia;
		this.freight = freight;
		this.shipName = shipName;
		this.shipAddress = shipAddress;
		this.shipCity = shipCity;
		this.shipRegion = shipRegion;
		this.shipPostalCode = shipPostalCode;
		this.shipCountry = shipCountry;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Long getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getRequiredDate() {
		return this.requiredDate;
	}

	public void setRequiredDate(Date requiredDate) {
		this.requiredDate = requiredDate;
	}

	public Date getShippedDate() {
		return this.shippedDate;
	}

	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}

	public Long getShipVia() {
		return this.shipVia;
	}

	public void setShipVia(Long shipVia) {
		this.shipVia = shipVia;
	}

	public BigDecimal getFreight() {
		return this.freight;
	}

	public void setFreight(BigDecimal freight) {
		this.freight = freight;
	}

	public String getShipName() {
		return this.shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public String getShipAddress() {
		return this.shipAddress;
	}

	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}

	public String getShipCity() {
		return this.shipCity;
	}

	public void setShipCity(String shipCity) {
		this.shipCity = shipCity;
	}

	public String getShipRegion() {
		return this.shipRegion;
	}

	public void setShipRegion(String shipRegion) {
		this.shipRegion = shipRegion;
	}

	public String getShipPostalCode() {
		return this.shipPostalCode;
	}

	public void setShipPostalCode(String shipPostalCode) {
		this.shipPostalCode = shipPostalCode;
	}

	public String getShipCountry() {
		return this.shipCountry;
	}

	public void setShipCountry(String shipCountry) {
		this.shipCountry = shipCountry;
	}

}
