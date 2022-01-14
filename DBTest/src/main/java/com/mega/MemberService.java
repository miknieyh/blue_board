package com.mega;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberService {

	private String dbID = "LASTMEGA";
	private String dbPassWd = "1234";
	private String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
	private String driver = "oracle.jdbc.driver.OracleDriver";

	public int setBlackMember(int[] members) {

		int result = -1;
		String temp = "";
		for (int i = 0; i < members.length; i++) {
			if (i == members.length - 1) {
				temp += members[i];
			} else {
				temp += members[i] + ",";
			}
		}
		String sql = "UPDATE MEMO_MEMBER SET stat=-1 WHERE IDX IN(" + temp + ")";
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, dbID, dbPassWd);
			Statement st = con.createStatement();

			result = st.executeUpdate(sql);
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public int getTotalCount() {
		int totalCount = 0;
		String sql = "SELECT COUNT(*) FROM MEMO_MEMBER";
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, dbID, dbPassWd);
			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				totalCount = rs.getInt(1);
			}

			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return totalCount;

	}

	public ArrayList<MemberData> getList(int page) {
		ArrayList<MemberData> b = new ArrayList<MemberData>();
		int sContent = page * 10 + 1;
		int eContent = sContent + 9;

		String sql = "SELECT t.* FROM( SELECT ROWNUM num, t2.* FROM ("
				+ "        SELECT * FROM MEMO_MEMBER ORDER BY idx DESC" + "        ) t2) t "
				+ "    WHERE num BETWEEN " + sContent + " AND " + eContent;

		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, dbID, dbPassWd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {

				b.add(new MemberData(rs.getInt("idx"), rs.getString("userid"), rs.getString("name"),
						rs.getString("email"), rs.getString("address"), rs.getTimestamp("wdate"),rs.getInt("stat")));
			}

			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return b;
	}
}
