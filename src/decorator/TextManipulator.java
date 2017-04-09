/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decorator;

/** Simple TextManipulator interface
 * 
 * TextManipulator stores and manipulates text.i.e. collection of chars
 *
 * @author Alex
 */
public interface TextManipulator {

    /** Adds new char to text
     * 
     * @param c new char to be added
     */
    void append(char c);
    
    /** Appends new chunk of text to the end of text stored
     * 
     * @param text text to be appended, in a form of String
     */

    void append(String text);
    
    /** Clears the text
     * 
     */

    void clear();
    
    /** Returns the contents, or null, if operation is not approaved
     * 
     * 
     * @return 
     */

    String contents();
    
    /** Removes char in position i
     * 
     * @param i pos
     */

    void remove(int i);
    
    /** Replaces the char in position i with new given char
     * 
     * @param i position
     * @param c new char 
     */

    void replace(int i, char c);
    
}
