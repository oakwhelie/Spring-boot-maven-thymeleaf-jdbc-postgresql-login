package test.spring.data;

public class User 
{
	private int id;
	private String username;
	private String realname;
	private String address;
	private boolean carlicensestatus;
	private boolean motorcyclelicensestatus;
	private String employment;
	

	public User(int id, 
				String username,
				String realname,
				String address,
				boolean carlicensestatus,
				boolean motorcyclelicensestatus,
				String employment)
	{
		this.id = id;
		this.username = username;
		this.realname = realname;
		this.address = address;
		this.carlicensestatus = carlicensestatus;
		this.motorcyclelicensestatus = motorcyclelicensestatus;
		this.employment = employment;
	}
	
	public int getID(){return id;}
	public String getUsername(){return username;}
	public String getRealname(){return realname;}
	public String getAddress(){return address;}
	public boolean getcarlicenseStatus(){return carlicensestatus;}
	public boolean getmotorcyclelicensestatus(){return motorcyclelicensestatus;}
	public String getEmployment(){return employment;}
	
	public void setAll(String realname,String address,boolean carlicensestatus,boolean motorcyclelicensestatus,String employment)
	{
		this.realname = realname;
		this.address = address;
		this.carlicensestatus = carlicensestatus;
		this.motorcyclelicensestatus = motorcyclelicensestatus;
		this.employment = employment;
	}

	public void setRealname(String realname){this.realname = realname;}
	public void setAddress(String address){this.address = address;}
	public void setCarLicenseStatus(boolean carlicensestatus){this.carlicensestatus = carlicensestatus;}
	public void setMotorcycleLicenseStatus(boolean motorcyclelicensestatus){this.motorcyclelicensestatus = motorcyclelicensestatus;}
	public void setEmployment(String employment){this.employment = employment;}
}
