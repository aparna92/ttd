package command;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ttd;
import connectionprovider.ConnectionProvider;

public class CreateTTD {

	public String execute(ttd ep) {
		  
		try {
			Connection connection = ConnectionProvider.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("INSERT INTO ttd(title, des) VALUES(?,?) Returning id");
			stmt.setString(1, ep.getTitle());
			stmt.setString(2, ep.getDes());
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				return rs.getString("id");
				
			}

		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "-1";
	}
	
	public static void main(String args[])
	{
		CreateTTD demo=new CreateTTD();
		
		ttd a = new ttd();
		a.setTitle("Saas project");
		a.setDes("finish by 20th april");
		
		System.out.println(demo.execute(a));
	}
	

}
