package stack_que;

import java.util.*;

public class DevelopedFunction {

    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new ArrayDeque<>();
        int[] answer = {};
        int[] distribute = new int[progresses.length];
        int[] results = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
            int count = 0;
            System.out.println("Enter while when i is " + i);
            while (progresses[i] >= 100) {
                count++;
                System.out.println(count);

                progresses[i] += speeds[i];
            }
            distribute[i] = count;
        }

        int temp = distribute[0];
        for (int i = 1; i < distribute.length; i++) {
            if (temp > distribute[i]) {
                results[i - 1] += 1;
            } else {
                results[i = 1] = 1;
                temp = distribute[i];
            }
        }

        return results;
    }

    public static void main(String[] args) {
        int [] progresses = {93, 30, 55};
        int [] speeds = {1, 30, 5};
        int [] results = new DevelopedFunction().solution(progresses, speeds);

        for (int num :
             results) {
            System.out.println(num);
        }
    }

}
