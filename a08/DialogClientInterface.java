import java.util.ArrayList;

public interface DialogClientInterface{
	public void dialogFinished(ArrayList<StadiumPanel.RCJButton> btns, int mode, String[][] info);
	public void dialogCancelled();
}