package bookCust;


public class CustomerVO {
	private int custid;
	private String name;
	private String address;
	private String phone;
	public CustomerVO(int custid, String name, String address, String phone) {
		super();
		this.custid = custid;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "CustomerVO [custid=" + custid + ", name=" + name + ", address=" + address + ", phone=" + phone + "]";
	}
	
}









