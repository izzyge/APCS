import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Screen extends JPanel implements KeyListener, ActionListener{
  private Player player;
  private BufferedImage bg1;
  private BufferedImage bg2;
  private BufferedImage bg3;
  private BufferedImage bg4;
  private BufferedImage bg5;
  private BufferedImage bg6;
  private BufferedImage bg7;
  private BufferedImage bg8;
  private BufferedImage bg9;

  private BufferedImage fastPotion;
  private BufferedImage healthPotion;
  private BufferedImage shell;
  private BufferedImage apple;
  private BufferedImage escPotion;
  private BufferedImage hammer;

  private BufferedImage char1;
  private BufferedImage char2;
  private BufferedImage char3;

  private BufferedImage up;
  private BufferedImage down;
  private BufferedImage l;
  private BufferedImage r;

  private JButton start;

  private Water[] water;
  private boolean right;
  private boolean left;
  private int scene;
  private boolean inv;
  private int count;
  private int marlin;
  private boolean sound2;
  private int sound;
  private int ch;
  private boolean win;


	private ArrayList<Item> groundItems;
	private ArrayList<Item> inventory;
  private GrayFish c1;
  private Crab c2;
  private Marlin c3;

	public Screen(){
    this.setLayout(null);
    player = new Player(400,300);
    scene = 0;
    right = false;
    left = false;
    inv = false;
    count = 1;
    marlin = 7;
    sound2 = false;
    sound = 1;
    ch=1;
    groundItems = new ArrayList<>();
    inventory = new ArrayList<>();
    start = new JButton("Start");
    start.setBounds(350,400,100,100);
    start.addActionListener(this);
    this.add(start);



    water = new Water[100];
		for(int i = 0; i<water.length;i++){
			water[i] = new Water();
		}

    try{
      bg1= ImageIO.read(new File("imgs/bg1.jpg"));
      bg2= ImageIO.read(new File("imgs/bg2.jpg"));
      bg3= ImageIO.read(new File("imgs/bg3.jpeg"));
      bg4= ImageIO.read(new File("imgs/bg4.jpg"));
      bg5= ImageIO.read(new File("imgs/bg5.jpg"));
      bg6= ImageIO.read(new File("imgs/bg6.jpeg"));
      bg7= ImageIO.read(new File("imgs/bg7.jpg"));
      bg8= ImageIO.read(new File("imgs/bg8.jpg"));
      bg9= ImageIO.read(new File("imgs/bg9.jpg"));
      up= ImageIO.read(new File("imgs/up.png"));
      down= ImageIO.read(new File("imgs/down.png"));
      l= ImageIO.read(new File("imgs/left.png"));
      r= ImageIO.read(new File("imgs/right.png"));

      char1= ImageIO.read(new File("imgs/char1.png"));
      c1 = new GrayFish(60,100, char1);
      char2= ImageIO.read(new File("imgs/char2.png"));
      c2 = new Crab(240, 120, char2);
      char3= ImageIO.read(new File("imgs/char3.png"));
      c3 = new Marlin(200, 300, char3);

      fastPotion = ImageIO.read(new File("imgs/fastPotion.png"));
      groundItems.add(0,new FastPotion(600,400, fastPotion, 1));
      healthPotion = ImageIO.read(new File("imgs/healthPotion.png"));
      groundItems.add(1,new HealthPotion(200,300, healthPotion, 1));
      shell = ImageIO.read(new File("imgs/shell.png"));
      groundItems.add(2,new Shell(100,400, shell, 4));
      apple = ImageIO.read(new File("imgs/apple.png"));
      groundItems.add(3,new Apple(450,400, apple, 5));
      escPotion = ImageIO.read(new File("imgs/escPotion.png"));
      groundItems.add(4,new EscPotion(200,400, escPotion, 9));
      hammer = ImageIO.read(new File("imgs/hammer.png"));
      groundItems.add(5,new Hammer(400,300, hammer, 8));
    } catch (IOException ex){

    }


		//sets keylistener
		setFocusable(true);
    addKeyListener(this);

  }






	public Dimension getPreferredSize() {
		//Sets the size of the panel
        return new Dimension(800,600);
	}

	public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if(scene == 1)
      g.drawImage(bg1,0,0,800,600, null);
    else if(scene == 2)
      g.drawImage(bg2,0,0,800,600, null);
    else if(scene == 3)
      g.drawImage(bg3,0,0,800,600, null);
    else if(scene == 4)
      g.drawImage(bg4,0,0,800,600, null);
    else if(scene == 5)
      g.drawImage(bg5,0,0,800,600, null);
    else if(scene == 6)
      g.drawImage(bg6,0,0,800,600, null);
    else if(scene == 7)
      g.drawImage(bg7,0,0,800,600, null);
    else if(scene == 8)
      g.drawImage(bg8,0,0,800,600, null);
    else if(scene == 9)
      g.drawImage(bg9,0,0,800,600, null);

    for(int i = 0; i< groundItems.size(); i++){
      if(groundItems.get(i).getScene()== scene)
        groundItems.get(i).drawMe(g);
    }

    if(scene == 2){
      c1.drawMe2(g,100,150);
        c1.conversation(g);
        player.setDX();

    }

    if(scene == 3){
      c2.drawMe2(g, 150,150);
      c2.conversation(g);

    }


    g.setColor(Color.white);
    g.drawString("Quest" + count, 740,30);
    if(count == 1){
      g.drawString("Collect 2 potions and bring them to the gray fish", 480, 60);
    } else if(count == 2){
      g.drawString("Collect apple and shell and return to the crab", 430, 60);
    } else if(count == 3){
      g.drawString("Collect 2 items and bring them to bottom left corner", 430, 60);
    }

        if(win){
          int timer = 1;
          while(timer<120)
            timer++;

          if(timer == 120){
          g.setColor(Color.black);
          g.fillRect(0,0,800,600);
          g.setColor(Color.white);
          g.drawString("YOU WON!!!", 390, 250);
        }
        }

    if(scene == marlin){
      c3.drawMe2(g, 150,150);
      c3.conversation(g);

    }



    for(int i = 0; i<water.length;i++){
			water[i].drawMe(g);
		}

    if(ch == 1 ||ch == 2 ||ch == 6 ||ch == 7)
      g.drawImage(r, 725, 275, 50, 50, null);
    else if(ch == 4 ||ch == 5 ||ch == 11 ||ch == 12)
      g.drawImage(l, 25, 275, 50, 50, null);
    else if(ch == 3 ||ch == 9 ||ch == 10)
      g.drawImage(down, 375, 525, 50, 50, null);
    else if(ch==8)
      g.drawImage(up, 375, 25, 50, 50, null);



    player.drawMe(g);




    if(inv){
      g.setColor(new Color(255, 255, 255, 200));
      g.fillRect(0,0,800,600);
      g.setColor(new Color(0,0,0));
      g.drawString("INVENTORY", 100,150);
      g.drawString("use esc to exit",100,520);

      for(int i = 0; i< inventory.size(); i++){
        inventory.get(i).drawMe2(g, 80* (i+1), 250, 50, 50);
        g.drawString(i+1 + "", 90* (i+1), 320);
      }

      g.drawString("1: Fast Potion", 300, 400);
      g.drawString("2: Health Potion", 300, 420);
      g.drawString("3: Apple",300,440);
      g.drawString("4: Shell",300,460);
      g.drawString("5: Escape Potion",300,480);
      g.drawString("6: Hammer",300,500);


    }



    if(scene == 0){
      g.setColor(Color.black);
      g.fillRect(0,0,800,600);
      g.setColor(Color.orange);
      g.drawString("Finding Nemo!", 50, 50);
      g.setColor(Color.white);
      g.drawString("USE ARROW KEYS TO MOVE AROUND", 250, 150);
      g.drawString("TOUCH ITEMS TO ADD THEM TO INVENTORY", 250, 200);
      g.drawString("TOUCH CHARACTERS TO TALK TO THEM", 250, 250);
      g.drawString("USE I KEY TO ACCESS INVENTORY, ESC TO LEAVE", 250, 300);
      g.drawString("YOU MUST TRAVEL IN THE DIRECTION OF THE ARROWS", 250, 350);
    }





	}

  public void animate(){
    while(true){
      if(right){
        for(int i=0; i<water.length; i++){
          water[i].moveRight();
        }
      } else if(left){
        for(int i=0; i<water.length; i++){
          water[i].moveLeft();
        }
      }

      if(scene%3!=0 && player.getX() > 780){
        scene ++;
        ch++;
        player.setX(20);
      } else if(scene%3!=1 && player.getX() < 20){
        scene --;
        ch++;
        player.setX(780);
      }

      if(!(scene>6) && player.getY() > 580){
        scene+=3;
        ch++;
        player.setY(20);
      } else if(!(scene<3) && player.getY() < 20){
        scene -=3;
        ch++;
        player.setY(580);
      }

      if(scene%3 == 0&& player.getX() > 750)
        player.setX(780);
      else if(scene%3==1 && player.getX() < 50)
        player.setX(50);
      else if(scene <= 3 && player.getY() < 50)
        player.setY(50);
      else if(scene >6 && player.getY() > 550)
        player.setY(550);




      for(int i = 0; i< groundItems.size(); i++){
        if(groundItems.get(i).getScene() == scene && groundItems.get(i).checkCollision(player)){
          inventory.add(groundItems.get(i));
          groundItems.get(i).setVisible(false);
          this.playSound();


        }
      }

      if(c1.checkCollision2(player)){
        if(scene == 2){
          c1.setActive();
          count=2;
          sound2 = true;
          if(sound == 1){
            playSound2();
            sound=2;
          }

        }

      }else if(c2.checkCollision2(player)){
        if(scene ==3){
        if(checkInventory(4) && checkInventory(5)){
          c2.changeMessage();
          count=3;
          sound2= true;
          if(sound == 2){
            playSound2();
            sound=3;
          }

        }


          c2.setActive();

        }


      }else if(c3.checkCollision2(player)){

        if(scene == 7|| scene ==8)
          c3.setActive();


      }






      repaint();
      try {
			    Thread.sleep(30);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
    }

  }

  public void nextQuest(int count){
    if(count == 1){
      inventory.clear();
      inventory.add(groundItems.get(0));
      groundItems.get(0).setVisible(false);
      inventory.add(groundItems.get(1));
      groundItems.get(1).setVisible(false);
      scene = 3;
      player.setX(100);
      player.setY(100);
      player.setDX();
      ch = 3;
    } else if(count == 2){
      if(!checkInventory(4)){
        inventory.add(groundItems.get(2));
        groundItems.get(2).setVisible(false);
      }
      if(!checkInventory(5)){
        inventory.add(groundItems.get(3));
        groundItems.get(3).setVisible(false);
      }
      c2.changeMessage();
      c2.setActive();
      scene = 3;
      ch=9;

    } else if(count == 3){
      if(!checkInventory(9)){
        inventory.add(groundItems.get(4));
        groundItems.get(4).setVisible(false);
      }
      if(!checkInventory(8)){
        inventory.add(groundItems.get(5));
        groundItems.get(5).setVisible(false);
      }
      scene = 8;
      marlin = 8;
      c3.changeMessage();
      c3.setActive();
      win = true;
      ch=0;

    }
  }

  public void playSound() {
    Sound.playSound("sound/Ding.wav");
  }


  public void playSound2() {
    if(sound2)
      Sound.playSound("sound/Win.wav");
  }

  public boolean checkInventory(int scene){
    for(int i=0; i<inventory.size(); i++){
      if(inventory.get(i).getScene() == scene)
        return true;
    }
    return false;
  }




	//implement methods of the KeyListener
	public void keyPressed(KeyEvent e) {

		//key code
		//http://www.cambiaresearch.com/articles/15/javascript-char-codes-key-codes

		if (e.getKeyCode()==38){
      player.moveUp();
    } else if(e.getKeyCode()==37){
      player.moveLeft();
      right = false;
      left = true;
    } else if(e.getKeyCode()==39){
      player.moveRight();
      left = false;
      right = true;
    } else if(e.getKeyCode()==40){
      player.moveDown();
    } else if(e.getKeyCode()==73){
      inv = true;
    } else if(e.getKeyCode()==27){
      inv = false;
    } else if(e.getKeyCode()==80){
      nextQuest(count);
      if(count<3)
        count++;
      sound2 = true;
      this.playSound2();
    } else if(e.getKeyCode()==53 || e.getKeyCode()==54){
      inv = false;
      scene = 8;
      marlin = 8;
      c3.changeMessage();
      win = true;
      sound2=true;
      this.playSound2();


    }


		repaint();

	}

	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}

  public void actionPerformed(ActionEvent e) {
    if( e.getSource() == start){
      scene = 1;
      start.setVisible(false);
    }
  }
}
