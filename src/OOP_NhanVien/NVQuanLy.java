package OOP_NhanVien;

import java.util.Scanner;
import Interface.Interface_NVQuanLy;

public class NVQuanLy extends NhanVien implements Interface_NVQuanLy
{
	//Fields
    private int iThamnien;
    //Properties
    public int getiThamnien() {
		return iThamnien;
	}
	public void setiThamnien(int iThamnien) {
		this.iThamnien = iThamnien;
	}
    //Constructors
    public NVQuanLy()
    {
    	super();
    }
    public NVQuanLy(String tenNV, String maNV, String quequan, String chucvu, int namsinh, int calam,int luongcb)
    {
    	super(tenNV,maNV,quequan,chucvu,namsinh,calam,luongcb);
    }
    //Method
    @Override
    public void Nhap()
    {
    	Scanner sc = new Scanner(System.in);
        super.Nhap();
        tinhluongCT();
        System.out.print("\t\tNhập Thâm Niên : ");
        this.setiThamnien(Integer.parseInt(sc.nextLine()));
        System.out.println();
    }
    @Override
    public void tinhluongCT()
    {
        
        if (this.getiThamnien() >= 5)
        {
            this.setiLuongChinhThuc((this.getiLuongCB() + this.getiCalam()*600000) + 500000);
        }
        else
        {
            this.setiLuongChinhThuc(this.getiLuongCB() + this.getiCalam()*600000);
        }
    }
    public boolean compareTo(Interface_NVQuanLy a)
    {
    	return this.getiLuongChinhThuc() > a.getiLuongChinhThuc();
    }
}
