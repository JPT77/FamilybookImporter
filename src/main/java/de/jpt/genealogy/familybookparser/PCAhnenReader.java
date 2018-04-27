package de.jpt.genealogy.familybookparser;

import java.nio.charset.Charset;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import de.jpt.genealogy.familybookparser.antlr.PCAhnenLexer;
import de.jpt.genealogy.familybookparser.antlr.PCAhnenListener;
import de.jpt.genealogy.familybookparser.antlr.PCAhnenParser;
import de.jpt.genealogy.familybookparser.antlr.TestPCAhnenListener;

public class PCAhnenReader {

	public static void main(String[] args) throws Exception {
		CharStream input = CharStreams.fromFileName("testdata/test.txt", Charset.forName("UTF-8"));
		PCAhnenLexer lexer = new PCAhnenLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		PCAhnenParser parser = new PCAhnenParser(tokens);		
		parser.setBuildParseTree(true);
		
		RuleContext tree = parser.record();
		System.out.println(tree.toStringTree(parser));
		System.out.println("----");
		PCAhnenListener listener = new TestPCAhnenListener();
		ParseTreeWalker.DEFAULT.walk(listener, tree);

//		PCAhnenParser.RecordContext expressionContext = parser.record();
//		TestPCAhnenVisitor visitor = new TestPCAhnenVisitor();
//		System.out.println(visitor.visit(expressionContext));

	}

}

