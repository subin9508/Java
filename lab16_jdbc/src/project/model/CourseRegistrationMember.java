package project.model;

public class CourseRegistrationMember {
	
	private int userNumber;
	private String id;
	private String name;
	private String password;
	private String phone;
	private String email;
	
	public CourseRegistrationMember() {}
	
	public CourseRegistrationMember(String id, String name, String password, String phone, 
			String email) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.email = email;
	}


	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "CourseRegisteration [userNumber=" + userNumber + ", id=" + id + ", name=" + name + ", password="
				+ password + ", phone=" + phone + ", email=" + email + "]";
	}

	
	
	

}
