import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Test {
	
	public static void main (String [] args) throws ParseException {
		/*Test creation of the LineItem
		 *Should print:
		 *{"name":"CO Chair","remaining":1500.0,"expenses":[]}
		 */
		ArrayList<Expense> expenses = new ArrayList<Expense>();
		LineItem item = new LineItem("CO Chair", 1500.00, expenses);
		System.out.println(item);
		
		/*Test that we can add new expenses
		 * Should print:
		 * {"name":"CO Chair","remaining":1350.0,"expenses":[{"name":"booze","submitter":"Michael Irvine","budget line item":"CO Chair","amount":150.0,"date":"Thu Aug 04 00:00:00 EDT 1949","purpose":"to have fun"}]}
		 */
		new Expense("booze", "Michael Irvine", item, 150.00, new SimpleDateFormat("yyyy-MM-dd").parse("1949-08-04"), "to have fun");
		System.out.println(item);
		
		/*Test that an expense with a null lineItem cannot be added
		 * Should print:
		 * Expense must have a corresponding LineItem
		 * {"name":"CO Chair","remaining":1350.0,"expenses":[{"name":"booze","submitter":"Michael Irvine","budget line item":"CO Chair","amount":150.0,"date":"Thu Aug 04 00:00:00 EDT 1949","purpose":"to have fun"}]}
		 */
		new Expense("fun", "Michael Irvine", null, 125.00, new SimpleDateFormat("yyyy-MM-dd").parse("2002-12-13"), "to have more fun");
		System.out.println(item);
	}

}
