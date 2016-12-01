package org.liquidengine.cbchain.impl;

import org.liquidengine.cbchain.AbstractChainCallback;
import org.liquidengine.cbchain.IChainCharCallback;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCharCallbackI;

/**
 * Chain callback implementation based on {@link AbstractChainCallback}.
 * <p>
 * Instances of this interface may be passed to the {@link GLFW#glfwSetCharCallback SetCharCallback} method.
 */
public class ChainCharCallback extends AbstractChainCallback<GLFWCharCallbackI> implements IChainCharCallback {
    @Override
    public void invoke(long window, int codepoint) {
        callbackChain.forEach(c -> c.invoke(window, codepoint));
    }
}
