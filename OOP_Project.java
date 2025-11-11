import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
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

    public KhachHang(String MaKH, String HoTen, String SDT, String DiaChi, String LoaiKH, double DiemTichLuy){
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
        System.out.printf("%-15s %-20s %-20s %-50s %-20s %-,15.0f %n", MaKH, getHoTen(), getSDT(), getDiaChi(), LoaiKH, DiemTichLuy);
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
// =============== CHI TIẾT HÓA ĐƠN ===============
class ChiTietHoaDon {
    private String MaCTHD;
    private String MaSP; // Thay đổi: Lưu MaSP (String) thay vì đối tượng SanPham
    private int soLuong;
    private double donGia; // Lưu lại đơn giá tại thời điểm mua
    private double thanhTien;

    public ChiTietHoaDon() {}

    public ChiTietHoaDon(String maCTHD, String maSP, int soLuong, double donGia) {
        this.MaCTHD = maCTHD;
        this.MaSP = maSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = TinhThanhTien();
    }

    // Getters
    public String getMaCTHD() { return MaCTHD; }
    public String getMaSP() { return MaSP; } // Thay đổi: Đổi tên từ getSanPham()
    public int getSoLuong() { return soLuong; }
    public double getDonGia() { return donGia; }
    public double getThanhTien() { return thanhTien; }

    // Setters
    public void setSoLuong(int soLuong) { 
        this.soLuong = soLuong;
        this.thanhTien = TinhThanhTien(); // Cập nhật lại thành tiền
    }

    public double TinhThanhTien() {
        return this.soLuong * this.donGia;
    }

    public void HienThiChiTiet() {
        // Vì chỉ có MaSP, ta phải tìm đối tượng SanPham để lấy Tên SP
        SanPham sp = QuanLySanPham.getInstance().TimTheoMa(this.MaSP);
        String tenSP = (sp != null) ? sp.getTenSP() : "[Sản phẩm không tồn tại]";
        
        System.out.printf("%-15s %-30s %-10d %-,15.0f %-,15.0f %n", 
            MaSP, 
            tenSP, 
            soLuong, 
            donGia, 
            thanhTien);
    }
}
// =============== HÓA ĐƠN ===============
class HoaDon {
    private String maHD;
    private String MaKH; // Thay đổi: Lưu MaKH (String)
    private String MaNV; // Thay đổi: Lưu MaNV (String)
    private Date ngayLap;
    private List<ChiTietHoaDon> dsChiTiet;
    private double tongTien;

    public HoaDon() {
        this.dsChiTiet = new ArrayList<>();
    }

    public HoaDon(String maHD, String maKH, String maNV, Date ngayLap) {
        this.maHD = maHD;
        this.MaKH = maKH;
        this.MaNV = maNV;
        this.ngayLap = ngayLap;
        this.dsChiTiet = new ArrayList<>();
        this.tongTien = 0;
    }

    // Getters
    public String getMaHD() { return maHD; }
    public String getMaKH() { return MaKH; } // Thay đổi
    public String getMaNV() { return MaNV; } // Thay đổi
    public Date getNgayLap() { return ngayLap; }
    public double getTongTien() { return tongTien; }
    public List<ChiTietHoaDon> getDsChiTiet() { return dsChiTiet; }

    // Setters
    public void setMaHD(String maHD) { this.maHD = maHD; }
    public void setMaKH(String maKH) { this.MaKH = maKH; }
    public void setMaNV(String maNV) { this.MaNV = maNV; }
    public void setNgayLap(Date ngayLap) { this.ngayLap = ngayLap; }

    // Hàm tính tổng tiền (nội bộ)
    public void TinhTongTien() {
        this.tongTien = 0;
        for (ChiTietHoaDon ct : dsChiTiet) {
            this.tongTien += ct.getThanhTien();
        }
    }

    // Thêm chi tiết vào hóa đơn
    public void themChiTiet(ChiTietHoaDon chiTiet) {
        dsChiTiet.add(chiTiet);
        TinhTongTien(); // Cập nhật lại tổng tiền mỗi khi thêm
    }
    
    // Xóa chi tiết khỏi hóa đơn (theo yêu cầu UML)
    public void xoaChiTiet(String MaCTHD) {
        boolean removed = dsChiTiet.removeIf(ct -> ct.getMaCTHD().equals(MaCTHD));
        if (removed) {
            System.out.println("Da xoa chi tiet " + MaCTHD);
            TinhTongTien(); // Cập nhật lại tổng tiền
        } else {
            System.out.println("Khong tim thay chi tiet " + MaCTHD);
        }
    }

    // Hiển thị thông tin tóm tắt
    public void HienThiThongTin() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        
        // Phải tra cứu tên từ MaKH và MaNV
        KhachHang kh = QuanLyKhachHang.getInstance().TimTheoMa(this.MaKH);
        NhanVien nv = QuanLyNhanVien.getInstance().TimTheoMa(this.MaNV);
        
        String tenKH = (kh != null) ? kh.getHoTen() : "[KH khong ton tai]";
        String tenNV = (nv != null) ? nv.getHoTen() : "[NV khong ton tai]";

        System.out.printf("%-15s %-25s %-20s %-20s %-,15.0f %n", 
            maHD, 
            sdf.format(ngayLap), 
            tenKH, 
            tenNV, 
            tongTien);
    }

    // Hiển thị chi tiết hóa đơn
    public void HienThiChiTietHoaDon() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        // Tra cứu tên
        KhachHang kh = QuanLyKhachHang.getInstance().TimTheoMa(this.MaKH);
        NhanVien nv = QuanLyNhanVien.getInstance().TimTheoMa(this.MaNV);
        String tenKH = (kh != null) ? kh.getHoTen() : "[N/A]";
        String tenNV = (nv != null) ? nv.getHoTen() : "[N/A]";

        System.out.println("==========================================================================================");
        System.out.println("                                  CHI TIET HOA DON                                        ");
        System.out.println("Ma hoa don: " + maHD + "\t\t\tNgay lap: " + sdf.format(ngayLap));
        System.out.println("Khach hang: " + tenKH + " (MaKH: " + MaKH + ")");
        System.out.println("Nhan vien: " + tenNV + " (MaNV: " + MaNV + ")");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-30s %-10s %-15s %-15s %n", "Ma SP", "Ten San Pham", "So Luong", "Don Gia", "Thanh Tien");
        System.out.println("------------------------------------------------------------------------------------------");
        for (ChiTietHoaDon ct : dsChiTiet) {
            ct.HienThiChiTiet();
        }
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.printf("Tong cong: %,.0f%n", tongTien);
        System.out.println("==========================================================================================");
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
        System.out.printf("Chi tiet so ghi - So trang : %d, Loai bia : %s %n", SoTrang, LoaiBia);
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
            System.out.println("Da xoa nhan vien co ma la " + MaNV);
        else
            System.out.println("Khong tim thay nhan vien co ma la " + MaNV);
    }
     public NhanVien TimTheoMa(String MaNV)
    {
        for (NhanVien NV : DSNhanVien) 
        {
            if (NV.getMaNV().equals(MaNV)) 
                return NV;
        }
        return null; 
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
        }
        catch (IOException e) 
        {
            System.out.println("Loi ghi file : " + e.getMessage());
        }
    }
}


