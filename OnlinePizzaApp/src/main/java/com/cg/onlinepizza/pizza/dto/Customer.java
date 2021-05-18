package com.cg.onlinepizza.pizza.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/***************************************************************************************************************************
 * Class: Customer
 * Description: It is the customer entity
 * Created By-BANHISHIKA CHANDA
 * Created Date -  15-05-2021 
 * 
 ***************************************************************************************************************************/

@Entity
@Table(name="customer")
public class Customer {
	@Id
	private int customerId;
	private String customerName;
	private Long customerMobile;
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerMobile="
				+ customerMobile + ", customerEmail=" + customerEmail + ", customerAddress=" + customerAddress
				+ ", userName=" + userName + ", password=" + password + "]";
	}

	private String customerEmail;
	private String customerAddress;
	private String userName;
	private String password;
	//@OneToMany(targetEntity=CartItem.class, mappedBy="customer", cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	//private List<CartItem> cartItem;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Long getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(Long customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}

