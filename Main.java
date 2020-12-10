import java.util.*;
import java.io.*;
class gokul{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Do you have a path to store your file? (Y/N) : ");
        char c = sc.next().toUpperCase().charAt(0);
        String path = "";
        if(c == 'N'){
          try{
            path = "./file1.txt";
            File myObj = new File("./file1.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
              }
          }catch (Exception e){
              System.out.println("Already existed");
          }
        }
        else{
          System.out.println("Enter your exact path (eg : C://Windows://...//filename.txt) : ");
          path = sc.next();
        }
        // sc.nextLine();
        keyValue keypair = new keyValue();
        while (true) {
            System.out.println("------------------------------------");
            System.out.println("1.Store your json value");
            System.out.println("2.Read your Json value");
            System.out.println("3.Delete the value using key");
            System.out.println("4.To Exit the process");
            System.out.println("------------------------------------");
            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    keypair.updatevalue(path);
                    break;
                case 2:
                    keypair.readvalue(path);
                    break;
                case 3:
                    keypair.deletevalue(path);
                    break;
                case 4:
                    return;
            }
        }
    }
}