package PGL.pglp_5_1;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * 
 * @author Akram
 *
 */
public class GroupePersonnel implements Component,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Array of workers
	 */
    private final ArrayList<Component> childComp = new ArrayList<Component>();
    /**
     * the id
     */
    private int id;
    /**
     * 
     * @param comp componenet to add
     */
    public void add(Component comp) {
    	childComp.add(comp);
    }
    /**
     * 
     * @param C component to remove
     */
    public void remove(final Component C) {
    	childComp.remove(C);
    }
    /**
     * Print them
     */
    public void print() {
        for (Component cm : childComp) {
            cm.print(); 
        }
    }
    /**
     * 
     * @return
     */
    public ArrayList<Component> getGroup(){
    	return childComp;
    }
    /**
     * 
     * @return
     */
    public Iterator<Component> iterator() {
		
		return childComp.iterator();
	}
    /**
     * 
     * @return id
     */
	public int getId() {
		return id;
	}
	/**
	 * 
	 * @param id new id
	 */
	public void setId(int id) {
		this.id = id;
	}
}
