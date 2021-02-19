import java.util.Arrays;

public class CharArrayPart {

    public static void main(String[] args) {
        toSnakeCase();
        line();
        String s = new String();
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

    public static void line() {
        System.out.println("---------------------------------------");
    }
}
