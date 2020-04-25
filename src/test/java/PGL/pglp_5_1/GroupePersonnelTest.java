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
public class GroupePersonnelTest {  
   
    GroupePersonnel g, g2, g3;
 
    File dir;
  
    DAO<NumTel> numTel;

    String nomDir;
  
    DAO<GroupePersonnel> groupePersoDAO;

    @Before
    public void setUp() throws IOException {
        nomDir = "Groups";
        dir = new File(nomDir);
        
        g = new GroupePersonnel("g1", 1);
        g2 = new GroupePersonnel("g2", 2);
        g3 = new GroupePersonnel("g3", 3);
        
        groupePersoDAO = DAOFactory.getGroupePersonnelsDAO();
    }

    @Test
    public void addTest() {

        g.add(g2);
        assertEquals(g.getGroup().get(0), g2);
    }

    @Test
    public void removeTest() {
        g.add(g2);
        g.add(g3);
        g.remove(g2);
        assertEquals(g.getGroup().get(0), g3);
    }
 
    private Object deserialize(final byte[] bytes) throws ClassNotFoundException, IOException {
        ByteArrayInputStream b = new ByteArrayInputStream(bytes);
        ObjectInputStream o = new ObjectInputStream(b);
        return o.readObject();
    }
  
    private byte[] serialize(final Object obj) throws IOException {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(b);
        o.writeObject(obj);
        return b.toByteArray();
    }

    @Test
    public void createTest() throws IOException, ClassNotFoundException {       
        groupePersoDAO.create(g);
        File search = new File(nomDir + "\\" + g.getId() + ".txt");
        Object deserialized = null;
        
        byte[] fileContent = Files.readAllBytes(search.toPath());
       
        deserialized = deserialize(fileContent);
        GroupePersonnel expected = (GroupePersonnel) deserialized;
        
        assertTrue(dir.exists());
        assertTrue(search.exists());
//        assertEquals(expected, g);
        
        groupePersoDAO.delete(g);
        dir.delete();
    }
  
    @Test
    public void deleteTest() throws IOException, ClassNotFoundException {      
        File search = new File(nomDir + "\\" + g.getId() + ".txt");
        File expected = new File(nomDir + "\\" + g2.getId() + ".txt");  

        groupePersoDAO.create(g);
        groupePersoDAO.create(g2);
        groupePersoDAO.delete(g);
        
        assertTrue(!search.exists());
        assertTrue(expected.exists());
        groupePersoDAO.delete(g2);
    }
    @Test
    public void updateTest() throws IOException, ClassNotFoundException {      
        File search = new File(nomDir + "\\" + g.getId() + ".txt");

        groupePersoDAO.create(g);
        groupePersoDAO.update(g);
        Object deserialized = null;
        
        byte[] fileContent = Files.readAllBytes(search.toPath());
       
        deserialized = deserialize(fileContent);
        GroupePersonnel expected = (GroupePersonnel) deserialized;
        
        assertTrue(search.exists());
//        assertEquals(expected, g);
        groupePersoDAO.delete(g);
    }  
    @Test
    public void findTest() throws IOException, ClassNotFoundException {      
        File search = new File(nomDir + "\\" + g.getId() + ".txt");
        GroupePersonnel expected;
        groupePersoDAO.create(g);
        
        expected = groupePersoDAO.find(1);
        
        assertTrue(search.exists());
//        assertEquals(expected, g);
        groupePersoDAO.delete(g);
    }
}

