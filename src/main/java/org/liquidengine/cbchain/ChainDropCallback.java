package org.liquidengine.cbchain;

import org.lwjgl.glfw.GLFWDropCallbackI;

/**
 * Created by Shcherbin Alexander on 6/8/2016.
 */
public final class ChainDropCallback extends AbstractChainCallback<GLFWDropCallbackI> implements GLFWDropCallbackI{

    @Override
    public void invoke(long window, int count, long names) {
        for(GLFWDropCallbackI glfwDropCallbackI: callbackChain){
            glfwDropCallbackI.invoke(window, count, names);
        }
    }
}
