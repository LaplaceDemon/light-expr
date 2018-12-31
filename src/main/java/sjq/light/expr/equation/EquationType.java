package sjq.light.expr.equation;

public enum EquationType {
	Assign("="),Eq("=="),Nq("!="),Gt(">"),Ge(">="), Lt("<"), Le("<="),Not("!");
	
	private String name;
	
	EquationType(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}