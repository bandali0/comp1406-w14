import java.util.Date;

public class Call {
	private Customer	madeFrom;
	private Customer	madeTo;
	private Date		time;
	private int			length;	// in seconds

	public Call(Customer f, Customer t, Date d, int len) {
		madeFrom = f;
		madeTo = t;
		time = d;
		length = len;
	}

	public Customer getMadeFrom() { return madeFrom; }
	public Customer getMadeTo() { return madeTo; }
	public Date getTime() { return time; }
	public int getLength() { return length; }

	public String toString() {
		return (String.format("%d:%02d",length/60,length%60) + " call from " + madeFrom.getNumber() + " to " + madeTo.getNumber());
	}
}