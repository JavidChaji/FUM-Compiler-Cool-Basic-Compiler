package compiler;

import gen.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.Trees;

public class ProgramPrinter implements CoolListener {
    public Tree tree;
    @Override
    public void enterProgram(CoolParser.ProgramContext ctx) {
        System.out.println("program start{");
        tree = new Tree("object");
    }

    @Override
    public void exitProgram(CoolParser.ProgramContext ctx) {
        System.out.println("}");
        System.out.println(tree.toString());
    }

    @Override
    public void enterClasses(CoolParser.ClassesContext ctx) {

    }

    @Override
    public void exitClasses(CoolParser.ClassesContext ctx) {

    }

    @Override
    public void enterEof(CoolParser.EofContext ctx) {

    }

    @Override
    public void exitEof(CoolParser.EofContext ctx) {

    }

    @Override
    public void enterClassDefine(CoolParser.ClassDefineContext ctx) {
        if(ctx.parentClass != null) {
            System.out.println("\tclass: " + ctx.className.getText() + "/ class parents: " + ctx.parentClass.getText() + ", " + "{");
            tree.addLeaf(ctx.parentClass.getText(), ctx.className.getText());
        }else {
            System.out.println("\tclass: " + ctx.className.getText() + "/ class parents: " + "object, " + "{");
            tree.addLeaf("object", ctx.className.getText());
        }
    }

    @Override
    public void exitClassDefine(CoolParser.ClassDefineContext ctx) {
        System.out.println("\t}");
    }

    @Override
    public void enterMethod(CoolParser.MethodContext ctx) {
        System.out.println("\t\tclass method: " + ctx.methodName.getText() + "/ return type=" + ctx.returnType.getText() + "{");
    }

    @Override
    public void exitMethod(CoolParser.MethodContext ctx) {
        System.out.println("\t\t}");
    }

    @Override
    public void enterProperty(CoolParser.PropertyContext ctx) {
        System.out.println("\t\tfield: " + ctx.propertyName.getText() + "/ type=" + ctx.propertyType.getText());
    }

    @Override
    public void exitProperty(CoolParser.PropertyContext ctx) {

    }

    @Override
    public void enterAtribute(CoolParser.AtributeContext ctx) {
        if(!ctx.formal().isEmpty()) {
            System.out.print("\t\t\tparameters list= [");
        }
    }

    @Override
    public void exitAtribute(CoolParser.AtributeContext ctx) {
        if(!ctx.formal().isEmpty()) {
            System.out.println("]");
        }
    }

    @Override
    public void enterFormal(CoolParser.FormalContext ctx) {
        if(ctx.formalName != null && ctx.formalType != null) {
            System.out.print(ctx.formalType.getText() + " " + ctx.formalName.getText() + ", ");
        }
    }

    @Override
    public void exitFormal(CoolParser.FormalContext ctx) {

    }

    @Override
    public void enterLetIn(CoolParser.LetInContext ctx) {
        System.out.println("\t\t\tfield: " + ctx.letName.getText() + "/ type=" + ctx.letType.getText());
    }

    @Override
    public void exitLetIn(CoolParser.LetInContext ctx) {

    }

    @Override
    public void enterMinus(CoolParser.MinusContext ctx) {

    }

    @Override
    public void exitMinus(CoolParser.MinusContext ctx) {

    }

    @Override
    public void enterString(CoolParser.StringContext ctx) {

    }

    @Override
    public void exitString(CoolParser.StringContext ctx) {

    }

    @Override
    public void enterIsvoid(CoolParser.IsvoidContext ctx) {

    }

    @Override
    public void exitIsvoid(CoolParser.IsvoidContext ctx) {

    }

    @Override
    public void enterWhile(CoolParser.WhileContext ctx) {
        int counter = 0;
        for(int i=0; i<ctx.expression().size(); i++){
            if(ctx.expression(1).getText().contains("if")||ctx.expression(1).getText().contains("while")){
                counter++;
            }

        }

        if(counter>1){
            System.out.println("\t"+"\t"+"\t"+"nested statement{\n\t\t\t}");
        } else {
//            System.out.println("\t"+"\t"+"\t"+ctx.WHILE()+" "+ctx.expression(0).getText()+" loop {");
//            System.out.println("\t"+"\t"+"\t"+"\t"+ctx.expression(1).getText());
//            System.out.println("\t"+"\t"+"\t}");
        }
    }

    @Override
    public void exitWhile(CoolParser.WhileContext ctx) {

    }

    @Override
    public void enterDivision(CoolParser.DivisionContext ctx) {

    }

