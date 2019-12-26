package study;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 두번 째로 큰 수 찾기
 * 제일 편한 방법은 list 에 옮긴 후 Comparator.reverseOrder() 로 하면 내림 차순정렬 이므로
 * list.get(1)을 하면 두번째로 큰 수를 얻을 수 있다.
 * 정렬 알고리즘을 이용하여 푸는 방법이 있으나 정렬 알고리즘은 내가 아직 익히지 못했다.
 */

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
