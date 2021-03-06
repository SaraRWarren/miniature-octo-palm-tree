import java.util.*;

class Program { 

  String name;
  Statement state;

  public Program () { }

  public Program (String name, Statement state) {
    this . name = name;
    this . state = state;
  }

  public String toString () {
    String print = "\n\n";
    print = print + "Abstract Syntax Tree for " + name + "\n";
    print = print + "-------------------------";
    for (int i = 0; i < name . length (); i++) 
      print = print + "-";
    print = print + "\n\n";
    print = print + state;
    return print;
  }
  
}

class Statement {

   protected Statement state1, state2;

   public Statement () { }

   public Statement (Statement state) {
     this . state1 = state;
     this . state2 = null;
   }

   public Statement (Statement state1, Statement state2) {
     this . state1 = state1;
     this . state2 = state2;
   }

   public String toString () {
     if (state2 == null)
       return "(" + state1 + ")";
     else
       return "(: " + state1 + " " + state2 + ")";
   }

}

class Assignment extends Statement {

   protected Variable lhs;
   protected Expression rhs;

   public Assignment () { }

   public Assignment (Variable lhs, Expression rhs) {
     this . lhs = lhs;
     this . rhs = rhs;
   }

   public String toString () {
     return "(= " + lhs + " " + rhs + ")";
   }

}

class Conditional extends Statement {

  protected Expression test;
  protected Statement elseStmt, thenStmt;

  public Conditional () { }

  public Conditional (Expression test, Statement thenStmt, Statement elseStmt) {
    this . test = test;
    this . thenStmt = thenStmt;
    this . elseStmt = elseStmt;
  }

  public String toString () {
    if (elseStmt == null)
      return "(if " + test + " " + thenStmt + ")";
    else
      return "(if " + test + " " + thenStmt + " " + elseStmt + ")";
   }

}

class Loop extends Statement {

  protected Expression test;
  protected Statement body;

  public Loop () { }

  public Loop (Expression test, Statement body) {
    this . test = test;
    this . body = body;
  }

  public String toString () {
     return "(while " + test + " " + body + ")";
   }

}

class Print extends Statement {

  protected Expression exp;

  public Print () { }

  public Print (Expression exp) {
    this . exp = exp;
  }

  public String toString () {
    return "(println " + exp + ")";
  }

}

class Return extends Statement {

  protected Expression exp;

  public Return () { }

  public Return (Expression exp) {
    this . exp = exp;
  }

  public String toString () {
    return "(return " + exp + ")";
  }

}

abstract class Expression { }

class Binary extends Expression {

  protected String op;
  protected Expression term1, term2;

  public Binary () { }

  public Binary (String op, Expression term1, Expression term2) {
    this . op = op;
    this . term1 = term1;
    this . term2 = term2;
  }

  public String toString () {
    return "(" + op + " " + term1 + " " + term2 + ")";
  }

}

class Unary extends Expression {

  protected String op;
  protected Expression term;

  public Unary () { }

  public Unary (String op, Expression term) {
    this . op = op;
    this . term = term;
  }

  public String toString () {
    return "(" + op + " " + term + ")";
  }

}

class Variable extends Expression {

  protected String id;

  public Variable () { }

  public Variable (String id) {
    this . id = id;
  }

  public String toString () {
    return "(id " + id + ")";
  }

}

class FunctionCall extends Expression {

  protected String id;
  protected ArrayList<Expression> actualParameter;

  public FunctionCall () { }

  public FunctionCall (String id, ArrayList<Expression> actualParameter) {
    this . id = id;
    this . actualParameter = actualParameter;
  }

  public String toString () {
    return "(apply " + id + " " + actualParameter + ")";
  }

}

abstract class Value extends Expression { }

class IntValue extends Value {

  protected int intValue;

  public IntValue () { }

  public IntValue (int intValue) {
    this . intValue = intValue;
  }

  public IntValue (String intValue) {
    this . intValue = Integer . parseInt (intValue);
  }

  public String toString () {
    return "(intValue " + intValue + ")";
  }

}

class NilValue extends Value {

  public NilValue () { }

  public String toString () {
    return "Nil";
  }

}

