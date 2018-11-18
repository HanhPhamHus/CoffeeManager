package e;

public class MenuItem {
	private String DoUongID;
	private String TenDoUong;
	private int DonGia;
	public MenuItem(String doUongID, String tenDoUong, int donGia) {
		super();
		DoUongID = doUongID;
		TenDoUong = tenDoUong;
		DonGia = donGia;
	}
	public String getDoUongID() {
		return DoUongID;
	}
	public void setDoUongID(String doUongID) {
		DoUongID = doUongID;
	}
	public String getTenDoUong() {
		return TenDoUong;
	}
	public void setTenDoUong(String tenDoUong) {
		TenDoUong = tenDoUong;
	}
	public int getDonGia() {
		return DonGia;
	}
	public void setDonGia(int donGia) {
		DonGia = donGia;
	}
	
	
	
}
