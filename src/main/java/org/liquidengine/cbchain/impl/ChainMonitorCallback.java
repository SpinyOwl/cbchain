package org.liquidengine.cbchain.impl;

import org.liquidengine.cbchain.AbstractChainCallback;
import org.liquidengine.cbchain.IChainMonitorCallback;
import org.lwjgl.glfw.GLFWMonitorCallbackI;

/**
 * Created by Shcherbin Alexander on 6/8/2016.
 */
public final class ChainMonitorCallback extends AbstractChainCallback<GLFWMonitorCallbackI> implements IChainMonitorCallback {
    @Override
    public void invoke(long monitor, int event) {
        for (GLFWMonitorCallbackI glfwMonitorCallbackI : callbackChain) {
            glfwMonitorCallbackI.invoke(monitor, event);
        }
    }
}
