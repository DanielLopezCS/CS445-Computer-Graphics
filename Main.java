/************************************************************************************************************************************
* file: Main.java
* author: Daniel Lopez
* class: CS 445 - Computer Graphics
*
* assignment: Program 1
* date last modified: 10/10/2017
*
* purpose: This serves as a standard main class which calls into a driver class(in this case GraphicsController.java) 
* ----Information about the functionality of the program mostly detailed in the GraphicsController.java purpose description--------
************************************************************************************************************************************/
public class Main {
/*************************************************************************************************************************************
	method: main 
	purpose: This is the main class of the entire program. This is where it all starts by calling the driver class GraphicsController.java. 
	Not much is declared here.
	
*************************************************************************************************************************************/
    public static void main(String []args){
		//A simple call to the constructor of the driver class GraphicsController.java which will start everything.
      GraphicsController execute = new GraphicsController();
      execute.start();
    }
    
}
