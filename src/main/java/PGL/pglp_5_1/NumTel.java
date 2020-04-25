package PGL.pglp_5_1;
import java.io.Serializable;
/**
 * 
 * @author Akram
 *
 */
public class NumTel implements Serializable{
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        NumTel other = (NumTel) obj;
  
        if (numero == null) {
            if (other.numero != null) {
                return false;
            }
        } else if (!numero.equals(other.numero)) {
            return false;
        }
        return true;
    }
    /**
     * Méthode de hachage.
     */
    @Override
    public int hashCode() {
        final int prime = 20;
        int result = 1;
        result = prime * result + id;
        result = prime * result
                + ((numero == null) ? 0 : numero.hashCode());
        return result;
    }
    /**
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String numero;
	private int id;
	
	/**
	 * 
	 * @param num numero
	 */
	NumTel(String num, int newId){
		setNumero(num);
        this.setId(newId);
	}
	/**
	 * 
	 * @return numero
	 */
	public String getNumero() {
		return numero;
	}
	/**
	 * 
	 * @param numero
	 */
	public void setNumero(String numero) {
		this.numero = numero;
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
	 * @param id identifier
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * update func
	 */
    public void update(final String nm) {
		// TODO Auto-generated method stub
    }
}
