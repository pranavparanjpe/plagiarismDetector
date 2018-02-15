package ASTSearchVisitorTests;

import static org.junit.Assert.*;

import org.junit.Test;

import ASTSearch3C.*;


public class ASTSearchVisitorTests {

	@Test
	public void test1(){
		Factory f = new Factory();
		Variable v = f.makeVariable("x");
		NumberExpression exp = f.makeNumberExpression(10);
		NumberExpression exp2 = f.makeNumberExpression(7);
		Operator o= f.makeOperator("+");
		VariableExpression v1 = f.makeVariableExpression(o, v, exp);
		Declaration d = f.makeDeclaration(v);
		Assignment a = f.makeAssignment(v, exp2);
		
		Sequence s = f.makeSequence(d, a);
		
		ASTSearchVisitor avs = new ASTSearchVisitor();
		
		NodeSet ns = new NodeSet();
		ns.add(s);
		
		NodeSet ans = avs.search(ns, v);
		
		Iterator<Node>it = ans.iterator();
		assertEquals(it.hasAnotherElement(),true);
		assertEquals(it.nextElement().textualRepresentation(),a.textualRepresentation());
		assertEquals(it.hasAnotherElement(),true);
		assertEquals(it.nextElement().textualRepresentation(),d.textualRepresentation());
		assertEquals(it.hasAnotherElement(),false);
		
		
	}
	@Test
	public void test2(){
		Factory f = new Factory();
		Variable v = f.makeVariable("z");
		NumberExpression exp = f.makeNumberExpression(19);
		NumberExpression exp2 = f.makeNumberExpression(34);
		Operator o= f.makeOperator("/");
		VariableExpression v1 = f.makeVariableExpression(o, v, exp);
		Declaration d = f.makeDeclaration(v);
		Assignment a = f.makeAssignment(v, exp2);
		
		Sequence s = f.makeSequence(d, a);
		
		ASTSearchVisitor avs = new ASTSearchVisitor();
		
		NodeSet ns = new NodeSet();
		ns.add(s);
		
		NodeSet ans = avs.search(ns, v);
		
		Iterator<Node>it = ans.iterator();
		assertEquals(it.hasAnotherElement(),true);
		assertEquals(it.nextElement().textualRepresentation(),a.textualRepresentation());
		assertEquals(it.hasAnotherElement(),true);
		assertEquals(it.nextElement().textualRepresentation(),d.textualRepresentation());
		assertEquals(it.hasAnotherElement(),false);
		
		
	}
	@Test
	public void test3(){
		Factory f = new Factory();
		Variable v = f.makeVariable("x");
		NumberExpression exp = f.makeNumberExpression(10);
		NumberExpression exp2 = f.makeNumberExpression(7);
		 
		Operator o= f.makeOperator("+");
		InfixExpression inf = f.makeInfixExpression(o, exp,exp2);
		VariableExpression v1 = f.makeVariableExpression(o, v, exp);
		Declaration d = f.makeDeclaration(v);
		Assignment a = f.makeAssignment(v, inf);
		
		Sequence s = f.makeSequence(d, a);
		
		ASTSearchVisitor avs = new ASTSearchVisitor();
		
		NodeSet ns = new NodeSet();
		ns.add(s);
		
		NodeSet ans = avs.search(ns, v);
		
		Iterator<Node>it = ans.iterator();
		assertEquals(it.hasAnotherElement(),true);
		
		assertEquals(it.nextElement().textualRepresentation(),"x = 10+7");
		assertEquals(it.hasAnotherElement(),true);
		assertEquals(it.nextElement().textualRepresentation(),"var x;");
		assertEquals(it.hasAnotherElement(),false);
		
		
	}
}
