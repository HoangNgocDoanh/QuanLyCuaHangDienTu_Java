package OOP_SanPham;
import java.util.Scanner;
public class TiVi extends SanPham
{
	 //Fields

    //Properties

    //Constructors
	public TiVi() { }
	public TiVi(String maSP) { }
    public TiVi(String loaiSP, String maSP, String tenSP, String thuongHieu, float giaBan, int soLuong, String trangThai)
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
    @Override
    public void Nhap()
    {
    	Scanner sc = new Scanner(System.in);
        System.out.print("\t\t Tên sản phẩm: ");
        setsTenSP(sc.nextLine());
        System.out.println();
        System.out.print("\t\t Thương hiệu : ");
        setsThuongHieu(sc.nextLine());
        System.out.println();
        System.out.print("\t\t Giá bán     : ");
        setsGiaban(Float.parseFloat(sc.nextLine()));
        System.out.println();
        System.out.print("\t\t Số Lượng    : ");
        setsSoluong(Integer.parseInt(sc.nextLine()));
        if (getsSoluong() > 0)
        {
            setsTrangThai("Còn");
        }
        else setsTrangThai("Hết hàng ");
    }
}
