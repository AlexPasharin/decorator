
package decorator;

import java.util.Scanner;

public class Main {
    
    private static final Scanner lukija = new Scanner(System.in);
    private static TextManipulator kasittelija;
    
    public static void main(String[] args) {
        
        System.out.println("Tervetuloa käyttämään tekstikäsittelijää");
        System.out.println("Haluatko käyttää salasanaa (Y/N)?");     
        
        char vastaus = lukija.nextLine().charAt(0);
        
        kasittelija = textManipulatorFactory(vastaus);
        
        launch();
        
    }

    private static void launch() {
        
        char valinta;
        
        System.out.println("------------------------");
        System.out.println("1. Lisää merkki");
        System.out.println("2. Lisää teksti");
        System.out.println("3. Tulosta teksti");
        System.out.println("4. Korvaa merkki");
        System.out.println("5. Poista merkki");
        System.out.println("6. Lopeta");
        
        do{
           valinta = lukija.nextLine().charAt(0);
           char merkki;
           String teksti;
           int paikka;
           
           switch(valinta){
               case '1': 
                   System.out.println("Anna merkki: ");
                   merkki = lukija.nextLine().charAt(0);
                   kasittelija.append(merkki);
                   break;
               case '2':  
                   System.out.println("Anna teksi: ");
                   teksti = lukija.nextLine();
                   kasittelija.append(teksti);
                   break;                  
               case '3': 
                   System.out.println(kasittelija.contents());
                   break;                  
               case '4': 
                   System.out.println("Anna uusi merkki: ");
                   merkki = lukija.nextLine().charAt(0);
                   System.out.println("Anna indeksi: ");
                   // huom - ei virhekäsittelyä
                   paikka = Integer.parseInt(lukija.nextLine());
                   kasittelija.replace(paikka, merkki);
                   break;                 
               case '5':
                   System.out.println("Anna indeksi: ");
                   // huom - ei virhekäsittelyä
                   paikka = Integer.parseInt(lukija.nextLine());
                   kasittelija.remove(paikka);
                   break;  
               default:     
           }
            
        }while(valinta != '6');
    }
    
    private static TextManipulator textManipulatorFactory(char c){
        
        SimpleTextManipulator manipulator = new SimpleTextManipulator();
               
        if(c != 'Y') return manipulator;
        
        else{
            String password = accuirePassword();
            return new SafeClassManipulator(manipulator, password);
        }    
    }

    private static String accuirePassword() {
        System.out.print("Anna salasana: ");
        return lukija.nextLine();
    }    
}


