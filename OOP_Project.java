import java.util.*;
import java.io.*;
//import java.text.SimpleDateFormat;

// =============== INTERFACE ===============
interface IQuanLy<I>
{
    void Them(I Object);
    void Xoa(String Ma);
    void Sua(Scanner sc);
    List<I> TimKiem(String TuKhoa);
    void XemDanhSach();
    void DocFile(String InputFile);
    void GhiFile(String OutputFile);
}


// =============== CON NGƯỜI ===============
abstract class ConNguoi {
    private String HoTen;
    private String SDT;
    private String DiaChi;

    public ConNguoi() {}
    public ConNguoi(String HoTen, String SDT, String DiaChi) {
        this.HoTen = HoTen;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
    }
    public String getHoTen() { return HoTen;}
    public void setHoTen(String HoTen) { this.HoTen = HoTen;}
    public String getSDT() { return SDT;}
    public void setSDT(String SDT) { this.SDT = SDT;}
    public String getDiaChi() { return DiaChi;}
    public void setDiaChi(String DiaChi) { this.DiaChi = DiaChi;}
    public abstract void HienThiThongTin();
}


// =============== NHÂN VIÊN ===============
class NhanVien extends ConNguoi {
    private String MaNV;
    private String ChucVu;
    private double Luong;
    private static int SoLuongNV = 0;

    NhanVien() {
        SoLuongNV++;
    }
    NhanVien(String MaNV, String HoTen, String SDT, String DiaChi, String ChucVu, double Luong){
        super(HoTen, SDT, DiaChi);
        this.MaNV= MaNV;
        this.ChucVu= ChucVu;
        this.Luong= Luong;
        SoLuongNV++;
    }
    public String getMaNV(){ return MaNV;}
    public void setMaNV(String MaNV){ this.MaNV= MaNV; }
    public String getChucVu(){ return ChucVu;}
    public void setChucVu(String ChucVu){ this.ChucVu= ChucVu; }
    public double getLuong(){ return Luong;}
    public void setLuong(double Luong){ this.Luong= Luong; }
    public static int getSoLuongNV(){ return SoLuongNV; }

    @Override
    public void HienThiThongTin(){
        System.out.printf("%-15s %-20s %-20s %-50s %-25s %-,15.0f %n", MaNV, getHoTen(), getSDT(), getDiaChi(), ChucVu, Luong);
    }
}

// =============== KHÁCH HÀNG ===============
class KhachHang extends ConNguoi {
    private String MaKH;
    private String LoaiKH;
    private double DiemTichLuy;
    private static int SoLuongKH=0;
    
    public KhachHang(){ SoLuongKH++;}

    public KhachHang(String MaKH, String LoaiKH, double DiemTichLuy, String HoTen, String SDT, String DiaChi){
        super(HoTen, SDT, DiaChi);
        this.MaKH= MaKH;
        this.DiemTichLuy= DiemTichLuy;
        this.LoaiKH= LoaiKH;
        SoLuongKH++;
    }

    public String getMaKH(){ return MaKH;}
    public void setMaKH(String MaKH){ this.MaKH= MaKH;}
    public String getLoaiKH(){ return LoaiKH;}
    public void setLoaiKH(String LoaiKH){ this.LoaiKH= LoaiKH;}
    public double getDiemTichLuy(){ return DiemTichLuy;}
    public void setDiemTichLuy(double DiemTichLuy){ this.DiemTichLuy= DiemTichLuy;}
    public static int getSoLuongKH(){ return SoLuongKH;}

    @Override
    public void HienThiThongTin(){
        System.out.printf("%-15s %-20s %-20s %-50s %-10s %-,15.0f %n", MaKH, getHoTen(), getSDT(), getDiaChi(), LoaiKH, DiemTichLuy);
    }
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

    public ButBi() {}

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

    public ButChi() {}

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

    public Giay() {}

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

    public SoGhi() {}

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
    private List<SanPham> DSSanPham;
    private static QuanLySanPham instance;

    public QuanLySanPham()
    {
        DSSanPham = new ArrayList<>();
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
        DSSanPham.add(SP);
        System.out.println("Da them san pham : " + SP.getTenSP() + "!");
    }

    @Override
    public void Xoa(String MaSP)
    {
        boolean found = DSSanPham.removeIf(SP -> SP.getMaSP().equals(MaSP));
        if (found)
            System.out.println("Da xoa san pham co ma la " + MaSP);
        else
            System.out.println("Khong tim thay san pham co ma la " + MaSP);
    }

