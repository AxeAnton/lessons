package ru.itmo.lessons.lessons19;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.Scanner;


public class FileReader {

    // java.io
    // java.nio
    // new File(���� ��� ����������)


    // ���������        ��������
    // InputStream (�����) ��������� ������ ���� � ��������� // �� ��������� � ���������, ����� ���������.
    // OutputStream (�����) �������� ������ �� ���������. // �� ��������� � ���������, ����� ���������.

    // Reader (char) ��������� ������ ��� � ���������
    // Writer (char) �������� ������ �� ���������


    // FileInputStream / FileOutputStream - ��������� �������� � �������, ��������� � ������, ������ �����.
    // ��� �������� �� ��������� � �����.
    // ObjectInputStream / ObjectOutputStream - ������������ ������ � ���� ������������������ ����.

    // FileInputStream(CustomStream(ObjectInputStream((������))))
    // ������ ����������, ����� ������, ������������ � ���� ������������������ ����, ����� ����� �� ����������(����� ���� � � ��������) ������� � �����, ��� ���������� � ����.

    public static boolean writeToFile(byte[] data, File file) /*throws FileNotFoundException*/ { // ��� �������� ������� ������, � ��������� ������ 47, �������������� ������� FileOutputStream, ��� ������� ����������� ������ - �� ����� ���������� �� ���� �� ��� - /*throws FileNotFoundException*/ ��� ���������� ������ Catch ������� 65.
        // Properties
        // ��� ������ ������
        // ��� �������� ������
        // ��� �������� ������

        // ���-�����.properties

        // ��� ��������� ������ �� properties ����� � ��������� Properties


        boolean result = false;
        try (FileOutputStream fileOutput = new FileOutputStream(file, true)) { //���� true - ��������, falce - ����������
            // �������� ������ (����������� ���������� ������) ������ ��� �������� �������. �� �������������� �������� ������ ������� ���������� ������ CLOSE (����� ����������).

            // true - �������� � ���� - new FileOutputStream(file, true)
            // false - ���������� new - FileOutputStream(file)

            // // try with resources (java 7):
            // ���� ����������� �������� ������� (������ ���� �������� ����������) � ������� ������ try �� �������� ������ ���������� ������������� ����� �������� ����������.
            // 1. ��� ���������� ����� try ��������� ��� ������
            // 2. � ����� try ��������� ������. // ������� ����� ������� �� �������� ���������� ������ catch, ������� ��������. � ����� ���� catch.

            // ���� �����, ������ �������� ��������� � try with resources, ���������  AutoCloseable ��������� � ��� ����������� ����� void close()


            // ���� try with resources �� ������������(� ������� ������ �� ���� �� ������������) , ��������� ������� ����� � ����� finally (� ��� ����� ��� ����� ������ ���������� �������� ������, ���������� ����� close ��� ��� �����...)
            // ����� ��� ����� ����������� �������� ������ ���������� ����� ������������ ����������.
            fileOutput.write(data);
            result = true;
        } catch (FileNotFoundException e) { // ���������� ���������� ��� ������.
            System.out.println("�� ������� ������������ ����");
        } catch (IOException e) { // FileNotFoundException - ��������� IOException ������� ���� ��� ��������  ������ �� ������ ������ �� ����.
            System.out.println("�� ������� �������� ������ � ����");
        }
        return result;
        //������ ������, ��� result ��������� ������ �� ����� try, ������� 46, ����� ��� ����� �� �����
    }

    public static byte[] readFromFile(File file) { // ������ �� ����� ����� ����� ������
        byte[] result = null; // ����������� �������� ����������, ��� ���� ������ null ���� ������ �� ����� ���������, ��������� ������ � ������� � ������� ������� ����� ���������.
        try (FileInputStream fileInput = new FileInputStream(file)) { //������� ������ �������� �� ���� ������ �� ������
            result = fileInput.readAllBytes(); // ��� ����� ��� ������
        } catch (FileNotFoundException e) { // �.� ����(new FileInputStream) ����� close, ���������� ���������� ������ ALT+ENTER
            // throw new RuntimeException(e); // ��� ����������� ��������� �������������, ��� �� ��������� �����, ������ ��� ���������
            System.out.println("�� ������� ������������ ����");
        } catch (IOException e) {
            // throw new RuntimeException(e);
            System.out.println("�� ������� ��������� ������ �� �����");
        }
        return result;
    }

