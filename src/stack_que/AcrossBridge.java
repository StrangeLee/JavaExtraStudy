package stack_que;

import java.util.Stack;

public class AcrossBridge {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int nowWeight = 0;

        for (int i = 0; i < truck_weights.length; i++) {
            for (int j = 0; j < bridge_length; j++) {
                nowWeight += truck_weights[i];
                if (nowWeight >= weight) {

                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int [] truck_weights = {7, 4, 5, 6};
        System.out.println(new AcrossBridge().solution(bridge_length, weight, truck_weights));
    }
}
