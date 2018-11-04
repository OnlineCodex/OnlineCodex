package oc.wh40k.units.rh_ia13;

import oc.*;

public class RH_IA13RenegadeSalamanderKammer extends RuestkammerVater {

    OptionsUpgradeGruppe o2;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;
    OptionsEinzelUpgrade mt;

    public RH_IA13RenegadeSalamanderKammer() {
        name = "RenegadeSalamander";
        grundkosten = 45;
    }

    @Override
    public void initButtons(boolean... defaults) {


        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 0));
        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Autocannon", 0));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o2.setSelected(0, true);

        seperator();

        add(mt = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Militia Training", 10));
        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Storm bolter", 5));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Heavy stubber", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dozer blade", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Mine plough", 15));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Extra armour", 15));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        oe1.setAktiv(!oe2.isSelected());
        oe2.setAktiv(!oe1.isSelected());

        o2.alwaysSelected();

        if (BuildaHQ.aktBuildaVater.getCountFromInformationVector("RHBloodyHandedReaver") == 1) {
            mt.setSelected(true);
        }
    }

}
