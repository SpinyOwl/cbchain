package org.liquidengine.cbchain.impl;

import org.liquidengine.cbchain.AbstractChainCallback;
import org.liquidengine.cbchain.IChainCharCallback;
import org.lwjgl.glfw.GLFWCharCallbackI;

/**
 * Created by Shcherbin Alexander on 6/8/2016.
 */
public final class ChainCharCallback extends AbstractChainCallback<GLFWCharCallbackI> implements IChainCharCallback {
    @Override
    public void invoke(long window, int codepoint) {
        for (GLFWCharCallbackI glfwKeyCallbackI : callbackChain) {
            glfwKeyCallbackI.invoke(window, codepoint);
        }
    }
}
