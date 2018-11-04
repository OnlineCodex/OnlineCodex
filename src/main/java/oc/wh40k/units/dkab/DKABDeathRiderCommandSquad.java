package oc.wh40k.units.dkab;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class DKABDeathRiderCommandSquad extends RuestkammerVater {

    OptionsZaehlerGruppe o2;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe3;

    public DKABDeathRiderCommandSquad() {
        name = "Death Rider Command Squad";
        grundkosten = 100;
    }

    public void initButtons(boolean... defaults) {
        add(ico = new oc.Picture("oc/wh40k/images/IGCompanyCommandSquad.jpg"));

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Company Commander", 0));

        seperator(5);

        ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 2));
        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
        ogE.addElement(new OptionsGruppeEintrag("Power sword", 10));
        ogE.addElement(new OptionsGruppeEintrag("Power axe", 10));
        add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

        seperator(5);

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Demolition Charge", 20));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melta bombs", 5));

        seperator();

        add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Commissar", 35));

        seperator(5);

        ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 2));
        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
        ogE.addElement(new OptionsGruppeEintrag("Power sword", 10));
        ogE.addElement(new OptionsGruppeEintrag("Power axe", 10));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        oe1.setSelected(true);

        o2.setAktiv(oe3.isSelected());
    }


}
