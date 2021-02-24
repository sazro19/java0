package TextApp;

import java.io.IOException;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws IOException {
        TextService service = new TextService("Sorry. I have to run. See you later.\n Hello.\n My name is Sasha! What is your name?");
        System.out.println("""
                Список операций:
                1 - отсортировать параграфы;
                2 - отсортировать все предложения;
                3 - отсортировать слова в предложении по вхождению символа;
                4 - выход""");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    service.sortParagraphs();
                    break;
                case 2:
                    service.sortWordsInSentences();
                    break;
                case 3:
                    int ch = scanner.nextInt();
                    int s = scanner.nextInt();
                    char c = (char) System.in.read();
                    service.sortWordsByLetter(ch, s, c);
                case 4:
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}
