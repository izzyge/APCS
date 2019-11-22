/*---------------------------------------------------------------------
--
-- RElipse
--
---------------------------------------------------------------------*/
import java.awt.Graphics;
import java.awt.Color;

public class RElipse extends RRectangle
{
    
//----------------------------------------------------------------------
    public RElipse(int sizeX, int sizeY, int objIndex)
    {
        super(sizeX, sizeY, objIndex);
        setBaseName();
        m_maxIndex = 1;
    }
//----------------------------------------------------------------------

    public void setBaseName()
    {
        m_baseName = "Object : " + m_objIndex + " - Ellipse ";
        m_fullName = m_baseName;
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
                wnd.fillOval(m_pointsX[0], m_pointsY[0], 
                                (m_pointsX[1] - m_pointsX[0]), (m_pointsY[1] - m_pointsY[0]));
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
            wnd.drawOval(m_pointsX[0], m_pointsY[0], 
                            (m_pointsX[1] - m_pointsX[0]), 
                            (m_pointsY[1] - m_pointsY[0]));
            if(objectIndex == m_objIndex)
            {
                wnd.drawRect(m_pointsX[0], m_pointsY[0], 
                            (m_pointsX[1] - m_pointsX[0]), 
                            (m_pointsY[1] - m_pointsY[0]));
            }
            
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
