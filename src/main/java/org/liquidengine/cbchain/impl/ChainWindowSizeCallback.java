package org.liquidengine.cbchain.impl;

import org.liquidengine.cbchain.AbstractChainCallback;
import org.liquidengine.cbchain.IChainWindowSizeCallback;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWWindowSizeCallbackI;

/**
 * Chain callback implementation based on {@link AbstractChainCallback}.
 * <p>
 * Instances of this interface may be passed to the {@link GLFW#glfwSetWindowSizeCallback SetWindowSizeCallback} method.
 */
public class ChainWindowSizeCallback extends AbstractChainCallback<GLFWWindowSizeCallbackI> implements IChainWindowSizeCallback {
    @Override
    public void invoke(long window, int width, int height) {
        callbackChain.forEach(c -> c.invoke(window, width, height));
    }
}
