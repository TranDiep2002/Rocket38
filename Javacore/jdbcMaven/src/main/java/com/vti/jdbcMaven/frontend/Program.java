package com.vti.jdbcMaven.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.jdbcMaven.backend.DsAccount;

public class Program {
	public static void main(String args[]) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DsAccount a = new DsAccount();
		a.ThemAccount();
	}
}
