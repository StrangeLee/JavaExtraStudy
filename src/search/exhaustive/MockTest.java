package search.exhaustive;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MockTest {

    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        int answerCount = 0;
        List<Integer> list = new ArrayList<>();

        int [][] student = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5},
        };

        for (int i = 0; i < student.length; i++) {
            if (answerCount >= answers.length) {
                answerCount = 0;
            }
            // 정답 비교
            for (int j = 0; j < student[i].length; j++) {
                if (student[i][j] == answers[answerCount]) {
                    answer[i] += 1;
                }
                answerCount ++;
                if (answerCount >= answers.length) {
                    answerCount = 0;
                }
            }
        }

        // 점수 비교
        int big = answer[0];
        int bigCount = 0;
        for (int i = 0; i < answer.length; i++) {
            if (big <= answer[i]) {
                answer[i] = i + 1;
                list.add(i + 1);
            } else {
                answer[i] = 0;
            }
        }

        list.sort(Comparator.naturalOrder());
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int [] answers = {3, 5, 1, 2, 4};
        var results = new MockTest().solution(answers);
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i]);
        }
    }
}
