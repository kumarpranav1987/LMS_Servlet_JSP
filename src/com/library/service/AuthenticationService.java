package com.library.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.livetechstudy.library.dao.ConnectFactory;

public class AuthenticationService {
	public boolean authenticate(String username, String password) {
		boolean result = false;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			String fetchedPassword = null;
			conn = ConnectFactory.getConnection();
			pst = conn.prepareStatement("SELECT password from users where name=?;");
			pst.setString(1, username);
			rs = pst.executeQuery();
			while (rs.next()) {
				fetchedPassword = rs.getString("password");
			}
			if (password.equals(fetchedPassword)) {
				result = true;
			} else {
				result = false;
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return result;
	}
}