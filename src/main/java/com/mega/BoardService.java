package com.mega;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.mega.BoardData;

public class BoardService {
	private String dbID = "LASTMEGA";
	private String dbPassWd = "1234";
	private String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
	private String driver = "oracle.jdbc.driver.OracleDriver";

	public int getTotalCount() {
		int totalCount = 0;
		String sql = "SELECT COUNT(*) FROM MEMO_BOARD";
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
	//write
	public void insertBoard(String title, String content, int idx,String files) {
		String sql = "INSERT INTO MEMO_BOARD(title,content,m_idx,wdate,files)" + " VALUES (?,?,?,SYSTIMESTAMP,?)";

		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "LASTMEGA", "1234");
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, title);
			psmt.setString(2, content);
			psmt.setInt(3, idx);
			psmt.setString(4,files);

			psmt.executeUpdate();

			psmt.close();
			con.close();
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// listCtrl
	public ArrayList<BoardData> getBoardList(int myIdx, int page) {
		ArrayList<BoardData> bArr = new ArrayList<BoardData>();
		int sContent = page * 10 + 1;
		int eContent = sContent + 9;

		String sql = "SELECT name,t.* FROM ( SELECT ROWNUM num, t2.* FROM ( "
				+ "SELECT * FROM MEMO_BOARD ORDER BY idx DESC)t2)t "
				+ "INNER JOIN MEMO_MEMBER ON MEMO_MEMBER.IDX = t.M_IDX WHERE num BETWEEN " + sContent + " AND "
				+ eContent;
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, dbID, dbPassWd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {

				String writer = rs.getString("name");
				Boolean mine = false;
				if (myIdx == rs.getInt("m_idx")) {
					mine = true;
				}

				bArr.add(new BoardData(rs.getInt("idx"), rs.getInt("m_idx"), rs.getString("title"), writer,
						rs.getString("content"), rs.getTimestamp("wdate"), mine));
			}

			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bArr;
	}

	// delete
	public void deleteBoard(int idx) {
		String sql = "DELETE FROM MEMO_BOARD WHERE idx=" + idx;
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, "LASTMEGA", "1234");
			Statement st = con.createStatement();
			int result = st.executeUpdate(sql);
			System.out.println(result);
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// editCtrl
	public BoardData getBoardData(int idx) {
		String sql = "SELECT title,content  FROM MEMO_BOARD WHERE idx=" + idx;
		BoardData b = null;
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, dbID, dbPassWd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			String title = "";
			String content = "";
			while (rs.next()) {
				title = rs.getString("title");
				content = rs.getString("content");
			}
			b = new BoardData(idx, title, content);

			rs.close();
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return b;
	}

	// detailCtrl
	public BoardData getBoardData(int idx, int my_idx) {
		String sql = "SELECT TITLE,CONTENT,FILES FROM MEMO_BOARD WHERE IDX = " + idx;
		BoardData b = null;
		ArrayList<BoardData> cArr = new ArrayList<>(); // 댓글목록
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, dbID, dbPassWd);

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			ResultSet rs2 = null;
			Statement st2 = con.createStatement();
			String title = "";
			String content = "";
			String file1 = "";
			String file2 = "";
			int c_idx = 0;
			int m_idx = 0;
			String comments = "";
			String writer = "";
			while (rs.next()) {

				title = rs.getString("title");
				content = rs.getString("content");
				String files = rs.getString("files");
				if(files!=null) {
					String file[] = files.split(",");
					file1 = file[0];
					file2 = file[1];
				}
				
				boolean mine = false;
				sql = "SELECT T2.NAME,T1.* FROM MEMO_COMMENT T1 LEFT OUTER JOIN MEMO_MEMBER T2 ON T1.M_IDX = T2.IDX WHERE T1.B_IDX = "+idx+" ORDER BY T1.IDX DESC";
				rs2 = st2.executeQuery(sql);
				while (rs2.next()) {
					c_idx = rs2.getInt("idx");
					m_idx = rs2.getInt("m_idx");
					writer = rs2.getString("name");
					comments = rs2.getString("comments");

					if (my_idx == m_idx) {
						mine = true;
					}
					cArr.add(new BoardData(c_idx, idx, m_idx, writer, comments, mine));
					mine = false;
				}
			}
			b = new BoardData(idx, title, content, cArr,file1,file2);

			rs.close();
			rs2.close();
			st.close();
			st2.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return b;
	}
}
