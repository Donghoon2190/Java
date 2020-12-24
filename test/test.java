package test;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Scanner sc = new Scanner(System.in);
	        int star = 0;
	        while(true) {
	            System.out.println("홀수를 입력해주세요");
	            System.out.print("입력숫자 >> ");
	            star = sc.nextInt();
	            if(star%2 == 1) break;
	        }

	        for (int i = star; i > 0; i=i-2) {
	            for (int j = (i-1)/2; j > 0; j--) {
	                System.out.print(" ");
	            }
	            for (int j = star - (i-1); j > 0; j--) {
	                System.out.print("*");
	            }
	            System.out.println();
	        }

	        for (int i = 2; i < star; i=i+2) {
	            for (int j = (i/2); j > 0; j--) {
	                System.out.print(" ");
	            }
	            for (int j = star-i; j > 0; j--) {
	                System.out.print("*");
	            }

	            System.out.println();
	        }
		
		}
		
	}



//for (int i = 0; i < 5; i++) {
//	switch (i) {
//	case 0:
//		System.out.println("    *");
//		break;
//	case 1:
//		System.out.println("   ***");
//		break;
//	case 2:
//		System.out.println("  *****");
//		break;
//	case 3:
//		System.out.println(" *******");
//		break;
//	case 4:
//		System.out.println("*********");
//		break;
//	}
//    for (int y = 0; y < 5; y++) {
//    	
//  
//        for (int j = 1; j < 5-y; j++) {
//            System.out.print(" ");
//        }
//        for (int k = 0; k < y*2+1; k++) {
//            System.out.print("*");
//        }
//        System.out.println();
//    }
