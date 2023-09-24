package serial1;

import java.io.*;
class Depersist{
  public static void main(String args[]){
    try{
      //creating stream to read the object
      ObjectInputStream in = new ObjectInputStream(new FileInputStream("output.txt"));
      Employee e1 = (Employee)in.readObject();
      Employee e2 = (Employee)in.readObject();
      Employee e3 = (Employee)in.readObject();

      //printing the data of serialized object
      System.out.println(e1.id + " " + e1.name);
      System.out.println(e2.id + " " + e2.name);
      System.out.println(e3.id + " " + e3.name);

      //closing the stream
      in.close();
    }catch(Exception e) {System.out.println(e);}
  }
}