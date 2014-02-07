package org.madbit.shaco.database.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID", unique=true, nullable=false)
	private long userId;

	@Column(name="IS_ENABLED")
	private byte isEnabled;

	@Column(nullable=false, length=15)
	private String msisdn;

	//bi-directional many-to-one association to Contact
	@OneToMany(mappedBy="user")
	private List<Contact> contacts;

	public User() {
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public List<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public Contact addContact(Contact contact) {
		getContacts().add(contact);
		contact.setUser(this);

		return contact;
	}

	public Contact removeContact(Contact contact) {
		getContacts().remove(contact);
		contact.setUser(null);

		return contact;
	}

}