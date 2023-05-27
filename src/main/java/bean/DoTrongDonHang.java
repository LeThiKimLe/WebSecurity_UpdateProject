package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.ConnectDataBase;

/**
 * DoTrongDonHang generated by hbm2java
 */
public class DoTrongDonHang implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String donHang;
	private String maKhoaHoc;

	public DoTrongDonHang() {
	}

	public DoTrongDonHang(String id) {
		this.id = id;
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
		
		String sql = "SELECT COUNT(*) as SoLuong FROM DoTrongDonHang";
		
		PreparedStatement pstm=null;
		try {
			pstm = conn.prepareStatement(sql);
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ResultSet rs = pstm.executeQuery();
        String kqString="";
        while (rs.next()) 
        {
        	int soluong = rs.getInt("SoLuong");
        	if (soluong+1<10)
        		kqString= "ITEM000"+ String.valueOf(soluong+1);
        	else {
				kqString= "ITEM00"+ String.valueOf(soluong+1);
			}
        }
        return kqString;  
	}

	public DoTrongDonHang(String donHang, String maKhoaHoc) throws SQLException {
		this.id = this.autoID();
		this.donHang = donHang;
		this.maKhoaHoc = maKhoaHoc;
	}
	

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDonHang() {
		return this.donHang;
	}

	public void setDonHang(String donHang) {
		this.donHang = donHang;
	}

	public String getMaKhoaHoc() {
		return this.maKhoaHoc;
	}

	public void setMaKhoaHoc(String maKhoaHoc) {
		this.maKhoaHoc = maKhoaHoc;
	}
	
}
