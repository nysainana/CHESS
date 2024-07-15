
package mg.njaka.chess.game;

import mg.njaka.chess.pieces.Piece;


public class Deplacement {
    
    private Piece pice;
    private Position newPosition;
    private boolean fait;

    public Deplacement(Piece pice, Position newPosition) {
        this.pice = pice;
        this.newPosition = newPosition;
        this.fait = false;
    }

    public Piece getPice() {
        return pice;
    }

    public Position getNewPosition() {
        return newPosition;
    }

    public boolean isFait() {
        return fait;
    }
    
}
