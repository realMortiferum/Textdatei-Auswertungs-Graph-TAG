package JUnit;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class UtilsTest {

	static int numget;
	static int numset;
	static List<String> getName = new ArrayList<String>();
	static List<String> getType = new ArrayList<String>();
	static List<String> setName = new ArrayList<String>();
	static List<String> setType = new ArrayList<String>();
	
	
	@Test
	public void testIncrement() {
		int zahl = 5;
		int erg = Utils.increment(zahl);
		assertTrue(erg + " ist nicht gleich 6!", erg == 6);
	}
    
	@Test
	public void testMethod() {

		numget = 0;
		numset = 0;
		
		Class reflectClass = Currency.class;

		Method[] classMethods = reflectClass.getMethods();

		for (Method method : classMethods) {

			if (method.getName().startsWith("get")) {

				numget = numget + 1; // Anzahl der Getter


				getName.add(method.getName());

				
				getType.add(String.valueOf(method.getReturnType()));

				// System.out.println("\n" + "Method Name: " +
				// method.getName());
				// System.out.println("Getter Method");
				// System.out.println("return Type: " + method.getReturnType());

			} else if (method.getName().startsWith("set")) {

				numset = numset + 1; // Anzahl der Setter

				
				setName.add(method.getName());

				
				setType.add(String.valueOf(method.getReturnType()));

				// System.out.println("\n" + "Method Name: " +
				// method.getName());
				// System.out.println("Setter Method");
				// System.out.println("return Type: " + method.getReturnType());

			}

		}

	}

	@Test
	public void getTest(){
		for(int c = 0; c < numget; c++){
			final Utils ut = new Utils();
			String method = getName.get(c);
			ut.methode(2);
		}
	}
	
	@Test
	public void testCurrencyID()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		final Utils ut = new Utils();

		ut.setCurrencyID(3);

		final Field field = ut.getClass().getDeclaredField("currencyID");
		field.setAccessible(true);
		assertEquals("Nicht die richtige Rückgabe", field.get(ut), 3);
	}

	@Test
	public void testGetter_getsValue()
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		final Utils ut = new Utils();
		final Field field = ut.getClass().getDeclaredField("currencyID");
		field.setAccessible(true);
		field.set(ut, 3);

		final int result = ut.getCurrencyID();

		assertEquals("Nicht gleich", result, 3);
	}

}
