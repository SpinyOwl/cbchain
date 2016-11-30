package org.liquidengine.cbchain.impl;

import org.liquidengine.cbchain.AbstractChainCallback;
import org.liquidengine.cbchain.IChainJoystickCallback;
import org.lwjgl.glfw.GLFWJoystickCallbackI;

/**
 * Created by Shcherbin Alexander on 6/8/2016.
 */
public final class ChainJoystickCallback extends AbstractChainCallback<GLFWJoystickCallbackI> implements IChainJoystickCallback {
    @Override
    public void invoke(int joy, int event) {
        for (GLFWJoystickCallbackI glfwJoystickCallbackI : callbackChain) {
            glfwJoystickCallbackI.invoke(joy, event);
        }
    }
}
