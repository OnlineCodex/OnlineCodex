package oc.wh40k.units.dw;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class DWTerminator extends RuestkammerVater {

    OptionsUpgradeGruppe o1, o2;
    OptionsEinzelUpgrade cyclone, klauen, hammer;

    public DWTerminator() {
        grundkosten = 40;
    }

    @Override
    public void initButtons(boolean... defaults) {

        ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 0));
        ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 0));
        ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 0));
        ogE.addElement(new OptionsGruppeEintrag("Energieaxt", 0));
        ogE.addElement(new OptionsGruppeEintrag("Energiestab", 0));
        ogE.addElement(new OptionsGruppeEintrag("Energiestreitkolben", 0));
        ogE.addElement(new OptionsGruppeEintrag("Energielanze", 0));
        ogE.addElement(new OptionsGruppeEintrag("Kettenfaust", 5));
        ogE.addElement(new OptionsGruppeEintrag("Energiefaust + Melter", 10));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        o1.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Schwerer Flammenwerfer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Sturmkanone", 20));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        o2.setSelected(0, true);

        seperator();

        add(cyclone = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Cyclone Raketenwerfer & Sturmbolter", 25));

        seperator();

        add(klauen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Energieklauen", 0));
        add(hammer = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hammer & Schild", 10));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        o1.setAktiv(!hammer.isSelected() && !klauen.isSelected());
        o2.setAktiv(!hammer.isSelected() && !klauen.isSelected() && !cyclone.isSelected());
        cyclone.setAktiv(!o2.isSelected() || o2.isSelected(0));
        hammer.setAktiv(!klauen.isSelected());
        klauen.setAktiv(!hammer.isSelected());
    }

}
