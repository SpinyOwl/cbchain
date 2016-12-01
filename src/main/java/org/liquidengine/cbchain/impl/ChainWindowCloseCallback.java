package org.liquidengine.cbchain.impl;

import org.liquidengine.cbchain.AbstractChainCallback;
import org.liquidengine.cbchain.IChainWindowCloseCallback;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWWindowCloseCallbackI;

/**
 * Chain callback implementation based on {@link AbstractChainCallback}.
 * <p>
 * Instances of this interface may be passed to the {@link GLFW#glfwSetWindowCloseCallback SetWindowCloseCallback} method.
 */
public final class ChainWindowCloseCallback extends AbstractChainCallback<GLFWWindowCloseCallbackI> implements IChainWindowCloseCallback {
    @Override
    public void invoke(long window) {
        for (GLFWWindowCloseCallbackI glfwWindowCloseCallbackI : callbackChain) {
            glfwWindowCloseCallbackI.invoke(window);
        }
    }
}
