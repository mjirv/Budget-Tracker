import java.util.ArrayList;
import java.util.Date;


public class App {
	
	ArrayList<LineItem> lineItems;
	
	public App() {
		this.lineItems = new ArrayList<LineItem>();
		//TODO Get the list of LineItems from the database.
		
	}
	
	public Expense createExpense(String name, String submitter, LineItem lineItem, double amt, Date date, String purpose) {
		return new Expense(name, submitter, lineItem, amt, date, purpose);
	}
	
	public LineItem createLineItem(String name, double start, ArrayList<Expense> startingExpenses) {
		return new LineItem(name, start, startingExpenses);
	}
	
	public Expense getExpense(String expenseName, String lineItemName) {
		try {
			LineItem lineItem = this.getLineItem(lineItemName);
			for(int i=0; i<lineItem.expenses.size(); i++) {
				Expense expense = lineItem.expenses.get(i);
				if(expense.getName() == expenseName) {
					return expense;
				}
			}
		}
		catch(NullPointerException err) {
			throw err;
		}
		throw new NullPointerException("No matching expense found.");
	}
	
	public LineItem getLineItem(String lineItemName) {
		for(int i=0; i<lineItems.size(); i++) {
			LineItem lineItem = lineItems.get(i);
			if(lineItem.getName().equals(lineItemName)) {
				return lineItem;
			}
		}
		throw new NullPointerException("No matching line item found.");
	}
	
	public Expense removeExpense(String expenseName, String lineItemName) {
		Expense expense = this.getExpense(expenseName, lineItemName);
		LineItem lineItem = this.getLineItem(lineItemName);
		lineItem.expenses.remove(expense);
		return expense;
	}
	
	public LineItem removeLineItem(String lineItemName) {
		LineItem lineItem = this.getLineItem(lineItemName);
		this.lineItems.remove(lineItem);
		return lineItem;
	}
}
