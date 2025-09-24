package application;

import java.util.*;

public class Dictionary {

    private List<String> words;
    private Map<String, String> translations;
    private Random random;

    public Dictionary() {
        this.words = new ArrayList<>();
        this.translations = new HashMap<>();
        this.random = new Random();

        // example word to avoid empty dictionary at start
        add("palavra", "word");
    }

    public String get(String word) {
        return this.translations.get(word);
    }

    public void add(String word, String translation) {
        if (!this.translations.containsKey(word)) {
            this.words.add(word);
        }
        this.translations.put(word, translation);
    }

    public String getRandomWord() {
        if (this.words.isEmpty()) {
            return null;
        }
        return this.words.get(random.nextInt(this.words.size()));
    }

    public boolean isEmpty() {
        return this.words.isEmpty();
    }
}
