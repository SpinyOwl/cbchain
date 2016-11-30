package org.liquidengine.cbchain;

import org.lwjgl.system.CallbackI;

import java.util.Collection;

/**
 * Created by Alexander on 01.12.2016.
 */
public interface IChainCallback<T extends CallbackI> {

    boolean isEmpty();

    int size();

    boolean remove(T callback);

    boolean add(T callback);

    boolean contains(T callback);

    boolean containsAll(Collection<? extends T> callbacks);

    boolean addAll(Collection<? extends T> callbacks);

    boolean addAll(int index, Collection<? extends T> callbacks);

    boolean removeAll(Collection<? extends T> callbacks);

    void clear();

    T get(int index);

    T set(int index, T callback);

    void add(int index, T callback);

    T remove(int index);

    int indexOf(T callback);

    int lastIndexOf(T callback);
}
