/*---------------------------------------------------------------------
--
-- PointGenerator program
--
---------------------------------------------------------------------*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.ArrayList;
import javax.swing.text.*;
public class PointGenerator extends JFrame
{
    public static void main(String[] args) 
    {
        new PointGenerator();
    }
    
    
    //------------------------------------
    //------------------------------------
    //------------------------------------
    //------------------------------------
    // USER CONFIGURABLE PARAMETERS:
    
    // Define the max x/y of the shape plot area.
    public static final int SIZE_X = 1000;
    public static final int SIZE_Y = 600;
    
    // Simple mode will create a second file on the write operation.
    // This second file (in addition to defining the x/y points
    // for each object will contain the corresponding correct
    // JAVA graphics method calls to create the shapes.
    public static final boolean SIMPLE_MODE = true;
    //------------------------------------
    
    public static final Color COLOR_ACTIVE = new Color(106, 181, 129);
    public static final Color COLOR_IDLE = new Color(103, 150, 184);
    
    private final boolean MOUSE_DEBUG = false;

    private final int BUTTON_ACTION_NULL = 0;
    private final int BUTTON_ACTION_INCR = 1;
    private final int BUTTON_ACTION_DECR = 2;
    private final int BUTTON_ACTION_UNDO = 3;
    private final int BUTTON_ACTION_CLEAR = 4;
    private final int BUTTON_ACTION_NEW_LINE = 5;
    private final int BUTTON_ACTION_NEW_ELIP = 6;
    private final int BUTTON_ACTION_NEW_RECT = 7;
    private final int BUTTON_ACTION_FILL = 8;
    private final int BUTTON_ACTION_WRITE = 9;
    private final int BUTTON_ACTION_READ = 10;
    private final int BUTTON_ACTION_MODE = 11;
    private final int BUTTON_ACTION_NAME = 12;
    
    private JLabel m_labelName;
    private JLabel m_labelFill;
    private JLabel m_labelMode;
    private JLabel m_labelMouse;
    private JLabel m_labelObjPos;
    private JLabel m_labelMaxXY;
    private String m_blankLabel;

    private Graphics wnd;
    private boolean m_mousePressed;
    private boolean m_mouseEntered;
    private boolean m_mouseDragged;
    private int m_mouseX = 0, m_mouseY = 0;
    private int m_objectIndex;
    private String m_pendingNameUpdate;
    private ArrayList<RShape> m_shapes;
    private RShape m_shape;
    private boolean m_simpleMode;
    
    protected boolean m_deleteReleased;
    protected boolean m_deletePressed;
    protected boolean m_insertReleased;
    protected boolean m_insertPressed;
    protected boolean m_objUp;
    protected boolean m_objDown;
    protected boolean m_objLeft;
    protected boolean m_objRight;
    protected boolean m_objAlt
    ; 
    private int m_centerPtBaseX;
    private int m_centerPtBaseY;
    private int m_centerPtX;
    private int m_centerPtY;
    private int m_drawingWidth;
    private int m_drawingHeight;
    private RDrawPanel m_drawingArea;
    
    private boolean m_printWarning;
    
    private int m_minXSize;
    private int m_minYSize;
    private int m_debugCntr;
    private String m_frameHeader;
    static JFrame thisJFrame = null;
    
    private boolean startup = true;
    
    RFileIo m_myFiles;
 
//---------------------------------------    
    public PointGenerator() 
    {
        super("");
        thisJFrame = this;
        if(SIMPLE_MODE)
        {
            m_frameHeader = "PointGenerator - Version 031215 - SIMPLE MODE" +
                "****** (TYPE \"h\" FOR HELP!!!!) ******";
        }
        else
        {
            m_frameHeader = "PointGenerator - Version 031215 - ADVANCED MODE " +
                "***** (TYPE \"h\" FOR HELP!!!!) ******";
        }
        setTitle(m_frameHeader);
        
        Container content = getContentPane();
        content.setBackground(Color.lightGray);
        
        // Control Area.
        JPanel controlArea = new JPanel(new GridLayout(1,2));
        controlArea.setBorder(BorderFactory.createBevelBorder(1, Color.LIGHT_GRAY, Color.DARK_GRAY));
        JPanel buttonArea = new JPanel(new GridLayout(2,6));
        JPanel textArea = new JPanel(new GridLayout(3,2));
        content.add(controlArea, BorderLayout.SOUTH);
        controlArea.add(buttonArea);
        controlArea.add(textArea);
        
        // Text Labels.
        m_labelName = new JLabel("");
        m_labelFill = new JLabel("");
        m_labelMode = new JLabel("");
        m_labelMouse = new JLabel("");
        m_labelObjPos = new JLabel("");
        m_labelMaxXY = new JLabel("");
        /*
        textArea.add(m_labelName);
        textArea.add(m_labelFill);
        textArea.add(m_labelMode);
        textArea.add(m_labelMouse);
        textArea.add(m_labelObjPos);
        textArea.add(m_labelMaxXY);
        */
        textArea.add(m_labelName);
        textArea.add(m_labelObjPos);
        textArea.add(m_labelFill);
        textArea.add(m_labelMouse);
        textArea.add(m_labelMode);
        textArea.add(m_labelMaxXY);
        
        initialize();
        setButtons(buttonArea);
        
        // Drawing aread.
        m_drawingArea = new RDrawPanel();
        m_drawingArea.setPreferredSize(new Dimension(SIZE_X, SIZE_Y));
        m_drawingArea.addMouseMotionListener(new RMouseAdapterMotionListener());
        m_drawingArea.addMouseListener(new RMouseAdapterListener());
        
        m_drawingArea.requestFocus();
        m_drawingArea.setFocusable(true);
        content.add(m_drawingArea, BorderLayout.NORTH);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
     
