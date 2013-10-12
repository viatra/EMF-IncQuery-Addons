package hu.bme.mit.incquery.cep.dsl.examples.actionhandlers;

public class MyActionHandler {
	public void handleAction(int id) {
		System.out.println("Action with id " + id + " handled!");
	}

	public static void handleAction2(int id) {
		System.out.println("Action with id " + id + " handled!");
	}
}
