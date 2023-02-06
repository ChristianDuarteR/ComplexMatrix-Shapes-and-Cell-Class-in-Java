import java.awt.*;
import java.awt.geom.*;

/**
 * A circle that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0.  (15 July 2000) 
 */

public class Circle extends Figure{

    public static final double PI=3.1416;
    
    protected double diameter;
    

    public Circle(){
        diameter = 30;
        xPosition = 20;
        yPosition = 15;
        color = "blue";
        isVisible = false;
    }
    

    public void draw(){
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color, 
                new Ellipse2D.Double(xPosition, yPosition, 
                diameter, diameter));
            canvas.wait(10);
        }
    }

    public void erase(){
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }

    /**
     * Change the size.
     * @param newDiameter the new size (in pixels). Size must be >=0.
     */
    public void changeSize(int newDiameter){
        erase();
        diameter = newDiameter;
        draw();
    }
    
    /**
     * return the perimeter of the circle.
     */
    public double perimetro(){
        return PI*diameter;
    }
    
    /**
     * Give a zoom to the circle with the same proportions
     * @param c the plus or the less. Valid c: "+", "-"
     */
    public void zoom(String c){
        diameter = (c =="+")? diameter*1.5:diameter*0.5;
        makeVisible();
    }
    
    /**
     *  makes the circle jump in the screen 
     *  @param times the number of times we want the circle "jumps"
     */
    public void jump(int times){
        if(times<0){
            System.out.print("times no debe tener un valor negativo");
        }else{
            for(int i=0;i<times;i++){
                slowMoveVertical(100);
                slowMoveVertical(-100);
            }
        }
    }
    
    /**
     * return the area of the circle
     */
    public double area(){
        return PI*(diameter/2)*(diameter/2);
    }



}
