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
     * nom
     */
    private String nom;
    /**
     * 
     * @param nom
     * @param id2
     */
    public GroupePersonnel(final String newNom, final int newId) {
        this.nom = newNom;
        this.setId(newId);
    }
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
	 * @param id new nom
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
     * 
     * @return nom
     */
	public String getNom() {
		return nom;
	}
	/**
	 * 
	 * @param nomY us the new name
	 */
	public void setNom(String nomY) {
		this.nom = nomY;
	}
	/**
	 * Names
	 */
	public void skull() {
	        Iterator<Component> ite = childComp.iterator();
	        System.out.println("|" + this.getNom() + "|");
	        while (ite.hasNext()) {
	            Component c = ite.next();
	            c.print();		
	        }
	}
	/**
	 * Update to do
	 */
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
