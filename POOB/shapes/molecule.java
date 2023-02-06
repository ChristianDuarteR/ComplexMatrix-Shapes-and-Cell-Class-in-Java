
/**
 * A molecula is a structure which have connectors like (A,B,C,D,E,F,G) and also have a sign (+,-)
 * They are two tipes of special connectos (**) and (00).
 *
 * @Christian Duarte, Miguel Tellez
 */
public class molecule extends Figure
{
    Rectangle cuadradoGrande=new Rectangle();
    Rectangle cuadradoPequeño=new Rectangle();
    String conector12,conector3,conector6,conector9;
    
    /**
     * Constructor fo class molecule with connectors
     */
    public molecule(String conector12, String conector3, String conector6, String conector9){
        cuadradoGrande.changeColor("black");
        cuadradoPequeño.changeColor("white");
        cuadradoPequeño.xPosition = cuadradoGrande.xPosition + 3;
        cuadradoPequeño.yPosition = cuadradoGrande.yPosition + 3;
        cuadradoPequeño.height = cuadradoGrande.height-6;
        cuadradoPequeño.width = cuadradoGrande.width-6;
        
        this.makeVisible();
        this.setConector(conector12);
        this.setConector(conector3);
        this.setConector(conector6);
        this.setConector(conector9);
        
    } 
    
    public void setConector(String conector){       
        
        Rectangle conectorType1 = new Rectangle();
        conectorType1.height=5;
        conectorType1.width=5;

        switch(conector.charAt(0)){
            case 'a':
                conectorType1.color="red";
                break;
            case 'b':
                conectorType1.color="yellow";
                break;
            case 'c':
                conectorType1.color="green";
                break;
            case 'd':
                conectorType1.color="magenta";
                break;
            case 'e':
                conectorType1.color="orange";
                break;
            case 'f':
                conectorType1.color="gray";
                break;
            case 'g':
                conectorType1.color="brown";
                break;
            default:
                conectorType1.color="pink";
                break;
        }
        
        pintarConector1(conector,conectorType1);
        
        if(conector.charAt(1)=='+'){
            Circle conectorType2 = new Circle();
            conectorType2.diameter=5;
            pintarConector2(conector,conectorType2);
        }else if(conector.charAt(1)=='-'){
            Triangle conectorType2 = new Triangle();
            conectorType2.height=5;
            conectorType2.width=5;
            pintarConector2(conector,conectorType2);
        }else{
            Rectangle conectorType2 = new Rectangle();
            conectorType2.height=5;
            conectorType2.width=5;
            conectorType2.color = conectorType1.color;
            pintarConector2(conector,conectorType2);
        }
    
    }
    
    public void pintarConector1(String conector, Rectangle conectorType){
        switch(conector.charAt(0)){
            case '1':
                conectorType.xPosition = -6 + cuadradoGrande.xPosition + (cuadradoGrande.width)/2;
                conectorType.yPosition = -5 + cuadradoGrande.yPosition + (cuadradoGrande.height);
                break;
            case '3':
                conectorType.xPosition = -11 + cuadradoGrande.xPosition + (cuadradoGrande.width);
                conectorType.yPosition = -3 + cuadradoGrande.yPosition + (cuadradoGrande.height)/2;
                break;
            case '6':
                conectorType.xPosition = -6 + cuadradoGrande.xPosition + (cuadradoGrande.width)/2;
                break;
            case '9':
                conectorType.yPosition = -3 + cuadradoGrande.yPosition + (cuadradoGrande.height)/2;
                break;
        }
        conectorType.makeVisible();
    }
    
    public void pintarConector2(String conector, Figure conectorType){
        switch(conector.charAt(1)){
            case '1':
                conectorType.xPosition = cuadradoGrande.xPosition + (cuadradoGrande.width)/2;
                conectorType.yPosition = cuadradoGrande.yPosition + (cuadradoGrande.height);
                break;
            case '3':
                conectorType.xPosition = cuadradoGrande.xPosition + (cuadradoGrande.width);
                conectorType.yPosition = cuadradoGrande.yPosition + (cuadradoGrande.height)/2;
                break;
            case '6':
                conectorType.xPosition = cuadradoGrande.xPosition + (cuadradoGrande.width)/2;
                break;
            case '9':
                conectorType.yPosition = cuadradoGrande.yPosition + (cuadradoGrande.height)/2;
                break;
        }
        conectorType.makeVisible();
    }
  
    public String getConector(int position){
        switch(position){
            case 12:
                return conector12;
            case 3:
                return conector3;
            case 6:
                return conector6;
            case 9:
                return conector9;
            default:
                return "numero invalido";
        }
    }
    
    public void makeVisible(){
        cuadradoGrande.makeVisible();
        cuadradoPequeño.makeVisible();
    }
    
    public void erase(){
        
    }
    
    public void draw(){
    
    }
}
