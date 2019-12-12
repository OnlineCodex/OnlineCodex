package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHQuestorisKnightStyrix extends Eintrag {

	private final OptionsUpgradeGruppe o1, o2, o3;

    public CHQuestorisKnightStyrix() {
        name = "Questoris Knight Styrix";
        grundkosten = getPts("Questoris Knight Styrix");

        add(ico = new oc.Picture("oc/wh40k/images/ChaosPredator.gif"));


        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Hellburner chieorovile", getPts("Hellburner chieorovile")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Graviton crusher", getPts("Graviton crusher")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Reaper chainsword", getPts("Reaper chainsword")));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));


        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
        o3.alwaysSelected();

        power = 24;
    }

}
