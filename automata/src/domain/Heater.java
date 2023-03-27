package domain;
import java.awt.Color;

public class Heater implements Item
{
    protected Color color;
    protected CellularAutomata automata;
    protected int row,column;
    private int misTics = 0;
    private int forma; 
    
    public Heater(CellularAutomata ac, int row, int column){
        automata=ac;
        this.row=row;
        this.column=column;
        automata.setItem(row,column,(Item)this);   

    }
    
    public void decide(){
        misTics++;
        
        if (misTics == 5){
            forma = Item.SQUARE;
        }else if(misTics == 15){
            forma = Item.ROUND;
        }
        
    }
    
    public void change(){
        getColor();
        shape();
    }
    
    public Color getColor(){
        if (automata.ticTacs % 2 == 0){
            return Color.gray;
        }else{
            return Color.orange;
        }
    }
    
    
    public final int shape(){
        if(misTics == 15){
            misTics = 0;
        }
        return forma;
    }
}
