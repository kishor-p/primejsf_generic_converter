package kishorp.primejsf.genconv.dbutils;

import java.io.Serializable;

public class DBFactory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8527700815152225186L;
	
	public Imdb getImdb(){
		return new ImdbJdbcImpl();
	}

}
