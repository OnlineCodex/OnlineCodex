package oc.wh40k.units.im;

import oc.*;

public class IMImperialKnightHeirlooms extends Eintrag {
    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe fk1;
    OptionsZaehlerGruppe fk2;
    AnzahlPanel squad;

    public IMImperialKnightHeirlooms() {
        name = "Armiger Helverin";
        grundkosten = 0;
        power = 0;

        ogE.addElement(new OptionsGruppeEintrag("Sanctuary", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Ravager", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("The Paragon Gauntlet", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Armour of the Sainted Ion", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Endless Fury", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Judgement", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Skyshield", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Helm of the Nameless Warrior", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Banner of Macharius Triumphant", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Traitor's Eye", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Traitor's Pyre", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Mark of the Omnissiah", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("The Helm Dominatus", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Cawl's Wrath", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("(Terryn) Thunder of Voltoris", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("(Griffith) Mark of the Lance", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("(Hawkshroud) Angel's Grace", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("(Cadmus) The Hunter's Eye", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("(Mortan) Honour's Bite", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("(Raven) The Banner Inviolate", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("(Taranis) Fury of Mars", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("(Krast) The Headsman's Mark", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("(Vulker) The Auric Mask", getPts("")));
        add(fk1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 3));

        this.eintragsCNT = 0;

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        fk1.alwaysSelected();
    }
}
