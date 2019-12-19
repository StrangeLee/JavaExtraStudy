package sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 프로그래머스 코테 연습 > 정렬 > K번째 수
 * 알고리즘 설명
 * 주어진 문제에서 commands[][]의 2번째 index 의 사이즈는 항상 3이고
 * commands[?][3] 의 0은 시작 인덱스, 1은 마지막 인덱스, 2는 찾는 범위 이다.
 * 중간에 정렬이 필요 함으로 편의를 위해 list 를 사용했다.
 * 여기서 중요한 것은 인덱스의 관계? 범위? 와 list를 초기화 시켜줘야하는 것이다.
 */

public class NumberK {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < commands.length; i++) {
            for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                list.add(array[j]);
            }
            list.sort(Comparator.naturalOrder());
            answer[i] = list.get(commands[i][2] - 1);
            list.clear();
        }

        return answer;
    }

    public static void main(String[] args) {
        int array[] = {1, 5, 2, 6, 3, 7, 4};
        int commands [][] = {
                {2, 5, 3}, {4, 4, 1}, {1, 7, 3}
        };
        var results = new NumberK().solution(array, commands);
        for (int i = 0; i < results.length; i++) {
            System.out.print(results[i] + " ");
        }
        System.out.println();
    }
}
