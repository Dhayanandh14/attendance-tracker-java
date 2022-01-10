package com.attendanceTracker.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "users",uniqueConstraints=@UniqueConstraint(columnNames={"id","user_email"}))
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long id;
	
	@Column(name = "user_name")
	private String username;
	
	@Column (name = "user_email")
	private String useremail;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "communication_address")
	private String communication_address;
	


	@Column(name = "home_address ")
	private String home_address;
	
	@Column(name = "access_id")
	private String access_id;
	
	@Column(name = "aadhar_number")
	private long Aadhar_number;
	
	@Column(name = "phone_number")
	private long phone_number;
	
	@Column(name = "blood_group")
	private String blood_group;
	
	@Column(name = "personal_email")
	private String personal_email;
	
	@Column(name = "emergency_contact_name")
	private String emergency_contact_name;
	
	@Column(name = "emergency_contact_number")
	private long emergency_contact_number;
	
//	@OneToOne(mappedBy = "user")
//	Student student;
//	
//	@ManyToOne(fetch = FetchType.EAGER,optional = false)
//	@JoinColumn(name = "student_id")
//	private Student student;
//	
//	
	
	public User() {
	
	}
	
	public User(String user_name, String user_email, String password, String role, int age, String gender,
			String communication_address, String home_address, String access_id, long aadhar_number, long phone_number,
			String blood_group, String personal_email, String emergency_contact_name, long emergency_contact_number) {
		super();
		this.username = user_name;
		this.useremail = user_email;
		this.password = password;
		this.role = role;
		this.age = age;
		this.gender = gender;
		this.communication_address = communication_address;
		this.home_address = home_address;
		this.access_id = access_id;
		Aadhar_number = aadhar_number;
		this.phone_number = phone_number;
		this.blood_group = blood_group;
		this.personal_email = personal_email;
		this.emergency_contact_name = emergency_contact_name;
		this.emergency_contact_number = emergency_contact_number;
	}


//	public User(String user_name, String user_email, String password) {
//		super();
//		this.user_name = user_name;
//		this.user_email = user_email;
//		this.password = password;
//	}

	public long getUser_id() {
		return id;
	}

	public void setUser_id(long user_id) {
		this.id = user_id;
	}

	public String getUser_name() {
		return username;
	}

	public void setUser_name(String user_name) {
		this.username = user_name;
	}

	public String getUser_email() {
		return useremail;
	}

	public void setUser_email(String user_email) {
		this.useremail = user_email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
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


	public String getCommunication_address() {
		return communication_address;
	}


	public void setCommunication_address(String communication_address) {
		this.communication_address = communication_address;
	}


	public String getHome_address() {
		return home_address;
	}


	public void setHome_address(String home_address) {
		this.home_address = home_address;
	}


	public String getAccess_id() {
		return access_id;
	}


	public void setAccess_id(String access_id) {
		this.access_id = access_id;
	}


	public long getAadhar_number() {
		return Aadhar_number;
	}


	public void setAadhar_number(long aadhar_number) {
		Aadhar_number = aadhar_number;
	}


	public long getPhone_number() {
		return phone_number;
	}


	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}


	public String getBlood_group() {
		return blood_group;
	}


	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}


	public String getPersonal_email() {
		return personal_email;
	}


	public void setPersonal_email(String personal_email) {
		this.personal_email = personal_email;
	}


	public String getEmergency_contact_name() {
		return emergency_contact_name;
	}


	public void setEmergency_contact_name(String emergency_contact_name) {
		this.emergency_contact_name = emergency_contact_name;
	}




	public long getEmergency_contact_number() {
		return emergency_contact_number;
	}


	public void setEmergency_contact_number(long emergency_contact_number) {
		this.emergency_contact_number = emergency_contact_number;
	}
	
	
	
}
