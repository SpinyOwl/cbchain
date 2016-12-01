package org.liquidengine.cbchain.impl;

import org.liquidengine.cbchain.AbstractChainCallback;
import org.liquidengine.cbchain.IChainCursorPosCallback;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallbackI;

/**
 * Chain callback implementation based on {@link AbstractChainCallback}.
 * <p>
 * Instances of this interface may be passed to the {@link GLFW#glfwSetCursorPosCallback SetCursorPosCallback} method.
 */
public final class ChainCursorPosCallback extends AbstractChainCallback<GLFWCursorPosCallbackI> implements IChainCursorPosCallback {
    public void invoke(long window, double xpos, double ypos) {
        for (GLFWCursorPosCallbackI glfwCursorPosCallbackI : callbackChain) {
            glfwCursorPosCallbackI.invoke(window, xpos, ypos);
        }
    }
}