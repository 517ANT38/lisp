package com.parcerlisp.parcer;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class LispParser {
    public LispExpression parseFile(String filename) {
        try {
            Scanner scanner = new Scanner(new File(filename));
            LispExpression res = null;
            LispExpression root = null;
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine().trim();
                
                if (res == null) {
                    res = parseExpression(data);
                    root = res;
                }
                else {
                    
                    List<LispExpression> lst = Optional.ofNullable(res.getChildren())
                        .orElse(new ArrayList<LispExpression>());
                    LispExpression e = parseExpression(data);
                    lst.add(e);
                    res = e;
                    
                }
            }
            
            return root;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            
        }
        return new LispExpression("", null);
    }

    private LispExpression parseExpression(String data) {
        if (!data.startsWith("(")) {
            return new LispExpression(data, null);
        }
    
        List<LispExpression> children = new ArrayList<>();
        int start = data.indexOf("(")+1;
        int pr = data.indexOf(" ") == -1 ? start : data.indexOf(" ");
        int end = data.lastIndexOf(")") == -1 ? data.length() - 1 : data.lastIndexOf(")");

        String value = data.substring(start, pr).trim();
        
        String[] childValues = data.substring(pr, end).split("[\\s+()]");

        for (String childValue : childValues) {
            String s = childValue.trim();
            if (s.isEmpty()) {
                continue;
            }
            children.add(parseExpression(s));
        }

        return new LispExpression(value, children);
    }
}
