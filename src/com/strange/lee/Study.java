package com.strange.lee;

// 백준 사이트의 문제 풀이

import java.util.Scanner;

class Study {

    int count = 0;

    public static void main(String[] args) {
        int j = 7;
        for (int i = 0; i < j - 1; i = i + 2) {
            System.out.println(i + " ");
        }
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        System.out.println(new Study().divideNum(num));
    }

    // https://www.acmicpc.net/problem/1463
    // 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
    //
    // X가 3으로 나누어 떨어지면, 3으로 나눈다.
    // X가 2로 나누어 떨어지면, 2로 나눈다.
    // 1을 뺀다.
    // 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
    public int divideNum (int num) {
        count++;
        if (num > 1) {
            if (num % 3 == 0 || num % 3 == 1) {
                num /= 3;
            } else if (num % 2 == 0) {
                num /= 2;
            } else {
                num--;
            }
        } else {
            return count;
        }

        return divideNum(num);
    }

}
