package com.raven.repository;

import com.raven.model.SanPham;
import com.raven.uitlities.DBConnect;
import com.raven.viewmodel.ChiTietSPVM;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ChiTietSPRepository {

    public boolean add(ChiTietSPVM spct) {
        String query = "INSERT INTO [dbo].[CHITIETSP] ([idSP], [HangSP], [KieuDang], [MauSac], "
                + "[NhienLieu], [DongXe], [HopSo], [DongCo], [ChoNgoi], [PhanKhuc], [XuatXu], [NamSX],"
                + " [SoLuongTon], [GiaBan], [MoTa], [trangThai]) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, spct.getSanPham().getId());
            ps.setString(2, spct.getHangSP());
            ps.setString(3, spct.getKieudang());
            ps.setString(4, spct.getMausac());
            ps.setString(5, spct.getNhienlieu());
            ps.setString(6, spct.getDongxe());
            ps.setString(7, spct.getHopso());
            ps.setString(8, spct.getDongco());
            ps.setString(9, spct.getChongoi());
            ps.setString(10, spct.getPhankhuc());
            ps.setString(11, spct.getXuatxu());
            ps.setInt(12, spct.getNamSX());
            ps.setInt(13, spct.getSoLuongTon());
            ps.setBigDecimal(14, spct.getDongia());
            ps.setString(15, spct.getMoTa());
            ps.setInt(16, spct.getTrangthai());
            ps.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(String id, ChiTietSPVM spct) {
        String query = "UPDATE [dbo].[CHITIETSP] SET [idSP]=?, [HangSP]=?, [KieuDang]=?, [MauSac]=?, "
                + "[NhienLieu]=?, [DongXe]=?, [HopSo]=?, [DongCo]=?, [ChoNgoi]=?, [PhanKhuc]=?, [XuatXu]=?, [NamSX]=?,"
                + " [SoLuongTon]=?, [GiaBan]=?, [MoTa]=?, [trangThai]=? WHERE [id] = ?";

        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, spct.getSanPham().getId());
            ps.setString(2, spct.getHangSP());
            ps.setString(3, spct.getKieudang());
            ps.setString(4, spct.getMausac());
            ps.setString(5, spct.getNhienlieu());
            ps.setString(6, spct.getDongxe());
            ps.setString(7, spct.getHopso());
            ps.setString(8, spct.getDongco());
            ps.setString(9, spct.getChongoi());
            ps.setString(10, spct.getPhankhuc());
            ps.setString(11, spct.getXuatxu());
            ps.setInt(12, spct.getNamSX());
            ps.setInt(13, spct.getSoLuongTon());
            ps.setBigDecimal(14, spct.getDongia());
            ps.setString(15, spct.getMoTa());
            ps.setInt(16, spct.getTrangthai());

            ps.setString(17, id);
            ps.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String id) {
        String query = "DELETE FROM [dbo].[CHITIETSP]\n"
                + "      WHERE [id] = ?";

        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            ps.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public ArrayList<ChiTietSPVM> getAll() {
        ArrayList<ChiTietSPVM> lstSP = new ArrayList<>();

        try {
            Connection con = DBConnect.getConnection();
            String query = "SELECT dbo.CHITIETSP.id, dbo.SANPHAM.id AS Expr1, dbo.SANPHAM.ten, dbo.CHITIETSP.HangSP, dbo.CHITIETSP.KieuDang, "
                    + "dbo.CHITIETSP.MauSac, dbo.CHITIETSP.NhienLieu, dbo.CHITIETSP.DongXe, dbo.CHITIETSP.HopSo, \n"
                    + "      dbo.CHITIETSP.DongCo, dbo.CHITIETSP.ChoNgoi, dbo.CHITIETSP.PhanKhuc, dbo.CHITIETSP.XuatXu,"
                    + " dbo.CHITIETSP.NamSX, dbo.CHITIETSP.SoLuongTon, dbo.CHITIETSP.GiaBan, dbo.CHITIETSP.MoTa, dbo.CHITIETSP.trangThai\n"
                    + "FROM  dbo.CHITIETSP INNER JOIN\n"
                    + "      dbo.SANPHAM ON dbo.CHITIETSP.idSP = dbo.SANPHAM.id";

            PreparedStatement ps = con.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString(1);
                String idsp = rs.getString(2);
                String tenSP = rs.getString(3);
                String hang = rs.getString(4);
                String kieudang = rs.getString(5);
                String mausac = rs.getString(6);
                String nhienlieu = rs.getString(7);
                String dongxe = rs.getString(8);
                String hopso = rs.getString(9);
                String dongco = rs.getString(10);
                String chongoi = rs.getString(11);
                String phankhuc = rs.getString(12);
                String xuatxu = rs.getString(13);
                int namSX = rs.getInt(14);
                Integer slTon = rs.getInt(15);
                BigDecimal giaBan = rs.getBigDecimal(16);
                String moTa = rs.getString(17);
                int trangThai = rs.getInt(18);

                SanPham sp = new SanPham(idsp, "", tenSP, "");
                ChiTietSPVM ct = new ChiTietSPVM(id, sp, hang, kieudang, mausac, nhienlieu, dongxe, hopso, dongco, chongoi, phankhuc, xuatxu, namSX, slTon, giaBan, moTa, trangThai);
                lstSP.add(ct);
            }
            return lstSP;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<ChiTietSPVM> getOne(String txt) {
        ArrayList<ChiTietSPVM> lstSP = new ArrayList<>();
        try {
            Connection con = DBConnect.getConnection();
            String query = "SELECT dbo.CHITIETSP.id, dbo.SANPHAM.id AS Expr1, dbo.SANPHAM.ten, dbo.CHITIETSP.HangSP, dbo.CHITIETSP.KieuDang, \n"
                    + "dbo.CHITIETSP.MauSac, dbo.CHITIETSP.NhienLieu, dbo.CHITIETSP.DongXe, dbo.CHITIETSP.HopSo, \n"
                    + " dbo.CHITIETSP.DongCo, dbo.CHITIETSP.ChoNgoi, dbo.CHITIETSP.PhanKhuc, dbo.CHITIETSP.XuatXu,\n"
                    + "dbo.CHITIETSP.NamSX, dbo.CHITIETSP.SoLuongTon, dbo.CHITIETSP.GiaBan, dbo.CHITIETSP.MoTa, dbo.CHITIETSP.trangThai\n"
                    + "FROM  dbo.CHITIETSP INNER JOIN\n"
                    + "dbo.SANPHAM ON dbo.CHITIETSP.idSP = dbo.SANPHAM.id WHERE  dbo.SANPHAM.ten like '%'+?+'%'  or dbo.CHITIETSP.HangSP like '%'+?+'%' \n"
                    + "or dbo.CHITIETSP.KieuDang like '%'+?+'%' or dbo.CHITIETSP.MauSac like '%'+?+'%' or\n"
                    + "   dbo.CHITIETSP.NhienLieu like '%'+?+'%' or dbo.CHITIETSP.DongXe like '%'+?+'%'  or dbo.CHITIETSP.HopSo like '%'+?+'%' or dbo.CHITIETSP.DongCo like '%'+?+'%'\n"
                    + " or dbo.CHITIETSP.ChoNgoi like '%'+?+'%' or dbo.CHITIETSP.XuatXu like '%'+?+'%' or dbo.CHITIETSP.PhanKhuc like '%'+?+'%'";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, txt);
            ps.setString(2, txt);
            ps.setString(3, txt);
            ps.setString(4, txt);
            ps.setString(5, txt);
            ps.setString(6, txt);
            ps.setString(7, txt);
            ps.setString(8, txt);
            ps.setString(9, txt);
            ps.setString(10, txt);
             ps.setString(11, txt);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                String id = rs.getString(1);
                String idsp = rs.getString(2);
                String tenSP = rs.getString(3);
                String hang = rs.getString(4);
                String kieudang = rs.getString(5);
                String mausac = rs.getString(6);
                String nhienlieu = rs.getString(7);
                String dongxe = rs.getString(8);
                String hopso = rs.getString(9);
                String dongco = rs.getString(10);
                String chongoi = rs.getString(11);
                String phankhuc = rs.getString(12);
                String xuatxu = rs.getString(13);
                int namSX = rs.getInt(14);
                Integer slTon = rs.getInt(15);
                BigDecimal giaBan = rs.getBigDecimal(16);
                String moTa = rs.getString(17);
                int trangThai = rs.getInt(18);

                SanPham sp = new SanPham(idsp, "", tenSP, "");
                ChiTietSPVM ct = new ChiTietSPVM(id, sp, hang, kieudang, mausac, nhienlieu, dongxe, hopso, dongco, chongoi, phankhuc, xuatxu, namSX, slTon, giaBan, moTa, trangThai);
                lstSP.add(ct);
            }
            return lstSP;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<ChiTietSPVM> getTop3_SL() {
        ArrayList<ChiTietSPVM> lstSP = new ArrayList<>();
        try {
            Connection con = DBConnect.getConnection();
            String query = "SELECT Top 3 dbo.CHITIETSP.id, dbo.SANPHAM.id AS Expr1, dbo.SANPHAM.ten, dbo.CHITIETSP.HangSP, dbo.CHITIETSP.KieuDang, "
                    + "dbo.CHITIETSP.MauSac, dbo.CHITIETSP.NhienLieu, dbo.CHITIETSP.DongXe, dbo.CHITIETSP.HopSo, \n"
                    + "      dbo.CHITIETSP.DongCo, dbo.CHITIETSP.ChoNgoi, dbo.CHITIETSP.PhanKhuc, dbo.CHITIETSP.XuatXu,"
                    + " dbo.CHITIETSP.NamSX, dbo.CHITIETSP.SoLuongTon, dbo.CHITIETSP.GiaBan, dbo.CHITIETSP.MoTa, dbo.CHITIETSP.trangThai\n"
                    + "FROM  dbo.CHITIETSP INNER JOIN\n"
                    + "      dbo.SANPHAM ON dbo.CHITIETSP.idSP = dbo.SANPHAM.id ORDER BY dbo.CHITIETSP.SoLuongTon DESC";
            PreparedStatement ps = con.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                String id = rs.getString(1);
                String idsp = rs.getString(2);
                String tenSP = rs.getString(3);
                String hang = rs.getString(4);
                String kieudang = rs.getString(5);
                String mausac = rs.getString(6);
                String nhienlieu = rs.getString(7);
                String dongxe = rs.getString(8);
                String hopso = rs.getString(9);
                String dongco = rs.getString(10);
                String chongoi = rs.getString(11);
                String phankhuc = rs.getString(12);
                String xuatxu = rs.getString(13);
                int namSX = rs.getInt(14);
                Integer slTon = rs.getInt(15);
                BigDecimal giaBan = rs.getBigDecimal(16);
                String moTa = rs.getString(17);
                int trangThai = rs.getInt(18);

                SanPham sp = new SanPham(idsp, "", tenSP, "");
                ChiTietSPVM ct = new ChiTietSPVM(id, sp, hang, kieudang, mausac, nhienlieu, dongxe, hopso, dongco, chongoi, phankhuc, xuatxu, namSX, slTon, giaBan, moTa, trangThai);
                lstSP.add(ct);
            }
            return lstSP;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<ChiTietSPVM> getSXGia_Tang() {
        ArrayList<ChiTietSPVM> lstSP = new ArrayList<>();
        try {
            Connection con = DBConnect.getConnection();
            String query = "SELECT  dbo.CHITIETSP.id, dbo.SANPHAM.id AS Expr1, dbo.SANPHAM.ten, dbo.CHITIETSP.HangSP, dbo.CHITIETSP.KieuDang, "
                    + "dbo.CHITIETSP.MauSac, dbo.CHITIETSP.NhienLieu, dbo.CHITIETSP.DongXe, dbo.CHITIETSP.HopSo, \n"
                    + "      dbo.CHITIETSP.DongCo, dbo.CHITIETSP.ChoNgoi, dbo.CHITIETSP.PhanKhuc, dbo.CHITIETSP.XuatXu,"
                    + " dbo.CHITIETSP.NamSX, dbo.CHITIETSP.SoLuongTon, dbo.CHITIETSP.GiaBan, dbo.CHITIETSP.MoTa, dbo.CHITIETSP.trangThai\n"
                    + "FROM  dbo.CHITIETSP INNER JOIN\n"
                    + "      dbo.SANPHAM ON dbo.CHITIETSP.idSP = dbo.SANPHAM.id ORDER BY dbo.CHITIETSP.GiaBan ASC";
            PreparedStatement ps = con.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                String id = rs.getString(1);
                String idsp = rs.getString(2);
                String tenSP = rs.getString(3);
                String hang = rs.getString(4);
                String kieudang = rs.getString(5);
                String mausac = rs.getString(6);
                String nhienlieu = rs.getString(7);
                String dongxe = rs.getString(8);
                String hopso = rs.getString(9);
                String dongco = rs.getString(10);
                String chongoi = rs.getString(11);
                String phankhuc = rs.getString(12);
                String xuatxu = rs.getString(13);
                int namSX = rs.getInt(14);
                Integer slTon = rs.getInt(15);
                BigDecimal giaBan = rs.getBigDecimal(16);
                String moTa = rs.getString(17);
                int trangThai = rs.getInt(18);

                SanPham sp = new SanPham(idsp, "", tenSP, "");
                ChiTietSPVM ct = new ChiTietSPVM(id, sp, hang, kieudang, mausac, nhienlieu, dongxe, hopso, dongco, chongoi, phankhuc, xuatxu, namSX, slTon, giaBan, moTa, trangThai);
                lstSP.add(ct);
            }
            return lstSP;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<ChiTietSPVM> getSXGia_Giam() {
        ArrayList<ChiTietSPVM> lstSP = new ArrayList<>();
        try {
            Connection con = DBConnect.getConnection();
            String query = "SELECT dbo.CHITIETSP.id, dbo.SANPHAM.id AS Expr1, dbo.SANPHAM.ten, dbo.CHITIETSP.HangSP, dbo.CHITIETSP.KieuDang, "
                    + "dbo.CHITIETSP.MauSac, dbo.CHITIETSP.NhienLieu, dbo.CHITIETSP.DongXe, dbo.CHITIETSP.HopSo, \n"
                    + "      dbo.CHITIETSP.DongCo, dbo.CHITIETSP.ChoNgoi, dbo.CHITIETSP.PhanKhuc, dbo.CHITIETSP.XuatXu,"
                    + " dbo.CHITIETSP.NamSX, dbo.CHITIETSP.SoLuongTon, dbo.CHITIETSP.GiaBan, dbo.CHITIETSP.MoTa, dbo.CHITIETSP.trangThai\n"
                    + "FROM  dbo.CHITIETSP INNER JOIN\n"
                    + "      dbo.SANPHAM ON dbo.CHITIETSP.idSP = dbo.SANPHAM.id ORDER BY dbo.CHITIETSP.GiaBan DESC";
            PreparedStatement ps = con.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                String id = rs.getString(1);
                String idsp = rs.getString(2);
                String tenSP = rs.getString(3);
                String hang = rs.getString(4);
                String kieudang = rs.getString(5);
                String mausac = rs.getString(6);
                String nhienlieu = rs.getString(7);
                String dongxe = rs.getString(8);
                String hopso = rs.getString(9);
                String dongco = rs.getString(10);
                String chongoi = rs.getString(11);
                String phankhuc = rs.getString(12);
                String xuatxu = rs.getString(13);
                int namSX = rs.getInt(14);
                Integer slTon = rs.getInt(15);
                BigDecimal giaBan = rs.getBigDecimal(16);
                String moTa = rs.getString(17);
                int trangThai = rs.getInt(18);

                SanPham sp = new SanPham(idsp, "", tenSP, "");
                ChiTietSPVM ct = new ChiTietSPVM(id, sp, hang, kieudang, mausac, nhienlieu, dongxe, hopso, dongco, chongoi, phankhuc, xuatxu, namSX, slTon, giaBan, moTa, trangThai);
                lstSP.add(ct);
            }
            return lstSP;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<ChiTietSPVM> getLocTheoGia(BigDecimal gia1, BigDecimal gia2) {
        ArrayList<ChiTietSPVM> lstSP = new ArrayList<>();
        try {
            Connection con = DBConnect.getConnection();
            String query = "SELECT dbo.CHITIETSP.id, dbo.SANPHAM.id AS Expr1, dbo.SANPHAM.ten, dbo.CHITIETSP.HangSP, dbo.CHITIETSP.KieuDang, "
                    + "dbo.CHITIETSP.MauSac, dbo.CHITIETSP.NhienLieu, dbo.CHITIETSP.DongXe, dbo.CHITIETSP.HopSo, \n"
                    + "      dbo.CHITIETSP.DongCo, dbo.CHITIETSP.ChoNgoi, dbo.CHITIETSP.PhanKhuc, dbo.CHITIETSP.XuatXu,"
                    + " dbo.CHITIETSP.NamSX, dbo.CHITIETSP.SoLuongTon, dbo.CHITIETSP.GiaBan, dbo.CHITIETSP.MoTa, dbo.CHITIETSP.trangThai\n"
                    + "FROM  dbo.CHITIETSP INNER JOIN\n"
                    + "      dbo.SANPHAM ON dbo.CHITIETSP.idSP = dbo.SANPHAM.id WHERE dbo.CHITIETSP.GiaBan >=? AND dbo.CHITIETSP.GiaBan<=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setBigDecimal(1, gia1);
            ps.setBigDecimal(2, gia2);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                String id = rs.getString(1);
                String idsp = rs.getString(2);
                String tenSP = rs.getString(3);
                String hang = rs.getString(4);
                String kieudang = rs.getString(5);
                String mausac = rs.getString(6);
                String nhienlieu = rs.getString(7);
                String dongxe = rs.getString(8);
                String hopso = rs.getString(9);
                String dongco = rs.getString(10);
                String chongoi = rs.getString(11);
                String phankhuc = rs.getString(12);
                String xuatxu = rs.getString(13);
                int namSX = rs.getInt(14);
                Integer slTon = rs.getInt(15);
                BigDecimal giaBan = rs.getBigDecimal(16);
                String moTa = rs.getString(17);
                int trangThai = rs.getInt(18);

                SanPham sp = new SanPham(idsp, "", tenSP, "");
                ChiTietSPVM ct = new ChiTietSPVM(id, sp, hang, kieudang, mausac, nhienlieu, dongxe, hopso, dongco, chongoi, phankhuc, xuatxu, namSX, slTon, giaBan, moTa, trangThai);
                lstSP.add(ct);
            }
            return lstSP;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<ChiTietSPVM> getLocTheoGiaT(BigDecimal giaT) {
        ArrayList<ChiTietSPVM> lstSP = new ArrayList<>();
        try {
            Connection con = DBConnect.getConnection();
            String query = "SELECT dbo.CHITIETSP.id, dbo.SANPHAM.id AS Expr1, dbo.SANPHAM.ten, dbo.CHITIETSP.HangSP, dbo.CHITIETSP.KieuDang, "
                    + "dbo.CHITIETSP.MauSac, dbo.CHITIETSP.NhienLieu, dbo.CHITIETSP.DongXe, dbo.CHITIETSP.HopSo, \n"
                    + "      dbo.CHITIETSP.DongCo, dbo.CHITIETSP.ChoNgoi, dbo.CHITIETSP.PhanKhuc, dbo.CHITIETSP.XuatXu,"
                    + " dbo.CHITIETSP.NamSX, dbo.CHITIETSP.SoLuongTon, dbo.CHITIETSP.GiaBan, dbo.CHITIETSP.MoTa, dbo.CHITIETSP.trangThai\n"
                    + "FROM  dbo.CHITIETSP INNER JOIN\n"
                    + "      dbo.SANPHAM ON dbo.CHITIETSP.idSP = dbo.SANPHAM.id WHERE dbo.CHITIETSP.GiaBan >=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setBigDecimal(1, giaT);

            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                String id = rs.getString(1);
                String idsp = rs.getString(2);
                String tenSP = rs.getString(3);
                String hang = rs.getString(4);
                String kieudang = rs.getString(5);
                String mausac = rs.getString(6);
                String nhienlieu = rs.getString(7);
                String dongxe = rs.getString(8);
                String hopso = rs.getString(9);
                String dongco = rs.getString(10);
                String chongoi = rs.getString(11);
                String phankhuc = rs.getString(12);
                String xuatxu = rs.getString(13);
                int namSX = rs.getInt(14);
                Integer slTon = rs.getInt(15);
                BigDecimal giaBan = rs.getBigDecimal(16);
                String moTa = rs.getString(17);
                int trangThai = rs.getInt(18);

                SanPham sp = new SanPham(idsp, "", tenSP, "");
                ChiTietSPVM ct = new ChiTietSPVM(id, sp, hang, kieudang, mausac, nhienlieu, dongxe, hopso, dongco, chongoi, phankhuc, xuatxu, namSX, slTon, giaBan, moTa, trangThai);
                lstSP.add(ct);
            }
            return lstSP;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<ChiTietSPVM> getAll_TrangThai(int txt) {
        ArrayList<ChiTietSPVM> lstSP = new ArrayList<>();
        try {
            Connection con = DBConnect.getConnection();
            String query = "SELECT dbo.CHITIETSP.id, dbo.SANPHAM.id AS Expr1, dbo.SANPHAM.ten, dbo.CHITIETSP.HangSP, dbo.CHITIETSP.KieuDang, "
                    + "dbo.CHITIETSP.MauSac, dbo.CHITIETSP.NhienLieu, dbo.CHITIETSP.DongXe, dbo.CHITIETSP.HopSo, \n"
                    + "      dbo.CHITIETSP.DongCo, dbo.CHITIETSP.ChoNgoi, dbo.CHITIETSP.PhanKhuc, dbo.CHITIETSP.XuatXu,"
                    + " dbo.CHITIETSP.NamSX, dbo.CHITIETSP.SoLuongTon, dbo.CHITIETSP.GiaBan, dbo.CHITIETSP.MoTa, dbo.CHITIETSP.trangThai\n"
                    + "FROM  dbo.CHITIETSP INNER JOIN\n"
                    + "      dbo.SANPHAM ON dbo.CHITIETSP.idSP = dbo.SANPHAM.id WHERE dbo.CHITIETSP.trangThai=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, txt);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                String id = rs.getString(1);
                String idsp = rs.getString(2);
                String tenSP = rs.getString(3);
                String hang = rs.getString(4);
                String kieudang = rs.getString(5);
                String mausac = rs.getString(6);
                String nhienlieu = rs.getString(7);
                String dongxe = rs.getString(8);
                String hopso = rs.getString(9);
                String dongco = rs.getString(10);
                String chongoi = rs.getString(11);
                String phankhuc = rs.getString(12);
                String xuatxu = rs.getString(13);
                int namSX = rs.getInt(14);
                Integer slTon = rs.getInt(15);
                BigDecimal giaBan = rs.getBigDecimal(16);
                String moTa = rs.getString(17);
                int trangThai = rs.getInt(18);

                SanPham sp = new SanPham(idsp, "", tenSP, "");
                ChiTietSPVM ct = new ChiTietSPVM(id, sp, hang, kieudang, mausac, nhienlieu, dongxe, hopso, dongco, chongoi, phankhuc, xuatxu, namSX, slTon, giaBan, moTa, trangThai);
                lstSP.add(ct);
            }
            return lstSP;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<ChiTietSPVM> getLocTheoHang(String txt) {
        ArrayList<ChiTietSPVM> lstSP = new ArrayList<>();
        try {
            Connection con = DBConnect.getConnection();
            String query = "SELECT dbo.CHITIETSP.id, dbo.SANPHAM.id AS Expr1, dbo.SANPHAM.ten, dbo.CHITIETSP.HangSP, dbo.CHITIETSP.KieuDang, "
                    + "dbo.CHITIETSP.MauSac, dbo.CHITIETSP.NhienLieu, dbo.CHITIETSP.DongXe, dbo.CHITIETSP.HopSo, \n"
                    + "      dbo.CHITIETSP.DongCo, dbo.CHITIETSP.ChoNgoi, dbo.CHITIETSP.PhanKhuc, dbo.CHITIETSP.XuatXu,"
                    + " dbo.CHITIETSP.NamSX, dbo.CHITIETSP.SoLuongTon, dbo.CHITIETSP.GiaBan, dbo.CHITIETSP.MoTa, dbo.CHITIETSP.trangThai\n"
                    + "FROM  dbo.CHITIETSP INNER JOIN\n"
                    + "      dbo.SANPHAM ON dbo.CHITIETSP.idSP = dbo.SANPHAM.id WHERE dbo.CHITIETSP.HangSP=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, txt);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                String id = rs.getString(1);
                String idsp = rs.getString(2);
                String tenSP = rs.getString(3);
                String hang = rs.getString(4);
                String kieudang = rs.getString(5);
                String mausac = rs.getString(6);
                String nhienlieu = rs.getString(7);
                String dongxe = rs.getString(8);
                String hopso = rs.getString(9);
                String dongco = rs.getString(10);
                String chongoi = rs.getString(11);
                String phankhuc = rs.getString(12);
                String xuatxu = rs.getString(13);
                int namSX = rs.getInt(14);
                Integer slTon = rs.getInt(15);
                BigDecimal giaBan = rs.getBigDecimal(16);
                String moTa = rs.getString(17);
                int trangThai = rs.getInt(18);

                SanPham sp = new SanPham(idsp, "", tenSP, "");
                ChiTietSPVM ct = new ChiTietSPVM(id, sp, hang, kieudang, mausac, nhienlieu, dongxe, hopso, dongco, chongoi, phankhuc, xuatxu, namSX, slTon, giaBan, moTa, trangThai);
                lstSP.add(ct);
            }
            return lstSP;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<ChiTietSPVM> getLocTheoKieuDang(String txt) {
        ArrayList<ChiTietSPVM> lstSP = new ArrayList<>();
        try {
            Connection con = DBConnect.getConnection();
            String query = "SELECT dbo.CHITIETSP.id, dbo.SANPHAM.id AS Expr1, dbo.SANPHAM.ten, dbo.CHITIETSP.HangSP, dbo.CHITIETSP.KieuDang, "
                    + "dbo.CHITIETSP.MauSac, dbo.CHITIETSP.NhienLieu, dbo.CHITIETSP.DongXe, dbo.CHITIETSP.HopSo, \n"
                    + "      dbo.CHITIETSP.DongCo, dbo.CHITIETSP.ChoNgoi, dbo.CHITIETSP.PhanKhuc, dbo.CHITIETSP.XuatXu,"
                    + " dbo.CHITIETSP.NamSX, dbo.CHITIETSP.SoLuongTon, dbo.CHITIETSP.GiaBan, dbo.CHITIETSP.MoTa, dbo.CHITIETSP.trangThai\n"
                    + "FROM  dbo.CHITIETSP INNER JOIN\n"
                    + "      dbo.SANPHAM ON dbo.CHITIETSP.idSP = dbo.SANPHAM.id WHERE dbo.CHITIETSP.KieuDang=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, txt);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                String id = rs.getString(1);
                String idsp = rs.getString(2);
                String tenSP = rs.getString(3);
                String hang = rs.getString(4);
                String kieudang = rs.getString(5);
                String mausac = rs.getString(6);
                String nhienlieu = rs.getString(7);
                String dongxe = rs.getString(8);
                String hopso = rs.getString(9);
                String dongco = rs.getString(10);
                String chongoi = rs.getString(11);
                String phankhuc = rs.getString(12);
                String xuatxu = rs.getString(13);
                int namSX = rs.getInt(14);
                Integer slTon = rs.getInt(15);
                BigDecimal giaBan = rs.getBigDecimal(16);
                String moTa = rs.getString(17);
                int trangThai = rs.getInt(18);

                SanPham sp = new SanPham(idsp, "", tenSP, "");
                ChiTietSPVM ct = new ChiTietSPVM(id, sp, hang, kieudang, mausac, nhienlieu, dongxe, hopso, dongco, chongoi, phankhuc, xuatxu, namSX, slTon, giaBan, moTa, trangThai);
                lstSP.add(ct);
            }
            return lstSP;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<ChiTietSPVM> getLocTheoMauSac(String txt) {
        ArrayList<ChiTietSPVM> lstSP = new ArrayList<>();
        try {
            Connection con = DBConnect.getConnection();
            String query = "SELECT dbo.CHITIETSP.id, dbo.SANPHAM.id AS Expr1, dbo.SANPHAM.ten, dbo.CHITIETSP.HangSP, dbo.CHITIETSP.KieuDang, "
                    + "dbo.CHITIETSP.MauSac, dbo.CHITIETSP.NhienLieu, dbo.CHITIETSP.DongXe, dbo.CHITIETSP.HopSo, \n"
                    + "      dbo.CHITIETSP.DongCo, dbo.CHITIETSP.ChoNgoi, dbo.CHITIETSP.PhanKhuc, dbo.CHITIETSP.XuatXu,"
                    + " dbo.CHITIETSP.NamSX, dbo.CHITIETSP.SoLuongTon, dbo.CHITIETSP.GiaBan, dbo.CHITIETSP.MoTa, dbo.CHITIETSP.trangThai\n"
                    + "FROM  dbo.CHITIETSP INNER JOIN\n"
                    + "      dbo.SANPHAM ON dbo.CHITIETSP.idSP = dbo.SANPHAM.id WHERE dbo.CHITIETSP.MauSac=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, txt);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                String id = rs.getString(1);
                String idsp = rs.getString(2);
                String tenSP = rs.getString(3);
                String hang = rs.getString(4);
                String kieudang = rs.getString(5);
                String mausac = rs.getString(6);
                String nhienlieu = rs.getString(7);
                String dongxe = rs.getString(8);
                String hopso = rs.getString(9);
                String dongco = rs.getString(10);
                String chongoi = rs.getString(11);
                String phankhuc = rs.getString(12);
                String xuatxu = rs.getString(13);
                int namSX = rs.getInt(14);
                Integer slTon = rs.getInt(15);
                BigDecimal giaBan = rs.getBigDecimal(16);
                String moTa = rs.getString(17);
                int trangThai = rs.getInt(18);

                SanPham sp = new SanPham(idsp, "", tenSP, "");
                ChiTietSPVM ct = new ChiTietSPVM(id, sp, hang, kieudang, mausac, nhienlieu, dongxe, hopso, dongco, chongoi, phankhuc, xuatxu, namSX, slTon, giaBan, moTa, trangThai);
                lstSP.add(ct);
            }
            return lstSP;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<ChiTietSPVM> getLocTheoNhienLieu(String txt) {
        ArrayList<ChiTietSPVM> lstSP = new ArrayList<>();
        try {
            Connection con = DBConnect.getConnection();
            String query = "SELECT dbo.CHITIETSP.id, dbo.SANPHAM.id AS Expr1, dbo.SANPHAM.ten, dbo.CHITIETSP.HangSP, dbo.CHITIETSP.KieuDang, "
                    + "dbo.CHITIETSP.MauSac, dbo.CHITIETSP.NhienLieu, dbo.CHITIETSP.DongXe, dbo.CHITIETSP.HopSo, \n"
                    + "      dbo.CHITIETSP.DongCo, dbo.CHITIETSP.ChoNgoi, dbo.CHITIETSP.PhanKhuc, dbo.CHITIETSP.XuatXu,"
                    + " dbo.CHITIETSP.NamSX, dbo.CHITIETSP.SoLuongTon, dbo.CHITIETSP.GiaBan, dbo.CHITIETSP.MoTa, dbo.CHITIETSP.trangThai\n"
                    + "FROM  dbo.CHITIETSP INNER JOIN\n"
                    + "      dbo.SANPHAM ON dbo.CHITIETSP.idSP = dbo.SANPHAM.id WHERE dbo.CHITIETSP.NhienLieu=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, txt);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                String id = rs.getString(1);
                String idsp = rs.getString(2);
                String tenSP = rs.getString(3);
                String hang = rs.getString(4);
                String kieudang = rs.getString(5);
                String mausac = rs.getString(6);
                String nhienlieu = rs.getString(7);
                String dongxe = rs.getString(8);
                String hopso = rs.getString(9);
                String dongco = rs.getString(10);
                String chongoi = rs.getString(11);
                String phankhuc = rs.getString(12);
                String xuatxu = rs.getString(13);
                int namSX = rs.getInt(14);
                Integer slTon = rs.getInt(15);
                BigDecimal giaBan = rs.getBigDecimal(16);
                String moTa = rs.getString(17);
                int trangThai = rs.getInt(18);

                SanPham sp = new SanPham(idsp, "", tenSP, "");
                ChiTietSPVM ct = new ChiTietSPVM(id, sp, hang, kieudang, mausac, nhienlieu, dongxe, hopso, dongco, chongoi, phankhuc, xuatxu, namSX, slTon, giaBan, moTa, trangThai);
                lstSP.add(ct);
            }
            return lstSP;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<ChiTietSPVM> getLocTheoDongXe(String txt) {
        ArrayList<ChiTietSPVM> lstSP = new ArrayList<>();
        try {
            Connection con = DBConnect.getConnection();
            String query = "SELECT dbo.CHITIETSP.id, dbo.SANPHAM.id AS Expr1, dbo.SANPHAM.ten, dbo.CHITIETSP.HangSP, dbo.CHITIETSP.KieuDang, "
                    + "dbo.CHITIETSP.MauSac, dbo.CHITIETSP.NhienLieu, dbo.CHITIETSP.DongXe, dbo.CHITIETSP.HopSo, \n"
                    + "      dbo.CHITIETSP.DongCo, dbo.CHITIETSP.ChoNgoi, dbo.CHITIETSP.PhanKhuc, dbo.CHITIETSP.XuatXu,"
                    + " dbo.CHITIETSP.NamSX, dbo.CHITIETSP.SoLuongTon, dbo.CHITIETSP.GiaBan, dbo.CHITIETSP.MoTa, dbo.CHITIETSP.trangThai\n"
                    + "FROM  dbo.CHITIETSP INNER JOIN\n"
                    + "      dbo.SANPHAM ON dbo.CHITIETSP.idSP = dbo.SANPHAM.id WHERE dbo.CHITIETSP.DongXe=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, txt);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                String id = rs.getString(1);
                String idsp = rs.getString(2);
                String tenSP = rs.getString(3);
                String hang = rs.getString(4);
                String kieudang = rs.getString(5);
                String mausac = rs.getString(6);
                String nhienlieu = rs.getString(7);
                String dongxe = rs.getString(8);
                String hopso = rs.getString(9);
                String dongco = rs.getString(10);
                String chongoi = rs.getString(11);
                String phankhuc = rs.getString(12);
                String xuatxu = rs.getString(13);
                int namSX = rs.getInt(14);
                Integer slTon = rs.getInt(15);
                BigDecimal giaBan = rs.getBigDecimal(16);
                String moTa = rs.getString(17);
                int trangThai = rs.getInt(18);

                SanPham sp = new SanPham(idsp, "", tenSP, "");
                ChiTietSPVM ct = new ChiTietSPVM(id, sp, hang, kieudang, mausac, nhienlieu, dongxe, hopso, dongco, chongoi, phankhuc, xuatxu, namSX, slTon, giaBan, moTa, trangThai);
                lstSP.add(ct);
            }
            return lstSP;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<ChiTietSPVM> getLocTheoDongco(String txt) {
        ArrayList<ChiTietSPVM> lstSP = new ArrayList<>();
        try {
            Connection con = DBConnect.getConnection();
            String query = "SELECT dbo.CHITIETSP.id, dbo.SANPHAM.id AS Expr1, dbo.SANPHAM.ten, dbo.CHITIETSP.HangSP, dbo.CHITIETSP.KieuDang, "
                    + "dbo.CHITIETSP.MauSac, dbo.CHITIETSP.NhienLieu, dbo.CHITIETSP.DongXe, dbo.CHITIETSP.HopSo, \n"
                    + "      dbo.CHITIETSP.DongCo, dbo.CHITIETSP.ChoNgoi, dbo.CHITIETSP.PhanKhuc, dbo.CHITIETSP.XuatXu,"
                    + " dbo.CHITIETSP.NamSX, dbo.CHITIETSP.SoLuongTon, dbo.CHITIETSP.GiaBan, dbo.CHITIETSP.MoTa, dbo.CHITIETSP.trangThai\n"
                    + "FROM  dbo.CHITIETSP INNER JOIN\n"
                    + "      dbo.SANPHAM ON dbo.CHITIETSP.idSP = dbo.SANPHAM.id WHERE dbo.CHITIETSP.DongCo=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, txt);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                String id = rs.getString(1);
                String idsp = rs.getString(2);
                String tenSP = rs.getString(3);
                String hang = rs.getString(4);
                String kieudang = rs.getString(5);
                String mausac = rs.getString(6);
                String nhienlieu = rs.getString(7);
                String dongxe = rs.getString(8);
                String hopso = rs.getString(9);
                String dongco = rs.getString(10);
                String chongoi = rs.getString(11);
                String phankhuc = rs.getString(12);
                String xuatxu = rs.getString(13);
                int namSX = rs.getInt(14);
                Integer slTon = rs.getInt(15);
                BigDecimal giaBan = rs.getBigDecimal(16);
                String moTa = rs.getString(17);
                int trangThai = rs.getInt(18);

                SanPham sp = new SanPham(idsp, "", tenSP, "");
                ChiTietSPVM ct = new ChiTietSPVM(id, sp, hang, kieudang, mausac, nhienlieu, dongxe, hopso, dongco, chongoi, phankhuc, xuatxu, namSX, slTon, giaBan, moTa, trangThai);
                lstSP.add(ct);
            }
            return lstSP;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<ChiTietSPVM> getLocChongoi(String txt) {
        ArrayList<ChiTietSPVM> lstSP = new ArrayList<>();
        try {
            Connection con = DBConnect.getConnection();
            String query = "SELECT dbo.CHITIETSP.id, dbo.SANPHAM.id AS Expr1, dbo.SANPHAM.ten, dbo.CHITIETSP.HangSP, dbo.CHITIETSP.KieuDang, "
                    + "dbo.CHITIETSP.MauSac, dbo.CHITIETSP.NhienLieu, dbo.CHITIETSP.DongXe, dbo.CHITIETSP.HopSo, \n"
                    + "      dbo.CHITIETSP.DongCo, dbo.CHITIETSP.ChoNgoi, dbo.CHITIETSP.PhanKhuc, dbo.CHITIETSP.XuatXu,"
                    + " dbo.CHITIETSP.NamSX, dbo.CHITIETSP.SoLuongTon, dbo.CHITIETSP.GiaBan, dbo.CHITIETSP.MoTa, dbo.CHITIETSP.trangThai\n"
                    + "FROM  dbo.CHITIETSP INNER JOIN\n"
                    + "      dbo.SANPHAM ON dbo.CHITIETSP.idSP = dbo.SANPHAM.id WHERE dbo.CHITIETSP.ChoNgoi=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, txt);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                String id = rs.getString(1);
                String idsp = rs.getString(2);
                String tenSP = rs.getString(3);
                String hang = rs.getString(4);
                String kieudang = rs.getString(5);
                String mausac = rs.getString(6);
                String nhienlieu = rs.getString(7);
                String dongxe = rs.getString(8);
                String hopso = rs.getString(9);
                String dongco = rs.getString(10);
                String chongoi = rs.getString(11);
                String phankhuc = rs.getString(12);
                String xuatxu = rs.getString(13);
                int namSX = rs.getInt(14);
                Integer slTon = rs.getInt(15);
                BigDecimal giaBan = rs.getBigDecimal(16);
                String moTa = rs.getString(17);
                int trangThai = rs.getInt(18);

                SanPham sp = new SanPham(idsp, "", tenSP, "");
                ChiTietSPVM ct = new ChiTietSPVM(id, sp, hang, kieudang, mausac, nhienlieu, dongxe, hopso, dongco, chongoi, phankhuc, xuatxu, namSX, slTon, giaBan, moTa, trangThai);
                lstSP.add(ct);
            }
            return lstSP;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<ChiTietSPVM> getLocHopso(String txt) {
        ArrayList<ChiTietSPVM> lstSP = new ArrayList<>();
        try {
            Connection con = DBConnect.getConnection();
            String query = "SELECT dbo.CHITIETSP.id, dbo.SANPHAM.id AS Expr1, dbo.SANPHAM.ten, dbo.CHITIETSP.HangSP, dbo.CHITIETSP.KieuDang, "
                    + "dbo.CHITIETSP.MauSac, dbo.CHITIETSP.NhienLieu, dbo.CHITIETSP.DongXe, dbo.CHITIETSP.HopSo, \n"
                    + "      dbo.CHITIETSP.DongCo, dbo.CHITIETSP.ChoNgoi, dbo.CHITIETSP.PhanKhuc, dbo.CHITIETSP.XuatXu,"
                    + " dbo.CHITIETSP.NamSX, dbo.CHITIETSP.SoLuongTon, dbo.CHITIETSP.GiaBan, dbo.CHITIETSP.MoTa, dbo.CHITIETSP.trangThai\n"
                    + "FROM  dbo.CHITIETSP INNER JOIN\n"
                    + "      dbo.SANPHAM ON dbo.CHITIETSP.idSP = dbo.SANPHAM.id WHERE dbo.CHITIETSP.HopSo=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, txt);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                String id = rs.getString(1);
                String idsp = rs.getString(2);
                String tenSP = rs.getString(3);
                String hang = rs.getString(4);
                String kieudang = rs.getString(5);
                String mausac = rs.getString(6);
                String nhienlieu = rs.getString(7);
                String dongxe = rs.getString(8);
                String hopso = rs.getString(9);
                String dongco = rs.getString(10);
                String chongoi = rs.getString(11);
                String phankhuc = rs.getString(12);
                String xuatxu = rs.getString(13);
                int namSX = rs.getInt(14);
                Integer slTon = rs.getInt(15);
                BigDecimal giaBan = rs.getBigDecimal(16);
                String moTa = rs.getString(17);
                int trangThai = rs.getInt(18);

                SanPham sp = new SanPham(idsp, "", tenSP, "");
                ChiTietSPVM ct = new ChiTietSPVM(id, sp, hang, kieudang, mausac, nhienlieu, dongxe, hopso, dongco, chongoi, phankhuc, xuatxu, namSX, slTon, giaBan, moTa, trangThai);
                lstSP.add(ct);
            }
            return lstSP;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<ChiTietSPVM> getLocPhanKhuc(String txt) {
        ArrayList<ChiTietSPVM> lstSP = new ArrayList<>();
        try {
            Connection con = DBConnect.getConnection();
            String query = "SELECT dbo.CHITIETSP.id, dbo.SANPHAM.id AS Expr1, dbo.SANPHAM.ten, dbo.CHITIETSP.HangSP, dbo.CHITIETSP.KieuDang, "
                    + "dbo.CHITIETSP.MauSac, dbo.CHITIETSP.NhienLieu, dbo.CHITIETSP.DongXe, dbo.CHITIETSP.HopSo, \n"
                    + "      dbo.CHITIETSP.DongCo, dbo.CHITIETSP.ChoNgoi, dbo.CHITIETSP.PhanKhuc, dbo.CHITIETSP.XuatXu,"
                    + " dbo.CHITIETSP.NamSX, dbo.CHITIETSP.SoLuongTon, dbo.CHITIETSP.GiaBan, dbo.CHITIETSP.MoTa, dbo.CHITIETSP.trangThai\n"
                    + "FROM  dbo.CHITIETSP INNER JOIN\n"
                    + "      dbo.SANPHAM ON dbo.CHITIETSP.idSP = dbo.SANPHAM.id WHERE dbo.CHITIETSP.PhanKhuc=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, txt);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                String id = rs.getString(1);
                String idsp = rs.getString(2);
                String tenSP = rs.getString(3);
                String hang = rs.getString(4);
                String kieudang = rs.getString(5);
                String mausac = rs.getString(6);
                String nhienlieu = rs.getString(7);
                String dongxe = rs.getString(8);
                String hopso = rs.getString(9);
                String dongco = rs.getString(10);
                String chongoi = rs.getString(11);
                String phankhuc = rs.getString(12);
                String xuatxu = rs.getString(13);
                int namSX = rs.getInt(14);
                Integer slTon = rs.getInt(15);
                BigDecimal giaBan = rs.getBigDecimal(16);
                String moTa = rs.getString(17);
                int trangThai = rs.getInt(18);

                SanPham sp = new SanPham(idsp, "", tenSP, "");
                ChiTietSPVM ct = new ChiTietSPVM(id, sp, hang, kieudang, mausac, nhienlieu, dongxe, hopso, dongco, chongoi, phankhuc, xuatxu, namSX, slTon, giaBan, moTa, trangThai);
                lstSP.add(ct);
            }
            return lstSP;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
