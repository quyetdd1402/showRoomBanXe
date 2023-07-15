
package com.raven.model;

public class NhanVien {

    private String id;
    private String maNV;
    private String ten;
    private int vaiTro;
    private String ngaySinh;
    private boolean gioiTinh;
    private String sdt;
    private String email;
    private String diaChi;
    private String anh;
    private String luong;
    private int trangThai;

    public NhanVien() {
    }

    public NhanVien(String id, String maNV, String ten, int vaiTro, String ngaySinh, boolean gioiTinh, String sdt, String email, String diaChi, String anh, String luong, int trangThai) {
        this.id = id;
        this.maNV = maNV;
        this.ten = ten;
        this.vaiTro = vaiTro;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
        this.anh = anh;
        this.luong = luong;
        this.trangThai = trangThai;
    }

    public NhanVien(String maNV, String ten, int vaiTro, String ngaySinh, boolean gioiTinh, String sdt, String email, String diaChi, String anh, String luong, int trangThai) {
        this.maNV = maNV;
        this.ten = ten;
        this.vaiTro = vaiTro;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
        this.anh = anh;
        this.luong = luong;
        this.trangThai = trangThai;
    }

     

    

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(int vaiTro) {
        this.vaiTro = vaiTro;
    }

     
 


    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getLuong() {
        return luong;
    }

    public void setLuong(String luong) {
        this.luong = luong;
    }
    
    

    @Override
    public String toString() {
        return "NhanVien{" + "id=" + id + ", maNV=" + maNV + ", ten=" + ten + ", vaiTro=" + vaiTro + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", sdt=" + sdt + ", email=" + email + ", diaChi=" + diaChi + ", anh=" + anh + ", trangThai=" + trangThai + '}';
    }

    public Object[] toRowData() {
        return new Object[]{id, maNV, ten, vaiTro == 0 ? "Quản lý": "Nhân viên", ngaySinh  , gioiTinh == true ? "Nam" : "Nữ", sdt, email, diaChi, anh, luong, trangThai == 0 ? "Đang làm việc" : "Nghỉ việc"};
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NhanVien) {
            NhanVien nv = (NhanVien) obj;
            if (this.maNV.equals(nv.maNV)) {
                return true;
            }
        }
        return false;
    }

}
