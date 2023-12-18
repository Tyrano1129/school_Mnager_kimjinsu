package School_김진수Ver3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SubjectDAO {
	private ArrayList<Subject> subList;
	public SubjectDAO(){
		subList = new ArrayList<Subject>();
	}
	public void init(String data) {
		String[] temp = data.split("\n");
		
		for(int i =0; i < temp.length; i+=1) {
			String[] info = temp[i].split("/");
			subList.add(new Subject(Integer.parseInt(info[0]),info[1],Integer.parseInt(info[2])));
		}
		
	}
	
	public void print() {
		for(Subject s : subList) {
			System.out.println(s);
		}
	}
	public void numberPrint(int number) {
		for(Subject s : subList) {
			if(number == s.getStuNo()) {
				System.out.print(s);				
			}
		}
		System.out.println();
	}
	//학생삭제후 과목삭제
	public void stuOnesubjectDelete(int num) {
		if(subList.size() == 1) {
			subList = null;
		}else {
			for(int i = 0; i < subList.size(); i+=1) {
				if(subList.get(i).getStuNo() == num) {
					subList.remove(i);
					i-=1;
				}
			}
		}
	}
	public int stuOneSubjectCnt(int number) {
		int cnt = 0;
		for(int i = 0; i < subList.size(); i+=1) {
			if(number == subList.get(i).getStuNo()) {
				cnt+=1;
			}
		}
		return cnt;
	}
	public int checkSubject(int number,String name) {
		for(int i = 0; i < subList.size(); i+=1) {
			if(subList.get(i).getStuNo() == number && subList.get(i).getSubName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	//과목 추가
	public void subjectJoin(StudentDAO stu) {
		Random read = new Random();
		int number = stu.studentNumber();
		String subName = Util.getValueString("과목 입력 : ");
		int idx = checkSubject(number,subName);
		if(idx != -1) {
			System.out.println("중복된 과목입니다.");
			return;
		}
		subList.add(new Subject(number,subName,read.nextInt(50)+51));
		stu.numberprint(number);
		numberPrint(number);
	}
	//과목 삭제
	public void subjectDelete(StudentDAO stu) {
		int number = stu.studentNumber();
		if(stuOneSubjectCnt(number) ==  0) {
			System.out.println("가지고 있는 과목이없습니다.");
			return;
		}
		String subName = Util.getValueString("과목 입력 : ");
		int idx = checkSubject(number,subName);
		if(idx == -1) {
			System.out.println("입력한 과목은 없습니다.");
			return;
		}
		subList.remove(idx);
		stu.numberprint(number);
		numberPrint(number);
	}
	//학생별 점수 평균계산
	public double stuAllprint(Student stu) {
		double sum = 0;
		int cnt = 0;
		for(int i = 0; i < subList.size(); i+=1) {
			if(stu.getStuNo() == subList.get(i).getStuNo()) {
				sum += subList.get(i).getScore();
				cnt+=1;
			}
		}
		return sum == 0? 0 : (sum * 1.0)/cnt;
	}
	//입력후 과목있는지 확인후 담기
	public ArrayList<Subject> subjectOneList(String name) {
		ArrayList<Subject> temp = new ArrayList<Subject>();
		for(int i = 0; i < subList.size(); i+=1) {
			if(subList.get(i).getSubName().equals(name)) {
				temp.add(subList.get(i));
			}
		}
		return temp;
	}
	//과목 입력후 학생데이터에 전달
	public void subjectprint(StudentDAO stu) {
		String name = Util.getValueString("과목입력 : ");
		ArrayList<Subject> temp = subjectOneList(name);
		if (temp.size() == 0) {
			System.out.println("입력하신 과목은 없습니다.");
			return;
		}
		stu.subjectAllstuprint(temp, name);
	}
	

	public String subdata() {
		if(subList == null) return null;
		String data = "";
		for(int i = 0; i < subList.size(); i+=1) {
			data += subList.get(i).data() + "\n";
		}
		return data;
	}
}
