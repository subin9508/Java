package project.model;

public class CourseRegistrationCourse {
	private int courseNumber;
	private String courseTitle, teacher, classroom;
	
	/*
	public CourseRegistrationCourse() {}

	public CourseRegistrationCourse(String couresTitle, String teacher, String classroom) {
		this.courseTitle = couresTitle;
		this.teacher = teacher;
		this.classroom = classroom;
	}
	*/
	public int getCourseNumber() {
		return courseNumber;
	}
	public void setCourseNumber(int courseNumber) {
		this.courseNumber = courseNumber;
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
	@Override
	public String toString() {
		return "CourseRegisterationCourse [courseNumber=" + courseNumber + ", courseTitle=" + courseTitle
				+ ", teacher=" + teacher + ", classroom=" + classroom + "]";
	}
	
	
	

}
