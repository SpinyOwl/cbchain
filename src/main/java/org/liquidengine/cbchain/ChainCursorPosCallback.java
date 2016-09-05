package org.liquidengine.cbchain;

import org.lwjgl.glfw.GLFWCursorPosCallbackI;

public final class ChainCursorPosCallback extends Chain<GLFWCursorPosCallbackI> implements GLFWCursorPosCallbackI {
    public void invoke(long window, double xpos, double ypos) {
        for (GLFWCursorPosCallbackI glfwCursorPosCallbackI : callbackChain) {
            glfwCursorPosCallbackI.invoke(window, xpos, ypos);
        }
    }
}