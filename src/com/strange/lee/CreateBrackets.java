package com.strange.lee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateBrackets {
    // 정수 n이 주어지면, n개의 여는 괄호 "("와 n개의 닫는 괄호 ")"로 만들 수 있는 괄호 조합을 모두 구하시오.
    // (시간 복잡도 제한 없습니다).
    //
    // Given an integer N, find the number of possible balanced parentheses with N opening and closing brackets.

    List<String> outputList = new ArrayList<>();

    public CreateBrackets() {
        System.out.println("Input Integer");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println("Input : " + num);

        while(num > 0) {
            outputList.add("(");

            num --;
        }

    }

    public static void main(String[] args) {
        new CreateBrackets();
    }

}
