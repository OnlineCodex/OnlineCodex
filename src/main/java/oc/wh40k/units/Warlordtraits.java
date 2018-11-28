package oc.wh40k.units;

import oc.*;

public class Warlordtraits extends RuestkammerVater {
    OptionsUpgradeGruppe fk1;

    public Warlordtraits() {
        grundkosten = 0;
    }

	@Override
	public void initButtons(boolean... b) {
		warlord = true;
    	addToInformationVector("Warlord", 1);

        ogE.addElement(new OptionsGruppeEintrag("Follow me Ladz", 0));
        ogE.addElement(new OptionsGruppeEintrag("Big Killa Boss", 0));
        ogE.addElement(new OptionsGruppeEintrag("Ard as Nails", 0));
        ogE.addElement(new OptionsGruppeEintrag("Brutal but Kunnin", 0));
        ogE.addElement(new OptionsGruppeEintrag("Kunnin but Brutal", 0));
        ogE.addElement(new OptionsGruppeEintrag("Might is Right", 0));
        
        ogE.addElement(new OptionsGruppeEintrag("Bad Moons: Da best armout teef can buy", 0));
        ogE.addElement(new OptionsGruppeEintrag("Blood Axes: I've got a plan, Ladz", 0));
        ogE.addElement(new OptionsGruppeEintrag("Deathskull: Opportunist", 0));
        ogE.addElement(new OptionsGruppeEintrag("Evil Sunz: Speed Freak", 0));
        ogE.addElement(new OptionsGruppeEintrag("Freebooterz: Killa Reputation", 0));
        ogE.addElement(new OptionsGruppeEintrag("Goofs: Proper Killy", 0));
        ogE.addElement(new OptionsGruppeEintrag("Snakebites: Surly as a Squiggoth", 0));
        add(fk1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1, false));

        setUeberschrift("Warlord Traits");
        sizeSetzen();
    }

    //@OVERRIDE
    public void refreshen() {
        fk1.alwaysSelected();
        warlordError = getCountFromInformationVector("Warlord") > 1;
        showErrorMessage(warlordError ? "Max. 1 Warlord" : "");
    }
    
    public void deleteYourself() {
    	addToInformationVector("Warlord", -1);
    	super.deleteYourself();
    }

    
}
