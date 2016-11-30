package org.liquidengine.cbchain;

import org.lwjgl.glfw.GLFWWindowSizeCallbackI;

/**
 * Created by Shcherbin Alexander on 6/8/2016.
 */
public final class ChainWindowSizeCallback extends AbstractChainCallback<GLFWWindowSizeCallbackI> implements GLFWWindowSizeCallbackI{

    @Override
    public void invoke(long window, int width, int height) {
        for(GLFWWindowSizeCallbackI glfwWindowSizeCallbackI: callbackChain){
            glfwWindowSizeCallbackI.invoke(window, width, height);
        }
    }
}
