package com.vti.jdbcMaven.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class account {
	private int id;
	private String email;
	private String name;
	private String pass;
	private int deId;
	private int poId;
	private String date;
	ScannerUtils sc = new ScannerUtils();
	static untils ut= new untils();
	public account(int id, String email, String name, String pass, int deId, int poId,String date) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.pass = pass;
		this.deId = deId;
		this.poId = poId;
		this.date=date;
	}
	public account() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getDeId() {
		return deId;
	}
	public void setDeId(int deId) {
		this.deId = deId;
	}
	public int getPoId() {
		return poId;
	}
	public void setPoId(int poId) {
		this.poId = poId;
	}
	public  void them() {
		System.out.print("\n nhap id:");
		id = sc.inputInt();
		System.out.print("\n nhap email");
		email= sc.inputString("nhap email");
		System.out.print("\n nhap name:");
		name = sc.inputString("nhap name");
		System.out.print("\n nhap deID:");
		deId=sc.inputInt();
		System.out.print("\n nhap poId:");
		poId = sc.inputInt();
		System.out.print("\n nhap password:");
		pass = sc.inputString("nhap pass");
		System.out.print("\n nhap date:");
		date = sc.inputString("nhap date");
		try(Connection connection = ut.Connect()) {
			Statement stmt =  connection.createStatement();
			String sql = " INSERT INTO `bai1`.`account1` (`AccID`, `Email`, `FK_DepartID`, `fullName`, `birtday`, `positionID`, `password`)"
					+ " VALUES (AccID=?, Email=?, FK_DepartID=?, fullName=?, birtday=?,positionID=?, password=?)";
			PreparedStatement pstmt1 = connection.prepareStatement(sql);
			pstmt1.setInt(1, id);
			pstmt1.setString(2,email);
			pstmt1.setInt(3, deId);
			pstmt1.setString(4, name);
			pstmt1.setString(5,date );
			pstmt1.setInt(6, poId);
			pstmt1.setString(7, pass);
			ResultSet rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("\n không thể thêm account");
		}
	}
}
