package com.gyandeep.ElasticSpringData.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Mapping;
import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "testindex4")
public class Employee {
	
	@Id
	@Field(type = FieldType.Long)
	long id;
	@Field(type = FieldType.Long)
	long gender;
	@Field(type = FieldType.Long)
	long userType; 
	@Field(type = FieldType.Long)
	long userStatus; 
	@Field(type = FieldType.Long)
	long creditBalance; 
	@Field(type = FieldType.Long)
	long myCash;
	@Field(type = FieldType.Keyword)
	String name;
	@Field(type = FieldType.Keyword)
	String email;
	@Field(type = FieldType.Keyword)
	String password;
	@Field(type = FieldType.Keyword)
	String about;
	@Field(type = FieldType.Keyword)
	String token;
	@Field(type = FieldType.Keyword)
	String country;
	@Field(type = FieldType.Keyword)
	String location;
	@Field(type = FieldType.Keyword)
	String dob;
	@Field(type = FieldType.Keyword)
	String profilePicture;
	@Field(type = FieldType.Keyword)
	String coverPicture;
	@Field(type = FieldType.Keyword)
	String createdAt;
	@Field(type = FieldType.Keyword)
	String updatedAt;
	@Field(type = FieldType.Keyword)
	String liveLocation;
	@Field(type = FieldType.Double)
	double lng;
	@Field(type = FieldType.Double)
	double lat;
	@Field(type = FieldType.Double)
	double livelng;
	@Field(type = FieldType.Double)
	double livelat;
	@Field(type = FieldType.Boolean)
	boolean enablefollowme;
	@Field(type = FieldType.Boolean)
	boolean sendmenotifications;
	@Field(type = FieldType.Boolean)
	boolean sendTextmessages;
	@Field(type = FieldType.Boolean)
	boolean enabletagging;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((about == null) ? 0 : about.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((coverPicture == null) ? 0 : coverPicture.hashCode());
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + (int) (creditBalance ^ (creditBalance >>> 32));
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (enablefollowme ? 1231 : 1237);
		result = prime * result + (enabletagging ? 1231 : 1237);
		result = prime * result + (int) (gender ^ (gender >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		long temp;
		temp = Double.doubleToLongBits(lat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((liveLocation == null) ? 0 : liveLocation.hashCode());
		temp = Double.doubleToLongBits(livelat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(livelng);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lng);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + (int) (myCash ^ (myCash >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((profilePicture == null) ? 0 : profilePicture.hashCode());
		result = prime * result + (sendTextmessages ? 1231 : 1237);
		result = prime * result + (sendmenotifications ? 1231 : 1237);
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
		result = prime * result + (int) (userStatus ^ (userStatus >>> 32));
		result = prime * result + (int) (userType ^ (userType >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (about == null) {
			if (other.about != null)
				return false;
		} else if (!about.equals(other.about))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (coverPicture == null) {
			if (other.coverPicture != null)
				return false;
		} else if (!coverPicture.equals(other.coverPicture))
			return false;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (creditBalance != other.creditBalance)
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (enablefollowme != other.enablefollowme)
			return false;
		if (enabletagging != other.enabletagging)
			return false;
		if (gender != other.gender)
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(lat) != Double.doubleToLongBits(other.lat))
			return false;
		if (liveLocation == null) {
			if (other.liveLocation != null)
				return false;
		} else if (!liveLocation.equals(other.liveLocation))
			return false;
		if (Double.doubleToLongBits(livelat) != Double.doubleToLongBits(other.livelat))
			return false;
		if (Double.doubleToLongBits(livelng) != Double.doubleToLongBits(other.livelng))
			return false;
		if (Double.doubleToLongBits(lng) != Double.doubleToLongBits(other.lng))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (myCash != other.myCash)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (profilePicture == null) {
			if (other.profilePicture != null)
				return false;
		} else if (!profilePicture.equals(other.profilePicture))
			return false;
		if (sendTextmessages != other.sendTextmessages)
			return false;
		if (sendmenotifications != other.sendmenotifications)
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		if (updatedAt == null) {
			if (other.updatedAt != null)
				return false;
		} else if (!updatedAt.equals(other.updatedAt))
			return false;
		if (userStatus != other.userStatus)
			return false;
		if (userType != other.userType)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", gender=" + gender + ", userType=" + userType + ", userStatus=" + userStatus
				+ ", creditBalance=" + creditBalance + ", myCash=" + myCash + ", name=" + name + ", email=" + email
				+ ", password=" + password + ", about=" + about + ", token=" + token + ", country=" + country
				+ ", location=" + location + ", dob=" + dob + ", profilePicture=" + profilePicture + ", coverPicture="
				+ coverPicture + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", liveLocation="
				+ liveLocation + ", lng=" + lng + ", lat=" + lat + ", livelng=" + livelng + ", livelat=" + livelat
				+ ", enablefollowme=" + enablefollowme + ", sendmenotifications=" + sendmenotifications
				+ ", sendTextmessages=" + sendTextmessages + ", enabletagging=" + enabletagging + "]";
	}
	
	
}

/*
{
    "id": 4051,
    "name": "manoj",
    "email": "manoj@gmail.com",
    "password": "Test@123",
    "about": null,
    "token": "7f471974-ae46-4ac0-a882-1980c300c4d6",
    "country": null,
    "location": null,
    "lng": 0,
    "lat": 0,
    "dob": null,
    "gender": 0,
    "userType": 1,
    "userStatus": 1,
    "profilePicture": "Images/9b291404-bc2e-4806-88c5-08d29e65a5ad.png",
    "coverPicture": "Images/44af97d9-b8c9-4ec1-a099-010671db25b7.png",
    "enablefollowme": false,
    "sendmenotifications": false,
    "sendTextmessages": false,
    "enabletagging": false,
    "createdAt": "2020-01-01T11:13:27.1107739",
    "updatedAt": "2020-01-02T09:16:49.284864",
    "livelng": 77.389849,
    "livelat": 28.6282231,
    "liveLocation": "Unnamed Road, Chhijarsi, Sector 63, Noida, Uttar Pradesh 201307, India",
    "creditBalance": 127,
    "myCash": 0
}*/