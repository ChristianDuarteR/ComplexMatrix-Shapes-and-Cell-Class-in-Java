/**
 * @author ECI, 2023
 *
 */
public class Matrix{
    
    protected double[][][] data;
   
    /**
     * @param data[][[][] the data with the valors of the matrix. 
     * Create a new matrix. If there is an error in the data, {{{0,0}}} is assumed
     */
    public Matrix (double data[][][]) {
        this.data = data;
    }
    
    /**
     * Get the dimension of the Matrix
     * @return an array 1D. 
     */
    public double [] dimension(){
        return data[0][0];
    }
    
    /**
     * @param f,c indicates the position at the matrix (f: "filas"), (c: "columnas")
     * Create a ComplexNumber with the first element real ant the other imaginary,
     * in the Matrix those elements are in [f][c]--->[0] and [f][c]--->[1]
     * @return a ComplexNumber
     */
    public ComplexNumber get(int f, int c){
        ComplexNumber MyNumber = new ComplexNumber(data[f][c][0],data[f][c][1]);
        return MyNumber;
    }
    
    /**
     * @param m another Matrix which it will be sum with our Matrix
     * Sum two matrix 
     * @return our matrix that has been sum.
     */
    public Matrix add(Matrix m){
        
        for(int i=0;i<data.length;i++){
            for(int j=0;j<data[0].length;i++){
                data[i][j][0] += m.data[i][j][0];
                data[i][j][1] += m.data[i][j][1];
            }
        }
        return this;
    }

    /**
     * @param m another Matrix which it will be substract with our Matrix
     * substract two matrix 
     * @return our matrix that has been substract.
     */
    public Matrix substract(Matrix m){
        
        for(int i=0;i<data.length;i++){
            for(int j=0;j<data[0].length;i++){
                data[i][j][0] -= m.data[i][j][0];
                data[i][j][1] -= m.data[i][j][1];
            }
        }
        return this;
    }
    
    /**
     * Traspone our Matrix (the rows will be our columns and the columns will be our rows)
     * @return  Our transponed Matrix
     */
    public Matrix transpone(){

        for(int i=0;i<data.length;i++){
            for(int j=0;j<data[0].length;i++){
                data[i][j][0] = data[j][i][0];
                data[i][j][1] = data[j][i][1];
            }
        }
        return this;
    }

    /**
     * @param rca indicates the type of the operation (r:row, c:column or a:all)
     */
    public Matrix add(char rca){
        return this;
    }
    
    /**
     * @param other another Matrix to compare if our matrix and the other are equals
     * Compare every number and array in the matrix to know if the Matrixs are equals
     * @return true if are equals, else false 
     */
    public boolean equals(Matrix other) {
        for(int i = 0;i<data.length;i++){
            if(data[i] == other.data[i]){
                
                for(int j=0; j<data[i].length;j++){
                    if(data[i][j] == other.data[i][j]){
                        
                        for(int k=0;k<other.data[i][j].length;k++){
                            if(data[i][j][k] != other.data[i][j][k]){
                                return false;
                            }
                        }
                        
                    }else return false;
                }
                
            }else return false;
        }return true;
    }
    
    @Override
    public boolean equals(Object otra) {
            return equals((Matrix)otra);
    }
    
    
    public void imprimirMatriz () {
        for(int i=0;i<data.length;i++){
            
            System.out.print("\n capa "+ i + "\n\t");

            for(int j=0;j<data[i].length;j++){
                
                for(int k=0;k<data[i][j].length;k++){  
                    
                System.out.print(data[i][j][k] + "   "); 
                    
                }
                System.out.print("\n\n\t");
            }
        }
        
    }   
 
}
