package PGL.pglp_5_1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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
        } else {
            System.out.println("File does not exist!");
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
//                obj.update("222");
                this.create(obj);
            } else {
                System.out.println("Le fichier à mettre à jour n'existe pas!");
            }
        } else {
            System.out.println("Le dossier contenant le fichier n'existe pas!");
        }
        return obj;
	}

	@Override
	public NumTel find(int id) {
		  String nomDir = "NumsTel";
	        File dir = new File(nomDir);
	        File search = new File(nomDir + "\\" + id + ".txt");
	        Object deserialized = null;
	        if (dir.exists()) {
	            if (search.exists()) {
	                byte[] fileContent = Files.readAllBytes(search.toPath());
	                deserialized = deserialize(fileContent);
	            } else {
	                System.out.println("Le fichier n'existe pas!");
	            }
	            NumeroTelephone num = (NumeroTelephone) deserialized;
	            System.out.println(num.toString());
	            return num;
	        } else {
	            System.out.println("Le dossier n'existe pas!");
	        }
	        return null;	
	    }
	

}
