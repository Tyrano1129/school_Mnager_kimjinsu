package School_김진수Ver3;

public class Subject {
	private int stuNo;
	private String subName;
	private int score;
	
	public Subject(int stuNo,String subName,int score){
		this.score = score;
		this.stuNo = stuNo;
		this.subName = subName;
	}

	@Override
	public String toString() {
		return "["+ subName + " " + score + "]";
	}
	

	public String data() {
		return stuNo+"/"+subName+"/"+score;
	}

	public int getStuNo() {
		return stuNo;
	}

	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}