    @Override
    public void exitDivision(CoolParser.DivisionContext ctx) {

    }

    @Override
    public void enterNegative(CoolParser.NegativeContext ctx) {

    }

    @Override
    public void exitNegative(CoolParser.NegativeContext ctx) {

    }

    @Override
    public void enterBoolNot(CoolParser.BoolNotContext ctx) {

    }

    @Override
    public void exitBoolNot(CoolParser.BoolNotContext ctx) {

    }

    @Override
    public void enterLessThan(CoolParser.LessThanContext ctx) {

    }

    @Override
    public void exitLessThan(CoolParser.LessThanContext ctx) {

    }

    @Override
    public void enterBlock(CoolParser.BlockContext ctx) {

    }

    @Override
    public void exitBlock(CoolParser.BlockContext ctx) {

    }

    @Override
    public void enterId(CoolParser.IdContext ctx) {

    }

    @Override
    public void exitId(CoolParser.IdContext ctx) {

    }

    @Override
    public void enterMultiply(CoolParser.MultiplyContext ctx) {

    }

    @Override
    public void exitMultiply(CoolParser.MultiplyContext ctx) {

    }

    @Override
    public void enterIf(CoolParser.IfContext ctx) {
        int counter = 0;
        for(int i=0; i<ctx.expression().size(); i++){
//            System.out.println(ctx.expression().get(i).getText());
            if(ctx.expression(1).getText().contains("if")||ctx.expression(1).getText().contains("while")){
                counter++;
            }

        }

        if(counter>1){
            System.out.println("\t"+"\t"+"\t"+"nested statement{\n\t\t\t}");
        } else {
//            System.out.println("\t"+"\t"+"\t"+ctx.IF()+" "+ctx.expression(0).getText()+" then");
//            System.out.println("\t"+"\t"+"\t"+"\t"+ctx.expression(1).getText());
//            System.out.println("\t"+"\t"+"\t"+ctx.ELSE());
//            System.out.println("\t"+"\t"+"\t"+"\t"+ctx.expression(2).getText());
//            System.out.println("\t"+"\t"+"\t"+ctx.FI());
        }
    }

    @Override
    public void exitIf(CoolParser.IfContext ctx) {

    }

    @Override
    public void enterCase(CoolParser.CaseContext ctx) {

    }

    @Override
    public void exitCase(CoolParser.CaseContext ctx) {

    }

    @Override
    public void enterOwnMethodCall(CoolParser.OwnMethodCallContext ctx) {

    }

    @Override
    public void exitOwnMethodCall(CoolParser.OwnMethodCallContext ctx) {

    }

    @Override
    public void enterAdd(CoolParser.AddContext ctx) {

    }

    @Override
    public void exitAdd(CoolParser.AddContext ctx) {

    }

    @Override
    public void enterNew(CoolParser.NewContext ctx) {

    }

    @Override
    public void exitNew(CoolParser.NewContext ctx) {

    }

    @Override
    public void enterParentheses(CoolParser.ParenthesesContext ctx) {

    }

    @Override
    public void exitParentheses(CoolParser.ParenthesesContext ctx) {

    }

    @Override
    public void enterAssignment(CoolParser.AssignmentContext ctx) {

    }

    @Override
    public void exitAssignment(CoolParser.AssignmentContext ctx) {

    }

    @Override
    public void enterFalse(CoolParser.FalseContext ctx) {

    }

    @Override
    public void exitFalse(CoolParser.FalseContext ctx) {

    }

    @Override
    public void enterInt(CoolParser.IntContext ctx) {

    }

    @Override
    public void exitInt(CoolParser.IntContext ctx) {

    }

    @Override
    public void enterEqual(CoolParser.EqualContext ctx) {

    }

    @Override
    public void exitEqual(CoolParser.EqualContext ctx) {

    }

    @Override
    public void enterTrue(CoolParser.TrueContext ctx) {

    }

    @Override
    public void exitTrue(CoolParser.TrueContext ctx) {

    }

    @Override
    public void enterLessEqual(CoolParser.LessEqualContext ctx) {

    }

    @Override
    public void exitLessEqual(CoolParser.LessEqualContext ctx) {

    }

    @Override
    public void enterMethodCall(CoolParser.MethodCallContext ctx) {

    }

    @Override
    public void exitMethodCall(CoolParser.MethodCallContext ctx) {

    }

    @Override
    public void visitTerminal(TerminalNode terminalNode) {

    }

    @Override
    public void visitErrorNode(ErrorNode errorNode) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext parserRuleContext) {

    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }
}
