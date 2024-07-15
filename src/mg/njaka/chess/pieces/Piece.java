
package mg.njaka.chess.pieces;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue.ShadowMode;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import java.util.ArrayList;
import mg.njaka.chess.M;
import mg.njaka.chess.game.Position;


public abstract class Piece {

    protected Position position;
    protected AssetManager assetManager;
    protected Spatial spatial;
    protected Node node;
    protected String MODEL_PATH = "pieces/";
    protected String MODEL_NAME;
    protected String TEXTURE_NAME;
    protected ColorRGBA color;
    protected Material material;
    protected int couleur;
    protected boolean dejaDeplacer = false;
    
    public Piece(int couleur, String name, AssetManager assetManager) {
        this.assetManager = assetManager;
        this.couleur = couleur;
        this.MODEL_NAME = MODEL_PATH + name;
        this.TEXTURE_NAME =  MODEL_PATH + (couleur == M.var.BLANC ? "textures/blanc.jpg" : "textures/noir.jpg");
        this.color = couleur == M.var.BLANC ? new ColorRGBA(0.7f, 0.7f, 0.7f, 1) : new ColorRGBA(0.2f, 0.2f, 0.2f, 1);
        this.position = new Position(0, 0, 0, 0, this);
        loadModel();
    }
    
    public abstract void deplace(Position newPosition);
    
    public abstract ArrayList<Position> getDeplacementPossible();
    
    public boolean canGo(Position pos){
        ArrayList<Position> l = getDeplacementPossible();
//        
//        Node par = node.getParent();
//        
//        par.detachChildNamed("box");
//        
//        l.forEach((p) -> {
//            p.marque(par, assetManager);
//        });
        
        return l.contains(pos);
    }
    
    protected void loadModel(){
        
//        material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
//        material.setTexture("ColorMap", assetManager.loadTexture(TEXTURE_NAME));
//        material.setColor("Color", color);
//        material.setBoolean("VertexColor",true);
        
        material = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
//        material.setTexture("DiffuseMap", assetManager.loadTexture(TEXTURE_NAME));
        material.setFloat("Shininess",64f);
        material.setBoolean("UseMaterialColors",true);
        material.setColor("Diffuse", color);
        material.setColor("Ambient", color);
        material.setColor("Specular", color);

        spatial = assetManager.loadModel(MODEL_NAME);
        spatial.scale(150);
        spatial.setMaterial(material);
        spatial.setShadowMode(ShadowMode.CastAndReceive);
        node = new Node(MODEL_NAME);
        node.attachChild(spatial);
        if(couleur == M.var.NOIR){
            Quaternion qt = new Quaternion();
            qt.fromAngleAxis(FastMath.PI, new Vector3f(0,1,0) );
            node.setLocalRotation(qt);
        }
    }

    public Spatial getSpatial() {
        return spatial;
    }

    public Node getNode() {
        return node;
    }

    public Position getPosition() {
        return position;
    }

    public void initPosition(Position position) {
        position.setPiece(this);
        this.position = position;
        this.node.setLocalTranslation(position.getPosition());
    }
    
    public void setPosition(Position position) {
        this.position.setPiece(null);
        position.setPiece(this);
        this.position = position;
        this.dejaDeplacer = true;
        this.node.setLocalTranslation(position.getPosition());
    }

    public int getCouleur() {
        return couleur;
    }

    public boolean isDejaDeplacer() {
        return dejaDeplacer;
    }
        
    protected static boolean addPosition(Position p, Piece pie, ArrayList<Position> liste){
        if(!p.equals(pie.getPosition())) {
            Piece pi = p.getPiece();
            if(pi==null){
                liste.add(p);
                return false;
            }
            else{
               if(pi.getCouleur() != pie.getCouleur()){
                   liste.add(p);
               }
               return true;
            }    
        }
        return false;
    }

}
