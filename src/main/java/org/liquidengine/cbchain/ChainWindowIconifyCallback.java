package org.liquidengine.cbchain;

import org.lwjgl.glfw.GLFWWindowIconifyCallbackI;

/**
 * Created by Shcherbin Alexander on 6/8/2016.
 */
public final class ChainWindowIconifyCallback extends Chain<GLFWWindowIconifyCallbackI> implements GLFWWindowIconifyCallbackI{

    @Override
    public void invoke(long window, boolean iconified) {
        for(GLFWWindowIconifyCallbackI glfwWindowIconifyCallbackI: callbackChain){
            glfwWindowIconifyCallbackI.invoke(window, iconified);
        }
    }
}
