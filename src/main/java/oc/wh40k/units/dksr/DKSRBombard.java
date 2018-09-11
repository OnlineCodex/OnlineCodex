package oc.wh40k.units.dksr;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class DKSRBombard extends RuestkammerVater {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;

    public DKSRBombard() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {
        add(ico = new oc.Picture("oc/wh40k/images/IGHellhound.jpg"));

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bombard", 140));
        

        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 0));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 5));
        	
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", 5));
        ogE.addElement(new OptionsGruppeEintrag("Storm bolter", 5));
        ogE.addElement(new OptionsGruppeEintrag("Enclosed crew compartment", 15));
        ogE.addElement(new OptionsGruppeEintrag("Hunter-killer missile", 10));
        ogE.addElement(new OptionsGruppeEintrag("Dozer blade", 5));
        ogE.addElement(new OptionsGruppeEintrag("Extra armour", 10));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 6));

//        seperator();
//
//        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Trojan and Trailer", 0));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        if (!oe1.isSelected()) oe1.setSelected(true);
        
        if (!o2.isSelected()) o2.setSelected(0,true);

        o1.setAktiv(0, !o1.isSelected(1));
        o1.setAktiv(1, !o1.isSelected(0));
    }
}
