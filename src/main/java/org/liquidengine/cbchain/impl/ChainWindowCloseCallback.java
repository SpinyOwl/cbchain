package org.liquidengine.cbchain.impl;

import org.liquidengine.cbchain.AbstractChainCallback;
import org.liquidengine.cbchain.IChainWindowCloseCallback;
import org.lwjgl.glfw.GLFWWindowCloseCallbackI;

/**
 * Created by Shcherbin Alexander on 6/8/2016.
 */
public final class ChainWindowCloseCallback extends AbstractChainCallback<GLFWWindowCloseCallbackI> implements IChainWindowCloseCallback {
    @Override
    public void invoke(long window) {
        for (GLFWWindowCloseCallbackI glfwWindowCloseCallbackI : callbackChain) {
            glfwWindowCloseCallbackI.invoke(window);
        }
    }
}
