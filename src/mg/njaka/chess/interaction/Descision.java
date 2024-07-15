
package mg.njaka.chess.interaction;


public class Descision {
    
    private String commande;
    private String commandeI = "0";

    public Descision(String txt) {
        String[] val = txt.split(" ");
        
        if(val.length == 2){
            String cl = decodeStr(val[0]);
            int cn = str2Nbr(val[1]);
            
            commande = cn!=0 ? "p"+cl+cn : commandeI;
        }
        else if(val.length == 3){
            String p = decodeStr(val[0]);
            String cl = val[1];
            int cn = str2Nbr(val[2]);
            
            commande = cn!=0 ? p+cl+cn : commandeI;
        }
        else{
            commande = commandeI;
        }
        
    }
    
    private int str2Nbr(String str){
        
        switch(str){
            case "un":
                return 1;
            case "deux":
                return 2;
            case "trois":
                return 3;
            case "quatre":
                return 4;
            case "cinq":
                return 5;
            case "six":
                return 6;
            case "sept":
                return 7;
            case "huit":
                return 8;
        }
        
        return 0;
    }
    
    private String decodeStr(String str){
        return str.substring(0, 1);
    }

    public String getCommande() {
        return commande;
    }

}
