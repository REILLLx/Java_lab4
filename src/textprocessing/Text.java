package textprocessing;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас для представлення тексту.
 */
public class Text {
    private final List<Sentence> sentences;

    /**
     * Конструктор для створення тексту з рядка.
     *
     * @param text Рядок, який представляє текст.
     */
    public Text(String text) {
        this.sentences = new ArrayList<>();
        String normalizedText = text.replaceAll("[ \t]+", " ");
        String[] sentencesArray = normalizedText.split("(?<=[.!?])\\s*");
        for (String sentence : sentencesArray) {
            this.sentences.add(new Sentence(sentence.trim()));
        }
    }

    /**
     * Повертає список речень.
     *
     * @return Список об'єктів Sentence.
     */
    public List<Sentence> getSentences() {
        return sentences;
    }

    /**
     * Повертає слова, які починаються з голосних і містять більше ніж 1 літеру.
     *
     * @return Список об'єктів Word.
     */
    public List<Word> getVowelStartingWords() {
        String vowels = "АЕЄИІЇОУЮЯаеєиіїоуюя";
        List<Word> vowelWords = new ArrayList<>();
        for (Sentence sentence : sentences) {
            for (Object component : sentence.getComponents()) {
                if (component instanceof Word) {
                    Word word = (Word) component;
                    if (!word.toString().isEmpty() &&
                            vowels.indexOf(word.toString().charAt(0)) != -1 &&
                            word.toString().length() > 1) { // Враховуємо лише слова з двома літерами і більше
                        vowelWords.add(word);
                    }
                }
            }
        }
        return vowelWords;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Sentence sentence : sentences) {
            result.append(sentence.toString()).append(" ");
        }
        return result.toString().trim();
    }
}
