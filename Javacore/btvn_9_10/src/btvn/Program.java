package btvn;

public class Program {
	public static void main(String args[]) {
		GiaoVien gv1 = new GiaoVien();
		gv1.maGv =1;
		gv1.tenGv="tran huong giang";
		gv1.capBac="tien si";
		gv1.tuoiGv=39;
		
		GiaoVien gv2 = new GiaoVien();
		gv2.maGv =2;
		gv2.tenGv="tran trung van";
		gv2.capBac="tien si";
		gv2.tuoiGv=40;
		
		SinhVien sv1= new SinhVien();
		sv1.maSv =1;
		sv1.tenSv = "tran a";
		sv1.tuoiSv =20;
		sv1.queQuan="ha noi";
		
		SinhVien sv2= new SinhVien();
		sv2.maSv =2;
		sv2.tenSv = "tran b";
		sv2.tuoiSv =20;
		sv2.queQuan="ha noi";
		
		SinhVien sv3= new SinhVien();
		sv3.maSv =3;
		sv3.tenSv = "tran c";
		sv3.tuoiSv =20;
		sv3.queQuan="ha noi";

		
		LopHoc lh1= new LopHoc();
		lh1.maLop = 1;
		
		lh1.monHoc="toan";
		lh1.thoiGian="5 thang";
		lh1.soSv = 60;
		lh1.giaovien = gv1;
		
		LopHoc lh2= new LopHoc();
		lh2.maLop = 2;
		lh2.monHoc="van";
		lh2.thoiGian="10 thang";
		lh2.soSv = 100;
		lh2.giaovien=gv2;
		
		CauLacBo clb1 = new CauLacBo();
		clb1.maClb=1;
		clb1.soSv=20;
		clb1.tenClb="am nhac";
		
		
		System.out.print("Danh sach sinh vien cac lop:" );
		System.out.print("\n===================================================");
		System.out.print("\nDanh sach lop : "+lh1.monHoc+"   " +"giang vien day:"+lh1.giaovien.getTenGv() + "    "+"mon hoc :"+lh1.monHoc);
		System.out.print("\n"+"ten sinh vien :"+sv1.tenSv+"   " +"Tuoi:"+  sv1.tuoiSv);
		System.out.print("\n"+"ten sinh vien :"+sv3.tenSv+"   " +"Tuoi:"+ sv3.tuoiSv);
		System.out.print("\n===================================================");
		System.out.print("\n Danh sach lop :"+lh2.monHoc+"    " +"Giang vien day:"+lh2.giaovien.getTenGv()+"     "+"mon hoc:" +lh2.monHoc);;
		System.out.print("\n "+"ten sinh vien :"+ sv1.tenSv+"    " +"Tuoi:"+ sv1.tuoiSv);
		
	}
}
