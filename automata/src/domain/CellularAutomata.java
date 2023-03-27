package domain;
import java.util.*;


/*No olviden adicionar la documentacion*/
public class CellularAutomata{
    static private int LENGTH=30;
    private Item[][] automata;
    protected int ticTacs = 0;
    
    public CellularAutomata() {
        automata=new Item[LENGTH][LENGTH];
        for (int r=0;r<LENGTH;r++){
            for (int c=0;c<LENGTH;c++){
                automata[r][c]=null;
            }
        }
        someItems();
    }

    public int  getLength(){
        return LENGTH;
    }

    public Item getItem(int r,int c){
        return automata[r][c];
    }

    public void setItem(int r, int c, Item e){
        automata[r][c]=e;
    }

    public void someItems(){
        SociableCell celula = new SociableCell(this,0,0);
        SociableCell agamenon = new SociableCell(this,2,5);
        SociableCell venus = new SociableCell(this, 15, 15);
        Heater suroeste  = new Heater(this, 29, 29);
        Heater noroeste = new Heater(this,29,0);
        CellParty christian = new CellParty(this, 18,3);
        CellParty miguel = new CellParty(this, 3,21);
        
        Virus Valentina = new Virus(this,18,18);
        Virus Jose = new Virus(this,19,18);
        Virus Daniel = new Virus(this,17,18);
    }

    
    public void ticTac(){
        ticTacs++;
        
        for (int i=0;i<LENGTH;i++){
            
            for (int j=0;j<LENGTH;j++){
                
                Item item = automata[i][j];
                if (item != null){
                    item.decide();
                }
            }
        }

        for (int i=0;i<LENGTH;i++){
            
            for (int j=0;j<LENGTH;j++){
                
                Item item = automata[i][j];
                if (item != null){
                    item.change();
                }
            }
        }
        
        if(ticTacs % 10 == 0){
            
            for (int i=0;i<LENGTH;i++){
                
                for (int j=0;j<LENGTH;j++){
                    
                    Item item = automata[i][j];
                    if (item != null){ 
                        if (item instanceof SociableCell){
                            
                            ((SociableCell)item).getTicTacs();
                        }
                        
                        else if(item instanceof CellParty){
                            ((CellParty)item).getTicTacs();
                        }
            
                        
                    }
                }
            }
        }

        if(ticTacs % 7 == 0){
            
            for (int i=0;i<LENGTH;i++){
                
                for (int j=0;j<LENGTH;j++){
                    
                    Item item = automata[i][j];
                    if (item != null){ 
                        if (item instanceof Virus){
                            
                            ((Virus)item).getTicTacs();
                        }
            
                    }
                }
            }
        }
        
        
    }
    
    
    
}