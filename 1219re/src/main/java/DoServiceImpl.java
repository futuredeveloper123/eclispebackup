
public class DoServiceImpl {

	private DoDAO dao;
	
	private DoServiceImpl() {
		
		dao=DoDAO.getInstance();
	}
	
	private static DoService doService;
	
	public static DoService getInstance() {
	
		if (doService==null) {
		
			doService = new DoServiceImpl();
		}
		
		return doService;
	}
	
	
}