//---------------------------------------    
    private void initialize()
    {
        m_mousePressed = false;
        m_mouseEntered = false;
        m_mouseDragged = false;
        m_objectIndex = -1;
        m_deleteReleased = true;
        m_deletePressed = false;
        m_insertReleased = true;
        m_insertPressed = false;
        m_objUp = false;
        m_objDown = false;
        m_objLeft = false;
        m_objRight = false;
        m_objAlt = false;        
        m_debugCntr = 0;

        m_simpleMode = SIMPLE_MODE;
        if(m_simpleMode)
        {
            // In simple mode, only absolute positioning is allowed.
            m_centerPtBaseX = 0;
            m_centerPtBaseY = 0;
        }
        else
        {
            m_centerPtBaseX = SIZE_X / 2;
            m_centerPtBaseY = SIZE_Y / 2;
        }
        m_centerPtX = m_centerPtBaseX;
        m_centerPtY = m_centerPtBaseY;
        
        m_pendingNameUpdate = "";
        m_mouseX = 0; m_mouseY = 0;
        m_shapes = new ArrayList<RShape>();
        RShape m_shape = null;
        
        m_myFiles = new RFileIo();
        
        m_printWarning = true;
        
        m_minXSize = 1000;
        m_minYSize = 500;
        
        m_blankLabel = "   ADD A SHAPE (Type \"h\" for help)";
        
     }
    
//---------------------------------------    
    class RDrawPanel extends JPanel
    {
        private boolean m_printit = false;
//---------------------------------------    
        public RDrawPanel()
        {
            super();
            setOpaque(true);
            setBackground(Color.lightGray);
            setFocusable(true);
            addKeyListener(new RKeyAdapter());
            requestFocus();
        }
//---------------------------------------    
        public void drawSplashScreen(Graphics g)
        {
            Font font = new Font( "Monospaced", Font.BOLD, 12 );
            g.setFont(font);
            g.setColor(new Color(192,3,3));
            int x = 100;
            int y = 40;
            
            font = new Font( "Monospaced", Font.BOLD, 16 );
            g.setFont(font);
            g.drawString("VERY IMPORTANT!!!!!!!", x, y );
            y += 40;
            g.drawString("HIT the h key to display two help pages AND/OR read file \"__README.txt\".",
                        x, y );
            y += 40;
            g.drawString("Once selecting a shape, use the mouse to draw before ", x, y );
            y += 20;
            g.drawString("    selecting another shape.", x, y );
            y += 20;
            g.drawString("    Not doing so will just generate a bunch of empty shapes.", x, y );
            y += 20;
            g.drawString("    Note that the shape index counter (in the text label area)", x, y );
            y += 20;
            g.drawString("    will increment each time a shape button is clicked.", x, y );
            g.setColor(Color.BLACK);
            y += 40;
            g.drawString("The saved file you create (e.g) \"yourname.txt\"", x, y );
            y += 20;
            g.drawString("    will contain the raw data points enclosed", x, y );
            y += 20;
            g.drawString("    in braces which you can copy & paste into", x, y );
            y += 20;
            g.drawString("    your object array declarations.", x, y );
            y += 40;
            g.drawString("Target bounding boxes are computed for each shape and also all shapes", x, y );
            y += 20;
            g.drawString("   combined (compound objects) in the current session.  Suggest ", x, y );
            y += 20;
            g.drawString("   that you create a different file for each compound object to get", x, y );
            y += 20;
            g.drawString("   object target area definitions for each compound object.", x, y );
            y += 20;
            g.drawString("   You will need bounding boxes when creating apps where you", x, y );
            y += 20;
            g.drawString("   need to determine when objects \"collide\".", x, y );
            if(SIMPLE_MODE)
            {
                g.setColor(new Color(33, 40, 137));
                y += 40;
                g.drawString("THIS APP IS CURRENTLY CONFIGURED " +
                            "IN SIMPLE MODE", x, y );
                y += 20;
                g.drawString("    In this mode, you will automatically get" +
                     " an ADDITIONAL file ", x, y );
                y += 20;
                g.drawString("    with the word \"simple\" prefixed to your filename.", x, y);
                y += 20;
                g.drawString("    This file will contain fully defined Java code" , x, y );
                y += 20;
                g.drawString("    for creating your graphics objects." , x, y );
                y += 20;
                g.drawString("    Optional relative positioning drawing mode " +
                            "is disabled in this mode." , x, y );
                
            }

        }
//---------------------------------------    
        public void paintComponent(Graphics g) 
        {
            super.paintComponent(g);
            
            m_minXSize = getWidth();
            m_minYSize = getHeight();
            m_drawingWidth = m_drawingArea.getWidth();
            m_drawingHeight = m_drawingArea.getHeight();
            if(m_printit)
            {
                m_printit = false;
                System.out.println("XY : " + m_minXSize + "   " + m_minYSize);
            }

            requestFocusInWindow();
            //System.out.println("XXXX  " + m_debugCntr++);
            
            // Delete object....
            if(m_deletePressed)
            {
                m_deletePressed = false;               
                //System.out.println("Deleting..........");
                if(m_shapes.size() > 0)
                {
                    deleteShape();
                    resetInsertDelete();
                }
            }

            // Insert object....
            if(m_insertPressed)
            {
                m_insertPressed = false;               
                if(m_shapes.size() > 0)
                {
                    addShape();
                    resetInsertDelete();
                }
            }
            
            // Move object last point or all points
            if(m_shapes.size() > 0)
            {
                m_shapes.get(m_objectIndex).incrObjX(m_objLeft, 
                            m_objRight, m_objAlt, 1);
                m_shapes.get(m_objectIndex).incrObjY(m_objUp, 
                                m_objDown, m_objAlt, 1);
                                
            }
            m_objUp = false; m_objDown = false; m_objLeft = false;
            m_objRight = false;
            
            
            //setObjIndex(index);
            drawShapes(g);
            drawRefPositionAndLabels(g);
            
            if(startup)
            {
                drawSplashScreen(g);
            }
        }
    }
