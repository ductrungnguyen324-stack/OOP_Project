import java.util.*;
import java.io.*;
//import java.text.SimpleDateFormat;

// =============== INTERFACE ===============
interface IQuanLy<I>
{
    void Them(I Object);
    void Xoa(String Ma);
    void Sua(String Ma, I Object);
    List<I> TimKiem(String TuKhoa);
    void XemDanhSach();
    void DocFile(String InputFile);
    void GhiFile(String OutputFile);
}


// =============== SẢN PHẨM ===============
class SanPham
{
    private String MaSP;
    private String TenSP;
    private String LoaiSP;
    private double GiaBan;
    private String NhaSanXuat;
    private static int SoLuongSP = 0;

    public SanPham()
    {
        SoLuongSP++;
    }

    public SanPham(String MaSP, String TenSP, String LoaiSP, double GiaBan, String NhaSanXuat)
    {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.LoaiSP = LoaiSP;
        this.GiaBan = GiaBan;
        this.NhaSanXuat = NhaSanXuat;
        SoLuongSP++;
    }

    //Get
    public String getMaSP() { return MaSP; }
    public String getTenSP() { return TenSP; }
    public String getLoaiSP() { return LoaiSP; }
    public double getGiaBan() { return GiaBan; }
    public String getNhaSanXuat() { return NhaSanXuat; }
    public static int getSoLuongSP() { return SoLuongSP; }

    //Set
    public void setMaSP(String MaSP) { this.MaSP = MaSP; }
    public void setTenSP(String TenSP) { this.TenSP = TenSP; }
    public void setLoaiSP(String LoaiSP) { this.LoaiSP = LoaiSP; }
    public void setGiaBan(double GiaBan) { this.GiaBan = GiaBan; }
    public void setNhaSanXuat(String NhaSanXuat) { this.NhaSanXuat = NhaSanXuat; }

    public void HienThiThongTin()
    {
        System.out.printf("%-15s %-30s %-15s %-,12.0f %-20s %n", MaSP, TenSP, LoaiSP, GiaBan, NhaSanXuat);
    }

    public void HienThiChiTiet()
    {
        System.out.printf("%-15s %-30s %-15s %-,12.0f %-20s %n", MaSP, TenSP, LoaiSP, GiaBan, NhaSanXuat);
    }
}


class ButBi extends SanPham
{
    private String MauMuc;
    private double KichThuocDauBut;

    public ButBi(String MaSP, String TenSP, String LoaiSP, double GiaBan, String NhaSanXuat, String MauMuc, double KichThuocDauBut)
    {
        super(MaSP, TenSP, LoaiSP, GiaBan, NhaSanXuat);
        this.MauMuc = MauMuc;
        this.KichThuocDauBut = KichThuocDauBut;
    }

    public String getMauMuc() { return MauMuc;}
    public void setMauMuc(String MauMuc) { this.MauMuc = MauMuc;}
    public double getKichThuocDauBut() { return KichThuocDauBut;}
    public void setKichThuocDauBut(double KTDB) { KichThuocDauBut = KTDB;}

    @Override
    public void HienThiChiTiet()
    {
        super.HienThiChiTiet();
        System.out.printf("Chi tiet but bi - Mau muc : %s, Kich thuoc dau but (mm) : %.2f %n", MauMuc, KichThuocDauBut);
    }
}

class ButChi extends SanPham
{
    private String LoaiBut;
    private String NgoiBut;

    public ButChi(String MaSP, String TenSP, String LoaiSP, double GiaBan, String NhaSanXuat, String LoaiBut, String NgoiBut)
    {
        super(MaSP, TenSP, LoaiSP, GiaBan, NhaSanXuat);
        this.LoaiBut = LoaiBut;
        this.NgoiBut = NgoiBut;
    }

    public String getLoaiBut() { return LoaiBut;}
    public void setLoaiBut(String LoaiBut) { this.LoaiBut = LoaiBut;}
    public String getNgoiBut() { return NgoiBut;}
    public void setNgoiBut(String NgoiBut) { this.NgoiBut = NgoiBut;}

