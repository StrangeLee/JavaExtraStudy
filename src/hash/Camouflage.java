package hash;

import java.util.HashMap;

/**
 * 프로그래머스 코테 연습 > 해시 > 위장 문제 풀이
 *
 *  (A종류 가짓수 + 1) // 입을때 안입을때
 * * (B종류 가짓수 +1) //  연속적인 사건(매일 다른 옷으로라는 말에서 나옴)
 * - 1 // 안입는 경우는 없기 때문
 */
public class Camouflage {

    public int camouflage(String [][] clothes) {
        int answer = 1;
        HashMap<String, Integer> clothValue = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            if (clothValue.containsKey(clothes[i][1]))
                clothValue.put(clothes[i][1], clothValue.get(clothes[i][1]) + 1);
            else
                clothValue.put(clothes[i][1], 1);
        }

        for (int value:
             clothValue.values()) {
            answer *= (value +1);
        }

        return answer -1;
    }

    public static void main(String[] args) {
        String [][] cloths = {
                {"yellow_hat", "face"}, {"blue_sunglasses", "face"},
                {"green_turban", "face"}
        };
        System.out.println(new Camouflage().camouflage(cloths));
    }
}
