import textprocessing.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Основний клас для виконання задачі: сортування слів у тексті, які починаються з голосних літер, за другою літерою.
 */
public class VowelWordsSorter {

    /**
     * Головний метод виконання програми.
     *
     * @param args Аргументи командного рядка.
     */
    public static void main(String[] args) {
        Scanner scanner = null;

        try {
            scanner = new Scanner(System.in);

            // Введення тексту користувачем
            System.out.println("Введіть текст українською мовою:");
            String inputText = scanner.nextLine();

            // Перевірка на порожній текст
            if (inputText.trim().isEmpty()) {
                throw new IllegalArgumentException("Текст не може бути порожнім. Будь ласка, введіть текст.");
            }

            // Створення тексту з використанням класу Text
            Text text = new Text(inputText);

            // Отримання слів, що починаються з голосних
            List<Word> vowelWords = text.getVowelStartingWords();

            // Перевірка, чи знайдено слова
            if (vowelWords.isEmpty()) {
                System.out.println("У введеному тексті немає слів, які починаються з голосних літер і мають другу літеру.");
                return;
            }

            // Сортування слів за другою літерою
            Collections.sort(vowelWords, new Comparator<Word>() {
                @Override
                public int compare(Word w1, Word w2) {
                    return Character.compare(w1.getSecondLetter(), w2.getSecondLetter());
                }
            });

            // Виведення результатів
            System.out.println("Слова, що починаються з голосних, відсортовані за другою літерою:");
            for (Word word : vowelWords) {
                System.out.println(word);
            }

            // Виведення нормалізованого тексту
            System.out.println("\nНормалізований текст:");
            System.out.println(text);

        } catch (IllegalArgumentException e) {
            System.err.println("Помилка: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Сталася непередбачена помилка: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
