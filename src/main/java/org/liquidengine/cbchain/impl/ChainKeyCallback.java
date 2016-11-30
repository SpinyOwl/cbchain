package org.liquidengine.cbchain.impl;

import org.liquidengine.cbchain.AbstractChainCallback;
import org.liquidengine.cbchain.IChainKeyCallback;
import org.lwjgl.glfw.GLFWKeyCallbackI;

/**
 * Created by Shcherbin Alexander on 6/7/2016.
 */
public final class ChainKeyCallback extends AbstractChainCallback<GLFWKeyCallbackI> implements IChainKeyCallback {
    @Override
    public void invoke(long window, int key, int scancode, int action, int mods) {
        for (GLFWKeyCallbackI glfwKeyCallbackI : callbackChain) {
            glfwKeyCallbackI.invoke(window, key, scancode, action, mods);
        }
    }
}
