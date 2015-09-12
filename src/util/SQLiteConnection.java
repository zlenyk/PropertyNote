package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conf.Configuration;

public class SQLiteConnection {
	private Connection connection = null;
	
	public SQLiteConnection(){
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:" + Configuration.getDatabasePath());
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Database connection failed");
		}
	}
	public boolean checkIfTableExist(String tableName){
		Statement stmt;
		try {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='" + tableName + "';");
			if(rs.next() == false)
				return false;
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void createTableOwners(){
		Statement stmt;
		try {
			stmt = connection.createStatement();
			stmt.executeUpdate(
				"CREATE TABLE " + Configuration.getOwnerTableName() + " " +
				"(ID 	INTEGER PRIMARY KEY 	AUTOINCREMENT," +
				"NAME 	TEXT 					NOT NULL)"
				);
			stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void createTableProperties(){
		Statement stmt;
		try {
			stmt = connection.createStatement();
			stmt.executeUpdate(
				"CREATE TABLE " + Configuration.getPropertyTableName() + " " +
				"(ID 	INTEGER PRIMARY KEY 	AUTOINCREMENT," +
				"NAME 	TEXT 					NOT NULL,"		+
				"OWNERID	INTEGER				NOT NULL)"
				);
			stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void insertOrDelete(String sql){
		Statement stmt;
		try {
			stmt = connection.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ResultSet select(String sql){
		Statement stmt;
		try {
			stmt = connection.createStatement();
			return stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void close(){
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
