
public class RideTestProgram {

	public static void main(String[] args) {
		Ride RC = new Ride("Roller Coaster", 4, 5.3f);
		Ride coolRide = new Ride("Cool Ride", 12, 2.3f);
		Ride boring = new Ride();
		
		System.out.println(RC.toString());
		System.out.println(coolRide.toString());
		System.out.println(boring.toString());
	}
	
}
