package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHChaosDecimator extends Eintrag {
    private final OptionsUpgradeGruppe o1;
    private final OptionsUpgradeGruppe o2;
    private final OptionsUpgradeGruppe mark;


    public CHChaosDecimator() {
        name = "Chaos Decimator";
        grundkosten = getPts("Chaos Decimator");

        ogE.addElement(new OptionsGruppeEintrag("Decimator claw/Flamer", getPts("Decimator claw") + getPts("Hellflamer")));
        ogE.addElement(new OptionsGruppeEintrag("Soulburner petard", getPts("Soulburner petard")));
        ogE.addElement(new OptionsGruppeEintrag("C-beam cannon", getPts("C-beam cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Butcher cannon", getPts("Butcher cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Decimator storm laser", getPts("Decimator storm laser")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Decimator claw/Flamer", getPts("Decimator claw") + getPts("Hellflamer")));
        ogE.addElement(new OptionsGruppeEintrag("Soulburner petard", getPts("Soulburner petard")));
        ogE.addElement(new OptionsGruppeEintrag("C-beam cannon", getPts("C-beam cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Butcher cannon", getPts("Butcher cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Decimator storm laser", getPts("Decimator storm laser")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Mark of Khorne", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
        add(mark = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        
        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
    }
}
