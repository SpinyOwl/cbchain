# CBCHAIN (Callback Chain for LWJGL3)

Chain callbacks for LWJGL3

Current version you can find in [version.properties](version.properties)

## ABOUT
Cahin callback is callback that keep another callbacks and invoke them sequently when receives event. 

## Example
-------

```java
package org.liquidengine.cbchain.example;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallbackI;
import org.liquidengine.cbchain.impl.ChainKeyCallback;
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
