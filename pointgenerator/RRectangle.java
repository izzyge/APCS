/*---------------------------------------------------------------------
--
-- RRectangle
--
---------------------------------------------------------------------*/
import java.awt.Graphics;
import java.awt.Color;

public class RRectangle extends RShape
{
    protected final int VECTOR_SIZE = 1000;
    
//----------------------------------------------------------------------
    public RRectangle(int sizeX, int sizeY, int objIndex)
    {
        super(sizeX, sizeY, objIndex);
        m_rawPntX = new int[2];
        m_rawPntY = new int[2];
        m_pointsX = new int[2];
        m_pointsY = new int[2];
        m_plotOk = false;
        final int NUMPTS = 2;
        setBaseName();
        m_maxIndex = 1;
    }
//----------------------------------------------------------------------
    public void setBaseName()
    {
        m_baseName = "Object : " + m_objIndex + " - Rectangle ";
        m_fullName = m_baseName;
    }
    
//----------------------------------------------------------------------
    public void update(Graphics wnd, int mouseX, int mouseY, 
                        int objectIndex, boolean pressed, boolean dragged,
                        boolean entered)
    {
        // In drawing area
        //if((mouseX < m_sizeX) && (mouseY < m_sizeY))
        if(entered)
        {
            // Not pressed
            if(!pressed)
            {
                m_armed = true;
                //m_rawInd = 0;
            }
            // Else, pressed
            else
            {
                if(m_armed)
                {
                    m_armed = false;
                    m_trigger = true;
                }
            }
            // First corner point in rectangle
            if(m_trigger && pressed)
            {
                m_trigger = false;
                m_index = 0;
                m_rawInd = 0;
                if(m_rawInd == 0)
                {
                    m_rawPntX[m_rawInd] = mouseX;
                    m_rawPntY[m_rawInd] = mouseY;
                    
                    orderCoordinates();
                    m_rawInd = 1;
                    m_plotOk = false;
               }
            }
            // Second corner point in rectangle.
            else if(dragged && (m_rawInd == 1) && pressed)
            {
                m_rawInd = 1;
                m_index = m_rawInd;
                m_rawPntX[m_rawInd] = mouseX;
                m_rawPntY[m_rawInd] = mouseY;
                
                orderCoordinates();
                m_plotOk = true;
            }
        }
        // Not in drawing area
        else
        {
            m_trigger = false; m_armed = false; //m_rawInd = 0; 
        }
        //orderCoordinates();
        draw(wnd, objectIndex);
    }
    
//----------------------------------------------------------------------
    private void orderCoordinates()
    {
        // Set up plot corner x points from smallest to largest.
        if(m_rawPntX[0] > m_rawPntX[1])
        {
            m_pointsX[0] = m_rawPntX[1];
            m_pointsX[1] = m_rawPntX[0];
        }
        else
        {
            m_pointsX[0] = m_rawPntX[0];
            m_pointsX[1] = m_rawPntX[1];
        }
        
        // Set up plot corner y points from smallest to largest.
        if(m_rawPntY[0] > m_rawPntY[1])
        {
            m_pointsY[0] = m_rawPntY[1];
            m_pointsY[1] = m_rawPntY[0];
        }
        else
        {
            m_pointsY[0] = m_rawPntY[0];
            m_pointsY[1] = m_rawPntY[1];
        }
    }

//----------------------------------------------------------------------
    public void draw(Graphics wnd, int objectIndex)
    {
                
        m_index = m_rawInd;
        if(m_plotOk)
        {
            // Fill enabled - (set fill color based on whether 
            // we are the current active object) and draw it.
            if(m_fill)
            {
                if(objectIndex == m_objIndex)
                {
                    wnd.setColor(m_colorActive);
                }
                else
                {
                    wnd.setColor(m_colorIdle);
                }           
                wnd.fillRect(m_pointsX[0], m_pointsY[0], 
                             (m_pointsX[1] - m_pointsX[0]), 
                             (m_pointsY[1] - m_pointsY[0]));
            }
                            
            //Draw object outline - set line color based
            // on whether we are the active object and draw it.
            if(objectIndex == m_objIndex)
            {
                wnd.setColor(m_outlineColorActive);
            }
            else
            {
                wnd.setColor(m_outlineCorlorIdle);
            }           
            wnd.drawRect(m_pointsX[0], m_pointsY[0], 
                            (m_pointsX[1] - m_pointsX[0]), 
                            (m_pointsY[1] - m_pointsY[0]));
            
        }


    }
//----------------------------------------------------------------------
    public void undo()
    {
        m_rawInd = 0;
        m_plotOk = false;
    }
    
//----------------------------------------------------------------------
    public void clear()
    {
        m_rawInd = 0;
        m_plotOk = false;
    }

}
