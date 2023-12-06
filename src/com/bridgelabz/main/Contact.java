package com.bridgelabz.main;

import java.util.Objects;

/*@desc:to get the contact details of the user
@params:fname,lname,address,city,zip,state,phone,email
@methods:parameterized contstructor, getFname, getLname,getAddress,getCity, getState */
class Contact {
	private String fname;
	private String lname;
	private String address;
	private String city;
	private String zip;
	private String state;
	private String phone;
	private String email;

	/*
	 * @desc:to get the contact details of the user
	 * 
	 * @params:fname,lname,address,city,zip,state,phone,email
	 * 
	 * @return:none
	 */
	public Contact(String fname, String lname, String address, String city, String state, String zip, String phone,
			String email) {
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.city = city;
		this.zip = zip;
		this.state = state;
		this.phone = phone;
		this.email = email;
	}

	/*
	 * @desc: to get info
	 * 
	 * @params:none
	 * 
	 * @return:String
	 */
	public String getFname() {
		return fname;
	}

	/*
	 * @desc: to get info
	 * 
	 * @params:none
	 * 
	 * @return:String
	 */
	public String getLname() {
		return lname;
	}

	/*
	 * @desc: to get info
	 * 
	 * @params:none
	 * 
	 * @return:String
	 */
	public String getAddress() {
		return address;
	}

	/*
	 * @desc: to get info
	 * 
	 * @params:none
	 * 
	 * @return:String
	 */
	public String getCity() {
		return city;
	}

	/*
	 * @desc: to get info
	 * 
	 * @params:none
	 * 
	 * @return:String
	 */
	public String getState() {
		return state;
	}

	/*
	 * @desc: to get info
	 * 
	 * @params:none
	 * 
	 * @return:String
	 */
	public String getZip() {
		return zip;
	}

	/*
	 * @desc: to get info
	 * 
	 * @params:none
	 * 
	 * @return:String
	 */
	public String getPhone() {
		return phone;
	}

	/*
	 * @desc: to get info
	 * 
	 * @params:none
	 * 
	 * @return:String
	 */
	public String getEmail() {
		return email;
	}

	/*
	 * @desc: to SET info
	 * 
	 * @params:STRING(from user)
	 * 
	 * @return:none
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/*
	 * @desc: to SET info
	 * 
	 * @params:STRING(from user)
	 * 
	 * @return:none
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/*
	 * @desc: to SET info
	 * 
	 * @params:STRING(from user)
	 * 
	 * @return:none
	 */
	public void setState(String state) {
		this.state = state;
	}

	/*
	 * @desc: to SET info
	 * 
	 * @params:STRING(from user)
	 * 
	 * @return:none
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/*
	 * @desc: to SET info
	 * 
	 * @params:STRING(from user)
	 * 
	 * @return:none
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/*
	 * @desc: to SET info
	 * 
	 * @params:STRING(from user)
	 * 
	 * @return:none
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 * @desc: to return in string format
	 * 
	 * @params:none
	 * 
	 * @return:String
	 */
	public String toString() {
		return String.format(
				"NAME : %s %s\nADDRESS : %s\nCITY : %s\nSTATE :%s\nZIP : %s\nPHONE NUMBER : %s\nEMAIL : %s\n", fname,
				lname, address, city, state, zip, phone, email);
	}

	/**
	 * @desc Checks if this Contact object is equal to another object. Equality is
	 *       determined based on the first name and last name.
	 * @params obj The object to compare with this Contact.
	 * @return true if the objects are equal, false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Contact contact = (Contact) obj;
		return Objects.equals(fname, contact.fname) && Objects.equals(lname, contact.lname);
	}

	@Override
	public int hashCode() {
		return Objects.hash(fname, lname);
	}

}
