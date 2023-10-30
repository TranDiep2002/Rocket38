package com.vti.jdbcMaven.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.vti.jdbcMaven.entity.ScannerUtils;
import com.vti.jdbcMaven.entity.account;
import com.vti.jdbcMaven.entity.untils;

public class DsAccount {
	String username;
	String pass;
	ScannerUtils sc = new ScannerUtils();
	static untils ut= new untils();
	// them account
	public void ThemAccount() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		System.out.print("Moi ban dang nhap:");
		System.out.print("\n nhap username:");
		username = sc.inputString("nhap username!!!");
		System.out.print("\n nhap password:");
		pass = sc.inputString("\n nhap password!!!");
		if(ut.login(username, pass)) {
			account a = new account();
			try {
				a.them();
				System.out.print("them thanh cong!!!");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.print("thêm không thành công ");
			}
			
		}
	}
	
}
