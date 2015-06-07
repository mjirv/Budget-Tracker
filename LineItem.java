import java.util.ArrayList;

import javax.json.*;


public class LineItem {
	String name;
	double remaining;
	ArrayList<Expense> expenses;
	
	public LineItem(String name, double start, ArrayList<Expense> startingExpenses) {
		this.name = name;
		this.remaining = start;
		this.expenses = startingExpenses;
	}
	
	public void addExpense(Expense expense) {
		this.expenses.add(expense);
		this.remaining -= expense.getAmt();
	}
	
	public JsonObject toJson() {
		JsonBuilderFactory factory = Json.createBuilderFactory(null);
		JsonObject jsonObj = factory.createObjectBuilder()
				.add("name", this.name)
				.add("remaining", this.remaining)
				.add("expenses", this.jsonArray())
				.build();
		return jsonObj;
	}
	
	public JsonArray jsonArray() {
		JsonBuilderFactory factory = Json.createBuilderFactory(null);
		JsonArrayBuilder arrayBuilder = factory.createArrayBuilder();
		for(int i=0; i<expenses.size(); i++) {
			arrayBuilder.add(expenses.get(i).toJson());
		}
		return arrayBuilder.build();
	}
	
	public String toString() {
		return this.toJson().toString();
	}

}
