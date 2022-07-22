package ReflectionAndAnnotation.Exercise._1_HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class Main {

    private final static Field[] DECLARED_FIELDS = RichSoilLand.class.getDeclaredFields();
    private final static Scanner SCANNER = new Scanner(System.in);
    private final static String PRIVATE = "private";
    private final static String PROTECTED = "protected";
    private final static String PUBLIC = "public";
    private final static Function<Field,String> FIELD_STRING_FUNCTION =field -> String.format("%s %s %s",Modifier.toString(field.getModifiers()),field.getType().getSimpleName(),field.getName());

    public static void main(String[] args) throws NoSuchFieldException {

        String input = SCANNER.nextLine();

        while (!"HARVEST".equals(input)) {

            switch (input) {
                case PRIVATE:
                    printFields(PRIVATE);
                    break;
                case PROTECTED:
                    printFields(PROTECTED);
                    break;
                case PUBLIC:
                    printFields(PUBLIC);
                    break;
                default:
                    Arrays.stream(DECLARED_FIELDS).map(FIELD_STRING_FUNCTION).forEach(System.out::println);
            }


            input = SCANNER.nextLine();
        }
    }

    private static void printFields(String modifier) {
        Arrays.stream(DECLARED_FIELDS).filter(field -> Modifier.toString(field.getModifiers()).equals(modifier)).map(FIELD_STRING_FUNCTION).forEach(System.out::println);
    }
}
