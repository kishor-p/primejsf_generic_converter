package kishorp.primejsf.genconv.dbutils;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBconnect implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7165329248807048131L;
	Logger LOG = LoggerFactory.getLogger(DBconnect.class);
	private Connection newConnection;
	
	public DBconnect(){}
	
	public Connection getConnection(){
		newConnection = null;
		 try {
			String conUrl = "jdbc:sqlite::resource:"+FacesContext.getCurrentInstance().getExternalContext().getResource("/db/imdb.sqlite");
			LOG.info("Conn URL:"+conUrl);
			Class.forName("org.sqlite.JDBC");
			newConnection = DriverManager.getConnection(conUrl);
		} catch (ClassNotFoundException | SQLException | MalformedURLException e) {
			LOG.error("getConnection()-Error while creating the connection:",e);
		}
		 
		return newConnection;
	}


}
