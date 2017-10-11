/************************************************************************************************************************************
* file: GraphicsController.java
* author: Daniel Lopez
* class: CS 445 - Computer Graphics
*
* assignment: Program 1
* date last modified: 10/10/2017
*
* purpose: This program takes in data from a coordinates.txt text file and converts it to abstract
shapes which can be painted unto the screen using various shape drawing algorithms that use fill 
individual pixels using x and y coordinates repeatedly. For this project we use the OpenGL Java 
Bindings known as LWJGL. 

----- EXTRA FUNCTIONALITY: Press the Q Key To Change Line Color, W Key To Change Circle Color, E Key To Change Ellipse Color--------  																			
************************************************************************************************************************************/
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.input.Keyboard;



public class GraphicsController {
    
/************************************************************************************************************************************
	In order to more easily control color, the RGBManager will give changeable information about
	Line colors, Circle colors, and Ellipse colors.
************************************************************************************************************************************/
    private RGBManager rgbManager;
	//As our Width and Height will never change, we use 640 pixels for width and 480 pixels for height as a static constant
    private static final int WINDOW_WIDTH = 640;
    private static final int WINDOW_HEIGHT = 480;
    
    
/************************************************************************************************************************************
	   Method: GraphicsController(constructor)
       Purpose: Called from the Main class and creates an instance of the Graphics Controller for the Main class to use.
	   .
************************************************************************************************************************************/
    public GraphicsController(){
    
    }
/************************************************************************************************************************************
	   Method: start 
       Purpose: Called from the Main class in order to start the graphics process,
	   including creating the window, initializing the GL, and beginning rendering.
************************************************************************************************************************************/
    public void start(){
        try {
		
            createWindow();
            initGL();
            render();
        } catch (Exception e) {
        }
    }
/************************************************************************************************************************************
    Method: createWindow
    Purpose: Makes a usable window for the GL with a base width and height of 640x480
************************************************************************************************************************************/
    private void createWindow() throws Exception {
        Display.setFullscreen(false);
        Display.setDisplayMode(new DisplayMode(WINDOW_WIDTH, WINDOW_HEIGHT));
        Display.setTitle("Computer Graphics Assignment 1 <<Q W E To Change Colors>>");
        Display.create();
    }
/************************************************************************************************************************************
    Method: initGL
    Purpose:instantiates the GL and gives default values to what we will need to render.
	Because the RGBManager has not yet been initialized we do it here.
************************************************************************************************************************************/
    private void initGL() {
        glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        glMatrixMode(GL_PROJECTION); 
        glLoadIdentity();
        glOrtho(0, WINDOW_WIDTH, 0, WINDOW_HEIGHT, 1, -1);
        glMatrixMode(GL_MODELVIEW);
        glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
        //As we initialize the GL we will also initialize the RGBManager
        rgbManager = new RGBManager();
       
    }
/************************************************************************************************************************************
    Method: render
    Purpose: Takes in a text file and extracts the type of shape aswell as the crucial
	properties such as radius or endpoints for a line.
************************************************************************************************************************************/
    private void render() {
        
        ArrayList<Object> shapesToPaint = getShapes();
        while (!Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
            
            try {
                for(int i = 0; i < shapesToPaint.size(); i++)
                {
                    Object shape = shapesToPaint.get(i);
		//instanceof basically checks if a certain generic object is of a certain type like Line,Circle or Ellipse
                    if(shape instanceof Line){paintLine((Line)shape);}
                    else if(shape instanceof Circle){paintCircle((Circle)shape);}
                    else if(shape instanceof Ellipse){paintEllipse((Ellipse)shape);}
                }
                //This is where we update the window to show what we rendered
                Display.update();
		//Gives a standard 60 Frames Per Second
                Display.sync(60);
            } catch (Exception e) {
				
            }
        }
        Display.destroy();
        
    }
/************************************************************************************************************************************
    Method: getShapes
    Purpose: reads shapes from coordinate.txt and stores shape
    objects to array list. Line splitting is done by the .split method which works as follows:
	
	String line = "l_-15,-15,_150,180" (using underscore (_) instead of space to make the space more visible)
	String[] splitLine = line.split("_");   splitLine now equals [l,"-15,-15","150,180"]. (Notice that there are 3 elements in the array)
	String[] section1 = splitLine[1].split(","). section1 now equals ["-15","-15"] 'getting what comes after shape character' this is the first endpoint
																		x0	  y0
	String[] section2 = splitLine[2].split(","). section2 now equals ["150","180"] 'getting what comes after the second space' this is the second endpoint
																	    x1    y1

	From this point all we need to do is parse the values from a String type with Float.parseFloat().																		
     * @return 
************************************************************************************************************************************/
    public ArrayList<Object> getShapes()
    {
        ArrayList<Object> shapes = new ArrayList<>();
        try {
			//for this project we are using a coordinates.txt file but this can be edited inside the code
	    FileReader shapesFile = new FileReader("coordinates.txt");
			
            BufferedReader br = new BufferedReader(shapesFile);
			
            String line;
			//while there are still lines, continue reading and importing shapes	
            while ((line = br.readLine()) != null)
            {
                
                String[] splitLine = line.split(" ");
                
                switch (splitLine[0]) {
                    case "l":
                        String[] section1 = splitLine[1].split(",");
                        String[] section2 = splitLine[2].split(",");
                        float x0 = Float.parseFloat(section1[0]);
                        float y0 = Float.parseFloat(section1[1]);
                        float x1 = Float.parseFloat(section2[0]);
                        float y1 = Float.parseFloat(section2[1]);
                        //Cannot use keyword line as we are using that word for the string of text file sentences.
                        Line myLine = new Line(x0, y0, x1, y1);
                        System.out.println("Added A Line!");
                        shapes.add(myLine);
                        break;
                    case "c":
                        {
                            String[] centerCoordinates = splitLine[1].split(",");
                            float xCenter = Float.parseFloat(centerCoordinates[0]);
                            float yCenter = Float.parseFloat(centerCoordinates[1]);
                            float radius = Float.parseFloat(splitLine[2]);
                            Circle circle = new Circle(xCenter, yCenter, radius);
                            System.out.println("Added A Circle!");
                            shapes.add(circle);
                            break;
                        }
                    case "e":
                        {
                            String[] centerCoordinates = splitLine[1].split(",");
                            String[] radiusValues = splitLine[2].split(",");
                            float xCenter = Float.parseFloat(centerCoordinates[0]);
                            float yCenter = Float.parseFloat(centerCoordinates[1]);
                            float xRadius = Float.parseFloat(radiusValues[0]);
                            float yRadius = Float.parseFloat(radiusValues[1]);
                            Ellipse ellipse = new Ellipse(xCenter, yCenter, xRadius, yRadius);
                            System.out.println("Added An Ellipse!");
                            shapes.add(ellipse);
                            break;
                        }
                    default: 
                        System.out.println("Not A Valid Shape Type...");
                        break;
                }
                
            }
          
        } 
        catch (Exception ex) {
         
        } 
		//returns an ArrayList of objects with abstract shapes and their properties given by the textfile.
        return shapes;
    }
  
/************************************************************************************************************************************
    Method: paintLine
    Purpose: Uses the midpoint algorithm for finding the proper pixels to paint on the screen
	by measuring a line to see what pixel is closest to its true location and painting it.
	For this we need 
		dx - change in x
		dy - change in y
		incrementRight - how much to move right (E)
		incrementUpRight - how much to move up and to the right (NE) 
		d - the distance to the midpoint
		x- the current x value to plot
		y - the current y value to plot
		
	**PseudoCode Provided by "computer graphics: principles and practice 3rd ed. (our textbook)parts of chapters 7 & 18 "**
     * @param line
************************************************************************************************************************************/
    public void paintLine(Line line)
    {
		
        
        //m is the slope 
        float slope = (line.getY1()-line.getY0())/(line.getX1()-line.getX0());
		
		
        if(slope <= -1.0f || slope >= 1.0f){paintlineByRow(line);return;}
        //Attributes needed for the midpoint line algorithm
        float x=line.getX0();
        float y=line.getY0();
        float dx=line.getX1()-x;
        float dy=line.getY1()-y;
        float incrementRight=2*dy;
        float incrementUpRight=2*(dy-dx);
        float d=2*dy-dx;
		
		//Our last X point will be the final X point X1 from the Line
        float xFinal = line.getX1();
  
        paintPixel(x,y,rgbManager.getLineRGB());
        while (x < xFinal)
        {
            if(y < line.getY1())
            {
                if (d > 0) {d+=incrementUpRight;x++; y++;} 
                else {d+=incrementRight;x++;}
            }
            else{
                if (d > 0) {d+=incrementRight;x++;} 
                else {d+=incrementUpRight;x++;y--;}
               }
            paintPixel(x,y,rgbManager.getLineRGB());
        }
        
    }
/************************************************************************************************************************************
      method: paintlineByRow
      purpose: To take into account times when -1<slope<1 is not true as this would
	  mean that there will be gaps if we used the standard algorithm.
     * @param line	
************************************************************************************************************************************/
    public void paintlineByRow(Line line)
    {
		//Declaring all the essential attributes of a Line
        float x0 = line.getX0();
        float y0 = line.getY0();
        float x1 = line.getX1();
        float y1 = line.getY1();
		//If our final endpoint is lower than our initial we need to swap the intial and final values so the algorithm can function the same way
        if(line.getY0() > line.getY1()){x0 = line.getX1();y0 = line.getY1();x1 = line.getX0();y1 = line.getY0();}
        float dx = x1 - x0;
        float dy = y1 - y0;
      
	    //Using the standard midpoint line algorithm 
        float incrementUp = 2*dx;
        float incrementUpRight = 2 * (dx - dy);
        float yFinal = y1;
        float d= 2*dy - dx;
        
        
        paintPixel(x0,y0,rgbManager.getLineRGB());
        
        while(y0 < yFinal)
        {
            if(x1>x0)
            {
                if (d > 0){d += incrementUpRight;x0++; y0++;} 
                else {d += incrementUp;y0++;}
            }
            else
            {
                if (d > 0){d += incrementUp;y0++;} 
                else {d += incrementUpRight;x0--;y0++;}
                
            }
            paintPixel(x0,y0,rgbManager.getLineRGB());
        }
            
    }
/************************************************************************************************************************************
    Method: paintCircle
    Purpose: Paints a circle given properties from the passed circle around 360 degrees 
	by angle increments of .5 degrees. Requires only 1 radius to paint.
     * @param circle
************************************************************************************************************************************/
    public void paintCircle(Circle circle)
    {
	//Declaring all the essential attributes of a Circle
        float centerX = circle.getXCenter();
        float centerY = circle.getYCenter();
        float radius  = circle.getRadius();
        float angle = 0.0f;
        float x = 0.0f;
        float y = 0.0f;
        
        while(angle < 360.0f)
        {
            x =  radius * (float)Math.cos(angle);
            y =  radius * (float)Math.sin(angle);
            paintPixel(x + centerX, y + centerY, rgbManager.getCircleRGB());
            
           
            angle += .5;
          
        }
    }
/***********************************************************************************************************************************
    Method: paintEllipse
    Purpose: Paints an ellipse given properties from the passed ellipse around 360 degrees
    by angle increments of .5 degrees . Difference between an ellipse and circle is that an ellipse
    requires an x-radius and a y-radius instead of just one radius.
************************************************************************************************************************************/
    public void paintEllipse(Ellipse ellipse)
    {
		//Declaring all the essential attributes of an Ellipse
        float xRadius = ellipse.getXRadius();
        float yRadius = ellipse.getYRadius();
        float xCenter = ellipse.getXCenter();
        float yCenter = ellipse.getYCenter();
        float angle = 0.0f;
        float x = 0.0f;
        float y = 0.0f;
		
        while(angle < 360.0f)
        {
            x = xRadius * (float)Math.cos(angle);
            y =  yRadius * (float)Math.sin(angle);
            
            paintPixel(x + xCenter, y + yCenter, rgbManager.getEllipseRGB());
            angle += .5;
        }
    }
/************************************************************************************************************************************
    Method: paintPixel
    Purpose: Uses x,y coordinates to fill a pixel using glVertex2f on the window. Every paintShape method 
	will call this as every shape is painted by pinpointing a specific pixel to fill over and over again.
	Takes in the x and y coordinates as well as an rgb float which is gotten from the RGBManager's shape 
	specific rgb float array.
	----- 							EXTRA FUNCTIONALITY KEYS HERE Press Q,W,E To Test                                        -----------------------------------
************************************************************************************************************************************/
    public void paintPixel(float x, float y, float[] rgb)
    {
		//Q changes Line Color, W changes Circle Color, E changes Ellipse Color.
        if(Keyboard.isKeyDown(Keyboard.KEY_Q))rgbManager.changeLineColor();
        else if(Keyboard.isKeyDown(Keyboard.KEY_W))rgbManager.changeCircleColor();
        else if(Keyboard.isKeyDown(Keyboard.KEY_E))rgbManager.changeEllipseColor();
		//setting color of pixel
        glColor3f(rgb[0], rgb[1], rgb[2]);
        
		//The Actual Painting of the pixel.
        glBegin(GL_POINTS);
        glVertex2f(x, y);
        glEnd();      
    }


}