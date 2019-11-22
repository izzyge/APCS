/*---------------------------------------------------------------------
--
-- RShape
--
---------------------------------------------------------------------*/
import java.awt.Graphics;
import java.awt.Color;

public class RShape
{
    protected int m_index, m_rawInd, m_objIndex;
    protected int m_sizeX, m_sizeY;
    protected boolean m_trigger, m_armed;
    protected int m_blue = 255;
    protected Color m_colorActive;
    protected Color m_colorIdle;
    protected Color m_outlineColorActive;
    protected Color m_outlineCorlorIdle;
    protected String m_userName;
    protected String m_baseName;
    protected String m_fullName;
    protected boolean m_fill;
    protected int[] m_pointsX;
    protected int[] m_pointsY;
    protected int[] m_rawPntX;
    protected int[] m_rawPntY;
    protected boolean m_plotOk;
    protected int m_maxIndex;
       
//----------------------------------------------------------------------
    public RShape(int sizeX, int sizeY, int objIndex)
    {
        m_index = 0; m_rawInd = 0;
        m_plotOk = false;
        m_sizeX = sizeX; m_sizeY = sizeY;
        m_objIndex = objIndex;
        m_trigger = false; m_armed = false;
        m_userName = "";
        m_baseName = "";
        m_fill = true;
        
        m_colorActive = PointGenerator.COLOR_ACTIVE;
        m_colorIdle = PointGenerator.COLOR_IDLE;
        
        m_outlineColorActive = Color.RED;
        m_outlineCorlorIdle = Color.BLACK;
    }
//----------------------------------------------------------------------
    public void setBaseName()
    {
    }
    
//----------------------------------------------------------------------
    public void toggleFill()
    {
        if(m_fill)
        {
            m_fill = false;
        }
        else
        {
            m_fill = true;
        }
    }
//----------------------------------------------------------------------
    public boolean getFill()
    {
        return m_fill;
    }
//----------------------------------------------------------------------
    public String getName()
    {
        return(m_fullName);
    }
//----------------------------------------------------------------------
    public String getBaseName()
    {
        return m_baseName;
    }
//----------------------------------------------------------------------
    public String getUserName()
    {
        return m_userName;
    }
//----------------------------------------------------------------------
    public void setUserName(String name)
    {
        m_userName = name;
        if(m_userName.equals(""))
        {
            m_fullName = m_baseName;
        }
        else
        {
            m_fullName = m_baseName + "(" + m_userName + ")";
        }
 
        return;
    }
//----------------------------------------------------------------------
    public void update(Graphics wnd, int mouseX, int mouseY,
                    int objectIndex, boolean pressed, boolean dragged,
                    boolean entered)
    {
    }

//----------------------------------------------------------------------
    public void draw(Graphics wnd, int objectIndex)
    {
    }
//----------------------------------------------------------------------
    public void undo()
    {
    }
    
//----------------------------------------------------------------------
    public void clear()
    {

    }
//----------------------------------------------------------------------
    public int getObjIndex()
    {
        return m_objIndex;
    }
//----------------------------------------------------------------------
    public void setObjIndex(int index)
    {
        m_objIndex = index;
        setBaseName();
        return;
    }
//----------------------------------------------------------------------
    public int getPointsIndex()
    {
        //System.out.println("POINTS INDEX : " + m_index);
        return m_index;
    }
//----------------------------------------------------------------------
    public void setPointsIndex(int pointsIndex)
    {
        m_index = pointsIndex;
        m_rawInd = m_index;
        m_plotOk = true;
    }
//----------------------------------------------------------------------
    public boolean getPlotOk()
    {
        return(m_plotOk);
    }
//----------------------------------------------------------------------
    public int[] getPointsX()
    {
        return m_pointsX;
    }
//----------------------------------------------------------------------
    public int[] getPointsY()
    {
        return m_pointsY;
    }
//----------------------------------------------------------------------
    public void incrObjX(boolean left, boolean right, boolean all, int deltaP)
    {
        int delta = 0;
        if(left)
        {
            delta = -deltaP;
        }
        else if(right)
        {
            delta = deltaP;
        }
        else return;
        
        if(!all)
        {
            m_pointsX[m_index] += delta;
            if(m_index <= 1)
            {
                m_rawPntX[m_index] += delta;
            }
        }
        else
        {
            int i;
            for(i = 0; i <= m_index; i++)
            {
                m_pointsX[i] += delta;
            }
            if(m_index <= 1)
            {
                for(i = 0; i <= m_index; i++)
                {
                    m_rawPntX[i] += delta;
                }
            }
        }
        return;
    }
//----------------------------------------------------------------------
    public void incrObjY(boolean up, boolean down, boolean all, int deltaP)
    {
        int delta = 0;
        if(up)
        {
            delta = -deltaP;
        }
        else if(down)
        {
            delta = deltaP;
        }
        else return;
        
        if(!all)
        {
            m_pointsY[m_index] += delta;
            if(m_index <= 1)
            {
                m_rawPntY[m_index] += delta;
            }
        }
        else
        {
            int i;
            for(i = 0; i <= m_index; i++)
            {
                m_pointsY[i] += delta;
            }
            if(m_index <= 1)
            {
                for(i = 0; i <= m_index; i++)
                {
                    m_rawPntY[i] += delta;
                }
            }
        }
    }
//----------------------------------------------------------------------
    public int getX0()
    {
        return m_pointsX[0];
    }
//----------------------------------------------------------------------
    public int getY0()
    {
        return m_pointsY[0];
    }

}
