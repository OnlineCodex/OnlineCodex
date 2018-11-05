package oc.wh40k.units.dw;

import oc.*;

public class DWWatchSergeant extends RuestkammerVater {

    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o2;
    OptionsUpgradeGruppe bolter;
    OptionsUpgradeGruppe handwaffe;

    public DWWatchSergeant() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {

        ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Sturmschild", 10));
        add(bolter = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Nahkampfwaffe", 0));
        ogE.addElement(new OptionsGruppeEintrag("Xenophase Schwert", 25));
        ogE.addElement(new OptionsGruppeEintrag("Sturmschild", 10));
        add(handwaffe = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        bolter.setSelected(0, true);
        handwaffe.setSelected(0, true);

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Auspex", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Parierschild", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Teleport-Peilsender", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Digitalwaffen", 10));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
    }

}
