package org.liquidengine.cbchain.impl;

import org.liquidengine.cbchain.AbstractChainCallback;
import org.liquidengine.cbchain.IChainWindowPosCallback;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWWindowPosCallbackI;

/**
 * Chain callback implementation based on {@link AbstractChainCallback}.
 * <p>
 * Instances of this interface may be passed to the {@link GLFW#glfwSetWindowPosCallback SetWindowPosCallback} method.
 */
public class ChainWindowPosCallback extends AbstractChainCallback<GLFWWindowPosCallbackI> implements IChainWindowPosCallback {
    @Override
    public void invoke(long window, int xpos, int ypos) {
        callbackChain.forEach(c -> c.invoke(window, xpos, ypos));
    }
}
