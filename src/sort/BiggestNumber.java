package sort;

import java.util.*;

public class BiggestNumber {

    public String solution(int[] numbers) {
        String answer = "";
        List<Integer> list = new ArrayList<>();
        int[] arrays = numbers;

        for (int i = 0; i < (numbers.length * (numbers.length - 1)); i++) {
            for (int j = 0; j < numbers.length; j++) {
                Random ran = new Random();
                for (int k = 0; k < j; k++) {
                    arrays[j] = numbers[ran.nextInt(numbers.length)];
                    if (arrays[k] == arrays[j])
                        j--;
                    else {
                        answer += arrays[j];
                        System.out.println("j : " + j + " value : " + arrays[j]);
                    }
                }
                //answer += numbers[ran.nextInt(numbers.length) + 0];
            }
            list.add(Integer.parseInt(answer));
            answer = "";
        }
        System.out.println("_______________________________");

        for (int num:
             list) {
            System.out.println(num);
        }
        
        return answer;
    }

    public static void main(String[] args) {
        int [] array = {6, 10, 2};
        System.out.println(new BiggestNumber().solution(array));
    }
}
