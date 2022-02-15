package base;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFile {

    public static Properties prop = new Properties();   // Class level obj creation and variable declared
    public static String emailQA;
    public static String passwordQa;
    public static String emailStg;
    public static String passwordStg;
    public static String emailProd;
    public static String passwordProd;


    public static void main(String[] args) {            // main method to call method
        readProperty();
    }

    public static void readProperty() {                 // read property method

        {
            try {
                InputStream  inputFile = new FileInputStream("src/main/java/config/config.properties");
                prop.load(inputFile);
                emailQA= prop.getProperty("emailQa");
                System.out.println(emailQA);
                passwordQa= prop.getProperty("passwordQa");
                System.out.println(passwordQa);
                emailStg=prop.getProperty("emailStg");
                System.out.println(emailStg);
                passwordStg=prop.getProperty("passwordStg");
                System.out.println(passwordStg);
                emailProd=prop.getProperty("emailProd");
                System.out.println(emailProd);
                passwordProd=prop.getProperty("passwordProd");
                System.out.println(passwordProd);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
