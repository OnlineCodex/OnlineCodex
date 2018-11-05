package oc.wh40k.units.or;

import oc.*;

public class ORWarlordtraits extends Eintrag {
    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe fk1;
    OptionsZaehlerGruppe fk2;
    AnzahlPanel squad;

    public ORWarlordtraits() {
        name = "Warlord Traits";
        grundkosten = 0;
        power = 0;

        ogE.addElement(new OptionsGruppeEintrag("Follow me Ladz", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Big Killa Boss", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Ard as Nails", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Brutal but Kunnin", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Kunnin but Brutal", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Might is Right", getPts("")));

        ogE.addElement(new OptionsGruppeEintrag("Bad Moons: Da best armout teef can buy", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Blood Axes: I've got a plan, Ladz", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Deathskull: Opportunist", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Evil Sunz: Speed Freak", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Freebooterz: Killa Reputation", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Goofs: Proper Killy", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Snakebites: Surly as a Squiggoth", getPts("")));
        add(fk1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        this.eintragsCNT = 0;

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        fk1.alwaysSelected();
    }
}
