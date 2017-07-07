
public class Customer {
	
	String fullname;
	String saddress;
	String city;
	String state;
	String zip;
	
	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Customer(String fname,String address, String c_city,String c_state,String c_zip)
	{
		fullname=fname;
		saddress=address;
		city=c_city;
		state=c_state;
		zip=c_zip;
	}
	
	public Customer()
	{
		
	}
	
	public String getInfo(String lname)
	{
		return "select * from customers where lastname ='"+lname+"'";
	}
	
	public String update_address(String lastname,String address)
	{
		
		return "update customers c set c.StreetAddress = '"+address+"' where c.lastname ='"+lastname+"'";
	}
	
	public String insert_entry(Customer cus)
	{
		System.out.println(cus.getFullname());
		String []splitted = cus.getFullname().split(" ");
		String email=splitted[0]+"@gmail.com";
		return "insert into customers values('"+cus.getFullname()+
				"','MR.','"+splitted[0]+"','"+splitted[1]+"','"+cus.getSaddress()+"','"+
		        cus.getCity()+"','"+cus.getState()+"','"+cus.getZip()+ "','"+email+"','position','company')";
	}
	
	
}
