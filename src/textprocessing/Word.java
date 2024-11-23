package textprocessing;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас для представлення слова.
 */
public class Word {
    private final List<Letter> letters;

    /**
     * Конструктор для створення слова з рядка.
     *
     * @param word Рядок, який представляє слово.
     */
    public Word(String word) {
        this.letters = new ArrayList<>();
        for (char ch : word.toCharArray()) {
            this.letters.add(new Letter(ch));
        }
    }

    /**
     * Повертає другу літеру слова.
     *
     * @return Друга літера або перша, якщо слово має довжину 1.
     */
    public char getSecondLetter() {
        return letters.size() > 1 ? letters.get(1).getValue() : letters.get(0).getValue();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Letter letter : letters) {
            result.append(letter.getValue());
        }
        return result.toString();
    }
}
