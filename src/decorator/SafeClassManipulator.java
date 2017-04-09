/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decorator;

import java.util.Scanner;

/** This class is a decorator for a SimpleTextManipulator that adds a "security check" 
 * All operations are designed so that the user is first asked for a password
 * If password is wrong operation is denied
 * For simplicity reasons no password change is supported
 *
 * @author Alex
 */
public class SafeClassManipulator implements TextManipulator{

    private final SimpleTextManipulator textManipulator;
    private final String password;
    private static final PasswordChecker CHECKER = new PasswordChecker();

    public SafeClassManipulator(SimpleTextManipulator textManipulator, String password) {
        this.textManipulator = textManipulator;
        this.password = password;
    }

    @Override
    public void append(char c) {
        if(CHECKER.checkPassword(this)) this.textManipulator.append(c);
    }
       
    @Override
    public void append(String text) {
        if(CHECKER.checkPassword(this)) this.textManipulator.append(text);
    }

    @Override
    public void clear() {
        if(CHECKER.checkPassword(this)) this.textManipulator.clear();
    }    

    // note - if password is wrong, a null is returned!
    @Override
    public String contents() {
        if(CHECKER.checkPassword(this)) return this.textManipulator.contents();
        else return null;
    }

    @Override
    public void remove(int i) {
        if(CHECKER.checkPassword(this)) this.textManipulator.remove(i);
    }

    @Override
    public void replace(int i, char c) {
        if(CHECKER.checkPassword(this)) this.textManipulator.replace(i,c);
    
    }
    
    private boolean checkPassword(String string){
        return this.password.equals(string);
    }
    
    // private class designed for interaction with user
    // note that it is used as a singleton is a host class
    // asks for a password, handles the mistake situation and notifies host if the password was wrong

    private static class PasswordChecker{
    
        private static final Scanner scanner = new Scanner(System.in);
        
        // note - this method violates SRP...
        
        boolean checkPassword(SafeClassManipulator manipulator){
            System.out.print("Anna salasana: ");
            String string = scanner.nextLine();
            
            boolean result = manipulator.checkPassword(string);
            
            if(!result)
                System.out.println("Väärä salasana!");
            
            return result;
        }
    }    
    
}
    
    


