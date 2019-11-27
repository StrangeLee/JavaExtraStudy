package study;

import java.util.Scanner;

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
