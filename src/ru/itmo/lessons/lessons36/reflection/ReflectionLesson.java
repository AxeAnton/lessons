package ru.itmo.lessons.lessons36.reflection;

import java.lang.reflect.*;
import java.util.Arrays;

public class ReflectionLesson {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException, NoSuchFieldException {
/*
        // 1. Reflection API - ��� ����� ������� ������� ���� � ����� ��� ��������� �������� � �������� ����������, �������� � �������������� ��� � ���������.
        ���� �� ������� ��� Reflection API, �� �� ������������, ���� ����������� ����� � ����� ��� ������ (��������� ���� class)!!!, � �� ������ ����� ������ �� ������� ��� ���� ���������� ������.
        ��� �������� ������ ������ �������� ��������� ���� Field, ��� ������, �������, �������, ����������������, �� ����������������, ������������� ��������� � �������������� � ������ ������������ �������� ������������ ����������� � ������ ��� �������� ������������ ������ Field.
        ��� ����� �������� ������������ ���� Method
        ��� ������������ �������� ��������� ���� Constructor
        � ����� � ��� ��� ��� �������, �������������, � ��� ���� ���������� ����� ������� � ��������.
*/

 /*
        // 2. ��������� � Java � ��� ��������, � ������� �������� ����� ������� ���������
        � �������� ���������� � �������, �����������, ����� � �������
        �� ����� ����������, ��� ���� �� ���� ���� ���� �������, ������� � �����.
        ����� ����, Reflection API ���� ����������� ��������� ����� ���������� �������,
        �������� ������, � ����� �������� ��� ������������� �������� �����.
        ��� �� ���������� ��������, ��� ���� ����������� ������ ������������ � runTime, �� ���� ��� �������� ������������ �������� �� ������� ����������. �� ������� ����������, ���-�� ������������, ���������, ����������� ���������� � �.�. � �� ���� �������� �������� ���� ��������� ������� ORM.
 */

/*        // 3. ��� �� �������� ����� � ������ ����� �������� ������ �� �����, �� ����� �������� ����� ���������:
         NB - ������ ���������� � ������ �� �������� String ��������� ����� � �������� ����� class.  �� ����� String.class - ������ �� ����� String �� �� ���������. ������ �� ����� ������������� ���������� stringClass.
         ������ �� ����� ��������� ���������� � ���� � ������ ��� �������� ������ � �.�.
*/
        Class<String> stringClass = String.class;
        System.out.println("stringClass: " + stringClass);
        // 4. ������ ������ ����� �������� � �� ����� int � �� ����� ������.
        Class<Integer> intClass = int.class;
        System.out.println("intClass: " + intClass);

        TextMessage textMessage = new TextMessage("qwerty"); // ������ �� ����� int........
        textMessage.setText("��� ������ � ����� �������� ���������");

        Class<TextMessage> textMessageClass = TextMessage.class;
        System.out.println("textMessageClass: " + textMessageClass);
        //5 NB - ������ ������� �������� ������ �� �����, ����� ������ ����� ������, � ������� ������� ���� ����� getClass, ����� getClass ���������� ������ �� ����� ������, � ��� ������� �� ������� ��������, ��� ��� ��� ������ ��������������� �� ����� ������, �� � ����� ����� ���� � ��� ��!
        //6.  Class<? extends TextMessage> textMessageClass02 - ����� textMessageClass02, ����� ���� ���� TextMessage ���� ����� �� ��� �����������, ������? ������ ��� ��� � ���� ������� TextMessage textMessage = new TextMessage("qwerty");, ��� ���� new TextMessage, ����� ����� �� TextMessage, � ����� ���� � ��� ���������, Message ��� ������� ������ (��� ��� � ArryLisy, LinkList, ������� ����� �� �� List). �� ����� � ��������� ���� ?
        Class<? extends TextMessage> textMessageClass02 = textMessage.getClass();
        System.out.println("textMessageClass02: " + textMessageClass02);

