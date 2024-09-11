package exercise;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;

// BEGIN
class Validator {

    public static ArrayList<String> validate(Object obj) {
        ArrayList<String> result = new ArrayList<String>();

        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {

            boolean isNotNull = false;
            Annotation[] annotations = field.getDeclaredAnnotations();

            for (var annotation : annotations) {
                if (annotation instanceof NotNull) {
                    isNotNull = true;
                }
            }

            field.setAccessible(true);

            try {
                if (field.get(obj) == null && isNotNull) {
                    result.add(field.getName());
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        return result;
    }
}
// END
