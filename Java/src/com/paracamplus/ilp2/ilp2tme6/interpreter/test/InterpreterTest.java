package com.paracamplus.ilp2.ilp2tme6.interpreter.test;

import com.paracamplus.ilp1.interpreter.GlobalVariableEnvironment;
import com.paracamplus.ilp1.interpreter.GlobalVariableStuff;
import com.paracamplus.ilp1.interpreter.OperatorEnvironment;
import com.paracamplus.ilp1.interpreter.OperatorStuff;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.IOperatorEnvironment;
import com.paracamplus.ilp1.interpreter.test.InterpreterRunner;
import com.paracamplus.ilp1.parser.xml.IXMLParser;
import com.paracamplus.ilp2.ast.ASTfactory;
import com.paracamplus.ilp2.ilp2tme6.parser.ilpml.ILPMLOptimizingParser;
import com.paracamplus.ilp2.interfaces.IASTfactory;
//import com.paracamplus.ilp2.interpreter.Interpreter;
import com.paracamplus.ilp2.ilp2tme6.interpreter.Interpreter;
import com.paracamplus.ilp2.parser.xml.XMLParser;
import org.junit.runners.Parameterized;

import java.io.File;
import java.io.StringWriter;
import java.util.Collection;

public class InterpreterTest extends com.paracamplus.ilp2.interpreter.test.InterpreterTest {
    protected static String[] samplesDirName = { "SamplesILP1" , "SamplesILP2", "SamplesTME6"};

    public InterpreterTest(File file) {
        super(file);
    }

    @Override
    public void configureRunner(InterpreterRunner run) throws EvaluationException {
        // configuration du parseur
        IASTfactory factory = new ASTfactory();
        IXMLParser xmlparser = new XMLParser(factory);
        xmlparser.setGrammar(new File(XMLgrammarFile));
        run.setXMLParser(xmlparser);
        run.setILPMLParser(new ILPMLOptimizingParser(factory));

        // configuration de l'interprète
        StringWriter stdout = new StringWriter();
        run.setStdout(stdout);
        IGlobalVariableEnvironment gve = new GlobalVariableEnvironment();
        GlobalVariableStuff.fillGlobalVariables(gve, stdout);
        IOperatorEnvironment oe = new OperatorEnvironment();
        OperatorStuff.fillUnaryOperators(oe);
        OperatorStuff.fillBinaryOperators(oe);
        Interpreter interpreter = new Interpreter(gve, oe);
        run.setInterpreter(interpreter);
    }

    @Parameterized.Parameters(name = "{0}")
    public static Collection<File[]> data() throws Exception {
        return InterpreterRunner.getFileList(samplesDirName, pattern);
    }
}
