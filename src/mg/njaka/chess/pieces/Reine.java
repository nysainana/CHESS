
package mg.njaka.chess.pieces;

import com.jme3.asset.AssetManager;
import java.util.ArrayList;
import mg.njaka.chess.game.Position;


public class Reine extends Piece{
    
    public Reine(int type, AssetManager assetManager) {
        super(type, "Reine/Reine.obj", assetManager);
    }

    @Override
    public void deplace(Position newPosition) {
        
    }

    @Override
    public ArrayList<Position> getDeplacementPossible() {
        ArrayList<Position> liste = new ArrayList<>();
        liste.addAll(Fou.getDeplacementPossible(this));
        liste.addAll(Tour.getDeplacementPossible(this));
        return liste;
    }

}
