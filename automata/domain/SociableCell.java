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
        
        if (automata.automata[row -1][column] == null){
            neights--;
        }
        
        if(automata.automata[row][column + 1] == null){
            neights--;
        }
        
        if(automata.automata[row+1][column] == null){
            neights--;
        }
        
        if(automata.automata[row][column-1] == null){
            neights--;
        }
        
    
        if(automata.automata[row -1][column] != null){
            
            if (!automata.automata[row -1][column].isAlive()){
                neights--;
            }
        }
            
        if(automata.automata[row][column + 1] != null){

            if(!automata.automata[row][column + 1].isAlive()){
                neights--;
            }
        }   
        
        if(automata.automata[row+1][column] != null){

            if(!automata.automata[row+1][column].isAlive()){
                neights--;
            }
        }   
        
        if(automata.automata[row][column-1] != null){

            if(!automata.automata[row][column-1].isAlive()){
                neights--;
            }
        }

    }
    
    public void neightBoursE(){
        if(row ==0 && column > 0 && column < 30){
            neightBoursSup();
        }

        if(row ==30 && column > 0 && column < 30){
            neightBoursInf();
        }
        
        if(column==0 && row > 0 && row < 30){
            neightBoursDer();
        }

        if(column ==0 && row > 0 && row < 30){
            neightBoursIzq();
        }
        
    }

    private void  neightBoursSup(){        
        if(automata.automata[0][column-1] != null){
            if(automata.automata[0][column-1].isAlive()){
                neights++;
            }
        }
        
        if(automata.automata[0][column+1] != null){
            if(automata.automata[0][column+1].isAlive()){
                neights++;
            }
        }
        
        if(automata.automata[1][column] != null){
            if(automata.automata[1][column].isAlive()){
                neights++;
            }
        }
    
    }
    
    private void  neightBoursInf(){        
        if(automata.automata[30][column-1] != null){
            if(automata.automata[30][column-1].isAlive()){
                neights++;
            }
        }
        
        if(automata.automata[30][column+1] != null){
            if(automata.automata[30][column+1].isAlive()){
                neights++;
            }
        }
        
        if(automata.automata[29][column] != null){
            if(automata.automata[29][column].isAlive()){
                neights++;
            }
        }
    
    }
    
    private void  neightBoursDer(){        
        if(automata.automata[row-1][30] != null){
            if(automata.automata[row-1][30].isAlive()){
                neights++;
            }
        }
        
        if(automata.automata[row+1][30] != null){
            if(automata.automata[row+1][30].isAlive()){
                neights++;
            }
        }
        
        if(automata.automata[row][29] != null){
            if(automata.automata[row][29].isAlive()){
                neights++;
            }
        }

    }
    
    private void  neightBoursIzq(){        
        if(automata.automata[row-1][0] != null){
            if(automata.automata[row-1][0].isAlive()){
                neights++;
            }
        }
        
        if(automata.automata[row+1][0] != null){
            if(automata.automata[row+1][0].isAlive()){
                neights++;
            }
        }
            
        if(automata.automata[row][1] != null){
            if(automata.automata[row][1].isAlive()){
                neights++;
            }
        }
    
    }
    
    private void neightBoursEs(){
        if(row ==0 && column ==0){
            neightBoursESD();
        }

        if(row ==0 && column ==30){
            neightBoursESI();
        }
        
        if(row ==30 && column ==0){
            neightBoursEID();
        }

        if(row ==30 && column == 30){
            neightBoursEII();
        }
        
    }
    
    private void neightBoursESD(){
        if(automata.automata[row+1][column] != null && automata.automata[row][column -1] != null){
            
            if(automata.automata[row][column-1].isAlive() && automata.automata[row+1][column].isAlive() ){
                neights += 2;
            }
        }
    }
    
    private void neightBoursESI(){
        if(automata.automata[row+1][column] != null && automata.automata[row][column + 1] != null){
            
            if(automata.automata[row][column+1].isAlive() && automata.automata[row+1][column].isAlive()){
                neights += 2;
            }
        }
    }

    private void neightBoursEID(){
        if(automata.automata[row-1][column] != null && automata.automata[row][column-1] != null){
            if(automata.automata[row][column-1].isAlive() && automata.automata[row-1][column].isAlive()){
                neights += 2;
            }
        }
    }

    private void neightBoursEII(){
        if(automata.automata[row-1][column] != null && automata.automata[row][column + 1] != null){
            if(automata.automata[row ][column+1].isAlive() && automata.automata[row-1][column].isAlive() && automata.automata[row-1][column] != null){
                neights += 2;
            }
        }
    }
    
    @Override
    /**Decide its next state
     */
    public void decide(){
        if(row ==0|| row == 30 || column ==0||  column ==30){
            neightBoursE();
            
        }else if((row ==0 && column ==0) || (row ==0 && column ==30) || (row ==30 && column ==0)|| (row ==30 && column == 30)){
            neightBoursEs();
            
        }else{
            neightBours();
        }
        
        if(neights < 2){
            nextState = Agent.DEAD;
        }else{
            nextState = Agent.ALIVE;
        }
        
        if (getAge()>=10){
            nextState=Agent.DEAD;
        }
    }
        
    public void getTicTacs(){
        if(automata.ticTacs % 10 == 0){
            if(automata.automata[row][column +1] == null){
                new Cell(automata, row, column + 1);
            }
            
            if(automata.automata[row][column-1] == null){
                new SociableCell(automata, row, column -1);
            }
        }
    }
    
}
