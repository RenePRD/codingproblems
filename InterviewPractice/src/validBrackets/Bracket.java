package validBrackets;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Bracket {

    public static void main(String[] args) {
        System.out.println(validBracket("()")); //true
        System.out.println(validBracket("(]")); //false
        System.out.println(validBracket(")(")); //false
        System.out.println(validBracket("({})")); //true
        System.out.println(validBracket("{(})")); //false
        System.out.println(validBracket("{{{{{{"));//false
        System.out.println(validBracket("{(){}[]}"));//true

    }
    //it's the first bracket, so pop in stack
    //second bracket, check if it's open or close bracket
        //if open, push in stack
        //if close, check and pop stack
            //if it matches, then continue
            //if it doesn't, then return false


    //check if there is matching bracket with the current bracket you're on
    //we're only checking if the current bracket we're on is a closing bracket
    //add bracket

    public static boolean validBracket(String brackets) {
        Stack<Character> characterStack = new Stack<>();
        Character currentCharacter;
        for(int i=0; i <= brackets.length() -1; i++) {
            currentCharacter = brackets.charAt(i);
            if (Character.toString(currentCharacter).matches("\\} | \\] | \\)") && characterStack.isEmpty())
                return false;
            switch (currentCharacter) {
                case '}':
                    if (characterStack.pop().compareTo('{') != 0 )
                        return false;
                    break;
                case ')':
                    if (characterStack.pop().compareTo('(') != 0)
                        return false;
                    break;
                case ']':
                    if (characterStack.pop().compareTo('[') != 0)
                        return false;
                    break;
                default:
                    characterStack.push(currentCharacter);

            }
        }
        if (characterStack.isEmpty())
            return true;
        else
            return false;
    }
}