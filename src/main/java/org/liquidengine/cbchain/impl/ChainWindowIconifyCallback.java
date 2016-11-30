package org.liquidengine.cbchain.impl;

import org.liquidengine.cbchain.AbstractChainCallback;
import org.liquidengine.cbchain.IChainWindowIconifyCallback;
import org.lwjgl.glfw.GLFWWindowIconifyCallbackI;

/**
 * Created by Shcherbin Alexander on 6/8/2016.
 */
public final class ChainWindowIconifyCallback extends AbstractChainCallback<GLFWWindowIconifyCallbackI> implements IChainWindowIconifyCallback {
    @Override
    public void invoke(long window, boolean iconified) {
        for (GLFWWindowIconifyCallbackI glfwWindowIconifyCallbackI : callbackChain) {
            glfwWindowIconifyCallbackI.invoke(window, iconified);
        }
    }
}
