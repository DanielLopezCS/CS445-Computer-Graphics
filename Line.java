/************************************************************************************************************************************
* file: Line.java
* author: Daniel Lopez
* class: CS 445 - Computer Graphics
*
* assignment: Program 1
* date last modified: 10/10/2017
*
* purpose: This Class is an abstract data type for an Line which will be an object stored in an ArrayList and later painted on
the main Window. A Line's core properties will be stored and easily called upon in the GraphicsController.java Class.
************************************************************************************************************************************/
public class Line {
	//Instantiates all key variables at a default value of 0.
    private float x0 = 0.0f;
    private float x1 = 0.0f;
    private float y0 = 0.0f;
    private float y1 = 0.0f;
    
/************************************************************************************************************************************
	Method: Line(params)(constructor)
	purpose: This is the constructor for a Line with all the properties needed to define a Line.

*************************************************************************************************************************************/
    public Line(float x0, float y0, float x1, float y1)
    {
        this.x0 = x0;
        this.x1 = x1;
        this.y0 = y0;
        this.y1 = y1;
    }
/*************************************************************************************************************************************
	*Method: Line()(constructor)
	*purpose: Another constructor which will create a default Line with values equal to 0.0f.
*************************************************************************************************************************************/
    public Line ()
    {
       
    }
/**************************************************************************************************************************************
* Method: getX0
* Purpose: Returns X0, which is the intial X poition of the line.
*************************************************************************************************************************************/
    public float getX0() {
        return x0;
    }
   
/**************************************************************************************************************************************
* Method: getX1
* Purpose: Returns X1, which is the final X poition of the line.
*************************************************************************************************************************************/
    public float getX1() {
        return x1;
    }
  
/**************************************************************************************************************************************
* Method: getY0
* Purpose: Returns Y0, which is the intial Y poition of the line.
*************************************************************************************************************************************/
    public float getY0() {
        return y0;
    }

/**************************************************************************************************************************************
* Method: getY1
* Purpose: Returns Y1, which is the final Y poition of the line.
*************************************************************************************************************************************/
    public float getY1() {
        return y1;
    }
  
  
 
    
}