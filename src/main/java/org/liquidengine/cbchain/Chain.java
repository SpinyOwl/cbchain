package org.liquidengine.cbchain;

import org.lwjgl.system.CallbackI;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Shcherbin Alexander on 6/7/2016.
 */
class Chain<T extends CallbackI> {
    List<T> callbackChain = new CopyOnWriteArrayList<T>();

    public boolean isEmpty() {
        return callbackChain.isEmpty();
    }

    public int size() {
        return callbackChain.size();
    }

    public boolean remove(Object o) {
        return callbackChain.remove(o);
    }

    public boolean add(T t) {
        return callbackChain.add(t);
    }

    public boolean contains(Object o) {
        return callbackChain.contains(o);
    }

    public boolean containsAll(Collection<?> c) {
        return callbackChain.containsAll(c);
    }

    public boolean addAll(Collection<? extends T> c) {
        return callbackChain.addAll(c);
    }

    public boolean addAll(int index, Collection<? extends T> c) {
        return callbackChain.addAll(index, c);
    }

    public boolean removeAll(Collection<?> c) {
        return callbackChain.removeAll(c);
    }

    public void clear() {
        callbackChain.clear();
    }

    public T get(int index) {
        return callbackChain.get(index);
    }

    public T set(int index, T element) {
        return callbackChain.set(index, element);
    }

    public void add(int index, T element) {
        callbackChain.add(index, element);
    }

    public T remove(int index) {
        return callbackChain.remove(index);
    }

    public int indexOf(Object o) {
        return callbackChain.indexOf(o);
    }

    public int lastIndexOf(Object o) {
        return callbackChain.lastIndexOf(o);
    }
}