        // 7. ����� ��������� ������ �� ����� (textMessageClass), ����� ��������: ��� ��� ������(getPackageName), ��� ������ + ��� ������ (getName) � ����������� ��� ������ (getSimpleName)
        System.out.println("��� ������: " + textMessageClass.getPackageName());
        System.out.println("��� ������ + ��� ������: " + textMessageClass.getName());
        System.out.println("��� ������: " + textMessageClass.getSimpleName());

        // 8. ��� �� ���� ������ �� ����� �� ����� �������� ������ �� ���������� ������, ������� ��������� ����� (�� �� ��������) + ���� ������ �� ����� �� ����� �������� ������ �� ������������ �����, ����� �� ��� �������� � ��� �� Objecta. �.� � ������ ����� ���� ����� �����������, ��� ���������� ���������� � ������ [], ������ �� ���������� �� �������� �� ������ getInterfaces, ������ �������� ���� �� ������ � �������� �� ������.
        Class<?>[] interfaces = textMessageClass.getInterfaces();
        System.out.println("���������� ������, ��� ����� ����������� ��������: " + Arrays.toString(interfaces));

        // 9. ��������� ������ �� ������������ �����. � ������� ������ ����� ���� ������ ���� ��������, ������������� ����� �� �������� ������ �� �������� ��� ��� �� �����, � ������ ������������ ���������.
        // 10. ��� �� �������� ������ �� ���������� � ������ �� ����� textMessageClass � �������� ����� getSuperclass � ������� ������ �� ��� ��������.
        System.out.println("������������ ����� [1]: " + textMessageClass.getSuperclass());
        System.out.println("������������ ����� [2]: " + textMessageClass.getSuperclass().getSuperclass()); // 11. ����� ��������� ������ �� ����� �������� �������� � �������� - Object
        System.out.println("������������ ����� [3]: " + textMessageClass.getSuperclass().getSuperclass().getSuperclass()); // 12. � ���� ��������� ������ �� �������� Object ������� - null, �.� � Object ��� ��������

        // 13. �� ���� ���� �������� ������ �� ���������� ������������� ������, �� �������� ������� ��������� ������������� ������ textMessageClass.getSuperclass()., � ����� �������� ����� ��������� ���������� getInterfaces.
        System.out.println("���������� ������������� ������: " + Arrays.toString(textMessageClass.getSuperclass().getInterfaces()));

        // 14 ������, ��� �� ��� ����� ������� ���������� textMessageClass ����������� ������ �� ����� TextMessage.
        textMessageClass = TextMessage.class;

        // 15. � jave �������� ��� �� �������� �������� � ���� ��������������.

/*
        // 16. ��� ��������, ��������� ������ ���� ����� ���� ������. � ����� ������ �� �������� ������ ���� Field:
         ������, �������� ���� ������ � ������� getFields, ���������� ������ �� ����/�������� ������ �������� � ������������ ������� ������� ����������� ������� public!
         ������, �������� ���� ������ � ������� getDeclaredFields �� �������� ������ �� ����� ������ � � ����� ������������� (������� public, private, protected � packageprivate), �� ������ �������� ������ (���� ����� �������� �������� �� ���� ������� �������� ������ �� ��������, � ����� �������� �����, ����� ��� ����� ����).
*/
        Field[] fields = textMessageClass.getFields();
        System.out.println("������ �� public ���� ������: " + Arrays.toString(fields));

        Field[] declaredFields = textMessageClass.getDeclaredFields();
        System.out.println("������ �� ���� ������: " + Arrays.toString(declaredFields));

