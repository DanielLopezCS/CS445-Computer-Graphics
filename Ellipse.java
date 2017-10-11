/************************************************************************************************************************************
* file: Ellipse.java
* author: Daniel Lopez
* class: CS 445 - Computer Graphics
*
* assignment: Program 1
* date last modified: 10/10/2017
*
* purpose: This Class is an abstract data type for an Ellipse which will be an object stored in an ArrayList and later painted to
the main Window. An Ellipse's core properties will be stored and easily called upon in the GraphicsController.java Class.
************************************************************************************************************************************/
public class Ellipse {
	//Instantiates all key variables at a default value of 0.
    private float xCenter = 0.0f;
    private float yCenter = 0.0f;
    private float xRadius = 0.0f;
    private float yRadius = 0.0f;
	
/************************************************************************************************************************************
	Method: Ellipse(params)(constructor)
	purpose: This is the constructor for an Ellipse with all the properties needed to define an Ellipse.

*************************************************************************************************************************************/
   
    public Ellipse(float xCenter, float yCenter, float xRadius, float yRadius) {
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.xRadius = xRadius;
        this.yRadius = yRadius;
    }
/*************************************************************************************************************************************
*	Method: Ellipse()(constructor)
*	purpose: Another constructor which will create a default Ellipse with values equal to 0.0f.
*************************************************************************************************************************************/
    public Ellipse(){
        
    }
/**************************************************************************************************************************************
*   Method: getXCenter
*   Purpose: Returns the Center X of the Ellipse
*
*************************************************************************************************************************************/
    public float getXCenter() {
        return xCenter;
    }
   
/**************************************************************************************************************************************
*    Method: getYCenter
*    Purpose: Returns the Center Y of the Ellipse
*************************************************************************************************************************************/
    public float getYCenter() {
        return yCenter;
    }
    
/**************************************************************************************************************************************
	* Method: getXRadius
	* Purpose: Returns the X Radius of the Ellipse
*************************************************************************************************************************************/
    public float getXRadius() {
        return xRadius;
    }
  
/**************************************************************************************************************************************
	* Method: getYRadius
	* Purpose: Returns the Y Radius of the Ellipse
*************************************************************************************************************************************/
    public float getYRadius() {
        return yRadius;
    }
   
   
     
}