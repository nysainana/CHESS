
package mg.njaka.chess.game;

import java.util.ArrayList;


public class ListePosition {
    private final Position[][] positions;
    private final ArrayList<Character> listeLetre;

    public ListePosition() {
        positions = new Position[8][8];
        listeLetre = new ArrayList<>();
        
        float y = -17.5f;
        for(int l=0; l<8; l++){
            float x = 17.5f;
            for(int c=0; c<8; c++){
                positions[l][c] = new Position(x, y, l, c);
                x -= 5;
            }
            y += 5;
        } 
        
        listeLetre.add('a');
        listeLetre.add('b');
        listeLetre.add('c');
        listeLetre.add('d');
        listeLetre.add('e');
        listeLetre.add('f');
        listeLetre.add('g');
        listeLetre.add('h');
    }
    
    public Position get(int l, char c){
        int k = listeLetre.indexOf(c);
        return positions[l][k];
    }
    
    public Position get(int l, int c){
        return positions[l][c];
    }
    
    public int getIndex(char a){
        return listeLetre.indexOf(a);
    }
    
    public char charAt(int index){
        return listeLetre.get(index);
    }
    
}
