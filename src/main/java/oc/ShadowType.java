package oc;

public abstract class ShadowType {
    protected ShadowType() {
        throw new UnsupportedOperationException("Tried to instantiate the shadowtype " + getClass() +
                        ". Shadowtypes are only meant to be used to typechecking and FactionIndexer. Never instantiated directly");
    }
}
