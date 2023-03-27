package domain;
import java.awt.Color;
import java.util.ArrayList;

public class CellParty extends Cell{
    private ArrayList<Color> colores = new ArrayList<Color>();
    
    public CellParty(CellularAutomata ac,int row, int column){
        super(ac,row,column);
        
        color = partyColor();
    }
    
    
    public Color partyColor(){
        colores.add(Color.pink);
        colores.add(Color.magenta);
        colores.add(Color.cyan);
        colores.add(Color.white);
        
        int x = (int)(Math.random()*4);
        return colores.get(x);
    }
    
    public void setPartyAge(){
        age = 0;
    }
    
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
    
    public void getTicTacs(){
        int rowsParty = (int)(Math.random()*30);
        int ColumnsParty = (int)(Math.random()*30);
        
        if (automata.getItem(rowsParty,ColumnsParty) == null){
            new CellParty(automata,rowsParty,ColumnsParty);
        }
    }

}
