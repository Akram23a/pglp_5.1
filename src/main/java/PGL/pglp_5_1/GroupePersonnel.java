package PGL.pglp_5_1;
/**
 * 
 */
import java.util.ArrayList;
import java.util.Iterator;
/**
 * 
 * @author Akram
 *
 */
public class GroupePersonnel implements Component{
	/**
	 * 
	 */
    private final ArrayList<Component> childComp = new ArrayList<Component>();
    /**
     * 
     * @param comp
     */
    public void add(Component comp) {
    	childComp.add(comp);
    }
    public void remove(final Component C) {
    	childComp.remove(C);
    }
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
}