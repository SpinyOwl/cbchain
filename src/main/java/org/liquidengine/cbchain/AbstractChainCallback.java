package org.liquidengine.cbchain;

import org.lwjgl.system.CallbackI;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Base implementation of {@link IChainCallback} based on {@link CopyOnWriteArrayList}
 */
public abstract class AbstractChainCallback<T extends CallbackI> implements IChainCallback<T> {
    protected List<T> callbackChain = new CopyOnWriteArrayList<T>();

    public boolean isEmpty() {
        return callbackChain.isEmpty();
    }

    public int size() {
        return callbackChain.size();
    }

    public boolean remove(T callback) {
        return callbackChain.remove(callback);
    }

    public boolean add(T callback) {
        return callbackChain.add(callback);
    }

    public boolean contains(T callback) {
        return callbackChain.contains(callback);
    }

    public boolean containsAll(Collection<? extends T> callbacks) {
        return callbackChain.containsAll(callbacks);
    }

    public boolean addAll(Collection<? extends T> callbacks) {
        return callbackChain.addAll(callbacks);
    }

    public boolean addAll(int index, Collection<? extends T> callbacks) {
        return callbackChain.addAll(index, callbacks);
    }

    public boolean removeAll(Collection<? extends T> callbacks) {
        return callbackChain.removeAll(callbacks);
    }

    public void clear() {
        callbackChain.clear();
    }

    public T get(int index) {
        return callbackChain.get(index);
    }

    public T set(int index, T callback) {
        return callbackChain.set(index, callback);
    }

    public void add(int index, T callback) {
        callbackChain.add(index, callback);
    }

    public T remove(int index) {
        return callbackChain.remove(index);
    }

    public int indexOf(T callback) {
        return callbackChain.indexOf(callback);
    }

    public int lastIndexOf(T callback) {
        return callbackChain.lastIndexOf(callback);
    }
}
