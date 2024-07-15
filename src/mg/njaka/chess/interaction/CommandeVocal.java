
package mg.njaka.chess.interaction;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Port;
import mg.njaka.chess.ui.FrameGame;
import t2s.son.LecteurTexte;


public class CommandeVocal {
    
    private Logger logger = Logger.getLogger(getClass().getName());
    private String result;
    
    private Thread speechThread;
    private Thread resourcesThread;
    private LiveSpeechRecognizer recognizer;
    
    private FrameGame frame;
    private boolean alive = false;
    
    public CommandeVocal(FrameGame frame){
        this.frame = frame;
        
        logger.log(Level.INFO, "Loading..\n");
        Configuration configuration = new Configuration();
        
        configuration.setAcousticModelPath("assets/fr/cmusphinx_fr");
        configuration.setDictionaryPath("assets/fr/fr_lm/fr.dict");
        configuration.setLanguageModelPath("assets/fr/fr_lm/fr-small.lm.bin");
        
        configuration.setGrammarPath("assets/grammars");
        configuration.setGrammarName("grammar");
        configuration.setUseGrammar(true);
        
        try{
           recognizer = new LiveSpeechRecognizer(configuration);
        }catch(IOException ex){
            logger.log(Level.SEVERE, null, ex);
        }
        
        recognizer.startRecognition(true);
        
    }
    
    public void start(){
        alive = true;
        startSpeechTread();
        startResourcesThread();
    }
    
    public void stop(){
        alive = false;
    }

    public boolean isAlive() {
        return alive;
    }

    private void startSpeechTread() {
        if(speechThread != null && speechThread.isAlive());
        
        speechThread = new Thread(()->{
            logger.log(Level.INFO, "you can start to speak...");
            try{
                while(alive){
                    SpeechResult speechResult = recognizer.getResult();
                    if(speechResult != null){
                        result = speechResult.getHypothesis();
                        String cmd = new Descision(result).getCommande();
                        System.out.println(result + " ==> " + cmd);
                        if(frame != null)
                            frame.onDeplace(cmd, result);
                    }
                    else
                        logger.log(Level.INFO, "I can't understaind what you say");
                }
            }catch(Exception ex){
                logger.log(Level.WARNING, null, ex);
            }
            logger.log(Level.INFO, "Speatch thread has exited...");
        });
        
        speechThread.start();
    }

    private void startResourcesThread() {
        
        if(resourcesThread!=null && resourcesThread.isAlive())
            return;
        
        resourcesThread = new Thread(() -> {
            try {
                while (alive) {                    
                    if(AudioSystem.isLineSupported(Port.Info.MICROPHONE)){
                        
                    }
                    else{
                        
                    }
                    Thread.sleep(350);
                }
                
            } catch (InterruptedException ex) {
                logger.log(Level.WARNING, null, ex);
                resourcesThread.interrupt();
            }
            logger.log(Level.INFO, "Ressource thread has exited...");
        });
        
        resourcesThread.start();
    }
    
}
