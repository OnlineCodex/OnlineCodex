package oc.wh40k.units.or;

import oc.*;

public class ORWarlordtraits extends Eintrag {
    OptionsUpgradeGruppe fk1;

    public ORWarlordtraits() {
        name = "Warlord Traits";
        grundkosten = 0;
        power = 0;

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

        this.eintragsCNT = 0;

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        fk1.alwaysSelected();
    }
}
