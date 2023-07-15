select ngayThanhToan,sum(tongTien-soTienGiam) as tongDoanhThu,count(id) as soLuongHoaDon from hoadon where trangThai =1 and '2020-10-11'<=ngayThanhToan and ngayThanhToan<= '2021-09-01' group by ngayThanhToan  

select * from hoaDon

select year(ngayThanhToan) from HOADON group by year(ngayThanhToan) order by year(ngayThanhToan) desc

select year(ngaythanhtoan) as nam,sum(tongTien-soTienGiam) as tongTien,sum(tongTien-soTienGiam)/12 as trungBinh,(select top 1 month(ngayThanhToan) from HOADON where year(ngaythanhtoan) ='2022' group by month(ngayThanhToan) order by sum(tongTien-soTienGiam) desc ) as thangNhieuNhat,(select top 1 month(ngayThanhToan) from HOADON where year(ngaythanhtoan) ='2022' group by month(ngayThanhToan) order by sum(tongTien-soTienGiam) asc ) as thangItNhat from HOADON where year(ngaythanhtoan) ='2022' group by year(ngayThanhToan)

delete from DICHVU where idHoaDon=(select id from HOADON where ma='')
delete from HOADON where ma='' 

update DICHVU set baoHiem='',lamBien='' where idHoaDon=(select id from HOADON where ma='')
update HOADON set tenXe='',tenNV='',tenKH='',ngayTao='',ngayThanhToan='',tongTien='',soTienGiam='',SĐTNguoiNhan='',trangThai='' where ma=''

insert into HOADON(ma,tenXe,tenNV,tenKH,ngayTao,ngayThanhToan,tongTien,soTienGiam,SĐTNguoiNhan,trangThai) values('','','','','','',10000000,10000,'',1)

insert into DICHVU(id,idHoaDon,idNhanVien,idKhachHang,baoHiem,lamBien) values(NEWID(),(select id from HOADON where ma='ma3'),(select idNhanVien from HOADON where ma='ma3'),(select idKhachHang from HOADON where ma='ma3'),1,0)
