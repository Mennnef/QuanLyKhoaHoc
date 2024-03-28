package view;

public interface tableAcctionEvent {
	public void onUpdate(int row);
	public void onDelete(int row);
	public void onMore(int row);
}
