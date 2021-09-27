package OOP_NhanVien;
import Interface.Interface_NVThuNgan;

public class NVThuNgan extends NhanVien implements Interface_NVThuNgan
{
	//Fields
	
	
	//Properties
	
	//Constructors
	public NVThuNgan()
    {
    	super();
    }
    public NVThuNgan(String tenNV, String maNV, String quequan, String chucvu, int namsinh, int calam,int luongcb)
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
    	this.setiLuongChinhThuc(this.getiLuongCB() + this.getiCalam()*500000);
    }
    public boolean compareTo(Interface_NVThuNgan a)
    {
    	return this.getiLuongChinhThuc() > a.getiLuongChinhThuc();
    }
}
