package oc.wh40k.units.ta;

import oc.OptionsEinzelUpgrade;
import oc.RuestkammerVater;

public class TAFahrzeugKammer extends RuestkammerVater {

	public TAFahrzeugKammer() {

        grundkosten = 0;
    }

    @Override
	public void initButtons(boolean... defaults) {

        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "Automatisches Reparatursystem", "Reparatursystem", 5)); //Automated repair system
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Fahrzeugsensorik", 5)); //Fahrzeugsensorik?
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Filteroptik", 1)); //Blacksun Filter
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Flechettewerfer", 10)); //Flechette discharger
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "Hochentwickeltes Zielsystem", "Zielsystem", 10));//Advanced targeting system
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Ködersystem", 3)); //Decoy launcher
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "Punktverteidigungs-Zielrelais", "Punktverteidigung", 10)); //Point defence targeting relay
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Störsystem", 15)); //Disruption pod

        sizeSetzen();
    }

    // @OVERRIDE
    @Override
	public void refreshen() {
    }
}
