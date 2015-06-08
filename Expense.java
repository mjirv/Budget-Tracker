import java.util.Date;
import javax.json.*;

public class Expense {
	String name;
	String submitter;
	LineItem lineItem;
	double amt;
	Date date;
	String purpose;
	
	//Constructor used when date is given
	public Expense(String name, String submitter, LineItem lineItem, double amt, Date date, String purpose) {
		this.name = name;
		this.submitter = submitter;
		this.lineItem = lineItem;
		this.amt = amt;
		this.date = date;
		this.purpose = purpose;
		
		try {
			lineItem.addExpense(this);
		}
		catch(NullPointerException e) {
			System.err.println("Expense must have a corresponding LineItem");
		}
			
	}
	
	//Constructor used when date is not given defaults to current date
	public Expense(String name, String submitter, LineItem lineItem, double amt, String purpose) {
		this.name = name;
		this.submitter = submitter;
		this.lineItem = lineItem;
		this.amt = amt;
		this.date = new Date();
		this.purpose = purpose;
		
		lineItem.addExpense(this);
	}
	
	public JsonObject toJson() {
		JsonBuilderFactory factory = Json.createBuilderFactory(null);
		JsonObject jsonObj = factory.createObjectBuilder()
				.add("name", name)
				.add("submitter", submitter)
				.add("budget line item", lineItem.name)
				.add("amount", amt)
				.add("date", date.toString())
				.add("purpose", purpose)
				.build();
		return jsonObj;
	}
	
	public String toString() {
		return this.toJson().toString();
	}
	
	public double getAmt() {
		return this.amt;
	}
	
	

}
