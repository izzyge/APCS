import java.util.ArrayList;
public class Practice{

  public String getDomain(String email){
    return email.substring(email.indexOf('@') + 1, email.lastIndexOf('.'));
  }

  public void print(Card[] deck){
    for(Card each: deck){
      System.out.print(each+ ",");
    }
    System.out.println();
  }

  public void print(ArrayList<Card> deck){
    for(Card each: deck){
      System.out.print(each + ",");
    }
    System.out.println();
  }

  public int getLargest(Card[] deck){
    int max = deck[0].getValue();
    for(int i = 0; i< deck.length-1; i++){
      for(int j = i+1; j<deck.length; j++){
        if(deck[j].getValue() > max){
          max = deck[j].getValue();
        }
      }
    }
    return max;
  }

  public int getSmallest(ArrayList<Card> deck){
    int max = deck.get(0).getValue();
    for(int i = 0; i< deck.size()-1; i++){
      for(int j = i+1; j<deck.size(); j++){
        if(deck.get(j).getValue() < max){
          max = deck.get(j).getValue();
        }
      }
    }
    return max;
  }

  public void scramble(Card[] deck){
    for(int i = 0; i<deck.length; i++){
      int i1 = (int)(Math.random()* deck.length);
      Card temp = deck[i1];
      deck[i1] = deck[i];
      deck[i] = temp;
    }
  }

  public void scramble(ArrayList<Card> deck){
    for(int i = 0; i<deck.size(); i++){
      int i1 = (int)(Math.random()* deck.size());
      Card temp = deck.get(i1);
      deck.set(i1, deck.get(i));
      deck.set(i, temp);
    }
  }

  public void sort(Card[] deck){
    for(int i = 0; i<deck.length-1; i++){
      for(int j = i+1; j<deck.length; j++){
        if(deck[j].getValue() < deck[i].getValue()){
          Card temp = deck[j];
          deck[j] = deck[i];
          deck[i] = temp;
        }
      }
    }
  }

  public void sort(ArrayList<Card> deck){
    for(int i = 0; i<deck.size()-1; i++){
      for(int j = i+1; j<deck.size(); j++){
        if(deck.get(j).getValue() < deck.get(i).getValue()){
          Card temp = deck.get(j);
          deck.set(j, deck.get(i));
          deck.set(i, temp);
        }
      }
    }
  }

  public void searchReplace(int value, Card[]deck){
    for(int i=0; i<deck.length;i++){
      if(deck[i].getValue() == 1){
        deck[i] = new Card(value);
      }
    }
  }

  public void searchReplace(int value, ArrayList<Card>deck){
    for(int i=0; i<deck.size();i++){
      if(deck.get(i).getValue() == 1){
        deck.set(i, new Card(value)) ;
      }
    }
  }

  public void searchDelete(int value, ArrayList<Card>deck){
    for(int i=0; i<deck.size();i++){
      if(deck.get(i).getValue() == 1){
        deck.remove(i) ;
      }
    }
  }




}
