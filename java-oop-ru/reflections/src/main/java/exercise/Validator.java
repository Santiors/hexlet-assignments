package exercise;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Object obj) {
        List<String> notValidFields = new ArrayList<>();
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                try {
                    Object value = field.get(obj);
                    if (value == null) {
                        notValidFields.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return notValidFields;
    }

    public static Map<String, List<String>> advancedValidate(Object obj) {
        Map<String, List<String>> errors = new HashMap<>();

        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof NotNull) {
                    try {
                        field.setAccessible(true);
                        Object value = field.get(obj);
                        if (value == null) {
                            addError(errors, field.getName(), "can not be null");
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                if (annotation instanceof MinLength) {
                    try {
                        field.setAccessible(true);
                        Object value = field.get(obj);
                        if (value != null && value instanceof String) {
                            int minLength = ((MinLength) annotation).minLength();
                            if (((String) value).length() < minLength) {
                                addError(errors, field.getName(), "length less than " + minLength);
                            }
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return errors;
    }

    private static void addError(Map<String, List<String>> errors, String fieldName, String message) {
        List<String> fieldErrors = errors.get(fieldName);
        if (fieldErrors == null) {
            fieldErrors = new ArrayList<>();
            errors.put(fieldName, fieldErrors);
        }
        fieldErrors.add(message);
    }

}
// END
