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
Make three files `Plains.java`, `Forest.java`, `Mountains.java`, and `Cave.java`
