package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Palindrome {
    // 문제 : 정수(int)가 주어지면, 팰린드롬(palindrome)인지 알아내시오.
    //        팰린드롬이란, 앞에서부터 읽으나 뒤에서부터 읽으나 같은 단어를 말합니다.
    //        단, 정수를 문자열로 바꾸면 안됩니다.
    List<Integer> numList = new ArrayList<>();

    public Palindrome() {
        System.out.println("Input any number");
        Scanner scanner = new Scanner(System.in);

        int inputNum = scanner.nextInt();
        System.out.println("Input : " + inputNum);

        int i = 10;
        int num = inputNum;
        while (num > 0) {
            num = inputNum % i;
            inputNum /= i;
            numList.add(num);
        }
        numList.remove(numList.size() - 1); // 마지막 인덱스에 0이 들어가는걸 지워줌

        for(i = 0; i < numList.size(); i++) {
            if (numList.get(numList.size() - 1) == numList.get(0)) {
                numList.remove(numList.size() - 1);
                numList.remove(0);
            } else {
                System.out.println("Output : false");
                break;
            }
        }
        if (numList.size() == 0 || numList.size() == 1) {
            System.out.println("Output : True");
        }

    }

    public static void main(String[] args) {
        new Palindrome();
    }
}
