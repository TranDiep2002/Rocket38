package bt.backend.Datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bt.entity.Account;
import bt.untils.jdbcConnection;

public class AccountRepository implements IAccountRepository {

	public List<Account> getListAccount() {
		try {
			Connection connection = jdbcConnection.getInstance.getDBConnection();
			String sql ="select * from account1";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rs= pstmt.executeQuery();
			List<Account>lst = new ArrayList<>();
			while(rs.next()) {
				String fullname = rs.getString("fullName");
				String emal = rs.getString("Email");
				Account a = new Account(emal,fullname);
				lst.add(a);
			}
			return lst;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.print("khong the select du lieu");
		}
		return null;
	}
	
}