        // 17. ��� �������� ����� ������ ���, ���, ������������ � �������� ������� ����
        for (Field field : fields) { // 18 ���������� ����� �� ������ fields, �� � DeclaredFiel, ��� ����� ���� ���������� ����������������, ��� �� �� ���� � ������� (assessable). ���������� �������� - fields.setAccessible(true);), � �. 21 ����� ����� ��� ��.
            System.out.println("��� ����: " + field.getName());
            System.out.println("��� ����: " + field.getType());
            // 19 ����� ��������� �� ������� ������������ final (�� � ������ ������) ���������� � ������ ����� Modifier (���������� true(���� �����������) � false(��� �����������) � � ����� �������� ��� ������������ ����, �������� ���� �������� Final - ����� ������ ����� .isFinal(field.getModifiers(), �� ������� true ���, ��� �� ��� ����.
            System.out.println("������� ������������ final: " + Modifier.isFinal(field.getModifiers()));

            field.setAccessible(true);
            // 20. ��������� �������� �������� ����� ���������. ���� �������� �� �����������, �� ��� �� ������ �������� �������� ����� ������. fields.setAccessible(true);
            // 21 ����������, ��� ������ �� �������� � filed (� ��� ��������� code)���� � ���� field ������� ����� .get(textMessage) � ��������� � ���� ������ (������ ��� ������) �� ������� ......, ���� � ���� ����������� privet �� ��������� �� ������� exeption, ���� ����� ��� �� ������� fields.setAccessible(true); �� ����� �������� �������� ���� ��� �������� �������. ��� ���� �����, ��� �������� textMessage.code. ��� �� �������� � privet �������������, ������ � ������� setAccessible, �� ���� ����� �������� �������� field.setAccessible(true);, �� ������� � privet ����.
            System.out.println("�������� ���� ��� ����������� �������: " + field.get(textMessage));
        }

        // 22 ��������� ������ �� ������ - ���������� �����/���������
        // 23 ���������� ������ �� ��� ��������� ������ ������ (������� ������������)
        Method[] methods = textMessageClass.getMethods();
        System.out.println("������ �� public ������ ������: " + Arrays.toString(methods));

        // 24 ���������� ������ �� ��� ������ ������ (������� private � protected, �� �� ��������)
        Method[] declaredMethods = textMessageClass.getDeclaredMethods();
        System.out.println("������ �� ������ ������: " + Arrays.toString(declaredMethods));

        // 25 ��� �������� (����� � declaredMethods ��� methods) �� ������� ������ ����� ������ ����� � ���� ���������, �����������, ��� ������������� �������� � ��
        for (Method method : methods) {
            System.out.println("---��� ������: " + method.getName());
            System.out.println("��� ������������� ��������: " + method.getReturnType());
            System.out.println("������� ������������ final: " + Modifier.isFinal(method.getModifiers()));
            System.out.println("������� ������������ synchronized: " + Modifier.isSynchronized(method.getModifiers()));
            System.out.println("���������� ����������/����������: " + method.getParameterCount());
            System.out.println("���� ����������/����������: " + Arrays.toString(method.getParameterTypes()));
            System.out.println("������������� ����������: " + Arrays.toString(method.getExceptionTypes()));
        }

        // 26 ��������� ������ �� ������������ (getDeclaredConstructors - ������� ���������, �� ��� ������������)
        Constructor<?>[] declaredConstructors = textMessageClass.getDeclaredConstructors();
        System.out.println("������ �� ������������: " + Arrays.toString(declaredConstructors));

        // 25 ��� �������� �� ������� ������������ ����� ������ ����� ����, �� ����� ������ ��� ���������� � ���� ����������, �.� ��� ���������� ��� �������� ������� (����� ���������� ���������� ���������� � ����������� �������).
        for (Constructor<?> constructor: declaredConstructors) {
            System.out.println("---���������� ����������/����������: " + constructor.getParameterCount());
             System.out.println("--���� ����������/����������: " + Arrays.toString(constructor.getParameterTypes()));
             System.out.println("---������������� ����������: " + constructor.getExceptionTypes());
        }

        // 26. �������� ����������� � �������������� ��������� (��� new)

        // 28. ���� �����, ��� � �. 14
        textMessageClass = TextMessage.class;

