package PGL.pglp_5_1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class GroupePersonnelDAO extends DAO<GroupePersonnel> {

	@Override
	public GroupePersonnel create(GroupePersonnel obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(GroupePersonnel obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GroupePersonnel update(GroupePersonnel obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroupePersonnel find(int id)  
			throws IOException, ClassNotFoundException {
        String nomDir = "Groups";
        File dir = new File(nomDir);
        File search = new File(nomDir + "\\" + id + ".txt");
        Object deserialized = null;
        if (dir.exists()) {
            if (search.exists()) {
                byte[] fileContent = Files.readAllBytes(search.toPath());
                deserialized = deserialize(fileContent);
            }
            GroupePersonnel groupP = (GroupePersonnel) deserialized;
            groupP.skull();

            return groupP;
        }
        return null;
	}

}