    @Override
    public void Sua(Scanner sc)
    {
        QuanLySanPham QLSP = getInstance();
        System.out.print("Nhap ma san pham muon sua : "); String maSP_Sua = sc.nextLine().trim();
        SanPham SP_Sua = QLSP.TimTheoMa(maSP_Sua);
        int choice_Sua;
        ButBi SP_ButBi = new ButBi();
        ButChi SP_ButChi = new ButChi();
        Giay SP_Giay = new Giay();
        SoGhi SP_SoGhi = new SoGhi();

        do
        {
            System.out.println("1. Ten san pham");
            System.out.println("2. Loai san pham");
            System.out.println("3. Gia ban");
            System.out.println("4. Nha san xuat");
            if (SP_Sua instanceof ButBi) 
            {
                SP_ButBi = (ButBi) SP_Sua;
                System.out.println("5. Mau muc");
                System.out.println("6. Mau muc");
            }
            else if (SP_Sua instanceof ButChi)
            {
                SP_ButChi = (ButChi) SP_Sua;
                System.out.println("5. Loai but");
                System.out.println("6. Ngoi but");
            }
            else if (SP_Sua instanceof Giay)
            {
                SP_Giay = (Giay) SP_Sua;
                System.out.println("5. Loai giay");
            }
            else if (SP_Sua instanceof SoGhi)
            {
                SP_SoGhi = (SoGhi) SP_Sua;
                System.out.println("5. So Trang");
                System.out.println("6. Loai bia");
            }
            System.out.println("0. Thoat");
            System.out.println("--------------------");
            System.out.println("Chon muc muon sua : ");
            choice_Sua = sc.nextInt();
            sc.nextLine();

            switch (choice_Sua) 
            {
                case 1:
                    System.out.print("Nhap lai ten san pham : "); 
                    SP_Sua.setTenSP(sc.nextLine().trim());
                    break;
                case 2:
                    System.out.print("Nhap lai loai san pham : "); 
                    SP_Sua.setLoaiSP(sc.nextLine().trim());
                    break;
                case 3:
                    System.out.print("Nhap lai gia ban : "); 
                    SP_Sua.setGiaBan(sc.nextDouble());
                    break;
                case 4:
                    System.out.print("Nhap lai nha san xuat : "); 
                    SP_Sua.setNhaSanXuat(sc.nextLine().trim());
                    break;
                case 5:
                    if (SP_Sua instanceof ButBi) 
                    {
                        System.out.print("Nhap lai mau muc :"); 
                        SP_ButBi.setMauMuc(sc.nextLine().trim());
                    }
                    else if (SP_Sua instanceof ButChi)
                    {
                        System.out.print("Nhap lai loai but :"); 
                        SP_ButChi.setLoaiBut(sc.nextLine().trim());
                    }
                    else if (SP_Sua instanceof Giay)
                    {
                        System.out.print("Nhap lai loai giay :"); 
                        SP_Giay.setLoaiGiay(sc.nextLine().trim());
                    }
                    else if (SP_Sua instanceof SoGhi)
                    {
                        System.out.print("Nhap lai so trang :"); 
                        SP_SoGhi.setSoTrang(sc.nextInt());
                    }
                    break;
                case 6:
                    if (SP_Sua instanceof ButBi) 
                    {
                        System.out.print("Nhap lai kich thuoc dau but :"); 
                        SP_ButBi.setKichThuocDauBut(sc.nextDouble());
                    }
                    else if (SP_Sua instanceof ButChi)
                    {
                        System.out.print("Nhap lai ngoi but :"); 
                        SP_ButChi.setNgoiBut(sc.nextLine().trim());
                    }
                    else if (SP_Sua instanceof SoGhi)
                    {
                        System.out.print("Nhap lai loai bia :"); 
                        SP_SoGhi.setLoaiBia(sc.nextLine().trim());
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Khong hop le.");
                    break;
            } 
        } while (choice_Sua != 0);
    }

    @Override
    public List<SanPham> TimKiem(String TuKhoa)
    {
        List<SanPham> Kq = new ArrayList<>();
        boolean found = false;
        for (SanPham SP : DSSanPham)
        {
            if (SP.getMaSP().toLowerCase().contains(TuKhoa.toLowerCase()) || SP.getTenSP().toLowerCase().contains(TuKhoa.toLowerCase()) ||
                SP.getLoaiSP().toLowerCase().contains(TuKhoa.toLowerCase()))
            {
                Kq.add(SP);
                found = true;
            } 
        }
        if (!found) System.out.println("Khong tim thay san pham nao");
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
        
        for (SanPham SP : DSSanPham)
            SP.HienThiThongTin();
    
        System.out.println("=============================================================================================");
        System.out.println("Tong so san pham : " + DSSanPham.size());
    }

    public SanPham TimTheoMa(String MaSP)
    {
        for (SanPham SP : DSSanPham)
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
                String[] data = line.split(";");
                if (data.length < 5) continue;

                String maSP = data[0].trim();
                String tenSP = data[1].trim();
                String loaiSP = data[2].trim();
                double giaban = Double.parseDouble(data[3].trim());
                String nhasanxuat = data[4].trim();

                SanPham SP = null; //Đối tượng chung

                //Sử dụng loaiSP (data[2]) để phân loại sản phẩm
                switch (loaiSP.toUpperCase()) 
                {
                    case "BUT BI":
                        if (data.length == 7)
                        {
                            String maumuc = data[5].trim();
                            double kichthuocdaubut = Double.parseDouble(data[6].trim());
                            SP = new ButBi(maSP, tenSP, loaiSP, giaban, nhasanxuat, maumuc, kichthuocdaubut);
                        }
                        break;
                    
                    case "BUT CHI":
                        if (data.length == 7)
                        {
                            String loaibut = data[5].trim();
                            String ngoibut = data[6].trim();
                            SP = new ButChi(maSP, tenSP, loaiSP, giaban, nhasanxuat, loaibut, ngoibut);
                        }
                        break;

                    case "GIAY":
                        if (data.length == 6)
                        {
                            String loaigiay = data[5].trim();
                            SP = new Giay(maSP, tenSP, loaiSP, giaban, nhasanxuat, loaigiay);
                        }
                        break;

                    case "SO GHI":
                        if (data.length == 7)
                        {
                            int sotrang = Integer.parseInt(data[5].trim());
                            String loaibia = data[6].trim();
                            SP = new SoGhi(maSP, tenSP, loaiSP, giaban, nhasanxuat, sotrang, loaibia);
                        }
                        break;

                    default:
                        SP = new SanPham(maSP, tenSP, loaiSP, giaban, nhasanxuat);
                        break;
                }

                if (SP != null) 
                    DSSanPham.add(SP);
                
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

            for (SanPham SP : DSSanPham)
            {
                output.write(String.format("%-15s %-30s %-15s %-12s %-20s", SP.getMaSP(), SP.getTenSP(), SP.getLoaiSP(), SP.getGiaBan(), SP.getNhaSanXuat()));
                output.newLine();
            }

            output.write("============================================================================================="); output.newLine();
            output.write("Tong so san pham : " + DSSanPham.size());
        }
        catch (IOException e) 
        {
            System.out.println("Loi ghi file : " + e.getMessage());
        }
    }
}


