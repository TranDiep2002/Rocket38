package bt.untils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import bt.entity.Account;

public class ReadWriteFile {
	public static void WriteAccount(String filepath , List<Account>lst ) throws IOException{
		//Account a = new Account();
		try {
			FileOutputStream fileOut = new FileOutputStream(filepath);
			ObjectOutputStream obj = new ObjectOutputStream(fileOut);
			obj.writeObject(lst);
			obj.close();
			System.out.print("ghi file thành công");
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
			System.out.print("ghi file không thành công");
		}
		
		
	}
	public static List<Account> ReadAccount(String filepath) throws IOException, ClassNotFoundException{
		FileInputStream fileIn = new FileInputStream(filepath);
		ObjectInputStream obj = new ObjectInputStream(fileIn);
		Object o = obj.readObject();
		obj.close();
		//Account b = (Account) o;
		List<Account>lst = new ArrayList<>();
		lst =(List<Account>) o;
		return lst;
		
	}
}
