import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		String[][] door = new String[10][];
		
		Scanner sc = new Scanner(System.in);
		
		
		
		for (int i = 0; i < door.length; i++) {
			
					door[i] = sc.nextLine().split(" ");
			
		}
	
		int x=1;
		int y=1;
		
		while(true) {
			if (door[x][y].equals("0")) {
				door[x][y]="9";
				y++;
			}else if(door[x][y].equals("1")){
				
				y--;
				x++;
				if(door[x][y].equals("1")) {
					
					break;
				}
			}else if(door[x][y].equals("2")) {
				door[x][y]="9";
				break;
			}
			
			
		}
		
		
		
		for (int k = 0; k < door.length; k++) {
			for (int a = 0; a < door.length; a++) {
				System.out.print(door[k][a] + " ");
			}
			System.out.println();
		}
		
	}

}



//for (int i = 1; i < door.length-1; i++) {
//	for (int j = 1; j < door.length-1; j++) {
//		
//		if (!door[i][j].equals("1")) {
//			door[i][j]="9";
//			if(door[i][j+1].equals("9")) {
//				door[i][j]="0";	
//			}
//		}
//		if (door[i-1][j].equals("9")) {
//			if (door[i][j+1].equals("1")) {
//				door[i+1][j]="9";
//			}
//			
//		}
//		if (door[i-1][j].equals("0")) {
//			door[i][j]="0";
//		}
//		if (door[i][j+1].equals("1")) {
//			door[i+1][j]="9";
//			j=9;
//		}
//		
//		if (door[i][j].equals("2")) {
//			door[i][j]="9";
//			j=9;
//			i=10;
//		}
//	}
//}
