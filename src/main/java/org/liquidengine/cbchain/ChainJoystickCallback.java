package org.liquidengine.cbchain;

import org.lwjgl.glfw.GLFWJoystickCallbackI;

/**
 * Created by Shcherbin Alexander on 6/8/2016.
 */
public final class ChainJoystickCallback extends Chain<GLFWJoystickCallbackI> implements GLFWJoystickCallbackI{

    @Override
    public void invoke(int joy, int event) {
        for(GLFWJoystickCallbackI glfwJoystickCallbackI: callbackChain){
            glfwJoystickCallbackI.invoke(joy, event);
        }
    }
}
