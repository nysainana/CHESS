
package mg.njaka.chess.game;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import mg.njaka.chess.pieces.Piece;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;


public class Position {
    
    private float posX;
    private float posY;
    private Piece piece;
    private int indexl;
    private int indexc;

    public Position(float posX, float posY, int indexl, int indexc, Piece piece) {
        this.posX = posX;
        this.posY = posY;
        this.piece = piece;
        this.indexl = indexl;
        this.indexc = indexc;
    }
    
    public Position(float posX, float posY, int indexl, int indexc) {
        this.posX = posX;
        this.posY = posY;
        this.piece = null;
        this.indexl = indexl;
        this.indexc = indexc;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }
    
    public Vector3f getPosition(){
        return new Vector3f(posX, 0, posY);
    }

    public int getIndexl() {
        return indexl;
    }

    public int getIndexc() {
        return indexc;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Float.floatToIntBits(this.posX);
        hash = 97 * hash + Float.floatToIntBits(this.posY);
        hash = 97 * hash + this.indexl;
        hash = 97 * hash + this.indexc;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (Float.floatToIntBits(this.posX) != Float.floatToIntBits(other.posX)) {
            return false;
        }
        if (Float.floatToIntBits(this.posY) != Float.floatToIntBits(other.posY)) {
            return false;
        }
        if (this.indexl != other.indexl) {
            return false;
        }
        return this.indexc == other.indexc;
    }
    
    public void marque(Node root, AssetManager assetManager){
        
        Material material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        material.setColor("Color", ColorRGBA.Green); 
        
        Box box = new Box(new Vector3f(posX, 0, posY), 1.5f, 0.1f, 1.5f);
        Geometry geo = new Geometry("box", box);
        geo.setMaterial(material);
        
        root.attachChild(geo);
    }
    
}
