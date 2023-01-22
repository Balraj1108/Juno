package it.giococarteuno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import it.giococarteuno.connection.MyConnection;
import it.giococarteuno.model.Utente;

public class UtenteDAO {

	
	public Utente findByNickname(String input) {

		if (input == null) {
			return null;
		}

		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Utente result = null;
		

		try {
			
			
			c = MyConnection.getConnection();
			ps = c.prepareStatement("select * from utente u where u.nickname=?;");
			ps.setString(1, input);

			rs = ps.executeQuery();
			System.out.println("try");

			if (rs.next()) {
				result = new Utente();
				result.setId(rs.getLong("id"));
				result.setNickname(rs.getString("nickname"));
				result.setPartiteGiocate(rs.getInt("partitegiocate"));
				result.setPartiteVinte(rs.getInt("partitevinte"));
				result.setPartitePerse(rs.getInt("partiteperse"));
				result.setLivello(rs.getInt("livello"));
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				rs.close();
				ps.close();
				c.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
		
	}
	
	public int insert(String input) {

		Connection c = null;
		PreparedStatement ps = null;
		int result = -1;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("insert into utente (nickname, partitegiocate, partitevinte, partiteperse, livello) \r\n"
					+ "values (?, 0, 0, 0,0);");
			ps.setString(1, input);
			

			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

			// TODO: handle exception
		} finally {
			try {
				ps.close();
				c.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}

		}
		System.out.println(result + "insert");
		return result;

	}
}