    @Override
    public void HienThiChiTiet()
    {
        super.HienThiChiTiet();
        System.out.printf("Chi tiet but chi - Loai but : %s, Ngoi but : %s %n", LoaiBut, NgoiBut);
    }
}

class Giay extends SanPham
{
    private String LoaiGiay;

    public Giay(String MaSP, String TenSP, String LoaiSP, double GiaBan, String NhaSanXuat, String LoaiGiay)
    {
        super(MaSP, TenSP, LoaiSP, GiaBan, NhaSanXuat);
        this.LoaiGiay = LoaiGiay;
    }

    public String getLoaiGiay() { return LoaiGiay;}
    public void setLoaiGiay(String LoaiGiay) { this.LoaiGiay = LoaiGiay;}

    @Override
    public void HienThiChiTiet()
    {
        super.HienThiChiTiet();
        System.out.printf("Chi tiet giay - Loai giay : %s %n", LoaiGiay);
    }
}

class SoGhi extends SanPham
{
    private int SoTrang;
    private String LoaiBia;

    public SoGhi(String MaSP, String TenSP, String LoaiSP, double GiaBan, String NhaSanXuat, int SoTrang, String LoaiBia)
    {
        super(MaSP, TenSP, LoaiSP, GiaBan, NhaSanXuat);
        this.SoTrang = SoTrang;
        this.LoaiBia = LoaiBia;
    }

    public int getSoTrang() { return SoTrang;}
    public void setSoTrang(int SoTrang) { this.SoTrang = SoTrang;}
    public String getLoaiBia() { return LoaiBia;}
    public void setLoaiBia(String LoaiBia) { this.LoaiBia = LoaiBia;}

    @Override
    public void HienThiChiTiet()
    {
        super.HienThiChiTiet();
        System.out.printf("Chi tiet so ghi - So trang : %i, Loai bia : %s %n", SoTrang, LoaiBia);
    }
}

// =============== QUẢN LÝ SẢN PHẨM ===============
class QuanLySanPham implements IQuanLy<SanPham>
{
    private List<SanPham> DanhSach;
    private static QuanLySanPham instance;

    public QuanLySanPham()
    {
        DanhSach = new ArrayList<>();
    }

    public static QuanLySanPham getInstance() 
    {
        if (instance == null) 
        {
            instance = new QuanLySanPham();
        }
        return instance;
    }

    @Override
    public void Them(SanPham SP)
    {
        DanhSach.add(SP);
        System.out.println("Da them san pham : " + SP.getTenSP() + "!");
    }

    @Override
    public void Xoa(String MaSP)
    {
        boolean found = DanhSach.removeIf(SP -> SP.getMaSP().equals(MaSP));
        if (found)
            System.out.println("Da xoa san pham co ma la " + MaSP);
        else
            System.out.println("Khong tim thay san pham co ma la " + MaSP);
    }

    @Override
    public void Sua(String MaSP, SanPham New_SP)
    {
        for (int i = 0; i < DanhSach.size(); i++)
        {
            if (DanhSach.get(i).getMaSP().equals(MaSP))
            {
                DanhSach.set(i, New_SP);
                System.out.println("Da cap nhat san pham co ma la " + MaSP);
                return;
            }
            else
                System.out.println("Khong tim thay san pham co ma la " + MaSP);
        }
    }

    @Override
    public List<SanPham> TimKiem(String TuKhoa)
    {
        List<SanPham> Kq = new ArrayList<>();
        for (SanPham SP : DanhSach)
        {
            if (SP.getMaSP().toLowerCase().contains(TuKhoa.toLowerCase()) || SP.getTenSP().toLowerCase().contains(TuKhoa.toLowerCase()) ||
                SP.getLoaiSP().toLowerCase().contains(TuKhoa.toLowerCase()))
                Kq.add(SP);
            else
                System.out.println("Khong tim thay san pham nao");
        }
        return Kq;
    }

