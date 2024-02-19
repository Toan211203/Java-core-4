package vn.aptech;

import java.util.Scanner;

public class UppercaseText {

	public static void main(String[] args) {
		String getStr;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhap mot cau tren ban phim: ");
		getStr = sc.nextLine();
		System.out.println("Chuoi vua nhp la: " + getStr.toUpperCase());
	}

}
