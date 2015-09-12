package util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conf.Configuration;

public class DatabaseManager {
	private SQLiteConnection connection;
	
	///////////////////////////
	private static DatabaseManager instance = null;
	private DatabaseManager(){
		connection = new SQLiteConnection();
		if(connection.checkIfTableExist(Configuration.getOwnerTableName()) == false){
			connection.createTableOwners();
		}
		if(connection.checkIfTableExist(Configuration.getPropertyTableName()) == false){
			connection.createTableProperties();
		}
	}
	public static DatabaseManager getDatabaseManager(){
		if(instance == null)
			instance = new DatabaseManager();
		return instance;
	}
	//////////////////////////
	public void addOwner(String ownerName){
		String sql = "INSERT INTO " + Configuration.getOwnerTableName() + " (name) " +
					"VALUES ('" + ownerName + "');";
		connection.insertOrDelete(sql);
	}
	public void addProperty(String name,String ownerName){
		String sql = "INSERT INTO " + Configuration.getPropertyTableName() + 
				" (NAME,OWNERID) " +
				"VALUES ('" + name + "',"+ getOwnerId(ownerName) + ");";
		connection.insertOrDelete(sql);
	}
	public void deleteOwner(String ownerName){
		String sql = "DELETE from " + Configuration.getOwnerTableName() +
					" WHERE NAME='" + ownerName + "';";
		connection.insertOrDelete(sql);
	}
	private int getOwnerId(String ownerName){
		String sql = "SELECT ID FROM " + Configuration.getOwnerTableName() +
				" WHERE NAME='" + ownerName + "';";
		ResultSet rs = connection.select(sql);
		int ret = -1;
		try{
			while(rs.next()){
				ret = rs.getInt("ID");
			}
			rs.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ret;
	}
	public List<String> getOwnerProperties(String ownerName){
		List<String> resultList = new ArrayList<String>();
		String sql = "SELECT NAME from " + Configuration.getPropertyTableName() + 
				" WHERE OWNERID=" + getOwnerId(ownerName) + ";";
		ResultSet rs = connection.select(sql);
		try {
			while(rs.next()){
				resultList.add(rs.getString("NAME"));
			}
			rs.close();
			return resultList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public List<String> getOwnerList(){
		String sql = "SELECT * from " + Configuration.getOwnerTableName() + ";";
		ResultSet rs = connection.select(sql);
		List<String> resultList = new ArrayList<String>();
		try {
			while(rs.next()){
				resultList.add(rs.getString("name"));
			}
			rs.close();
			return resultList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public boolean ownerExist(String name){
		return getOwnerList().indexOf(name) != -1;
	}
	
	public void close(){
		connection.close();
	}
}
