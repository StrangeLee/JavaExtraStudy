package study;

import java.util.*;

/**
 * 정수 배열(int array)과 정수 N이 주어지면, N번째로 큰 배열 원소를 찾으시오.
 *
 * Given an integer array and integer N, find the Nth largest element in the array.
 */
public class N_Number {

    public N_Number(int [] array, int n) {
        List<Integer> list = new ArrayList();
        for (int num :
                array) {
            list.add(num);
        }

        list.sort(Comparator.reverseOrder());

        System.out.println(n + "번째 수는 " + list.get(n - 1));
    }

    public static void main(String[] args) {
        int [] array = {5, 2, -1, 9, 4, 7};
        int n = 3;
        new N_Number(array, n);
    }
}
