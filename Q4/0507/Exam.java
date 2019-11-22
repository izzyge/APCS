import java.util.ArrayList;

public class Exam{

  public void printTable(int[][]matrix){
    for(int r = 0; r<matrix.length; r++){
      for(int c = 0; c<matrix[r].length; c++){
        System.out.print(matrix[r][c]);
      }
    }
  }

  public int findSmallest(int[][] matrix){
    int smallest = matrix[0][0];
    for(int r = 0; r<matrix.length; r++){
      for(int c = 0; c<matrix[r].length; c++){
        if(matrix[r][c] < smallest)
          smallest = matrix[r][c];
      }
    }
    return smallest;
  }

  public int findOccurrence(int[][] matrix, int num){
    int occ = 0;
    for(int r = 0; r<matrix.length; r++){
      for(int c = 0; c<matrix[r].length; c++){
        if(matrix[r][c] == num)
          occ++;
      }
    }
    return occ;
  }

  public void printstudentList(ArrayList<Student> studentList){
    for(int i = 0; i<studentList.size(); i++){
      System.out.println(studentList.get(i));
    }
  }

  public int averageAge(ArrayList<Student> studentList){
    int total = 0;
    for(int i = 0; i<studentList.size(); i++){
      total+=studentList.get(i).getAge();
    }
    return total/studentList.size();
  }

  public void sort(ArrayList<Student> studentList){
    int min = 0;
    for(int i = 0; i<studentList.size(); i++){
      if(studentList.get(i).getAge() < studentList.get(min).getAge()){
        Student temp = studentList.get(i);
        studentList.set(i, studentList.get(min));
        studentList.set(min, temp);

      }
    }
  }

  public String getUser(String email){
    return email.substring(0, email.indexOf("@"));
  }

  public String getDomain(String email){
    return email.substring(email.indexOf("@") + 1, email.indexOf("."));
  }

  public int count(String email, char ch){
    int count = 0;
    for(int i = 0; i<email.length(); i++){
      if(email.charAt(i) == ch){
        count++;
      }
    }
    return count;
  }


}
