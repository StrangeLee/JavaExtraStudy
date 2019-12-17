package study;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 정수 배열(int array)이 주어지면 0이 아닌 정수 순서를 유지하며 모든 0을 배열 오른쪽 끝으로 옮기시오. 단, 시간복잡도는 O(n), 공간복잡도는 O(1)여야 합니다.
 *
 * Given an integer array, move all the 0s to the right of the array without changing the order of non-zero elements.
 */
public class SortArrayWithZero {

    static int zeroCount = 0;

    public SortArrayWithZero(int [] array) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0)
                zeroCount++;
            else
                list.add(array[i]);
        }
        list.sort(Comparator.naturalOrder());
        list.sort(Comparator.reverseOrder());

        for (int i = 0; i < zeroCount; i++) {
            list.add(0);
        }

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            str.append(list.get(i));
            if (i < list.size() -1) {
                str.append(", ");
            }
        }

        System.out.println(str);
    }

    public static void main(String[] args) {
        new SortArrayWithZero(new int[]{
                3, 0, 3
        });
    }
}
