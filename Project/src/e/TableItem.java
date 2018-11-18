package e;

public class TableItem {
	private String BanID;
	
	private String TenBan;
	private String GhiChu;
	
	public TableItem(String banID, String tenBan, String ghiChu) {
		super();
		BanID = banID;
		TenBan = tenBan;
		GhiChu = ghiChu;
	}

	public String getBanID() {
		return BanID;
	}

	public void setBanID(String banID) {
		BanID = banID;
	}

	public String getTenBan() {
		return TenBan;
	}

	public void setTenBan(String tenBan) {
		TenBan = tenBan;
	}

	public String getGhiChu() {
		return GhiChu;
	}

	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}

	@Override
	public String toString() {
		return "TableItem [BanID=" + BanID + ", TenBan=" + TenBan + ", GhiChu=" + GhiChu + "]";
	}
	
	
	
	
}
