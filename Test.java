package SerializationInheritance;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class A implements Serializable { //classe serializzata
  int i;

  public A (int i) {
    this.i = i;
  }
}

class B extends A {
  int j;

  public B (int i, int j){
    super(i);
    this.j = j;
  }
}

public class Test {
  public static void main (String args[])throws Exception{
    B b1 = new B(300, 20); // dichiarazione di B
    System.out.println("i = " + b1.i); //print di B con i valori della dichiarazione
    System.out.println("j = " + b1.j);
    FileOutputStream fos = new FileOutputStream("abc.ser"); //creo il file di testo e ci scrivo
    ObjectOutputStream oos = new ObjectOutputStream(fos); 
    oos.writeObject(b1); 
    oos.close(); //chiudo
    fos.close();
    System.out.println("Object has been serialized");
    FileInputStream fis = new FileInputStream("abc.ser"); //apro il file e leggo il contenuto
    ObjectInputStream ois = new ObjectInputStream(fis);
    B b2 = (B) ois.readObject();
    ois.close(); //chiudo
    fis.close();
    System.out.println("Object has been deserialized");
    System.out.println("i = " + b2.i);
    System.out.println("j = " + b2.j);
  }
}