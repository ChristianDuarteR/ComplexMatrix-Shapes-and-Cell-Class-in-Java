
/**
 * Write a description of class molecule here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class molecule extends Rectangle
{
    Rectangle cuadradoGrande=new Rectangle();
    Rectangle cuadradoPequeño=new Rectangle();
    char conectorC;
    char conectorS;
    /**
     * Constructor for class molecula without parameters
     */
    
    /**
     * Constructor fo class molecule with connectors
     */
    public molecule(char conectorC, char conectorS){
        cuadradoGrande.changeColor("black");
        cuadradoPequeño.changeColor("white");
        cuadradoPequeño.xPosition = cuadradoGrande.xPosition + 3;
        cuadradoPequeño.yPosition = cuadradoGrande.yPosition + 3;
        cuadradoPequeño.height = cuadradoGrande.height-6;
        cuadradoPequeño.width = cuadradoGrande.width-6;
        
        this.setConectorC(conectorC);
        this.setConectorS(conectorS);
        
        
    } 
    
    public void setConectorC(char conectorC){
        Rectangle conectorType1 = new Rectangle();
        conectorType1.height=5;
        conectorType1.width=5;
        switch(conectorC){
            case 'a':
                conectorType1.color="red";
            case 'b':
                conectorType1.color="yellow";
            case 'c':
                conectorType1.color="green";
            case 'd':
                conectorType1.color="magenta";
            case 'e':
                conectorType1.color="orange";
            case 'f':
                conectorType1.color="gray";
            case 'g':
                conectorType1.color="brown";
                
        }
        
    }
    
    public void setConectorS(char conectorS){
        if(conectorS=='+'){
            Circle conectorType2 = new Circle();
            conectorType2.diameter=5;
        }else{
            Triangle conectorType2 = new Triangle();
            conectorType2.height=5;
            conectorType2.width=5;
        }
    }
    
    public char getConector(int position){
        if (position==0){
            return conectorC;
        }else{
            return conectorS;
        }
    }
    
    public void makeVisible(){
        cuadradoGrande.makeVisible();
        cuadradoPequeño.makeVisible();
        
    }
}