// =============== QUẢN LÝ NHÂN VIÊN ===============
class QuanLyNhanVien implements IQuanLy<NhanVien>
{
    private List<NhanVien> DSNhanVien;
    private static QuanLyNhanVien instance;

    public QuanLyNhanVien()
    {
        DSNhanVien = new ArrayList<>();
    }

    public static QuanLyNhanVien getInstance()
    {
        if (instance == null) 
        {
            instance = new QuanLyNhanVien();
        }
        return instance;
    }

    @Override
    public void Them(NhanVien NV)
    {
        DSNhanVien.add(NV);
        System.out.println("Da them nhan vien : " + NV.getHoTen() + "!");
    }

    @Override
    public void Sua(Scanner sc){
        System.out.print(" Nhap Ma NV can sua: ");
        String Ma= sc.nextLine();
        boolean ketqua= false;
        for (NhanVien nv: DSNhanVien){
            if (nv.getMaNV().equalsIgnoreCase(Ma)){
                ketqua= true;
                int Choice;
                do {
                    System.out.println(" Chon muc can sua: ");
                    System.out.println(" 1. Ho Ten");
                    System.out.println(" 2. SDT");
                    System.out.println(" 3. Dia Chi");
                    System.out.println(" 4. Chuc Vu");
                    System.out.println(" 5. Luong");
                    System.out.print(" 6. Thoat ");
                    Choice= sc.nextInt();
                    sc.nextLine();
                    switch (Choice){
                        case 1:
                            System.out.print(" Nhap lai Ho Ten: ");
                            nv.setHoTen(sc.nextLine());
                            break;
                        case 2:
                            System.out.print(" Nhap lai SDT: ");
                            nv.setSDT(sc.nextLine());
                            break;
                        case 3:
                            System.out.print(" Nhap lai Dia Chi: ");
                            nv.setDiaChi(sc.nextLine());
                            break;
                        case 4:
                            System.out.println(" Nhap lai Chuc Vu: ");
                            nv.setChucVu(sc.nextLine());
                            break;
                        case 5:
                            System.out.print(" Nhap lai Luong: ");
                            nv.setLuong(Double.parseDouble(sc.nextLine()));
                            break;
                        case 6:
                            System.out.print(" Thoat chinh sua");
                            break;
                        default:
                            System.out.print(" Khong hop le");
                    }
                } while (Choice!=6);
            }
        }
        if (!ketqua){ System.out.print(" Khong tim thay ma");}
    }

