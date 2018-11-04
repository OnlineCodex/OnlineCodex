package oc.wh40k.units.ia;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class IAJusticar extends RuestkammerVater {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    OptionsUpgradeGruppe o3;

    public IAJusticar() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {
        ogE.addElement(new OptionsGruppeEintrag("Psischwert", "Nemesis-Psischwert", 0));
        ogE.addElement(new OptionsGruppeEintrag("Psihellebarde", "Nemesis-Psihellebarde", 2));
        ogE.addElement(new OptionsGruppeEintrag("Falchions", "Paar Nemesis-Falchions", 4));
        ogE.addElement(new OptionsGruppeEintrag("Wehrstab", "Nemesis-Wehrstab", 5));
        ogE.addElement(new OptionsGruppeEintrag("Dämonenhammer", "Nemesis-Dämonenhammer", 10));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 0));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Digitalwaffen", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Teleport-Peilsender", 10));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Nahkampfwaffe Meisterhaft", 10));
        ogE.addElement(new OptionsGruppeEintrag("Fernkampfwaffe Meisterhaft", 10));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        if (!o1.isSelected()) o1.setSelected(0, true);
        //o1.setAktiv(!o2.isSelected());

        if (!o3.isSelected()) o3.setSelected(0, true);
    }

    @Override
    public void switchEntry(String name, boolean aktiv) {
    }

}
