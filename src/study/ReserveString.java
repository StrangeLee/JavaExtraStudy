package study;

import java.util.Scanner;

/**
 * 문자열을 입력 받으면
 * 입력 받은 문자열을 거꾸로 출력
 *
 * String.charAt 과 for 문을 str.length() 부터 -- 하면 간단하게
 * 해결 가능
 */

public class ReserveString {

    public ReserveString(String str) {
        String reserve = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reserve += str.charAt(i);
        }
        System.out.println(reserve);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new ReserveString(sc.next());
    }

}
