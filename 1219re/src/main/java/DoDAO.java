import java.util.Map;

public class DoDAO {

	private DoDAO() {}
	
	private static DoDAO doDAO;
	
	public static DoDAO getInstance() {
	
		if(doDAO ==null) {
		
			doDAO = new DoDAO();
		}
		return doDAO;
	}
	public int doInsert(Map<String,Object> map) {
	
		return 1;
	}
	
}

