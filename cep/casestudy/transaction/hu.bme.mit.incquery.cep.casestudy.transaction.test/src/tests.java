import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

import com.google.common.collect.Maps;

public class tests {

	@Ignore
	@Test
	public void test() {
		Map<String, List<Object>> params = Maps.newHashMap();

		String paramName = "tId";
		Object value = "asdasd";

		List<Object> list = params.get(paramName);
		System.out.println(list == null);
		System.out.println(list.isEmpty());
	}

	@Test
	public void test2() {
		ComponentA componentA = new ComponentA(null);
		for (Object parameter : componentA.getParameters()) {
			System.out.println(parameter);
		}
		
		componentA.setTransactionId("transaction-1");
		componentA.setTimestamp(1000l);
		componentA.setCustomerId("customer-10");
		
		for (Object parameter : componentA.getParameters()) {
			System.out.println(parameter);
		}
	}

}
