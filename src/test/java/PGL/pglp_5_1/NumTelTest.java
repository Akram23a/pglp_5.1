package PGL.pglp_5_1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
 
public class NumTelTest {


    NumTel tel;

    File dir;

    DAO<NumTel> numTel;

    String nomDir;
   
    @Before
    public void setUp() throws IOException {
        nomDir = "NumsTel";
        dir = new File(nomDir);
        
        tel = new NumTel("0222222222", 2);
        numTel = DAOFactory.getNumeroTelephoneDAO();
    }



    @Test
    public void getNumeroTest() {
        String expected = "0222222222";
        assertEquals(expected, tel.getNumero());
    }
//
    private Object deserialize(final byte[] bytes) throws ClassNotFoundException, IOException {
        ByteArrayInputStream b = new ByteArrayInputStream(bytes);
        ObjectInputStream o = new ObjectInputStream(b);
        return o.readObject();
    }

//    private byte[] serialize(final Object obj) throws IOException {
//        ByteArrayOutputStream b = new ByteArrayOutputStream();
//        ObjectOutputStream o = new ObjectOutputStream(b);
//        o.writeObject(obj);
//        return b.toByteArray();
//    }

    @Test
    public void createTest() throws IOException, ClassNotFoundException {       
        numTel.create(tel);
        
        File search = new File(nomDir + "\\" + tel.getId() + ".txt");
        Object deserialized = null;
        
        byte[] fileContent = Files.readAllBytes(search.toPath());
       
        deserialized = deserialize(fileContent);
        NumTel expected = (NumTel) deserialized;
        
        assertTrue(dir.exists());
        assertTrue(search.exists());
        assertEquals(expected, tel);
        
        numTel.delete(tel);
        dir.delete();
    }

    @Test
    public void deleteTest() throws IOException, ClassNotFoundException {      
    	NumTel tel2 = new NumTel("0333333333", 3);
        File search = new File(nomDir + "\\" + tel.getId() + ".txt");
        File expected = new File(nomDir + "\\" + tel2.getId() + ".txt");  

        numTel.create(tel);
        numTel.create(tel2);
        numTel.delete(tel);
        
        assertTrue(!search.exists());
        assertTrue(expected.exists());
        numTel.delete(tel2);
    }

    @Test
    public void updateTest() throws IOException, ClassNotFoundException {      
        File search = new File(nomDir + "\\" + tel.getId() + ".txt");
        NumTel tel2 = new NumTel("0222222222", 2);

        numTel.create(tel);
        numTel.update(tel);
        Object deserialized = null;
        
        byte[] fileContent = Files.readAllBytes(search.toPath());
       
        deserialized = deserialize(fileContent);
        NumTel expected = (NumTel) deserialized;
        
        assertTrue(search.exists());
        assertEquals(expected, tel2);
        numTel.delete(tel);
    }  

    @Test
    public void findTest() throws IOException, ClassNotFoundException {      
        File search = new File(nomDir + "\\" + tel.getId() + ".txt");
        NumTel expected;
        numTel.create(tel);
        
        expected = numTel.find(2);
        
        assertTrue(search.exists());
        assertEquals(expected, tel);
        numTel.delete(tel);
    }
}