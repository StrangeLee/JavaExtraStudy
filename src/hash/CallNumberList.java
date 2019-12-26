package hash;

import java.util.Arrays;

/**
 * 프로그래머스 코테 연습 > 해시 > 전화번호 목록
 */

public class CallNumberList {

    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String [] phone_book  = {"123", "123789", "456"};
        System.out.println(new CallNumberList().solution(phone_book));
    }
}