//--------------------------------------- 
    private void deleteShape()
    {
        // Remove the shape and re-adjust index/name
        m_shapes.remove(m_objectIndex);
        int index = 0;
        for(RShape shape : m_shapes)
        {
            shape.setObjIndex(index);
            shape.setUserName(shape.getUserName());
            index++;
        }
        m_objectIndex = m_shapes.size() - 1;
    }
//--------------------------------------- 
    private void addShape()
    {
        //m_shapes.remove(m_objectIndex);
        
        // Create a new shape
        RShape shapeBaseline = m_shapes.get(m_objectIndex);
        String baseName = shapeBaseline.getBaseName();
        RShape shape;
        if(!shapeBaseline.getPlotOk())
        {
            return;
        }
        if(baseName.contains("Polygon"))
        {
            shape = new RLine(SIZE_X, SIZE_Y, m_objectIndex);
        }
        else if(baseName.contains("Ellipse"))
        {
            shape = new RElipse(SIZE_X, SIZE_Y, m_objectIndex);
        }
        else if(baseName.contains("Rectangle"))
        {
            shape = new RRectangle(SIZE_X, SIZE_Y, m_objectIndex);
        }
        else
        {
            return;
        }
        
        // Duplicate the data points in the new shape.
        int[] SrcXpts = shapeBaseline.getPointsX();
        int[] SrcYpts = shapeBaseline.getPointsY();
        int[] DstXpts = shape.getPointsX();
        int[] DstYpts = shape.getPointsY();
        int maxIndex = shapeBaseline.getPointsIndex();
        shape.setPointsIndex(maxIndex);
        for(int i = 0; i <= maxIndex; i++)
        {
            DstXpts[i] = SrcXpts[i];
            DstYpts[i] = SrcYpts[i];          
        }
        
        shape.setUserName("");
        if(DstYpts[0] > 250)
        {
            shape.incrObjY(true, false, true, 50);
        }
        else
        {
            shape.incrObjY(false, true, true, 50);
        }
        m_shapes.add(m_objectIndex + 1, shape);
        
        //Addjust object indexes and names.
        int index = 0;
        for(RShape shp : m_shapes)
        {
            shp.setObjIndex(index);
            shp.setUserName(shp.getUserName());
            index++;
        }
        m_objectIndex = m_objectIndex + 1;
    }
//--------------------------------------- 
    private void resetInsertDelete()
    {
        m_deleteReleased = true;
        m_deletePressed = false;
        m_insertReleased = true;
        m_insertPressed = false;
    }

//--------------------------------------- 
    private void drawShapes(Graphics wnd)
    {
        if(m_shapes.size() == 0)
        {
            m_labelFill.setText(m_blankLabel);
            m_labelName.setText("   Object Name & Index (no objects defined)");
            m_labelObjPos.setText(m_blankLabel);
            return;
        }
                    
        // For each shape.
        for(RShape shape : m_shapes)
        {
        
            // If drawing an selected object.
            if(m_objectIndex == shape.getObjIndex())
            {
                // If user has input a name for the object, set it.
                if(m_pendingNameUpdate.length() > 0)
                {
                    shape.setUserName(m_pendingNameUpdate);
                    m_pendingNameUpdate = "";
                }
                
                // Update object if necessary  (ALSO DRAWS IT!!).
                shape.update(wnd, m_mouseX, m_mouseY, m_objectIndex,
                            m_mousePressed, m_mouseDragged, m_mouseEntered);
                            
                // Display the object index and type (polygon, ellipse, etc.)
                String name = shape.getName();
                wnd.setColor(Color.BLACK);
                m_labelName.setText("   " + name);
                
                // Update fill option for selected object and display it.
                boolean fill = shape.getFill();
                String fillStr;
                String refStr;
                if(fill)
                {
                    fillStr = "   Shape Fill - ON";
                }
                else
                {
                    fillStr = "   Shape Fill - OFF";
                }
                m_labelFill.setText(fillStr);
                String text = "   Object Data Point 0 X,Y = "  + 
                                (shape.getX0() - m_centerPtX) +
                                "," + (shape.getY0() - m_centerPtY);
                m_labelObjPos.setText(text);
                        
            }
            
            // Else, not drawing an selected object - just draw it.
            else
            {
                shape.draw(wnd, m_objectIndex);
            }
        }
    }

