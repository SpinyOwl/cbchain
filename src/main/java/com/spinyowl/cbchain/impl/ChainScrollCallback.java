package com.spinyowl.cbchain.impl;

import com.spinyowl.cbchain.IChainScrollCallback;
import com.spinyowl.cbchain.AbstractChainCallback;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWScrollCallbackI;

/**
 * Chain callback implementation based on {@link AbstractChainCallback}.
 * <p>
 * Instances of this interface may be passed to the {@link GLFW#glfwSetScrollCallback SetScrollCallback} method.
 */
public class ChainScrollCallback extends AbstractChainCallback<GLFWScrollCallbackI> implements IChainScrollCallback {
    @Override
    public void invoke(long window, double xoffset, double yoffset) {
        callbackChain.forEach(c -> c.invoke(window, xoffset, yoffset));
    }
}
