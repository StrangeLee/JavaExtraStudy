package hash;

import java.util.*;

// 프로그래머스 - 코딩테스트 연습(해시) : 완주하지 못한 선수
public class IncompletionMarathon {

    public IncompletionMarathon() {

    }

    // list, hashset, hashmap 으로
    // 이 문제를 각 각 풀어 보았을 때
    // 모든 api 가 정확도는 얻어 내지만
    // hashmap 의 속도가 가장 빠르다.
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        // list 사용
        ArrayList<String> comp = new ArrayList<>();

        for (int i = 0; i < completion.length; i++) {
            comp.add(completion[i]);
        }

        for (int i = 0; i < participant.length; i++) {
            if (comp.contains(participant[i])) {
                comp.remove(participant[i]);
                participant[i] = "";
            }
        }

        for (String str :
                participant) {
            answer += str;
        }

        return answer;
    }

    // hash 사용
   /*
    HashSet<String> hash = new HashSet<>();

        for (int i = 0; i < completion.length; i++) {
            hash.add(completion[i]);
        }

        for (int i = 0; i < participant.length; i++) {
            if (hash.contains(participant[i])) {
                hash.remove(participant[i]);
                participant[i] = "";
            }
        }

        for (int i = 0; i < participant.length; i++) {
            answer += participant[i];
        }
    */

   // map
    /*
    HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion) hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }

     */

    public static void main(String[] args) {
        String [] a = {"가", "나", "다", "가"};
        String [] b = {"가", "나", "다"};
        System.out.println(new IncompletionMarathon().solution(a, b));
    }

}