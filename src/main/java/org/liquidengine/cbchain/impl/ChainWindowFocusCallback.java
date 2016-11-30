package org.liquidengine.cbchain.impl;

import org.liquidengine.cbchain.AbstractChainCallback;
import org.liquidengine.cbchain.IChainWindowFocusCallback;
import org.lwjgl.glfw.GLFWWindowFocusCallbackI;

/**
 * Created by Shcherbin Alexander on 6/8/2016.
 */
public final class ChainWindowFocusCallback extends AbstractChainCallback<GLFWWindowFocusCallbackI> implements IChainWindowFocusCallback {
    @Override
    public void invoke(long window, boolean focused) {
        for (GLFWWindowFocusCallbackI glfwWindowFocusCallbackI : callbackChain) {
            glfwWindowFocusCallbackI.invoke(window, focused);
        }
    }
}
