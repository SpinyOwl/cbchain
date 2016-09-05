package org.liquidengine.cbchain;

import org.lwjgl.glfw.GLFWFramebufferSizeCallbackI;

/**
 * Created by Shcherbin Alexander on 6/8/2016.
 */
public final class ChainFramebufferSizeCallback extends Chain<GLFWFramebufferSizeCallbackI> implements GLFWFramebufferSizeCallbackI{

    @Override
    public void invoke(long window, int width, int height) {
        for(GLFWFramebufferSizeCallbackI glfwFramebufferSizeCallbackI: callbackChain){
            glfwFramebufferSizeCallbackI.invoke(window, width, height);
        }
    }
}
