# Get started
## Step 1
Download the .jar and and it to your project
## Step 2 - Create a the main class
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
		super(new String[] {"plains", "cave", "mine trees"}, new String[] {"plains", "cave"}, "forest");
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

public class Cave extends Node implements InputListener {
	
	public Cave() {
		super(new String[] {"forest", "mine stone", "mine coal ore"}, new String[] {"forest"}, "cave");
	}
	
}

```
