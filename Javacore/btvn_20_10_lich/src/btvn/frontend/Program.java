package btvn.frontend;

import java.util.Scanner;

import btvn.entity.Account;
import btvn.entity.DangNhap;
import btvn.entity.Lich;

public class Program {
	
	public static void main(String args[]) {
		DangNhap a = new DangNhap();
		Account b = new Account();
		Scanner sc = new Scanner(System.in);
		int chon;
		do {
			System.out.print("\n================CHƯƠNG TRÌNH XEM LỊCH==========");
			System.out.print("\n1. đăng nhập");
			System.out.print("\n2. Tạo account mới");
			System.out.print("\n3. xem lịch hôm nay");
			System.out.print("\n4. đổi lịch dương sang lịch âm");
			System.out.print("\n5. xem chi tiết account");
			System.out.print("\n6. Thoát");
			System.out.print("\n mời bạn chon:");
			chon = sc.nextInt();
			switch(chon) {
			case 1:
				while (true) {
					a.Nhap();
					if (a.getHoten().compareTo("diep") == 0 && a.getPass().compareTo("123") == 0) {
						System.out.print("Đăng nhập  thành công !!! ");
						break;
					} else {
						System.out.print("Đăng nhập không thành công !!! mời nhập lại");
					}
				} break;
			case 2:
				
				b.nhap();
				break;
			case 3:
				if(a.getHoten()!=null) {
					Lich c = new Lich();
					c.ngayhientai();
				}else
				{
					System.out.print("\n bạn chưa đăng nhập , không thể xem được lịch");
				}break;
				
			case 4:
				if(a.getHoten()!=null) {
					Lich c = new Lich();
					int d,m,y;
					System.out.print("\n nhập ngày :");
					d = sc.nextInt();
					System.out.print("\n nhập tháng :");
					m = sc.nextInt();
					System.out.print("\n nhập năm :");
					y = sc.nextInt();
					c.Solar2Lunar(d, m, y);
				}else
				{
					System.out.print("\n bạn chưa đăng nhập , không thể xem được lịch");
				}break;
			case 5: 
				b.xuat(); break;
			case 6: 
				System.exit(0);
			}
	}while(chon!=0);
	}
}
