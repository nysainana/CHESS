package mg.njaka.chess.ui;

import com.jme3.system.AppSettings;
import com.jme3.system.JmeCanvasContext;
import java.awt.Canvas;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTextField;
import mg.njaka.chess.game.MainGame;

public class PanelGame extends JPanel {

    private static Canvas canvas;
    private JTextField field;
    private MainGame mainGame;

    public PanelGame() {
        setLayout(new CardLayout());
        setBackground(Color.black);
    }

    @SuppressWarnings("unchecked")
    public void initGame(int couleur) {
        new Thread(() -> {
            AppSettings settings = new AppSettings(true);
            settings.setResolution(1000, 600);
            settings.setSamples(8);
            settings.setGammaCorrection(true);
            settings.setResizable(false);
            settings.setFrameRate(60);
            settings.setVSync(true);

            mainGame = new MainGame(couleur);
            mainGame.setSettings(settings);
            mainGame.setShowSettings(false);
            mainGame.setDisplayStatView(false);
            mainGame.setDisplayFps(false);
            mainGame.setPauseOnLostFocus(false);

            mainGame.createCanvas();

            JmeCanvasContext ctx = (JmeCanvasContext) mainGame.getContext();
            canvas = ctx.getCanvas();
            Dimension dim = new Dimension(settings.getWidth(), settings.getHeight());
            canvas.setPreferredSize(dim);

            add(canvas, "canvas");
        }).start();
    }

    public MainGame getMainGame() {
        return mainGame;
    }
    
}
