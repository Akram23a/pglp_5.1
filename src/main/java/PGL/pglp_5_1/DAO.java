package PGL.pglp_5_1;

import java.io.FileNotFoundException;
import java.io.IOException;

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
     */
    public abstract T update(T obj);
    /**
     * 
     * @param id
     * @return
     */
    public abstract T find(int id);
}