    @Override
    public void Xoa(String MaNV)
    {
        boolean found = DSNhanVien.removeIf(SP -> SP.getMaNV().equals(MaNV));
        if (found)
            System.out.println("Da xoa san pham co ma la " + MaNV);
        else
            System.out.println("Khong tim thay san pham co ma la " + MaNV);
    }

    @Override
    public List<NhanVien> TimKiem(String TuKhoa)
    {
        List<NhanVien> Kq = new ArrayList<>();
        boolean found = false;
        for (NhanVien NV : DSNhanVien)
        {
            if (NV.getMaNV().toLowerCase().contains(TuKhoa.toLowerCase()) || NV.getHoTen().toLowerCase().contains(TuKhoa.toLowerCase()) ||
                NV.getChucVu().toLowerCase().contains(TuKhoa.toLowerCase()))
            {
                Kq.add(NV);
                found = true;
            } 
        }
        if (!found) System.out.println("Khong tim thay nhan vien nao");
        return Kq;
    }

    @Override
    public void XemDanhSach()
    {
        System.out.println("================================================================================================================================================");
        System.out.println("                                                            DANH SACH NHAN VIEN                                                                 ");
        System.out.println("================================================================================================================================================");
        System.out.printf("%-15s %-20s %-20s %-50s %-25s %-15s %n", "Ma nhan vien", "Ho ten", "So dien thoai", "Dia chi", "Chuc vu", "Luong");
        System.out.println("================================================================================================================================================");
        
        for (NhanVien NV : DSNhanVien)
            NV.HienThiThongTin();
    
        System.out.println("================================================================================================================================================");
        System.out.println("Tong so nhan vien : " + DSNhanVien.size());
    }

    public NhanVien TimTheoMa(String MaNV)
    {
        for (NhanVien NV : DSNhanVien)
            if (NV.getMaNV().equals(MaNV)) return NV;
        return null;
    }

    @Override
    public void DocFile(String InputFile){
        try (BufferedReader br = new BufferedReader(new FileReader(InputFile))){
            String Line;
            while ((Line= br.readLine())!= null){
                String[] data= Line.split(";");
                if (data.length==6){
                    String MaNV= data[0].trim();
                    String HoTen = data[1].trim();
                    String SDT = data[2].trim();
                    String DiaChi = data[3].trim();
                    String ChucVu = data[4].trim();
                    double Luong = Double.parseDouble(data[5].trim());
                    DSNhanVien.add(new NhanVien(MaNV, HoTen, SDT, DiaChi, ChucVu, Luong));
                }
            }
            System.out.println("Da doc file " + InputFile);
        } catch (IOException e) {System.out.println("Loi doc file " + e.getMessage());}
    }

