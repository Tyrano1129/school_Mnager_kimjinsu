package School_김진수Ver3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Util {
	
	private static Scanner scan= new Scanner(System.in);
	final private static String CUR_PATH = System.getProperty("user.dir") + "\\src\\" + new Util().getClass().getPackageName() + "\\";
	
	public static void scanClose(){
		scan.close();
	}
	public static void menuPrint() {
		System.out.println("[1]학생추가"); // 학번(1001) 자동증가 : 학생id 중복 불가
		System.out.println("[2]학생삭제"); // 학생 id 입력후 삭제 과목도 같이 삭제
		System.out.println("[3]학생의과목추가"); // 점수 랜덤 50 - 100 : 과목이름 중복 저장 불가능
		System.out.println("[4]학생의과목삭제"); // 학번 입력후 과목 이름 받아서 해당 과목 에서 학생1명 삭제
		System.out.println("[5]전체학생목록"); // 점수로 (오름차순) 출력
		System.out.println("[6]과목별학생목록"); // 과목이름 입력 받아서 해당 과목 학생 이름과 과목점수 출력 (오름차순)4
		System.out.println("[7] 파일 저장");
		System.out.println("[8] 파일 로드");
		System.out.println("[0] 종    료");
	}
	
	public static int getValue(String msg,int start,int end) {
		int num = 0;
		System.out.println(msg);
		while(true) {
			try {
				num = scan.nextInt();
				if(num < start || num > end) {
					System.out.printf("[%d] ~ [%d] 사이의 입력%n",start,end);
					continue;
				}
				return num;
			}catch(Exception e) {
				System.out.println("숫자만 입력해주세요.");
			}finally {
				scan.nextLine();
			}
		}
	}
	
	public static String getValueString(String msg) {
		System.out.println(msg);
		return scan.next();
	}
	
	private static String file(String fileName) {
		if(!fileCheck(fileName)) {
			return null;
		}
		String data = "";
		try(FileReader fr = new FileReader(CUR_PATH+fileName);
			BufferedReader br = new BufferedReader(fr)){
			while(true) {
				String rd = br.readLine();
				if(rd == null) break;
				data += rd +"\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public static boolean fileCheck(String fileName) {
		File file = new File(CUR_PATH+fileName);
		if(file.exists()) {
			return true;
		}
		return false;
	}
	
	public static void fileload(StudentDAO stu, SubjectDAO sub) {
		String studata = file("student.txt");
		String subdata = file("subject.txt");
		if(studata != null) {
			stu.init(studata);
		}
		if(subdata != null) {
			sub.init(subdata);
		}
	}
	private static void save(String filename,String data) {
		try(FileWriter fw = new FileWriter(CUR_PATH + filename);){
			fw.write(data);
			System.out.printf("%s 파일 저장 성공%n",filename);
		} catch (IOException e) {
			System.out.printf("%s 파일 저장 실패%n",filename);
		}
	}
	public static void fileSave(StudentDAO stu, SubjectDAO sub) {
		String studata = stu.studata();
		String subdata = sub.subdata();
		
		save("student.txt",studata);
		save("subject.txt",subdata);
	}
}
