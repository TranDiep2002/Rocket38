/*
 * =====Lịch Vạn Niên==========
=====1. Đăng nhập==============
=====2. Tạo Account=============
=====3. Xem ngày hiện tại========== (chỉ đăng nhập rồi mới xem đươc)
=====4. Đổi lịch dương sang lịch âm==== (chỉ đăng nhập rồi mới xem đươc)
=====5. Xem thông tin chi tiết Account===== (chỉ đăng nhập rồi mới xem đươc)
=====Q. Quit=================================
 */
package btvn.entity;

public class DangNhap {
	private String hoten;
	private String pass;
	public DangNhap(String hoten, String pass) {
		super();
		this.hoten = hoten;
		this.pass = pass;
	}
	public DangNhap() {
		
	}
	public void Nhap() {
		ScannerUtils sc = new ScannerUtils();
		System.out.print("\n nhập tên đăng nhập:");
		hoten = sc.inputString("nhap ten dang nhap!!!");
		System.out.print("\n nhập password:");
		pass = sc.inputString("nhap pass!!!");
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
