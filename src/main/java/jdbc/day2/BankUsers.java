package jdbc.day2;

public class BankUsers {
	
	private int id;
	private String accountType;
	private Double accountBalance;
	private String ssn;
	private String address;
	private String email;
	private String phoneNum;
	private String bankName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public BankUsers(int id, String accountType, Double accountBalance, String ssn, String address, String email,
			String phoneNum, String bankName) {
		super();
		this.id = id;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.ssn = ssn;
		this.address = address;
		this.email = email;
		this.phoneNum = phoneNum;
		this.bankName = bankName;
	}
	public BankUsers() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
