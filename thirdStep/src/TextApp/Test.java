package TextApp;

import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        TextService service = new TextService("Sorry. I have to run. See you later.\n Hello.\n My name is Sasha! What is your name?");
        service.sortSentences();
    }
}
