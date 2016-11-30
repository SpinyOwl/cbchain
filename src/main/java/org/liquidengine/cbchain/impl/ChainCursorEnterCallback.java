package org.liquidengine.cbchain.impl;

import org.liquidengine.cbchain.AbstractChainCallback;
import org.liquidengine.cbchain.IChainCursorEnterCallback;
import org.lwjgl.glfw.GLFWCursorEnterCallbackI;

/**
 * Created by Shcherbin Alexander on 6/8/2016.
 */
public final class ChainCursorEnterCallback extends AbstractChainCallback<GLFWCursorEnterCallbackI> implements IChainCursorEnterCallback {
    @Override
    public void invoke(long window, boolean entered) {
        for (GLFWCursorEnterCallbackI glfwCursorEnterCallbackI : callbackChain) {
            glfwCursorEnterCallbackI.invoke(window, entered);
        }
    }
}
