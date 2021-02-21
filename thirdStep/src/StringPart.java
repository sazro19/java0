public class StringPart {

    public static void main(String[] args) {
        System.out.println(maxSpaces("     ab b   cdzyzxc        cl o wn  ", 0));
        CharArrayPart.line();
        insertB(new StringBuilder("acadkac"));
        CharArrayPart.line();
        isPalindrome(new StringBuilder("abbab"));
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
}
