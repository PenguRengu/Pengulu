# Get started
## Step 1
<a href="https://github.com/PenguRengu/Pengulu/releases/tag/1.0">Download</a> the .jar and it to your project
## Step 2 - Create a the Main Class
#### TestRun.java
```java
import com.pengu.pengulu.*;

public class TestRun extends Game {
	
	public static void main(String[] args) {
		new TestRun().go();
	}
	
	void go() {
		start();
	}
	
}
```
## Step 3 - Make Nodes
Nodes are at the heart of Pengulu. Each node has connections to other nodes and choices to do things within the node.<br>
The superconstructor takes three arguments: `connections`, ids of other nodes, `choices`, and the `id` of the node itself.<br>
Make four new files: `Plains.java`, `Forest.java`, `Mountains.java`, and `Cave.java`.
#### Plains.java
```java
import com.pengu.pengulu.Node;

public class Plains extends Node {

	public Plains() {
		super(new String[] {"forest", "mountains"}, new String[] {"forest", "mountains"}, "plains");
	}

}

```
#### Forest.java
```java
import com.pengu.pengulu.Node;

public class Forest extends Node {
	
	public Forest() {
		super(new String[] {"plains", "cave"}, new String[] {"plains", "cave"}, "forest");
	}
}

```
#### Mountains.java
```java
import com.pengu.pengulu.Node;

public class Mountains extends Node {

	public Mountains() {
		super(new String[] {"plains"}, new String[] {"plains"}, "mountains");
	}

}
```
#### Cave.java
```java
import com.pengu.pengulu.*;

public class Cave extends Node {
	
	public Cave() {
		super(new String[] {"forest"}, new String[] {"forest"}, "cave");
	}
	
}

```
## Step 4 - Add Nodes to the Game
First, make sure all the nodes know the game they are a part of.<br>
Add this to the `go` method in `TestRun.java`:
```java
Node.setGame(this);
```
Then we add all our nodes:
```java
addNode(new Forest());
addNode(new Plains());
addNode(new Cave());
addNode(new Mountains());
```
Finally we set the starting node:
```java
setCurrentNode(Game.getNodeById("forest"));
```
`TestRun.java` should now look like this:
```java
import com.pengu.pengulu.*;

public class TestRun extends Game {
	
	public static void main(String[] args) {
		new TestRun().go();
	}
	
	void go() {
		Node.setGame(this);
		addNode(new Forest());
		addNode(new Plains());
		addNode(new Cave());
		addNode(new Mountains());
		
		setCurrentNode(Game.getNodeById("forest"));
		start();
	}

}

```
## Step 5 - Make Items
The `ItemTemplate` superconstructor takes two arguments: `count`, how much of the item there is, and `id`.<br>
Create three new files: `Log.java`, `Coal.java`, and `Cobblestone.java`.
#### Log.java
```java
import com.pengu.pengulu.ItemTemplate;

public class Log extends ItemTemplate {

	public Log(int count) {
		super(count, "log");
	}

}
```
#### Coal.java
```java
import com.pengu.pengulu.*;

public class Coal extends ItemTemplate {
	
	public Coal(int count) {
		super(count, "coal");
	}
	
}
```
#### Cobblestone.java
```java
import com.pengu.pengulu.*;

public class Cobblestone extends ItemTemplate {
	
	public Cobblestone(int count) {
		super(count, "cobblestone");
	}
	
}
```
## Step 6 - Add Items to the Inventory
Add this to the `go` methoc in `TestRun.java`:
```java
InventoryManager.addItem(new Log(0));
InventoryManager.addItem(new Cobblestone(0));
InventoryManager.addItem(new Coal(0));
```
`TestRun.java` should now look like this:
```java
import com.pengu.pengulu.*;

public class TestRun extends Game {
	
	public static void main(String[] args) {
		new TestRun().go();
	}
	
	void go() {
		Node.setGame(this);
		addNode(new Forest());
		addNode(new Plains());
		addNode(new Cave());
		addNode(new Mountains());
		
		InventoryManager.addItem(new Log(0));
		InventoryManager.addItem(new Cobblestone(0));
		InventoryManager.addItem(new Coal(0));
		
		setCurrentNode(Game.getNodeById("forest"));
		start();
	}

}
```
## Step 7 - Mining Logs
Add an additional choice in the constructor of `Forest.java`:
```java
public Forest() {
	super(new String[] {"plains", "cave", "mine trees"}, new String[] {"plains", "cave"}, "forest");
}
```
Modify `Forest.java` so it implements `InputListener`:
```java
public class Forest extends Node implements InputListener {
```
Add a `respond` method so it responds to the `"mine trees"` choice:
```java
@Override
public void respond(String choice) {
	int choiceIndex = getChoiceIndex(choice);
	if (choiceIndex == 2) {
		Game.displayln("how many?");
		requestInput();
	} else {
		runNode(choiceIndex);
	}
}
```
