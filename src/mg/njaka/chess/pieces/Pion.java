package mg.njaka.chess.pieces;

import com.jme3.asset.AssetManager;
import java.util.ArrayList;
import mg.njaka.chess.M;
import mg.njaka.chess.game.MainGame;
import mg.njaka.chess.game.Position;

public class Pion extends Piece {

    public Pion(int type, AssetManager assetManager) {
        super(type, "Pion/Pion.obj", assetManager);
    }

    @Override
    public void deplace(Position newPosition) {

    }

    @Override
    public ArrayList<Position> getDeplacementPossible() {
        ArrayList<Position> liste = new ArrayList<>();

        int indexco = position.getIndexc();
        int indexli = position.getIndexl();
        Position p = null;

        if (couleur == M.var.BLANC) {
            p = MainGame.lp.get(indexli + 1, indexco);
            if (p.getPiece() == null) {
                addPosition(p, this, liste);
            }

            if (!dejaDeplacer) {
                p = MainGame.lp.get(indexli + 2, indexco);
                if (p.getPiece() == null) {
                    addPosition(p, this, liste);
                }
            }

            if (indexli + 1 < 8 && indexco + 1 < 8) {
                p = MainGame.lp.get(indexli + 1, indexco + 1);
                if (p.getPiece() != null && p.getPiece().getCouleur() != couleur) {
                    addPosition(p, this, liste);
                }
            }

            if (indexli + 1 < 8 && indexco - 1 >= 0) {
                p = MainGame.lp.get(indexli + 1, indexco - 1);
                if (p.getPiece() != null && p.getPiece().getCouleur() != couleur) {
                    addPosition(p, this, liste);
                }
            }
        }
        else{
            p = MainGame.lp.get(indexli - 1, indexco);
            if (p.getPiece() == null) {
                addPosition(p, this, liste);
            }

            if (!dejaDeplacer) {
                p = MainGame.lp.get(indexli - 2, indexco);
                if (p.getPiece() == null) {
                    addPosition(p, this, liste);
                }
            }

            if (indexli - 1 >= 0 && indexco - 1 >= 0) {
                p = MainGame.lp.get(indexli - 1, indexco - 1);
                if (p.getPiece() != null && p.getPiece().getCouleur() != couleur) {
                    addPosition(p, this, liste);
                }
            }

            if (indexli - 1 >= 0 && indexco + 1 < 8) {
                p = MainGame.lp.get(indexli - 1, indexco + 1);
                if (p.getPiece() != null && p.getPiece().getCouleur() != couleur) {
                    addPosition(p, this, liste);
                }
            }
        }

        return liste;
    }

}
