package com.strange.lee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindTargetNumber {
    // 정수 배열과 타겟 숫자가 주어지면, 합이 타겟값이 되는 두 원소의 인덱스를 찾으시오.
    // 단, 시간복잡도 O(n) 여야 합니다.
    //
    // Given an array of integers and a target integer, find two indexes of the array element that sums to the target number.

    int [] array;
    int target;
    String result = "";

    public FindTargetNumber(int [] array, int target) {
        this.array = array;
        this.target = target;
    }

    private void getTargetNumber() {
        for (int i = 0; i < array.length; i ++) {
            int sum = array[i];
            for (int num : array) {
                if (sum != num) {
                    sum += num;
                }
                if (sum == target) {
                    result += "{ " + array[i] + ", ";
                    result += num + " }";
                    System.out.println(result);
                    System.out.println("find target");
                }
                sum -= num;
            }
        }
    }

    public static void main(String[] args) {
        int [] array = {1, 2, 3, 4, 5, 6, 7};
        new FindTargetNumber(array, 10).getTargetNumber();
    }

}
