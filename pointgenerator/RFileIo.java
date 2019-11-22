/*---------------------------------------------------------------------
--
-- RFileIo
--
---------------------------------------------------------------------*/

//import java.io.*;
import java.util.ArrayList;
import java.lang.Exception;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.File;
import java.awt.EventQueue;
import java.lang.Math;
import javax.swing.JFileChooser;
import javax.swing.filechooser.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.SwingUtilities;
public class RFileIo
{
    public static String m_fileErrMsg = "";
    private String m_xLabel;
    private String m_yLabel;
    private String m_pointsLabel;
    private String m_newObjectDelimiter;
    private String m_maxMinDisplayDelimiter;
    private String m_objectName;
    private String m_fileName;
    private int m_lineType;
    private int m_objType;
    private String m_polygon;
    private String m_elipse;
    private String m_rectangle;
    private String m_maxIndexStr;
    private int m_sizeX;
    private int m_sizeY;
    private int m_maxDataIndex;
    private String m_refLabel;
    private String m_absoluteRef;
    private String m_relativeRef;
    private String m_userLabel;
    private String m_objectDirectory;
    private String m_blankFill;
    private JFileChooser m_chooser;
    
    private int m_refX;
    private int m_refY;
    private boolean m_absolutePosintioning;
    
    private final int OBJ_TYPE_NONE = 0;
    private final int OBJ_TYPE_POLYGON = 1;
    private final int OBJ_TYPE_ELIPSE = 2;
    private final int OBJ_TYPE_RECTANGLE = 3;
    
    private final int LINE_TYPE_NONE = 0;
    private final int LINE_TYPE_OBJECT_NAME = 1;
    private final int LINE_TYPE_POINT_CNT = 2;
    private final int LINE_TYPE_DATA_VALS = 3;
    private final int LINE_TYPE_DATA_X_VALS = 4;
    private final int LINE_TYPE_DATA_Y_VALS = 5;
    
    //----------------------------------
    // Method 'local' variables
    int m_indexMax;    
    int[] m_pointsX;
    int[] m_pointsY;
    int[] m_pointsWrt;
    int m_bigMaxX = Integer.MIN_VALUE;
    int m_bigMinX = Integer.MAX_VALUE;
    int m_bigMaxY = Integer.MIN_VALUE;
    int m_bigMinY = Integer.MAX_VALUE;
    PrintWriter m_pwSimple = null;
    PrintWriter m_pw = null;
   
    
//----------------------------------------------------------------------
// Constructor