// =============== QUẢN LÝ KHACH HANG ===============
class QuanLyKhachHang implements IQuanLy<KhachHang>
{
    private List<KhachHang> DSKhachHang;
    private static QuanLyKhachHang instance;

    public QuanLyKhachHang()
    {
        DSKhachHang = new ArrayList<>();
    }

    public static QuanLyKhachHang getInstance()
    {
        if (instance == null) 
        {
            instance = new QuanLyKhachHang();
        }
        return instance;
    }

    @Override
    public void Them(KhachHang KH)
    {
        DSKhachHang.add(KH);
        System.out.println("Da them khach hang : " + KH.getHoTen() + "!");
    }

    @Override
    public void Sua(Scanner sc){
        System.out.print(" Nhap Ma KH can sua: ");
        String Ma= sc.nextLine();
        boolean ketqua= false;
        for (KhachHang kh: DSKhachHang){
            if (kh.getMaKH().equalsIgnoreCase(Ma)){
                ketqua= true;
                int Choice;
                do {
                    System.out.println(" Chon muc can sua: ");
                    System.out.println(" 1. Ho Ten");
                    System.out.println(" 2. SDT");
                    System.out.println(" 3. Dia Chi");
                    System.out.println(" 4. Loai KH");
                    System.out.println(" 5. Diem Tich Luy");
                    System.out.print(" 6. Thoat ");
                    Choice= sc.nextInt();
                    sc.nextLine();
                    switch (Choice){
                        case 1:
                            System.out.print(" Nhap lai Ho Ten: ");
                            kh.setHoTen(sc.nextLine());
                            break;
                        case 2:
                            System.out.print(" Nhap lai SDT: ");
                            kh.setSDT(sc.nextLine());
                            break;
                        case 3:
                            System.out.print(" Nhap lai Dia Chi: ");
                            kh.setDiaChi(sc.nextLine());
                            break;
                        case 4:
                            System.out.print(" Nhap lai Loai KH: ");
                            kh.setLoaiKH(sc.nextLine());
                            break;
                        case 5:
                            System.out.print(" Nhap lai Diem Tich Luy: ");
                            kh.setDiemTichLuy(Double.parseDouble(sc.nextLine()));
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
    public void Xoa(String MaKH)
    {
        boolean found = DSKhachHang.removeIf(SP -> SP.getMaKH().equals(MaKH));
        if (found)
            System.out.println("Da xoa khach hang co ma la " + MaKH);
        else
            System.out.println("Khong tim thay khach hang co ma la " + MaKH);
    }
  
    public KhachHang TimTheoMa(String MaKH)
    {
        for (KhachHang KH : DSKhachHang) 
        {
            if (KH.getMaKH().equals(MaKH)) 
                return KH;
        }
        return null; 
    }

    @Override
    public List<KhachHang> TimKiem(String TuKhoa)
    {
        List<KhachHang> Kq = new ArrayList<>();
        boolean found = false;
        for (KhachHang KH : DSKhachHang)
        {
            if (KH.getMaKH().toLowerCase().contains(TuKhoa.toLowerCase()) || KH.getHoTen().toLowerCase().contains(TuKhoa.toLowerCase()) ||
                KH.getLoaiKH().toLowerCase().contains(TuKhoa.toLowerCase()))
            {
                Kq.add(KH);
                found = true;
            } 
        }
        if (!found) System.out.println("Khong tim thay khach hang nao");
        return Kq;
    }

    @Override
    public void XemDanhSach()
    {
        System.out.println("===============================================================================================================================================");
        System.out.println("                                                             DANH SACH KHACH HANG                                                              ");
        System.out.println("===============================================================================================================================================");
        System.out.printf("%-15s %-20s %-20s %-50s %-20s %-15s %n", "Ma khach hang", "Ho ten", "So dien thoai", "Dia chi", "Loai khach hang", "Diem tich luy");
        System.out.println("===============================================================================================================================================");
        
        for (KhachHang KH : DSKhachHang)
            KH.HienThiThongTin();
    
        System.out.println("===============================================================================================================================================");    
    }
    
    @Override
    public void DocFile(String InputFile){
        try (BufferedReader br = new BufferedReader(new FileReader(InputFile))){
            String Line;
            while ((Line= br.readLine())!= null){
                String[] data= Line.split(";");
                if (data.length==6){
                    String MaKH= data[0].trim();
                    String HoTen = data[1].trim();
                    String SDT = data[2].trim();
                    String DiaChi = data[3].trim();
                    String LoaiKH = data[4].trim();
                    double DiemTichLuy = Double.parseDouble(data[5].trim());
                    DSKhachHang.add(new KhachHang(MaKH, HoTen, SDT, DiaChi, LoaiKH, DiemTichLuy));
                }
            }
            System.out.println("Da doc file " + InputFile);
        } 
        catch (IOException e) {System.out.println("Loi doc file " + e.getMessage());}
    }   

    @Override
    public void GhiFile(String OutputFile)
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(OutputFile)))
        {
            bw.write("==============================================================================================================================================="); bw.newLine();
            bw.write("                                                            DANH SACH KHACH HANG                                                               "); bw.newLine();
            bw.write("==============================================================================================================================================="); bw.newLine();
            
            String HeaderLine = String.format("%-15s %-20s %-20s %-50s %-15s %-15s %n", "Ma khach hang", "Ho ten", "So dien thoai", "Dia chi", "Loai khach hang", "Diem tich luy");

            bw.write(HeaderLine);
            bw.newLine();

            for (KhachHang KH : DSKhachHang)
            {
                bw.write(String.format("%-15s %-20s %-20s %-50s %-15s %-15s", KH.getMaKH(), KH.getHoTen(), KH.getSDT(), KH.getDiaChi(), KH.getLoaiKH(), KH.getDiemTichLuy()));
                bw.newLine();
            }

            bw.write("==============================================================================================================================================="); bw.newLine();
        }
        catch (IOException e) 
        {
            System.out.println("Loi ghi file : " + e.getMessage());
        }
    }
}

// =============== QUẢN LÝ HÓA ĐƠN ===============
class QuanLyHoaDon implements IQuanLy<HoaDon>
{
    // Thay đổi: Dùng tên "DSHoaDon"
    private List<HoaDon> DSHoaDon; 
    private static QuanLyHoaDon instance;

    public QuanLyHoaDon()
    {
        DSHoaDon = new ArrayList<>(); // Thay đổi
    }

    public static QuanLyHoaDon getInstance()
    {
        if (instance == null) 
        {
            instance = new QuanLyHoaDon();
        }
        return instance;
    }

    @Override
    public void Them(HoaDon HD)
    {
        DSHoaDon.add(HD); // Thay đổi
        System.out.println("Da them hoa don: " + HD.getMaHD() + "!");
    }

    @Override
    public void Xoa(String MaHD)
    {
        boolean found = DSHoaDon.removeIf(HD -> HD.getMaHD().equals(MaHD)); // Thay đổi
        if (found)
            System.out.println("Da xoa hoa don co ma la " + MaHD);
        else
            System.out.println("Khong tim thay hoa don co ma la " + MaHD);
    }


    @Override
    public void Sua(Scanner sc)
    {
        System.out.print("Nhap Ma Hoa Don can sua: ");
        String MaHD = sc.nextLine();
        HoaDon hd = TimTheoMa(MaHD);
        if (hd == null) {
            System.out.println("Khong tim thay hoa don!");
            return;
        }

        // Hiển thị một menu con cho phép sửa Hóa đơn
        int choice;
        do {
            System.out.println("--- SUA HOA DON " + MaHD + " ---");
            System.out.println("1. Sua Ma Khach Hang");
            System.out.println("2. Sua Ma Nhan Vien");
            System.out.println("3. Them Chi Tiet San Pham");
            System.out.println("4. Xoa Chi Tiet San Pham");
            System.out.println("0. Quay lai");
            System.out.print("Chon chuc nang: ");
            choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhap MaKH moi: ");
                    String maKH_moi = sc.nextLine();
                    // (Nên kiểm tra MaKH có tồn tại không)
                    hd.setMaKH(maKH_moi);
                    System.out.println("Da cap nhat MaKH.");
                    break;
                case 2:
                    System.out.print("Nhap MaNV moi: ");
                    String maNV_moi = sc.nextLine();
                    // (Nên kiểm tra MaNV có tồn tại không)
                    hd.setMaNV(maNV_moi);
                    System.out.println("Da cap nhat MaNV.");
                    break;
                case 3:
                    // (Tương tự logic Thêm HĐ: nhập MaCTHD, MaSP, SoLuong...)
                    System.out.println("Chuc nang dang phat trien.");
                    break;
                case 4:
                    System.out.print("Nhap MaCTHD can xoa: ");
                    String maCTHD_xoa = sc.nextLine();
                    hd.xoaChiTiet(maCTHD_xoa);
                    break;
            }
        } while (choice != 0);
    }

    @Override
    public List<HoaDon> TimKiem(String TuKhoa)
    {
        List<HoaDon> Kq = new ArrayList<>();
        boolean found = false;
        // Giữ nguyên logic tìm kiếm theo mã HĐ
        for (HoaDon HD : DSHoaDon) // Thay đổi
        {
            if (HD.getMaHD().toLowerCase().contains(TuKhoa.toLowerCase()))
            {
                Kq.add(HD);
                found = true;
            } 
        }
        if (!found) System.out.println("Khong tim thay hoa don nao");
        return Kq;
    }
    
    public HoaDon TimTheoMa(String MaHD)
    {
        for (HoaDon HD : DSHoaDon) // Thay đổi
            if (HD.getMaHD().equals(MaHD)) return HD;
        return null;
    }

    @Override
    public void XemDanhSach()
    {
        System.out.println("======================================================================================================");
        System.out.println("                                      DANH SACH HOA DON");
        System.out.println("======================================================================================================");
        System.out.printf("%-15s %-25s %-20s %-20s %-15s %n", "Ma Hoa Don", "Ngay Lap", "Khach Hang", "Nhan Vien", "Tong Tien");
        System.out.println("======================================================================================================");
        
        if (DSHoaDon.isEmpty()) { // Thay đổi
            System.out.println("Chua co hoa don nao.");
        } else {
            for (HoaDon HD : DSHoaDon) // Thay đổi
                HD.HienThiThongTin();
        }
    
        System.out.println("======================================================================================================");
        System.out.println("Tong so hoa don : " + DSHoaDon.size()); // Thay đổi
    }

    /**
     * HÀM MỚI: Thống kê doanh thu theo UML
     * Cần import java.util.Date và java.text.SimpleDateFormat
     */
    public double ThongKeDoanhThu(Date tuNgay, Date denNgay) {
        double tongDoanhThu = 0;
        for (HoaDon hd : DSHoaDon) { // Thay đổi
            Date ngayLap = hd.getNgayLap();
            // Kiểm tra xem ngayLap có nằm trong khoảng [tuNgay, denNgay] không
            // !(ngayLap < tuNgay) && !(ngayLap > denNgay)
            if (!ngayLap.before(tuNgay) && !ngayLap.after(denNgay)) {
                tongDoanhThu += hd.getTongTien();
            }
        }
        return tongDoanhThu;
    }

    // --- CẬP NHẬT FILE LOGIC ---
    @Override
    public void DocFile(String InputFile)
    {
        String fileHoaDon = InputFile;
        String fileChiTiet = "chitiethoadon.txt"; 
        
        DSHoaDon.clear(); 

        // === BƯỚC 1: Đọc file hoadon.txt ===
        try (BufferedReader hdReader = new BufferedReader(new FileReader(fileHoaDon)))
        {
            String line;
            while ((line = hdReader.readLine()) != null)
            {
                String[] data = line.split(";");
                if (data.length < 4) continue;

                String maHD = data[0].trim();
                long timestamp = Long.parseLong(data[1].trim());
                String maKH = data[2].trim();
                String maNV = data[3].trim();

                HoaDon hd = new HoaDon(maHD, maKH, maNV, new Date(timestamp));
                DSHoaDon.add(hd); 
            }
        } catch (IOException e) {
            System.out.println("Loi doc file " + fileHoaDon + ": " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Loi dinh dang so trong file " + fileHoaDon + ": " + e.getMessage());
        }

        // === BƯỚC 2: Đọc file chitiethoadon.txt (ĐÃ SỬA LỖI) ===
        try (BufferedReader ctReader = new BufferedReader(new FileReader(fileChiTiet)))
        {
            String line;
            while ((line = ctReader.readLine()) != null)
            {
                // SỬA Ở ĐÂY: Phải dùng biến 'line' đã đọc từ 'while'
                String[] data = line.split(";"); 
                
                if (data.length < 5) continue;

                String maHD = data[0].trim();
                String maCTHD = data[1].trim(); 
                String maSP = data[2].trim(); 
                int soLuong = Integer.parseInt(data[3].trim());
                double donGia = Double.parseDouble(data[4].trim()); 

                HoaDon hd = this.TimTheoMa(maHD);
                
                if (hd != null) {
                    ChiTietHoaDon ct = new ChiTietHoaDon(maCTHD, maSP, soLuong, donGia);
                    // Dòng này rất quan trọng, nó sẽ tính tongTien
                    hd.themChiTiet(ct); 
                } else {
                     System.out.println("Canh bao: Khong tim thay HĐ (" + maHD + ") cho chi tiet");
                }
            }
        } catch (IOException e) {
            System.out.println("Loi doc file " + fileChiTiet + ": " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Loi dinh dang so trong file " + fileChiTiet + ": " + e.getMessage());
        }

        System.out.println("Da doc file hoadon.txt");
    }

    @Override
    public void GhiFile(String OutputFile)
    {
       String fileHoaDon = OutputFile; // "hoadon.txt"
        String fileChiTiet = "chitiethoadon.txt"; 

        // 1. Ghi file hoadon.txt
        try (BufferedWriter hdWriter = new BufferedWriter(new FileWriter(fileHoaDon)))
        {
            for (HoaDon hd : DSHoaDon) { // Thay đổi
                // Cập nhật: Lưu MaKH và MaNV (String)
                // Format: MaHD;NgayLap_Timestamp;MaKH;MaNV
                String line = hd.getMaHD() + ";" + 
                              hd.getNgayLap().getTime() + ";" + 
                              hd.getMaKH() + ";" + // Cập nhật
                              hd.getMaNV(); // Cập nhật
                hdWriter.write(line);
                hdWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Loi ghi file hoa don: " + e.getMessage());
        }
        // 2. Ghi file chitiethoadon.txt 
        try (BufferedWriter ctWriter = new BufferedWriter(new FileWriter(fileChiTiet))) 
        { 
            for (HoaDon hd : DSHoaDon) { // Thay đổi
                for (ChiTietHoaDon ct : hd.getDsChiTiet()) { 
                // Cập nhật: Thêm MaCTHD, MaSP, DonGia 
                // Format: MaHD;MaCTHD;MaSP;SoLuong;DonGia 
                    String line = hd.getMaHD() + ";" + 
                                    ct.getMaCTHD() + ";" + 
                                    ct.getMaSP() + ";" +  
                                    ct.getSoLuong() + ";" + 
                                    ct.getDonGia(); 
                    ctWriter.write(line); 
                    ctWriter.newLine(); 
                } 
            } 
        } catch (IOException e) { 
            System.out.println("Loi ghi file chi tiet hoa don: " + e.getMessage()); 
        } 
        System.out.println("Da luu du lieu hoa don vao file " + fileHoaDon + " va " + fileChiTiet); 
        
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
        QuanLyKhachHang QLKH = QuanLyKhachHang.getInstance();
        QLKH.DocFile("khachhang.txt");
        QuanLySanPham QLSP = QuanLySanPham.getInstance();
        QLSP.DocFile("sanpham.txt");
        QuanLyHoaDon QLHD = QuanLyHoaDon.getInstance();
        QLHD.DocFile("hoadon.txt");

        //Menu chính
        do 
        {
            ClearScreen();
            MainMenu();
            System.out.print("Chon chuc nang : ");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) 
            {
                case 1: MenuKhachHang(); break;
                case 2: MenuNhanVien(); break;
                case 3: MenuSanPham(); break;

                case 4: MenuHoaDon(); break;

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

    // =============== HÀM HIỂN THỊ MENU QUẢN LÝ KHÁCH HÀNG ===============
    private static void MenuKhachHang()
    {
        QuanLyKhachHang QLKH = QuanLyKhachHang.getInstance();
        do 
        {
            ClearScreen();
            QLKH.XemDanhSach();
            System.out.print("\n\n\n");
            System.out.println("=============================================================================================");
            System.out.println("                                  QUAN LY KHACH HANG                                         ");
            System.out.println("=============================================================================================");
            System.out.println("      1. Them khach hang moi");
            System.out.println("      2. Xoa khach hang");
            System.out.println("      3. Sua thong tin khach hang");
            System.out.println("      4. Tim kim khach hang");
            System.out.println("      5. Luu danh sach khach hang vao file");
            System.out.println("      0. Quay lai Menu Chinh");
            System.out.println("=============================================================================================");

            System.out.print("Chon chuc nang : ");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) 
            {
                case 1:
                    System.out.print("Ma KH : "); String ma = sc.nextLine().trim();
                    System.out.print("Ho va ten : "); String hoten = sc.nextLine().trim();
                    System.out.print("So dien thoai : "); String sdt = sc.nextLine().trim();
                    System.out.print("Dia chi : "); String diachi = sc.nextLine().trim();
                    System.out.print("Loai khach hang : "); String loai = sc.nextLine().trim();
                    System.out.print("Diem tich luy : "); double diem = sc.nextDouble();

                    QLKH.Them(new KhachHang(ma, hoten, sdt, diachi, loai, diem));
                    break;

                case 2:
                    System.out.print("Nhap ma cua khach hang : "); String maKH = sc.nextLine().trim();
                    QLKH.Xoa(maKH);
                    break;

                case 3:
                    QLKH.Sua(sc);
                    break;

                case 4:
                    System.out.print("Nhap ma khach hang (hoac ho ten, loai khach hang) : "); String tukhoa = sc.nextLine().trim();
                    List<KhachHang> NV_Found = QLKH.TimKiem(tukhoa);
                    System.out.println("===============================================================================================================================================");
                    System.out.println("                                                               KET QUA TIM KIEM                                                               " );
                    System.out.println("===============================================================================================================================================");
                    System.out.printf("%-15s %-20s %-20s %-50s %-15s %-15s %n", "Ma khach hang", "Ho ten", "So dien thoai", "Dia chi", "Loai khach hang", "Diem tich luy");
                    System.out.println("===============================================================================================================================================");
                    for (KhachHang KH : NV_Found)
                        KH.HienThiThongTin();
                    break;

                case 5:
                    QLKH.GhiFile("danhsach_khachhang.txt"); 
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
    // =============== HÀM HIỂN THỊ MENU QUẢN LÝ HÓA ĐƠN ===============
    private static void MenuHoaDon()
    {
        QuanLyHoaDon QLHD = QuanLyHoaDon.getInstance();
        QuanLySanPham QLSP = QuanLySanPham.getInstance();
        QuanLyKhachHang QLKH = QuanLyKhachHang.getInstance();
        QuanLyNhanVien QLNV = QuanLyNhanVien.getInstance();
        
        // Cần cho chức năng Thống kê
        SimpleDateFormat sdfParser = new SimpleDateFormat("dd/MM/yyyy");

        do 
        {
            ClearScreen();
           
            System.out.print("\n\n\n");
            System.out.println("=============================================================================================");
            System.out.println("                                      QUAN LY HOA DON                                      ");
            System.out.println("=============================================================================================");
            System.out.println("      1. Tao hoa don moi");
            System.out.println("      2. Xoa hoa don");
            System.out.println("      3. Sua thong tin hoa don");
            System.out.println("      4. Xem chi tiet hoa don");
            System.out.println("      5. Tim kiem hoa don (theo MaHD)");
            System.out.println("      6. Luu danh sach hoa don vao file");
            System.out.println("      7. Danh sach hoa don ");
            System.out.println("      0. Quay lai Menu Chinh");
            System.out.println("=============================================================================================");

            System.out.print("Chon chuc nang : ");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) 
            {
                case 1:
                    // === CẬP NHẬT QUY TRÌNH TẠO HÓA ĐƠN ===
                    System.out.print("Nhap ma hoa don (vi du: HD001): ");
                    String maHD = sc.nextLine().trim();
                    // (Nên kiểm tra mã HĐ có trùng không)
                    
                    // Lấy khách hàng
                    KhachHang kh = null;
                    String maKH_Chon = "";
                    while (kh == null) {
                        System.out.print("Nhap ma khach hang: ");
                        maKH_Chon = sc.nextLine().trim();
                        kh = QLKH.TimTheoMa(maKH_Chon);
                        if (kh == null) System.out.println("Khong tim thay khach hang. Vui long nhap lai.");
                        else System.out.println("Khach hang: " + kh.getHoTen());
                    }

                    // Lấy nhân viên
                    NhanVien nv = null;
                    String maNV_Chon = "";
                    while (nv == null) {
                        System.out.print("Nhap ma nhan vien lap hoa don: ");
                        maNV_Chon = sc.nextLine().trim();
                        nv = QLNV.TimTheoMa(maNV_Chon);
                        if (nv == null) System.out.println("Khong tim thay nhan vien. Vui long nhap lai.");
                        else System.out.println("Nhan vien: " + nv.getHoTen());
                    }
                    
                    // Tạo đối tượng Hóa đơn (dùng String MaKH, MaNV)
                    HoaDon hdMoi = new HoaDon(maHD, maKH_Chon, maNV_Chon, new Date());

                    // Thêm sản phẩm vào chi tiết hóa đơn
                    String themTiep;
                    int chiTietCounter = 1; // Để tạo MaCTHD
                    do {
                        SanPham sp = null;
                        String maSP_Chon = "";
                        while (sp == null) {
                            System.out.print("Nhap ma san pham can them: ");
                            maSP_Chon = sc.nextLine().trim();
                            sp = QLSP.TimTheoMa(maSP_Chon);
                            if (sp == null) System.out.println("Khong tim thay san pham. Vui long nhap lai.");
                        }

                        System.out.print("Nhap so luong: ");
                        int soLuong = sc.nextInt(); sc.nextLine();
                        // (Nên kiểm tra số lượng tồn kho nếu có)

                        // Lấy đơn giá tại thời điểm bán
                        double donGia = sp.getGiaBan();
                        
                        // Tạo MaCTHD (ví dụ: HD001-1, HD001-2)
                        String maCTHD = maHD + "-" + chiTietCounter;
                        chiTietCounter++;

                        // Tạo chi tiết HĐ (dùng String MaSP)
                        ChiTietHoaDon ctMoi = new ChiTietHoaDon(maCTHD, maSP_Chon, soLuong, donGia);
                        hdMoi.themChiTiet(ctMoi);
                        System.out.println("Da them san pham: " + sp.getTenSP());

                        System.out.print("Ban co muon them san pham khac khong? (c/k): ");
                        themTiep = sc.nextLine().trim();
                    } while (themTiep.equalsIgnoreCase("c"));

                    // Thêm HĐ vào danh sách quản lý
                    QLHD.Them(hdMoi);
                    System.out.println("DA TAO HOA DON MOI THANH CONG!");
                    hdMoi.HienThiChiTietHoaDon(); // Hiển thị chi tiết HĐ vừa tạo
                    break;

                case 2:
                    System.out.print("Nhap ma hoa don can xoa: ");
                    String maHD_Xoa = sc.nextLine().trim();
                    QLHD.Xoa(maHD_Xoa);
                    break;

                case 3:
                    QLHD.Sua(sc); // Gọi hàm sửa
                    break;
                case 4:
                    System.out.print("Nhap ma hoa don can xem chi tiet: ");
                    String maHD_Xem = sc.nextLine().trim();
                    HoaDon hdXem = QLHD.TimTheoMa(maHD_Xem);
                    if (hdXem != null) {
                        hdXem.HienThiChiTietHoaDon();
                    } else {
                        System.out.println("Khong tim thay hoa don voi ma: " + maHD_Xem);
                    }
                    break;

                case 5:
                    System.out.print("Nhap ma hoa don can tim: ");
                    String tukhoa = sc.nextLine().trim();
                    List<HoaDon> HD_Found = QLHD.TimKiem(tukhoa);
                    System.out.println("======================================================================================================");
                    System.out.println("                                      KET QUA TIM KIEM");
                    // (Hiển thị kết quả như cũ)
                    System.out.printf("%-15s %-25s %-20s %-20s %-15s %n", "Ma Hoa Don", "Ngay Lap", "Khach Hang", "Nhan Vien", "Tong Tien");
                    System.out.println("======================================================================================================");
                    for (HoaDon HD : HD_Found)
                        HD.HienThiThongTin();
                    break;

                case 6:
                    QLHD.GhiFile("hoadon.txt"); // Sẽ ghi ra hoadon.txt và chitiethoadon.txt
                    break;

                case 7: 
                    QLHD.XemDanhSach();
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

