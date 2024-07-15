
package mg.njaka.chess.game;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;


public class Board {
    
    protected AssetManager assetManager;
    protected Spatial spatial;
    protected Node node;
    protected Material material;
    protected String MODEL_NAME = "board/chess_board1.obj";
    protected String TEXTURE_NAME = "board/texture.JPG";
    
    public Board(AssetManager assetManager) {
        this.assetManager = assetManager;
        loadModel();
    }
    
    protected void loadModel(){
        
//        material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
//        material.setTexture("ColorMap", assetManager.loadTexture(TEXTURE_NAME));
        
        material = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        material.setTexture("DiffuseMap", assetManager.loadTexture(TEXTURE_NAME));
        
        spatial = assetManager.loadModel(MODEL_NAME);
        spatial.setMaterial(material);
        node = new Node(MODEL_NAME);
        node.attachChild(spatial);
        node.scale(1.1f);
        node.setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
    }

    public Spatial getSpatial() {
        return spatial;
    }

    public Node getNode() {
        return node;
    }
}
