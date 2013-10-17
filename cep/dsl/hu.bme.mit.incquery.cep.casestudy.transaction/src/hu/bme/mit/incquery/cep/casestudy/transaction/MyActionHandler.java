package hu.bme.mit.incquery.cep.casestudy.transaction;

public class MyActionHandler {
	public void handleAction(int id) {
		System.out.println("Action with id " + id + " handled!");
	}

	public static void handleAction2(int id) {
		System.out.println("Action with id " + id + " handled!");
	}
}