//--------------------------------------- 
    private void drawRefPositionAndLabels(Graphics wnd)
    {
        String refStr;
        
        // Display type of object positioning option.
        if(m_centerPtX == 0)
        {
            refStr = "   Absolute Mode (Top Left Ref Point)";
        }
        else
        {
            refStr = "   Relative Mode (Yellow Plus Ref Point)";
        }
        m_labelMode.setText(refStr);
        
        // Mouse X, Y
        String mousePositionStr = "   Mouse X,Y = " + m_mouseX + "," + m_mouseY;        
        m_labelMouse.setText(mousePositionStr);
                
        // Draw reference mark (yellow plus symbol.
        if(m_centerPtX > 0)
        {
            wnd.setColor(Color.YELLOW);
            wnd.drawLine((m_centerPtX - 10), m_centerPtY,
                    (m_centerPtX + 10), m_centerPtY);
            wnd.drawLine(m_centerPtX, (m_centerPtY - 10),
                    m_centerPtX , (m_centerPtY + 10));
        }
        
        // Plot area size
        m_labelMaxXY.setText("   Plot Max X,Y = " + m_drawingWidth + "," + m_drawingHeight);
    }
//---------------------------------------    
//---------------------------------------    
// Read/Write Methods

//---------------------------------------    
// Read shape objects file and update object database   
    public void readFile()
    {
        ArrayList<RShape> shapes;
        shapes = m_myFiles.readFile();
        m_shapes.clear();
        if(shapes.size() > 0)
        {
            m_shapes = shapes;
            m_objectIndex = m_shapes.size() - 1;
			/* ***
            m_centerPtBaseX = m_myFiles.getRefX();
            m_centerPtBaseY = m_myFiles.getRefY();
			*/
            if(m_myFiles.isAbsolutePosMode())
            {            
                m_centerPtX = 0;
                m_centerPtY = 0;
            }
            else
            {
                m_centerPtX = m_centerPtBaseX;
                m_centerPtY = m_centerPtBaseY;
            }
        }
        String newTitle = m_frameHeader + "File : " + m_myFiles.getFilename();
        setTitle(newTitle);
        repaint();
    }
//---------------------------------------    
// Call method to write shape objects to a file.   
    public void writeFile()
    {
        boolean isAbsolute = true;
        if(m_centerPtX != 0)
        {
            isAbsolute = false;
        }
        //m_myFiles.writeFile(m_shapes, m_centerPtBaseX, m_centerPtBaseY,
        //                    isAbsolute);
        m_myFiles.writeFile(m_shapes, m_centerPtX, m_centerPtY,
                            isAbsolute);
        String newTitle = m_frameHeader + "File : " + m_myFiles.getFilename();
        setTitle(newTitle);
    }
//---------------------------------------    
//---------------------------------------
// Buttion initialization    
    class RButton extends JButton
    {
        int m_index;
        public RButton(String label, int btnIndex)
        {
            super(label);
            m_index = btnIndex;
            addMouseListener(new RButtonAdapter());
        }
        public int getIndex()
        {
            return m_index;
        }
    }
    
//---------------------------------------    
    private void setButtons(JPanel buttonArea)
    {
        buttonArea.add(new RButton("POLY", BUTTON_ACTION_NEW_LINE));
        buttonArea.add(new RButton("ELLIPSE", BUTTON_ACTION_NEW_ELIP));
        buttonArea.add(new RButton("RECT", BUTTON_ACTION_NEW_RECT));
        buttonArea.add(new RButton("UNDO", BUTTON_ACTION_UNDO));
        buttonArea.add(new RButton("CLEAR", BUTTON_ACTION_CLEAR));
        buttonArea.add(new RButton("NAME", BUTTON_ACTION_NAME));
        buttonArea.add(new RButton("INCR", BUTTON_ACTION_INCR));
        buttonArea.add(new RButton("DECR", BUTTON_ACTION_DECR));
        buttonArea.add(new RButton("FILL", BUTTON_ACTION_FILL));
        if(!m_simpleMode)
        {
            buttonArea.add(new RButton("MODE", BUTTON_ACTION_MODE));
        }
        buttonArea.add(new RButton("WRT", BUTTON_ACTION_WRITE));
        buttonArea.add(new RButton("READ", BUTTON_ACTION_READ));

    }
        
//=======================================
// Mouse Button Adapter    
    class RButtonAdapter extends MouseAdapter
    {
        public void mouseClicked(MouseEvent e)
        {
            startup = false;
            m_mouseX = e.getX(); m_mouseY = e.getY(); 
            m_mouseDragged = false;
            m_mousePressed = false; 
            RButton button = (RButton) e.getSource();
            
            int action = button.getIndex();
            processButtons(action);       
        }
    }
