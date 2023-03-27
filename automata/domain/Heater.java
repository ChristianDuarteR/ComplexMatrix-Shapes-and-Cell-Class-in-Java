package domain;
import java.awt.Color;

/**
 * The Heater class represents a heater object in a Cellular Automata simulation that implements the Item interface.
 * The heater object changes its shape and color according to its current state and the state of the simulation.
 */
public class Heater implements Item
{
    protected Color color;
    protected CellularAutomata automata;
    protected int row,column;
    private int misTics = 0;
    private int forma; 
    
    /**
     * Constructs a new Heater object and adds it to the specified CellularAutomata simulation.
     *
     * @param ac The CellularAutomata simulation to which the heater belongs.
     * @param row The row index of the cell where the heater will be placed.
     * @param column The column index of the cell where the heater will be placed.
     */
    public Heater(CellularAutomata ac, int row, int column){
        automata=ac;
        this.row=row;
        this.column=column;
        automata.setItem(row,column,(Item)this);   

    }
    
    
    /**
     * Determines the state of the heater based on the number of ticks that have passed since its creation.
     * After 5 ticks, the heater changes its shape to SQUARE, and after 15 ticks, it changes its shape to ROUND.
     */
    public void decide(){
        misTics++;
        
        if (misTics == 5){
            forma = Item.SQUARE;
        }else if(misTics == 15){
            forma = Item.ROUND;
        }
        
    }

    /**
     * Updates the color and shape of the heater in the simulation.
     */
    public void change(){
        getColor();
        shape();
    }
    
    /**
     * Returns the current color of the heater.
     *
     * @return The current color of the heater.
     */
    public Color getColor(){
        if (automata.ticTacs % 2 == 0){
            return Color.gray;
        }else{
            return Color.orange;
        }
    }
    
    /**
     * Determines the current shape of the heater based on the number of ticks that have passed since its creation.
     * The shape of the heater changes from SQUARE to ROUND every 15 ticks.
     *
     * @return The current shape of the heater.
     */
    public final int shape(){
        if(misTics == 15){
            misTics = 0;
        }
        return forma;
    }
}