    @Override
    public void XemDanhSach()
    {
        System.out.println("=============================================================================================");
        System.out.println("                                   DANH SACH SAN PHAM                                        ");
        System.out.println("=============================================================================================");
        System.out.printf("%-15s %-30s %-15s %-12s %-20s %n", "Ma san pham", "Ten san pham", "Loai san pham", "Gia ban", "Nha san xuat");
        System.out.println("=============================================================================================");
        
        for (SanPham SP : DanhSach)
            SP.HienThiThongTin();
    
        System.out.println("=============================================================================================");
        System.out.println("Tong so san pham : " + DanhSach.size());
    }

    public SanPham TimTheoMa(String MaSP)
    {
        for (SanPham SP : DanhSach)
            if (SP.getMaSP().equals(MaSP)) return SP;
        return null;
    }

    @Override
    public void DocFile(String InputFile)
    {
        try (BufferedReader input = new BufferedReader(new FileReader(InputFile)))
        {
            String line;
            while ((line = input.readLine()) != null)
            {
                String[] data = line.split(",");
                if (data.length < 5) continue;

                String maSP = data[0];
                String tenSP = data[1];
                String loaiSP = data[2];
                double giaban = Double.parseDouble(data[3]);
                String nhasanxuat = data[4];

                SanPham SP = null; //Đối tượng chung

                //Sử dụng loaiSP (data[2]) để phân loại sản phẩm
                switch (loaiSP.toUpperCase()) 
                {
                    case "BUT BI":
                        if (data.length == 7)
                        {
                            String maumuc = data[5];
                            double kichthuocdaubut = Double.parseDouble(data[6]);
                            SP = new ButBi(maSP, tenSP, loaiSP, giaban, nhasanxuat, maumuc, kichthuocdaubut);
                        }
                        break;
                    
                    case "BUT CHI":
                        if (data.length == 7)
                        {
                            String loaibut = data[5];
                            String ngoibut = data[6];
                            SP = new ButChi(maSP, tenSP, loaiSP, giaban, nhasanxuat, loaibut, ngoibut);
                        }
                        break;

                    case "GIAY":
                        if (data.length == 6)
                        {
                            String loaigiay = data[5];
                            SP = new Giay(maSP, tenSP, loaiSP, giaban, nhasanxuat, loaigiay);
                        }
                        break;

                    case "SO GHI":
                        if (data.length == 7)
                        {
                            int sotrang = Integer.parseInt(data[5]);
                            String loaibia = data[6];
                            SP = new SoGhi(maSP, tenSP, loaiSP, giaban, nhasanxuat, sotrang, loaibia);
                        }
                        break;

                    default:
                        SP = new SanPham(maSP, tenSP, loaiSP, giaban, nhasanxuat);
                        break;
                }

                if (SP != null) 
                    DanhSach.add(SP);
                
            }
            System.out.println("Da doc file " + InputFile);
        }
        catch (IOException e) 
        {
            System.out.println("Loi doc file : " + e.getMessage());
        }
    }

    @Override
    public void GhiFile(String OutputFile)
    {
        try (BufferedWriter output = new BufferedWriter(new FileWriter(OutputFile)))
        {
            output.write("============================================================================================="); output.newLine();
            output.write("                                   DANH SACH SAN PHAM                                        "); output.newLine();
            output.write("============================================================================================="); output.newLine();
            
            String HeaderLine = String.format("%-15s %-30s %-15s %-12s %-20s", "Ma san pham", "Ten san pham", "Loai san pham", "Gia ban", "Nha san xuat");
            output.write(HeaderLine);
            output.newLine();

            for (SanPham SP : DanhSach)
            {
                output.write(String.format("%-15s %-30s %-15s %-12s %-20s", SP.getMaSP(), SP.getTenSP(), SP.getLoaiSP(), SP.getGiaBan(), SP.getNhaSanXuat()));
                output.newLine();
            }

            output.write("============================================================================================="); output.newLine();
            output.write("Tong so san pham : " + DanhSach.size());
        }
        catch (IOException e) 
        {
            System.out.println("Loi doc file : " + e.getMessage());
        }
    }
}



