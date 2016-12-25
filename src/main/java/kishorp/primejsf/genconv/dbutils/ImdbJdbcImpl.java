package kishorp.primejsf.genconv.dbutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kishorp.primejsf.genconv.beans.Movie;

public class ImdbJdbcImpl implements Imdb{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1913168016690477381L;
	private final Logger LOG = LoggerFactory.getLogger(ImdbJdbcImpl.class);

	@Override
	public List<Movie> listTop250Movies() {
		List<Movie> retList = null;
		try {
			DBconnect dBconnect = new DBconnect();
			Connection con = dBconnect.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM top250movies");
			
			if(rs!=null){
				retList = new ArrayList<Movie>();
				while(rs.next()){
					Movie tempMov = new Movie();
					tempMov.setName(rs.getString("name"));
					tempMov.setYear(rs.getString("year"));
					tempMov.setRating(rs.getFloat("rating"));
					tempMov.setUniqueId(UUID.randomUUID().toString().replaceAll("-", ""));
					retList.add(tempMov);
				}
			}
		} catch (SQLException e) {
			LOG.error("listTop250Movies()-Error while listing Top250Movies: ",e);
		}
		return retList;
	}

	@Override
	public List<Movie> filterMovieByRating(float rating) {
		List<Movie> retList = null;
		try {
			DBconnect dBconnect = new DBconnect();
			Connection con = dBconnect.getConnection();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM top250movies WHERE rating > ?");
			stmt.setFloat(1, rating);
			ResultSet rs = stmt.executeQuery();
			
			if(rs!=null){
				retList = new ArrayList<Movie>();
				while(rs.next()){
					Movie tempMov = new Movie();
					tempMov.setName(rs.getString("name"));
					tempMov.setYear(rs.getString("year"));
					tempMov.setRating(rs.getFloat("rating"));
					tempMov.setUniqueId(UUID.randomUUID().toString().replaceAll("-", ""));
					retList.add(tempMov);
				}
			}
		} catch (SQLException e) {
			LOG.error("listTop250Movies()-Error while listing Top250Movies: ",e);
		}
		return retList;
	}


}
