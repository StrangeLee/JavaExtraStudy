package sort;

public class H_Index {

    public int solution(int[] citations) {
        int answer = 0;
        int h_index = 1;

        for (int i = 0; i < citations.length; i++) {
            for (int j = 0; j < h_index; j++) {
                if (citations[j] == h_index) {
                    return h_index;
                } else {
                    h_index++;
                    if (h_index > citations.length) {
                        return 0;
                    }
                }
            }
        }
        
        return citations.length / 2;
    }

    public static void main(String[] args) {
        int [] citations = {3, 0, 6, 1, 5};
        System.out.println(new H_Index().solution(citations));
    }
}
