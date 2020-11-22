package com.paracamplus.ilp2.ilp2tme5bis.interpreter;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.ILexicalEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.IOperatorEnvironment;
import com.paracamplus.ilp2.ilp2tme5bis.interfaces.IASTbreak;
import com.paracamplus.ilp2.ilp2tme5bis.interfaces.IASTcontinue;
import com.paracamplus.ilp2.ilp2tme5bis.interfaces.IASTloop;
import com.paracamplus.ilp2.ilp2tme5bis.interfaces.IASTvisitor;
import com.paracamplus.ilp2.interfaces.IASTfunctionDefinition;
import com.paracamplus.ilp2.interfaces.IASTprogram;

import java.util.ArrayList;

public class Interpreter extends com.paracamplus.ilp2.interpreter.Interpreter
        implements IASTvisitor<Object, ILexicalEnvironment, EvaluationException> {

    private ArrayList<String> labels;
    protected int nbWhile = 0;

    public Interpreter(IGlobalVariableEnvironment globalVariableEnvironment, IOperatorEnvironment operatorEnvironment) {
        super(globalVariableEnvironment, operatorEnvironment);
        labels = new ArrayList<>();
    }

    @Override
    public Object visit(com.paracamplus.ilp1.interfaces.IASTprogram iast, ILexicalEnvironment lexenv) throws EvaluationException  {
        return visit((IASTprogram)iast, lexenv);
    }

    public Object visit(IASTprogram iast, ILexicalEnvironment lexenv)
            throws EvaluationException {
        for ( IASTfunctionDefinition fd : iast.getFunctionDefinitions() ) {
            Object f = this.visit(fd, lexenv);
            String v = fd.getName();
            getGlobalVariableEnvironment().addGlobalVariableValue(v, f);
        }
        try {
            return iast.getBody().accept(this, lexenv);
        } catch (Exception exc) {
            return exc;
        }
    }

    @Override
    public Object visit(IASTloop iast, ILexicalEnvironment lexenv) throws EvaluationException {
        if (!iast.getLabel().isBlank()){
            labels.add(iast.getLabel());
        }
        while ( true ) {
            Object condition = iast.getCondition().accept(this, lexenv);
            if ( condition instanceof Boolean ) {
                Boolean c = (Boolean) condition;
                if ( ! c ) {
                    break;
                }
            }
            nbWhile++;
            try {
                iast.getBody().accept(this, lexenv);

            } catch (BreakException e){
                String message = e.getMessage();
                //message = label de ce while ou label non spécifié, break dans le while courant
                if(message.equals(iast.getLabel()) || message.equals("break")){
                    labels.remove(labels.lastIndexOf(iast.getLabel()));
                    nbWhile--;
                    break;
                }
                //message = un label inconnu, break dans un while extérieur ou inexistant
                int index = labels.lastIndexOf(message);
                if (index == -1) throw new EvaluationException("The label is not defined");
                labels.remove(labels.lastIndexOf(iast.getLabel()));
                nbWhile--;
                throw new BreakException(message);

            } catch (ContinueException e){
                String message = e.getMessage();
                //message = label de ce while ou label non spécifié, continue dans le while courant
                if(message.equals(iast.getLabel()) || message.equals("continue")){
                    //labels.remove(labels.lastIndexOf(iast.getLabel()));
                    nbWhile--;
                    continue;
                }
                //message = un label inconnu, continue dans un while extérieur ou inexistant
                int index = labels.lastIndexOf(message);
                if (index == -1) throw new EvaluationException("The label is not defined");
                labels.remove(labels.lastIndexOf(iast.getLabel()));
                nbWhile--;
                throw new ContinueException(message);
            }
            nbWhile--;
        }
        return Boolean.FALSE;
    }

    @Override
    public Object visit(IASTbreak iast, ILexicalEnvironment iLexicalEnvironment) throws EvaluationException {
        if (nbWhile < 1){
            throw new EvaluationException("The keyword break is not in a loop");
        }else{
            if (iast.getLabel().isBlank()){
                throw new BreakException("break");
            }else {
                throw new BreakException(iast.getLabel());
            }
        }


    }

    @Override
    public Object visit(IASTcontinue iast, ILexicalEnvironment iLexicalEnvironment) throws EvaluationException {
        if (nbWhile < 1){
            throw new EvaluationException("The keyword continue is not in a loop");
        }
        if (iast.getLabel().isBlank()){
            throw new ContinueException("continue");
        }else {
            throw new ContinueException(iast.getLabel());
        }
    }
}
