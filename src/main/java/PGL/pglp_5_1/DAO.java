package PGL.pglp_5_1;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 
 * @author Akram
 *
 * @param <T>
 */
public abstract class DAO<T> {
	/**
	 * 
	 * @param obj
	 * @return
	 * @throws FileNotFoundException 
	 * @throws IOException 
	 */
    public abstract T create(T obj) throws FileNotFoundException, IOException;
    /**
     * 
     * @param obj
     */
    public abstract void delete(T obj);
    /**
     * 
     * @param obj
     * @return
     * @throws IOException 
     */
    public abstract T update(T obj) throws IOException;
    /**
     * 
     * @param id
     * @return
     */
    public abstract T find(int id);
    /**
     * 
     * @param bytes
     * @return
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public Object deserialize(final byte[] bytes) throws ClassNotFoundException,
    IOException {
        ByteArrayInputStream b = new ByteArrayInputStream(bytes);
        ObjectInputStream o = new ObjectInputStream(b);
        return o.readObject();
    }
}
