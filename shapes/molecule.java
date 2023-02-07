
/**
 * A molecula is a structure which have connectors like (A,B,C,D,E,F,G) and also have a sign (+,-)
 * They are two tipes of special connectos (**) and (00).
 *
 * @Christian Duarte, Miguel Tellez
 */
public class molecule extends Figure
{
    private Rectangle cuadradoGrande=new Rectangle();
    private Rectangle cuadradoPequeño=new Rectangle();
    private String conector12,conector3,conector6,conector9;
    
    /**
     * Constructor fo class molecule with connectors
     */
    public molecule(String conector12, String conector3, String conector6, String conector9){
        this.conector12 = conector12;
        this.conector3 = conector3;
        this.conector6 = conector6;
        this.conector9 = conector9;
        
        cuadradoGrande.changeColor("black");
        cuadradoPequeño.changeColor("white");
        cuadradoPequeño.xPosition = cuadradoGrande.xPosition + 3;
        cuadradoPequeño.yPosition = cuadradoGrande.yPosition + 3;
        cuadradoPequeño.height = cuadradoGrande.height-6;
        cuadradoPequeño.width = cuadradoGrande.width-6;
        
        conector12+='1';
        conector3+='3';
        conector6+='6';
        conector9+='9';
        
        this.makeVisible();
        this.setConector(conector12);
        this.setConector(conector3);
        this.setConector(conector6);
        this.setConector(conector9);
        
    }
    
    private void setConector(String conector){
        
        Rectangle conectorType1 = new Rectangle();
        conectorType1.height=5;
        conectorType1.width=5;

        switch(conector.charAt(0)){
            case 'a':
                conectorType1.changeColor("red");
                break;
            case 'b':
                conectorType1.changeColor("yellow");
                break;
            case 'c':
                conectorType1.changeColor("green");
                break;
            case 'd':
                conectorType1.changeColor("magenta");
                break;
            case 'e':
                conectorType1.changeColor("orange");
                break;
            case 'f':
                conectorType1.changeColor("gray");
                break;
            case 'g':
                conectorType1.changeColor("cyan");
                break;
            default:
                conectorType1.changeColor("pink");
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
            conectorType2.changeColor(conectorType1.color);
            pintarConector2(conector,conectorType2);
        }
    
    }
    
    public void pintarConector1(String conector, Rectangle conectorType){
        switch(conector.charAt(2)){
            case '6':
                conectorType.xPosition = -7 + cuadradoGrande.xPosition + (cuadradoGrande.width)/2;
                conectorType.yPosition = -9 + cuadradoGrande.yPosition + (cuadradoGrande.height);
                break;
            case '3':
                conectorType.xPosition = -9 + cuadradoGrande.xPosition + (cuadradoGrande.width);
                conectorType.yPosition = -5 + cuadradoGrande.yPosition + (cuadradoGrande.height)/2;
                break;
            case '1':
                conectorType.xPosition = -7 + cuadradoGrande.xPosition + (cuadradoGrande.width)/2;
                conectorType.yPosition = 4 +cuadradoGrande.yPosition; 
                break;
            case '9':
                conectorType.xPosition = 4 +cuadradoGrande.xPosition;
                conectorType.yPosition = -5 + cuadradoGrande.yPosition + (cuadradoGrande.height)/2;
                break;
        }
        conectorType.makeVisible();
    }
    
    public void pintarConector2(String conector, Figure conectorType){
        switch(conector.charAt(2)){
            case '6':
                conectorType.xPosition = 2 + cuadradoGrande.xPosition + (cuadradoGrande.width)/2;
                conectorType.yPosition = -9 + cuadradoGrande.yPosition + (cuadradoGrande.height);
                break;
            case '3':
                conectorType.xPosition = -9 + cuadradoGrande.xPosition + (cuadradoGrande.width);
                conectorType.yPosition =  2 + cuadradoGrande.yPosition + (cuadradoGrande.height)/2;
                break;
            case '1':
                conectorType.xPosition = 2 + cuadradoGrande.xPosition + (cuadradoGrande.width)/2;
                conectorType.yPosition = 4 + cuadradoGrande.yPosition;
                break;
            case '9':
                conectorType.xPosition = 4 + cuadradoGrande.xPosition;
                conectorType.yPosition = 2 + cuadradoGrande.yPosition + (cuadradoGrande.height)/2;
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
