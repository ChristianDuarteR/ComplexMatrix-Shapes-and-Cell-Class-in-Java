package domain;
import java.awt.Color;

public class Virus implements Item {
    private CellularAutomata automata;
    protected Color color;
    protected int row,column;
    private Item[] neights;
    
    public Virus(CellularAutomata ac, int row, int column){
        automata=ac;
        this.row=row;
        this.column=column;
        automata.setItem(row,column,(Item)this); 
        color = getColor();
        neights = new Item[4];
    }
    
    public Color getColor(){
        return Color.black;
    }
    
    public void decide(){
        for(int i = 0; i<neights.length; i++){
            neights[i] = null;
        }
        
        lookNeights();
        
    }
    
    private void lookNeights(){
        if (row < 29 && row > 0 && column < 29 && column > 0){
            
            if(automata.getItem(row-1,column) != null){
                neights[0] = automata.getItem(row-1,column);
            }
            
            if(automata.getItem(row,column+1) != null){
                neights[1] = automata.getItem(row,column+1);
            }
    
            if(automata.getItem(row+1,column) != null){
                neights[2] = automata.getItem(row+1,column);
            }
    
            if(automata.getItem(row,column-1) != null){
                neights[3] = automata.getItem(row,column-1);
            }
        }

    }
    
    public void change(){

        if (row < 29 && row > 0 && column < 29 && column > 0){
            
            if(neights[0] != null && !(neights[0] instanceof Virus)){
                automata.setItem(row-1,column,null); 
            }
            
            if(neights[1] != null && !(neights[1] instanceof Virus)){
               automata.setItem(row,column+1,null);
            }
            
            if(neights[2] != null && !(neights[2] instanceof Virus)){
                automata.setItem(row-1,column,null);
            }
            
            if(neights[3] != null && !(neights[3] instanceof Virus)){
                automata.setItem(row,column-1,null);
            }
            
        }
        
    }
    
    public void getTicTacs(){
        
        if (row < 29 && row > 0 && column < 29 && column > 0){
            
            if(neights[0] == null ){
                new Virus(automata,row-1,column); 
            }
            
            if(neights[1] == null ){
               new Virus(automata,row,column+1);
            }
            
            if(neights[2] == null ){
               new Virus(automata,row+1,column);
            }
            
            if(neights[3] == null ){
               new Virus(automata,row,column-1);
            }
  
        }   
    }
}
