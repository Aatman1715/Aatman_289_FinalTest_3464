import java.util.ArrayList;
import java.util.List;
class Move {
	//class Move coded by Aatman Rajyaguru
	private List<Box> boxes;
	public Move(int numberOfBoxes)
	{
		boxes = new ArrayList<> (numberOfBoxes);
	}
	public void addBox(Box box)
	{
		boxes.add(box);
	}
	public void print()
	{
		for (Box box : boxes)
		{
			box.print("");
		}
	}
	public int find(String item)
	{
		for (Box box : boxes)
		{
			int found = box.find(item);
			if(found != -1)
			{
				return found;
			}
		}
		return -1;
	}
	//Finished code of class Move by Aatman Rajyaguru
	public static void main(String[] args) {
		// We create a move that will hold 2 main boxes
		Move move = new Move(2);

		/*
		 * We create and then fill 3 boxes
		 * Arguments of the constructor of Box:
		 * argument 1: number of items (simple items/objects or box) that the box can hold
		 * argument 2: box number
		 */

		// box 1 contains scissors
		Box box1 = new Box(1, 1);
		box1.addItem(new SingleObject("scissors"));

		// box 2 contains one book
		Box box2 = new Box(1, 2);
		box2.addItem(new SingleObject("book"));

		// box 3 contains one compass
		// and one box containing one scarf
		Box box3 = new Box(2, 3);
		box3.addItem(new SingleObject("compass"));
		Box box4 = new Box(1, 4);
		box4.addItem(new SingleObject("scarf"));
		box3.addItem(box4);

		// We add the three boxes to the first box of move - see below
		Box box5 = new Box(3, 5);
		box5.addItem(box1);
		box5.addItem(box2);
		box5.addItem(box3);

		// We add one box containing 3 objects to move
		Box box6 = new Box(3, 6);
		box6.addItem(new SingleObject("pencils"));
		box6.addItem(new SingleObject("pens"));
		box6.addItem(new SingleObject("rubber"));

		// We add the two most external boxes to the move
		move.addBox(box5);
		move.addBox(box6);

		// We print all the contents of the move
		move.print();

		// We print the number of the outermost cardboard containing the item "scarf"
		System.out.println("The scarf is in the cardboard number " + move.find("scarf"));
	}
}
//class Box coded by Aatman Rajyaguru
class Box {
	private List<Object> items;
	private int capacity;
	private int boxNumber;

	public Box(int capacity, int boxNumber) {
		this.capacity = capacity;
		this.boxNumber = boxNumber;
		items = new ArrayList<>(capacity);
	}

	public void addItem(Object item) {
		if (items.size() < capacity) {
			items.add(item);
		}
	}

	public void print(String indent) {
		System.out.println(indent + "Box " + boxNumber);
		for (Object item : items) {
			if (item instanceof Box) {
				((Box) item).print(indent + "  ");
			} else {
				System.out.println(indent + "  " + item);
			}
		}
	}

	public int find(String item) {
		for (Object obj : items) {
			if (obj instanceof Box) {
				int found = ((Box) obj).find(item);
				if (found != -1) {
					return found;
				}
			} else if (obj instanceof SingleObject && ((SingleObject) obj).getName().equals(item)) {
				return this.boxNumber;
			}
		}
		return -1;
	}
}
//Finished the code of class Box by Aatman Rajyaguru

//class SingleObject coded by Aatman Rajyaguru
class SingleObject {
	private String name;

	public SingleObject(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}
}
//Finished the code of class SingleObject by Aatman Rajyaguru