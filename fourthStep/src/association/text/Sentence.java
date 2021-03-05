package association.text;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Sentence {

    private List<Word> sentence;

    Sentence(List<Word> words) {
        sentence = words;
    }

    Sentence(String sentence) {
        Pattern pattern = Pattern.compile("( )|(, )|( = )|(: )|(; )");
        String[] words = pattern.split(sentence);
        List<Word> sen = new ArrayList<>();
        for (String w : words) {
            Word word = new Word(w);
            sen.add(word);
        }
        this.sentence = sen;
    }

    @Override
    public String toString() {
        List<String> words = new ArrayList<>();
        for (Word word : sentence) {
            words.add(word.getWord());
        }
        return words.toString();
    }

    public List<Word> getSentence() {
        return sentence;
    }
}
