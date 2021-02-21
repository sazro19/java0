import java.io.IOException;
import java.util.Scanner;

public class StringPart {

    public static void main(String[] args) {
        System.out.println(maxSpaces("     ab b   cdzyzxc        cl o wn  ", 0));
        CharArrayPart.line();
        insertB(new StringBuilder("acadkac"));
        CharArrayPart.line();
        isPalindrome(new StringBuilder("abbab"));
        CharArrayPart.line();
        changeToCake();
        CharArrayPart.line();
        System.out.println(countA("abCdsafa +_aaasdfatzxcaaaa", 0));
        CharArrayPart.line();
        doubleEl("abcdzxcqwe123 +-_");
        CharArrayPart.line();
        // deleteRepeatsAndSpaces();
        // printTheLongest();
        // countLetters();
        countSentences("Hello. My name is zxc. I am dead inside. I am going to pick butcher on mid! Why are bulling" +
                " me for this?");
    }

    public static int maxSpaces(String s, int prev) {
        int count = 0;
        for (int i = s.indexOf(' '); i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                count++;
            } else {
                String str = s.substring(i);
                return maxSpaces(str, Math.max(count, prev));
            }
        }
        return Math.max(count, prev);
    }

    public static void insertB(StringBuilder s) {
        for (int i = s.indexOf("a"); i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                s.insert(i + 1, "b");
            }
        }
        System.out.println(s);
    }

    public static void isPalindrome(StringBuilder s) {
        System.out.println(s.toString().equals(s.reverse().toString()));
    }

    public static void changeToCake() {
        String str = "информатика";
        String cake = "";
        cake = str.charAt(str.indexOf('т')) + str.substring(3, 5) + str.charAt(str.indexOf('т'));
        System.out.println(cake);
    }

    public static int countA(String str, int count) {
        if (str.indexOf('a') != -1) {
            count += countA(str.substring(str.indexOf("a") + 1), count) + 1;
        }
        return count;
    }

    public static void doubleEl(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            result += str.charAt(i);
            result += str.charAt(i);
        }
        System.out.println(result);
    }

    public static void deleteRepeatsAndSpaces() {
        Scanner scanner = new Scanner(System.in);
        String s;
        s = scanner.nextLine();
        StringBuilder str = new StringBuilder(s);
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(j) == str.charAt(i) || str.charAt(j) == ' ') {
                    str.deleteCharAt(j);
                }
            }
        }
        System.out.println(str.toString());
    }

    public static void printTheLongest() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] strings = s.split(" ");
        int max = 0;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() > strings[max].length()) {
                max = i;
            }
        }
        System.out.println(strings[max]);
    }

    public static void countLetters() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int countLowerCase = 0;
        int countUpperCase = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((int) s.charAt(i) >= 97 && (int) s.charAt(i) <= 122) {
                countLowerCase++;
            }
            if ((int) s.charAt(i) >= 65 && (int) s.charAt(i) <= 90) {
                countUpperCase++;
            }
        }
        System.out.println("Количество заглавных букв: " + countUpperCase);
        System.out.println("Количество прописных букв: " + countLowerCase);
    }

    public static void countSentences(String x) {
        int count = 0;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == '.' || x.charAt(i) == '!' || x.charAt(i) == '?') {
                count++;
            }
        }
        System.out.println(count);
    }
}
