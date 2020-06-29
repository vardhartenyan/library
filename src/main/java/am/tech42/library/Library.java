package am.tech42.library;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class Library{

	public static List<String> validate(Object obj) throws Exception{
	
	List<String> validField = new ArrayList<>();
        try{
            Class clazz = obj.getClass();
            while (clazz != Object.class){
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(obj);
		if(value == null || value instanceof Integer && (Integer) value <= 0){
				validField.add("valid field:" + field.getName());

			}
            }
            	clazz = clazz.getSuperclass();
            }
            	return validField;

            }catch(Exception e){
		System.out.println(e.getMessage());
            	throw new Exception("Project failed");
            }
	
	
		
	}

}
