package textprocessing;

/**
 * Клас для представлення літери тексту.
 */
public class Letter {
    private final char value;

    /**
     * Конструктор для створення об'єкта літери.
     *
     * @param value Символ, який представляє цю літеру.
     */
    public Letter(char value) {
        this.value = value;
    }

    /**
     * Повертає значення літери.
     *
     * @return Символ літери.
     */
    public char getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
