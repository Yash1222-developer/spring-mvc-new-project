package com.online.shopping.portal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "tbl_admin")
public class Admin {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

    @NotEmpty(message="Email cannot be empty")
    @Email(message="Enter a valid email")
    @Column(name = "email", unique = true)
    private String email;

    @NotEmpty(message="Password cannot be empty")
    @Column(name = "pass")
    private String password;
    
    @Column(name="country_id")
    private int countryId;

    @Column(name="state_id")
    private int stateId;

    @Column(name="district_id")
    private int districtId;

    // transient fields for form selection
    @Transient
    private String countryName;
    @Transient
    private String stateName;
    @Transient
    private String districtName;

    @Column(name = "status")
    private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public int getDistrictId() {
		return districtId;
	}

	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Admin(int id,
			@NotEmpty(message = "Email cannot be empty") @Email(message = "Enter a valid email") String email,
			@NotEmpty(message = "Password cannot be empty") String password, int countryId, int stateId, int districtId,
			String countryName, String stateName, String districtName, String status) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.countryId = countryId;
		this.stateId = stateId;
		this.districtId = districtId;
		this.countryName = countryName;
		this.stateName = stateName;
		this.districtName = districtName;
		this.status = status;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

}