// =============== MAIN ===============
public class OOP_Project 
{
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        //Đọc file
        QuanLySanPham QLSP = QuanLySanPham.getInstance();
        QLSP.DocFile("sanpham.txt");

        //Menu chính
        do 
        {
            ClearScreen();
            MainMenu();
            System.out.print("Chon chuc nang : ");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) 
            {
                case 1: 
                case 2:
                case 3: MenuSanPham(); break;
            
                default: System.out.println("Lua chon khong hop le."); break;
            }
            Pause();
        } while (true);


    }

    // =============== HÀM TẠM DỪNG CHƯƠNG TRÌNH ===============
    private static void Pause()
    {
        System.out.print("Nhap ENTER de tiep tuc...");
        sc.nextLine();
    }

    // =============== HÀM XÓA TERMINAL ===============
    private static void ClearScreen()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // =============== HÀM HIỂN THỊ MENU CHÍNH ===============
    private static void MainMenu()
    {
        System.out.println("=============================================================================================");
        System.out.println("                       HE THONG QUAN LY CUA HANG VAN PHONG PHAM                              ");
        System.out.println("=============================================================================================");
        System.out.println("      1. Quan ly Khach hang");
        System.out.println("      2. Quan ly Nhan vien");
        System.out.println("      3. Quan ly San pham");
        System.out.println("      4. Quan ly Hoa don");
        System.out.println("      5. Thong ke");
        System.out.println("=============================================================================================");
    }

    // =============== HÀM HIỂN THỊ MENU QUẢN LÝ SẢN PHẨM ===============
    private static void MenuSanPham()
    {
        QuanLySanPham QLSP = QuanLySanPham.getInstance();
        do 
        {
            ClearScreen();
            QLSP.XemDanhSach();
            System.out.print("\n\n\n");
            System.out.println("=============================================================================================");
            System.out.println("                                    QUAN LY SAN PHAM                                         ");
            System.out.println("=============================================================================================");
            System.out.println("      1. Them san pham moi");
            System.out.println("      2. Xoa san pham");
            System.out.println("      3. Sua thong tin san pham");
            System.out.println("      4. Xem chi tiet san pham");
            System.out.println("      5. Luu danh sach san pham vao file");
            System.out.println("      0. Quay lai Menu Chinh");
            System.out.println("=============================================================================================");

            System.out.print("Chon chuc nang : ");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) 
            {
                case 1:
                    System.out.print("Ma SP: "); String ma = sc.nextLine().trim();
                    System.out.print("Ten SP: "); String ten = sc.nextLine().trim();
                    System.out.print("Loai SP: "); String loai = sc.nextLine().trim();
                    System.out.print("Gia ban : "); double gia = sc.nextDouble();
                    sc.nextLine(); //Xóa khoảng trắng thừa sau khi nhập giá bán
                    System.out.print("Nha san xuat: "); String nsx = sc.nextLine().trim();

                    if (loai.equals("But bi"))
                    {
                        System.out.print("Mau muc : "); String mau = sc.nextLine().trim();
                        System.out.print("Kich thuoc dau but : "); double ktdb = sc.nextDouble();
                        QLSP.Them(new ButBi(ma, ten, loai, gia, nsx, mau, ktdb));
                    }
                    else if (loai.equals("But chi"))
                    {
                        System.out.print("Loai but : "); String loaibut = sc.nextLine().trim();
                        System.out.print("Ngoi but : "); String ngoibut = sc.nextLine().trim();
                        QLSP.Them(new ButChi(ma, ten, loai, gia, nsx, loaibut, ngoibut));
                    }
                    else if (loai.equals("Giay"))
                    {
                        System.out.print("Loai giay : "); String loaigiay = sc.nextLine().trim();
                        QLSP.Them(new Giay(ma, ten, loai, gia, nsx, loaigiay));
                    }
                    else if (loai.equals("So ghi"))
                    {
                        System.out.print("So trang : "); int sotrang = sc.nextInt();
                        System.out.print("Ngoi but : "); String loaibia = sc.nextLine().trim();
                        QLSP.Them(new SoGhi(ma, ten, loai, gia, nsx, sotrang, loaibia));
                    }
                    else
                        QLSP.Them(new SanPham(ma, ten, loai, gia, nsx));
                    break;

                case 2:
                    System.out.print("Nhap ma cua san pham : "); String maSP = sc.nextLine().trim();
                    QLSP.Xoa(maSP);
                    break;

                case 3:
                    System.out.print("Nhap ma san pham muon sua : "); String maSP_Sua = sc.nextLine().trim();
                    SanPham SP_Sua = QLSP.TimTheoMa(maSP_Sua);

                    System.out.print("Ten SP: "); String tenMoi = sc.nextLine().trim();
                    System.out.print("Loai SP: "); String loaiMoi = sc.nextLine().trim();
                    System.out.print("Gia ban : "); double giaMoi = sc.nextDouble();
                    sc.nextLine(); //Xóa khoảng trắng thừa sau khi nhập giá bán
                    System.out.print("Nha san xuat: "); String nsxMoi = sc.nextLine().trim();

                    if (SP_Sua.getLoaiSP().equals("But bi"))
                    {
                        System.out.print("Mau muc : "); String mauMoi = sc.nextLine().trim();
                        System.out.print("Kich thuoc dau but : "); double ktdbMoi = sc.nextDouble();
                        QLSP.Sua(maSP_Sua, new ButBi(maSP_Sua, tenMoi, loaiMoi, giaMoi, nsxMoi, mauMoi, ktdbMoi));
                        break;
                    }
                    else if (SP_Sua.getLoaiSP().equals("But chi"))
                    {
                        System.out.print("Loai but : "); String loaibutMoi = sc.nextLine().trim();
                        System.out.print("Ngoi but : "); String ngoibutMoi = sc.nextLine().trim();
                        QLSP.Sua(maSP_Sua, new ButChi(maSP_Sua, tenMoi, loaiMoi, giaMoi, nsxMoi, loaibutMoi, ngoibutMoi));
                        break;
                    }
                    else if (SP_Sua.getLoaiSP().equals("Giay"))
                    {
                        System.out.print("Loai giay : "); String loaigiayMoi = sc.nextLine().trim();
                        QLSP.Sua(maSP_Sua, new Giay(maSP_Sua, tenMoi, loaiMoi, giaMoi, nsxMoi, loaigiayMoi));
                        break;
                    }
                    else if (SP_Sua.getLoaiSP().equals("So ghi"))
                    {
                        System.out.print("So trang : "); int sotrangMoi = sc.nextInt();
                        System.out.print("Ngoi but : "); String loaibiaMoi = sc.nextLine().trim();
                        QLSP.Sua(maSP_Sua, new SoGhi(maSP_Sua, tenMoi, loaiMoi, giaMoi, nsxMoi, sotrangMoi, loaibiaMoi));
                        break;
                    }
                    else
                        QLSP.Sua(maSP_Sua, new SanPham(maSP_Sua, tenMoi, loaiMoi, giaMoi, nsxMoi));
                        break;

                case 4:
                    System.out.print("Nhap ma san pham : "); String maSP_Xem = sc.nextLine().trim();
                    SanPham SP_Xem = QLSP.TimTheoMa(maSP_Xem);

                    System.out.println("\n----- CHI TIET SAN PHAM -----");
                    System.out.printf("%-15s %-30s %-15s %-12s %-20s %n", "Ma san pham", "Ten san pham", "Loai san pham", "Gia ban", "Nha san xuat");
                    SP_Xem.HienThiChiTiet();
                    break;

                case 5:
                    QLSP.GhiFile("danhsach.txt"); 
                    break;

                case 0:
                    return;
                default:
                    System.out.println("Lua chon khong hop le.");
                    break;
            }

            Pause();
        } while (true);
    }
}
