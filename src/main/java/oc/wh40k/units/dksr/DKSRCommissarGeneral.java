package oc.wh40k.units.dksr;

import oc.*;

public class DKSRCommissarGeneral extends Eintrag {

    RuestkammerStarter rkTransport;

    public DKSRCommissarGeneral() {
        name = "Commissar General";
        grundkosten = 70;

        add(ico = new oc.Picture("oc/wh40k/images/IGLordCommissar.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Boltgun", 0));
        ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
        ogE.addElement(new OptionsGruppeEintrag("Power sword", 10));
        ogE.addElement(new OptionsGruppeEintrag("Power axe", 10));
        ogE.addElement(new OptionsGruppeEintrag("Power maul", 10));
        ogE.addElement(new OptionsGruppeEintrag("Power lance", 10));
        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
        ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
        add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand + 10, cnt, "option", "Melta bombs", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand + 10, cnt, "option", "Carapace Armour", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand + 10, cnt, "option", "Camo cloak", 10));

        seperator();

        rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "DKCentaur", "Centaur");
        rkTransport.initKammer();
        add(rkTransport);

        complete();
    }

    @Override
    public void refreshen() {
    }

}
