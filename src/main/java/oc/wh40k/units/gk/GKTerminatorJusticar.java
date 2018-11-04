package oc.wh40k.units.gk;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class GKTerminatorJusticar extends RuestkammerVater {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    OptionsUpgradeGruppe o3;
    OptionsEinzelUpgrade banner;

    public GKTerminatorJusticar() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {
        ogE.addElement(new OptionsGruppeEintrag("Psischwert", "Nemesis-Psischwert", 0));
        ogE.addElement(new OptionsGruppeEintrag("Psihellebarde", "Nemesis-Psihellebarde", 2));
        ogE.addElement(new OptionsGruppeEintrag("Falchions", "Paar Nemesis-Falchions", 4));
        ogE.addElement(new OptionsGruppeEintrag("Wehrstab", "Nemesis-Wehrstab", 5));
        ogE.addElement(new OptionsGruppeEintrag("Dämonenhammer", "Nemesis-Dämonenhammer", 10));
        //ogE.addElement(new OptionsGruppeEintrag("Meisterhaftes Psischwert", "Meisterhaftes Nemesis-Psischwert", 5));
        //ogE.addElement(new OptionsGruppeEintrag("Meisterhafte Psihellebarde", "Meisterhafte Nemesis-Psihellebarde", 10));
        //ogE.addElement(new OptionsGruppeEintrag("Meisterhafter Däm.hammer", "Meisterhafter Nemesis-Dämonenhammer", 15));
        //ogE.addElement(new OptionsGruppeEintrag("Meisterhafte Falchions", "Paar Meisterhafte Nemesis-Falchions", 15));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 0));
        //ogE.addElement(new OptionsGruppeEintrag("Meisterhafter Sturmbolter", 5));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Digitalwaffen", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Teleport-Peilsender", 10));
    }

    @Override
    public void refreshen() {
        if (!o1.isSelected()) o1.setSelected(0, true);
        //o1.setAktiv(!o2.isSelected());

        if (!o3.isSelected()) o3.setSelected(0, true);
    }
}
