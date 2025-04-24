package com.soft6creators.futurespace.app.deposit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.soft6creators.futurespace.app.crypto.Crypto;
import com.soft6creators.futurespace.app.user.User;

@Entity
public class Deposit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int depositId;
	@ManyToOne
	private User user;
	private int amount;
	private String status;
	@OneToOne
	private Crypto crypto;
	private String date;
	private String transactionId;
	
	public int getDepositId() {
		return depositId;
	}
	public void setDepositId(int depositId) {
		this.depositId = depositId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Crypto getCrypto() {
		return crypto;
	}
	public void setCrypto(Crypto crypto) {
		this.crypto = crypto;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
} 