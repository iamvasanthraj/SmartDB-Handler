package practiceJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class connect {
	Connection con = null;

	public boolean Connect(String dbname) throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbname, "root", "root");
			boolean check = true;
			return check;
		} catch (Exception e) {
			System.out.println("Database Does Not exist...Try Again");
		}
		return false;
	}

	public boolean Updatetable(marks s, String tbname) throws Exception {
		try {
			String query = "SELECT COUNT(*) FROM information_schema.tables "
					+ "WHERE table_schema = DATABASE() AND LOWER(table_name) = LOWER(?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, tbname.trim());
			ResultSet rs = ps.executeQuery();
			rs.next();

			if (rs.getInt(1) > 0) {
				if (s.student_name != null && !s.student_name.isEmpty()) {
					PreparedStatement st = con.prepareStatement("INSERT INTO " + tbname
							+ " (student_name, subject1, subject2, subject3, subject4, subject5) VALUES (?, ?, ?, ?, ?, ?)");
					st.setString(1, s.student_name);
					st.setInt(2, s.subject1);
					st.setInt(3, s.subject2);
					st.setInt(4, s.subject3);
					st.setInt(5, s.subject4);
					st.setInt(6, s.subject5);
					st.executeUpdate();
					System.out.println("Student " + s.student_name + " added to Database");
				}
				return true;
			} else {
				System.out.println("Table does not Exist — check the Table name...");
				return false;
			}

		} catch (Exception e) {
			System.out.println("Error while checking or updating");
			return false;
		}
	}

	public void Createtable(String table) throws Exception {
		try {
			String query = "CREATE TABLE " + table + " (" + "student_id INT AUTO_INCREMENT PRIMARY KEY, "
					+ "student_name VARCHAR(100) NOT NULL, " + "subject1 INT CHECK (subject1 BETWEEN 0 AND 100), "
					+ "subject2 INT CHECK (subject2 BETWEEN 0 AND 100), "
					+ "subject3 INT CHECK (subject3 BETWEEN 0 AND 100), "
					+ "subject4 INT CHECK (subject4 BETWEEN 0 AND 100), "
					+ "subject5 INT CHECK (subject5 BETWEEN 0 AND 100), "
					+ "total INT GENERATED ALWAYS AS (subject1 + subject2 + subject3 + subject4 + subject5) STORED, "
					+ "percentage DECIMAL(5,2) GENERATED ALWAYS AS (total / 5) STORED" + ");";

			Statement cs = con.createStatement();
			cs.executeUpdate(query);
			System.out.println(table + " Table created Sucessfully");
		} catch (Exception e) {
			System.out.println("Table Alredy Exist Try with Different name..");
		}
	}

	public void dispalyDb(String table) throws SQLException {
		Statement st = con.createStatement();
		try {
			ResultSet rs = st.executeQuery("Select * from " + table);
			System.out.println("----------------------------------------------------------------------");

			System.out.println("  ID  " + "   Name  " + "   sub 1  " + " sub 2  " + "sub 3  " + "sub 4  " + "sub 5  "
					+ "Total " + "   Avg   |");
			while (rs.next()) {
				String data = "|  " + rs.getInt(1) + "  |  " + rs.getString(2) + "  |  " + rs.getInt(3) + "  |  "
						+ rs.getInt(4) + "  |  " + rs.getInt(5) + "  |  " + rs.getInt(6) + "  |  " + rs.getInt(7)
						+ "  |  " + rs.getInt(8) + "  |  " + rs.getFloat(9) + "  |  ";
				System.out.println("----------------------------------------------------------------------");
				System.out.println(data);
			}
			System.out.println("----------------------------------------------------------------------");

		} catch (Exception e) {
			System.out.println("Table does not Exist check the Table name...");
		}
	}
}