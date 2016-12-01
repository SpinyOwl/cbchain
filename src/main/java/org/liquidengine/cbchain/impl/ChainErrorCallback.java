package org.liquidengine.cbchain.impl;

import org.liquidengine.cbchain.AbstractChainCallback;
import org.liquidengine.cbchain.IChainErrorCallback;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallbackI;

/**
 * Chain callback implementation based on {@link AbstractChainCallback}.
 * <p>
 * Instances of this interface may be passed to the {@link GLFW#glfwSetErrorCallback SetErrorCallback} method.
 */
public class ChainErrorCallback extends AbstractChainCallback<GLFWErrorCallbackI> implements IChainErrorCallback {
    @Override
    public void invoke(int error, long description) {
        callbackChain.forEach(c -> c.invoke(error, description));
    }
}
