package org.liquidengine.cbchain;

import org.lwjgl.glfw.GLFWScrollCallbackI;

/**
 * Created by Shcherbin Alexander on 6/8/2016.
 */
public final class ChainScrollCallback extends AbstractChainCallback<GLFWScrollCallbackI> implements GLFWScrollCallbackI{

    @Override
    public void invoke(long window, double xoffset, double yoffset) {
        for(GLFWScrollCallbackI glfwScrollCallbackI: callbackChain){
            glfwScrollCallbackI.invoke(window, xoffset, yoffset);
        }
    }
}
