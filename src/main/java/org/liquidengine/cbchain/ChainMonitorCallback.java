package org.liquidengine.cbchain;

import org.lwjgl.glfw.GLFWMonitorCallbackI;

/**
 * Created by Shcherbin Alexander on 6/8/2016.
 */
public final class ChainMonitorCallback extends Chain<GLFWMonitorCallbackI> implements GLFWMonitorCallbackI{

    @Override
    public void invoke(long monitor, int event) {
        for(GLFWMonitorCallbackI glfwMonitorCallbackI: callbackChain){
            glfwMonitorCallbackI.invoke(monitor, event);
        }
    }
}
