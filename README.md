# Get started
## Step 1
Download the .jar and it to your project
## Step 2 - Create a the main class
#### TestRun.java
```
import com.pengu.pengulu.*;

public class TestRun extends Game {
	
	public static void main(String[] args) {
		new TestRun().go();
	}
	
	void go() {
		
	}
	
}
```
## Step 3 - Make nodes
Nodes are at the heart of Pengulu. Each node has connections to other nodes and choices to do things within the node.<br>
The superconstructor takes three arguments: `connections`, `choices`, and `id`.<br>
Make three files: `Plains.java`, `Forest.java`, `Mountains.java`, and `Cave.java`.
#### Plains.java
```
import com.pengu.pengulu.Node;

public class Plains extends Node {

	public Plains() {
		super(new String[] {"forest", "mountains"}, new String[] {"forest", "mountains"}, "plains");
	}

}

```
#### Forest.java
```
import com.pengu.pengulu.Node;

public class Forest extends Node {
	
	public Forest() {
		super(new String[] {"plains", "cave"}, new String[] {"plains", "cave"}, "forest");
	}
}

```
#### Mountains.java
```
import com.pengu.pengulu.Node;

public class Mountains extends Node {

	public Mountains() {
		super(new String[] {"plains"}, new String[] {"plains"}, "mountains");
	}

}
```
#### Cave.java
```
import com.pengu.pengulu.*;

public class Cave extends Node {
	
	public Cave() {
		super(new String[] {"forest"}, new String[] {"forest"}, "cave");
	}
	
}

```
## Step 4 - Add nodes to the game
First, make sure all the nodes know the game they are a part of.<br>
Add this to the `go` method.
#### TestRun.java
```

```
