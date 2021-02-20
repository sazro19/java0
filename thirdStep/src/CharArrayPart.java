import java.util.Arrays;

public class CharArrayPart {

    public static void main(String[] args) {
        toSnakeCase();
        line();
        changeToLetter("abcdwordkoshpwordSfagry");
        line();
        figuresAmount("abcdqwrzxfg015 43asfsdf2a0");
        line();
        numbersAmount("abdc01023s 15d_+- d34s");
    }

    public static void toSnakeCase() {
        String[] camel = new String[]{"firstVar", "secondVar", "thirdVarLast"};
        String[] snake = camel;
        for (int i = 0; i < camel.length; i++) {
            String temp = "";
            for (int j = 0; j < camel[i].length(); j++) {
                if (Character.toUpperCase(camel[i].charAt(j)) == camel[i].charAt(j)) {
                    temp += "_";
                    temp += Character.toLowerCase(camel[i].charAt(j));
                } else {
                    temp += camel[i].charAt(j);
                }
            }
            snake[i] = temp;
        }
        System.out.println(Arrays.toString(snake));
    }

    public static void changeToLetter(String s) {
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'w' && i <= s.length() - 4) {
                if (s.charAt(i + 1) == 'o') {
                    if (s.charAt(i + 2) == 'r') {
                        if (s.charAt(i + 3) == 'd') {
                            temp += "letter";
                            if (i + 4 < s.length()) {
                                i += 4;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
            temp += s.charAt(i);
        }
        s = temp;
        System.out.println(s);
    }

    public static void figuresAmount(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isFigure(s.charAt(i))) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean isFigure(char c) {
        return (int) c >= 48 && (int) c <= 57;
    }

    public static void numbersAmount(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isFigure(s.charAt(i))) {
                if (s.charAt(i) == '0'){
                    count++;
                    continue;
                }
                for (int j = i; j < s.length(); j++) {
                    if (!isFigure(s.charAt(j)) || j == s.length() - 1) {
                        count++;
                        i = j;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }

    public static void line() {
        System.out.println("---------------------------------------");
    }
}
