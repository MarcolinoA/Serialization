package serial1;

import java.io.*;
class Persist {
  public static void main(String args[]){
    try{
      Employee emp1 = new Employee(201010, "Jhon");
      Employee emp2 = new Employee(202020, "Marco");
      Employee emp3 = new Employee(303030, "Fabrizio");

      FileOutputStream fout = new FileOutputStream("output.txt");
      ObjectOutputStream out = new ObjectOutputStream(fout);
      out.writeObject(emp1);
      out.writeObject(emp2);
      out.writeObject(emp3);
      out.flush();

      out.close();
      System.out.println("Serialization and Deserialization is been successfully executed");
    } catch(Exception e) {System.out.println(e);}
  }
}