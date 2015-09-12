package exc;

public class ListableExistException extends Exception{
	private static final long serialVersionUID = 1L;
	public ListableExistException(){ super(); }
	public ListableExistException(String message){ super(message); }
}
