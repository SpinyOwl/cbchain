package org.liquidengine.cbchain;

import org.lwjgl.glfw.*;

public final class ChainCursorEnterCallback extends AbstractChainCallback<GLFWCursorEnterCallbackI> implements GLFWCursorEnterCallbackI{

    @Override
    public void invoke(long window, boolean entered) {
        for(GLFWCursorEnterCallbackI glfwCursorEnterCallbackI: callbackChain){
            glfwCursorEnterCallbackI.invoke(window, entered);
        }
    }
}
