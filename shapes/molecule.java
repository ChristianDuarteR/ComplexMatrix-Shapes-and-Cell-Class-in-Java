import java.util.Random;
/**
 * A molecula is a structure which have connectors like (A,B,C,D,E,F,G) and also have a sign (+,-)
 * They are two tipes of special connectos (**) and (00).
 *
 * @Christian Duarte, Miguel Tellez
 */
public class molecule
{
    private Rectangle cuadradoGrande=new Rectangle();
    private Rectangle cuadradoPequeño=new Rectangle();
    private String[] connectors;
    
    /**
     * Constructor for class molecule without connectors
     */
    public molecule(){  
        connectors = new String[4];
        cuadradoGrande.changeColor("black");
        cuadradoPequeño.changeColor("white");
        cuadradoPequeño.xPosition = cuadradoGrande.xPosition + 3;
        cuadradoPequeño.yPosition = cuadradoGrande.yPosition + 3;
        cuadradoPequeño.height = cuadradoGrande.height-6;
        cuadradoPequeño.width = cuadradoGrande.width-6;
        
        setRandomsConectors();
        this.makeVisible();
    }
    
    /**
     * Constructor fo class molecule with connectors
     */
    public molecule(String[] connectors){
        this.connectors = new String[4];
        this.connectors[0] = connectors[0];
        this.connectors[1] = connectors[1];
        this.connectors[2] = connectors[2];
        this.connectors[3] = connectors[3];
        
        cuadradoGrande.changeColor("black");
        cuadradoPequeño.changeColor("white");
        
        cuadradoPequeño.xPosition = cuadradoGrande.xPosition + 3;
        cuadradoPequeño.yPosition = cuadradoGrande.yPosition + 3;
        cuadradoPequeño.height = cuadradoGrande.height-6;
        cuadradoPequeño.width = cuadradoGrande.width-6;
        
        this.makeVisible();    
    }
    
    /** 
     * Initialize de conectors in the randoms letters and signs: (A,B,C,D,E,F,G) and (+,-,*,+)
     */
    private void setRandomsConectors(){ 
        String conectores1 [] = {"a","b","c","d","e","f","g"};
        String conectores2 [] = {"-","+","0","*"};
        
        for(int i=0; i<4;i++){
            connectors[i] = conectores1[getRamdomIndex(conectores1)] + conectores2[getRamdomIndex(conectores2)];
            if (connectors[i].charAt(1)=='0'|| connectors[i].charAt(1)=='*'){
                connectors[i] = connectors[i].substring(1) + connectors[i].substring(1);
            }
        }
    }
    
    /**
     * give a random index of a list of strings
     * @Param List of strings 
     */
    private int getRamdomIndex(String [] lista){
        Random numRamdom = new Random();
        int randomIndex = numRamdom.nextInt(lista.length);
        return randomIndex;
    }
    
