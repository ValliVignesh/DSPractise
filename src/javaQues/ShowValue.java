package javaQues;

public class ShowValue {
	final int num = 10;

	public void display() {
		int num = 12;
		Runnable r = new Runnable() {
			final int num = 15;

			@Override
			public void run() {
				int num = 20;
				System.out.println(this.num);
				// TODO Auto-generated method stub

			}
		};
		r.run();

	}

	public static void main(String args[]) {
		ShowValue sv = new ShowValue();
		sv.display();

	}
}
