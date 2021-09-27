package OOP_SanPham;
import Interface.Interface_SanPham;

public abstract class SanPham implements Interface_SanPham
{
	 //Fields
    protected String sMaSP;
    protected String sTenSP;
    protected String sLoaiSP;
    protected String sThuongHieu;
    protected String sTrangThai;
    protected int sSoluong;
    protected float sGiaban;
    
    //Properties
    public String getsMaSP() {
		return sMaSP;
	}
	public void setsMaSP(String sMaSP) {
		this.sMaSP = sMaSP;
	}
	public String getsTenSP() {
		return sTenSP;
	}
	public void setsTenSP(String sTenSP) {
		this.sTenSP = sTenSP;
	}
	public String getsLoaiSP() {
		return sLoaiSP;
	}
	public void setsLoaiSP(String sLoaiSP) {
		this.sLoaiSP = sLoaiSP;
	}
	public String getsThuongHieu() {
		return sThuongHieu;
	}
	public void setsThuongHieu(String sThuongHieu) {
		this.sThuongHieu = sThuongHieu;
	}
	public String getsTrangThai() {
		return sTrangThai;
	}
	public void setsTrangThai(String sTrangThai) {
		this.sTrangThai = sTrangThai;
	}
	public int getsSoluong() {
		return sSoluong;
	}
	public void setsSoluong(int sSoluong) {
		this.sSoluong = sSoluong;
	}
	public float getsGiaban() {
		return sGiaban;
	}
	public void setsGiaban(float sGiaban) {
		this.sGiaban = sGiaban;
	}

	
	//Constructors
	public SanPham() { }
	public SanPham(String maSP) { }
    public SanPham(String loaiSP, String maSP, String tenSP, String thuongHieu, float giaBan, int soLuong, String trangThai)
    {
        this.setsLoaiSP(loaiSP);
        this.setsMaSP(maSP);
        this.setsTenSP(tenSP);
        this.setsThuongHieu(thuongHieu);
        this.setsGiaban(giaBan);
        this.setsSoluong(soLuong);
        this.setsTrangThai(trangThai);
    }
    
    //Method
    public abstract void Nhap();
    public void Hien()
    {
        System.out.printf("\t|| %s\t\t   ||  %s   ||  %s\t\t\t\t     ||  %s\t        ||  %f  ||   %d\t     ||    %s       || ",getsLoaiSP(), getsMaSP(), getsTenSP(), getsThuongHieu(), getsGiaban(), getsSoluong(), getsTrangThai());
        System.out.println();
    }
    public String toString()
    {
        return getsLoaiSP() + "#" + getsMaSP() + "#" + getsTenSP() + "#" + getsThuongHieu() + "#" + getsGiaban() + "#" + getsSoluong() + "#" + getsTrangThai();
    }
    public boolean compareTo(Interface_SanPham a)
    {
    	return this.getsSoluong() >a.getsSoluong();
    }
    
}
