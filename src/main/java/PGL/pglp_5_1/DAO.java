package PGL.pglp_5_1;
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
	 */
    public abstract T create(T obj);
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
