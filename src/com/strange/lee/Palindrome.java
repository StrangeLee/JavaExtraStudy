package com.strange.lee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Palindrome {

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
            System.out.println("Output : True" );
        }

    }

    public static void main(String[] args) {
        new Palindrome();
    }
}
