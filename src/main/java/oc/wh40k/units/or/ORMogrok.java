package oc.wh40k.units.or;

public class ORMogrok extends ORBigMek {

    public ORMogrok() {
        super();
        name = "Mogrok [Bigmek]";
    }

    @Override
    public void refreshen() {
        setUnikat(true);
        super.refreshen();
    }

}
