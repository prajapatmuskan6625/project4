
package com.rays.pro4.Bean;

public class PaymentBean extends BaseBean {
	
	private String paymentType;
	private String amount;
	 private String customerName;
	 private String message;
	 
	 
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	@Override
	public String getkey() {
		return id + "";
	}
	@Override
	public String getValue() {
		return paymentType+"" ;
	}
	
	

}
