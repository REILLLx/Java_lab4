package textprocessing;

/**
 * Клас для представлення розділового знака.
 */
public class Punctuation {
    private final char symbol;

    /**
     * Конструктор для створення об'єкта розділового знака.
     *
     * @param symbol Символ, який представляє розділовий знак.
     */
    public Punctuation(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Повертає символ розділового знака.
     *
     * @return Символ розділового знака.
     */
    public char getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
