package org.madbit.shaco.database.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_TOKEN", unique=true, nullable=false)
	private String userToken;

	@Column(name="IS_ENABLED")
	private byte isEnabled;

	@Column(name="MSISDN", nullable=false, length=15)
	private String msisdn;

	public User() {
	}

	public String getUserToken() {
		return this.userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public byte getIsEnabled() {
		return this.isEnabled;
	}

	public void setIsEnabled(byte isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getMsisdn() {
		return this.msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

}