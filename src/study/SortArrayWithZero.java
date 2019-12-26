package study;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 정수 배열(int array)이 주어지면 0이 아닌 정수 순서를 유지하며 모든 0을 배열 오른쪽 끝으로 옮기시오. 단, 시간복잡도는 O(n), 공간복잡도는 O(1)여야 합니다.
 *
 * Given an integer array, move all the 0s to the right of the array without changing the order of non-zero elements.
 *
 * 배열을 돌려서 정렬을 하는데 list 로 해도되고, 배열로 한뒤 정렬을 해도 되지만
 * 나는 편의를 위해 list 를 사용했다.
 *
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
                3, 0, 3, 6, 4
        });
    }
}
