package bbm.humanrmsystem.core.utilities.abstracts;

import java.util.List;

public interface EmailCheckService {
	
	public List<String> emailCheckDataBase();
	public boolean emailIsItUsed(String email);

}
