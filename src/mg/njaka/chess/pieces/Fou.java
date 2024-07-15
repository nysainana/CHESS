
package mg.njaka.chess.pieces;

import com.jme3.asset.AssetManager;
import java.util.ArrayList;
import mg.njaka.chess.game.MainGame;
import mg.njaka.chess.game.Position;


public class Fou extends Piece {

    public Fou(int type, AssetManager assetManager) {
        super(type, "Fou/Fou.obj", assetManager);
    }

    @Override
    public void deplace(Position newPosition) {
        
    }

    @Override
    public ArrayList<Position> getDeplacementPossible() {
        return getDeplacementPossible(this);
    }
    
    public static ArrayList<Position> getDeplacementPossible(Piece pie){
        ArrayList<Position> liste = new ArrayList<>();
        
        int indexco = pie.getPosition().getIndexc();
        int indexli = pie.getPosition().getIndexl();
        
        boolean test1=false, test2=false, test3=false, test4=false;
        
        for(int i=0; i<=7;i++){
            if(indexli+i<8 && indexco+i<8 && !test1){
                Position p = MainGame.lp.get(indexli+i, indexco+i);
                test1 = addPosition(p, pie, liste);
            }
            if(indexli-i>=0 && indexco-i>=0 && !test2){
                Position p = MainGame.lp.get(indexli-i, indexco-i);
                test2 = addPosition(p, pie, liste);
            }
            if(indexli+i<8 && indexco-i>=0 && !test3){
                Position p = MainGame.lp.get(indexli+i, indexco-i);
                test3 = addPosition(p, pie, liste);
            }
            if(indexli-i>=0 && indexco+i<8 && !test4){
                Position p = MainGame.lp.get(indexli-i, indexco+i);
                test4 = addPosition(p, pie, liste);
            }
        }
        
        return liste;
    }
}
