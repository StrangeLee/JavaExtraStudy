package search.exhaustive;

public class MockTest {

    public int[] solution(int[] answers) {
        int[] answer = new int[3];

        int[] a = {1, 2, 3, 4, 5};
        int[] b = {1, 3, 4, 5}; // 숫자 앞뒤로 2가 들어감
        int[] c = {3, 1, 2, 4, 5}; // 2번씩 반복

        for (int i = 0; i < a.length; i++) {
            if (answers[i] == a.length)
                answer[0] += 1;
        }

        for (int i = 0; i < b.length * 2; i++) {
            if (answer[i])
        }

        return answer;
    }

    public static void main(String[] args) {
        int [] answers = {1, 2, 3, 4, 5};
        new MockTest()
    }
}
