package domain;
import java.awt.Color;
import java.util.ArrayList;

public class CellParty extends Cell{
    private ArrayList<Color> colores = new ArrayList<Color>();
    
    
    /**
     * Constructs a new CellParty object with a random color.
     *
     * @param ac     The CellularAutomata object.
     * @param row    The row where the cell is located.
     * @param column The column where the cell is located.
     */
    public CellParty(CellularAutomata ac,int row, int column){
        super(ac,row,column);
        
        color = partyColor();
    }
    
     /**
     * Generates a random color for the cell from a pre-defined list of colors.
     *
     * @return A randomly selected color.
     */
    public Color partyColor(){
        colores.add(Color.pink);
        colores.add(Color.magenta);
        colores.add(Color.cyan);
        colores.add(Color.white);
        
        int x = (int)(Math.random()*4);
        return colores.get(x);
    }
    
    
    /**
     * Resets the age of the cell to zero.
     */
    public void setPartyAge(){
        age = 0;
    }
    
    
    /**
     * Determines the state of the cell based on its current age.
     * If the age is 20 or more, the age is reset to zero.
     * If the age is between 15 and 20, the cell dies.
     * Otherwise, the cell remains alive.
     */
    public void decide(){
        color = partyColor();
        
        if(getAge() == 20){
            setPartyAge();
        }else if(getAge() >= 15){
            nextState = Agent.DEAD;
        }else{
            nextState = Agent.ALIVE;
        }
    }
    
    /**
     * Generates a new CellParty object at a random location in the CellularAutomata grid.
     */
    public void getTicTacs(){
        int rowsParty = (int)(Math.random()*30);
        int ColumnsParty = (int)(Math.random()*30);
        
        if (automata.getItem(rowsParty,ColumnsParty) == null){
            new CellParty(automata,rowsParty,ColumnsParty);
        }
    }

}
