package com.paracamplus.ilp2.ilp2tme6.transform.Test;

import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.tools.Input;
import com.paracamplus.ilp1.tools.InputFromFile;
import com.paracamplus.ilp2.ilp2tme6.transform.CallAnalysis;
import com.paracamplus.ilp2.interfaces.IASTprogram;
import com.paracamplus.ilp1.parser.ParseException;

import com.paracamplus.ilp2.ast.ASTfactory;
import com.paracamplus.ilp2.ilp2tme6.parser.ilpml.ILPMLOptimizingParser;
import com.paracamplus.ilp2.interfaces.IASTfactory;
import org.junit.Before;
import org.junit.Test;

import java.io.File;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CallAnalysisTest {

    protected CallAnalysis callAnalysis;
    protected String path = "SamplesTME6/CallAnalysis";
    protected IASTfactory factory;
    protected ILPMLOptimizingParser ilpmlParser;

    @Before
    public void init() {
        factory = new ASTfactory();
        ilpmlParser = new ILPMLOptimizingParser(factory);
    }

    @Test
    public void testRecursif() throws ParseException, CompilationException {
        File file = new File(path+"/s1.ilpml");
        Input input = new InputFromFile(file);
        System.err.println("Testing " + file.getAbsolutePath() + " ...");
        ilpmlParser.setInput(input);
        IASTprogram program = ilpmlParser.getProgram();

        callAnalysis = new CallAnalysis(program);

        assertTrue(callAnalysis.isRecursive(factory.newVariable("pow")));
    }

    @Test
    public void testMutuelleRecursif() throws ParseException, CompilationException {
        File file = new File(path+"/s2.ilpml");
        Input input = new InputFromFile(file);
        System.err.println("Testing " + file.getAbsolutePath() + " ...");
        ilpmlParser.setInput(input);
        IASTprogram program = ilpmlParser.getProgram();

        callAnalysis = new CallAnalysis(program);

        assertTrue(callAnalysis.isRecursive(factory.newVariable("isOdd")));
        assertTrue(callAnalysis.isRecursive(factory.newVariable("isEven")));
        assertFalse(callAnalysis.isRecursive(factory.newVariable("moins")));
    }







}
