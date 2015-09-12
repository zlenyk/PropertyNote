package conf;

public class Configuration {

	private static String appName = "PropertyNote";
	public static String getAppName(){
		return appName;
	}
	
	private static String databasePath = "/home/user/Codes/workspace/PropertyNote/db/database.db";
	public static String getDatabasePath(){
		return databasePath;
	}
	
	private static String ownerTableName = "OWNERS";
	public static String getOwnerTableName() {
		return ownerTableName;
	}
	private static String propertyTableName = "PROPERTIES";
	public static String getPropertyTableName() {
		return propertyTableName;
	}
	
	
}
