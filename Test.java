import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Test {
	
	public static void main (String [] args) throws ParseException {
		ArrayList<Expense> expenses = new ArrayList<Expense>();
		LineItem item = new LineItem("CO Chair", 1500.00, expenses);
		System.out.println(item);
		Expense expense = new Expense("booze", "Michael Irvine", item, 150.00, new SimpleDateFormat("yyyy-MM-dd").parse("1949-08-04"), "to have fun");
		System.out.println(item);
	}

}
