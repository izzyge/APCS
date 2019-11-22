/*---------------------------------------------------------------------
--
-- RLine
--
---------------------------------------------------------------------*/
import java.awt.Graphics;
import java.awt.Color;

public class RLine extends RShape
{
    private final int VECTOR_SIZE = 1000;
    
//----------------------------------------------------------------------
    public RLine(int sizeX, int sizeY, int objIndex)
    {
        super(sizeX, sizeY, objIndex);
        m_pointsX = new int[VECTOR_SIZE];
        m_pointsY = new int[VECTOR_SIZE];
        m_rawPntX = new int[VECTOR_SIZE];
        m_rawPntY = new int[VECTOR_SIZE];
        setBaseName();
        m_maxIndex = VECTOR_SIZE - 1;
    }
//----------------------------------------------------------------------
    public void setBaseName()
    {
        m_baseName = "Object : " + m_objIndex + " - Polygon ";
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
            }
            // Else, pressed
            else
            {
                // Indicate that we are ready to set the 1st point
                if(m_armed)
                {
                    m_armed = false;
                    m_trigger = true;
                }
            }
            // Set first and (initial second) point.
            if(m_trigger)
            {
                // Set first point.
                m_trigger = false;
                if(m_index == 0)
                {
                    m_pointsX[m_index] = mouseX;
                    m_pointsY[m_index] = mouseY;
                }

                if(m_index < m_maxIndex)
                {
                    m_index++;
                }
                m_pointsX[m_index] = mouseX;
                m_pointsY[m_index] = mouseY;

            }
            
            // Update second and subsequent points
            else if(dragged && pressed)
            {

                m_pointsX[m_index] = mouseX;
                m_pointsY[m_index] = mouseY;
            }
        }
        // Not in drawing area
        else
        {
            m_trigger = false; m_armed = false;
        }
        draw(wnd, objectIndex);
    }

//----------------------------------------------------------------------
    public void draw(Graphics wnd, int objectIndex)
    {
        
        // Now do the drawing
        m_plotOk = false;
        if(m_index > 1)
        {
            m_plotOk = true;
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
                wnd.fillPolygon(m_pointsX, m_pointsY, (m_index + 1));
            }
        }
        if(m_index > 0)
        {
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
            
            wnd.drawPolyline(m_pointsX, m_pointsY, (m_index + 1));
        }

    }
//----------------------------------------------------------------------
    public void undo()
    {
        if(m_index > 0)
        {
            m_index--;
        }
    }
    
//----------------------------------------------------------------------
    public void clear()
    {
        m_index = 0;
    }


}
