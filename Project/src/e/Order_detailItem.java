package e;

public class Order_detailItem {
	private String GoiID;
	private String BanID;
	private String DoUongID;
	private int SoLuong;
	public Order_detailItem(String goiID, String banID, String doUongID, int soLuong) {
		super();
		GoiID = goiID;
		BanID = banID;
		DoUongID = doUongID;
		SoLuong = soLuong;
	}
	public String getGoiID() {
		return GoiID;
	}
	public void setGoiID(String goiID) {
		GoiID = goiID;
	}
	public String getBanID() {
		return BanID;
	}
	public void setBanID(String banID) {
		BanID = banID;
	}
	public String getDoUongID() {
		return DoUongID;
	}
	public void setDoUongID(String doUongID) {
		DoUongID = doUongID;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	

}
