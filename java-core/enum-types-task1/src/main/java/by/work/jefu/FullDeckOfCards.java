package by.work.jefu;

/**
 * Class whose instances represent a full deck of cards.
 */
public class FullDeckOfCards {
    private static final int ROWS = Suit.values().length;
    private static final int COLUMNS = Rank.values().length;
    private static final int AMOUNT_OF_CARDS = ROWS * COLUMNS;
    
    private final Card[][] deck;
    
    /**
     * Public constructor.
     * Initializes full deck of cards on object creating.
     */
    public FullDeckOfCards() {
        deck = new Card[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                deck[i][j] = new Card(Rank.values()[j], Suit.values()[i]);
            }
        }
    }
    
    /**
     * Getter for rows.
     * @return this.rows.
     */
    public int getRows() {
        return ROWS;
    }

    /**
     * Getter for columns.
     * @return this.columns.
     */
    public int getColumns() {
        return COLUMNS;
    }

    /**
     * Getter for amount of cards.
     * @return this.amountOfCards.
     */
    public int getAmountOfCards() {
        return AMOUNT_OF_CARDS;
    }

    /**
     * Getter for the full deck.
     * @return this.deck.
     */
    public Card[][] getDeck() {
        return this.deck;
    }
        
    /**
     * Method that gets certain card from the deck (by id).
     * @param row int type.
     * @param column int type.
     * @return Card from the full deck.
     */
    public Card getCardById(int row, int column) {
        return deck[row][column];
    }
}
