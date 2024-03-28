package DAO;

import java.util.ArrayList;

public interface interfaceDAO<G> {
	public int insertX(G g);
	
	public int deleteX(G g);

	public int updateX(G g);
	
	public ArrayList<G> selectAll();
	
	public G selectG(G g);
}
