package mg.njaka.chess.game;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.plugins.FileLocator;
import com.jme3.input.ChaseCamera;
import com.jme3.input.controls.AnalogListener;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.post.FilterPostProcessor;
import com.jme3.renderer.Limits;
import com.jme3.shadow.DirectionalLightShadowFilter;
import com.jme3.shadow.DirectionalLightShadowRenderer;
import com.jme3.shadow.EdgeFilteringMode;
import java.util.ArrayList;
import mg.njaka.chess.M;
import mg.njaka.chess.pieces.Cavalier;
import mg.njaka.chess.pieces.Fou;
import mg.njaka.chess.pieces.Piece;
import mg.njaka.chess.pieces.Pion;
import mg.njaka.chess.pieces.Reine;
import mg.njaka.chess.pieces.Roi;
import mg.njaka.chess.pieces.Tour;

public class MainGame extends SimpleApplication {

    public Thread loader;
    private ChaseCamera camera;
    private Player playerBlanc, playerNoir, playerCur;
    private Piece elementMove = null;
    private Position newPos = null, oldPos = null;
    private float posx = 0, posz = 0;
    private boolean deplacement = false, incremx = false, incremz = false, stopx = false, stopz = false;
    public static ListePosition lp;
    private ArrayList<Deplacement> deplacements = new ArrayList<>();
    private int couleurPlayer;

    public MainGame(int couleurPlayer) {
        this.couleurPlayer = couleurPlayer;
    }
    
    @Override
    public void simpleInitApp() {
        flyCam.setMoveSpeed(10);
        flyCam.setRotationSpeed(3);
        assetManager.registerLocator("assets/", FileLocator.class);
        lp = new ListePosition();

        Board board = new Board(assetManager);
        rootNode.attachChild(board.getNode());

        setUpLight(false);
        setUpCamera();

        viewPort.setBackgroundColor(ColorRGBA.Cyan);

        playerBlanc = new Player(M.var.BLANC, assetManager);
        playerBlanc.attach(rootNode);
        playerCur = playerBlanc;

        playerNoir = new Player(M.var.NOIR, assetManager);
        playerNoir.attach(rootNode);

        int maxDegree = renderer.getLimits().get(Limits.TextureAnisotropy);
        renderer.setDefaultAnisotropicFilter(maxDegree);
        renderer.setMainFrameBufferSrgb(true);
        renderer.setLinearizeSrgbImages(true);

//        inputManager.addMapping("p", new KeyTrigger(KeyInput.KEY_P));
//        inputManager.addMapping("c", new KeyTrigger(KeyInput.KEY_C));
//        inputManager.addMapping("f", new KeyTrigger(KeyInput.KEY_F));
//        inputManager.addListener(keyListenerDeplacement, new String[]{"p","c","f"});
    }

    private final AnalogListener keyListenerDeplacement = (String string, float f, float f1) -> {

    };