        // 27. � ������ ������� ���������� �������� ������ �� ����������� - tmConstructor, ���������� �����, ������������������ ���������� ���������� ������������ � �� ���� - getDeclaredConstructor
        // 28. �������� ���, � ������ �� ����� textMessageClass �������� ����� getDeclaredConstructor � �������� ��� ���� ���������� ������� �� ��������� String.class (���������� ������, ����� ���������� ��������� ����������, ��������� �� ������� ���������� � �� ���� �.25, �� ���������� ����� �� ������, �� ����� ���������� ������ ������ ������ ����������� ����� ��������� ������ � �������).
        Constructor<TextMessage> tmConstructor = textMessageClass.getDeclaredConstructor(String.class);

        // 29. ����� ��������� ������ �� ����������� ����� ��������� ��������� �������
        // 30. � ������ �� ����������� tmConstructor �������� ����� newInstance � �������� ����������, ������������ � ����������� (��������� ��� ����� �� �����, �� �������, ������� ����� ��������� �������� ������������, ���� ���������� ���������� �������� (���-�� � ������, �������� � �.�.) ������ ���� ������ ������ ���� ����� ������� ��� �� ��� � � ������������, �������� ������� string ����� int � ��.) ��� �� �������� ����� ���� ������
        TextMessage reflectMessage = tmConstructor.newInstance("Reflect Message");
        System.out.println("������������ ���������: " + reflectMessage);

        // 31. � ���������� ���������� ����� �������� ������ (getXXXXXXX/getDeclaredField/....) � ���������� � ��������� ����� ���������

        // 32. ��������� ������ �� ���� �� ��� ����� ("text") � ������
        Field textField = textMessageClass.getDeclaredField("text");
        // 33. ���������� ����������� �������� � private � protected ������, ��� � public
        textField.setAccessible(true);

        // 34. ���������� �������� ���� ��� ����������� �������, ���� ��������� ����������� �������, � ��������� ������ - IllegalAccessException
        // 35. � ������ �� ����/�������� textField �������� ����� get � �������� � �������� ���������� ������� reflectMessage
        System.out.println("�������� �������� text ��� ������� reflectMessage: " + textField.get(reflectMessage));

        // 36. ������������� �������� ���� (�������� ��� ������) ��� ����������� �������, ���� ��������� ����������� �������, � ��������� ������ - IllegalAccessException
        // 37. � ������ �� ���� textField �������� ����� set � �������� � �������� ������ �� ��������� ������� reflectMessage � ��������������� �������� ����/�������� "xxxxxx"
        textField.set(reflectMessage, "�������� ���� ������� reflectMessage ����������� ����� ���������");


        // � ������������� ��������� ����� ��������, ��� � �������� � �������� (� ��� ����� ��� ������ ��������� �������� �������� text??)
        System.out.println(reflectMessage.getText());


        // 38. � ������� ����� ������� ����� ����� ��������� ���������, ��� ����� ���������� �������� ������ �� ���� �����, � ����� ���� � ������������������ ����������.
        // 39. ��������, ��������� ������ �� ����� - setTextMethod �� ��� ����� - "setText" � ������ - textMessageClass, ��� ����� ���������� �����, ������������������ ���������� ���������� ������ � �� ���� - String.class
        Method setTextMethod = textMessageClass.getDeclaredMethod("setText", String.class);
        // 40. ����� ������ ����������� �������, �������� ����������� ����������, ��������� �� ��������(invoke). ��� ���� ����� setTextMethod � ����������� ������� reflectMessage � �������� � ����� ��� ��� ������� "����� �����".
        setTextMethod.invoke(reflectMessage, "����� �����");
        System.out.println(reflectMessage.getText());

        Method printInfoMethod = textMessageClass.getDeclaredMethod("printInfo");
        printInfoMethod.setAccessible(true);
        printInfoMethod.invoke(reflectMessage);

        // TODO: ����������� ������������ ����� public static String toString(Object o){ }
        //  ������� ������� ��� �������� � �������� �������� ��� ������� 'obj' ���� �������� �������� ���������� (@Exclude �� �������� � ������� ���������� �� ������� ����. ���������� �������� �������������� . ��� ����� ����� ������������ ����� �������


    }
    public  static void toString(Object obj){

    }
}
