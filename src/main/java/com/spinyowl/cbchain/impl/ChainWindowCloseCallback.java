package com.spinyowl.cbchain.impl;

import com.spinyowl.cbchain.AbstractChainCallback;
import com.spinyowl.cbchain.IChainWindowCloseCallback;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWWindowCloseCallbackI;

/**
 * Chain callback implementation based on {@link AbstractChainCallback}.
 * <p>
 * Instances of this interface may be passed to the {@link GLFW#glfwSetWindowCloseCallback SetWindowCloseCallback} method.
 */
public class ChainWindowCloseCallback extends AbstractChainCallback<GLFWWindowCloseCallbackI> implements IChainWindowCloseCallback {
    @Override
    public void invoke(long window) {
        callbackChain.forEach(c -> c.invoke(window));
    }
}
