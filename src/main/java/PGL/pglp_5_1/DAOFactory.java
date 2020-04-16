package PGL.pglp_5_1;

public class DAOFactory {
    private DAOFactory() {
      }
    public static DAO<NumTel> getNumeroTelephoneDAO() {
        return new NumTelDAO();
    }
    public static DAO<Personnel> getPersonnelDAO() {
        return new PersonnelDAO();
    }
    public static DAO<GroupePersonnel> getGroupePersonnelsDAO() {
        return new GroupePersonnelDAO();
    }
}