//=======================================
// Keyboard Adapters
    class RKeyAdapter extends KeyAdapter
    {
        @Override
        public void keyPressed(KeyEvent ke) 
        {
            int kc = ke.getKeyCode();
            switch(kc)
            {
            
                case KeyEvent.VK_DELETE :
                case KeyEvent.VK_D :
                    if(m_deleteReleased)
                    {
                        m_deletePressed = true;
                        m_deleteReleased = false;
                        String msg = "Do you want to delete ";
                        msg = msg + m_shapes.get(m_objectIndex).getName() + "?";
                        int resp = JOptionPane.showConfirmDialog(null,msg,
                            "WARNING", JOptionPane.YES_NO_OPTION, 
                            JOptionPane.WARNING_MESSAGE);
                        if(resp != JOptionPane.YES_OPTION)
                        {
                            m_deletePressed = false;
                        }
                        
                    }
                    repaint();
                    break;
                case KeyEvent.VK_INSERT :
                case KeyEvent.VK_I :
                    if(m_insertReleased)
                    {
                        m_insertPressed = true;
                        m_insertReleased = false;
                        /*
                        if(m_shapes.size() > 0)
                        {
                            JOptionPane.showMessageDialog(null,"Duplicating object",
                                "INFO", JOptionPane.INFORMATION_MESSAGE);
                        }
                        */
                        String msg = "Do you want to duplicate object ";
                        msg = msg + m_shapes.get(m_objectIndex).getName() + "?";
                        int resp = JOptionPane.showConfirmDialog(null,msg,
                            "WARNING", JOptionPane.YES_NO_OPTION, 
                            JOptionPane.WARNING_MESSAGE);
                        if(resp != JOptionPane.YES_OPTION)
                        {
                            m_insertPressed = false;
                        }
                    }
                    repaint();
                    break;
                case KeyEvent.VK_UP :
                    m_objUp = true;
                    repaint();
                    break;
                case KeyEvent.VK_DOWN :
                    m_objDown = true;
                    repaint();
                    break;
                case KeyEvent.VK_LEFT :
                    m_objLeft = true;
                    repaint();
                    break;
                case KeyEvent.VK_RIGHT :
                    m_objRight = true;
                    repaint();
                    break;
                case KeyEvent.VK_SHIFT :
                    break;
                case KeyEvent.VK_COPY :
                    break;
                case KeyEvent.VK_PASTE :
                     break;
                case KeyEvent.VK_ALT :
                    m_objAlt = true;
                    // Do NOT repaint
                    break;
                case KeyEvent.VK_H :
                    MyDialog dlg = new MyDialog(null);
                    dlg.setVisible(true);
                    repaint();
                    break;                    
            }
        }
//---------------------------------------    
        @Override
        public void keyReleased(KeyEvent ke) 
        {
            int kc = ke.getKeyCode();
            switch(kc)
            {
                case KeyEvent.VK_DELETE :
                case KeyEvent.VK_D :
                    m_deleteReleased = true;
                    m_deletePressed = false; 
                    repaint();
                    break;
                case KeyEvent.VK_INSERT :                    
                case KeyEvent.VK_I :                    
                    m_insertReleased = true;
                    m_insertPressed = false; 
                    repaint();
                    break;
                case KeyEvent.VK_UP :
                    break;
                case KeyEvent.VK_DOWN :
                    break;
                case KeyEvent.VK_LEFT :
                    break;
                case KeyEvent.VK_RIGHT :
                    break;
                case KeyEvent.VK_SHIFT :
                    break;
                case KeyEvent.VK_COPY :
                    break;
                case KeyEvent.VK_PASTE :
                    break;
                case KeyEvent.VK_ALT :
                    m_objAlt = false;
                    break;
            }
        }
    }
//=======================================
// Mouse listeners for drawing    
    class RMouseAdapterMotionListener extends MouseMotionAdapter
    {
        public void mouseMoved(MouseEvent e)
        {
            m_mouseX = e.getX(); m_mouseY = e.getY();
            m_mousePressed = false; 
            m_mouseDragged = false;
            if(MOUSE_DEBUG)
            {
                System.out.println("Moved - X,Y : " + e.getX() + "  " + e.getY() +
                "  PR ENT DR : " + m_mousePressed + "  " + m_mouseEntered + "   " + m_mouseDragged);
            }
            repaint();
        }
        public void mouseDragged(MouseEvent e)
        {
            m_mouseX = e.getX(); m_mouseY = e.getY();
            if(m_mouseEntered)
            {
                m_mouseDragged = true;
            }            
            if(MOUSE_DEBUG)
            {
                System.out.println("Draged - X,Y : " + e.getX() + "  " + e.getY() +
                "  PR ENT DR : " + m_mousePressed + "  " + m_mouseEntered + "   " + m_mouseDragged);
            }
            repaint();
        }
    }
