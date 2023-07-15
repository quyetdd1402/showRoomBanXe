package com.raven.service;

import com.raven.viewmodel.ChiTietSPVM;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;

public interface CTSPService {

    public ArrayList<ChiTietSPVM> getList();

    public ArrayList<ChiTietSPVM> getSeach(String ten);

    public ArrayList<ChiTietSPVM> getLocTrangThai(int txt);

    public ArrayList<ChiTietSPVM> getLocTheoGia(BigDecimal gia1, BigDecimal gia2);

    public ArrayList<ChiTietSPVM> getLocTheoGiaT(BigDecimal giaT);

    public ArrayList<ChiTietSPVM> getLocTheoHang(String txt);

    public ArrayList<ChiTietSPVM> getLocTheoDongXe(String txt);

    public ArrayList<ChiTietSPVM> getLocTheoPhanKhuc(String txt);

    public ArrayList<ChiTietSPVM> getLocTheoChoNgoi(String txt);

    public ArrayList<ChiTietSPVM> getLocTheoKieuDang(String txt);

    public ArrayList<ChiTietSPVM> getLocTheoDongco(String txt);

    public ArrayList<ChiTietSPVM> getLocTheoHopso(String txt);

    public ArrayList<ChiTietSPVM> getLocTheoNhienlieu(String txt);

    public ArrayList<ChiTietSPVM> getLocTheoMausac(String txt);

    public ArrayList<ChiTietSPVM> getTop2_SL();

    public ArrayList<ChiTietSPVM> getSX_GiaBan_Tang();

    public ArrayList<ChiTietSPVM> getSX_GiaBan_Giam();

    public boolean insert(ChiTietSPVM qlCT);

    public boolean update(String id, ChiTietSPVM qlCT);

    public boolean delete(String id);

    public boolean xuatDS(File files);
    
    
}
