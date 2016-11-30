package org.liquidengine.cbchain;

import org.lwjgl.glfw.GLFWCharModsCallbackI;

/**
 * Created by Shcherbin Alexander on 6/8/2016.
 */
public class ChainCharModsCallback extends AbstractChainCallback<GLFWCharModsCallbackI> implements GLFWCharModsCallbackI {
    @Override
    public void invoke(long window, int codepoint, int mods) {
        for (GLFWCharModsCallbackI glfwCharModsCallbackI : callbackChain) {
            glfwCharModsCallbackI.invoke(window, codepoint, mods);
        }
    }
}
