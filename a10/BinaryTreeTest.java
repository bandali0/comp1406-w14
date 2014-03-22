public class BinaryTreeTest {
	public static void main(String[] args) {
		BinaryTree[] trees = new BinaryTree[8];

		trees[0] = new BinaryTree("A");
		trees[1] = new BinaryTree("A", new BinaryTree("B"), new BinaryTree("C"));
		trees[2] = new BinaryTree("A",
				new BinaryTree("B", new BinaryTree("C"), null), new BinaryTree("D"));
		trees[3] = new BinaryTree("A", null, new BinaryTree("C", new BinaryTree("D"),
							new BinaryTree("E",
								new BinaryTree("F", new BinaryTree("G"), null),
								new BinaryTree("H"))));
		trees[4] = new BinaryTree("A",
					new BinaryTree("B",
						new BinaryTree("C",
							new BinaryTree("D"),
							new BinaryTree("E",
								new BinaryTree("F",
									new BinaryTree("G"),
								  	new BinaryTree("I")),
								new BinaryTree("H"))),
						new BinaryTree("J",
							new BinaryTree("K",
								null,
								new BinaryTree("L",
									null,
									new BinaryTree("M"))),
							new BinaryTree("N",
								null,
								new BinaryTree("O")))),
					new BinaryTree("P",
						new BinaryTree("Q"),
						new BinaryTree("R",
							new BinaryTree("S",
								new BinaryTree("T"),
								null),
							new BinaryTree("U"))));
		trees[5] = new BinaryTree("A", null, new BinaryTree("P", null,
						new BinaryTree("R", null, new BinaryTree("U"))));
		trees[6] = new BinaryTree("A", null, new BinaryTree("P", null,
						new BinaryTree("R", new BinaryTree("W"), new BinaryTree("U"))));
		trees[7] = new BinaryTree("A",
					new BinaryTree("B",
						new BinaryTree("C",
							null,
							new BinaryTree("E",
								new BinaryTree("F",
									new BinaryTree("G"),
								  	new BinaryTree("I")),
								new BinaryTree("H"))),
						new BinaryTree("J",
							new BinaryTree("K",
								null,
								new BinaryTree("L",
									null,
									new BinaryTree("M"))),
							new BinaryTree("N",
								null,
								new BinaryTree("O")))),
					null);

		for (int i=0; i<8; i++)
			for (int j=0; j<8; j++)
				System.out.println("Tree["+i+"] == trees["+j+"]: " + trees[i].hasSameStructureAs(trees[j]));


	}
}
