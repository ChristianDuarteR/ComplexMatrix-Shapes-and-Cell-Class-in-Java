package domain;
import java.util.*;


/*No olviden adicionar la documentacion*/
public class CellularAutomata{
    static private int LENGTH=30;
    protected Item[][] automata;
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
        new Cell(this, 5, 5);
        Cell Indiana = new Cell(this, 1, 1);
        Cell oo7 = new Cell(this, 2, 2);
        SociableCell santiago = new SociableCell(this,2,1);
        SociableCell venus = new SociableCell(this, 15, 15);
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
    }
    
}