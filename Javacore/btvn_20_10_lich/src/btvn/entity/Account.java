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

public class Account {
	private int id;
	private String name;
	private String ngaySinh;
	private String diaChi;
	public Account(int id, String name, String ngaySinh , String diaChi) {
		super();
		this.id = id;
		this.name = name;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
	}
	public Account() {	
	}
	public void nhap() {
		ScannerUtils sc = new ScannerUtils();
		System.out.print("\n nhap id account");
		id = sc.inputInt("Nhap vao so");
		System.out.print("\n nhap name:");
		name = sc.inputName(name);
		System.out.print("\n nhap ngay sinh:");
		ngaySinh = sc.inputString("nhap ngay sinh:");
		System.out.print("\n nhap dia chi :");
		diaChi = sc.inputString("nhap dia chi!!");
	}
	public void xuat() {
		System.out.printf("\n%15s%15s%15s%15s","id","name","ngay sinh","dia chi");
		System.out.printf("\n%15d%15s%15s%15s",id,name,ngaySinh,diaChi);
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
}
