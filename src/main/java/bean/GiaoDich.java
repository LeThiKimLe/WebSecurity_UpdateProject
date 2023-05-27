package bean;
// Generated Dec 3, 2022, 12:48:29 PM by Hibernate Tools 6.0.2.Final

import java.math.BigDecimal;
import java.sql.Date;

/**
 * GiaoDich generated by hbm2java
 */
public class GiaoDich implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maGiaoDich;
	private ViThanhToan viThanhToan;
	private BigDecimal soTienGiaoDich;
	private String noiDungGiaoDich;
	private Date ngayGiaoDich;
	private BigDecimal soDuCapNhat;

	public GiaoDich() {
	}

	public GiaoDich(String maGiaoDich) {
		this.maGiaoDich = maGiaoDich;
	}

	public GiaoDich(String maGiaoDich, ViThanhToan viThanhToan, BigDecimal soTienGiaoDich, String noiDungGiaoDich,
			Date ngayGiaoDich, BigDecimal soDuCapNhat) {
		this.maGiaoDich = maGiaoDich;
		this.viThanhToan = viThanhToan;
		this.soTienGiaoDich = soTienGiaoDich;
		this.noiDungGiaoDich = noiDungGiaoDich;
		this.ngayGiaoDich = ngayGiaoDich;
		this.soDuCapNhat = soDuCapNhat;
	}

	public String getMaGiaoDich() {
		return this.maGiaoDich;
	}

	public void setMaGiaoDich(String maGiaoDich) {
		this.maGiaoDich = maGiaoDich;
	}

	public ViThanhToan getViThanhToan() {
		return this.viThanhToan;
	}

	public void setViThanhToan(ViThanhToan viThanhToan) {
		this.viThanhToan = viThanhToan;
	}

	public BigDecimal getSoTienGiaoDich() {
		return this.soTienGiaoDich;
	}

	public void setSoTienGiaoDich(BigDecimal soTienGiaoDich) {
		this.soTienGiaoDich = soTienGiaoDich;
	}

	public String getNoiDungGiaoDich() {
		return this.noiDungGiaoDich;
	}

	public void setNoiDungGiaoDich(String noiDungGiaoDich) {
		this.noiDungGiaoDich = noiDungGiaoDich;
	}

	public Date getNgayGiaoDich() {
		return this.ngayGiaoDich;
	}

	public void setNgayGiaoDich(Date ngayGiaoDich) {
		this.ngayGiaoDich = ngayGiaoDich;
	}

	public BigDecimal getSoDuCapNhat() {
		return this.soDuCapNhat;
	}

	public void setSoDuCapNhat(BigDecimal soDuCapNhat) {
		this.soDuCapNhat = soDuCapNhat;
	}

}