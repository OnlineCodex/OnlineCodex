package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMContemptorExemplarDreadnought extends Eintrag {
    OptionsUpgradeGruppe o1, o2, o3, o4, o5;

    public IMContemptorExemplarDreadnought() {
        name = "Contemptor-Exemplar Dreadnought";
        grundkosten = getPts("Contemptor-Exemplar");
        power = 13;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Dreadnought combat weapon", getPts("Dreadnought combat weapon (AC)")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o1.setSelected(0, true);

        ogE.addElement(new OptionsGruppeEintrag("Lastrum storm bolter", getPts("Lastrum storm bolter")));
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", getPts("Heavy flamer")));
        ogE.addElement(new OptionsGruppeEintrag("Plasma ejector", getPts("Plasma ejector")));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o3.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Dreadnought combat weapon", getPts("Dreadnought combat weapon")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o2.setSelected(0, true);

        ogE.addElement(new OptionsGruppeEintrag("Lastrum storm bolter", getPts("Lastrum storm bolter")));
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", getPts("Heavy flamer")));
        ogE.addElement(new OptionsGruppeEintrag("Plasma ejector", getPts("Plasma ejector")));
        add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o4.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Twin las-pulsar", getPts("Twin las-pulsar")));
        add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();
    }

    @Override
    public void refreshen() {
        o2.setAktiv(!o5.isSelected());
        o2.setSelected(0, (!o5.isSelected()));
        o4.setAktiv(!o5.isSelected());
        o4.setSelected(0, (!o5.isSelected()));

        if (o1.isSelected() && !o3.isSelected()) o3.setSelected(0, true);
        if (o2.isSelected() && !o4.isSelected()) o3.setSelected(0, true);

        int selected = ((o1.isSelected()) ? 1 : 0) + ((o2.isSelected()) ? 1 : 0) + ((o5.isSelected()) ? 1 : 0);
        o1.setLegal(selected == 2);
        o2.setLegal(selected == 2);
        o5.setLegal(selected == 2);

        if (o1.isSelected() && o2.isSelected()) {
            o1.setPreis(0, getPts("Dreadnought combat weapon pair (AC)") / 2);
            o2.setPreis(0, getPts("Dreadnought combat weapon pair (AC)") / 2);
        } else {
            o1.setPreis(0, getPts("Dreadnought combat weapon (AC)"));
            o2.setPreis(0, getPts("Dreadnought combat weapon (AC)"));
        }
    }
}