    public static boolean writeFromConsole(File file) {
        boolean result = false;
        // �������� ����������
        try (FileOutputStream fileOutput = new FileOutputStream(file, true);
             // ��������� � �� ����� ���� ���������
             BufferedOutputStream buffer = new BufferedOutputStream(fileOutput)) { // � ������� ������� Try ����� ������� ��������� �������� ����� �������.
    // buffer ��������� � ���� ����� �� �����, � ����� �������� fileOutput ��� ������ � ����, �� �������� � �������� buffer ��������� ������ �� fileOutput.

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("������� ������ ��� stop ��� ������");
                String userInput = scanner.nextLine();
                if ("stop".equalsIgnoreCase(userInput)) break;
                buffer.write(userInput.getBytes()); //
                // ���������OutputStream, � ������ ������ buffered, �������� ����� write � OutputStream (� ����� ������FileOutputStream), ����� �������� ���� � ��� ��������� (fileOutput - ������� 93).
                // NB ���������� ������� write � ����, �� ��� ������ ���������� ����������� �������, ��� getBytes.
            }
            result = true;
        } catch (IOException e) {
            System.out.println("�������� � ������� � ����");
        }
        return result;
    }

    public static String readWithBuffer(File file) {
        String result = null;
        try (FileInputStream fileInput = new FileInputStream(file);
             BufferedInputStream bufferedInput = new BufferedInputStream(fileInput); //1.bufferedInput - ����� �� ����� FileInputStream fileInput - ������ ������
             ByteArrayOutputStream byteArray = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[300]; // ��������� ������,  // 4 ���� ��������� ����������� � ��������� ����� ��������� ������ �� ��������, ���������, ��� ����� ����� �����, � ����� ������, ��� �� ��� �� ��������� � ����� ������� ���������� ���������� ���� � 122 ������.
            int count;

            while ((count = bufferedInput.read(buffer)) != -1) { // 2. ������ ���������� �� ������� (bufferedInput) � ��������� ����� //NB ����� read ���������� ��� ���������� ����������� ��� ��� "-1" ���� ������ ������
                byteArray.write(buffer, 0, count); // 3 ��������� � byteArray � 116 ������ �������� ����� ������ write � � �������� � byteArray. ��������, buffer - ������ ������ � �������� � byteArray, off 0 - ��������, ���������� - ������� ��������).
            }

            result = byteArray.toString(); // new String(byteArray.toString());

        } catch (IOException e) {
            System.out.println("������ ������");
        }

        return result;
    }

    // ������ ��� �������������� ����������� � �����, �� �.� ���� ����� �����, �� ��� ������ �� ����������
    public static boolean byteArrayToImage(File file, byte[] bytes) throws IOException { // ������ ��� byte[] bytes ����� ������������ � ������ File file //throws IOException �������� ������ ������, ��� �� �� �� ��������������
        try (ByteArrayInputStream byteArray = new ByteArrayInputStream(bytes)) { //��������� ByteArrayInputStream byteArray (� ��������� (bytes)), �.� BufferedImage image �� ����� ������ ��������, �����
            BufferedImage image = ImageIO.read(byteArray); // ����� ����� ������ �� byteArray
            return ImageIO.write(image, "png", file); // �� ������ ������ ����������� image ��������� ����� write �� ������ ImageIO, � �������� ����������� � file � ����������� png
        }
    }


    // �������� �� ����������� � ������.
    public static byte[] imageToBytes(File file) throws IOException {
        BufferedImage image = ImageIO.read(file); // 1. � ����� ��������� �� ������� (File file) - ImageIO.read(file)
        ByteArrayOutputStream arrayOutput = new ByteArrayOutputStream(); //2. ������� ��������� ������� ���� ����� �������� �����������
        ImageIO.write(image, "png", arrayOutput); //3. �� ������ (imege) ���������� � ByteArrayOutputStream arrayOutput c ����������� png
        return arrayOutput.toByteArray(); // � ������� ��� ����� ������ �������� ������ � ������� toByteArray()
    }

}