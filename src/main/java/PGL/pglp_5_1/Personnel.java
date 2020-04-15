package PGL.pglp_5_1;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * 
 * @author Akram
 *
 */
public class Personnel implements Component, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String nom;
	private final String prenom;
	private final String fonction;
	private final LocalDate dateNaissance;
	private ArrayList<NumTel> numsTel;
	/**
	 * 
	 * @author Akram
	 *
	 */
	public static class PBuilder {
		
		public final String nom;
		public final String prenom;
		public final String fonction;
		public LocalDate dateNaissance;
		public final ArrayList<NumTel> numsTelephone;
        private final int id;
		/**
		 * 
		 * @param nom
		 * @param prenom
		 * @param fonction
		 * @param dateNaissance
		 */
		public PBuilder(final String nom, final String prenom, final String fonction, final LocalDate dateNaissance, final int newId) {
			this.nom = nom;
			this.prenom = prenom;
			this.fonction = fonction;
			this.dateNaissance = dateNaissance;
            this.numsTelephone = new ArrayList<NumTel>();
            this.id = newId;
		}
		/**
		 * 
		 * @param dN
		 * @return
		 */
		public  PBuilder Naissance(final LocalDate dN) {
			
			this.dateNaissance = dN;
			return this;
			
		}
		/**
		 * 
		 * @param num
		 * @return Builder
		 */
		public PBuilder numsTelephone(NumTel num) {
			this.numsTelephone.add(num);
			return this;
		}
		/**
		 * 
		 * @return built personnel
		 */
		public Personnel build() {
			return new Personnel(this);
		}
		public int getId() {
			return id;
		}
	}
	/**
	 * 
	 * @param builder
	 */
	private Personnel(PBuilder builder) {
		nom = builder.nom;
		prenom = builder.prenom;
		fonction = builder.fonction;
		dateNaissance = builder.dateNaissance;
		setNumsTel(builder.numsTelephone);
	}
	/**
	 * 
	 */
	public void print() {
		System.out.println("Nom: "+ nom + "\nPrenom : " + prenom + " \nFonction: " 
		+ fonction + "\ndate de naissance: "+ dateNaissance + "\n");
	}
	/**
	 * 
	 * @return numeros
	 */
	public ArrayList<NumTel> getNumsTel() {
		return numsTel;
	}
	/**
	 *  
	 * @param numsTel numeros
	 */
	public void setNumsTel(ArrayList<NumTel> numsTel) {
		this.numsTel = numsTel;
	}
}
