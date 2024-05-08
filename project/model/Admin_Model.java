package project.model;

public class Admin_Model {
private String id, password;

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

@Override
public String toString() {
	return "Admin_Model [id=" + id + ", password=" + password + "]";
}





}
