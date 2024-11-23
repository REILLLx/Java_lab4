package textprocessing;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас для представлення речення.
 */
public class Sentence {
    private final List<Object> components;

    /**
     * Конструктор для створення речення з рядка.
     *
     * @param sentence Рядок, який представляє речення.
     */
    public Sentence(String sentence) {
        this.components = new ArrayList<>();
        String[] words = sentence.split("\\s+");
        for (String word : words) {
            if (word.matches("\\p{Punct}")) {
                components.add(new Punctuation(word.charAt(0)));
            } else {
                components.add(new Word(word));
            }
        }
    }

    /**
     * Повертає список компонентів речення.
     *
     * @return Список слів та розділових знаків.
     */
    public List<Object> getComponents() {
        return components;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Object component : components) {
            result.append(component.toString()).append(" ");
        }
        return result.toString().trim();
    }
}
