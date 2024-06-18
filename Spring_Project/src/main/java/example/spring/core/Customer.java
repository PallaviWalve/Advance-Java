package example.spring.core;

public class Customer {

	private String customerId;
	private String name;
	private int age;
	private Address permanentAddress;
	
	public Customer() {
		
	}

	public Customer(String customerId, String name, int age, Address permanentAddress) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.age = age;
		this.permanentAddress = permanentAddress;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(Address permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", age=" + age + ", permanentAddress="
				+ permanentAddress + "]";
	}

}
