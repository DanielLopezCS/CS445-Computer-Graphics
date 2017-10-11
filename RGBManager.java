/************************************************************************************************************************************
* file: RGBManager.java
* author: Daniel Lopez
* class: CS 445 - Computer Graphics
*
* assignment: Program 1
* date last modified: 10/10/2017
*
* purpose: Serves as a color controller which stores information about the Red, Green, and Blue components of Lines,Circles, and Ellipses.
* This was meant to make the changing of colors easier and more intuitive.
************************************************************************************************************************************/
public class RGBManager {
  
    //These instance variables are the default colors for the Lines,Circles,and Ellipses.
    private float lineRGB[] = {255.0f,0.0f,0.0f};
    private float circleRGB[] = {0.0f,0.0f,255.0f};
    private float ellipseRGB[]= {0.0f,255.0f,0.0f};
   
/************************************************************************************************************************************
    Method: RGBManager (constructor)
    Purpose: Because we always want Lines to start Red, Circles to start Green, and Ellipses to start Blue, our default constructor will 
	not modify these attributes and therefore it will remain an empty method.
************************************************************************************************************************************/
    public RGBManager(){
         
    }
/************************************************************************************************************************************
    Method: getLineRGB
    Purpose: Returns the RGB array for Lines
************************************************************************************************************************************/
    public float[] getLineRGB(){
        return lineRGB;
    }
/************************************************************************************************************************************
    Method: getCircleRGB
    Purpose: Returns the RGB array for Circles
    ************************************************************************************************************************************/
    public float[] getCircleRGB(){
        return circleRGB;
    }
/************************************************************************************************************************************
    Method: getEllipseRGB
    Purpose: Returns the RGB array for Ellipses
************************************************************************************************************************************/
    public float[] getEllipseRGB(){
        return ellipseRGB;
    }
/************************************************************************************************************************************
    Method: changeLineColor
    Purpose: Changes the Line color float array to a predefined value which can be changed. The main purpose of this is to better understand
	how to change colors in real time of objects with OpenGL.
************************************************************************************************************************************/
    public void changeLineColor(){
        lineRGB[0] =   0f;
        lineRGB[1] =   50f;
        lineRGB[2] =  50f;
      
          
    }
/************************************************************************************************************************************
    Method: changeCircleColor
    Purpose: Changes the Circle color float array to a predefined value which can be changed. The main purpose of this is to better understand
	how to change colors in real time of objects with OpenGL.
************************************************************************************************************************************/
    public void changeCircleColor(){
       circleRGB[0] = 50f;
       circleRGB[1] = 0f;
       circleRGB[2] = 50f; 
    }
/************************************************************************************************************************************
    Method: changeEllipseColor
    Purpose: Changes the Ellipse color float array to a predefined value which can be changed. The main purpose of this is to better understand
	how to change colors in real time of objects with OpenGL.
************************************************************************************************************************************/
    public void changeEllipseColor(){
        ellipseRGB[0] = 50f;
        ellipseRGB[1] = 100f;
        ellipseRGB[2] = 55f;
        
         
    }
    
}
