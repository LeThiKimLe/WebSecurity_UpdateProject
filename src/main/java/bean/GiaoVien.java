package bean;
// Generated Dec 3, 2022, 12:48:29 PM by Hibernate Tools 6.0.2.Final

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ConnectDataBase;
import utils.DBUtilsGiaoVien;

/**
 * GiaoVien generated by hbm2java
 */
public class GiaoVien implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maGiaoVien;
	private String tenGiaoVien;
	private String sdt;
	private String cccd;
	private String diaChi;
	private Date ngayKyKet;
	private String chuyenmon;
	private String email;
	private List<KhoaHoc> listKhoaHocs;

	public GiaoVien() {
	}
	
	public String autoID() throws SQLException
	{
		Connection conn = null;
		try {
			conn = ConnectDataBase.getConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String sql = "SELECT COUNT(*) as SoLuong FROM GiaoVien";
		
		PreparedStatement pstm=null;
		try {
			pstm = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ResultSet rs = pstm.executeQuery();
        String kqString="";
        while (rs.next()) 
        {
        	int soluong = rs.getInt("SoLuong");
        	if (soluong+1<10)
        		kqString= "GV00"+ String.valueOf(soluong+1);
        	else {
				kqString= "GV0"+ String.valueOf(soluong+1);
			}
        }
        return kqString;  
	}

	public GiaoVien(String maGiaoVien, String tenGiaoVien, String sdt, String cccd, String diaChi,
			Date ngayKyKet)
	{
		this.maGiaoVien = maGiaoVien;
		this.tenGiaoVien = tenGiaoVien;
		this.sdt = sdt;
		this.cccd = cccd;
		this.diaChi = diaChi;
		this.ngayKyKet = ngayKyKet;
	}
	
	public GiaoVien(String tenGiaoVien, String sdt, String email, String cccd, String diaChi,
			Date ngayKyKet, String chuyen, boolean taomoi) throws SQLException {
		String maGiaoVien=autoID();
		this.maGiaoVien = maGiaoVien;
		this.tenGiaoVien = tenGiaoVien;
		this.sdt = sdt;
		this.email=email;
		this.cccd = cccd;
		this.diaChi = diaChi;
		this.ngayKyKet = ngayKyKet;
		this.chuyenmon= chuyen;		
	}
	
	public GiaoVien(String maGiaoVien,String tenGiaoVien, String sdt, String cccd, String diaChi,
			Date ngayKyKet, String chuyen)
	{
		this.maGiaoVien = maGiaoVien;
		this.tenGiaoVien = tenGiaoVien;
		this.sdt = sdt;
		this.cccd = cccd;
		this.diaChi = diaChi;
		this.ngayKyKet = ngayKyKet;
		this.chuyenmon= chuyen;		
	}

	public String getMaGiaoVien() {
		return this.maGiaoVien;
	}

	public void setMaGiaoVien(String maGiaoVien) {
		this.maGiaoVien = maGiaoVien;
	}

	public String getTenGiaoVien() {
		return this.tenGiaoVien;
	}

	public void setTenGiaoVien(String tenGiaoVien) {
		this.tenGiaoVien = tenGiaoVien;
	}

	public String getSdt() {
		return this.sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getCccd() {
		return this.cccd;
	}

	public void setCccd(String cccd)
	{
		this.cccd = cccd;
	}

	public String getDiaChi()
	{
		return this.diaChi;
	}

	public void setDiaChi(String diaChi) 
	{
		this.diaChi = diaChi;
	}

	public Date getNgayKyKet()
	{
		return this.ngayKyKet;
	}

	public void setNgayKyKet(Date ngayKyKet)
	{
		this.ngayKyKet = ngayKyKet;
	}

	
	public List<KhoaHoc> getListKhoaHocs() 
	{
		return listKhoaHocs;
	}

	public void setListKhoaHocs(List<KhoaHoc> listKhoaHocs) {
		this.listKhoaHocs = listKhoaHocs;
	}
	
	public String getChuyenmon() {
		return chuyenmon;
	}

	public void setChuyenmon(String chuyenmon) {
		this.chuyenmon = chuyenmon;
	}

	public GiaoVien(Connection conn, String maGiaoVien) throws SQLException
	 {
		 	String sql = "Select * from GiaoVien a where a.MaGiaoVien=?";
	        PreparedStatement pstm = conn.prepareStatement(sql);
	        pstm.setString(1, maGiaoVien);
	        ResultSet rs = pstm.executeQuery();
	        while (rs.next()) 
	        {
	        	this.maGiaoVien=maGiaoVien;
	        	this.tenGiaoVien = rs.getString("TenGiaoVien");
	            this.ngayKyKet = rs.getDate("NgayKyKet");           
	            this.sdt = rs.getString("SDT");
	            this.cccd = rs.getString("CCCD");
	            this.diaChi = rs.getString("DiaChi");
	        }
	        this.listKhoaHocs=LayKhoaHoc(conn, maGiaoVien);
	 }
	
	public List<KhoaHoc> LayKhoaHoc(Connection conn, String maGiaoVien) throws SQLException
	 {
		 	String sql = "Select * from KhoaHoc a where a.GiaoVien=?";
		 	PreparedStatement pstm = conn.prepareStatement(sql);
		 	pstm.setString(1, maGiaoVien);
			ResultSet rs = pstm.executeQuery();
			 
			List<KhoaHoc> list = new ArrayList<KhoaHoc>();
			    
	        String ma_khoahocString=null;
	        String phan_monString=null;
	        String ten_khoahocString=null;
	        String mo_taString=null;
	        int so_baihoc=0;
	        int gia_tien=0;
	        Date ngay_capnhatDate=null;
	        String img=null;
	       
	        while (rs.next()) {
	        	
	        	ma_khoahocString=rs.getString("MaKhoaHoc");
	        	phan_monString=rs.getString("PhanMon");
	        	ten_khoahocString=rs.getString("TenKhoaHoc");
	        	mo_taString=rs.getString("MoTa");
	        	so_baihoc=rs.getInt("SoBaiHoc");
	        	gia_tien=rs.getInt("GiaTien");
	        	ngay_capnhatDate=rs.getDate("NgayCapNhat");
	        	img=rs.getString("HinhAnhMoTa");
	        	
	            KhoaHoc mh = new KhoaHoc();
	            mh.setMaKhoaHoc(ma_khoahocString);
	            mh.setGiaoVien(maGiaoVien);
	            mh.setPhanMon(phan_monString);
	            mh.setTenKhoaHoc(ten_khoahocString);
	            mh.setMoTa(mo_taString);
	            mh.setSoBaiHoc(so_baihoc);
	            mh.setGiaTien(gia_tien);
	            mh.setNgayCapNhat(ngay_capnhatDate);
	            mh.setHinhAnhMoTa(img);
	            list.add(mh);
	        }
	        return list;
	 }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
