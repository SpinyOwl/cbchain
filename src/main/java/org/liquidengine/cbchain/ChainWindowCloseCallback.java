package org.liquidengine.cbchain;

import org.lwjgl.glfw.GLFWWindowCloseCallbackI;

/**
 * Created by Shcherbin Alexander on 6/8/2016.
 */
public final class ChainWindowCloseCallback extends AbstractChainCallback<GLFWWindowCloseCallbackI> implements GLFWWindowCloseCallbackI{

    @Override
    public void invoke(long window) {
        for(GLFWWindowCloseCallbackI glfwWindowCloseCallbackI: callbackChain){
            glfwWindowCloseCallbackI.invoke(window);
        }
    }
}
