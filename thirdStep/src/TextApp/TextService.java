package TextApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
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
        for (Paragraph par : paragraphs) {
            System.out.println(par.getSentences().toString());
        }
    }

    public void sortWordsInSentences() {
        for (Paragraph paragraph : paragraphs) {
            paragraph.sortWords();
        }
    }

    public void sortWordsByLetter(int paragraphNumber, int sentenceNumber, char letter) {
        Pattern pattern = Pattern.compile("( )|(, )|(: )|( - )|(; )");
        String[] sentence = pattern.split(paragraphs.get(paragraphNumber).getSentences().get(sentenceNumber));
        for (int i = 0; i < sentence.length; i++) {
            for (int j = 0; j < sentence.length - 1; j++) {
                if (countLetter(sentence[j], letter) < countLetter(sentence[j + 1], letter)) {
                    String temp = sentence[j];
                    sentence[j] = sentence[j + 1];
                    sentence[j + 1] = temp;
                } else if (countLetter(sentence[j], letter) == countLetter(sentence[j + 1], letter)) {
                    if (Character.toLowerCase(sentence[j].charAt(0)) > Character.toLowerCase(sentence[j + 1].charAt(0))) {
                        String temp = sentence[j];
                        sentence[j] = sentence[j + 1];
                        sentence[j + 1] = temp;
                    }
                }
            }
        }
        String result = "";
        for (String s : sentence) {
            result += s + " ";
        }
        System.out.println(result);
        paragraphs.get(paragraphNumber).getSentences().set(sentenceNumber, result);

    }

    private int countLetter(String string, char letter) {
        Pattern pattern = Pattern.compile(String.valueOf(letter));
        Matcher matcher = pattern.matcher(string);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}

class Paragraph {

    private List<String> sentences = new ArrayList<>();

    private final int size;

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
