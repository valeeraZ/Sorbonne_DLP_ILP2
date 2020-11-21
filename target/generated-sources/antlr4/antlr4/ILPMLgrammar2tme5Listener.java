// Generated from ILPMLgrammar2tme5.g4 by ANTLR 4.4

    package antlr4;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ILPMLgrammar2tme5Parser}.
 */
public interface ILPMLgrammar2tme5Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ILPMLgrammar2tme5Parser#globalFunDef}.
	 * @param ctx the parse tree
	 */
	void enterGlobalFunDef(@NotNull ILPMLgrammar2tme5Parser.GlobalFunDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILPMLgrammar2tme5Parser#globalFunDef}.
	 * @param ctx the parse tree
	 */
	void exitGlobalFunDef(@NotNull ILPMLgrammar2tme5Parser.GlobalFunDefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Binding}
	 * labeled alternative in {@link ILPMLgrammar2tme5Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinding(@NotNull ILPMLgrammar2tme5Parser.BindingContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Binding}
	 * labeled alternative in {@link ILPMLgrammar2tme5Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinding(@NotNull ILPMLgrammar2tme5Parser.BindingContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Loop}
	 * labeled alternative in {@link ILPMLgrammar2tme5Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLoop(@NotNull ILPMLgrammar2tme5Parser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Loop}
	 * labeled alternative in {@link ILPMLgrammar2tme5Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLoop(@NotNull ILPMLgrammar2tme5Parser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link ILPMLgrammar2tme5Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVariable(@NotNull ILPMLgrammar2tme5Parser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link ILPMLgrammar2tme5Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVariable(@NotNull ILPMLgrammar2tme5Parser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Alternative}
	 * labeled alternative in {@link ILPMLgrammar2tme5Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAlternative(@NotNull ILPMLgrammar2tme5Parser.AlternativeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Alternative}
	 * labeled alternative in {@link ILPMLgrammar2tme5Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAlternative(@NotNull ILPMLgrammar2tme5Parser.AlternativeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Invocation}
	 * labeled alternative in {@link ILPMLgrammar2tme5Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInvocation(@NotNull ILPMLgrammar2tme5Parser.InvocationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Invocation}
	 * labeled alternative in {@link ILPMLgrammar2tme5Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInvocation(@NotNull ILPMLgrammar2tme5Parser.InvocationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstFloat}
	 * labeled alternative in {@link ILPMLgrammar2tme5Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstFloat(@NotNull ILPMLgrammar2tme5Parser.ConstFloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstFloat}
	 * labeled alternative in {@link ILPMLgrammar2tme5Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstFloat(@NotNull ILPMLgrammar2tme5Parser.ConstFloatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Break}
	 * labeled alternative in {@link ILPMLgrammar2tme5Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBreak(@NotNull ILPMLgrammar2tme5Parser.BreakContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Break}
	 * labeled alternative in {@link ILPMLgrammar2tme5Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBreak(@NotNull ILPMLgrammar2tme5Parser.BreakContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VariableAssign}
	 * labeled alternative in {@link ILPMLgrammar2tme5Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVariableAssign(@NotNull ILPMLgrammar2tme5Parser.VariableAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariableAssign}
	 * labeled alternative in {@link ILPMLgrammar2tme5Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVariableAssign(@NotNull ILPMLgrammar2tme5Parser.VariableAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Sequence}
	 * labeled alternative in {@link ILPMLgrammar2tme5Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSequence(@NotNull ILPMLgrammar2tme5Parser.SequenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Sequence}
	 * labeled alternative in {@link ILPMLgrammar2tme5Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSequence(@NotNull ILPMLgrammar2tme5Parser.SequenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstFalse}
	 * labeled alternative in {@link ILPMLgrammar2tme5Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstFalse(@NotNull ILPMLgrammar2tme5Parser.ConstFalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstFalse}
	 * labeled alternative in {@link ILPMLgrammar2tme5Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstFalse(@NotNull ILPMLgrammar2tme5Parser.ConstFalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Continue}
	 * labeled alternative in {@link ILPMLgrammar2tme5Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterContinue(@NotNull ILPMLgrammar2tme5Parser.ContinueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Continue}
	 * labeled alternative in {@link ILPMLgrammar2tme5Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitContinue(@NotNull ILPMLgrammar2tme5Parser.ContinueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILPMLgrammar2tme5Parser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(@NotNull ILPMLgrammar2tme5Parser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILPMLgrammar2tme5Parser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(@NotNull ILPMLgrammar2tme5Parser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Unary}
	 * labeled alternative in {@link ILPMLgrammar2tme5Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnary(@NotNull ILPMLgrammar2tme5Parser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Unary}
	 * labeled alternative in {@link ILPMLgrammar2tme5Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnary(@NotNull ILPMLgrammar2tme5Parser.UnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstTrue}
	 * labeled alternative in {@link ILPMLgrammar2tme5Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstTrue(@NotNull ILPMLgrammar2tme5Parser.ConstTrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstTrue}
	 * labeled alternative in {@link ILPMLgrammar2tme5Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstTrue(@NotNull ILPMLgrammar2tme5Parser.ConstTrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstInteger}
	 * labeled alternative in {@link ILPMLgrammar2tme5Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstInteger(@NotNull ILPMLgrammar2tme5Parser.ConstIntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstInteger}
	 * labeled alternative in {@link ILPMLgrammar2tme5Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstInteger(@NotNull ILPMLgrammar2tme5Parser.ConstIntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstString}
	 * labeled alternative in {@link ILPMLgrammar2tme5Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstString(@NotNull ILPMLgrammar2tme5Parser.ConstStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstString}
	 * labeled alternative in {@link ILPMLgrammar2tme5Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstString(@NotNull ILPMLgrammar2tme5Parser.ConstStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Binary}
	 * labeled alternative in {@link ILPMLgrammar2tme5Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinary(@NotNull ILPMLgrammar2tme5Parser.BinaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Binary}
	 * labeled alternative in {@link ILPMLgrammar2tme5Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinary(@NotNull ILPMLgrammar2tme5Parser.BinaryContext ctx);
}