
package serializacion2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author plago-bergonpazos
 */
public class Serializacion2 {


    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        
      boolean x = true;
        
      product obx1 = new product("p1", "parafusos", 3.0);
      product obx2 = new product("p2", "cravos", 4.0);
      product obx3 = new product("p3", "tachas", 5.0);
      product obxv = new product();
      
      File serial = new File("/home/local/DANIELCASTELAO/plago-bergonpazos/NetBeansProjects/serializacion2/src/serial.txt");
      serial.createNewFile();
      
      FileInputStream in1 = new FileInputStream(serial);
      FileOutputStream out1 = new FileOutputStream(serial);
      ObjectOutputStream out2 = new ObjectOutputStream(out1);
      ObjectInputStream in2 = new ObjectInputStream(in1);
      
      out2.writeObject(obx1);
      out2.writeObject(obx2);
      out2.writeObject(obx3);
      
      out2.close();
      while(x==true){
          obxv = (product) in2.readObject();
          System.out.println(obxv.toString());
          obxv = (product) in2.readObject();
          System.out.println(obxv.toString());
          obxv = (product) in2.readObject();
          System.out.println(obxv.toString());
          x=false;
      }
        
      in2.close();
      
    }
    
}
