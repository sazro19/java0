package association.text;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Text {

    private List<Sentence> sentences;

    private String head;

    public Text(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public Text(String text) {
        Pattern pattern = Pattern.compile("(\\. ?)|(! ?)|(\\n *)|(\\? ?)");
        String[] strings = pattern.split(text);
        List<Sentence> sentences = new ArrayList<>();
        for (String s : strings) {
            Sentence sentence = new Sentence(s);
            sentences.add(sentence);
        }
        this.sentences = sentences;
    }

    public Text(String head, String text) {
        this(text);
        this.head = head;
    }

    public void addToText(String text) {
        Text newText = new Text(text);
        sentences.addAll(newText.getSentences());
    }

    public void printText() {
        System.out.println(head);
        for (Sentence sentence : sentences) {
            System.out.println(sentence.toString());
        }
    }

    public void printHead() {
        try {
            if (head != null) {
                System.out.println(head);
            } else {
                throw new NullPointerException("Text haven't head!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public static void main(String[] args) {
        Text text = new Text("Head", "Hello. I am student! My name is Alex.");
        text.printText();
        text.printHead();
    }
}