    RFileIo()
    {
        m_xLabel = "X Data :";
        m_yLabel = "Y Data :";
        m_pointsLabel = "Number Of Points : ";
        m_maxIndexStr = m_pointsLabel;
        m_objectName = "Object :";
        m_polygon = " - Polygon";
        m_elipse = " - Ellipse";
        m_rectangle = " - Rectangle";
        m_refLabel = "Reference Data X, Y ";
        m_absoluteRef = "(Data Relative to 0,0) : ";
        m_relativeRef = "(Data Relative to Ref Data) : ";
        m_userLabel = "User Label : ";
        m_maxDataIndex = 0;
        m_sizeX = PointGenerator.SIZE_X;
        m_sizeY = PointGenerator.SIZE_Y;
        m_newObjectDelimiter = "________________________________________________";
        m_maxMinDisplayDelimiter = "{Min X, Max X}, {Min Y, Max Y}";
        m_objectDirectory = "DataFiles";
        m_blankFill = "    ";
        m_fileName = "";
        
        m_refX = 0;
        m_refY = 0;
        m_absolutePosintioning = false;
        
        // File selection dialog  
        m_chooser = new JFileChooser(".");

        FileFilter filterTxt = new FileNameExtensionFilter("TXT file", "txt", "txt");
        m_chooser.addChoosableFileFilter(filterTxt);
    }     
    
//----------------------------------------------------------------------
// Top level function to write generated data to a file. Calls writeDataPoints
// to output the data points for each object in the database.
    public void writeFile(ArrayList<RShape> shapes, int refPosX, int refPosY,
                          boolean isAbsolute)
    {
        m_bigMaxX = Integer.MIN_VALUE;
        m_bigMinX = Integer.MAX_VALUE;
        m_bigMaxY = Integer.MIN_VALUE;
        m_bigMinY = Integer.MAX_VALUE;
        File dataFile;
        String filePath = "";
        String filePathSimple = "";
        boolean fileError = false;
        boolean doSimple = PointGenerator.SIMPLE_MODE;
        try
        {
            // Select the file
            boolean nameError = true;
            m_chooser.setDialogTitle("Write File - name must be \"name.\" or \"name.txt\"");
            int returnVal = m_chooser.showSaveDialog(PointGenerator.thisJFrame);
            if(returnVal == JFileChooser.APPROVE_OPTION)
            {
                String fileName = m_chooser.getSelectedFile().getName();
                String path = m_chooser.getSelectedFile().getParent();
                if(fileName != null)
                {               
                    if((!fileName.toLowerCase().endsWith(".")) &&
                       (!fileName.toLowerCase().endsWith(".txt")))
                    {                        
                        // Invoke JOptionPane from the event queue (invokeLater)
                        PointGenerator.thisJFrame.repaint();
                        SwingUtilities.invokeLater(new Runnable()
                        {
                            public void run()
                            {
                                String errMsg = "Filename error - must end with" +
                                        " \".\" or \".txt\"" + "\n" +
                                        "File operation aborted";
                                JOptionPane.showMessageDialog(null,errMsg, "ERROR",
                                                JOptionPane.ERROR_MESSAGE);
                            }
                        });
                        return;
                    }

                    m_fileName = fileName;
                    m_objectDirectory = path;
                }
            }
            else
            {
                // Invoke JOptionPane from the event queue (invokeLater)
                PointGenerator.thisJFrame.repaint();
                SwingUtilities.invokeLater(new Runnable()
                {
                    public void run()
                    {
                        String errMsg = "No File Specified" + "\n" +
                                        "File operation aborted";
                        JOptionPane.showMessageDialog(null,errMsg, "ERROR",
                                        JOptionPane.ERROR_MESSAGE);
                    }
                });
                return;                
            }
            
            // Set the file names for the file to contain the advanced
            // file content and the file to contain the simple file
            // content.
            filePath = m_objectDirectory + "/" + m_fileName; 
            filePathSimple = m_objectDirectory + "/simple" + m_fileName;

            // Open the files.
            m_pw = new PrintWriter(filePath);
            //m_pwSimple = new PrintWriter(m_objectDirectory + "/__deleteMeFile.txt");
            //m_pwSimple.close();
            if(doSimple)
            {
                m_pwSimple = new PrintWriter(filePathSimple);
            }
            m_pw.println(m_newObjectDelimiter);
            m_pw.print(m_refLabel);
            if(isAbsolute)
            {
                m_pw.println(m_absoluteRef + "  " + refPosX + "  " + refPosY);
            }
            else
            {
                m_pw.println(m_relativeRef + "  " + refPosX + "  " + refPosY);
            }
            
            // For each shape.
            int dataLabSimpleSuf = 0;
            if(doSimple) {m_pwSimple.println(m_blankFill + "//------------------");}
            for(RShape object : shapes)
            {
                if(!object.getPlotOk())
                {
                    continue;
                }
                boolean doSimplePoly = doSimple && (object instanceof RLine);
                if(doSimplePoly) {dataLabSimpleSuf++;}
                
                // Get object parameters.
                m_indexMax = object.getPointsIndex();
                m_pointsX = object.getPointsX();
                m_pointsY = object.getPointsY();
                
                // Object name
                m_pw.println(m_newObjectDelimiter);
                m_pw.println(object.getBaseName());
                m_pw.println(m_userLabel + object.getUserName());
                if((object instanceof RElipse) || (object instanceof RRectangle))
                {
                    m_pw.println("Data is represented as : " +
                                 "{x posLow, x posHigh} {y posLow, y posHigh}");
                    m_pw.println("Subtract \"Low\" values from \"High\" values " +
                                "to get data compatible\nwith JAVA" +
                                " drawOval, fillOval, drawRect, fillRect"); 
                }
                else
                {
                    m_pw.println("Data is represented as a sequence of x and then y values");
                }
                m_pw.println(m_pointsLabel + (m_indexMax + 1));
                if(doSimple)
                {
                    m_pwSimple.println(m_blankFill + "//" + object.getBaseName());
                    m_pwSimple.println(m_blankFill + "//" + m_userLabel + 
                                        object.getUserName());
                }
                
                // Write the data points and min/max values.
                writeDataPoints(refPosX, refPosY, isAbsolute, object, doSimple,
                                dataLabSimpleSuf);
            }
            // Print Max/Min x/y of  for all shapes for defining target envelope
            // For user's application.
            m_pw.println("-----------");
            m_pw.println("(ALL DATA {Min X, Max X}, {Min Y, Max Y}");
            m_pw.printf("{%6d,%6d} {%6d,%6d}", 
                        m_bigMinX, m_bigMaxX, m_bigMinY, m_bigMaxY);
            m_pw.close();
            if(doSimple)
            {
                m_pwSimple.close();
            }
        } catch (Exception e) 
        {                        
            // Invoke JOptionPane from the event queue (invokeLater)
            PointGenerator.thisJFrame.repaint();
            SwingUtilities.invokeLater(new Runnable()
            {
                public void run()
                {
                    String errMsg = "General I/O Error" + "\n" +
                                    "File operation aborted.";
                    JOptionPane.showMessageDialog(null,errMsg, "ERROR",
                                    JOptionPane.ERROR_MESSAGE);
                                JOptionPane.showMessageDialog(null,errMsg, "ERROR",
                                    JOptionPane.ERROR_MESSAGE);
                }
            });
        }
        
        m_fileErrMsg = "File Operation Completed :";
        m_fileErrMsg += "\n\nRaw Data File : " + m_fileName;

        
        if(doSimple)
        {
            m_fileErrMsg += "\n\nJava Code Data File : simple" + m_fileName;
        }

        m_fileErrMsg += "\n\n";
        
        // Invoke JOptionPane from the event queue (invokeLater)
        PointGenerator.thisJFrame.repaint();
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                JOptionPane.showMessageDialog(null,m_fileErrMsg,
                    "INFO", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        

    }
//----------------------------------------------------------------------
// Called to output data points for a single object. X & Y envelope is
// also computed for the single object.  If program is set to generate
// full Java graphics calls in addition to raw data arrays 
// data for the full graphics call will be writtent to the(doSimple is true)
// "simple" file too.
    private void writeDataPoints( int refPosX, int refPosY, boolean isAbsolute,
                                RShape object, boolean doSimple,
                                int dataLabSimpleSuf)
    {
        String xLabelBase = "int[] xdata" + dataLabSimpleSuf + " = ";
        String yLabelBase = "int[] ydata" + dataLabSimpleSuf + " = ";
        
        // Set up for writing the X data.
        String label = m_xLabel;
        m_pointsWrt = m_pointsX;
        int refPoint = refPosX;
        String simpleLabel = xLabelBase;
        
        // Initialize object max/min evelope data.
        int maxX = 0;
        int minX = 0;
        int maxY = 0;
        int minY = 0;
        boolean doSimplePoly = doSimple && (object instanceof RLine);
        
        // For X and then Y data arrays.
        for(int arrSel = 0; arrSel < 2; arrSel++)
        {
            // Max/Min
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
        
            // print the X or Y data label.
            m_pw.println("-----------");
            m_pw.println(label);
            if(doSimplePoly)
            {
                m_pwSimple.println(m_blankFill + simpleLabel);
            }
            
            // For each data point.
            for(int i = 0; i <= m_indexMax; i++)
            {
                int val = m_pointsWrt[i] - refPoint;
        
                // Update max/min
                min = Math.min(min, val);
                max = Math.max(max, val);
                
                // Output the data.
                boolean lineStart = false;
                // Start of new line in data array
                if(i == 0)
                {                            
                    m_pw.printf("{%6d,", val);
                    if(doSimplePoly) 
                    {
                        m_pwSimple.print(m_blankFill);
                        m_pwSimple.printf("{%6d,",val);
                    }
                }
                // End of data for data array
                else if(i == m_indexMax)
                {
                    m_pw.printf("%6d}", val);
                    if(doSimplePoly) 
                    {
                        if(lineStart)
                        {
                            m_pwSimple.print(m_blankFill);
                            lineStart = false;
                        }
                        m_pwSimple.printf("%6d};", val);
                    }
                }
                // Write last data point for data array
                else if((i % 8) == 7)
                {
                    m_pw.printf("%6d,\r\n ", val);
                    if(doSimplePoly) 
                    {
                        m_pwSimple.printf("%6d,\r\n ", val);
                        lineStart = true;
                    }
                }
                // Normal data in data array - not start new line, last in line,
                // last data point
                else
                {
                    m_pw.printf("%6d,", val);
                    if(doSimplePoly) 
                    {
                        if(lineStart)
                        {
                            m_pwSimple.print(m_blankFill);
                            lineStart = false;
                        }
                        m_pwSimple.printf("%6d,", val);
                    }
                }
            }
            
            // Determine which max/min (X Y) that we computed.
            if(arrSel == 0)
            {
                maxX = max;
                minX = min;
                m_bigMaxX = Math.max(m_bigMaxX, maxX);
                m_bigMinX = Math.min(m_bigMinX, minX);
            }
            else
            {
                maxY = max;
                minY = min;
                m_bigMaxY = Math.max(m_bigMaxY, maxY);
                m_bigMinY = Math.min(m_bigMinY, minY);
            }
            
            // Set parameters for Y data for next loop iteration
            m_pw.println("");
            if(doSimplePoly) {m_pwSimple.println("");}
            label = m_yLabel;                    
            simpleLabel = yLabelBase;
            m_pointsWrt = m_pointsY;
            refPoint = refPosY;                
        }
        
        // Output Java graphics code block for simplified data file. 
        boolean doSimpleElipse = doSimple && (object instanceof RElipse);
        boolean doSimpleRect = doSimple && (object instanceof RRectangle);
        
        // For Polygon
        if(doSimplePoly)
        {
            int pnts = m_indexMax + 1;
            String str = m_blankFill + "wnd.fillPolygon(xdata" + 
                        dataLabSimpleSuf + ", ydata" +
                        dataLabSimpleSuf + ", " + pnts + ");";
            m_pwSimple.println(str);
            m_pwSimple.println(m_blankFill + "//------------------");
        }
        
        // For ellipse
        if(doSimpleElipse)
        {
            String str = m_blankFill + "wnd.fillOval(" + m_pointsX[0] +
                        ", " + m_pointsY[0] + ", " +
                        (m_pointsX[1] - m_pointsX[0] + 1) + ", " +
                        (m_pointsY[1] - m_pointsY[0] + 1) +");";
            m_pwSimple.println(str);
            m_pwSimple.println(m_blankFill + "//------------------");
        }
        
        // For rectangle.
        else if(doSimpleRect)
        {
            String str = m_blankFill + "wnd.fillRect(" + m_pointsX[0] + 
                        ", " + m_pointsY[0] + ", " +
                        (m_pointsX[1] - m_pointsX[0] + 1) + ", " +
                        (m_pointsY[1] - m_pointsY[0] + 1) +");";
            m_pwSimple.println(str);
            m_pwSimple.println(m_blankFill + "//------------------");
        }
        
        // Output min/max x/y values current object written to file
        // for use in providing target "hit" coordinates for 
        // user's app (for current object).
        m_pw.println("-----------");
        m_pw.println(m_maxMinDisplayDelimiter);
        m_pw.printf("{%6d,%6d} {%6d,%6d}\r\n", minX, maxX, minY, maxY);
    }
//----------------------------------------------------------------------
    public ArrayList<RShape> readFile()
    {
        int objIndex = 0;
        int fileDataLine = 0; 
        RShape shape =  new RRectangle(m_sizeX, m_sizeY, objIndex);

        
        ArrayList<RShape> createdShapes = new ArrayList<RShape>();
        try
        {
            // Select the file
            boolean nameError = true;
            m_chooser.setDialogTitle("Write File - name must be \"name.\" or \"name.txt\"");
            int returnVal = m_chooser.showOpenDialog(PointGenerator.thisJFrame);
            if(returnVal == JFileChooser.APPROVE_OPTION)
            {
                String fileName = m_chooser.getSelectedFile().getName();
                String path = m_chooser.getSelectedFile().getParent();
                if(fileName != null)
                {               
                    if((!fileName.toLowerCase().endsWith(".")) &&
                       (!fileName.toLowerCase().endsWith(".txt")))
                    {                                                            
                        // Invoke JOptionPane from the event queue (invokeLater)
                        PointGenerator.thisJFrame.repaint();
                        SwingUtilities.invokeLater(new Runnable()
                        {
                            public void run()
                            {
                                String errMsg = "Filename error - must end with" +
                                        " \".\" or \".txt\"" + "\n" +
                                        "File operation aborted";
                                JOptionPane.showMessageDialog(null,errMsg, "ERROR",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                        });                                    
                        return createdShapes;
                    }

                    m_fileName = fileName;
                    m_objectDirectory = path;
                }
            }
            else
            {
                // Invoke JOptionPane from the event queue (invokeLater)
                PointGenerator.thisJFrame.repaint();
                SwingUtilities.invokeLater(new Runnable()
                {
                    public void run()
                    {
                        String errMsg = "No File Specified" + "\n" +
                                        "File operation aborted";
                        JOptionPane.showMessageDialog(null,errMsg, "ERROR",
                        JOptionPane.ERROR_MESSAGE);
                    }
                });
                                
                return createdShapes;                
            }
            
            // Open file.
            String filePath = m_objectDirectory + "/" + m_fileName; 
            File dataFile = new File(filePath); 
            if(!dataFile.isFile())
            {
                // Invoke JOptionPane from the event queue (invokeLater)
                PointGenerator.thisJFrame.repaint();
                m_fileErrMsg = filePath + 
                    " Does NOT exist" +
                    "\n" + "File operation aborted";
                SwingUtilities.invokeLater(new Runnable()
                {
                    public void run()
                    {
                        JOptionPane.showMessageDialog(null,m_fileErrMsg, "ERROR",
                                JOptionPane.ERROR_MESSAGE);
                    }
                });
                        
                return createdShapes;
            }
            Scanner file = new Scanner(dataFile);
            
            // Ready to read the data.
            String inputLine;
            int lineType = OBJ_TYPE_NONE;
            int[] points = new int[2];
            int indexLimit = 0;
            
            // While there is another line in the file
            while(file.hasNextLine())
            {
                // Read the line and increment file line number. Line
                // number will be used in future to indicate location
                // of file format errors.
                inputLine = file.nextLine();
                fileDataLine++;
                
                // Null lines.
                //---------------
                if((inputLine == null) || (inputLine.isEmpty()) || (inputLine.trim().isEmpty()))
                {
                    lineType = OBJ_TYPE_NONE;
                    continue;
                }
                
                //---------------
                else if(inputLine.contains(m_maxMinDisplayDelimiter))
                {
                    lineType = OBJ_TYPE_NONE;
                }
                        
                // Read Ref point coordinates
                //---------------
                else if(inputLine.contains(m_refLabel))
                {
                    inputLine = inputLine.replace(m_refLabel, "  ");
                    if(inputLine.contains(m_absoluteRef))
                    {
                        inputLine = inputLine.replace(m_absoluteRef, "  ");
                        m_absolutePosintioning = true;
                    }
                    else
                    {
                        inputLine = inputLine.replace(m_relativeRef, "  ");
                        m_absolutePosintioning = false;
                    }
                    
                    Scanner input = new Scanner(inputLine);
                    if(input.hasNextInt())
                    {
                        m_refX = input.nextInt();
                    }
                    if(input.hasNextInt())
                    {
                        m_refY = input.nextInt();
                    }
                    
                }
                    
                // Line that separates data blocks for each object.
                //---------------
                else if(inputLine.contains(m_newObjectDelimiter))
                {
                    lineType = OBJ_TYPE_NONE;
                    continue;
                }
                
                // Data grouping delimiter
                //---------------
                else if(inputLine.contains("----------"))
                {
                    continue; 
                }
                
                //  Object type - create appropriate shape object.
                //---------------
                else if(inputLine.contains(m_objectName)) 
                {
                    // Polygon
                    if(inputLine.contains(m_polygon))
                    {
                        shape = new RLine(m_sizeX, m_sizeY, objIndex);
                        createdShapes.add(shape);
                        objIndex++;
                    }
                    
                    // Ellipse
                    else if(inputLine.contains(m_elipse))
                    {
                        shape = new RElipse(m_sizeX, m_sizeY, objIndex);
                        createdShapes.add(shape);
                        objIndex++;
                    }
                    
                    // Rectangle.
                    else if(inputLine.contains(m_rectangle))
                    {
                        shape = new RRectangle(m_sizeX, m_sizeY, objIndex);
                        createdShapes.add(shape);
                        objIndex++;
                    }
                    
                    // Object not supported.
                    else
                    {
                        System.out.println("Invalid object type (" + inputLine + ") on line : " + fileDataLine);
                        System.exit(0);
                    }
                    
                }
                    
                // User supplied object label.
                //---------------
                else if(inputLine.contains(m_userLabel)) 
                {
                    inputLine = inputLine.replace(m_userLabel,"");
                    inputLine = inputLine.trim();
                    shape.setUserName(inputLine);
                }
                
                // Max array index value in x/y data points.
                //---------------
                else if(inputLine.contains(m_maxIndexStr))
                {
                    lineType = LINE_TYPE_POINT_CNT;
                    inputLine = inputLine.replace(m_maxIndexStr, "  ");
                    m_maxDataIndex = 0;
                    Scanner input = new Scanner(inputLine);
                    if(input.hasNextInt())
                    {
                        m_maxDataIndex = input.nextInt();
                        if(m_maxDataIndex > 0)
                        {
                            m_maxDataIndex--;  // Num pts to max index
                        }
                        shape.setPointsIndex(m_maxDataIndex);
                    }
                        
                }
                
                
                // LINE_TYPE_DATA_X_VALS
                // X data points - set state variable to expect X data values.
                //---------------
                else if(inputLine.contains(m_xLabel))
                {
                    lineType = LINE_TYPE_DATA_X_VALS;
                    points = shape.getPointsX();
                    
                }
                
                // LINE_TYPE_DATA_Y_VALS
                // Y data points - set state variable to expect Y data values.
                //---------------
                else if(inputLine.contains(m_yLabel))
                {
                    lineType = LINE_TYPE_DATA_Y_VALS;
                    points = shape.getPointsY();
                }
                
                // If X/Y label has been found, attempt to read the data.
                //---------------
                else if((lineType == LINE_TYPE_DATA_X_VALS) ||
                        (lineType == LINE_TYPE_DATA_Y_VALS))
                {                    
                    // Get all X or Y data lines.
                    int dataIndex = 0;
                    
                    LabelEndOfDataVals:
                    {
                        
                        // Identify the correct (X or Y) data reference.
                        int refPos = 0;
                        if(lineType == LINE_TYPE_DATA_X_VALS)
                        {
                            refPos = m_refX;
                        }
                        else
                        {
                            refPos = m_refY;
                        }
                        
                        // While more data expected.
                        while(dataIndex <= m_maxDataIndex)
                        {
                        
                            // Remove delimiters etc. from line.
                            inputLine = inputLine.replace('{',' ');
                            inputLine = inputLine.replace('}',' ');
                            inputLine = inputLine.replace(',',' ');
                            Scanner input = new Scanner(inputLine);
                            
                            // Parse one data line.
                            while(input.hasNextInt())
                            {
                                int val = input.nextInt();
                                points[dataIndex] = val + refPos;
                                if(dataIndex > m_maxDataIndex)
                                {
                                    System.out.println("Too many data points on line : " + fileDataLine);
                                    break LabelEndOfDataVals;
                                }                            
                                dataIndex++;
                            }
                            
                            // Have more data - read a new line.
                            if(dataIndex <= m_maxDataIndex)
                            {
                                if(file.hasNextLine())
                                {
                                    inputLine = file.nextLine();
                                    fileDataLine++;
                                }
                            }
                        }
                    }
                }
                
            }
            file.close();
            
            // Invoke JOptionPane from the event queue (invokeLater)
            PointGenerator.thisJFrame.repaint();
            SwingUtilities.invokeLater(new Runnable()
            {
                public void run()
                {
                    JOptionPane.showMessageDialog(null,"File Operation Completed",
                        "INFO", JOptionPane.INFORMATION_MESSAGE);
                }
            });
        } catch (Exception e) 
        {
            // Invoke JOptionPane from the event queue (invokeLater)
            PointGenerator.thisJFrame.repaint();
            SwingUtilities.invokeLater(new Runnable()
            {
                public void run()
                {
                    String errMsg = "General I/O Error" + "\n" +
                            "File operation aborted.";
                    JOptionPane.showMessageDialog(null,errMsg, "ERROR",
                            JOptionPane.ERROR_MESSAGE);
                }
            });                                    
                            
                            
            createdShapes.clear();
            return createdShapes;
        }

        return createdShapes;
    }
//----------------------------------------------------------------------  
    public int getRefX()
    {
        return  m_refX;
    }
    public int getRefY()
    {
        return  m_refY;
    }
    public boolean isAbsolutePosMode()
    {
        return m_absolutePosintioning;
    }
    public String getFilename()
    {
        return  m_fileName;
    }
}