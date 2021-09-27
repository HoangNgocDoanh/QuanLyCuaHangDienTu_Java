import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Interface.Interface_NVBaoVe;
import Interface.Interface_NVQuanLy;
import Interface.Interface_NVThuNgan;
import Interface.Interface_SanPham;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import OOP_NhanVien.NVQuanLy;
import OOP_NhanVien.NVThuNgan;
import OOP_NhanVien.NVBaoVe;
import OOP_SanPham.TiVi;
import OOP_SanPham.TuLanh;
import OOP_SanPham.DieuHoa;
public class GiaoDien 
{
	List<Interface_SanPham> danhsach = new ArrayList<Interface_SanPham>();
    List<Interface_NVQuanLy> lQL = new ArrayList<Interface_NVQuanLy>();
    List<Interface_NVThuNgan> lTG = new ArrayList<Interface_NVThuNgan>();
    List<Interface_NVBaoVe> lBV = new ArrayList<Interface_NVBaoVe>();    
    Scanner sc = new Scanner(System.in);
    BufferedReader rd = new BufferedReader(new InputStreamReader(System.in)); 
    
    //NhanVien
    public void DocTepNV()
    {
        try
        {
            BufferedReader sr = new BufferedReader(new FileReader("nhanvien.txt"));
            String s;
            while ((s = sr.readLine()) != null)
            {
                if (s.length() > 0)
                {
                	Interface_NVQuanLy ql = new NVQuanLy();
                    Interface_NVThuNgan tg = new NVThuNgan();
                    Interface_NVBaoVe bv = new NVBaoVe();
                    int check;
                    String[] l = new String[7];
                    l = s.split("#");
                    if (l[3].equals("Quản Lý"))
                    {
                        ql = new NVQuanLy(l[0], l[1], l[2], l[3], Integer.parseInt(l[4]), Integer.parseInt(l[5]), Integer.parseInt(l[6]));
                        check = 1;
                    }
                    else if (l[3].equals("Thu Ngân"))
                    {
                        tg = new NVThuNgan(l[0], l[1], l[2], l[3], Integer.parseInt(l[4]), Integer.parseInt(l[5]), Integer.parseInt(l[6]));
                        check = 2;
                    }
                    else
                    {
                        bv = new NVBaoVe(l[0], l[1], l[2], l[3], Integer.parseInt(l[4]), Integer.parseInt(l[5]), Integer.parseInt(l[6]));
                        check = 3;
                    }
                    if (check == 1)
                    {
                    	int kt = 0;
                        for (Interface_NVQuanLy x : lQL) if (x.getsMaNV() == ql.getsMaNV()) kt = 1;
                        if (kt == 0) lQL.add(ql);
                    }
                    else if (check ==2)
                    {
                    	 int kt = 0;
                         for (Interface_NVThuNgan x : lTG) if (x.getsMaNV() == tg.getsMaNV()) kt = 1;
                         if (kt == 0) lTG.add(tg);
                    }
                    else 
                    {
                    	int kt = 0;
                        for (Interface_NVBaoVe x : lBV) if (x.getsMaNV() == bv.getsMaNV()) kt = 1;
                        if (kt == 0) lBV.add(bv);
                    }
                }
            }
            sr.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void GhiTepNV() throws IOException
    {
        BufferedWriter sw = new BufferedWriter(new FileWriter("nhanvien.txt"));
        for (Interface_NVQuanLy x : lQL)
        {
            sw.write(x.toString());
            sw.write("\n");
        }
        for (Interface_NVThuNgan y : lTG)
        {
            sw.write(y.toString());
            sw.write("\n");
        }
        for (Interface_NVBaoVe z : lBV)
        {
            sw.write(z.toString());
            sw.write("\n");
        }
        sw.close();
    }
    public void TKMaNV(String ma )
    {
        boolean ok = false;
        System.out.println("\n\t========================================DANH SÁCH THÔNG TIN NHÂN VIÊN CỦA CỬA HÀNG===========================================================================");
        System.out.println("\t||          Tên Nhân Viên          ||   Mã   ||   Quê Quán  ||   Chức Vụ   ||    Năm Sinh   || Số ngày công (Ngày) ||  Lương Chính Thức (VNĐ) ||");
        System.out.println("\t-------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < lQL.size(); i++)
        {
            if (lQL.get(i).getsMaNV().equals(ma))
            {
                ok = true;
                lQL.get(i).Hien();
            }
        }
        for (int i = 0; i < lTG.size(); i++)
        {
            if (lTG.get(i).getsMaNV().equals(ma))
            {
                ok = true;
                lTG.get(i).Hien();
            }
        }
        for (int i = 0; i < lBV.size(); i++)
        {
            if (lBV.get(i).getsMaNV().equals(ma))
            {
                ok = true;
                lBV.get(i).Hien();
            }
        }
        System.out.println("\t=============================================================================================================================================================");
        if (!ok)
            System.out.println("Mã Sản Phẩm Không Tồn Tại");
    }
    public void TKCvuNV(String cv )
    {
        boolean ok = false;
        System.out.println("\n\t========================================DANH SÁCH THÔNG TIN NHÂN VIÊN CỦA CỬA HÀNG===========================================================================");
        System.out.println("\t||          Tên Nhân Viên          ||   Mã   ||   Quê Quán  ||   Chức Vụ   ||    Năm Sinh   || Số ngày công (Ngày) ||  Lương Chính Thức (VNĐ) ||");
        System.out.println("\t-------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < lQL.size(); i++)
        {
            if (lQL.get(i).getsChucvu().equals(cv))
            {
                ok = true;
                lQL.get(i).Hien();
                
            }
        }
        for (int i = 0; i < lTG.size(); i++)
        {
            if (lTG.get(i).getsChucvu().equals(cv))
            {
                ok = true;
                lTG.get(i).Hien();
                
            }
        }
        for (int i = 0; i < lQL.size(); i++)
        {
            if (lBV.get(i).getsChucvu().equals(cv))
            {
                ok = true;
                lBV.get(i).Hien();
                
            }
        }
        System.out.println("\t=============================================================================================================================================================");
        if (!ok)
            System.out.println("Chức Vụ Không Tồn Tại");
    }
    public void TKTenNV(String ten )
    {
        boolean ok = false;
        System.out.println("\n\t========================================DANH SÁCH THÔNG TIN NHÂN VIÊN CỦA CỬA HÀNG===========================================================================");
        System.out.println("\t||          Tên Nhân Viên          ||   Mã   ||   Quê Quán  ||   Chức Vụ   ||    Năm Sinh   || Số ngày công (Ngày) ||  Lương Chính Thức (VNĐ) ||");
        System.out.println("\t-------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < lQL.size(); i++)
        {
            if (lQL.get(i).getsTenNV().equals(ten))
            {
                ok = true;
                lQL.get(i).Hien();
                
            }
        }
        for (int i = 0; i < lTG.size(); i++)
        {
            if (lTG.get(i).getsTenNV().equals(ten))
            {
                ok = true;
                lTG.get(i).Hien();
                
            }
        }
        for (int i = 0; i < lBV.size(); i++)
        {
            if (lBV.get(i).getsTenNV().equals(ten))
            {
                ok = true;
                lBV.get(i).Hien();
                
            }
        }
        System.out.println("\t=============================================================================================================================================================");
        if (!ok)
            System.out.println("Tên Nhân Viên Không Tồn Tại");
    }
    public void suatenNV()
    {
        boolean ok = false;
        System.out.print("\n\t\t\tNhập mã nhân viên cần sửa: ");
        String a = sc.nextLine();
        System.out.print("\t\t\tNhập tên mới : ");
        String b = sc.nextLine();
        for (int i = 0; i < lQL.size(); i++)
        {
            if (lQL.get(i).getsMaNV().equals(a))
            {
                ok = true;
                lQL.get(i).setsTenNV(b);
            }
        }
        for (int i = 0; i < lTG.size(); i++)
        {
            if (lTG.get(i).getsMaNV().equals(a))
            {
                ok = true;
                lTG.get(i).setsTenNV(b);
            }
        }
        for (int i = 0; i < lBV.size(); i++)
        {
            if (lBV.get(i).getsMaNV().equals(a))
            {
                ok = true;
                lBV.get(i).setsTenNV(b);
            }
        }
        if (!ok)
            System.out.println("\n\t\tMã nhân viên không tồn tại. Vui lòng quay lại sau!");
        else
        {
            System.out.println("\t\t Tên nhân viên đã sửa thành công !\n");
            TKMaNV(a);
        }
    }
    public void suaqueNV()
    {
        boolean ok = false;
        System.out.print("\n\t\t\tNhập mã nhân viên cần sửa: ");
        String a = sc.nextLine();
        System.out.print("\t\t\tNhập quê quán mới : ");
        String b = sc.nextLine();
        for (int i = 0; i < lQL.size(); i++)
        {
            if (lQL.get(i).getsMaNV().equals(a))
            {
                ok = true;
                lQL.get(i).setsQuequan(b);
            }
        }
        for (int i = 0; i < lTG.size(); i++)
        {
            if (lTG.get(i).getsMaNV().equals(a))
            {
                ok = true;
                lTG.get(i).setsQuequan(b);
            }
        }
        for (int i = 0; i < lBV.size(); i++)
        {
            if (lBV.get(i).getsMaNV().equals(a))
            {
                ok = true;
                lBV.get(i).setsQuequan(b);
            }
        }
        if (!ok)
            System.out.println("\n\t\tMã nhân viên không tồn tại. Vui lòng quay lại sau!");
        else
        {
            System.out.println("\t\t Quê quán nhân viên đã sửa thành công !\n");
            TKMaNV(a);
        }
    }
    public void suanamsinhNV()
    {
        boolean ok = false;
        System.out.print("\n\t\t\tNhập mã nhân viên cần sửa: ");
        String a = sc.nextLine();
        System.out.print("\t\t\tNhập năm sinh mới : ");
        int b = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < lQL.size(); i++)
        {
            if (lQL.get(i).getsMaNV().equals(a))
            {
                ok = true;
                lQL.get(i).setiNamsinh(b);
            }
        }
        for (int i = 0; i < lTG.size(); i++)
        {
            if (lTG.get(i).getsMaNV().equals(a))
            {
                ok = true;
                lTG.get(i).setiNamsinh(b);
            }
        }
        for (int i = 0; i < lBV.size(); i++)
        {
            if (lBV.get(i).getsMaNV().equals(a))
            {
                ok = true;
                lBV.get(i).setiNamsinh(b);
            }
        }
        if (!ok)
            System.out.println("\n\t\tMã nhân viên không tồn tại. Vui lòng quay lại sau!");
        else
        {
            System.out.println("\t\t Năm sinh nhân viên đã sửa thành công !\n");
            TKMaNV(a);
        }
    }
    public void suacvNV()
    {
        boolean ok = false;
        System.out.print("\n\t\t\tNhập mã nhân viên cần sửa: ");
        String a = sc.nextLine();
        System.out.print("\t\t\tNhập chức vụ mới : ");
        String b = sc.nextLine();
        for (int i = 0; i < lQL.size(); i++)
        {
            if (lQL.get(i).getsMaNV().equals(a))
            {
                ok = true;
                lQL.get(i).setsChucvu(b);
            }
        }
        for (int i = 0; i < lTG.size(); i++)
        {
            if (lTG.get(i).getsMaNV().equals(a))
            {
                ok = true;
                lTG.get(i).setsChucvu(b);
            }
        }
        for (int i = 0; i < lBV.size(); i++)
        {
            if (lBV.get(i).getsMaNV().equals(a))
            {
                ok = true;
                lBV.get(i).setsChucvu(b);
            }
        }
        if (!ok)
            System.out.println("\n\t\tMã nhân viên không tồn tại. Vui lòng quay lại sau!");
        else
        {
            System.out.println("\t\t Chức vụ nhân viên đã sửa thành công !\n");
            TKMaNV(a);
        }
    }
    public void SuaNV() throws IOException
    {
        while (true)
        {
            int i = 0;
            while (i<=5)
            {
            	System.out.println();
            	i++;
            }
            System.out.println("                     _______________________________________________ ");
        	System.out.println();
            System.out.println("                    |         CÁC HÌNH THỨC SỬA NHÂN VIÊN           |");
            System.out.println();
            System.out.println("                    |-----------------------------------------------|");
            System.out.println();
            System.out.println("                    |            1. Sửa Tên Nhân Viên               |");
            System.out.println();
            System.out.println("                    |            2. Sửa Quê Quán Nhân Viên          |");
            System.out.println();
            System.out.println("                    |            3. Sửa Năm Sinh Nhân Viên          |");
            System.out.println();
            System.out.println("                    |            4. Sửa Chức Vụ Nhân Viên           |");
            System.out.println();
            System.out.println("                    |            5. Quay Lại                        |");
            System.out.println();
            System.out.println("                    |_______________________________________________|");
            System.out.println();
            System.out.println();
            System.out.print(" Nhập công việc bạn muốn thực hiện(1->5) : ");
            int chon = Integer.parseInt(sc.nextLine());
            switch (chon)
            {
                case 1:
                    String temp;
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println("                    *-------------SỬA TÊN NHÂN VIÊN--------------*");
                    do
                    {
                        System.out.println();
                        suatenNV();
                        GhiTepNV();
                        System.out.print("\n\t\tBạn có muốn sửa tên nhân viên khác không (C/K)? ");
                        temp = sc.nextLine();
                    } while (temp == "c" || temp == "C");
                    rd.readLine();
                    break;
                case 2:
                    String b;
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println("                    *-------------SỬA QUÊ QUÁN NHÂN VIÊN------------*");
                    do
                    {
                        System.out.println();
                        suaqueNV();
                        GhiTepNV();
                        System.out.print("\n\t\tBạn có muốn sửa quê quán nhân viên khác không (C/K)? ");
                        b = sc.nextLine();
                    } while (b == "c" || b == "C");
                    rd.readLine();
                    break;
                case 3:
                    String c;
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println("                     *--------------SỬA NĂM SINH NHÂN VIÊN---------------*");
                    do
                    {
                        System.out.println();
                        suanamsinhNV();
                        GhiTepNV();
                        System.out.print("\n\t\tBạn có muốn sửa năm sinh nhân viên khác không (C/K)? ");
                        c = sc.nextLine();
                    } while (c == "c" || c == "C");
                    rd.readLine();
                    break;
                case 4:
                    String d;
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println("                    *-----------SỬA CHỨC VỤ NHÂN VIÊN-------------*");
                    do
                    {
                        System.out.println();
                        suacvNV();
                        GhiTepNV();
                        System.out.print("\n\t\tBạn có muốn sửa chức vụ nhân viên khác không (C/K)? ");
                        d = sc.nextLine();
                    } while (d == "c" || d == "C");
                    rd.readLine();
                    break;
                case 5:
                    MenuNV(); 
                    rd.readLine();
                    break;
            }
        }
    }
    public void xoaNV()
    {
        boolean ok = false;
        System.out.print("\t\t\tNhập mã nhân viên cần xóa: ");
        String ma = sc.nextLine();
        for (int i = 0; i < lQL.size(); i++)
        {
            if (lQL.get(i).getsMaNV().equals(ma))
            {
                lQL.remove(i);
                System.out.printf("\n\t\t    NHÂN VIÊN %s ĐÃ XÓA KHỎI DANH SÁCH ", ma);
                break;
            }
        }
        for (int i = 0; i < lTG.size(); i++)
        {
            if (lTG.get(i).getsMaNV().equals(ma))
            {
                lTG.remove(i);
                System.out.printf("\n\t\t    NHÂN VIÊN %s ĐÃ XÓA KHỎI DANH SÁCH ", ma);
                break;
            }
        }
        for (int i = 0; i < lBV.size(); i++)
        {
            if (lBV.get(i).getsMaNV().equals(ma))
            {
                lBV.remove(i);
                System.out.printf("\n\t\t    NHÂN VIÊN %s ĐÃ XÓA KHỎI DANH SÁCH ", ma);
                break;
            }
        }
        if (!ok)
            System.out.println("Không tồn tại mã " + ma);
    }
    public void Them1NV()
    {
    	Interface_NVQuanLy ql = new NVQuanLy();
        Interface_NVThuNgan tg = new NVThuNgan();
        Interface_NVBaoVe bv = new NVBaoVe();
        System.out.print("\t\tChọn chức vụ nhân viên(Quản lý/Thu ngân/Bảo vệ)(1->3): ");
        int a = Integer.parseInt(sc.nextLine());
        if (a == 1)
        {
            ql.setsChucvu("Quản Lý");
        }
        else if (a == 2)
        {
            tg.setsChucvu("Thu Ngân");
        }
        else
        {
            bv.setsChucvu("Bảo Vệ");
        }
        boolean ok = false;
        System.out.print("\t\t Nhập mã nhân viên: ");
        if (a==1)
        {
        	ql.setsMaNV(sc.nextLine());
            for (int i = 0; i < lQL.size(); i++)
            {
                if (lQL.get(i).getsMaNV().equals(ql.getsMaNV()))//So sánh 2 chuỗi có giống nhau hay không
                {
                    ok = true;
                    System.out.println("\n\t\tĐã tồn tại mã nhân viên trong danh sách. Vui lòng nhập lại!");
                }
            }
        }
        else if (a==2)
        {
        	tg.setsMaNV(sc.nextLine());
            for (int i = 0; i < lTG.size(); i++)
            {
                if (lTG.get(i).getsMaNV().equals(tg.getsMaNV()))//So sánh 2 chuỗi có giống nhau hay không
                {
                    ok = true;
                    System.out.println("\n\t\tĐã tồn tại mã nhân viên trong danh sách. Vui lòng nhập lại!");
                }
            }
        }
        else 
        {
        	bv.setsMaNV(sc.nextLine());
            for (int i = 0; i < lBV.size(); i++)
            {
                if (lBV.get(i).getsMaNV().equals(bv.getsMaNV()))//So sánh 2 chuỗi có giống nhau hay không
                {
                    ok = true;
                    System.out.println("\n\t\tĐã tồn tại mã nhân viên trong danh sách. Vui lòng nhập lại!");
                }
            }
        }
        if (!ok)//Chưa tồn tại mã nếu biến Ok khác true thì sẽ thực hiện các lệnh 
        {
        	if (a == 1)
            {
                ql.Nhap();
                lQL.add(ql);
            }
            else if (a == 2)
            {
                tg.Nhap();
                lTG.add(tg);
            }
            else
            {
                bv.Nhap();
                lBV.add(bv);
            }
            System.out.println("\t\tNHÂN VIÊN ÐÃ ÐƯỢC THÊM VÀO TRONG DANH SÁCH !");
        }
    }
    public void ThemNV() throws IOException

    
    {
        System.out.print("\t\tNhập số lượng nhân viên cần thêm: ");
        int n = Integer.parseInt(sc.nextLine());
        System.out.println();
        for (int i = 0; i < n; i++)
        {
            System.out.printf("\n\t\tNhập thông tin nhân viên thứ %d ", i + 1);
            System.out.println();
            Them1NV();
            GhiTepNV();
        }
    }
    public void HienThiNV()
    {
        System.out.println("\n\t========================================DANH SÁCH THÔNG TIN NHÂN VIÊN CỦA CỬA HÀNG==============================================================");
        System.out.println("\t||          Tên Nhân Viên          ||   Mã   ||   Quê Quán  ||   Chức Vụ   ||    Năm Sinh   || Số ngày công (Ngày) ||  Lương Chính Thức (VNĐ) ||");
        System.out.println("\t---------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Interface_NVQuanLy x : lQL)
        {
            x.Hien();
        }
        for (Interface_NVThuNgan x : lTG)
        {
            x.Hien();
        }
        for (Interface_NVBaoVe x : lBV)
        {
            x.Hien();
        }
        System.out.println("\t===================================================================================================================================================");
    }
    public void Quanly()
    {

        System.out.println("\n\t========================================DANH SÁCH THÔNG TIN NHÂN VIÊN CỦA CỬA HÀNG===========================================================================");
        System.out.println("\t||          Tên Nhân Viên          ||   Mã   ||   Quê Quán  ||   Chức Vụ   ||    Năm Sinh   || Số ngày công (Ngày) ||  Lương Chính Thức (VNĐ) ||");
        System.out.println("\t-------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Interface_NVQuanLy x : lQL)
        {
            x.Hien();
        }
        System.out.println("\t==============================================================================================================================================================");
    }
    public void BaoVe()
    {

        System.out.println("\n\t========================================DANH SÁCH THÔNG TIN NHÂN VIÊN CỦA CỬA HÀNG===========================================================================");
        System.out.println("\t||          Tên Nhân Viên          ||   Mã   ||   Quê Quán  ||   Chức Vụ   ||    Năm Sinh   || Số ngày công (Ngày) ||  Lương Chính Thức (VNĐ) ||");
        System.out.println("\t-------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Interface_NVBaoVe x : lBV)
        {
            x.Hien();
        }
        System.out.println("\t==============================================================================================================================================================");
    }
    public void ThuNgan()
    {

        System.out.println("\n\t========================================DANH SÁCH THÔNG TIN NHÂN VIÊN CỦA CỬA HÀNG===========================================================================");
        System.out.println("\t||          Tên Nhân Viên          ||   Mã   ||   Quê Quán  ||   Chức Vụ   ||    Năm Sinh   || Số ngày công (Ngày) ||  Lương Chính Thức (VNĐ) ||");
        System.out.println("\t-------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Interface_NVThuNgan x : lTG)
        {
            x.Hien();
        }
        System.out.println("\t=============================================================================================================================================================");
    }
    public String MaxLuong()
    {
        DocTepNV();
        Interface_NVQuanLy maxql = new NVQuanLy("", "", "", "", 0, 0, 0);
        Interface_NVThuNgan maxtg = new NVThuNgan("", "", "", "", 0, 0, 0);
        Interface_NVBaoVe maxbv = new NVBaoVe("", "", "", "", 0, 0, 0);
        String maxma = "";
        int maxmon = 0;
        for (Interface_NVQuanLy a : lQL)
        {
            if (a.compareTo(maxql))
            {
                maxql = a;
                maxmon = a.getiLuongChinhThuc();
                maxma = a.getsMaNV();
            }
        }
        for (Interface_NVThuNgan b : lTG)
        {
            if (b.compareTo(maxtg))
            {
                maxtg = b;
                if (maxtg.getiLuongChinhThuc() > maxmon)
                {
                    maxmon = maxtg.getiLuongChinhThuc();
                    maxma = maxtg.getsMaNV();
                }
            }
        }
        for (Interface_NVBaoVe c : lBV)
        {
            if (c.compareTo(maxbv))
            {
                maxbv = c;
                if (maxbv.getiLuongChinhThuc() > maxmon)
                {
                    maxmon = maxbv.getiLuongChinhThuc();
                    maxma = maxbv.getsMaNV();
                }
            }
        }
        return maxma;
    }

    //MENU
    public void MenuChinh() throws IOException
    {
    	int i = 0;
        while (i<=5)
        {
        	System.out.println();
        	i++;
        }
        System.out.println("                     =============================================================================");
    	System.out.println();
        System.out.println("                     ||               =======>  QUẢN LÝ CỬA HÀNG ĐIỆN TỬ  <=======               ||");
        System.out.println();
        System.out.println("                     ||                                                                          ||");
        System.out.println();
        System.out.println("                     ||   1. Quản Lý Sản Phẩm            ||       4. Thông Tin Cửa Hàng          ||");
        System.out.println();
        System.out.println("                     ||                                  ||                                      ||");
        System.out.println();
        System.out.println("                     ||   2. Quản Lý Cửa Hàng            ||       5. Thống Kê Sản Phẩm           ||");
        System.out.println();
        System.out.println("                     ||                                  ||                                      ||");
        System.out.println();
        System.out.println("                     ||   3. Tìm Kiếm Thông Tin          ||       6. Thoát Khỏi Chương Trình     ||");
        System.out.println();
        System.out.println("                     ||                                                                          ||");
        System.out.println();
        System.out.println("                     =============================================================================");
        System.out.println();
        System.out.println();
        System.out.print("                     Mời Bạn Chọn Công Việc (1-6): ");
        int t = Integer.parseInt(sc.nextLine());
        do
        {
            switch (t)
            {
                case 1:
                    MenuSP();
                    rd.readLine();
                    break;
                case 2:
                    MenuNV();
                    rd.readLine();
                    break;
                case 3:
                    MenuTK();
                    rd.readLine();
                    break;
                case 4:
                    ThongTinCuaHang();
                    rd.readLine();
                    break;
                case 5:
                    ThongKeSP();
                    rd.readLine();
                    break;
                case 6: System.exit(0); break;
            }
        } while (true);
    }
    public void ThongTinCuaHang() throws IOException
    {
    	System.out.println("                         ********************************************************");
        System.out.println("                         *                 CỬA HÀNG ĐIỆN TỬ UTE                 *");
        System.out.println("                         * Số 1 Võ Văn Ngân - Phường Bình Thọ, Thủ Đức - TPHCM  *");
        System.out.println("                         *......................................................*");
        System.out.println("                         *   Liên hệ chúng tôi:                                 *");
        System.out.println("                         *                     -SĐT  : 0946 669 966-0123 169 96 *");
        System.out.println("                         *                     -Email: dientuute@gmail.com      *");
        System.out.println("                         ********************************************************");
        System.out.println("             \n");
        System.out.println("Press any key to return main menu..");
        rd.readLine();
        MenuChinh();
    }
    public void TaiKhoan() throws IOException
    {
        // Console.Clear();
        String tk;
        String mk = "";
        int d = 0;
        do
        {
            System.out.println("                         ********************************************************");
            System.out.println("                         *                       ĐỒ ÁN                          *");
            System.out.println("                         *               Quản lý bán hàng điện tử               *");
            System.out.println("                         *......................................................*");
            System.out.println("                         *                                                      *");
            System.out.println("                         *   Giáo Viên Hướng Dẫn: Ths: Lê Văn Vinh              *");
            System.out.println("                         *      Sinh Viên Thực Hiện  : Lê Nguyễn Thanh Nhân     *");
            System.out.println("                         *                             Hoàng Ngọc Doanh         *");
            System.out.println("                         ********************************************************");
            System.out.println("             \n");
            int k = 0;
            while (k<11)
            {
            	System.out.println();
            	k++;
            }
            System.out.print(" 				_________________________________________");
            System.out.println();
            System.out.print("				|                 ĐĂNG NHẬP               |");
            System.out.println();
            System.out.print("				|-----------------------------------------|");
            System.out.println();
            System.out.print("				|                                         |");
            System.out.println();
            System.out.print("				|	Tên đăng nhập: ");
            tk = sc.nextLine();
            System.out.println();
            System.out.print("				|	Mật khẩu: ");
            mk = sc.nextLine();
            System.out.print(" 				_________________________________________");
            System.out.println("\n");
            if (tk.equals("admin") && mk.equals("admin"))
            {
                MenuChinh();
            }
            else if (tk != "admin" || mk != "admin")
            {
                System.out.println("				Tên tài khoản hoặc mật khẩu đăng nhập không chính xác! Vui lòng nhập lại.");
                d = d + 1;
                System.out.print("				Bạn Có Muốn Đăng Nhập Lại Không?(C/K)");
                String kt = sc.nextLine();
                if (kt.equals("k") || kt.equals("K")) System.exit(0);//Thoát khỏi chương trình
            }

        } while ((d != 3));
        if (d == 3)
        {
            System.out.print("*** BẠN ĐÃ ĐĂNG NHẬP QUÁ BA LẦN VUI LÒNG QUAY LẠI SAU !***");
            rd.readLine();
            System.exit(0);
        }
    }
    public void MenuSP() throws IOException
    {
        DocTepSP();
        while (true)
        {
        	int i = 0;
            while (i<=5)
            {
            	System.out.println();
            	i++;
            }
            System.out.println("                    			*------------------------------------------------------------------------*");
            System.out.println("					*                        QUẢN LÝ DANH SÁCH SẢN PHẨM                      *");
            System.out.println("					*                                                                        *");
            System.out.println("					*  1. Hiện Thị Danh Sách Sản Phẩm   |  5. Tìm Kiếm Sản Phẩm Theo Mã      *");
            System.out.println("					*  2. Thêm Sản Phẩm                 |  6. Tìm Kiếm Sản Phẩm Theo Tên     *");
            System.out.println("					*  3. Sửa Thông Tin Sản Phẩm        |  7. Quay Lại                       *");
            System.out.println("					*  4. Xóa Thông Tin Sản Phẩm        |  8. Thoát Khỏi Chương Trình        *");
            System.out.println("					*                                                                        *");
            System.out.println("					*------------------------------------------------------------------------*");
            System.out.print(" 					Mời Bạn Chọn Công Việc (1->8): ");
            int c = Integer.parseInt(sc.nextLine());
            switch (c)
            {
                case 1:
                    HienThiSP();
                    rd.readLine();
                    break;
                case 2:
                	System.out.println();
                	System.out.println();
                	System.out.println();
                    System.out.println("		  *--------------THÊM THÔNG TIN SẢN PHẨM--------------*");
                    ThemSP();
                    rd.readLine();
                    break;
                case 3:
                    SuaSP();
                    rd.readLine();
                    break;
                case 4:
                	System.out.println();
                	System.out.println();
                	System.out.println();
                    System.out.println("		  *--------------XÓA THÔNG TIN SẢN PHẨM----------------*");
                    String xa;
                    do
                    {
                        System.out.println();
                        XoaSP();
                        GhiTepSP();
                        System.out.print("\n\t\t  Bạn có muốn xóa sản phẩm khác không (C/K)? ");
                        xa = sc.nextLine();
                    } while (xa == "c" || xa == "C");
                    rd.readLine();
                    break;
                case 5:
                	System.out.println();
                	System.out.println();
                	System.out.println();
                	System.out.println("		  *---------------TÌM KIẾM SẢN PHẢM THEO MÃ-----------------*");
                	System.out.println();
                	System.out.println();
                    System.out.print("		  	Nhập mã sản phẩm cần tìm kiếm: ");
                    String ma = sc.nextLine();
                    TKMaSP(ma);
                    rd.readLine();
                    break;
                case 6:
                	System.out.println();
                	System.out.println();
                	System.out.println();
                    System.out.println("*---------------TÌM KIẾM SẢN PHẢM THEO TÊN SP-----------------*");
                    System.out.println();
                	System.out.println();
                    System.out.print("\n\t\tNhập tên sản phẩm cần tìm kiếm: ");
                    String b = sc.nextLine();
                    TKTenSP(b);
                    rd.readLine();
                    break;
                case 7:
                    MenuChinh();
                    rd.readLine();
                    break;
                case 8:
                    System.exit(0);
                    break;
            }
        }
    }
    public void MenuNV() throws IOException
    {
        DocTepNV();
        while (true)
        {
        	int i = 0;
            while (i<=5)
            {
            	System.out.println();
            	i++;
            }
            System.out.println("				*------------------------------------------------------------------------*");
            System.out.println();
            System.out.println("				*                        QUẢN LÝ NHÂN SỰ CỬA HÀNG                        *");
            System.out.println();
            System.out.println("				*                                                                        *");
            System.out.println();
            System.out.println("				*  1. Hiện Thị Danh Sách Nhân Viên  |  4. Xóa Thông Tin Nhân Viên        *");
            System.out.println();
            System.out.println("				*  2. Thêm Nhân Viên                |  5. Quay lại Menu Chính            *");
            System.out.println();
            System.out.println("				*  3. Sửa Thông Tin Nhân Viên       |  6. Escape                         *");
            System.out.println();
            System.out.println("				*                                                                        *");
            System.out.println();
            System.out.println("				*------------------------------------------------------------------------*");
            System.out.println();
            System.out.println();
            System.out.print(" 				Mời Bạn Chọn Công Việc (1->6): ");
            int c = Integer.parseInt(sc.nextLine());
            String xa;
            switch (c)
            {
                case 1:
                    HienThiNV();
                    rd.readLine();
                    break;
                case 2:
                	System.out.println();
                	System.out.println();
                	System.out.println();
                    System.out.println("		  *--------------THÊM THÔNG TIN SẢN PHẨM--------------*");
                    ThemNV();
                    rd.readLine();
                    break;
                case 3:
                    SuaNV();
                    rd.readLine();
                    break;
                case 4:
                	System.out.println();
                	System.out.println();
                	System.out.println();
                    System.out.println("				*--------------XÓA THÔNG TIN SẢN PHẨM----------------*");
                    do
                    {
                        System.out.println();
                        xoaNV();
                        GhiTepNV();
                        System.out.print("\n\t\t  Bạn có muốn xóa sản phẩm khác không (C/K)? ");
                        xa = sc.nextLine();
                    } while (xa == "c" || xa == "C");
                    rd.readLine();
                    break;
                case 5:
                    MenuChinh();
                    rd.readLine();
                    break;
                case 6:
                	System.exit(0);
                    break;
            }
        }
    }
    public void TKSanPham() throws IOException
    {
        DocTepSP();
        while (true)
        {
        	int i = 0;
            while (i<=5)
            {
            	System.out.println();
            	i++;
            }
            System.out.println(" 				_______________TÌM KIẾM SẢN PHẨM_____________ ");
            System.out.println();
            System.out.println("				|     1. Tìm Kiếm Theo Mã Sản Phẩm            |");
            System.out.println();
            System.out.println("				|     2. Tìm Kiếm Theo Tên Sản Phẩm           |");
            System.out.println();
            System.out.println("				|     3. Tìm Kiếm Theo Giá Sản Phẩm           |");
            System.out.println();
            System.out.println("				|     4. Quay Lại                             |");
            System.out.println();
            System.out.println("				|_____________________________________________|");
            System.out.println();
            System.out.println();
            System.out.print("				   Nhập công việc bạn muốn thực hiện: ");
            int a = Integer.parseInt(sc.nextLine());
            switch (a)
            {
                case 1:
                	System.out.println();
                	System.out.println();
                	System.out.println();
                    System.out.println("		  *---------------TÌM KIẾM SẢN PHẢM THEO MÃ-----------------*");
                    System.out.println();
                    System.out.println();
                    System.out.print("			Nhập mã sản phẩm cần tìm kiếm: ");
                    String ma = sc.nextLine();
                    TKMaSP(ma);
                    rd.readLine();
                    break;
                case 2:
                	System.out.println();
                	System.out.println();
                	System.out.println();
                    System.out.println("		  *---------------TÌM KIẾM SẢN PHẢM THEO TÊN SP-----------------*");
                    System.out.println();
                    System.out.println();
                    System.out.print("\n\t\tNhập tên sản phẩm cần tìm kiếm: ");
                    String b = sc.nextLine();
                    TKTenSP(b);
                    rd.readLine();
                    break;
                case 3:
                	System.out.println();
                	System.out.println();
                	System.out.println();
                    System.out.println("		  *---------------TÌM KIẾM SẢN PHẢM THEO GiÁ SP-----------------*");
                    TKGiaSP();
                    rd.readLine();
                    break;
                case 4:
                    MenuTK();
                    rd.readLine();
                    break;
            }
        }
    }
    public void TKNhanVien() throws IOException
    {
        DocTepNV();
        while (true)
        {
        	int i = 0;
            while (i<=5)
            {
            	System.out.println();
            	i++;
            }
            System.out.println("				_______________TÌM KIẾM NHÂN VIÊN____________ ");
            System.out.println();
            System.out.println("				|     1. Tìm Kiếm Theo Mã Nhân Viên           |");
            System.out.println();
            System.out.println("				|     2. Tìm Kiếm Theo Tên Nhân Viên          |");
            System.out.println();
            System.out.println("				|     3. Tìm Kiếm Theo Chức Vụ Nhân Viên      |");
            System.out.println();
            System.out.println("				|     4. Quay Lại                             |");
            System.out.println();
            System.out.println("				|_____________________________________________|");
            System.out.println();
            System.out.println();
            System.out.print("				   Nhập công việc bạn muốn thực hiện: ");
            int a = Integer.parseInt(sc.nextLine());
            switch (a)
            {
                case 1:
                	System.out.println();
                	System.out.println();
                	System.out.println();
                    System.out.println("*---------------TÌM KIẾM SẢN PHẢM THEO MÃ NHÂN VIÊN-----------------*");
                    System.out.println();
                    System.out.println();
                    System.out.print("Nhập mã nhân viên cần tìm kiếm: ");
                    String ma = sc.nextLine();
                    TKMaNV(ma );
                    break;
                case 2:
                	System.out.println();
                	System.out.println();
                	System.out.println();
                    System.out.println("*---------------TÌM KIẾM SẢN PHẢM THEO TÊN NHÂN VIÊN-----------------*");
                    System.out.println();
                    System.out.println();
                    System.out.print("\n\t\tNhập tên sản phẩm cần tìm kiếm: ");
                    String b = sc.nextLine();
                    TKTenNV(b); 
                    break;
                case 3:
                	System.out.println();
                	System.out.println();
                	System.out.println();
                    System.out.println("*---------------TÌM KIẾM SẢN PHẢM THEO CHỨC VỤ-----------------*");
                    System.out.println();
                    System.out.println();
                    System.out.print("\n\t\tNhập chức vụ cần tìm kiếm(Quản lý/Thu ngân/Bảo vệ)(1->3): ");
                    int dem = Integer.parseInt(sc.nextLine());
                    String temp;
                    if (dem == 1) temp = "Quản Lý";
                    else if (dem == 2) temp = "Thu Ngân";
                    else temp = "Bảo Vệ";
                    TKCvuNV(temp); 
                    break;
                case 4:
                    MenuTK(); break;
            }
        }
    }
    public void MenuTK() throws IOException
    {
        while (true)
        {
        	int i = 0;
            while (i<=5)
            {
            	System.out.println();
            	i++;
            }
            System.out.println("				*----------------TÌM KIẾM------------------*");
            System.out.println();
            System.out.println("				*     1. Tìm Kiếm Nhân Viên                *");
            System.out.println();
            System.out.println("				*     2. Tìm Kiếm Sản Phẩm                 *");
            System.out.println();
            System.out.println("				*     3. Nhân Viên Lương Cao Nhất          *");
            System.out.println();
            System.out.println("				*     4. Sản Phẩm Số Lượng Lớn Nhất        *");
            System.out.println();
            System.out.println("				*     5. Quay Lại                          *");
            System.out.println();
            System.out.println("				*     6. Thoát                             *");
            System.out.println();
            System.out.println("				*------------------------------------------*");
            System.out.println();
            System.out.println();
            System.out.print("  			  Mời Bạn Chọn Công Việc (1-4): ");
            int c = Integer.parseInt(sc.nextLine());
            switch (c)
            {
                case 1:
                    TKNhanVien(); 
                    rd.readLine();
                    break;
                case 2:
                    DocTepSP();
                    TKSanPham();
                    rd.readLine();
                    break;
                case 3:
                	TKMaNV(MaxLuong());
                	rd.readLine();
                case 4:
                	TKMaSP(MaxSP());
                	rd.readLine();
                case 5:
                    MenuChinh();
                    rd.readLine();
                    break;
                case 6:
                	System.exit(0);
                    break;
            }
        }
    }
    
    //SanPham
    public void HienThiSP()
    {
        System.out.println("\n\t===================================DANH SÁCH SẢN PHẨM CỦA CỬA HÀNG HIỆN TẠI====================================================================");
        System.out.println("\t||  Loại Sản Phẩm  ||   Mã    ||           Tên Sản Phẩm              ||   Thương Hiệu   ||        Giá        ||   Số Lượng   ||  Tình Trạng  ||");
        System.out.println("\t-----------------------------------------------------------------------------------------------------------------------------------------------");
        for (Interface_SanPham x : danhsach )
        {
            x.Hien();
        }
        System.out.println("\t=================================================================================================================================================");
    }
    public void SapHetSP()
    {
        System.out.println("\n\t===================================DANH SÁCH SẢN PHẨM SẮP BÁN HẾT CỦA CỬA HÀNG=================================================================");
        System.out.println("\t||  Loại Sản Phẩm  ||   Mã    ||           Tên Sản Phẩm              ||   Thương Hiệu   ||        Giá        ||   Số Lượng   ||  Tình Trạng  ||");
        System.out.println("\t-----------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < danhsach.size(); i++)
        {
            if ((danhsach.get(i).getsSoluong()) > 0 && (danhsach.get(i).getsSoluong()) <= 10)
            {
                danhsach.get(i).Hien();
            }
        }
        System.out.println("\t================================================================================================================================================");
    }
    public void HetSP()
    {
        System.out.println("\n\t===================================DANH SÁCH SẢN PHẨM ĐÃ BÁN HẾT CỦA CỬA HÀNG==================================================================");
        System.out.println("\t||  Loại Sản Phẩm  ||   Mã    ||           Tên Sản Phẩm              ||   Thương Hiệu   ||        Giá        ||   Số Lượng   ||  Tình Trạng  ||");
        System.out.println("\t-----------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < danhsach.size(); i++)
        {
            if ((danhsach.get(i).getsTrangThai()) == "Hết hàng")
            {
                danhsach.get(i).Hien();
            }
        }
        System.out.println("\t================================================================================================================================================");

    }
    public void ThongKeSP() throws IOException
    {
        while (true)
        {
        	int i = 0;
            while (i<=5)
            {
            	System.out.println();
            	i++;
            }
            System.out.println(" 				_____________________________________________ ");
            System.out.println();
            System.out.println("				|              THỐNG KÊ SẢN PHẨM              |");
            System.out.println();
            System.out.println("				|---------------------------------------------|");
            System.out.println();
            System.out.println("				|     1. Thống Kê Tất Cả Sản Phẩm             |");
            System.out.println();
            System.out.println("				|     2. Thống Kê Các Sản Phẩm Sắp Hết        |");
            System.out.println();
            System.out.println("				|     3. Thống Kê Các Sản Phẩm Đã Hết         |");
            System.out.println();
            System.out.println("				|     4. Quay Lại                             |");
            System.out.println();
            System.out.println("				|_____________________________________________|");
            System.out.println();
            System.out.println();
            System.out.print("  			   Chọn công việc bạn muốn thực hiện(1->4): ");
            int c = Integer.parseInt(sc.nextLine());
            switch (c)
            {
                case 1:
                    HienThiSP();
                    rd.readLine();
                    break;
                case 2:
                    SapHetSP();
                    rd.readLine();
                    break;
                case 3:
                    HetSP();
                    rd.readLine();
                    break;
                case 4:
                     MenuChinh();
                    break;
            }
        }
    }
    public void SuaSP() throws IOException
    {
        while (true)
        {
        	int i = 0;
            while (i<=5)
            {
            	System.out.println();
            	i++;
            }
            System.out.println("				 _______________________________________________ ");
            System.out.println();
            System.out.println("				|         CÁC HÌNH THỨC SỬA SẢN PHẨM            |");
            System.out.println();
            System.out.println("				|-----------------------------------------------|");
            System.out.println();
            System.out.println("				|            1. Sửa Giá Sản Phẩm                |");
            System.out.println();
            System.out.println("				|            2. Sửa Số Lượng Sản Phẩm           |");
            System.out.println();
            System.out.println("				|            3. Sửa Tên Sản Phẩm                |");
            System.out.println();
            System.out.println("				|            4. Sửa Thương Hiệu Sản Phẩm        |");
            System.out.println();
            System.out.println("				|            5. Quay Lại                        |");
            System.out.println();
            System.out.println("				|_______________________________________________|");
            System.out.println();
            System.out.println();
            System.out.print(" 				   Nhập công việc bạn muốn thực hiện : ");
            int chon = Integer.parseInt(sc.nextLine());
            switch (chon)
            {
                case 1:
                    String temp;
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println("				*-------------SỬA GIÁ BÁN SẢN PHẨM------------*");
                    do
                    {
                        System.out.println();
                        SuagiaSP();
                        GhiTepSP();
                        System.out.print("\n\t\tBạn có muốn sửa giá sản phẩm khác không (C/K)? ");
                        temp = sc.nextLine();
                    } while (temp == "c" || temp == "C");
                    break;
                case 2:
                    String b;
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println("				*-------------SỬA SỐ LƯỢNG SẢN PHẨM------------*");
                    do
                    {
                        System.out.println();
                        SuasoluongSP();
                        GhiTepSP();
                        System.out.print("\n\t\tBạn có muốn sửa số lượng sản phẩm khác không (C/K)? ");
                        b = sc.nextLine();
                    } while (b == "c" || b == "C");
                    break;
                case 3:
                    String c;
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println("				*--------------SỬA TÊN SẢN PHẨM----------------*");
                    do
                    {
                        System.out.println();
                        SuaTenSP();
                        GhiTepSP();
                        System.out.print("\n\t\tBạn có muốn sửa tên sản phẩm khác không (C/K)? ");
                        c = sc.nextLine();
                    } while (c == "c" || c == "C");
                    break;
                case 4:
                    String d;
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println("				*-----------SỬA THƯƠNG HIỆU SẢN PHẨM------------*");
                    do
                    {
                        System.out.println();
                        SuaThuongHieuSP();
                        GhiTepSP();
                        System.out.print("\n\t\tBạn có muốn sửa số lượng sản phẩm khác không (C/K)? ");
                        d = sc.nextLine();
                    } while (d == "c" || d == "C");
                    break;
                case 5:
                    MenuSP(); ; break;
            }
        }
    }
    public void DocTepSP()
    {
        try
        {
            Interface_SanPham sp;
            BufferedReader sr = new BufferedReader(new FileReader("sanpham.txt"));//Mở một tệp đang tồn tại
            String s;
            while ((s = sr.readLine()) != null)
            {
                if (s.length() > 0)
                {
                	int check=0;
                    String[] l = new String[7];
                    l = s.split("#");
                    if (l[0] == "TiVi") sp = new TiVi(l[0], l[1], l[2], l[3], Float.parseFloat(l[4]), Integer.parseInt(l[5]), l[6]);
                    else if (l[0] == "Tủ Lạnh") sp = new TuLanh(l[0], l[1], l[2], l[3], Float.parseFloat(l[4]), Integer.parseInt(l[5]), l[6]);
                    else sp = new DieuHoa(l[0], l[1], l[2], l[3], Float.parseFloat(l[4]), Integer.parseInt(l[5]), l[6]);
                    for (Interface_SanPham a : danhsach) if (a.getsMaSP().equals(sp.getsMaSP())) check = 1;
                    if (check==0) danhsach.add(sp);
                }
            }
            sr.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void GhiTepSP() throws IOException
    {
    	BufferedWriter sw = new BufferedWriter(new FileWriter("Interface_SanPham.txt"));
        for (Interface_SanPham x : danhsach)
    	{
            sw.write(x.toString());
            sw.write("\n");
        }
        sw.close();
    }
    public void Them1SP()
    {
        Interface_SanPham sp;
        System.out.print("\t\t Chọn loại sản phẩm(TiVi/Tủ Lạnh/Điều Hòa)(1->3): ");
        int a = Integer.parseInt(sc.nextLine());
        if (a == 1)
        {
            sp = new TiVi();
            sp.setsLoaiSP("TiVi");
        }
        else if (a == 2)
        {
            sp = new TuLanh();
            sp.setsLoaiSP("Tủ Lạnh");
        }
        else
        {
            sp = new DieuHoa();
            sp.setsLoaiSP("Điều Hòa");
        }
        boolean ok = false;
        System.out.print("\t\t Nhập mã sản phẩm: ");
        sp.setsMaSP(sc.nextLine());
        for (int i = 0; i < danhsach.size(); i++)
        {
            if (danhsach.get(i).getsMaSP().equals(sp.getsMaSP()))//So sánh 2 chuỗi có giống nhau hay không
            {
                ok = true;
                System.out.println("\n\t\tĐã tồn tại mã hóa đơn trong danh sách. Vui lòng nhập lại!");
            }
        }
        if (!ok)//Chưa tồn tại mã nếu biến Ok khác true thì sẽ thực hiện các lệnh 
        {
            sp.Nhap();
            danhsach.add(sp);
            System.out.println("\t\tSẢN PHẨM ÐÃ ÐƯỢC THÊM VÀO TRONG DANH SÁCH !");
        }
    }
    public void ThemSP() throws IOException
    {
        System.out.println("\t\tNhập số lượng sản phẩm cần thêm: ");
        int n = Integer.parseInt(sc.nextLine());
        System.out.println();
        for (int i = 0; i < n; i++)
        {
            System.out.printf("\n\t\tNhập thông tin sản phẩm thứ %d ", i + 1);
            System.out.println();
            Them1SP();
            GhiTepSP();
        }
    }
    public void SuaTenSP()
    {
        boolean ok = false;
        System.out.print("\n\t\t\tNhập mã sản phẩm cần sửa: ");
        String a = sc.nextLine();
        System.out.print("\t\t\tNhập tên mới : ");
        String b = sc.nextLine();
        for (int i = 0; i < danhsach.size(); i++)
        {
            if (danhsach.get(i).getsMaSP().equals(a))
            {
                ok = true;
                danhsach.get(i).setsTenSP(b);
            }
        }
        if (!ok)
            System.out.println("\n\t\tMã sản phẩm không tồn tại. Vui lòng quay lại sau!");
        else
        {
            System.out.println("\t\t Tên sản phẩm đã sửa thành công !\n");
            TKMaSP(a);
        }
    }
    public void SuaThuongHieuSP()
    {
        boolean ok = false;
        System.out.print("\n\t\t\tNhập mã sản phẩm cần sửa: ");
        String a = sc.nextLine();
        System.out.print("\t\t\tNhập tên thương hiệu mới: ");
        String b = sc.nextLine();
        for (int i = 0; i < danhsach.size(); i++)
        {
            if (danhsach.get(i).getsMaSP().equals(a))
            {
                ok = true;
                danhsach.get(i).setsThuongHieu(b);
            }
        }
        if (!ok)
            System.out.println("\n\t\tMã sản phẩm không tồn tại. Vui lòng quay lại sau!");
        else
        {
            System.out.println("\n\t\t   Thương hiệu sản phẩm đã sửa thành công !\n");
            TKMaSP(a);
        }
    }
    public void SuagiaSP()
    {
        boolean ok = false;
        System.out.print("\n\t\t\tNhập mã sản phẩm cần sửa: ");
        String a = sc.nextLine();
        System.out.print("\t\t\tNhập đơn giá mới : ");
        float b = Float.parseFloat(sc.nextLine());
        for (int i = 0; i < danhsach.size(); i++)
        {
            if (danhsach.get(i).getsMaSP().equals(a))
            {
                ok = true;
                danhsach.get(i).setsGiaban(b);
            }
        }

        if (!ok)
            System.out.println("\n\t\tMã sản phẩm không tồn tại. Vui lòng quay lại sau!");
        else
        {
            System.out.println("\t\t   Giá sản phẩm đã sửa thành công !\n");
            TKMaSP(a);
        }
    }
    public void SuasoluongSP()
    {
        boolean ok = false;
        System.out.print("\n\t\t\tNhập mã sản phẩm cần sửa: ");
        String a = sc.nextLine();
        System.out.print("\t\t\tNhập số lượng sản phẩm mới: ");
        int b = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < danhsach.size(); i++)
        {
            if (danhsach.get(i).getsMaSP().equals(a))
            {
                ok = true;
                danhsach.get(i).setsSoluong(b);
                if (danhsach.get(i).getsSoluong() > 0)
                {
                	danhsach.get(i).setsTrangThai("Còn");
                }
                else danhsach.get(i).setsTrangThai("Hết hàng ");
            }
        }
        if (!ok)
            System.out.println("\n\t\tMã sản phẩm không tồn tại. Vui lòng quay lại sau!");
        else
        {
            System.out.println("\t\t   Số lượng sản phẩm đã sửa thành công !\n");
            TKMaSP(a);
        }
    }
    public void XoaSP()
    {
        boolean ok = false;
        System.out.print("\t\t\tNhập mã sản phẩm cần xóa: ");
        String ma = sc.nextLine();
        for (int i = 0; i < danhsach.size(); i++)
        {
            if (danhsach.get(i).getsMaSP().equals(ma))
            {
                ok = true;//tim thay
                danhsach.remove(i);//RemoveAt Xoa tai vi tri i 
                System.out.printf("\n\t\t    SẢN PHẨM %s ĐÃ XÓA KHỎI DANH SÁCH ", ma);
                break;//thoat
            }
        }
        if (!ok)
            System.out.println("Không tồn tại mã " + ma);
    }
    public void TKMaSP(String ma)
    {
        boolean ok = false;
        System.out.println("\n\t===================================DANH SÁCH SẢN PHẨM TÌM THEO MÃ=============================================================================");
        System.out.println("\t||  Loại Sản Phẩm  ||   Mã    ||           Tên Sản Phẩm              ||   Thương Hiệu   ||        Giá        ||   Số Lượng   ||  Tình Trạng  ||");
        System.out.println("\t-----------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < danhsach.size(); i++)
        {
            if (danhsach.get(i).getsMaSP().equals(ma))
            {
                ok = true;
                danhsach.get(i).Hien();
                break;
            }
        }
        System.out.println("\t===============================================================================================================================================");
        if (!ok)
            System.out.println("Mã Sản Phẩm Không Tồn Tại");
    }
    public void TKTenSP(String b)
    {
        System.out.println("\n\t===================================DANH SÁCH SẢN PHẨM TÌM KIẾM THEO TÊN=======================================================================");
        System.out.println("\t||  Loại Sản Phẩm  ||   Mã    ||           Tên Sản Phẩm              ||   Thương Hiệu   ||        Giá        ||   Số Lượng   ||  Tình Trạng  ||");
        System.out.println("\t-----------------------------------------------------------------------------------------------------------------------------------------------");
        int j = 0;//khai báo biến kiểu nguyên có tên là j và khởi tạo giá trị là 0.
        for (int i = 0; i < danhsach.size(); i++)
        {
            if (danhsach.get(i).getsTenSP().startsWith(b)) //Str1.StartsWith(Str2):Kiểm tra xem chuỗi Str1 có bắt đầu bằng chuỗi Str2 không?
            {
                j = 1;
                danhsach.get(i).Hien();
            }
        }
        if (j == 0)
            System.out.printf("\t\tKhông tìm thấy tên sản phẩm %s ", b);
    }
    public void TKGiaSP()
    {
        System.out.println("\n\t\tMời Bạn Nhâp Khoảng Giá Cần Tìm Kiếm:");
        System.out.print("\t\tGiá Min: ");
        float min = Float.parseFloat(sc.nextLine());
        System.out.print("\t\tGiá Max: ");
        float max = Float.parseFloat(sc.nextLine());
        System.out.println("\n\t===================================DANH SÁCH SẢN PHẨM TÌM THEO GIÁ============================================================================");
        System.out.println("\t||  Loại Sản Phẩm  ||   Mã    ||           Tên Sản Phẩm              ||   Thương Hiệu   ||        Giá        ||   Số Lượng   ||  Tình Trạng  ||");
        System.out.println("\t-----------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < danhsach.size(); i++)
        {
            if (danhsach.get(i).getsGiaban() >= min && danhsach.get(i).getsGiaban() <= max)
            {
            	danhsach.get(i).Hien();
            }
        }
        System.out.println("\t================================================================================================================================================");
    }
    public String MaxSP()
    {
        DocTepSP();
        Interface_SanPham max = new TiVi("", "", "", "", 0, 0, "");
        for (Interface_SanPham a : danhsach)
        {
            if (a.compareTo(max)) max = a;
        }
        return max.getsMaSP();
    }

    // HÀM PHỤ
    public String LayTenInterface_SanPham(String MaSP) throws IOException
    {
        BufferedReader sr = new BufferedReader(new FileReader("Interface_SanPham.txt"));//Mở một tệp đang tồn tại
        String s;
        while ((s = sr.readLine()) != null)
        {
            String[] a = s.split("#");
            if (a[0] == MaSP) return a[1];
        }
        sr.close();
        return "";
    }
    public String LayGiaInterface_SanPham(String MaSP) throws IOException
    {
        BufferedReader sr = new BufferedReader(new FileReader("Interface_SanPham.txt"));//Mở một tệp đang tồn tại
        String s;
        while ((s = sr.readLine()) != null)
        {
            String[] a = s.split("#");
            if (a[0] == MaSP) return a[3];
        }
        sr.close();
        return "";
    }
    public String LaySLInterface_SanPham(String MaSP) throws IOException
    {
        BufferedReader sr = new BufferedReader(new FileReader("Interface_SanPham.txt"));//Mở một tệp đang tồn tại
        String s;
        while ((s = sr.readLine()) != null)
        {
            String[] a = s.split("#");
            if (a[0] == MaSP) return a[4];
        }
        sr.close();
        return "";
    }
}
