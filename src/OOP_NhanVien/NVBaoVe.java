package OOP_NhanVien;
import Interface.Interface_NVBaoVe;

public class NVBaoVe extends NhanVien implements Interface_NVBaoVe
{
	//Fields
	
	//Properties
	
	//Constructors
	public NVBaoVe()
    {
    	super();
    }
    public NVBaoVe(String tenNV, String maNV, String quequan, String chucvu, int namsinh, int calam,int luongcb)
    {
    	super(tenNV,maNV,quequan,chucvu,namsinh,calam,luongcb);
    }  
    //Method
    @Override
    public void Nhap()
    {
        super.Nhap();
        tinhluongCT();
    }
    @Override
    public void tinhluongCT()
    {
    	this.setiLuongChinhThuc(this.getiLuongCB() + this.getiCalam()*300000);
    }
    public boolean compareTo(Interface_NVBaoVe a)
    {
    	return this.getiLuongChinhThuc() > a.getiLuongChinhThuc();
    }
}
