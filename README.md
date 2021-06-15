![REPO SIZE](https://img.shields.io/github/repo-size/SpinyOwl/cbchain.svg)
![CODE SIZE](https://img.shields.io/github/languages/code-size/SpinyOwl/cbchain.svg)
[![License](https://img.shields.io/github/license/SpinyOwl/cbchain.svg)](/LICENSE)

# CBCHAIN (Callback Chain for LWJGL3)

Chain callbacks for LWJGL3

## ABOUT
Cahin callback is callback that keep another callbacks and invoke them sequently when receives event. 

## How to add
### Add repository
#### Maven
```xml
<repositories>
    <repository>
      <id>SpinyOwl-releases</id>
      <url>https://raw.githubusercontent.com/SpinyOwl/repo/releases</url>
      <releases><enabled>true</enabled></releases>
      <snapshots><enabled>false</enabled></snapshots>
    </repository>
</repositories>
```
#### Gradle
```groovy
repositories {
    maven { url "https://raw.githubusercontent.com/SpinyOwl/repo/releases" }
}
```
### Add dependency
#### Maven
```xml
<!-- CBCHAIN - RELEASE - https://github.com/SpinyOwl/cbchain -->
<dependencies>
    <dependency>
       <groupId>org.liquidengine</groupId>
        <artifactId>cbchain</artifactId>
        <version>1.0.0</version>
    </dependency>
</dependencies>
 ```
#### Gradle
  ```groovy
// CBCHAIN - RELEASE - https://github.com/SpinyOwl/cbchain
compile group: 'org.liquidengine', name: 'cbchain', version: '1.0.0';
  ```


## Usage example
-------

```java
package org.liquidengine.cbchain.example;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallbackI;
import ChainKeyCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.system.MemoryUtil.NULL;

public class Example {
    
    public static void main(String[] args) {
        // Create chain key callback
        ChainKeyCallback glfwChainKeyCallback = new ChainKeyCallback();
        
        // Create some callback - for example escape button callback - to exit from app 
        GLFWKeyCallbackI escapeCallback = (long window, int key, int scancode, int action, int mods) -> {
            if (key == GLFW.GLFW_KEY_ESCAPE && action != GLFW.GLFW_RELEASE) {
                GLFW.glfwSetWindowShouldClose(window, true);
            }
        };
        
        // Create another callback that will print pressed key and action
        GLFWKeyCallbackI printKeyCallback = (long window, int key, int scancode, int action, int mods) -> {
            System.out.println("key: " + key + "; action: " + action);
        };
        
        // Add callbacks to chain callback
        glfwChainKeyCallback.add(escapeCallback);
        glfwChainKeyCallback.add(printKeyCallback);
        
        // Initialize glfw
        if (!GLFW.glfwInit()) {
            throw new IllegalStateException("Can't initialize GLFW");
        }
        // Create window
        long window = GLFW.glfwCreateWindow(600, 400, "Example", NULL, NULL);

        GLFW.glfwMakeContextCurrent(window);
        GL.createCapabilities();
        GL11.glClearColor(1, 1, 1, 1);

        // Bind chain key callback to window
        GLFW.glfwSetKeyCallback(window, glfwChainKeyCallback);
        
        while (!GLFW.glfwWindowShouldClose(window)) {
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

            GLFW.glfwSwapBuffers(window);
            GLFW.glfwPollEvents();
        }

        GLFW.glfwDestroyWindow(window);
        GLFW.glfwTerminate();
    }

}
```

Links
-------------------------------
[LWJGL - Lightweight Java Game Library 3](https://github.com/LWJGL/lwjgl3)
