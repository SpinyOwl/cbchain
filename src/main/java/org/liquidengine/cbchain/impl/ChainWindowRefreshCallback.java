package org.liquidengine.cbchain.impl;

import org.liquidengine.cbchain.AbstractChainCallback;
import org.liquidengine.cbchain.IChainWindowRefreshCallback;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWWindowRefreshCallbackI;

/**
 * Chain callback implementation based on {@link AbstractChainCallback}.
 * <p>
 * Instances of this interface may be passed to the {@link GLFW#glfwSetWindowRefreshCallback SetWindowRefreshCallback} method.
 */
public class ChainWindowRefreshCallback extends AbstractChainCallback<GLFWWindowRefreshCallbackI> implements IChainWindowRefreshCallback {
    @Override
    public void invoke(long window) {
        callbackChain.forEach(c -> c.invoke(window));
    }
}
