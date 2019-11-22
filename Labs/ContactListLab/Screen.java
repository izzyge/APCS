import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Screen extends JPanel implements ActionListener{

    private Contact[] contactList;

    private JTextPane allContactsPane;

    private JButton searchFirstButton;
    private JButton searchLastButton;
    private JButton searchUserButton;
    private JButton searchDomButton;
    private JButton searchExtButton;
    private JButton sortFirstButton;
    private JButton sortLastButton;
    private JButton sortEmailButton;
    private JTextField searchInput;
    private JTextPane searchResultsPane;

    public Screen(){

        this.setLayout(null);

        contactList = new Contact[10];
        contactList[0] = new Contact("John", "Adams", "johnadams@gmail.com");
        contactList[1] = new Contact("Barack", "Obama", "barryo@hotmail.com");
        contactList[2] = new Contact("Abraham", "Lincoln", "abe.lincoln@mvla.net");
        contactList[3] = new Contact("Alexander", "Hamilton", "alexham@mail.gov");
        contactList[4] = new Contact("George", "Bush", "georgebush@yahoo.com");
        contactList[5] = new Contact("William", "Taft", "willt@mvla.net");
        contactList[6] = new Contact("James", "Monroe", "james.m@gmail.com");
        contactList[7] = new Contact("Thomas", "Jefferson", "thomas.jeff@jefferson.org");
        contactList[8] = new Contact("Ronald", "Reagan", "ronaldreag@gmail.com");
        contactList[9] = new Contact("John F.", "Kennedy", "jfk@kennedy.gov");

        allContactsPane = new JTextPane();
        allContactsPane.setBounds(10,100,200,470);
        this.add(allContactsPane);

        String contactStr = "";
        for(int i = 0; i<contactList.length; i++){
          contactStr += contactList[i].toString() + "\n";
        }
        allContactsPane.setText(contactStr);

        searchFirstButton = new JButton("First Name");
        searchFirstButton.setBounds(240,50,100,30);
        searchFirstButton.addActionListener(this);
        this.add(searchFirstButton);

        searchLastButton = new JButton("Last Name");
        searchLastButton.setBounds(350,50,100,30);
        searchLastButton.addActionListener(this);
        this.add(searchLastButton);

        searchUserButton = new JButton("Username");
        searchUserButton.setBounds(460,50,100,30);
        searchUserButton.addActionListener(this);
        this.add(searchUserButton);

        searchDomButton = new JButton("Domain");
        searchDomButton.setBounds(570,50,100,30);
        searchDomButton.addActionListener(this);
        this.add(searchDomButton);

        searchExtButton = new JButton("Dom. Ext.");
        searchExtButton.setBounds(680,50,100,30);
        searchExtButton.addActionListener(this);
        this.add(searchExtButton);

        sortEmailButton = new JButton("Sort By Email");
        sortEmailButton.setBounds(550,250,200,30);
        sortEmailButton.addActionListener(this);
        this.add(sortEmailButton);

        sortLastButton = new JButton("Sort By Last Name");
        sortLastButton.setBounds(550,320,200,30);
        sortLastButton.addActionListener(this);
        this.add(sortLastButton);

        sortFirstButton = new JButton("Sort By First Name");
        sortFirstButton.setBounds(550,390,200,30);
        sortFirstButton.addActionListener(this);
        this.add(sortFirstButton);

        searchInput = new JTextField();
        searchInput.setBounds(10,50,200,30);
        this.add(searchInput);

        searchResultsPane = new JTextPane();
        searchResultsPane.setBounds(310,100,200,470);
        this.add(searchResultsPane);

        this.setFocusable(true);


    }

    public Dimension getPreferredSize(){
        //Sets the size of the panel
        return new Dimension(800,600);
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);


    }

    public void actionPerformed(ActionEvent e) {
      if( e.getSource() == searchFirstButton){

        String firstNameSearch = searchInput.getText();

        String contactStr = "";
        for(int i = 0; i<contactList.length; i++){
          if(contactList[i].getFirstName().equals(firstNameSearch)){
            contactStr += contactList[i] + "\n";
          }
        }
        searchResultsPane.setText(contactStr);
      } else if ( e.getSource() == searchLastButton){
        String lastNameSearch = searchInput.getText();

        String contactStr = "";
        for(int i = 0; i<contactList.length; i++){
          if(contactList[i].getLastName().equals(lastNameSearch)){
            contactStr += contactList[i] + "\n";
          }
        }
        searchResultsPane.setText(contactStr);
      } else if ( e.getSource() == searchUserButton ){
        String userSearch = searchInput.getText();

        String contactStr = "";
        for(int i = 0; i<contactList.length; i++){
          if(contactList[i].getUsername().equals(userSearch)){
            contactStr += contactList[i] + "\n";
          }
        }
        searchResultsPane.setText(contactStr);
      } else if ( e.getSource() == searchDomButton ){
        String domSearch = searchInput.getText();

        String contactStr = "";
        for(int i = 0; i<contactList.length; i++){
          if(contactList[i].getDomainName().equals(domSearch)){
            contactStr += contactList[i] + "\n";
          }
        }
        searchResultsPane.setText(contactStr);
      } else if ( e.getSource() == searchExtButton ){
        String extSearch = searchInput.getText();

        String contactStr = "";
        for(int i = 0; i<contactList.length; i++){
          if(contactList[i].getDomainExt().equals(extSearch)){
            contactStr += contactList[i] + "\n";
          }
        }
        searchResultsPane.setText(contactStr);
      } else if ( e.getSource() == sortFirstButton ){

        String contactStr = "";
        for(int i = 0; i<contactList.length ; i++){
          int min = i;
          int current = i;
          for(int j = i+1; j<contactList.length; j++){

            if(contactList[j].getFirstName().compareTo(contactList[min].getFirstName()) < 0){
              min = j;
            }
          }

          if(min!= current){
            Contact temp = contactList[current];
            contactList[current] = contactList[min];
            contactList[min] = temp;


          }
          contactStr += contactList[i] + "\n";


        }
        searchResultsPane.setText(contactStr);
    } else if ( e.getSource() == sortLastButton ){

      String contactStr = "";
      for(int i = 0; i<10 ; i++){
        int min = i;
        int current = i;
        for(int j = i+1; j<10; j++){

          if(contactList[j].getLastName().compareTo(contactList[min].getLastName()) < 0){
            min = j;
          }
        }

        if(min!= current){
          Contact temp = contactList[current];
          contactList[current] = contactList[min];
          contactList[min] = temp;



        }

        contactStr += contactList[i] + "\n";


      }
      searchResultsPane.setText(contactStr);
    } else if ( e.getSource() == sortEmailButton ){

        String contactStr = "";
        for(int i = 0; i<10 ; i++){
          int min = i;
          int current = i;
          for(int j = i+1; j<10; j++){

            if(contactList[j].getUsername().compareTo(contactList[min].getUsername()) < 0){
              min = j;
            }
          }

          if(min!= current){
            Contact temp = contactList[current];
            contactList[current] = contactList[min];
            contactList[min] = temp;



          }

          contactStr += contactList[i] + "\n";


        }
        searchResultsPane.setText(contactStr);
    }
  }

}
