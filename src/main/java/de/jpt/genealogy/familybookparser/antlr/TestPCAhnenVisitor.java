package de.jpt.genealogy.familybookparser.antlr;

public class TestPCAhnenVisitor<T> extends PCAhnenBaseVisitor<T> {

	@Override
	public T visitRecord(PCAhnenParser.RecordContext ctx) {
		System.out.println("Visitor.visitRecord");
		return visitChildren(ctx);
	}

	/*
	@Override
	public T visitBirth(PCAhnenParser.BirthContext ctx) {
		System.out.println("Visitor.visitBirth");
		return visitChildren(ctx);
	}

	@Override
	public T visitDeath(PCAhnenParser.DeathContext ctx) {
		System.out.println("Visitor.visitDeath");
		return visitChildren(ctx);
	}

	@Override
	public T visitSource(PCAhnenParser.SourceContext ctx) {
		System.out.println("Visitor.visitSource");
		return visitChildren(ctx);
	}
	*/

}

