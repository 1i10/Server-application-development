package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarsSellingDB {
	private static String url = "jdbc:sqlserver://DESKTOP-9838BTS\\SQLEXPRESS01;" 
			+ "databaseName=CarsSelling";
    private static String login = "admin1";
    private static String password = "123456";
    private static Connection conn;
    
    protected static void connectDB() throws SQLException {
        if (conn == null || conn.isClosed()) {
            try {
            	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            conn = DriverManager.getConnection(url, login, password);
        }
    }
    
    protected static void disconnectDB() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
    
    public static List<CarSelling> listSellingPositions() throws SQLException {
        List<CarSelling> listPositions = new ArrayList<>();
         
        String sql = "select *from CarsSelling";
         
        connectDB();
         
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int code = resultSet.getInt("code");
            String manufacturer = resultSet.getString("manufacturer");
        	String model = resultSet.getString("model");
        	String color = resultSet.getString("color");
        	String transmission = resultSet.getString("transmission");
        	String body_type = resultSet.getString("body_type");
        	float price = resultSet.getFloat("price");
             
            CarSelling position = new CarSelling(code, manufacturer, model, color, transmission,
            		body_type, price);
            listPositions.add(position);
        }
         
        resultSet.close();
        statement.close();
         
        disconnectDB();
         
        return listPositions;
    }
    
    public static CarSelling selectPosition(int code) throws SQLException {
        String sql = "select *from CarsSelling where code = ?";
         
        connectDB();
         
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, code);
         
        ResultSet resultSet = statement.executeQuery();
        CarSelling position = null;
        
        if (resultSet.next()) {
        	String manufacturer = resultSet.getString("manufacturer");
        	String model = resultSet.getString("model");
        	String color = resultSet.getString("color");
        	String transmission = resultSet.getString("transmission");
        	String body_type = resultSet.getString("body_type");
        	float price = resultSet.getFloat("price");
             
            position = new CarSelling(code, manufacturer, model, color, transmission,
            		body_type, price);
        }
         
        resultSet.close();
        statement.close();
         
        return position;
    }
    
    public static boolean insertPosition(CarSelling position) throws SQLException {
        String sql = "insert into CarsSelling(manufacturer, model, color, transmission, "
        		+ "body_type, price) values(?, ?, ?, ?, ?, ?)";
        connectDB();
         
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, position.getManufacturer());
        statement.setString(2, position.getModel());
        statement.setString(3, position.getColor());
        statement.setString(4, position.getTransmission());
        statement.setString(5, position.getBody_type());
        statement.setFloat(6, position.getPrice());
        
        boolean positionInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnectDB();
        return positionInserted;
    }
    
    public static boolean deletePosition(CarSelling position) throws SQLException {
        String sql = "delete from CarsSelling where code = ?";
         
        connectDB();
         
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, position.getCode());
         
        boolean positionDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnectDB();
        return positionDeleted;     
    }
    
    public static boolean updatePosition(CarSelling position) throws SQLException {
    	String sql = "update CarsSelling set manufacturer = ?, model = ?, color = ?, " + 
        		"transmission = ?, body_type = ?, price = ? where code = ?";
        connectDB();
         
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, position.getManufacturer());
        statement.setString(2, position.getModel());
        statement.setString(3, position.getColor());
        statement.setString(4, position.getTransmission());
        statement.setString(5, position.getBody_type());
        statement.setFloat(6, position.getPrice());
        statement.setInt(7, position.getCode());
        
        boolean positionUpdated = statement.executeUpdate() > 0;
        
        statement.close();
        disconnectDB();
 
        return positionUpdated;   
    }
}