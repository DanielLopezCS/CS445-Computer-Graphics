/************************************************************************************************************************************
* file: Circle.java
* author: Daniel Lopez
* class: CS 445 - Computer Graphics
*
* assignment: Program 1
* date last modified: 10/10/2017
*
* purpose: This Class is an abstract data type for an Circle which will be an object stored in an ArrayList and later painted on
the main Window. A Circle's core properties will be stored and easily called upon in the GraphicsController.java Class.
************************************************************************************************************************************/
public class Circle {
    private float xCenter = 0.0f;
    private float yCenter = 0.0f;
    private float radius = 0.0f;
    
     
/************************************************************************************************************************************
	Method: Circle(params)(constructor)
	purpose: This is the constructor for a Circle with all the properties needed to define a Circle

*************************************************************************************************************************************/
    public Circle(float xCenter, float yCenter, float radius)
    {
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.radius = radius;
    }
/*************************************************************************************************************************************
	*Method: Line()(constructor)
	*purpose: Another constructor which will create a default Circle with values equal to 0.0f.
*************************************************************************************************************************************/
    public Circle()
    {
    }
 /**************************************************************************************************************************************
* 	Method: getXCenter
* 	Purpose: Returns the Center X of the Circle.
  
*************************************************************************************************************************************/
    public float getXCenter() {
        return xCenter;
    }
   
/**************************************************************************************************************************************
     * Method: getYCenter
     * Purpose: Returns the Center Y of the Circle
  
*************************************************************************************************************************************/
    public float getYCenter() {
        return yCenter;
    }
   
/**************************************************************************************************************************************
* Method: getRadius
* Purpose: Returns the radius of the Circle.
*************************************************************************************************************************************/
    public float getRadius() {
        return radius;
    }
   
    
 
}