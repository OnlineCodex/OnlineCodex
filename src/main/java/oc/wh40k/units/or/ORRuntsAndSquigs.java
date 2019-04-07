package oc.wh40k.units.or;

import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.RuestkammerVater;

public class ORRuntsAndSquigs extends RuestkammerVater {

	private boolean mek = false;
	private boolean dok = false;
	public ORRuntsAndSquigs() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {
        try {
            mek = defaults[0];
            dok = defaults[1];
        } catch (final Exception e) {
        }

        add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Munigrot", 3, 3));
        if (mek) {
            add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Schmiergrot", 3, 5)); //Nur Meks
        }
        if (dok) {
            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grotassistent", 5)); //Nur Doks
        }
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Schnappasquiq", 15));


        setUeberschrift("Runts & Squigs");
        sizeSetzen();
    }

    @Override
    public void refreshen() {

    }

}
