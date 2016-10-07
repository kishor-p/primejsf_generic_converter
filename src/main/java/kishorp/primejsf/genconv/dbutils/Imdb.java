package kishorp.primejsf.genconv.dbutils;

import java.io.Serializable;
import java.util.List;

import kishorp.primejsf.genconv.beans.Movie;

public interface Imdb extends Serializable{
	
	List<Movie> listTop250Movies();

}
