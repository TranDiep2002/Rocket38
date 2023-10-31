package bt.frontend;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import bt.backend.PresentationLayer.Controller;
import bt.entity.Account;
import bt.untils.ReadWriteFile;
import bt.untils.ScannerUtils;

public class Program {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		File file = new File("D:\\esclip\\account.ser");
		Controller co = new Controller();
		List<Account> lst = co.LayAllAccount();
		int chon;
		
		do {
			menu();
			chon = ScannerUtils.inputInt();
			switch (chon) {
			case 1:
				for (Account a : lst) {
					System.out.print(a.toString()+"\n");
				}
				break;
			case 2: 
				if(file.createNewFile()) {
					System.out.print("tạo file thành công");
				}else {
					System.out.print("tạo file không thành công");
				}break;
			case 3:
				ReadWriteFile.WriteAccount("D:\\esclip\\account.ser", lst);
				break;
			case 4:
				List<Account> list= new ArrayList<>();
				list=ReadWriteFile.ReadAccount("D:\\esclip\\account.ser");
				for(Account acc: list) {
					System.out.print(acc.toString()+"\n");
				}break;
			case 5: 
				System.out.print("Kết thúc chương trình !!!");
				System.exit(0);break;
			}
		} while (chon != 0);
	}

	public static void menu() {
		System.out.print("\n 1. Hiện danh sách account");
		System.out.print("\n 2. Tạo file mới");
		System.out.print("\n 3. Ghi file account");
		System.out.print("\n 4. Đọc file account");
		System.out.print("\n 5. Thoát");
		System.out.print("\nMời bạn chọn:");
	}
}