    @Override
    public void GhiFile(String OutputFile)
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(OutputFile)))
        {
            bw.write("================================================================================================================================================"); bw.newLine();
            bw.write("                                                            DANH SACH NHAN VIEN                                                                 "); bw.newLine();
            bw.write("================================================================================================================================================"); bw.newLine();
            
            String HeaderLine = String.format("%-15s %-20s %-20s %-50s %-25s %-15s %n", "Ma nhan vien", "Ho ten", "So dien thoai", "Dia chi", "Chuc vu", "Luong");

            bw.write(HeaderLine);
            bw.newLine();

            for (NhanVien NV : DSNhanVien)
            {
                bw.write(String.format("%-15s %-20s %-20s %-50s %-25s %-15s", NV.getMaNV(), NV.getHoTen(), NV.getSDT(), NV.getDiaChi(), NV.getChucVu(), NV.getLuong()));
                bw.newLine();
            }

            bw.write("================================================================================================================================================"); bw.newLine();
            bw.write("Tong so nhan vien : " + DSNhanVien.size());
        }
        catch (IOException e) 
        {
            System.out.println("Loi ghi file : " + e.getMessage());
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
        QuanLyNhanVien QLNV = QuanLyNhanVien.getInstance();
        QLNV.DocFile("nhanvien.txt");
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
                case 2: MenuNhanVien(); break;
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
            System.out.println("      5. Tim kiem san pham");
            System.out.println("      6. Luu danh sach san pham vao file");
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
                    QLSP.Sua(sc);
                    break;
                case 4:
                    System.out.print("Nhap ma san pham : "); String maSP_Xem = sc.nextLine().trim();
                    SanPham SP_Xem = QLSP.TimTheoMa(maSP_Xem);

                    System.out.println("\n----- CHI TIET SAN PHAM -----");
                    System.out.printf("%-15s %-30s %-15s %-12s %-20s %n", "Ma san pham", "Ten san pham", "Loai san pham", "Gia ban", "Nha san xuat");
                    SP_Xem.HienThiChiTiet();
                    break;

                case 5:
                    System.out.print("Nhap ma san pham (hoac ten, loai) : "); String tukhoa = sc.nextLine().trim();
                    List<SanPham> SP_Found = QLSP.TimKiem(tukhoa);
                    System.out.println("=============================================================================================");
                    System.out.println("                                    KET QUA TIM KIEM                                         ");
                    System.out.println("=============================================================================================");
                    System.out.printf("%-15s %-30s %-15s %-12s %-20s %n", "Ma san pham", "Ten san pham", "Loai san pham", "Gia ban", "Nha san xuat");
                    System.out.println("=============================================================================================");
                    for (SanPham SP : SP_Found)
                        SP.HienThiThongTin();
                    break;

                case 6:
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

    // =============== HÀM HIỂN THỊ MENU QUẢN LÝ NHÂN VIÊN ===============
    private static void MenuNhanVien()
    {
        QuanLyNhanVien QLNV = QuanLyNhanVien.getInstance();
        do 
        {
            ClearScreen();
            QLNV.XemDanhSach();
            System.out.print("\n\n\n");
            System.out.println("=============================================================================================");
            System.out.println("                                   QUAN LY NHAN VIEN                                         ");
            System.out.println("=============================================================================================");
            System.out.println("      1. Them nhan vien moi");
            System.out.println("      2. Xoa nhan vien");
            System.out.println("      3. Sua thong tin nhan vien");
            System.out.println("      4. Tim kim nhan vien");
            System.out.println("      5. Luu danh sach nhan vien vao file");
            System.out.println("      0. Quay lai Menu Chinh");
            System.out.println("=============================================================================================");

            System.out.print("Chon chuc nang : ");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) 
            {
                case 1:
                    System.out.print("Ma NV: "); String ma = sc.nextLine().trim();
                    System.out.print("Ho va ten: "); String hoten = sc.nextLine().trim();
                    System.out.print("So dien thoai: "); String sdt = sc.nextLine().trim();
                    System.out.print("Dia chi : "); String diachi = sc.nextLine().trim();
                    System.out.print("Chuc vu : "); String chucvu = sc.nextLine().trim();
                    System.out.print("Luong : "); double luong = sc.nextDouble();

                    QLNV.Them(new NhanVien(ma, hoten, sdt, diachi, chucvu, luong));
                    break;

                case 2:
                    System.out.print("Nhap ma cua nhan vien : "); String maNV = sc.nextLine().trim();
                    QLNV.Xoa(maNV);
                    break;

                case 3:
                    QLNV.Sua(sc);
                    break;

                case 4:
                    System.out.print("Nhap ma nhan vien (hoac ho ten, chuc vu) : "); String tukhoa = sc.nextLine().trim();
                    List<NhanVien> NV_Found = QLNV.TimKiem(tukhoa);
                    System.out.println("================================================================================================================================================");
                    System.out.println("                                                              KET QUA TIM KIEM                                                                  ");
                    System.out.println("================================================================================================================================================");
                    System.out.printf("%-15s %-20s %-20s %-50s %-25s %-15s %n", "Ma nhan vien", "Ho ten", "So dien thoai", "Dia chi", "Chuc vu", "Luong");
                    System.out.println("================================================================================================================================================");
                    for (NhanVien NV : NV_Found)
                        NV.HienThiThongTin();
                    break;

                case 5:
                    QLNV.GhiFile("danhsach_nhanvien.txt"); 
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
