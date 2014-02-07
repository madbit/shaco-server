package org.madbit.shaco.database.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="contact")
public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="UID", unique=true, nullable=false)
	private long uid;

	@Column(name="MSISDN", nullable=false, length=15)
	private String msisdn;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;

	public Contact() {
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}