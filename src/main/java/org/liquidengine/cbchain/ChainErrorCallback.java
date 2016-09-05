package org.liquidengine.cbchain;

import org.lwjgl.glfw.GLFWErrorCallbackI;

/**
 * Created by Shcherbin Alexander on 6/8/2016.
 */
public final class ChainErrorCallback extends Chain<GLFWErrorCallbackI> implements GLFWErrorCallbackI{

    @Override
    public void invoke(int error, long description) {
        for(GLFWErrorCallbackI glfwErrorCallbackI: callbackChain){
            glfwErrorCallbackI.invoke(error, description);
        }
    }
}
