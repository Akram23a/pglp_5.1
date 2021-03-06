package PGL.pglp_5_1;
import java.io.File;
//import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
//import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
/**
 * 
 * @author Akram
 *
 */
public class NumTelDAO extends DAO<NumTel>{
	@Override
	public NumTel create(NumTel obj) throws IOException {
		 String nomDir = "NumsTel";
	        File dir = new File(nomDir);
	        FileOutputStream fileOut;
	        ObjectOutputStream objOut;

	        File file = new File(nomDir + "\\" + obj.getId() + ".txt");
	        if (!dir.exists()) {
	           dir.mkdir();
	        }
	        fileOut = new FileOutputStream(file);
	        objOut = new ObjectOutputStream(fileOut);
	        objOut.writeObject(obj);
	        objOut.close();
	        return obj;
	    }
	@Override
	public void delete(NumTel obj) {
        String nomDir = "NumsTel";
        File dir = new File(nomDir);
        if (dir.exists()) {
            File file = new File(nomDir + "\\" + obj.getId() + ".txt");
            if (file.exists()) {
                file.delete();
            }	
        }
	}
	@Override
	public NumTel update(NumTel obj) throws IOException {
        String nomDir = "NumsTel";
        File dir = new File(nomDir);
        if (dir.exists()) {
            File file = new File(nomDir + "\\" + obj.getId() + ".txt");
            if (file.exists()) {
                file.delete();
                obj.update("222");
                this.create(obj);
            }
        }
        return obj;
	}

	@Override
	public NumTel find(int id) throws IOException, ClassNotFoundException {
		  String nomDir = "NumsTel";
	        File dir = new File(nomDir);
	        File search = new File(nomDir + "\\" + id + ".txt");
	        Object deserialized = null;
	        if (dir.exists()) {
	            if (search.exists()) {
	                byte[] fileContent = Files.readAllBytes(search.toPath());
	                deserialized = deserialize(fileContent);
	            }
	            NumTel num = (NumTel) deserialized;
	            System.out.println(num.toString());
	            return num;
	        }
	        return null;	
	    }
}
