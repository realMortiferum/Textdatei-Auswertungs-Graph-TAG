package JUnit;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class GetSetTestKurz {

	static int numget;
	static int numset;
	static List<String> getName = new ArrayList<String>();
	static List<String> getType = new ArrayList<String>();
	static List<String> setName = new ArrayList<String>();
	static List<String> setType = new ArrayList<String>();
	static Class<?> reflectClass = Currency.class;
	static Method[] classMethods = reflectClass.getMethods();

	
	public void testMethodnamesAndMethodtypes() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

		numget = 0;
		numset = 0;

		for (int i = 0; i < classMethods.length; i++) {

			if (classMethods[i].getName().startsWith("get")) {
				
				numget = numget + 1;
				getName.add(classMethods[i].getName());
				getType.add(String.valueOf(classMethods[i].getReturnType()));
				

			} else if (classMethods[i].getName().startsWith("set")) {

				numset = numset + 1;
				setName.add(classMethods[i].getName());
				setType.add(String.valueOf(classMethods[i].getReturnType()));
				
			}
		}
		
	}

	@Test
	public void setterAndGetterTest() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, ClassNotFoundException {

		testMethodnamesAndMethodtypes();
		
		String testString = "Test";
		int testInt = 5;
		double testDouble = 5.55;
		Currency cu = new  Currency();

		for (int c = 0; c < numset; c++) {

			String setsub = setName.get(c).substring(3, setName.get(c).length());

			for (int d = 0; d < numget; d++) {
				
				String getsub = getName.get(d).substring(3, getName.get(d).length());

				if (setsub.equals(getsub)) {
										
					if (getType.get(d).equals("class java.lang.Integer")) {	
						Method setter = reflectClass.getMethod(setName.get(c),Integer.class);  
						setter.setAccessible(true);
						setter.invoke(cu,testInt);
					}

					else if (getType.get(d).equals("class java.lang.String")) {
						Method setter = reflectClass.getMethod(setName.get(c),String.class);  
						setter.setAccessible(true);
						setter.invoke(cu,testString);
					}

					else if (getType.get(d).equals("class java.lang.Double")) {
						Method setter = reflectClass.getMethod(setName.get(c),Double.class);  
						setter.setAccessible(true);
						setter.invoke(cu,testDouble);
					}
				}
			}
		}

		for (int c = 0; c < numget; c++) {
			
			if (getType.get(c).equals("class java.lang.Integer")) {
				Method getter = reflectClass.getMethod(getName.get(c));
				getter.setAccessible(true);
				int receivedInt = Integer.parseInt(String.valueOf((getter.invoke(cu, null))));
				assertEquals(receivedInt,testInt);
			} else if (getType.get(c).equals("class java.lang.String")) {
				Method getter = reflectClass.getMethod(getName.get(c));
				getter.setAccessible(true);
				String receivedStr = String.valueOf((getter.invoke(cu, null)));
				assertEquals(receivedStr,testString);
			} else if (getType.get(c).equals("class java.lang.Double")) {
				Method getter = reflectClass.getMethod(getName.get(c));
				getter.setAccessible(true);
				double receivedDouble = Double.parseDouble(String.valueOf((getter.invoke(cu, null))));
				assertEquals(receivedDouble,testDouble, 0.001);
			}
		}
	}
}
