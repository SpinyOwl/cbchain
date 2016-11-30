package org.liquidengine.cbchain;

import org.lwjgl.glfw.GLFWWindowPosCallbackI;

/**
 * Created by Shcherbin Alexander on 6/8/2016.
 */
public final class ChainWindowPosCallback extends AbstractChainCallback<GLFWWindowPosCallbackI> implements GLFWWindowPosCallbackI{

    @Override
    public void invoke(long window, int xpos, int ypos) {
        for(GLFWWindowPosCallbackI glfwWindowPosCallbackI: callbackChain){
            glfwWindowPosCallbackI.invoke(window, xpos, ypos);
        }
    }
}
