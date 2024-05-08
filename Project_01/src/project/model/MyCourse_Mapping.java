package project.model;

public class MyCourse_Mapping {
	private String id, name, courseTitle, teacher, classroom;
	private int courseNumber;
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
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	public int getCourseNumber() {
		return courseNumber;
	}
	public void setCourseNumber(int courseNumber) {
		this.courseNumber = courseNumber;
	}
	@Override
	public String toString() {
		return "MyCourse_Mapping [id=" + id + ", name=" + name + ", courseTitle=" + courseTitle + ", teacher=" + teacher
				+ ", classroom=" + classroom + ", courseNumber=" + courseNumber + "]";
	}
	
	
}
