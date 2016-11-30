package org.liquidengine.cbchain.impl;

import org.liquidengine.cbchain.AbstractChainCallback;
import org.liquidengine.cbchain.IChainCursorPosCallback;
import org.lwjgl.glfw.GLFWCursorPosCallbackI;

/**
 * Created by Shcherbin Alexander on 6/8/2016.
 */
public final class ChainCursorPosCallback extends AbstractChainCallback<GLFWCursorPosCallbackI> implements IChainCursorPosCallback {
    public void invoke(long window, double xpos, double ypos) {
        for (GLFWCursorPosCallbackI glfwCursorPosCallbackI : callbackChain) {
            glfwCursorPosCallbackI.invoke(window, xpos, ypos);
        }
    }
}