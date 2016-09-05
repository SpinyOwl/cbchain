package org.liquidengine.cbchain;

import org.lwjgl.glfw.GLFWKeyCallbackI;

/**
 * Created by Shcherbin Alexander on 6/7/2016.
 */
public final class ChainKeyCallback extends Chain<GLFWKeyCallbackI> implements GLFWKeyCallbackI {
    @Override
    public void invoke(long window, int key, int scancode, int action, int mods) {
        for (GLFWKeyCallbackI glfwKeyCallbackI : callbackChain) {
            glfwKeyCallbackI.invoke(window, key, scancode, action, mods);
        }
    }
}
