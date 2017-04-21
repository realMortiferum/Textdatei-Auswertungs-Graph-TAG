package JUnit;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class GetSetTest {

	static int numget;
	static int numset;
	static List<String> getName = new ArrayList<String>();
	static List<String> getType = new ArrayList<String>();
	static List<String> setName = new ArrayList<String>();
	static List<String> setType = new ArrayList<String>();
	//Variable! reflectClass
	static Class<?> reflectClass = Currency.class;
	static Method[] classMethods = reflectClass.getMethods();

	/**
	 * Ermittelt alle Getter und Setter aus der ausgewählten Klasse und
	 * speichert deren Namen und Typen in einer Liste
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * 
	 */
	
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

	/*
	 * Müssen alle Get Typen vorher definiert werden? ACHTUNG! Derzeit sind
	 * Setter nur für Integer, String und Double gesetzt!
	 */

	/**
	 * Soll alle Getter und Setter auf ihre Funktionalität überprüfen
	 * 
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws ClassNotFoundException
	 */
	
	@Test
	public void setterAndGetterTest() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, ClassNotFoundException {

		testMethodnamesAndMethodtypes();
		//VARIABLEN
		String testString = "Test";
		int testInt = 5;
		double testDouble = 5.55;
		Currency cu = new  Currency();
        //VARIABLEN	

		for (int c = 0; c < numset; c++) {

			String setsub = setName.get(c).substring(3, setName.get(c).length());

			for (int d = 0; d < numget; d++) {
				
				String getsub = getName.get(d).substring(3, getName.get(d).length());

				if (setsub.equals(getsub)) {
					System.out.println("get" + getsub + " == " + "set" + setsub +"\n");
										
					if (getType.get(d).equals("class java.lang.Integer")) {
						System.out.println(setName.get(c)+"\n"+"Nimmt und gibt Integer Wert an" + "\n" + "Set Integer for Test: " + testInt);
						// make Setter accessible	
						Method setter = reflectClass.getMethod(setName.get(c),Integer.class);  
						System.out.println("Setter-Accessability-old: "+setter.isAccessible());
						setter.setAccessible(true);
						System.out.println("Setter-Accessability-new: "+setter.isAccessible());
						//invoke Setter
						setter.invoke(cu,testInt);
					}

					else if (getType.get(d).equals("class java.lang.String")) {
						System.out.println(setName.get(c)+"\n"+"Nimmt und gibt String Wert an" + "\n" + "Set String for Test: " + testString);
						// make Setter accessible
						Method setter = reflectClass.getMethod(setName.get(c),String.class);  
						System.out.println("Setter-Accessability-old: "+setter.isAccessible());
						setter.setAccessible(true);
						System.out.println("Setter-Accessability-new: "+setter.isAccessible());
						//invoke Setter
						setter.invoke(cu,testString);
					}

					else if (getType.get(d).equals("class java.lang.Double")) {
						System.out.println(setName.get(c)+"\n"+"Nimmt und gibt Double Wert an" + "\n" + "Set Double for Test: " + testDouble);
						// make Setter accessible
						Method setter = reflectClass.getMethod(setName.get(c),Double.class);  
						System.out.println("Setter-Accessability-old: "+setter.isAccessible());
						setter.setAccessible(true);
						System.out.println("Setter-Accessability-new: "+setter.isAccessible());
						//invoke Setter
						setter.invoke(cu,testDouble);
					}else{
						fail("Getter Typ nicht definiert");
					}
				}
			}
			System.out.println("\n");
		}


		
		// Getter
		for (int c = 0; c < numget; c++) {

			String methodName = getName.get(c);
			
			System.out.println(methodName);
			System.out.println("Type: "+getType.get(c));
			
			if (getType.get(c).equals("class java.lang.Integer")) {
				// make Getter accessible
				Method getter = reflectClass.getMethod(getName.get(c));
				System.out.println("Getter-Accessability-old: "+getter.isAccessible());
				getter.setAccessible(true);
				System.out.println("Getter-Accessability-new: "+getter.isAccessible());
				//invoke Getter
				System.out.println("Received Integer: "+ getter.invoke(cu,null) + "\n" + "Expected Integer: " + testInt);				
				//assertEqual	
				int receivedInt = Integer.parseInt(String.valueOf((getter.invoke(cu, null))));
				assertEquals(receivedInt,testInt);
			} else if (getType.get(c).equals("class java.lang.String")) {
				System.out.println("Received String: ");
				// make Getter accessible
				Method getter = reflectClass.getMethod(getName.get(c));
				System.out.println("Getter-Accessability-old: "+getter.isAccessible());
				getter.setAccessible(true);
				System.out.println("Getter-Accessability-new: "+getter.isAccessible());
				//invoke Getter
				System.out.println("Received String: "+ getter.invoke(cu,null)+ "\n "+"Expected String: " + testString);
				//assertEqual
				String receivedStr = String.valueOf((getter.invoke(cu, null)));
				assertEquals(receivedStr,testString);
			} else if (getType.get(c).equals("class java.lang.Double")) {
				System.out.println("Received Double: ");
				// make Getter accessible
				Method getter = reflectClass.getMethod(getName.get(c));
				System.out.println("Getter-Accessability-old: "+getter.isAccessible());
				getter.setAccessible(true);
				System.out.println("Getter-Accessability-new: "+getter.isAccessible());
				//invoke Getter
				System.out.println("Received Double: "+ getter.invoke(cu,null)+ "\n"+ "Expected Double: " + testDouble);
				//assertEqual
				double receivedDouble = Double.parseDouble(String.valueOf((getter.invoke(cu, null))));
				assertEquals(receivedDouble,testDouble, 0.001);
			}
			System.out.println("\n");
		}
	}
}
