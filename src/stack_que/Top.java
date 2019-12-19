package stack_que;

import java.util.Stack;

/**
 * 프로그래머스 코테 연습 > 스택/큐 > 탑
 * 알고리즘
 *
 */

public class Top {

    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        int top = 0;
        int removeTop = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            stack.push(heights[i]);
        }

        for (int i = heights.length; i > 0; i--) {
            top = stack.pop();
            removeTop = top;
            if (top > stack.peek()) {
                answer[i - 1] = stack.indexOf(stack.peek());
            } else {
                stack.push(removeTop);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int [] items = {
                6,9,5,7,4
        };
        var answer = new Top().solution(items);
        for (int i = 0; i < items.length; i++) {
            System.out.print(answer[i] + " ");
        }
        System.out.println();
    }
}
