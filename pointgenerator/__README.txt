PointGenerator user notes (program version 021214) :
-----------------------------------------------------

This file contains complete documentation on the use of this
program.

For quick (simple) help, type the letter "h" on the keyboard.

This program can be built by bringing up the JDK console and
going to the directory containing the program source code.  From
here, in the console menu, type "build" to compile all files

This program allows the user to create graphical objects and 
save the corresponding data points to a file in either absolute mode 
(relative to the upper right hand corner of the drawing area) or relative 
mode (relative to the yellow plus marker).  This file can
be read back into the application so that objects can be updated and/or
new objects added.

The output file contains lists of x and y data points for each object
drawn surrounded by {} for easy import to the user application.  In
relative mode (relative to the yellow plus marker) the user application
can shift the data in the X/Y directions and, if the user code converts
these points to polar coordinates relative to the 'yellow' reference
point, can also rotate the objects.  Object rotation in the user
code only works on polygons.

Bounding box coordinates are also computed for each object in the 
drawing area to provide a target rectangles to facilitate target
intercept logic in "projectile" applications.  Also, combined
bounding box coordinates are computed for all objects in the
drawing area for target area of compound objects.  In the latter
case, a new drawing/data file should be created for each compound 
object. 

There is a simple mode of operation when the constant SIMPLE_MODE
near the top if file PointGenerator.java is set to true.  In this
case, only the absolute mode of drawing can be performed 
(relative mode disabled).  Also in this case, a second data 
file is produced which contains Java coded snippets that can be directly 
pasted into the user paint application with the Java "draw" method
calls already completed for the user.  The name of this "simple" file
is the entered name of the file that the user entered in the write
operation prefixed with the word "simple".

The drawing area size can be controlled by changing the SIZE_X and
SIZE_Y constants near the top if file PointGenerator.java.  Use the 
'build.bat' file to re-build the application.  Placement of the GUI 
controls will limit the minimum drawing area size that the user can 
specify.  If the limit(s) are violated, an informative pop-up will 
appear after the first button activation indicating the changes 
necessary.

Use the absolute mode of operation for creating background landscapes
in the user application. When creating landscapes, it is suggested to 
size the drawing area slightly larger than the user's application drawing 
area to avoid gaps in the landscape around the edges of the drawing area.

For the more advanced mode of operation, it is suggested to create 
separate files - each with a single compound object (consisting of
one or more drawing shapes).  The transformation code in the user
application then can be optimized for each compound object.

Button functions :
------------------

POLY, ELLIPSE, RECT create polygon, ellipse and rectangle objects 
respectively.  Remember that only Polygon objects can be manipulated
in the user application (translation and/or rotation).

UNDO clears the last data point for the active POLY object and can 
be performed repetitively to remove previous data points in reverse 
order.

UNDO clears all data points for the active ELIPSE and RECT object.

CLEAR clears all data points for any selected object type.

NAME allows the user to add a supplemental name to the currently active
object.  These names are part of the data incorporated in the output
files so the user can easily associate the data points with corresponding
objects.

INCR & DECR walks the object selected on the drawing forward and backward.
The currently active object is indicated by different fill and line 
colors.

FILL changes the fill option for the currently active object.
The fill color and line boundary colors are appropriately
altered to indicate the currently active object.

MODE changes the drawing mode for all objects - absolute with respect 
to the upper left of the screen or relative to the yellow plus
mark in the middle of the drawing area.  This button is not available
when the application is built configured in the 'simple' mode of operation.

WRT allows the user to write the data to a file.
The written file will contain the master database which includes 
the absolute or relative data points for each object enclosed in {} symbols
for easy importing into the user application.  This file also contains 
the max/min xy values for each object and the max/min xy values associated 
with all objects in the drawing.  These values can define target area
limits for each sub-object of a compound object or for the whole 
compound object.  When operating in 'simple' mode of operation, a second 
file is created that has the word "simple" embedded in the user supplied
file name.  This file contains full Java code to draw all objects 
(in the absolute positioning mode).  In both files, the user name
for each object is written for easy identification of each object.

READ allows the user to retrieve data from a file.
The master data file is utilized to restore the drawing area and allow
update of existing data sets.


Keyboard functions :
------------------
In order to utilize selected keys on the keyboard, the application
must have the focus.  To do this, click on the title bar.  In this 
case, avoid clicking in the active drawing area as this will alter the 
state of the currently active object.

Arrow keys:
The arrow keys move the last data point of the selected object in the
direction of corresponding arrow key.

Alt arrow keys move the whole object in the direction of the selected 
arrow key.  As the object is moved, the position of the the first data
point of the active object is reflected in the lowest label in the label 
area. This data point is referenced to point 0,0 or the reference point
based on the data reference mode selected in the application.

Delete key removes the active object from the plot.

Insert key adds an object to the plot.
