package bbm.humanrmsystem.core.utilities.abstracts;

import java.util.List;

public interface IdentityCheckService {
	
	public List<String> identityCheckDataBase();
	public boolean identityIsItUsed(String identity);

}
