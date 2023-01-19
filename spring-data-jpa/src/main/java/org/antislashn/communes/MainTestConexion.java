package org.antislashn.communes;

import java.sql.Connection;
import java.sql.DriverManager;

public class MainTestConexion {

	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/communes;");
			System.out.println("Connected to the database successfully");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
