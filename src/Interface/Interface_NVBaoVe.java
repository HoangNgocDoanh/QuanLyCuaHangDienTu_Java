package Interface;

public interface Interface_NVBaoVe
{
	//Properties
		public String getsTenNV();
		public void setsTenNV(String sTenNV);
		public String getsMaNV();
		public void setsMaNV(String sMaNV);
		public String getsQuequan();
		public void setsQuequan(String sQuequan);
		public String getsChucvu();
		public void setsChucvu(String sChucvu);
		public int getiNamsinh();
		public void setiNamsinh(int iNamsinh);
		public int getiLuongCB();
		public void setiLuongCB(int iLuongCB);
		public int getiCalam();
		public void setiCalam(int iCalam);
		public int getiLuongChinhThuc();
		public void setiLuongChinhThuc(int iLuongChinhThuc);
		
		//Method
		public void Nhap();
	    public void tinhluongCT();
	    public void Hien();
	    public String toString();
	    public boolean compareTo(Interface_NVBaoVe a);
}
