package practice;

import java.io.Serializable;

public class Member implements Serializable{
	private String name;
	private String phone;
	private String gender;
	private String addr;
	private boolean agree;
	public Member(String name, String phone, String gender, String addr, boolean agree) {
		super();
		this.name = name;
		this.phone = phone;
		this.gender = gender;
		this.addr = addr;
		this.agree = agree;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public boolean isAgree() {
		return agree;
	}
	public void setAgree(boolean agree) {
		this.agree = agree;
	}
	@Override
	public String toString() {
		return "Member [name=" + name + ", phone=" + phone + ", gender=" + gender + ", addr=" + addr + ", agree="
				+ agree + "]";
	}
	
}
