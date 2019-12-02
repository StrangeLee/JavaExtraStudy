package study;

import java.util.ArrayList;
import java.util.Comparator;

public class FindSecondBigNumber {

    public FindSecondBigNumber(int [] array) {
        var numList = new ArrayList<Integer>();
        int bigNum = array[0];

        // 가장 큰수 찾기
        for (int num :
             array) {
            if (bigNum < num) {
                bigNum = num;
            }
        }

        // 가장 큰수를 제외한 수를 ArrayList 로 옮긴후
        // 정렬로 큰수 추출
        for (int num :
                array) {
            if (num != bigNum)
                numList.add(num);
        }

        if (numList.size() != 0) {
            numList.sort(Comparator.reverseOrder());
            System.out.println("second big num is " + numList.get(0));
        } else {
            System.out.println("Does not exists.");
        }

    }

    public static void main(String[] args) {
        var array = new int[]{
                3, 3, 3, 3, 3
        };
        new FindSecondBigNumber(array);
    }
}
