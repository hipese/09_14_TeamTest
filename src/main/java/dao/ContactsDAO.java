package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import dto.ContactsDTO;

public class ContactsDAO {
	private BasicDataSource dataSource = new BasicDataSource();
	// singleton
	private static ContactsDAO instance;

	public static ContactsDAO getInstance() {
		if (instance == null) {
			instance = new ContactsDAO();
		}
		return instance;
	}

	private ContactsDAO() {
			dataSource.setInitialSize(10);
			dataSource.setUsername("java");
			dataSource.setPassword("java");
			dataSource.setUrl("jdbc:mysql://10.2.10.253/java");
			dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		}

	private Connection getConnection() throws Exception {
		return dataSource.getConnection();
	}

	public int insert(ContactsDTO dto) throws Exception {

		String sql = "insert into contacts values(null, ?, ?)";

		try (Connection con = this.getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {
			pstat.setString(1, dto.getName());
			pstat.setString(2, dto.getContact());
			return pstat.executeUpdate();
		}
	}

	public int delete(String seq) throws Exception {

		String sql = "delete from contacts where seq=?";

		try (Connection con = this.getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {

			pstat.setString(1, seq);
			return pstat.executeUpdate();

		}
	}

	public int update(ContactsDTO dto) throws Exception {

		String sql = "update contacts set name=?, contact=? where seq=?";

		try (Connection con = this.getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {

			pstat.setString(1, dto.getName());
			pstat.setString(2, dto.getContact());
			pstat.setString(3, dto.getSeq());
			return pstat.executeUpdate();
		}
	}

	public List<ContactsDTO> selectAll() throws Exception {

		String sql = "select * from contacts";

		try (Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();) {
			List<ContactsDTO> list = new ArrayList<>();
			while (rs.next()) {
				String seq = rs.getInt("seq") + "";
				String name = rs.getString("name");
				String contact = rs.getString("contact");
				ContactsDTO dto = new ContactsDTO(seq, name, contact);
				list.add(dto);
			}
			return list;
		}
	}
}
