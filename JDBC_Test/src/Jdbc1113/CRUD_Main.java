package Jdbc1113;

import java.util.Scanner;

public class CRUD_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// CRUD
		// CREATE(생성)
		// READ(읽기), RETRIEVE(검색)
		// UPDATE(수정)
		// DELETE(삭제)

		//SQL문을 실행하기 위한 crud객체 선언
		CRUD_SQL crud = new CRUD_SQL();

		//학생 정보를 담아오는 STU 객체 선언
		CRUD_DTO stu = new CRUD_DTO();

		Scanner sc = new Scanner(System.in);

		boolean run = true;
		int menu = 0;

		while(run) {
			System.out.println("\n========================");
			System.out.println("1.DB접속  	2.DB해제");
			System.out.println("3.학생등록 	4.학생조회");
			System.out.println("5.학생정보수정 	6.학생삭제");
			System.out.println("0.종료");
			System.out.println("========================");
			System.out.print("메뉴선택 >> ");
			menu = sc.nextInt();

			switch (menu) {
			case 1:
				crud.connect();
				break;
			case 2:
				crud.conClose();
				break;
			case 3: // 학생등록
				System.out.println("학생 정보를 입력해주세요!");
				System.out.print("이름 >> ");
				//학생 이름을 입력받으면 바로 stu빈에 담아준다.
				stu.setStuName(sc.next());
				System.out.print("나이 >> ");
				//학생 나리를 입력받으면 바로 stu빈에 담아준다.
				stu.setStuAge(sc.nextInt());

				crud.stuJoin(stu);
				break;
			case 4:  // 학생조회
				System.out.println("\n========================");
				System.out.println();
				System.out.println("1.모든학생  2.개인정보");
				System.out.println();
				System.out.println("========================");
				System.out.print("메뉴선택 >> ");
				if(sc.nextInt()==1) {
					//학생 이름을 입력받으면 바로 stu빈에 담아준다.
					crud.select(stu);
				}
				else {
					System.out.println("\n학생 정보를 입력해주세요!");
					System.out.print("이름 >> ");
					stu.setStuName(sc.next());
					crud.select(stu);}
				break;
			case 5: 							 // 학생 정보보 수정
				System.out.println("\n========================");
				System.out.println("1.이름수정 	2.나이수정");
				System.out.println("3.전부수정		0.뒤로가기");
				System.out.println("\n========================");
				System.out.print("메뉴선택 >> ");
				int user =sc.nextInt();
				if (user==1) {					 // 이름만 수정
					System.out.println("\n학생 정보를 입력해주세요!");
					System.out.print("이름 >> ");
					String name = sc.next();
					System.out.print("변경할 이름 >> ");
					stu.setStuName(sc.next());

					crud.stmod(name,stu);
				}else if(user==2) { 			// 나이만 수정
					System.out.println("\n학생 정보를 입력해주세요!");
					System.out.print("이름 >> ");
					String name = sc.next();
					System.out.print("변경할 나이 >> ");
					stu.setStuAge(sc.nextInt());

					crud.stmod(name,stu);
					
				}else if(user==3) { 			// 둘다 수정
					System.out.println("\n학생 정보를 입력해주세요!");
					System.out.print("변경할 학생 이름 >> ");
					String name = sc.next();
					System.out.print("변경할 이름 >> ");
					stu.setStuName(sc.next());
					System.out.print("변경할 나이 >> ");
					stu.setStuAge(sc.nextInt());

					crud.stmod(name,stu);
				}
				
				
				

				break;
			case 6:  // 학생삭제
				System.out.println("삭제할 학생 정보를 입력해주세요!");
				System.out.print("이름 >> ");
				stu.setStuName(sc.next());

				crud.stdel(stu);
				break;
			case 0:
				run = false;
				System.out.println("시스템 종료!");
				break;

			default:
				break;
			}
		}


	}


	
}

















