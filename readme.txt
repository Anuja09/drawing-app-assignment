Problem Statement:
__Description__

You're given the task of writing a simple console version of a drawing program. 
At this time, the functionality of the program is quire limited but this might change in the future. 
In a nutshell, the program should work as follows:
1. Create a new canvas
2. Start drawing on the canvas by issuing various commands
3. Quit

Command                Description
C w h           Should create a new canvas of width w and height h.
L x1 y1 x2 y2   Should create a new line from (x1,y1) to (x2,y2). Currently only
                horizontal or vertical lines are supported. Horizontal and vertical lines
                will be drawn using the 'x' character.
R x1 y1 x2 y2   Should create a new rectangle, whose upper left corner is (x1,y1) and
                lower right corner is (x2,y2). Horizontal and vertical lines will be drawn
                using the 'x' character.
B x y c         Should fill the entire area connected to (x,y) with "colour" c. The
                behaviour of this is the same as that of the "bucket fill" tool in paint
                programs.
Q               Should quit the program.
-----------------------------------------------------------------

SOLUTION=


Assumptions: for defining scope and keeping it a simple version
1. constraints, height, width
	1<=height<=200, 1<=width<=200
	1<=x<=width && 1<=y<=height
2. only alphabets allowed for buckefill
3. command names are case insensitive
4. For Q command - Ask for confirmation, do you want to quit, y/n?

Additions:for better user experience
1. H - the command for help of supported command usage
2. output console is having one implementation for rendering the canvas. And, can be extended to for different OutputConsoles e.g. FILE etc


Can be done in future:
1. Input adaptor can be added and extended to for handling user request from different user interfaces e.g. FILE, GUI etc
2. Can be enhanced to draw shapes like diagonal lines, triangle, pentagon etc	
3. Ask for confirmation, do you want to reset canvas, y/n?


To run application from jar
1. Go to /build folder on CMD where jar is present.
3. Execute command: java -jar drawing-app-1.0-SNAPSHOT.jar


To compile and run the application from source code drawaing-app:
1. Open drawing-app in editor of your choice. and gradle build.
2. jdk1.8, junit5.5, mockito 2.82 is used for developement.
3. DrawingApplication is the entry point class having main method. One need to run this class to start application.
4. When application is run, config.properties is loaded on startup.

----------------------------------------------------------------------------------
Sample output of my runs for the reference as below:

6:46:08 PM: Executing task 'DrawingApplication.main()'...

> Task :compileJava UP-TO-DATE
> Task :processResources UP-TO-DATE
> Task :classes UP-TO-DATE

> Task :DrawingApplication.main()
log:Configuration Initialized

Enter command: 
C 40 10
------------------------------------------
|                                        |
|                                        |
|                                        |
|                                        |
|                                        |
|                                        |
|                                        |
|                                        |
|                                        |
|                                        |
------------------------------------------

Enter command: 
L 2 1 2 6
------------------------------------------
| x                                      |
| x                                      |
| x                                      |
| x                                      |
| x                                      |
| x                                      |
|                                        |
|                                        |
|                                        |
|                                        |
------------------------------------------

Enter command: 
R 10 3 25 8
------------------------------------------
| x                                      |
| x                                      |
| x       xxxxxxxxxxxxxxxx               |
| x       x              x               |
| x       x              x               |
| x       x              x               |
|         x              x               |
|         xxxxxxxxxxxxxxxx               |
|                                        |
|                                        |
------------------------------------------

Enter command: 
L 8 1 8 10
------------------------------------------
| x     x                                |
| x     x                                |
| x     x xxxxxxxxxxxxxxxx               |
| x     x x              x               |
| x     x x              x               |
| x     x x              x               |
|       x x              x               |
|       x xxxxxxxxxxxxxxxx               |
|       x                                |
|       x                                |
------------------------------------------

Enter command:
B 4 5 g
------------------------------------------
|gxgggggx                                |
|gxgggggx                                |
|gxgggggx xxxxxxxxxxxxxxxx               |
|gxgggggx x              x               |
|gxgggggx x              x               |
|gxgggggx x              x               |
|gggggggx x              x               |
|gggggggx xxxxxxxxxxxxxxxx               |
|gggggggx                                |
|gggggggx                                |
------------------------------------------

Enter command: 
B rt
Syntax Error! Run 'H' command for details of supported commands.

Enter command: 
H
Supported Commands are 
C w h	-It create a new canvas of width w and height h.Constraints:1)1<=w<=200,1<=h<=200  2)1<=x<=w, 1<=y<=h for any x,y on canvas.
L x1 y1 x2 y2	-It creates a new line from (x1,y1) to (x2,y2). Currently only horizontal or vertical lines are supported. Horizontal and vertical lines will be drawn using the 'x' character.
R x1 y1 x2 y2	-It creates a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2). Horizontal and vertical lines will be drawn using the 'x' character.
B x y c	-It fill the entire area connected to (x,y) with colour c. The behaviour of this is the same as that of the 'bucket fill' tool in paint programs.
Q	-It quits the program.
H	-It list all supported commands.

Enter command: 
Q
Do you want to quit, y/n?
y
log:Application is terminated successfully.
------------------------------------------------------------
