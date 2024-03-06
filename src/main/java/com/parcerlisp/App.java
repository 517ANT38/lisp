package com.parcerlisp;

import com.parcerlisp.parcer.LispExpression;
import com.parcerlisp.parcer.LispParser;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {      
        LispParser parser = new LispParser();
        LispExpression expression = parser.parseFile("main.lisp");
        System.out.println(expression.getValue());
        for (LispExpression child : expression.getChildren()) {
            if (child == null) {
                continue;
            }
            System.out.println(child.getValue());
            if (child.getChildren() == null) {
                continue;
            }
            for (LispExpression subChild : child.getChildren()){
                System.out.println(subChild.getValue());
            }
        }
    }
}
