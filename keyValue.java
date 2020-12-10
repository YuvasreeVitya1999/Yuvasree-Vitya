import java.util.*;
import java.io.*;

public class keyValue {
    public  Scanner sc = new Scanner(System.in);

    public  void updatevalue(String path) {
        try {
            boolean keytry = true;
            Scanner filesc = new Scanner(new File(path));
            File fileSize = new File(path);
            if(fileSize.length() == 1073741824){
                System.out.println("------------------------------------");
                System.out.println("File size Exceeded Please try again");
                System.out.println("------------------------------------");
                return;
            }
            System.out.print("Enter the key : ");
            String key = sc.next();

            while (filesc.hasNextLine()) {
                String check = filesc.nextLine();
                String checkarr[] = check.split(",");
                if (checkarr[0].equals(key)) {
                    keytry = false;
                    break;
                }
            }
            if (!keytry) {
                System.out.println("------------------------------------");
                System.out.println("Key Value is already present Please Try again");
                System.out.println("------------------------------------");
                return;
            }
            BufferedWriter myWriter = new BufferedWriter(new FileWriter(path, true));
            myWriter.write(key + ",");
            System.out.print("Enter the value : ");
            myWriter.write(sc.next() + ",");
            myWriter.newLine();
            myWriter.close();
        } catch (Exception e) {
            System.out.println("------------------------------------");
            System.out.println("Error occured");
            System.out.println("------------------------------------");
        }
    }

    public  void readvalue(String path) {
        System.out.print("Enter your Key to obtain the data : ");
        String keyvalue = sc.next();
        try {
            Scanner filesc = new Scanner(new File(path));
            while (filesc.hasNextLine()) {
                String line = filesc.nextLine();
                String linearray[] = line.split(",");
                if (linearray[0].equals(keyvalue)) {
                    System.out.println("------------------------------------");
                    System.out.println("The value is " + linearray[1]);
                    System.out.println("------------------------------------");
                }
            }
        } catch (Exception e) {
            System.out.println("------------------------------------");
            System.out.println("Error happened");
            System.out.println("------------------------------------");
        }
    }
    public  void deletevalue(String path){
        File file1 = new File(path);
        File file2 = new File("./file2.txt"); 
        try{
            System.out.print("Enter the key to delete the value : ");
            String key = sc.next();
            Scanner filesc = new Scanner(new File(path));
            BufferedWriter myWriter = new BufferedWriter(new FileWriter("./file2.txt", true));
            while (filesc.hasNextLine()) {
              String check = filesc.nextLine();
              String checkarr[] = check.split(",");
              if (checkarr[0].equals(key)) {
                continue;
              }
      
              myWriter.write(check);
              myWriter.newLine();
            }
            myWriter.close();
            filesc.close();
        }catch(Exception e){
            System.out.println(e);
        }
        boolean successful = file2.renameTo(file1);
        if(successful){
            System.out.println("------------------------------------");
            System.out.println("Deleted succeessfully");
            System.out.println("------------------------------------");
        }

    }
}
//