    @Override
    public void simpleUpdate(float tpf) {

        if (elementMove == null && !deplacements.isEmpty()) {
            Deplacement e = deplacements.get(0);
            elementMove = e.getPice();
            oldPos = elementMove.getPosition();
            posx = oldPos.getPosX();
            posz = oldPos.getPosY();
            newPos = e.getNewPosition();
            incremx = newPos.getPosX() > posx;
            incremz = newPos.getPosY() > posz;
            deplacement = true;
            deplacements.remove(0);
            
            if(deplacements.isEmpty())
                playerCur = elementMove.getCouleur() == M.var.BLANC ? playerNoir : playerBlanc;
        }

        if (elementMove != null && newPos != null) {

            stopx = incremx ? posx > newPos.getPosX() : posx < newPos.getPosX();
            stopz = incremz ? posz > newPos.getPosY() : posz < newPos.getPosY();

            if (!stopx) {
                posx += incremx ? (tpf * 15) : -(tpf * 15);
            }
            if (!stopz) {
                posz += incremz ? (tpf * 15) : -(tpf * 15);
            }

            elementMove.getNode().setLocalTranslation(posx, elementMove.getNode().getLocalTranslation().y, posz);

            if (stopx && stopz) {
                Piece pi = newPos.getPiece();
                if (pi != null) {
                    rootNode.detachChild(pi.getNode());
                    playerCur.getListePiece().remove(pi);
                }
                elementMove.setPosition(newPos);
                elementMove = null;
                newPos = null;
                deplacement = false;
            }
        }

    }
    
    
    private boolean result[] = {false,false};
    public boolean[] setAction(String string) {
        result[0] = true;
        result[1] = false;
        
        try {
            int len = string.length();
            if ((len == 2 || len == 3 || len == 5) && !deplacement) {
                char[] str = string.toLowerCase().toCharArray();

                if (len == 2 || len == 3) {
                    String el = len == 2 ? "p" : String.valueOf(str[0]);
                    char px = str[len == 2 ? 0 : 1];
                    int pz = Integer.parseInt(String.valueOf(str[len == 2 ? 1 : 2])) - 1;
                    final Position newP = lp.get(pz, px);

                    if (null != el) {
                        switch (el) {
                            case "r":
                                loop:
                                playerCur.getListePiece().forEach((p) -> {
                                    if (p instanceof Roi) {
                                        if (p.canGo(newP)) {
                                            // BALNC : grand c1 petit g1
                                            // NOIR : grang c8 petit g8
                                            if(!p.isDejaDeplacer()){
                                                Position ppr = p.getCouleur() == M.var.BLANC ? lp.get(1, 'g') : lp.get(8, 'g');
                                                Position pgr = p.getCouleur() == M.var.BLANC ? lp.get(1, 'c') : lp.get(8, 'c');
                                                
                                                if(newP.equals(ppr)){
                                                    
                                                }
                                                    
                                            }
                                            
                                            deplacements.add(new Deplacement(p, newP));
                                            result[1] = true;
                                        }
                                    }
                                });
                                break;
                            case "d":
                                playerCur.getListePiece().forEach((p) -> {
                                    if (p instanceof Reine) {
                                        if (p.canGo(newP)) {
                                            deplacements.add(new Deplacement(p, newP));
                                            result[1] = true;
                                        }
                                    }
                                });
                                break;
                            case "p":
                                playerCur.getListePiece().forEach((p) -> {
                                    if (p instanceof Pion) {
                                        if (p.canGo(newP)) {
                                            deplacements.add(new Deplacement(p, newP));
                                            result[1] = true;
                                        }
                                    }
                                });
                                break;
                            case "t":
                                playerCur.getListePiece().forEach((p) -> {
                                    if (p instanceof Tour) {
                                        if (p.canGo(newP)) {
                                            deplacements.add(new Deplacement(p, newP));
                                            result[1] = true;
                                        }
                                    }
                                });
                                break;
                            case "c":
                                playerCur.getListePiece().forEach((p) -> {
                                    if (p instanceof Cavalier) {
                                        if (p.canGo(newP)) {
                                            deplacements.add(new Deplacement(p, newP));
                                            result[1] = true;
                                        }
                                    }
                                });
                                break;
                            case "f":
                                playerCur.getListePiece().forEach((p) -> {
                                    if (p instanceof Fou) {
                                        if (p.canGo(newP)) {
                                            deplacements.add(new Deplacement(p, newP));
                                            result[1] = true;
                                        }
                                    }
                                });
                                break;
                            default:
                                result[0] = false;
                        }
                    }
                } else if (len == 5) {
                    char poz = str[0];
                    int pox = Integer.parseInt(String.valueOf(str[1])) - 1;
                    char pnz = str[3];
                    int pnx = Integer.parseInt(String.valueOf(str[4])) - 1;
                    Position newP = lp.get(pnx, pnz);
                    Piece p = lp.get(pox, poz).getPiece();
                    if(p.canGo(newP)){
                        deplacements.add(new Deplacement(p, newP));
                        result[1] = true;
                    }
                }
                else{
                    result[0] = false;
                }
            }
        } catch (NumberFormatException e) {
            result[0] = false;
        }
        
        return result;
    }

    private void setUpCamera() {

        flyCam.setEnabled(false);
        camera = new ChaseCamera(cam, rootNode, inputManager);
        camera.setDragToRotate(true);
        camera.setInvertVerticalAxis(true);
        camera.setRotationSpeed(10.0f);
        camera.setDefaultHorizontalRotation(couleurPlayer * (FastMath.PI / 2));
        camera.setDefaultVerticalRotation(FastMath.PI / 4);
        camera.setDefaultDistance(60);
//        camera.setMinVerticalRotation((float) -(Math.PI/2 - 0.0001f));
        camera.setMinVerticalRotation(0);
        camera.setMaxVerticalRotation((float) Math.PI / 2);
        camera.setMinDistance(7.5f);
        camera.setMaxDistance(100.f);

    }

    private void setUpLight(boolean shadow) {

        AmbientLight al = new AmbientLight();
        al.setColor(ColorRGBA.White.mult(0.5f));
        rootNode.addLight(al);

        DirectionalLight directionalLight = new DirectionalLight();
        directionalLight.setColor(ColorRGBA.White.mult(1f));
        directionalLight.setDirection(new Vector3f(-.5f, -.5f, -.5f).normalizeLocal());
        rootNode.addLight(directionalLight);

        if (shadow) {
            setUpShadow(directionalLight);
        }
    }

    private void setUpShadow(DirectionalLight directionalLight) {

        final int SHADOWMAP_SIZE = 1024;
        DirectionalLightShadowRenderer dlsr = new DirectionalLightShadowRenderer(assetManager, SHADOWMAP_SIZE, 3);
        dlsr.setLight(directionalLight);
        dlsr.setLambda(0.55f);
        dlsr.setShadowIntensity(0.2f);
        dlsr.setEdgeFilteringMode(EdgeFilteringMode.Nearest);
        viewPort.addProcessor(dlsr);

        DirectionalLightShadowFilter dlsf = new DirectionalLightShadowFilter(assetManager, SHADOWMAP_SIZE, 3);
        dlsf.setLight(directionalLight);
        dlsf.setLambda(0.55f);
        dlsf.setShadowIntensity(0.2f);
        dlsf.setEdgeFilteringMode(EdgeFilteringMode.Nearest);
        dlsf.setEnabled(true);

        FilterPostProcessor fpp = new FilterPostProcessor(assetManager);
        fpp.addFilter(dlsf);
        viewPort.addProcessor(fpp);

    }

    public boolean isMonTour(){
        return playerCur.getCouleur() == couleurPlayer;
    }
    
}