    /**initializes the conectors for one molecule which has already his conectors
     * and then paint them at the molecule
     * @param conector to set
     */
    private void setConectores(){
        int veces=0;
        for(String e: connectors){
            
            Rectangle conectorType1 = new Rectangle();
            conectorType1.height=5;
            conectorType1.width=5;
            switch(e.toLowerCase().charAt(0)){
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
                case 'e'    :
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
            pintarConector1(e,conectorType1,veces);
        
            if(e.charAt(1)=='+'){
                Circle conectorType2 = new Circle();
                conectorType2.diameter=5;
                pintarConector2(e,conectorType2,veces);
            }else if(e.charAt(1)=='-'){
                Triangle conectorType2 = new Triangle();
                conectorType2.height=5;
                conectorType2.width=5;
                pintarConector2(e,conectorType2,veces);
            }else{
                Rectangle conectorType2 = new Rectangle();
                conectorType2.height=5;
                conectorType2.width=5;
                conectorType2.changeColor(conectorType1.color);
                pintarConector2(e,conectorType2,veces);
            }
        veces++;
        }
    }
    
    
    /**
     * paint the first conector(A,B,C,D,E,F,G) in the molecula
     * @Param conector 
     * @Param conector(form) 
     * 
     */
    private void pintarConector1(String conector, Rectangle conectorType, int veces){
        switch(veces){
            case 2:
                conectorType.xPosition = -7 + cuadradoGrande.xPosition + (cuadradoGrande.width)/2;
                conectorType.yPosition = -9 + cuadradoGrande.yPosition + (cuadradoGrande.height);
                break;
            case 1:
                conectorType.xPosition = -9 + cuadradoGrande.xPosition + (cuadradoGrande.width);
                conectorType.yPosition = -5 + cuadradoGrande.yPosition + (cuadradoGrande.height)/2;
                break;
            case 0:
                conectorType.xPosition = -7 + cuadradoGrande.xPosition + (cuadradoGrande.width)/2;
                conectorType.yPosition = 4 +cuadradoGrande.yPosition; 
                break;
            case 3:
                conectorType.xPosition = 4 +cuadradoGrande.xPosition;
                conectorType.yPosition = -5 + cuadradoGrande.yPosition + (cuadradoGrande.height)/2;
                break;
        }
        conectorType.makeVisible();
    }
    
    /**
     * paint the second conector(+,-,0,*) in the molecula
     * @Param conector 
     * @Param conector(form) 
     */
    private void pintarConector2(String conector, Figure conectorType, int veces){
        switch(veces){
            case 2:
                conectorType.xPosition = 2 + cuadradoGrande.xPosition + (cuadradoGrande.width)/2;
                conectorType.yPosition = -9 + cuadradoGrande.yPosition + (cuadradoGrande.height);
                break;
            case 1:
                conectorType.xPosition = -9 + cuadradoGrande.xPosition + (cuadradoGrande.width);
                conectorType.yPosition =  2 + cuadradoGrande.yPosition + (cuadradoGrande.height)/2;
                break;
            case 0:
                conectorType.xPosition = 2 + cuadradoGrande.xPosition + (cuadradoGrande.width)/2;
                conectorType.yPosition = 4 + cuadradoGrande.yPosition;
                break;
            case 3:
                conectorType.xPosition = 4 + cuadradoGrande.xPosition;
                conectorType.yPosition = 2 + cuadradoGrande.yPosition + (cuadradoGrande.height)/2;
                break;
        }
        conectorType.makeVisible();
    }
    
    /**
     * Changes the conectors of the molecule (if it is possible)
     */
    public void change(){
        char conectors[] = {'a','b','c','d','e','f','g'};

        for(int i=0;i<4;i++){
            if(connectors[i].charAt(0)!='0'&& connectors[i].charAt(0)!='*'){
                if(connectors[i].charAt(0) == 'g'){
                    connectors[i] = conectors[0] + connectors[i].substring(1);
                }else{
                    connectors[i] = conectors[indexOf(connectors[i])+1] + connectors[i].substring(1);
                }
            }
            makeVisible();
        }
    }
    
    /**
     * return the index where is located the letter of the conector
     * @Param the conector (A+,B-,D+,etc) 
     */
    private int indexOf(String conector){
        char conectors[] = {'a','b','c','d','e','f'};
        for (int i = 0; i < conectors.length; i++){
            if (conectors[i] == conector.charAt(0)){
                return i;
            }
        }return -1;
    }
    /**
     * return the conector in the position.
     * @Param position, the position has to be 12,3,6 or 9 in other case return "invalid number"
     */
    public String getConector(int position){
        switch(position){
            case 12:
                return (connectors[0]).toUpperCase();
            case 3:
                return (connectors[1]).toUpperCase();
            case 6:
                return (connectors[2]).toUpperCase();
            case 9:
                return (connectors[3]).toUpperCase();
            default:
                return "numero invalido";
        }
    }
    
    /**
     * Makes the molecule visible at the canvas.
     */
    public void makeVisible(){
        cuadradoGrande.makeVisible();
        cuadradoPequeño.makeVisible();
        setConectores();
    }

    /**
     * Makes the molecule invisible at the canvas.
     */
    public void makeInvisible(){
        cuadradoPequeño.makeVisible();
        cuadradoGrande.makeInvisible();
    }
    
}
