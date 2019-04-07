package oc.wh40k.units.or;

import oc.OptionsEinzelUpgrade;
import oc.RuestkammerVater;

public class ORFlakkTrukkKammer extends RuestkammerVater {

	public ORFlakkTrukkKammer() {
        grundkosten = 75;
    }

    @Override
	public void initButtons(boolean... defaults) {
        add(ico = new oc.Picture("oc/wh40k/images/ORFlakkTrukk.gif"));


        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Rokkit launcha", 5));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Red paint job", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grot riggers", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Stikkbomb chukka", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wreckin' ball", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Reinforced ram", 5));

        sizeSetzen();
    }

    // @OVERRIDE
    @Override
	public void refreshen() {

    }

}
