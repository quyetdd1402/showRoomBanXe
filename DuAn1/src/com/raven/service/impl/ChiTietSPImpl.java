package com.raven.service.impl;

import com.raven.model.ChiTietSP;
import com.raven.model.SanPham;
import com.raven.repository.ChiTietSPRepository;
import com.raven.service.CTSPService;
import com.raven.viewmodel.ChiTietSPVM;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ChiTietSPImpl implements CTSPService {

    private ChiTietSPRepository spRepo = new ChiTietSPRepository();
    public static final SanPhamImpl spsv = new SanPhamImpl();
    public static final int COLUMN_INDEX_ID = 0;
    public static final int COLUMN_INDEX_Ten = 1;
    public static final int COLUMN_INDEX_Hang = 2;
    public static final int COLUMN_INDEX_Kieudang = 3;
    public static final int COLUMN_INDEX_Mausac = 4;
    public static final int COLUMN_INDEX_Nhienlieu = 5;
    public static final int COLUMN_INDEX_Dongxe = 6;
    public static final int COLUMN_INDEX_Hopso = 7;
    public static final int COLUMN_INDEX_Dongco = 8;
    public static final int COLUMN_INDEX_Chongoi = 9;
    public static final int COLUMN_INDEX_Phankhuc = 10;
    public static final int COLUMN_INDEX_Xuatxu = 11;
    public static final int COLUMN_INDEX_NamSX = 12;
    public static final int COLUMN_INDEX_SLTon = 13;
    public static final int COLUMN_INDEX_GiaBan = 14;
    public static final int COLUMN_INDEX_Mota = 15;
    public static final int COLUMN_INDEX_Trangthai = 16;

    @Override
    public ArrayList<ChiTietSPVM> getList() {
        ArrayList<ChiTietSPVM> lst = new ArrayList<>();
        var lstCtsp = spRepo.getAll();
        for (ChiTietSPVM x : lstCtsp) {
            lst.add(new ChiTietSPVM(x.getId(), x.getSanPham(), x.getHangSP(), x.getKieudang(), x.getMausac(), x.getNhienlieu(), x.getDongxe(), x.getHopso(), x.getDongco(), x.getChongoi(), x.getPhankhuc(), x.getXuatxu(), x.getNamSX(), x.getSoLuongTon(), x.getDongia(), x.getMoTa(), x.getTrangthai()));
        }
        return lst;
    }

    @Override
    public ArrayList<ChiTietSPVM> getSeach(String ten) {
        ArrayList<ChiTietSPVM> lst = new ArrayList<>();
        var lstCtsp = spRepo.getOne(ten);
        for (ChiTietSPVM x : lstCtsp) {
            lst.add(new ChiTietSPVM(x.getId(), x.getSanPham(), x.getHangSP(), x.getKieudang(), x.getMausac(), x.getNhienlieu(), x.getDongxe(), x.getHopso(), x.getDongco(), x.getChongoi(), x.getPhankhuc(), x.getXuatxu(), x.getNamSX(), x.getSoLuongTon(), x.getDongia(), x.getMoTa(), x.getTrangthai()));
        }
        return lst;
    }

    @Override
    public boolean insert(ChiTietSPVM x) {
        return this.spRepo.add(new ChiTietSPVM(x.getId(), x.getSanPham(), x.getHangSP(), x.getKieudang(), x.getMausac(), x.getNhienlieu(), x.getDongxe(), x.getHopso(), x.getDongco(), x.getChongoi(), x.getPhankhuc(), x.getXuatxu(), x.getNamSX(), x.getSoLuongTon(), x.getDongia(), x.getMoTa(), x.getTrangthai()));
    }

    @Override
    public boolean update(String id, ChiTietSPVM x) {
        return this.spRepo.add(new ChiTietSPVM(x.getId(), x.getSanPham(), x.getHangSP(), x.getKieudang(), x.getMausac(), x.getNhienlieu(), x.getDongxe(), x.getHopso(), x.getDongco(), x.getChongoi(), x.getPhankhuc(), x.getXuatxu(), x.getNamSX(), x.getSoLuongTon(), x.getDongia(), x.getMoTa(), x.getTrangthai()));
    }

    @Override
    public boolean delete(String id) {
        return spRepo.delete(id);
    }

    @Override
    public ArrayList<ChiTietSPVM> getLocTrangThai(int txt) {
        ArrayList<ChiTietSPVM> lst = new ArrayList<>();
        var lstCtsp = spRepo.getAll_TrangThai(txt);
        for (ChiTietSPVM x : lstCtsp) {
            lst.add(new ChiTietSPVM(x.getId(), x.getSanPham(), x.getHangSP(), x.getKieudang(), x.getMausac(), x.getNhienlieu(), x.getDongxe(), x.getHopso(), x.getDongco(), x.getChongoi(), x.getPhankhuc(), x.getXuatxu(), x.getNamSX(), x.getSoLuongTon(), x.getDongia(), x.getMoTa(), x.getTrangthai()));
        }
        return lst;
    }

    @Override
    public ArrayList<ChiTietSPVM> getTop2_SL() {
        ArrayList<ChiTietSPVM> lst = new ArrayList<>();
        var lstCtsp = spRepo.getTop3_SL();
        for (ChiTietSPVM x : lstCtsp) {
            lst.add(new ChiTietSPVM(x.getId(), x.getSanPham(), x.getHangSP(), x.getKieudang(), x.getMausac(), x.getNhienlieu(), x.getDongxe(), x.getHopso(), x.getDongco(), x.getChongoi(), x.getPhankhuc(), x.getXuatxu(), x.getNamSX(), x.getSoLuongTon(), x.getDongia(), x.getMoTa(), x.getTrangthai()));
        }
        return lst;
    }

    @Override
    public ArrayList<ChiTietSPVM> getSX_GiaBan_Tang() {
        ArrayList<ChiTietSPVM> lst = new ArrayList<>();
        var lstCtsp = spRepo.getSXGia_Tang();
        for (ChiTietSPVM x : lstCtsp) {
            lst.add(new ChiTietSPVM(x.getId(), x.getSanPham(), x.getHangSP(), x.getKieudang(), x.getMausac(), x.getNhienlieu(), x.getDongxe(), x.getHopso(), x.getDongco(), x.getChongoi(), x.getPhankhuc(), x.getXuatxu(), x.getNamSX(), x.getSoLuongTon(), x.getDongia(), x.getMoTa(), x.getTrangthai()));
        }
        return lst;
    }

    @Override
    public ArrayList<ChiTietSPVM> getSX_GiaBan_Giam() {
        ArrayList<ChiTietSPVM> lst = new ArrayList<>();
        var lstCtsp = spRepo.getSXGia_Giam();
        for (ChiTietSPVM x : lstCtsp) {
            lst.add(new ChiTietSPVM(x.getId(), x.getSanPham(), x.getHangSP(), x.getKieudang(), x.getMausac(), x.getNhienlieu(), x.getDongxe(), x.getHopso(), x.getDongco(), x.getChongoi(), x.getPhankhuc(), x.getXuatxu(), x.getNamSX(), x.getSoLuongTon(), x.getDongia(), x.getMoTa(), x.getTrangthai()));
        }
        return lst;
    }

    @Override
    public ArrayList<ChiTietSPVM> getLocTheoHang(String txt) {
        ArrayList<ChiTietSPVM> lst = new ArrayList<>();
        var lstCtsp = spRepo.getLocTheoHang(txt);
        for (ChiTietSPVM x : lstCtsp) {
            lst.add(new ChiTietSPVM(x.getId(), x.getSanPham(), x.getHangSP(), x.getKieudang(), x.getMausac(), x.getNhienlieu(), x.getDongxe(), x.getHopso(), x.getDongco(), x.getChongoi(), x.getPhankhuc(), x.getXuatxu(), x.getNamSX(), x.getSoLuongTon(), x.getDongia(), x.getMoTa(), x.getTrangthai()));
        }
        return lst;
    }

    @Override
    public ArrayList<ChiTietSPVM> getLocTheoDongXe(String txt) {
        ArrayList<ChiTietSPVM> lst = new ArrayList<>();
        var lstCtsp = spRepo.getLocTheoDongXe(txt);
        for (ChiTietSPVM x : lstCtsp) {
            lst.add(new ChiTietSPVM(x.getId(), x.getSanPham(), x.getHangSP(), x.getKieudang(), x.getMausac(), x.getNhienlieu(), x.getDongxe(), x.getHopso(), x.getDongco(), x.getChongoi(), x.getPhankhuc(), x.getXuatxu(), x.getNamSX(), x.getSoLuongTon(), x.getDongia(), x.getMoTa(), x.getTrangthai()));
        }
        return lst;
    }

    @Override
    public ArrayList<ChiTietSPVM> getLocTheoChoNgoi(String txt) {
        ArrayList<ChiTietSPVM> lst = new ArrayList<>();
        var lstCtsp = spRepo.getLocChongoi(txt);
        for (ChiTietSPVM x : lstCtsp) {
            lst.add(new ChiTietSPVM(x.getId(), x.getSanPham(), x.getHangSP(), x.getKieudang(), x.getMausac(), x.getNhienlieu(), x.getDongxe(), x.getHopso(), x.getDongco(), x.getChongoi(), x.getPhankhuc(), x.getXuatxu(), x.getNamSX(), x.getSoLuongTon(), x.getDongia(), x.getMoTa(), x.getTrangthai()));
        }
        return lst;
    }

    @Override
    public ArrayList<ChiTietSPVM> getLocTheoPhanKhuc(String txt) {
        ArrayList<ChiTietSPVM> lst = new ArrayList<>();
        var lstCtsp = spRepo.getLocPhanKhuc(txt);
        for (ChiTietSPVM x : lstCtsp) {
            lst.add(new ChiTietSPVM(x.getId(), x.getSanPham(), x.getHangSP(), x.getKieudang(), x.getMausac(), x.getNhienlieu(), x.getDongxe(), x.getHopso(), x.getDongco(), x.getChongoi(), x.getPhankhuc(), x.getXuatxu(), x.getNamSX(), x.getSoLuongTon(), x.getDongia(), x.getMoTa(), x.getTrangthai()));
        }
        return lst;
    }

    @Override
    public ArrayList<ChiTietSPVM> getLocTheoKieuDang(String txt) {
        ArrayList<ChiTietSPVM> lst = new ArrayList<>();
        var lstCtsp = spRepo.getLocTheoKieuDang(txt);
        for (ChiTietSPVM x : lstCtsp) {
            lst.add(new ChiTietSPVM(x.getId(), x.getSanPham(), x.getHangSP(), x.getKieudang(), x.getMausac(), x.getNhienlieu(), x.getDongxe(), x.getHopso(), x.getDongco(), x.getChongoi(), x.getPhankhuc(), x.getXuatxu(), x.getNamSX(), x.getSoLuongTon(), x.getDongia(), x.getMoTa(), x.getTrangthai()));
        }
        return lst;
    }

    @Override
    public ArrayList<ChiTietSPVM> getLocTheoDongco(String txt) {
        ArrayList<ChiTietSPVM> lst = new ArrayList<>();
        var lstCtsp = spRepo.getLocTheoDongco(txt);
        for (ChiTietSPVM x : lstCtsp) {
            lst.add(new ChiTietSPVM(x.getId(), x.getSanPham(), x.getHangSP(), x.getKieudang(), x.getMausac(), x.getNhienlieu(), x.getDongxe(), x.getHopso(), x.getDongco(), x.getChongoi(), x.getPhankhuc(), x.getXuatxu(), x.getNamSX(), x.getSoLuongTon(), x.getDongia(), x.getMoTa(), x.getTrangthai()));
        }
        return lst;
    }

    @Override
    public ArrayList<ChiTietSPVM> getLocTheoHopso(String txt) {
        ArrayList<ChiTietSPVM> lst = new ArrayList<>();
        var lstCtsp = spRepo.getLocHopso(txt);
        for (ChiTietSPVM x : lstCtsp) {
            lst.add(new ChiTietSPVM(x.getId(), x.getSanPham(), x.getHangSP(), x.getKieudang(), x.getMausac(), x.getNhienlieu(), x.getDongxe(), x.getHopso(), x.getDongco(), x.getChongoi(), x.getPhankhuc(), x.getXuatxu(), x.getNamSX(), x.getSoLuongTon(), x.getDongia(), x.getMoTa(), x.getTrangthai()));
        }
        return lst;
    }

    @Override
    public ArrayList<ChiTietSPVM> getLocTheoNhienlieu(String txt) {
        ArrayList<ChiTietSPVM> lst = new ArrayList<>();
        var lstCtsp = spRepo.getLocTheoNhienLieu(txt);
        for (ChiTietSPVM x : lstCtsp) {
            lst.add(new ChiTietSPVM(x.getId(), x.getSanPham(), x.getHangSP(), x.getKieudang(), x.getMausac(), x.getNhienlieu(), x.getDongxe(), x.getHopso(), x.getDongco(), x.getChongoi(), x.getPhankhuc(), x.getXuatxu(), x.getNamSX(), x.getSoLuongTon(), x.getDongia(), x.getMoTa(), x.getTrangthai()));
        }
        return lst;
    }

    @Override
    public ArrayList<ChiTietSPVM> getLocTheoMausac(String txt) {
        ArrayList<ChiTietSPVM> lst = new ArrayList<>();
        var lstCtsp = spRepo.getLocTheoMauSac(txt);
        for (ChiTietSPVM x : lstCtsp) {
            lst.add(new ChiTietSPVM(x.getId(), x.getSanPham(), x.getHangSP(), x.getKieudang(), x.getMausac(), x.getNhienlieu(), x.getDongxe(), x.getHopso(), x.getDongco(), x.getChongoi(), x.getPhankhuc(), x.getXuatxu(), x.getNamSX(), x.getSoLuongTon(), x.getDongia(), x.getMoTa(), x.getTrangthai()));
        }
        return lst;
    }

    public boolean xuatDS(File file) {
        ArrayList<ChiTietSPVM> lst = spRepo.getAll();
        try {
            FileOutputStream fos = new FileOutputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Danh sách ô tô");
            int rowNum = 0;
            Row firstRow = sheet.createRow(rowNum++);

            Cell idTitle = firstRow.createCell(0);
            idTitle.setCellValue("ID");

            Cell tenSPTitle = firstRow.createCell(1);
            tenSPTitle.setCellValue("Tên SP");

            Cell hangSPTitle = firstRow.createCell(2);
            hangSPTitle.setCellValue("Hãng SP");

            Cell kieudangTitle = firstRow.createCell(3);
            kieudangTitle.setCellValue("Kiểu dáng");

            Cell mausacTitle = firstRow.createCell(4);
            mausacTitle.setCellValue("Màu sắc");

            Cell nhienlieuTitle = firstRow.createCell(5);
            nhienlieuTitle.setCellValue("Nhiên liệu");

            Cell dongXe = firstRow.createCell(6);
            dongXe.setCellValue("Dòng xe");

            Cell hopso = firstRow.createCell(7);
            hopso.setCellValue("Hộp số");

            Cell dongco = firstRow.createCell(8);
            dongco.setCellValue("Động cơ");

            Cell chongoi = firstRow.createCell(9);
            chongoi.setCellValue("Chỗ ngồi");

            Cell phankhuc = firstRow.createCell(10);
            phankhuc.setCellValue("Phân khúc");

            Cell xuatxu = firstRow.createCell(11);
            xuatxu.setCellValue("Xuất xứ");

            Cell namsx = firstRow.createCell(12);
            namsx.setCellValue("Năm sản xuất");

            Cell slton = firstRow.createCell(13);
            slton.setCellValue("Số lượng tồn");

            Cell giaban = firstRow.createCell(14);
            giaban.setCellValue("Giá bán");

            Cell mota = firstRow.createCell(15);
            mota.setCellValue("Mô tả");

            Cell trangthai = firstRow.createCell(16);
            trangthai.setCellValue("Trạng thái");

            for (ChiTietSPVM x : lst) {
                Row row = sheet.createRow(rowNum++);

                Cell cell1 = row.createCell(0);
                cell1.setCellValue(x.getId());

                Cell cell2 = row.createCell(1);
                cell2.setCellValue(x.getSanPham().getTen());

                Cell cell3 = row.createCell(2);
                cell3.setCellValue(x.getHangSP());

                Cell cell14 = row.createCell(3);
                cell14.setCellValue(x.getKieudang());

                Cell cell15 = row.createCell(4);
                cell15.setCellValue(x.getMausac());

                Cell cell16 = row.createCell(5);
                cell16.setCellValue(x.getNhienlieu());

                Cell cell17 = row.createCell(6);
                cell17.setCellValue(x.getDongxe());

                Cell cell18 = row.createCell(7);
                cell18.setCellValue(x.getHopso());

                Cell cell19 = row.createCell(8);
                cell19.setCellValue(x.getDongco());

                Cell cell10 = row.createCell(9);
                cell10.setCellValue(x.getChongoi());

                Cell cell111 = row.createCell(10);
                cell111.setCellValue(x.getPhankhuc());

                Cell cell112 = row.createCell(11);
                cell112.setCellValue(x.getXuatxu());

                Cell cell113 = row.createCell(12);
                cell113.setCellValue(x.getNamSX());

                Cell cell114 = row.createCell(13);
                cell114.setCellValue(x.getSoLuongTon());

                Cell cell115 = row.createCell(14);
                cell115.setCellValue(x.getDongia() + "");

                Cell cell116 = row.createCell(15);
                cell116.setCellValue(x.getMoTa());

                Cell cell117 = row.createCell(16);
                cell117.setCellValue(x.getTrangthai() == 1 ? "Đang kinh doanh" : "Ngừng kinh doanh");
            }
            workbook.write(fos);
            workbook.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return false;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
        return false;
    }

    @Override
    public ArrayList<ChiTietSPVM> getLocTheoGia(BigDecimal gia1, BigDecimal gia2) {
        ArrayList<ChiTietSPVM> lst = new ArrayList<>();
        var lstCtsp = spRepo.getLocTheoGia(gia1, gia2);
        for (ChiTietSPVM x : lstCtsp) {
            lst.add(new ChiTietSPVM(x.getId(), x.getSanPham(), x.getHangSP(), x.getKieudang(), x.getMausac(), x.getNhienlieu(), x.getDongxe(), x.getHopso(), x.getDongco(), x.getChongoi(), x.getPhankhuc(), x.getXuatxu(), x.getNamSX(), x.getSoLuongTon(), x.getDongia(), x.getMoTa(), x.getTrangthai()));
        }
        return lst;
    }

    @Override
    public ArrayList<ChiTietSPVM> getLocTheoGiaT(BigDecimal giaT) {
        ArrayList<ChiTietSPVM> lst = new ArrayList<>();
        var lstCtsp = spRepo.getLocTheoGiaT(giaT);
        for (ChiTietSPVM x : lstCtsp) {
            lst.add(new ChiTietSPVM(x.getId(), x.getSanPham(), x.getHangSP(), x.getKieudang(), x.getMausac(), x.getNhienlieu(), x.getDongxe(), x.getHopso(), x.getDongco(), x.getChongoi(), x.getPhankhuc(), x.getXuatxu(), x.getNamSX(), x.getSoLuongTon(), x.getDongia(), x.getMoTa(), x.getTrangthai()));
        }
        return lst;
    }

    public ArrayList<ChiTietSPVM> readExcel(File excelFilePath) throws IOException {
        ArrayList<ChiTietSPVM> listBooks = new ArrayList<>();
        InputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = sheet.iterator();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            if (nextRow.getRowNum() == 0) {
                continue;
            }
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            ChiTietSPVM ct = new ChiTietSPVM();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                Object cellValue = getCellValue(cell);
                if (cellValue == null || cellValue.toString().isEmpty()) {
                    continue;
                }
                int columnIndex = cell.getColumnIndex();
                switch (columnIndex) {
                    case COLUMN_INDEX_ID:
                        ct.setId((String) getCellValue(cell));
                        break;
                    case COLUMN_INDEX_Ten:
                        String tenSanPham = (String) getCellValue(cell);
                        SanPham s = spsv.getSPByName(tenSanPham);
                        ct.setSanPham(s);
                        break;
                    case COLUMN_INDEX_Hang:
                        ct.setHangSP((String) getCellValue(cell));
                        break;
                    case COLUMN_INDEX_Kieudang:
                        ct.setKieudang((String) getCellValue(cell));
                        break;
                    case COLUMN_INDEX_Mausac:
                        ct.setMausac((String) getCellValue(cell));
                        break;
                    case COLUMN_INDEX_Nhienlieu:
                        ct.setNhienlieu((String) getCellValue(cell));
                        break;
                    case COLUMN_INDEX_Dongxe:
                        ct.setDongxe((String) getCellValue(cell));
                        break;
                    case COLUMN_INDEX_Hopso:
                        ct.setHopso((String) getCellValue(cell));
                        break;
                    case COLUMN_INDEX_Dongco:
                        ct.setDongco((String) getCellValue(cell));
                        break;
                    case COLUMN_INDEX_Chongoi:
                        ct.setChongoi((String) getCellValue(cell));
                        break;
                    case COLUMN_INDEX_Phankhuc:
                        ct.setPhankhuc((String) getCellValue(cell));
                        break;
                    case COLUMN_INDEX_Xuatxu:
                        ct.setXuatxu((String) getCellValue(cell));
                        break;
                    case COLUMN_INDEX_NamSX:
                        ct.setNamSX(((Double) getCellValue(cell)).intValue());
                        break;
                    case COLUMN_INDEX_SLTon:
                        ct.setSoLuongTon(((Double) getCellValue(cell)).intValue());
                        break;
                    case COLUMN_INDEX_GiaBan:
                        ct.setDongia(new BigDecimal((double) cellValue));
                        break;
                    case COLUMN_INDEX_Mota:
                        ct.setMoTa((String) getCellValue(cell));
                        break;
                    case COLUMN_INDEX_Trangthai:
                        if (ct.getTrangthai() == 1) {
                            System.out.println("Đang kinh doanh");
                        } else {
                            System.out.println("Ngừng kinh doanh");
                        }
                        ct.setTrangthai(((Double) getCellValue(cell)).intValue());
                        break;
                    default:
                        break;
                }
            }
            listBooks.add(ct);
        }
        workbook.close();
        inputStream.close();
        return listBooks;
    }

    private static Workbook getWorkbook(InputStream inputStream, String excelFilePath) throws IOException {
        Workbook workbook = null;
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }

        return workbook;
    }

    private static Object getCellValue(Cell cell) {
        CellType cellType = cell.getCellType();
        Object cellValue = null;
        switch (cellType) {
            case BOOLEAN:
                cellValue = cell.getBooleanCellValue();
                break;
            case FORMULA:
                Workbook workbook = cell.getSheet().getWorkbook();
                FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                cellValue = evaluator.evaluate(cell).getNumberValue();
                break;
            case NUMERIC:
                cellValue = cell.getNumericCellValue();
                break;
            case STRING:
                cellValue = cell.getStringCellValue();
                break;
            case _NONE:
            case BLANK:
            case ERROR:
                break;
            default:
                break;
        }

        return cellValue;
    }

}
