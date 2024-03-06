package com.parcerlisp.generator;

import com.parcerlisp.parcer.LispExpression;

public interface Generator {
    
    byte[] compileToByteCode(LispExpression node);

}
