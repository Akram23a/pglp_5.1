package PGL.pglp_5_1;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import PGL.pglp_5_1.Personnel.PBuilder;
/**
 * 
 * @author Akram
 *
 */
public class PersonnelTest {

    Personnel directeur;

    String nomDir;

    File dir;
 
    DAO<Personnel> personnel;
  
/**
 * 
 * @throws IOException
 */
    @Before
    public void setUp() throws IOException {
        nomDir = "PersonnelDAO";
        dir = new File(nomDir);
        personnel = DAOFactory.getPersonnelDAO();
        
        NumTel portable =
                new NumTel("011111111",1);
        PBuilder b = new PBuilder("SMITH", "John", "directeur",
                LocalDate.of(1950, 5, 5), 1);
        b.numsTelephone(portable);
        Personnel p = b.build();
        directeur = p;
    }
/**
 * 
 */
    @Test
    public void constructeurTest() {
        String num = "011111111";
        String nom = "SMITH";
        String pnom = "John";
        String fct = "directeur";
        LocalDate date = LocalDate.of(1950, 5, 5);

        assertEquals(num, directeur.getNumsTel().get(0).getNumero());
        assertEquals(nom, directeur.getNom());
        assertEquals(pnom, directeur.getPrenom());
        assertEquals(fct, directeur.getFonction());
        assertEquals(date, directeur.getDateNaissance());

    }
    private Object deserialize(final byte[] bytes) throws ClassNotFoundException, IOException {
        ByteArrayInputStream b = new ByteArrayInputStream(bytes);
        ObjectInputStream o = new ObjectInputStream(b);
        return o.readObject();
    }
/**
 * 
 * @throws IOException
 * @throws ClassNotFoundException
 */
    @Test
    public void createTest() throws IOException, ClassNotFoundException {       
        personnel.create(directeur);
        
        File search = new File(nomDir + "\\" + directeur.getId() + ".txt");
        Object deserialized = null;
        
        byte[] fileContent = Files.readAllBytes(search.toPath());
       
        deserialized = deserialize(fileContent);
        Personnel expected = (Personnel) deserialized;
        
        assertTrue(dir.exists());
        assertTrue(search.exists());
//        assertEquals(expected, directeur);
        
        personnel.delete(directeur);
        dir.delete();
    }

    @Test
    public void deleteTest() throws IOException, ClassNotFoundException {      
        NumTel portable =
                new NumTel("0651724519", 2);
        PBuilder b = new PBuilder("SMITH", "Jeanne", "secrétaire",
                LocalDate.of(1964, 5, 25), 2);
        b.numsTelephone(portable);
        Personnel secretaire2 = b.build();
        
        File search = new File(nomDir + "\\" + directeur.getId() + ".txt");
        File expected = new File(nomDir + "\\" + secretaire2.getId() + ".txt");  

        personnel.create(directeur);
        personnel.create(secretaire2);
        personnel.delete(directeur);
        
        assertTrue(!search.exists());
        assertTrue(expected.exists());
        personnel.delete(secretaire2);
    }

    @Test
    public void updateTest() throws IOException, ClassNotFoundException {      
        File search = new File(nomDir + "\\" + directeur.getId() + ".txt");

        personnel.create(directeur);
        personnel.update(directeur);
        Object deserialized = null;
        
        byte[] fileContent = Files.readAllBytes(search.toPath());
       
        deserialized = deserialize(fileContent);
        Personnel expected = (Personnel) deserialized;
        
        assertTrue(search.exists());
//        assertEquals(expected, directeur);
        personnel.delete(directeur);
    }  
/**
 * 
 * @throws IOException
 * @throws ClassNotFoundException
 */
    @Test
    public void findTest() throws IOException, ClassNotFoundException {      
        File search = new File(nomDir + "\\" + directeur.getId() + ".txt");
        Personnel expected;
        personnel.create(directeur);
        
        expected = personnel.find(1);
        
        assertTrue(search.exists());
//        assertEquals(expected, directeur);
        personnel.delete(directeur);
    }
    
}

