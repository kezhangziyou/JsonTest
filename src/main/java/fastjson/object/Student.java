package fastjson.object;

/**
 * @author zhangke
 * @version 1.0
 * @className Student
 * @description
 * @date 2020/11/13 10:14
 **/
 public   class  Student {
	private String studentName;

	private String studentAge;

	/**
	 * 必须要无参构造器
	 */
	public Student() {
	}

	public Student(String studentName, String studentAge) {
		this.studentName = studentName;
		this.studentAge = studentAge;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(String studentAge) {
		this.studentAge = studentAge;
	}

	@Override
	public String toString() {
		return "Student{" +
				"studentName='" + studentName + '\'' +
				", studentAge='" + studentAge + '\'' +
				'}';
	}
}
