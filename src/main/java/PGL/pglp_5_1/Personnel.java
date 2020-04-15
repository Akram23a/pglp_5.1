package PGL.pglp_5_1;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 * 
 * @author Akram
 *
 */
public class Personnel {

	public String nom;
	public String prenom;
	public String fonction;
	public LocalDate dateNaissance;
	public ArrayList<NumTel> numsTel;
	/**
	 * 
	 * @author Akram
	 *
	 */
	public static class PBuilder {
		
		public String nom;
		public String prenom;
		public String fonction;
		public LocalDate dateNaissance;
		public ArrayList<NumTel> numsTelephone;
		/**
		 * 
		 * @param nom
		 * @param prenom
		 * @param fonction
		 * @param dateNaissance
		 */
		public PBuilder(String nom, String prenom, String fonction, LocalDate dateNaissance) {
			this.nom = nom;
			this.prenom = prenom;
			this.fonction = fonction;
			this.dateNaissance= dateNaissance;
		}
		/**
		 * 
		 * @param dN
		 * @return
		 */
		public  PBuilder Naissance(LocalDate dN) {
			
			this.dateNaissance = dN;
			return this;
			
		}
		/**
		 * 
		 * @param num
		 * @return
		 */
		public PBuilder numsTelephone(NumTel num) {
			this.numsTelephone.add(num);
			return this;
		}
		/**
		 * 
		 * @return
		 */
		public Personnel build() {
			return new Personnel(this);
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
		numsTel = builder.numsTelephone;
	}
	/**
	 * 
	 */
	public void print() {
		System.out.println("Nom: "+ nom + "\nPrenom : " + prenom + " \nFonction: " 
		+ fonction + "\ndate de naissance: "+ dateNaissance + "\n");
	}
}
