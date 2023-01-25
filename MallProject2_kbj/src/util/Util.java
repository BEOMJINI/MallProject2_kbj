package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {
	public static Scanner sc = new Scanner(System.in);

	public static int getValue(int a, int b) {
		// Scanner sc = new Scanner(System.in);
		int val = -1;
		while (true) {
			try {
				System.out.print("# 선택 ->  ");
				val = sc.nextInt();
				if (val < a || val > b) {
					System.err.println(a + " ~ " + b + " 사이 값 입력");
					continue;
				}
			} catch (InputMismatchException e) {
				System.err.println("숫자값만 입력");
				sc.nextLine();
				continue;
			}
			return val;
		}
	}

	public static int getPrice() {
		int price = 0;
		while (true) {
			try {
				System.out.print("# Price ->  ");
				price = sc.nextInt();
				if (price <= 0) {
					System.out.println("0보다 큰 값 입력해주세요.");
					continue;
				}
				if (price % 100 != 0) {
					System.out.println("100원 단위 미만 절삭해주세요.");
					continue;
				}
			} catch (InputMismatchException e) {
				System.out.println("숫자만 입력 해주세요.");
				sc.nextLine();
				continue;
			}
			return price;
		}

	}
}
