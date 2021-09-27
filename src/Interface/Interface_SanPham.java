package Interface;

public interface Interface_SanPham 
{
	//Properties
	public String getsMaSP();
	public void setsMaSP(String sMaSP);
	public String getsTenSP();
	public void setsTenSP(String sTenSP);
	public String getsLoaiSP();
	public void setsLoaiSP(String sLoaiSP);
	public String getsThuongHieu();
	public void setsThuongHieu(String sThuongHieu);
	public String getsTrangThai();
	public void setsTrangThai(String sTrangThai);
	public int getsSoluong();
	public void setsSoluong(int sSoluong);
	public float getsGiaban();
	public void setsGiaban(float sGiaban);
	
	//Method
	public void Nhap();
    public void Hien();
    public String toString();
    public boolean compareTo(Interface_SanPham a);
}
