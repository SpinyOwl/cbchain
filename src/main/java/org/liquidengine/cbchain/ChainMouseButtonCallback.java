package org.liquidengine.cbchain;

import org.lwjgl.glfw.GLFWMouseButtonCallbackI;

/**
 * Created by Shcherbin Alexander on 6/8/2016.
 */
public final class ChainMouseButtonCallback extends Chain<GLFWMouseButtonCallbackI> implements GLFWMouseButtonCallbackI{

    @Override
    public void invoke(long window, int button, int action, int mods) {
        for(GLFWMouseButtonCallbackI glfwMouseButtonCallbackI: callbackChain){
            glfwMouseButtonCallbackI.invoke(window, button, action, mods);
        }
    }
}
