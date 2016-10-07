package kishorp.primejsf.genconv.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kishorp.primejsf.genconv.beans.Movie;

public class MoviePool implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 273692954662372115L;
	private final Logger  LOG = LoggerFactory.getLogger(MoviePool.class); 
	private List<Movie> moviesList;
	
	public MoviePool(){}
	
	public void fillUpPool(){
		if(moviesList==null || moviesList.isEmpty()){
			moviesList  = new ArrayList<Movie>();
			
			try{
				File movFile = new File((getClass().getResource("imdb_top_250.txt")).toURI());
				BufferedReader br = new BufferedReader(new FileReader(movFile));
				String st = null;
				while((st=br.readLine())!=null){
					Movie mov  = new Movie();
					mov.setName(st.substring(0, st.indexOf("(")-1));
					mov.setYear(st.substring(st.indexOf("(")+1, st.indexOf(")")));
					mov.setRating(Float.parseFloat(st.substring(st.indexOf(")")+1,st.length())));
					mov.setUniqueId(UUID.randomUUID().toString());
					moviesList.add(mov);
				}
			}catch(IOException | URISyntaxException e){
				LOG.error("fillUpPool()-Error while filling up movies pool: ",e);
			}
		}
	}

	public List<Movie> getMoviesList() {
		return moviesList;
	}

	public void setMoviesList(List<Movie> moviesList) {
		this.moviesList = moviesList;
	}
	
	public void test() throws Exception{
		Connection c = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:imdb.sqlite");
	      
	      File movFile = new File((getClass().getResource("imdb_top_250.txt")).toURI());
			BufferedReader br = new BufferedReader(new FileReader(movFile));
			String st = null;
			String query ="INSERT INTO top250movies (name,year,rating,num) VALUES";
			int ix =1;
			
		/*	PreparedStatement ps = c.prepareStatement("INSERT INTO top250movies (name,year,rating,num) VALUES(?,?,?,?)");
			while((st=br.readLine())!=null){
				
				//query+="('"+st.substring(0, st.indexOf("(")-1)+"','"+st.substring(st.indexOf("(")+1, st.indexOf(")"))+"',"+Float.parseFloat(st.substring(st.indexOf(")")+1,st.length()))+","+i+"),";
				ps.setString(1, st.substring(0, st.indexOf("(")-1));
				ps.setString(2, st.substring(st.indexOf("(")+1, st.indexOf(")")));
				ps.setFloat(3, Float.parseFloat(st.substring(st.indexOf(")")+1,st.length())));
				ps.setInt(4, ix);
				ps.addBatch();
				ix++;
				Movie mov  = new Movie();
				mov.setName(st.substring(0, st.indexOf("(")-1));
				mov.setYear(st.substring(st.indexOf("(")+1, st.indexOf(")")));
				mov.setRating(Float.parseFloat(st.substring(st.indexOf(")")+1,st.length())));
				mov.setUniqueId(UUID.randomUUID().toString());
				moviesList.add(mov);
			}
	      //query = query.substring(0, query.length()-1);
			//System.out.println(query);
	    ps.executeBatch();*/
			
			ResultSet rs = c.createStatement().executeQuery("select * from top250movies");
			System.out.println(rs);
			
	      
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Opened database successfully");
	 }
	
	
	public static void main(String[] args) throws Exception{
		MoviePool mp = new MoviePool();
		//mp.fillUpPool();
		//System.out.println(mp.getMoviesList());
		mp.test();
		
		Long l = Long.parseLong("1234567890");
		System.out.println(l);
	}

}
