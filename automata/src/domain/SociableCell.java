package domain;

public class SociableCell extends Cell
{
    private int neights;
    
    public SociableCell(CellularAutomata ac,int row, int column){
        super(ac,row,column);
        color = color.red;
    }
    
    public void neightBours(){
        neights = 4;
        
        if (automata.getItem(row -1,column) == null){
            neights--;
        }
        
        if(automata.getItem(row,column + 1) == null){
            neights--;
        }
        
        if(automata.getItem(row+1,column) == null){
            neights--;
        }
        
        if(automata.getItem(row,column-1) == null){
            neights--;
        }
        
    
        if(automata.getItem(row -1,column) != null){
            
            if (!automata.getItem(row -1,column).isAlive()){
                neights--;
            }
        }
            
        if(automata.getItem(row,column + 1) != null){

            if(!automata.getItem(row,column + 1).isAlive()){
                neights--;
            }
        }   
        
        if(automata.getItem(row+1,column) != null){

            if(!automata.getItem(row+1,column).isAlive()){
                neights--;
            }
        }   
        
        if(automata.getItem(row,column-1)!= null){

            if(!automata.getItem(row,column-1).isAlive()){
                neights--;
            }
        }

    }
    
    public void neightBoursE(){
        if(row ==0 && column > 0 && column < 29){
            neightBoursSup();
        }

        if(row ==29 && column > 0 && column < 29){
            neightBoursInf();
        }
        
        if(column==0 && row > 0 && row < 29){
            neightBoursDer();
        }

        if(column ==0 && row > 0 && row < 29){
            neightBoursIzq();
        }
        
    }

    private void  neightBoursSup(){

        if(automata.getItem(0,column-1) != null){
            if(automata.getItem(0,column-1).isAlive()){
                neights++;
            }
        }
        
        if(automata.getItem(0,column+1) != null){
            if(automata.getItem(0,column+1).isAlive()){
                neights++;
            }
        }
        
        if(automata.getItem(1,column) != null){
            if(automata.getItem(1,column).isAlive()){
                neights++;
            }
        }
    
    }
    
    private void  neightBoursInf(){        
        if(automata.getItem(29,column-1) != null){
            if(automata.getItem(29,column-1).isAlive()){
                neights++;
            }
        }
        
        if(automata.getItem(29,column+1) != null){
            if(automata.getItem(29,column+1).isAlive()){
                neights++;
            }
        }
        
        if(automata.getItem(28,column) != null){
            if(automata.getItem(28,column).isAlive()){
                neights++;
            }
        }
    
    }
    
    private void  neightBoursDer(){        
        if(automata.getItem(row-1,29) != null){
            if(automata.getItem(row-1,29).isAlive()){
                neights++;
            }
        }
        
        if(automata.getItem(row+1,29) != null){
            if(automata.getItem(row+1,29).isAlive()){
                neights++;
            }
        }
        
        if(automata.getItem(row,28) != null){
            if(automata.getItem(row,28).isAlive()){
                neights++;
            }
        }

    }
    
    private void  neightBoursIzq(){        
        if(automata.getItem(row-1,0) != null){
            if(automata.getItem(row-1,0).isAlive()){
                neights++;
            }
        }
        
        if(automata.getItem(row+1,0) != null){
            if(automata.getItem(row+1,0).isAlive()){
                neights++;
            }
        }
            
        if(automata.getItem(row,1) != null){
            if(automata.getItem(row,1).isAlive()){
                neights++;
            }
        }
    
    }
    
    private void neightBoursEs(){
        if(row ==0 && column ==0){
            neightBoursESD();
        }

        if(row ==0 && column ==29){
            neightBoursESI();
        }
        
        if(row ==29 && column ==0){
            neightBoursEID();
        }

        if(row ==29 && column == 29){
            neightBoursEII();
        }
        
    }
    
    private void neightBoursESD(){
        if(automata.getItem(row+1,column) != null && automata.getItem(row,column -1) != null){
            
            if(automata.getItem(row,column-1).isAlive() && automata.getItem(row+1,column).isAlive() ){
                neights += 2;
            }
        }
    }
    
    private void neightBoursESI(){
        if(automata.getItem(row+1,column) != null && automata.getItem(row,column + 1) != null){
            
            if(automata.getItem(row,column+1).isAlive() && automata.getItem(row+1,column).isAlive()){
                neights += 2;
            }
        }
    }

    private void neightBoursEID(){
        if(automata.getItem(row-1,column) != null && automata.getItem(row,column-1) != null){
            if(automata.getItem(row,column-1).isAlive() && automata.getItem(row-1,column).isAlive()){
                neights += 2;
            }
        }
    }

    private void neightBoursEII(){
        if(automata.getItem(row-1,column) != null && automata.getItem(row,column + 1) != null){
            if(automata.getItem(row ,column+1).isAlive() && automata.getItem(row-1,column).isAlive()){
                neights += 2;
            }
        }
    }
    
    @Override
    /**Decide its next state
     */
    public void decide(){
        if(row ==0|| row == 29 || column ==0 ||  column == 29){
            neightBoursE();
            
        }else if((row ==0 && column ==0) || (row ==0 && column ==29) || (row == 29 && column ==0)|| (row == 29 && column == 29)){
            neightBoursEs();
            
        }else{
            neightBours();
        }
        
        if(neights < 2){
            nextState = Agent.DEAD;
        }else{
            nextState = Agent.ALIVE;
        }
        
        if (getAge()>=80){
            nextState=Agent.DEAD;
        }
    }
        
    public void getTicTacs(){
        if(column != 0 && column != 29){
            if(automata.getItem(row,column +1) == null){
                new Cell(automata,row,column +1);
            }
            
            if(automata.getItem(row,column-1) == null){
                new SociableCell(automata,row,column-1);
            }
        }
        else{
            if(column == 29){
                getTicTacsIzq();
            }
            else{
                getTicTacsDer();
            }
        }
    }
    
    
    private void getTicTacsDer(){
        if(automata.getItem(row,column+1) == null){
            new Cell(automata,row,column+1);
        }
    }
    
    private void getTicTacsIzq(){
        if(automata.getItem(row,column-1) == null){
            new SociableCell(automata,row,column-1);
        }
    }
}
