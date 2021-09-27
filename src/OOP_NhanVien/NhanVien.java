package OOP_NhanVien;

import java.util.Scanner;

public class NhanVien 
{
	//Fields
    protected String sTenNV;
    protected String sMaNV;
    protected String sQuequan;
    protected String sChucvu;
    protected int iNamsinh;
    protected int iLuongCB;
    protected int iCalam;
    protected int iLuongChinhThuc;
    
    //Properties
    public String getsTenNV() {
		return sTenNV;
	}
	public void setsTenNV(String sTenNV) {
		this.sTenNV = sTenNV;
	}
	public String getsMaNV() {
		return sMaNV;
	}
	public void setsMaNV(String sMaNV) {
		this.sMaNV = sMaNV;
	}
	public String getsQuequan() {
		return sQuequan;
	}
	public void setsQuequan(String sQuequan) {
		this.sQuequan = sQuequan;
	}
	public String getsChucvu() {
		return sChucvu;
	}
	public void setsChucvu(String sChucvu) {
		this.sChucvu = sChucvu;
	}
	public int getiNamsinh() {
		return iNamsinh;
	}
	public void setiNamsinh(int iNamsinh) {
		this.iNamsinh = iNamsinh;
	}
	public int getiLuongCB() {
		return iLuongCB;
	}
	public void setiLuongCB(int iLuongCB) {
		this.iLuongCB = iLuongCB;
	}
	public int getiCalam() {
		return iCalam;
	}
	public void setiCalam(int iCalam) {
		this.iCalam = iCalam;
	}
	public int getiLuongChinhThuc() {
		return iLuongChinhThuc;
	}
	public void setiLuongChinhThuc(int iLuongChinhThuc) {
		this.iLuongChinhThuc = iLuongChinhThuc;
	}
	
    //Constructors
    public NhanVien()
    {

    }
	public NhanVien(String tenNV, String maNV, String quequan, String chucvu, int namsinh, int calam, int luongcb)
    {
        this.setsTenNV(tenNV);
        this.setsMaNV(maNV);
        this.setsQuequan(quequan);
        this.setsChucvu(chucvu);
        this.setiNamsinh(namsinh);
        this.setiLuongCB(luongcb);
        this.setiCalam(calam);
        this.tinhluongCT();
    }
    
	//Method
    public void Nhap()
    {
        tinhluongCT();
        Scanner sc = new Scanner(System.in);
        System.out.print("\t\tNhập Tên Nhân Viên: ");
        this.setsTenNV(sc.nextLine());
        System.out.println();
        System.out.print("\t\tNhập Quê quán: ");
        this.setsQuequan(sc.nextLine());
        System.out.println();
        System.out.print("\t\tNhập Năm Sinh: ");
        this.setiNamsinh(Integer.parseInt(sc.nextLine()));
        System.out.println();
        System.out.print("\t\tNhập Lương cơ bản: ");
        this.setiLuongCB(Integer.parseInt(sc.nextLine()));
        System.out.println();
        System.out.print("\t\tNhập Số Ca làm: ");
        this.setiCalam(Integer.parseInt(sc.nextLine()));
    }
    public void tinhluongCT()
    {
        this.setiLuongChinhThuc(this.getiLuongCB());
    }
    public void Hien()
    {
        System.out.printf("\t|| %s\t\t\t\t   ||  %s   ||  %s    ||  %s    ||   %d\t    ||   %d\t\t   || %d\t\t      || ", this.getsTenNV(), this.getsMaNV(), this.getsQuequan(), this.getsChucvu(), this.getiNamsinh(), this.getiCalam(), this.getiLuongChinhThuc());
        System.out.println();
    }
    public String toString()
    {
        return (this.getsTenNV() + "#" + this.getsMaNV() + "#" + this.getsQuequan() + "#" + this.getsChucvu() + "#" + this.getiNamsinh() + "#" + this.getiCalam() + "#" + this.getiLuongCB());
    }

}
