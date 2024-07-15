
package mg.njaka.chess.pieces;

import com.jme3.asset.AssetManager;
import java.util.ArrayList;
import mg.njaka.chess.game.MainGame;
import mg.njaka.chess.game.Position;


public class Cavalier extends Piece {

    public Cavalier(int type, AssetManager assetManager) {
        super(type, "Cavalier/Cavalier.obj", assetManager);
    }

    @Override
    public void deplace(Position newPosition) {
        
    }

    @Override
    public ArrayList<Position> getDeplacementPossible() {
        ArrayList<Position> liste = new ArrayList<>();
        
        int indexco = position.getIndexc();
        int indexli = position.getIndexl();
        
        if(indexli+2<8 && indexco+1<8) addPosition(MainGame.lp.get(indexli+2, indexco+1), this, liste);
        if(indexli+2<8 && indexco-1>=0) addPosition(MainGame.lp.get(indexli+2, indexco-1), this, liste);
        if(indexli-2>=0 && indexco+1<8) addPosition(MainGame.lp.get(indexli-2, indexco+1), this, liste);
        if(indexli-2>=0 && indexco-1>=0) addPosition(MainGame.lp.get(indexli-2, indexco-1), this, liste);
        
        if(indexli+1<8 && indexco+2<8) addPosition(MainGame.lp.get(indexli+1, indexco+2), this, liste);
        if(indexli+1<8 && indexco-2>=0) addPosition(MainGame.lp.get(indexli+1, indexco-2), this, liste);
        if(indexli-1>=0 && indexco+2<8) addPosition(MainGame.lp.get(indexli-1, indexco+2), this, liste);
        if(indexli-1>=0 && indexco-2>=0) addPosition(MainGame.lp.get(indexli-1, indexco-2), this, liste);
        
        return liste;
    }

}
