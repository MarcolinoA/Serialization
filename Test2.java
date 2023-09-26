package SerializationInheritance;

import java.io.*;

class superclass {
  int i;

  public superclass(int i) {
    this.i = i;
  }

  public superclass(){
    i = 50;
    System.out.println("Super class constructor called");
  }
}

class subclass extends superclass implements Serializable {
  int j;

  public subclass (int i, int j){
    super(i);
    this.j = j;
  }
}

public class Test2 {
  public static void main(String args[])throws Exception{
    subclass b1 = new subclass(100, 200);
    System.out.println("i = " + b1.i);
    System.out.println("i = " + b1.j);
    FileOutputStream fos = new FileOutputStream("output.ser");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(b1);
    oos.close();
    fos.close();
    System.out.println("Object has been serialized");
    FileInputStream fis = new FileInputStream("output.ser");
    ObjectInputStream ois = new ObjectInputStream(fis);
    subclass b2 = (subclass) ois.readObject();
    ois.close();
    fis.close();
    System.out.println("Object has been deserialized");
    System.out.println("i = " + b2.i);
    System.out.println("i = " + b2.j);
  }
}