//---------------------------------------    
    class RMouseAdapterListener extends MouseAdapter
    {
        public void mouseEntered(MouseEvent e)
        {
            m_mouseX = e.getX(); m_mouseY = e.getY();
            m_mouseEntered = true;
            m_mouseDragged = false;
            if(MOUSE_DEBUG)
            {
                System.out.println("Entered - X,Y : " + e.getX() + "  " + e.getY() +
                "  PR ENT DR : " + m_mousePressed + "  " + m_mouseEntered + "   " + m_mouseDragged);
            }
            repaint();
        }
        public void mouseExited(MouseEvent e)
        {
            m_mouseX = e.getX(); m_mouseY = e.getY();
            m_mouseEntered = false;
            m_mouseDragged = false;
            if(MOUSE_DEBUG)
            {
                System.out.println("Exited - X,Y : " + e.getX() + "  " + e.getY() +
                "  PR ENT DR : " + m_mousePressed + "  " + m_mouseEntered + "   " + m_mouseDragged);
            }
            repaint();
        }
        public void mousePressed(MouseEvent e)
        {
            m_mouseX = e.getX(); m_mouseY = e.getY();
            m_mousePressed = true;
            m_mouseDragged = false;
            if(MOUSE_DEBUG)
            {
                System.out.println("Pressed - X,Y : " + e.getX() + "  " + e.getY() +
                "  PR ENT DR : " + m_mousePressed + "  " + m_mouseEntered + "   " + m_mouseDragged);
            }
            repaint();
        }
        public void mouseReleased(MouseEvent e)
        {
            m_mouseX = e.getX(); m_mouseY = e.getY();
            m_mousePressed = false;
            m_mouseDragged = false;
            if(MOUSE_DEBUG)
            {
                System.out.println("Released - X,Y : " + e.getX() + "  " + e.getY() + 
                "  PR ENT DR : " + m_mousePressed + "  " + m_mouseEntered + "   " + m_mouseDragged);
            }
            repaint();
        }
    }

//---------------------------------------
// Process all the buttons    
    protected void processButtons(int action)
    {
        if(action != BUTTON_ACTION_NULL)
        {
            
            if(m_printWarning)
            {
                m_printWarning = false;
                if((m_minXSize != SIZE_X) || (m_minYSize != SIZE_Y))
                {
                    String msg = "User desired drawing area size not achieved" +
                                "\n" + "Min width must be : " + m_minXSize +
                                "\n" + "Min height must be : " + m_minYSize;
                    JOptionPane.showMessageDialog(null,msg,
                    "WARNING!!!!!", JOptionPane.WARNING_MESSAGE);
            
                }
            }
        
            switch (action)
            {
                // Undo last input on selected object.
                case BUTTON_ACTION_UNDO :
                    if((m_objectIndex >= 0) && (m_objectIndex < m_shapes.size()))
                    {
                        m_shapes.get(m_objectIndex).undo();
                    }
                    break;
                    
                //  Clear all input on selected object.
                case BUTTON_ACTION_CLEAR :
                    if((m_objectIndex >= 0) && (m_objectIndex < m_shapes.size()))
                    {
                        m_shapes.get(m_objectIndex).clear();
                    }
                    break;
                    
                // New line (polygon) object.
                case BUTTON_ACTION_NEW_LINE :
                    m_objectIndex = m_shapes.size();
                    m_shape = new RLine(SIZE_X, SIZE_Y, m_objectIndex);
                    m_shapes.add(m_shape); 
                    break;
        
                // New rectangle object.
                case BUTTON_ACTION_NEW_RECT :
                    m_objectIndex = m_shapes.size();
                    m_shape = new RRectangle(SIZE_X, SIZE_Y, m_objectIndex);
                    m_shapes.add(m_shape);
                    break;
                    
                // New ellipse object.
                case BUTTON_ACTION_NEW_ELIP :
                    m_objectIndex = m_shapes.size();
                    m_shape = new RElipse(SIZE_X, SIZE_Y, m_objectIndex);
                    m_shapes.add(m_shape);
                    break;
                    
                // Increment object index (go to next object).
                case BUTTON_ACTION_INCR :
                    if(m_objectIndex >= 0)
                    {
                        m_objectIndex++;
                        if(m_objectIndex >= m_shapes.size())
                        {
                            m_objectIndex = 0;
                        }
                    }
                    break;
                    
                // Decrement object index (go to previous object).
                case BUTTON_ACTION_DECR :
                    if(m_objectIndex >= 0)
                    {
                        m_objectIndex--;
                        if(m_objectIndex < 0)
                        {
                            m_objectIndex = m_shapes.size() - 1;
                        }
                    }
                    break;
                    
                // Set fill/nofill on selected object.
                case BUTTON_ACTION_FILL :
                    if((m_objectIndex >= 0) && (m_objectIndex < m_shapes.size()))
                    {
                        m_shapes.get(m_objectIndex).toggleFill();
                    }
                    break;
                    
                // Write objects to file.
                case BUTTON_ACTION_WRITE :
                    if((m_objectIndex >= 0) && (m_objectIndex < m_shapes.size()))
                    {
                        writeFile();
                    }
                    break;
                    
                // Read objects from file.
                case BUTTON_ACTION_READ :
                    readFile();
                    break;
                    
                // Drawing mode (absolute; relative to reference plus sign).    
                case BUTTON_ACTION_MODE :
                    if(m_centerPtX == 0)
                    {
                        m_centerPtX = m_centerPtBaseX;
                        m_centerPtY = m_centerPtBaseY;
                    }
                    else
                    {
                        m_centerPtX = 0;
                        m_centerPtY = 0;
                    }
                    break;
                    
                // Add user name to selected object.
                case BUTTON_ACTION_NAME :
                    String objectName = JOptionPane.showInputDialog(null, 
                        "Enter Object Name)");
                    if(objectName != null)
                    {
                        m_pendingNameUpdate = objectName;
                    }

                    break;
                default :
                    break;
                    
            }
            repaint();
        }
    }    
