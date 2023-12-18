package School_김진수Ver3;

public class Student {
	private int stuNo;
	private String stuName;
	private String stuId;
	
	public Student(int stuNo,String stuName,String stuId){
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.stuId = stuId;
	}

	@Override
	public String toString() {
		return "[" + stuNo + " " + stuName + " " + stuId + "]";
	}
	
	public String data() {
		return stuNo+"/"+stuName+"/"+stuId;
	}

	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public int getStuNo() {
		return stuNo;
	}

	public String getStuName() {
		return stuName;
	}

	public String getStuId() {
		return stuId;
	}
	
	
}
