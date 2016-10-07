package kishorp.primejsf.genconv.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kishorp.primejsf.genconv.beans.Movie;
import kishorp.primejsf.genconv.dbutils.DBFactory;
import kishorp.primejsf.genconv.dbutils.Imdb;

@ManagedBean
@ViewScoped
public class MBeanOne implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9152136570475398702L;
	private final Logger LOG = LoggerFactory.getLogger(MBeanOne.class);
	
	private List<Movie> first100List;
	private Imdb imdb = new DBFactory().getImdb();
	
	
	@PostConstruct
	public void init(){
		LOG.info("Initializing @PostContsruct");
		first100List = new ArrayList<>(imdb.listTop250Movies());
		
	}
	

	public List<Movie> getFirst100List() {
		return first100List;
	}

	public void setFirst100List(List<Movie> first100List) {
		this.first100List = first100List;
	}
	

}
