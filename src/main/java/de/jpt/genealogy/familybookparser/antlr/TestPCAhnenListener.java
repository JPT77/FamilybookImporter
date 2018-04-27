package de.jpt.genealogy.familybookparser.antlr;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import de.jpt.genealogy.familybookparser.antlr.PCAhnenParser.RecordContext;

public class TestPCAhnenListener extends PCAhnenBaseListener{

	@Override
	public void enterRecord(RecordContext ctx) {
		System.out.println("Listener.enterRecord: '"+ctx+"'");
	}

	@Override
	public void exitRecord(RecordContext ctx) {
		System.out.println("Listener.exitRecord: '"+ctx+"'");
	}

	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
		System.out.println("Listener.enterEveryRule: '"+ctx+"'");
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		System.out.println("Listener.exitEveryRule: '"+ctx+"'");
	}

	@Override
	public void visitTerminal(TerminalNode node) {
		System.out.println("Listener.visitTerminal: '"+node+"'");
	}

	@Override
	public void visitErrorNode(ErrorNode node) {
		System.out.println("Listener.visitErrorNode: '"+node+"'");
	}

}

