package command;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.ttd;
import connectionprovider.ConnectionProvider;

public class DeleteTTD {
	
	
	public boolean execute(int id) {
		
		try {
			Connection connection = ConnectionProvider.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("DELETE FROM ttd WHERE ID = ?");
			stmt.setInt(1, id);
			
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				return true;
				
			}

		} catch (URISyntaxException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return false;
		
		
		
			
		

		
	}

	public static void main(String[] args) {
		DeleteTTD command = new DeleteTTD();
		boolean result =  command.execute(1);
		System.out.println(result);
	}
}
