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
		// TODO Auto-generated method stub
		
	}

	@Override
	public NumTel update(NumTel obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NumTel find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
