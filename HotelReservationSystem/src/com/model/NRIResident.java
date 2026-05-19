
package com.model;

public class NRIResident {
 private String residentId;
 private String residentName;
 private int age;
 private String gender;
 private long contactNumber;
 private String email;
 private String address;
 private int numberOfAdults;
 private int numberOfChildrenAbove12;
 private int numberOfChildrenAbove5;
 private int durationOfStay;
 private String residentType;
 private String passportNo;
 private String passportType;
 private String nationality;
 private String purposeForVisit;
 public String getResidentId() {
	return residentId;
 }
 public void setResidentId(String residentId) {
	this.residentId = residentId;
 }
 public String getResidentName() {
	return residentName;
 }
 public void setResidentName(String residentName) {
	this.residentName = residentName;
 }
 public int getAge() {
	return age;
 }
 public void setAge(int age) {
	this.age = age;
 }
 public String getGender() {
	return gender;
 }
 public void setGender(String gender) {
	this.gender = gender;
 }
 public long getContactNumber() {
	return contactNumber;
 }
 public void setContactNumber(long contactNumber) {
	this.contactNumber = contactNumber;
 }
 public String getEmail() {
	return email;
 }
 public void setEmail(String email) {
	this.email = email;
 }
 public String getAddress() {
	return address;
 }
 public void setAddress(String address) {
	this.address = address;
 }
 public int getNumberOfAdults() {
	return numberOfAdults;
 }
 public void setNumberOfAdults(int numberOfAdults) {
	this.numberOfAdults = numberOfAdults;
 }
 public int getNumberOfChildrenAbove12() {
	return numberOfChildrenAbove12;
 }
 public void setNumberOfChildrenAbove12(int numberOfChildrenAbove12) {
	this.numberOfChildrenAbove12 = numberOfChildrenAbove12;
 }
 public int getNumberOfChildrenAbove5() {
	return numberOfChildrenAbove5;
 }
 public void setNumberOfChildrenAbove5(int numberOfChildrenAbove5) {
	this.numberOfChildrenAbove5 = numberOfChildrenAbove5;
 }
 public int getDurationOfStay() {
	return durationOfStay;
 }
 public void setDurationOfStay(int durationOfStay) {
	this.durationOfStay = durationOfStay;
 }
 public String getResidentType() {
	return residentType;
 }
 public void setResidentType(String residentType) {
	this.residentType = residentType;
 }
 public String getPassportNo() {
	return passportNo;
 }
 public void setPassportNo(String passportNo) {
	this.passportNo = passportNo;
 }
 public String getPassportType() {
	return passportType;
 }
 public void setPassportType(String passportType) {
	this.passportType = passportType;
 }
 public String getNationality() {
	return nationality;
 }
 public void setNationality(String nationality) {
	this.nationality = nationality;
 }
 public String getPurposeForVisit() {
	return purposeForVisit;
 }
 public void setPurposeForVisit(String purposeForVisit) {
	this.purposeForVisit = purposeForVisit;
 }
 public NRIResident(String residentId, String residentName, int age, String gender, long contactNumber, String email,
		String address, int numberOfAdults, int numberOfChildrenAbove12, int numberOfChildrenAbove5, int durationOfStay,
		String residentType, String passportNo, String passportType, String nationality, String purposeForVisit) {
	super();
	this.residentId = residentId;
	this.residentName = residentName;
	this.age = age;
	this.gender = gender;
	this.contactNumber = contactNumber;
	this.email = email;
	this.address = address;
	this.numberOfAdults = numberOfAdults;
	this.numberOfChildrenAbove12 = numberOfChildrenAbove12;
	this.numberOfChildrenAbove5 = numberOfChildrenAbove5;
	this.durationOfStay = durationOfStay;
	this.residentType = residentType;
	this.passportNo = passportNo;
	this.passportType = passportType;
	this.nationality = nationality;
	this.purposeForVisit = purposeForVisit;
 }
 @Override
 public String toString() {
	return "NRIResident [residentId=" + residentId + ", residentName=" + residentName + ", age=" + age + ", gender="
			+ gender + ", contactNumber=" + contactNumber + ", email=" + email + ", address=" + address
			+ ", numberOfAdults=" + numberOfAdults + ", numberOfChildrenAbove12=" + numberOfChildrenAbove12
			+ ", numberOfChildrenAbove5=" + numberOfChildrenAbove5 + ", durationOfStay=" + durationOfStay
			+ ", residentType=" + residentType + ", passportNo=" + passportNo + ", passportType=" + passportType
			+ ", nationality=" + nationality + ", purposeForVisit=" + purposeForVisit + "]";
 }
 
}
