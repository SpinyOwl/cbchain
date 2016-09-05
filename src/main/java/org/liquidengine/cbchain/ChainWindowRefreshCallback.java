package org.liquidengine.cbchain;

import org.lwjgl.glfw.GLFWWindowRefreshCallbackI;

/**
 * Created by Shcherbin Alexander on 6/8/2016.
 */
public final class ChainWindowRefreshCallback extends Chain<GLFWWindowRefreshCallbackI> implements GLFWWindowRefreshCallbackI{

    @Override
    public void invoke(long window) {
        for(GLFWWindowRefreshCallbackI glfwWindowRefreshCallbackI: callbackChain){
            glfwWindowRefreshCallbackI.invoke(window);
        }
    }
}
