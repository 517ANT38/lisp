package com.parcerlisp.parcer;

import java.util.List;

public class LispExpression {
    private String value;
    private List<LispExpression> children;

    public void setChildren(List<LispExpression> children) {
        this.children = children;
    }

    public LispExpression(String value, List<LispExpression> children) {
        this.value = value;
        this.children = children;
    }

    public String getValue() {
        return value;
    }

    public List<LispExpression> getChildren() {
        return children;
    }
}
