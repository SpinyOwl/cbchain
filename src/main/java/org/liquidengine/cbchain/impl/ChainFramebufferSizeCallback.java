package org.liquidengine.cbchain.impl;

import org.liquidengine.cbchain.AbstractChainCallback;
import org.liquidengine.cbchain.IChainFramebufferSizeCallback;
import org.lwjgl.glfw.GLFWFramebufferSizeCallbackI;

/**
 * Created by Shcherbin Alexander on 6/8/2016.
 */
public final class ChainFramebufferSizeCallback extends AbstractChainCallback<GLFWFramebufferSizeCallbackI> implements IChainFramebufferSizeCallback {
    @Override
    public void invoke(long window, int width, int height) {
        for (GLFWFramebufferSizeCallbackI glfwFramebufferSizeCallbackI : callbackChain) {
            glfwFramebufferSizeCallbackI.invoke(window, width, height);
        }
    }
}
