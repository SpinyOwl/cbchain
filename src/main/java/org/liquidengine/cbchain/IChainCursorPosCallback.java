package org.liquidengine.cbchain;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallbackI;

/**
 * Instances of this interface may be passed to the {@link GLFW#glfwSetCursorPosCallback SetCursorPosCallback} method.
 */
public interface IChainCursorPosCallback extends IChainCallback<GLFWCursorPosCallbackI>, GLFWCursorPosCallbackI {
}