package study;

/**
 * 길이가 같은 두 문자열(string) A 와 B가 주어지면, A 가 B 로 1:1 암호화 가능한지 찾으시오.
 *
 * Given two strings of equal length, check if two strings can be encrypted 1 to 1.
 */

public class Pattern1On1 {

    public Pattern1On1(String str1, String str2) {
        String results = "";
        System.out.println("before change Strings " + str1);
        for (int i = 0; i < str1.length(); i++) {
            System.out.println(str1.replace(str1.substring(i, i + 1) , str2.substring(i, i + 1)));
            System.out.println(str2.substring(i, i + 1));
            if (str1.replace(str1.substring(i, i + 1) , str2.substring(i, i + 1)).equals(str2.substring(i, i + 1))) {
                continue;
            } else {
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
    }

    public static void main(String[] args) {
        new Pattern1On1("EFF", "FOO");
    }

}
