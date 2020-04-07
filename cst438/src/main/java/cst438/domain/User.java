package cst438.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Users")
public class User {

	@Id
	@GeneratedValue
	private long id;
	@Column(name="countryCode")
	private String countryCode;
	@Column(name="district")
	private String district;
	@Column(name="symptomListId")
	private long symptomListId;
	@Column(name="age")
	private long age;
	
	@Transient
	private UserSymptomList symptoms;
	
	
	
	public User(String countryCode, String district, UserSymptomList symptoms, long age) {
		super();
		this.countryCode = countryCode;
		this.district = district;
		this.symptoms = symptoms;
		this.symptomListId = symptoms.getId();
	}



	public String getCountryCode() {
		return countryCode;
	}



	public long getAge() {
		return age;
	}



	public void setAge(long age) {
		this.age = age;
	}



	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}



	public String getDistrict() {
		return district;
	}



	public void setDistrict(String district) {
		this.district = district;
	}




	public UserSymptomList getSymptoms() {
		return symptoms;
	}



	public void setSymptoms(UserSymptomList symptoms) {
		this.symptoms = symptoms;
	}


	public long getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return "{"
				+ "id: " + id
				+ "coutryCode: " + countryCode
				+ "district: " + district
				+ "symptomListId: " + symptomListId
				+ "}";
	}
	
	
	
}
