package PGL.pglp_5_1;
/**
 * 
 * @author Akram
 *
 */
public class DAOFactory {
	/**
	 * Constructer
	 */
    private DAOFactory() {
      }
    /**
     * 
     * @return DaoNumTel
     */
    public static DAO<NumTel> getNumeroTelephoneDAO() {
        return new NumTelDAO();
    }
    /**
     * 
     * @return DaoPersonnel
     */
    public static DAO<Personnel> getPersonnelDAO() {
        return new PersonnelDAO();
    }
    /**
     * 
     * @return DAOGp
     */
    public static DAO<GroupePersonnel> getGroupePersonnelsDAO() {
        return new GroupePersonnelDAO();
    }
}
