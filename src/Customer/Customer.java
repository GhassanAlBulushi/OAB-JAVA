package Customer;

public class Customer {
	
	private int custId;
	private String custName;
	private double Balance;
	
	public Customer(int custId, String custName, double Balance) {
		this.custId=custId;
		this.custName=custName;
		this.Balance=Balance;
	}

	/**
	 * @return the custId
	 */
	public int getCustId() {
		return custId;
	}

	/**
	 * @param custId the custId to set
	 */
	public void setCustId(int custId) {
		this.custId = custId;
	}

	/**
	 * @return the custName
	 */
	public String getCustName() {
		return custName;
	}

	/**
	 * @param custName the custName to set
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return Balance;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setBalance(double Balance) {
		this.Balance = Balance;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", Balance=" + Balance + "]";
	}

}
