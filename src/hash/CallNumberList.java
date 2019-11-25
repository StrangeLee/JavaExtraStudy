package hash;

import java.util.HashMap;

public class CallNumberList {

    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, String> phoneMap = new HashMap<>();

        for (String phone :
                phone_book) {
            //phoneMap.put(phone, phoneMap.containsKey());
        }

        return answer = true;
    }

    public static void main(String[] args) {
        String [] phone_book  = {"123", "123789", "456"};
        System.out.println(new CallNumberList().solution(phone_book));
    }
}