//-----------------------------
// HELP DIALOG :
//-----------------------------
    
/*---------------------------------------------------------------------
--   Layout :
--                                                           | textAreaATop
--                                    | textPanelA (Flow) -- | textAreaA
--            | cardPanelA (Boarder)  |                      | textAreaAFin
--            |                       | buttonPanelA (def) - |-- two Buttons
--  helpCards |
--            |                                              | textAreaBTop
--            |                       | textPanelB (Flow) -- | textAreaB
--            | cardPanelB (Boarder)  |                      | textAreaBFin
--                                    | buttonPanelB (def) - |-- two Buttons
-- 
---------------------------------------------------------------------*/    
    class MyDialog extends JDialog
    {
        public MyDialog(JFrame parent)
        {
            super(parent, "Application Help", true);
             
            final JPanel helpCards;
            final CardLayout cardLO;
           
            Color color = new Color(149, 187, 219);
            Container contentPane = getContentPane();            
            contentPane.setLayout(new BorderLayout());
            
            cardLO = new CardLayout();
            helpCards = new JPanel();
            helpCards.setLayout(cardLO);
            
            Font font = new Font( "Monospaced", Font.BOLD, 16 );
            
            //--------------------------------
            //--------------------------------
            //--------------------------------
            // Panel A
            JPanel cardPanelA = new JPanel(new BorderLayout());
            cardPanelA.setPreferredSize(new Dimension(800, 760));
            cardPanelA.setBackground(color);
            
            JPanel textPanelA = new JPanel(new FlowLayout());
            textPanelA.setOpaque(false);
            textPanelA.setPreferredSize(new Dimension(800, 540));
            textPanelA.setMaximumSize(textPanelA.getPreferredSize());
            textPanelA.setMinimumSize(textPanelA.getPreferredSize());
            
            JTextArea textAreaATop = new JTextArea();
            textAreaATop.setPreferredSize(new Dimension(800, 20));
            textAreaATop.setOpaque(false);
            textAreaATop.setFont(font);
            //textAreaATop.setForeground(new Color(192,3,3));
            textAreaATop.setForeground(Color.red);
            
            JTextArea textAreaA = new JTextArea();
            textAreaA.setPreferredSize(new Dimension(800, 500));
            textAreaA.setOpaque(false);
            textAreaA.setBackground(color);
            textAreaA.setFont(font);
            textAreaA.setForeground(Color.black);
            
            JTextArea textAreaAFin = new JTextArea();
            textAreaAFin.setPreferredSize(new Dimension(800, 20));
            textAreaAFin.setOpaque(false);
            textAreaAFin.setFont(font);
            //textAreaAFin.setForeground(new Color(192,3,3));
            textAreaAFin.setForeground(Color.red);

            //--------------------------------
            // Text area A
            textAreaATop.append("GO TO THE START PANE FOR GETTING STARTED INSTRUCTIONS....\n\n");
            
            textAreaA.append("Poly              - Add polygon shape element\n");
            textAreaA.append("Ellipse           - Add Ellipse shape element\n");
            textAreaA.append("Rect              - Add Rectangle shape element\n");
            textAreaA.append("To Draw It!!!     - Left click and drag mouse\n\n");
            textAreaA.append("Undo              - Clears last point (poly), all points in others\n");
            textAreaA.append("Clear             - Clears all data points in selected shape\n");
            textAreaA.append("Name              - Add user defined name for selected shape\n\n");
            textAreaA.append("Inc               - Selects next shape in list (red outline, green fill)\n");
            textAreaA.append("Dec               - Selects previous shape in list (red outline, green fill)\n");
            textAreaA.append("Fill              - Toggles color fill on/off\n");
            textAreaA.append("Mode              - Toggles reference mode (relative/absolute)\n\n");
            textAreaA.append("Write             - Write data to file\n");
            textAreaA.append("Read              - Read data from file\n\n");            
            textAreaA.append("Arrow key         - Moves shape last data point in arrow direction\n");            
            textAreaA.append("Alt Arrow key     - Moves all shape data points in arrow direction \n" +
                             "                    (Use Option Key instead of ALT key for MAC)\n");            
            textAreaA.append("Ins Key           - Duplicates the selected shape (\"I\" Key for MAC)\n");            
            textAreaA.append("Del key           - Deletes the selected shape (\"D\" Key for MAC)\n");

            textAreaAFin.append("More Info on the START Pane and in the \"readme\" file\n");            
            
            textPanelA.add(textAreaATop);
            textPanelA.add(textAreaA);
            textPanelA.add(textAreaAFin);
            
            //--------------------------------
            //--------------------------------
            //--------------------------------
            // Panel B
                        
            JPanel cardPanelB = new JPanel(new BorderLayout());
            cardPanelB.setPreferredSize(new Dimension(800, 730));
            cardPanelB.setBackground(color);
            
            JPanel textPanelB = new JPanel(new FlowLayout());
            textPanelB.setOpaque(false);
            textPanelB.setPreferredSize(new Dimension(800, 540));
            textPanelB.setMaximumSize(textPanelB.getPreferredSize());
            textPanelB.setMinimumSize(textPanelB.getPreferredSize());
            
            JTextArea textAreaBTop = new JTextArea();
            textAreaBTop.setPreferredSize(new Dimension(800, 50));
            textAreaBTop.setOpaque(false);
            textAreaBTop.setFont(font);
            //textAreaBTop.setForeground(new Color(192,3,3));
            textAreaBTop.setForeground(Color.red);
            
            JTextArea textAreaB = new JTextArea();
            textAreaB.setPreferredSize(new Dimension(800, 420));
            textAreaB.setOpaque(false);
            textAreaB.setBackground(color);
            textAreaB.setFont(font);
            textAreaB.setForeground(Color.black);
            
            JTextArea textAreaBFin = new JTextArea();
            textAreaBFin.setPreferredSize(new Dimension(800, 50));
            textAreaBFin.setOpaque(false);
            textAreaBFin.setFont(font);
            //textAreaBFin.setForeground(new Color(192,3,3));
            textAreaBFin.setForeground(Color.red);
            
            //--------------------------------
            textAreaBTop.append("Getting Started\n");
            textAreaBTop.append("GO TO THE DOC PANE FOR USAGE DOCUMENTATION\n\n");
            
            textAreaB.append("1)  SELECT A SHAPE (Polygon, Rectangle, Elipse)\n");
            textAreaB.append("2)  Draw shape (mouse right click & drag, (and, for poly, repeat this operation)\n");
            textAreaB.append("3)  Optionally NAME your object\n");
            textAreaB.append("4)  Toggle FILL to go between empty and filled shapes\n");
            textAreaB.append("5)  UNDO button to undo the latest point drawn (clears all on rect & ellipse)\n");
            textAreaB.append("6)  CLEAR button to remove all points on the selected shape\n");
            textAreaB.append("7)  ADD ANOTHER SHAPE (Polygon, Rectangle, Ellipse)\n");
            textAreaB.append("8)  Do stuff with this new shape (selected shape has red outline, green fill)\n\n");
            textAreaB.append("9)  Move between the shapes using INCR, DECR buttons\n");
            textAreaB.append("10) MODE button to toggle data reference between upper left and yellow cross\n");
            textAreaB.append("    This button/option available when app is configured for advanced mode\n");
            textAreaB.append("11) Save data Using WRITE - hopefully files are self explanatory\n");
            textAreaB.append("12) On new session, retrieve data using READ\n\n");
            textAreaB.append("13) Use alt arrow keys to move selected object (hold down for auto repeat)\n");
            textAreaB.append("14) Arrow keys to move last point of selected object (hold down for auto repeat)\n");
            textAreaB.append("15) Use the ins key to duplicate selected object\n");
            textAreaB.append("16) Use the del key to delete selected object\n");
            
            textAreaBFin.append("Save each scenery and each compound object in a separate file\n");
            textAreaBFin.append("More Info on the DOC Pane and in the \"readme\" file\n");            
            
            textPanelB.add(textAreaBTop);
            textPanelB.add(textAreaB);
            textPanelB.add(textAreaBFin);
            
            //--------------------------------
            //--------------------------------
            //--------------------------------            
            // Create Areas.
            JPanel buttonPanelA = new JPanel();
            buttonPanelA.setOpaque(false);
            buttonPanelA.setPreferredSize(new Dimension(800, 190));
 
            JPanel buttonPanelB = new JPanel();
            buttonPanelB.setOpaque(false);
            buttonPanelB.setPreferredSize(new Dimension(800, 190));
            
            JButton okA = new JButton("OK");
            final JButton main = new JButton("DOC");
            final JButton aux = new JButton("START");
            JButton okB = new JButton("OK");

            //--------------------------------            
            // Add buttons to button panels.
            buttonPanelA.add(okA);
            buttonPanelA.add(aux);
            buttonPanelB.add(okB);
            buttonPanelB.add(main);
 
            //--------------------------------
            //--------------------------------
            //--------------------------------            
            // Action Listeners
            okA.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
                {
                    dispose();
                }
            });
            
            main.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
                {
                    if(ae.getSource() == main)
                    {
                        cardLO.show(helpCards, "DOC");
                    }
                    else
                    {
                        cardLO.show(helpCards, "START");
                    }
                 }
            });
            
            aux.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
                {
                    if(ae.getSource() == main)
                    {
                        cardLO.show(helpCards, "DOC");
                    }
                    else
                    {
                        cardLO.show(helpCards, "START");
                    }
                }
            });
 
            okB.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
                {
                    dispose();
                }
            });
            
            //--------------------------------
            //--------------------------------
            //--------------------------------            
            // Add button areas to each card panel.
            cardPanelA.add(textPanelA,BorderLayout.NORTH);
            cardPanelA.add(buttonPanelA,BorderLayout.SOUTH);
            cardPanelB.add(textPanelB,BorderLayout.NORTH);
            cardPanelB.add(buttonPanelB,BorderLayout.SOUTH);
            
            // Add each card panels to card layout panel
            helpCards.add(cardPanelA, "DOC");
            helpCards.add(cardPanelB, "START");
            setSize(900,650);
            contentPane.add(helpCards, BorderLayout.NORTH);
        }
    }
}

