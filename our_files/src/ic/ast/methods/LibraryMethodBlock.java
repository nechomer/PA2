package ic.ast.methods;

import ic.ast.ASTNode;
import ic.ast.Formal;
import ic.ast.Visitor;
import ic.ast.stmt.Statement;
import ic.ast.types.Type;

import java.util.ArrayList;
import java.util.List;

public class LibraryMethodBlock extends ASTNode {

	private List<Method> methods = new ArrayList<Method>();
	
	public LibraryMethodBlock(int line, Method startingMethod) {
		super(line);
		methods.add(startingMethod);
		// TODO Auto-generated constructor stub
	}
	
	public void addMethod(Method method){
		methods.add(method);
	}

	@Override
	public Object accept(Visitor visitor) {
		// TODO Auto-generated method stub
		return null;
	}

}
