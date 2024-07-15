
package mg.njaka.chess.game;

import com.jme3.asset.AssetManager;
import com.jme3.scene.Node;
import java.util.ArrayList;
import mg.njaka.chess.M;
import mg.njaka.chess.pieces.Cavalier;
import mg.njaka.chess.pieces.Fou;
import mg.njaka.chess.pieces.Piece;
import mg.njaka.chess.pieces.Pion;
import mg.njaka.chess.pieces.Reine;
import mg.njaka.chess.pieces.Roi;
import mg.njaka.chess.pieces.Tour;


public class Player {
    
    private final int type;
    private final ArrayList<Piece> listePiece = new ArrayList<>();
    
    public Player(int type, AssetManager assetManager){
        this.type = type;
        int ligneP = type == M.var.BLANC ? 0 : 7;
        int lignePi = type == M.var.BLANC ? 1 : 6;
        
        Roi roi = new Roi(type, assetManager);
        roi.initPosition(MainGame.lp.get(ligneP, 'e'));
        listePiece.add(roi);
        Reine reine = new Reine(type, assetManager);
        reine.initPosition(MainGame.lp.get(ligneP, 'd'));
        listePiece.add(reine);
        
        for(int i=0; i<8; i++){
            Pion pi = new Pion(type, assetManager);
            char c = MainGame.lp.charAt(i);
            pi.initPosition(MainGame.lp.get(lignePi, c));
            listePiece.add(pi);
        }
        
        for(int i=0; i<2; i++){
            Tour to = new Tour(type, assetManager);
            char c = i == 0? 'a' : 'h';
            to.initPosition(MainGame.lp.get(ligneP, c));
            listePiece.add(to);
        }
        
        for(int i=0; i<2; i++){
            Cavalier ca = new Cavalier(type, assetManager);
            char c = i == 0? 'b' : 'g';
            ca.initPosition(MainGame.lp.get(ligneP, c));
            listePiece.add(ca);
        }
        
        for(int i=0; i<2; i++){
            Fou fo = new Fou(type, assetManager);
            char c = i == 0? 'c' : 'f';
            fo.initPosition(MainGame.lp.get(ligneP, c));
            listePiece.add(fo);
        }
    }
    
    public void attach(Node node){
        listePiece.forEach((piece) -> {
            node.attachChild(piece.getNode());
        });
    }

    public int getCouleur() {
        return type;
    }

    public ArrayList<Piece> getListePiece() {
        return listePiece;
    }
    
}
