package School_김진수Ver3;
/*
 	무조건 파일 업로드 먼저
 	
 	처음부터 우리 데이터가 연결된 상태
 */
public class Controller {

	private StudentDAO stuDAO;
	private SubjectDAO subDAO;
	public Controller(){
		stuDAO = new StudentDAO();
		subDAO = new SubjectDAO();
		Util.fileload(stuDAO, subDAO);
	}
	private void mainMenu() {
		while(true) {
			Util.menuPrint();
			int sel = Util.getValue("메뉴선택 : ",0,8);
			if(sel == 1) {
				System.out.println("[학생추가]");
				stuDAO.studentJoin();
			}else if(sel == 2) {
				System.out.println("[학생삭제]");
				stuDAO.studentDelete(subDAO);
			}else if(sel == 3) {
				System.out.println("[학생의과목추가]");
				subDAO.subjectJoin(stuDAO);
			}else if(sel == 4) {
				System.out.println("[학생의과목삭제]");
				subDAO.subjectDelete(stuDAO);
			}else if(sel == 5) {
				System.out.println("[전체학생목록]");
				stuDAO.studentAllprint(subDAO);
			}else if(sel == 6) {
				System.out.println("[과목별학생목록]");
				subDAO.subjectprint(stuDAO);
			}else if(sel == 7) {
				System.out.println("[파일 저장]");
				Util.fileSave(stuDAO, subDAO);
			}else if(sel == 8) {
				System.out.println("[파일 로드]");
				Util.fileload(stuDAO, subDAO);
			}else if(sel == 0) {
				System.out.println("종료...");
				break;
			}
		}
		
	}
	public void run() {
		mainMenu();
		Util.scanClose();
	}

}
