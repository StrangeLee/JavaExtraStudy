package stack_que;

import java.util.HashMap;

/**
 * 프로그래머스 코테 연습 > 스택/큐 < 프린터 문제 풀이
 * 알고리즘
 *
 * 배열로 받은 숫자들을 비교해서 가장 큰 수 구하기
 * 전체 배열 length - 가장 큰 수 +
 *
 *
 */
public class Printer {

    public int solution(int[] priorities, int location) {
        HashMap<Integer, Integer> items = new HashMap<>();

        int bigNum = 0;
        int bigIndex = 0;
        for (int i = 0; i < priorities.length; i++) {
            items.put(i, priorities[i]);
            if (bigNum < priorities[i]) {
                bigNum = priorities[i];
                bigIndex = i;
            }
        }

        if (location == bigIndex) {
            return 1;
        } else {
            return items.size() - bigIndex + (location + 1);
        }
    }

    public static void main(String[] args) {
        int[] priorities = {
                5, 3, 5, 6, 8, 4
        };
        // 8
        int location = 2;
        var result = new Printer().solution(priorities, location);
        System.out.println(result);
    }
}
