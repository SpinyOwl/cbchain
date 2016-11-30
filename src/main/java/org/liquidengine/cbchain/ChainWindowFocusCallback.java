package org.liquidengine.cbchain;

import org.lwjgl.glfw.GLFWWindowFocusCallbackI;

/**
 * Created by Shcherbin Alexander on 6/8/2016.
 */
public final class ChainWindowFocusCallback extends AbstractChainCallback<GLFWWindowFocusCallbackI> implements GLFWWindowFocusCallbackI{

    @Override
    public void invoke(long window, boolean focused) {
        for(GLFWWindowFocusCallbackI glfwWindowFocusCallbackI: callbackChain){
            glfwWindowFocusCallbackI.invoke(window, focused);
        }
    }
}
