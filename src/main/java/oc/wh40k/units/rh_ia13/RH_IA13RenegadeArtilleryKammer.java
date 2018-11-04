package oc.wh40k.units.rh_ia13;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class RH_IA13RenegadeArtilleryKammer extends RuestkammerVater {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    OptionsUpgradeGruppe o3;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;
    OptionsEinzelUpgrade oe3;

    boolean paskSelected = false;

    public RH_IA13RenegadeArtilleryKammer() {
        grundkosten = 0;
    }

    public void initButtons(boolean... defaults) {

        ogE.addElement(new OptionsGruppeEintrag("Renegade Basilisk", 115));
        ogE.addElement(new OptionsGruppeEintrag("Renegade Medusa", 105));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o1.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 0));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o2.setSelected(0, true);

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Enclosed crew compartment", 15));
        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Storm bolter", 10));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Heavy stubber", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Hunter-killer missile", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Dozer blade", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Extra armour", 10));
        add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Bastion breacher shells", 5));

        sizeSetzen();
    }

    // @OVERRIDE
    public void refreshen() {
        if (!o1.isSelected()) o1.setSelected(0, true);
        if (!o2.isSelected()) o2.setSelected(0, true);

        oe1.setAktiv(!oe2.isSelected());
        oe2.setAktiv(!oe1.isSelected());
        oe3.setAktiv(o1.isSelected("Medusa"));
    }

}
