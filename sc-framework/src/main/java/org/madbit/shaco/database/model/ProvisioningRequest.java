package org.madbit.shaco.database.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the registration database table.
 * 
 */
@Entity
@Table(name="PROVISIONING_REQUEST")
public class ProvisioningRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PROVISIONING_ID", unique=true, nullable=false)
	private int provisioningID;

	@Column(name="MSISDN", nullable=false, length=15)
	private String msisdn;

	@Column(name="REGISTRATION_CODE", nullable=false)
	private int registrationCode;
	
	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="EXPIRATION", nullable=false)
	private Date expiration;

	public ProvisioningRequest() {
	}

	public int getProvisioningID() {
		return provisioningID;
	}

	public void setProvisioningID(int provisioningID) {
		this.provisioningID = provisioningID;
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
}