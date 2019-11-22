import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Font;

public class Scenery extends JPanel{

    public String currentSeason;
    private int seasonTime;
    private RainDrop[] rain;
    private Snow[] snow;
    private Trees[] tree;
    private Clouds clouds;
    private Mountains[] mountain;
    private int[] riverX = {0,100,200,300,400,500,600,700};
    private int[] riverY;



    public Scenery(){
      seasonTime = 1;
      currentSeason = "Spring";
      clouds = new Clouds();
      riverY = new int[8];
        for(int i = 0; i<8; i+=2){
          riverY[i] = 560;
        }
        for(int i = 1; i<8; i+=2){
          riverY[i] = 575;
        }


        rain = new RainDrop[100];
        for(int i=0; i<rain.length; i++){
            rain[i] = new RainDrop();
        }

        snow = new Snow[100];
        for(int i=0; i<snow.length; i++){
            snow[i] = new Snow();
        }

        tree = new Trees[30];
        for(int i=0; i<tree.length; i++){
            tree[i] = new Trees();
        }

        mountain = new Mountains[9];
        for(int i=0; i<mountain.length; i++){
            mountain[i] = new Mountains();
        }



    }

    public Dimension getPreferredSize() {
        //Sets the size of the panel
        return new Dimension(800,600);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Color sky = new Color(196, 249, 255);
        Color ground = new Color(100, 168, 112);
        Color river = new Color(25, 162, 255);

        g.setFont(new Font("TimesRoman", Font.PLAIN, 60));

        g.setColor(sky);
        g.fillRect(0,0,800,300);
        g.setColor(ground);
        g.fillRect(0,300,800,300);

        for(int i = 0; i<mountain.length; i++){
          mountain[i].drawMe(g);
        }
        if(currentSeason.equals("Winter")){
          for(int i = 0; i<mountain.length; i++){
            mountain[i].drawMeWinter(g);
          }
        }


        Color frozen = new Color(177, 199, 204);
        if(currentSeason.equals("Winter")){
          g.setColor(frozen);
          g.fillRect(0,540,800,45);
        }else{
          g.setColor(river);
          g.fillRect(0,540,800,45);
          for(int i = 0; i<8; i++){
            g.setColor(Color.white);
            g.fillRect(riverX[i],riverY[i],50,3);
          }
        }

        if(currentSeason.equals("Spring")|| currentSeason.equals("Summer")){
          g.setColor(Color.yellow);
          g.fillOval(700,80,60,60);
          for(int i=0; i<tree.length; i++){
              tree[i].drawMeGreen(g);
          }
        }

        if(currentSeason.equals("Spring")){
          g.setColor(Color.black);
          g.drawString("Spring",600,50);

          for(int i=0; i<rain.length; i++){
              rain[i].drawMe(g);
          }
        }

        if(currentSeason.equals("Summer")){
          g.setColor(Color.black);
          g.drawString("Summer",570,50);
        }



        if(currentSeason.equals("Spring")|| currentSeason.equals("Fall")){
          clouds.drawMe(g);
        }

        if(currentSeason.equals("Fall")){

          for(int i=0; i<tree.length; i++){
              tree[i].drawMeOrange(g);
          }
          g.setColor(Color.black);
          g.drawString("Fall",600,50);
        }

        if(currentSeason.equals("Winter")){


          clouds.drawMe(g);
          clouds.drawMe2(g);
          for(int i=0; i<tree.length; i++){
              tree[i].drawMeBrown(g);
          }

          for(int i=0; i<snow.length; i++){
              snow[i].drawMe(g);
          }
          g.setColor(Color.black);
          g.drawString("Winter",600,50);
        }





    }


    public void animate(){
        while(true){
            //wait for .01 second
            seasonTime++;
            for(int i = 0; i<8; i++){
              riverX[i] ++;
              if(riverX[i]>800){
                riverX[i] = 0;
              }
            }
            if(seasonTime<500){
              currentSeason = "Spring";
            } else if(seasonTime<1000){
              currentSeason = "Summer";
            } else if(seasonTime<1500){
              currentSeason = "Fall";
            } else if(seasonTime<2000){
              currentSeason = "Winter";
            } else {
              seasonTime = 0;
            }

            try {
                Thread.sleep(10);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }



            for(int i=0; i<rain.length; i++){
                rain[i].move();
            }

            for(int i=0; i<snow.length; i++){
                snow[i].move();
            }

            //repaint the graphics drawn
            repaint();
        }

    }



}
