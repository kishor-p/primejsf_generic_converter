package kishorp.primejsf.genconv.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import kishorp.primejsf.genconv.beans.Movie;
import kishorp.primejsf.genconv.dbutils.DBFactory;
import kishorp.primejsf.genconv.dbutils.Imdb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean
@ViewScoped
public class MBeanOne implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9152136570475398702L;
	private final Logger LOG = LoggerFactory.getLogger(MBeanOne.class);
	
	private List<Movie> top250MovieList;
	private Imdb imdb = new DBFactory().getImdb();
	private Movie selectedTop250Movie;
	
	private int searchRating;
	private List<Movie> filteredMoviesList;
	

	
	@PostConstruct
	public void init(){
		LOG.info("Initializing @PostContsruct");
		setTop250MovieList(new ArrayList<>(imdb.listTop250Movies()));
		
	}

	public void filterMovies(){
		filteredMoviesList = imdb.filterMovieByRating(new Float(searchRating));
	}

	public Movie getSelectedTop250Movie() {
		return selectedTop250Movie;
	}


	public void setSelectedTop250Movie(Movie selectedTop250Movie) {
		this.selectedTop250Movie = selectedTop250Movie;
	}
	
	public void listen(ActionEvent event){
		System.out.println(event.getComponent().getAttributes().keySet());
		
	}


	public int getSearchRating() {
		return searchRating;
	}


	public void setSearchRating(int searchRating) {
		this.searchRating = searchRating;
	}


	public List<Movie> getTop250MovieList() {
		return top250MovieList;
	}


	public void setTop250MovieList(List<Movie> top250MovieList) {
		this.top250MovieList = top250MovieList;
	}


	public List<Movie> getFilteredMoviesList() {
		return filteredMoviesList;
	}


	public void setFilteredMoviesList(List<Movie> filteredMoviesList) {
		this.filteredMoviesList = filteredMoviesList;
	}

}
