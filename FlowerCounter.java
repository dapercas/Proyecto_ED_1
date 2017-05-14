package flowercounter;
import java.util.*;

/*** @author Pedro Garcia M. */

public class FlowerCounter {

    public static Scanner stdin = new Scanner(System.in);
    
    private static String[]flowers = {"petunia", "pansy", "rose", "violet", "carnation"};
    private static double[]flowersPrices = {0.50, 0.75, 1.50, 0.50, 0.80}; /*Respectively to each flower*/
    private static int[]cart = {0, 0, 0, 0, 0};
    private static double[]total = {0.0, 0.0, 0.0, 0.0, 0.0};
    
    public static void addToCart(String nameFlower){
        int i, index, addCart; boolean enc = false;
        nameFlower = nameFlower.toLowerCase();
        
        index = 0;
        
        for(i=0; i<flowers.length; i++){
           if(nameFlower.equals(flowers[i])){
               index = i;
               enc = true;
           }
        }
        
        if(enc){
            FlowerCounter.clearScreen();
            do{
                System.out.println("Hoy many " + flowers[index] + "(s) do you want?");
                addCart = stdin.nextInt();
                if(addCart < 0){
                    System.out.println("You can't enter a negative unit. If you don't want " + flowers[index] + "(s) insert 0.");
                }
            }while(addCart < 0);
            cart[index]+=addCart;
            FlowerCounter.clearScreen();
        }
        else{
            System.out.println("Sorry, the " + nameFlower + " has been not found.");
        }
    }
    
    public static void printTicket(){
        
        FlowerCounter.clearScreen();
        
        for(int i=0; i<flowersPrices.length; i++){
            total[i]=flowersPrices[i]*cart[i];
        }
        
        for(int i=0; i<flowers.length; i++){
            do{
                flowers[i]+=" ";
            }while(flowers[i].length()<=16);
        }
        
        double totalPay = 0.0;
        for(int i=0; i<total.length; i++){
            totalPay+=total[i];
        }
        
        Calendar dateTicket = GregorianCalendar.getInstance();
        System.out.println("        Florist DAW         ");
        System.out.println(" IES Juan de Garay(Valencia)");
        System.out.println(dateTicket.getTime().toString());
        System.out.println("-----------------------------");
        
        for(int i=0; i<flowers.length; i++){
           if(cart[i]>0){
               System.out.printf(" %dx %S", cart[i], flowers[i]);
               System.out.printf("");
               System.out.printf(" %.2f €%n", total[i]);
           } 
        }
        
        System.out.println("-----------------------------");
        System.out.printf("Total to pay          %.2f €%n", totalPay);
        float iva;
        iva = (float) (totalPay - (totalPay/1.21));
        System.out.printf("IVA                   %.2f € %n", iva);
        
    }
    
    public static int menu(){
        int option;
        System.out.println("*******************");
        System.out.println("*** Florist DAW ***");
        System.out.println("*******************");
        System.out.println("| 1. Buy flowers. |");
        System.out.println("| 2. Checkout.    |");
        System.out.println("-------------------");
        do{
            System.out.println("Select a option: ");
            option = stdin.nextInt();
        }while(option < 1 || option > 2);
        return option;
    }
    
    public static void clearScreen(){
        for(int i=0; i<30; i++){
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        String flower;
        int option;
        
        do{
            option = menu();
            switch(option){
                case 1:
                    stdin.nextLine();
                    System.out.println("Enter the name of the flower you want: ");
                    flower = stdin.nextLine();
                    FlowerCounter.addToCart(flower);
                    break;
                case 2:
                    FlowerCounter.printTicket();
                    System.exit(0);
            }
        }while(option != 2);
    }
    
}
