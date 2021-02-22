package TextApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

public class TextService {

    private String text = "";

    private List<Paragraph> paragraphs = new ArrayList<>();

    TextService(String text) {
        this.text = text;
        Pattern pattern = Pattern.compile("\\n ?");
        String[] pars = pattern.split(text);
        for (String el : pars) {
            paragraphs.add(new Paragraph(el));
        }
    }

    public void sortParagraphs() {
        paragraphs.sort(Comparator.comparing(Paragraph::getSize));

    }

    public void sortSentences() {
        for (int i = 0; i < paragraphs.size(); i++) {
            paragraphs.get(i).sortWords();
        }
    }

    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }

}

class Paragraph {

    private List<String> sentences = new ArrayList<>();

    private int size;

    Paragraph(String par) {
        Pattern pattern = Pattern.compile("(\\. ?)|(\\? ?)|(\\! ?)|(\\.\\.\\. ?)");
        String[] sens = pattern.split(par);
        sentences = Arrays.asList(sens);
        this.size = sentences.size();
    }

    public void sortWords() {
        Pattern pattern = Pattern.compile("( )|(, )|(: )|( - )|(; )");
        for (int i = 0; i < sentences.size(); i++) {
            List<String> temp = Arrays.asList(pattern.split(sentences.get(i)));
            temp.sort(Comparator.comparing(String::length));
            String str = "";
            for (String el : temp) {
                str += el + " ";
            }
            sentences.set(i, str);
            System.out.println(sentences.get(i));
        }
    }

    public List<String> getSentences() {
        return sentences;
    }

    public int getSize() {
        return size;
    }
}
