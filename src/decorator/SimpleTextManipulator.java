/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decorator;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

/** Simple text manipulator - all operations always allowed
 * Text is keeped internely in a char list, for efficiency reasons
 *
 * @author Alex
 */
public class SimpleTextManipulator implements TextManipulator {
    
    private final List<Character> contents;
    
    public SimpleTextManipulator(){
        this.contents = new ArrayList<>();
    }
    
    public SimpleTextManipulator(String text){
        // using lambda we convert String into ArrayList of chars
        this.contents = new ArrayList<>(
                            text.chars()
                            .mapToObj(e -> (char)e)
                            .collect(Collectors.toList()));
    }
    
    @Override
    public String contents(){
        // using StringBuilder and lambdas we convert the text into a String
        StringBuilder sb = new StringBuilder(this.contents.size());
        
        this.contents.stream().forEach((e) -> {
            sb.append(e);
        });
        
        return sb.toString();
    }
    
    @Override
    public void append(char c){
        this.contents.add(c);
    }
    
    @Override
    public void append(String text){
        char[] newSymbols = text.toCharArray();
        
        for(char e : newSymbols){
            this.contents.add(e);
        }
    }
    
    @Override
    public void replace(int i, char c){
        this.contents.set(i, c);
    }
    
    @Override
    public void remove(int i){
        this.contents.remove(i);
    }
    
    @Override
    public void clear(){
        this.contents.clear();
    }
    
    
}
