/**
 * Date: 2021-07-02
 * File Name: Message.java
 * Auther: Zhicheng Wang
 */

package zw222bc_assign3;

/**
 * Class Description: Message class can be set/get text 
 *                    and return the set message by toString() funxtion
 *                    and has the encode method to encode the text message
 * 
 * @version 1.1 03 July 2021
 * @auther Zhicheng Wang
 */

public class Message 
{
    private String text;                                         // the private data member "text" to store message

    // constructors
    public Message(String newText) {text = newText;}
    public Message() {}

    public void setText(String newText) {text = newText;}        // Mutator method

    public String getText() {return text;}                       // Accessor method
    
    public String toString() {return "The message: " + text;}    // return the data member "text"
    
    /* replacing each alphabetic character (aA to zZ) with the character that comes after it */
    public String encode()
    {
        
        String orginalText = text;                      // the text data member in Message
        String encodeText = "";                         // initialize the encode text
        int length = orginalText.length();              // the length of the text
        char character;                                 // the character to store the coding char
        int charIndex;                                  // the char index in the orginal text

        // use for-loop to replace one by one
        for (int i = 0; i < length; i++)
            {
                charIndex = orginalText.charAt(i);

                if ((charIndex < 65) || ((charIndex > 90) && (charIndex < 97)) || (charIndex > 122))        // if not alphabetic characters, not change
                {
                    character = orginalText.charAt(i);
                }
                else if ((charIndex == 90) || (charIndex == 122))       // if z or Z, replaced with a or A
                {
                    charIndex -= 25;
                    character = (char)charIndex;
                }
                else        // replace with the character that comes after it 
                {
                    charIndex ++;
                    character = (char)charIndex;    
                }

                encodeText += character;
            }

        return encodeText;
    }
}
