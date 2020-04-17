package PGL.pglp_5_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;

public class PersonnelDAO extends DAO<Personnel>{

	@Override
	public Personnel create(Personnel obj) throws IOException {
        String nomDir = "PersonnelDAO";
        File dir = new File(nomDir);
        FileOutputStream fileOut;
        ObjectOutputStream objOut;

        File file = new File(nomDir + "\\" + obj.getId() + ".txt");
        if (!dir.exists()) {
            if (dir.mkdir()) {
                System.out.println("File created");
            }
        }
        fileOut = new FileOutputStream(file);
        objOut = new ObjectOutputStream(fileOut);
        objOut.writeObject(obj);
        objOut.close();
        return obj;	
	}

	@Override
	public void delete(Personnel obj) {
	     String nomDir = "PersonnelDAO";
	        File dir = new File(nomDir);
	        if (dir.exists()) {
	            File file = new File(nomDir + "\\" + obj.getId() + ".txt");
	            if (file.exists()) {
	                file.delete();
	                System.out.println("File deleted!");
	            }
	        }
	    }

	@Override
	public Personnel update(Personnel obj)    throws IOException {
        String nomDir = "PersonnelDAO";
        File dir = new File(nomDir);
        if (dir.exists()) {
            File file = new File(nomDir + "\\" + obj.getId() + ".txt");
            if (file.exists()) {
                file.delete();
                obj.update();
                this.create(obj);
            } else {
                System.out.println("File does not exist!");
            }
        }
        return obj;
	}

	@Override
	public Personnel find(int id) 
			throws IOException, ClassNotFoundException {
        String nomDir = "PersonnelDAO";
        File dir = new File(nomDir);
        File search = new File(nomDir + "\\" + id + ".txt");
        Object deserialized = null;
        if (dir.exists()) {
            if (search.exists()) {
                byte[] fileContent = Files.readAllBytes(search.toPath());
                deserialized = deserialize(fileContent);
            }
            Personnel pers = (Personnel) deserialized;
            pers.print();
            return pers;
        }
        return null;
    }
	
	  public void serialize(final String path) {
	      ObjectOutputStream writer = null;
	      try {
	          FileOutputStream file = new FileOutputStream(path);
	          writer = new ObjectOutputStream(file);
	          writer.writeObject(this);
	          writer.flush();
	          writer.close();
	      } catch (IOException e) {
	          System.err.println(
	          "serialization to \""
	          + path + " failed\"");
	      }
	      try {
	          if (writer != null) {
	              writer.flush();
	              writer.close();
	          }
	      } catch (IOException e2) {
	          e2.printStackTrace();
	      }
	  }
	  
	  public static PersonnelDAO deserialize(final String path) {
	      ObjectInputStream reader = null;
	      PersonnelDAO personnelDAO = null;
	      try {
	          FileInputStream file = new FileInputStream(path);
	          reader = new ObjectInputStream(file);
	          personnelDAO = (PersonnelDAO) reader.readObject();
	      } catch (IOException e) {
	          System.err.println(
	          "deserialization to \""
	          + path + " failed\"");
	      } catch (ClassNotFoundException e) {
	          e.printStackTrace();
	      }
	      try {
	          if (reader != null) {
	              reader.close();
	          }
	      } catch (IOException e2) {
	          e2.printStackTrace();
	      }
	      return personnelDAO;
	  }
}
