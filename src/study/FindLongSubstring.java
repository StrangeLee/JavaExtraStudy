package study;

import java.util.ArrayList;
import java.util.List;

/**
 * String이 주어지면, 중복된 char가 없는 가장 긴 서브스트링 (substring)의 길이를 찾으시오.
 *
 * Given a string, find the longest substring that does not have duplicate characters.
 *
 * 첫번째 인덱스의 값과 같은 string 비교 후 split, 만약 모두 같으면 바로 반환
 * 아니면 두번째 인덱스까지 비교(반복).
 */

public class FindLongSubstring {

    public FindLongSubstring(String str) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            String nowString = str.substring(i, i+1);
            for (int j = i; j < str.length(); j++) {
                if (nowString.equals(str.substring(j, j + 1))) {
                    System.out.println("it is same " + nowString);
                }
            }
        }
        for (String s:
             list) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        new FindLongSubstring("aabcbcbc");
    }
}
