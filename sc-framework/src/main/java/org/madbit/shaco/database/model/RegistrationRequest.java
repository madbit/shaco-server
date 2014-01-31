package org.madbit.shaco.database.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the registration database table.
 * 
 */
@Entity
@Table(name="REGISTRATION_REQUEST")
public class RegistrationRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="REGISTRATION_ID", unique=true, nullable=false)
	private long registrationId;

	@Column(name="MSISDN", nullable=false, length=15)
	private String msisdn;
	
	@Column(name="USER_TOKEN", unique=true, nullable=false)
	private long userToken;

	@Column(name="REGISTRATION_CODE", nullable=false)
	private int registrationCode;
	
	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="EXPIRATION", nullable=false)
	private Date expiration;

	public RegistrationRequest() {
	}

	public long getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(long registrationId) {
		this.registrationId = registrationId;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public int getRegistrationCode() {
		return registrationCode;
	}

	public void setRegistrationCode(int registrationCode) {
		this.registrationCode = registrationCode;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public long getUserToken() {
		return userToken;
	}

	public void setUserToken(long userToken) {
		this.userToken = userToken;
	}
}