package org.liquidengine.cbchain.impl;

import org.liquidengine.cbchain.AbstractChainCallback;
import org.liquidengine.cbchain.IChainErrorCallback;
import org.lwjgl.glfw.GLFWErrorCallbackI;

/**
 * Created by Shcherbin Alexander on 6/8/2016.
 */
public final class ChainErrorCallback extends AbstractChainCallback<GLFWErrorCallbackI> implements IChainErrorCallback {
    @Override
    public void invoke(int error, long description) {
        for (GLFWErrorCallbackI glfwErrorCallbackI : callbackChain) {
            glfwErrorCallbackI.invoke(error, description);
        }
    }
}
