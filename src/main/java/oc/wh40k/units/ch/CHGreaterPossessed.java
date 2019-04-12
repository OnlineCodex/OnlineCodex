package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHGreaterPossessed extends Eintrag {

	private final AnzahlPanel marines;
	public CHGreaterPossessed() {

        category = 1;

        name = "Greater Possessed";
        grundkosten = 0;
        add(marines = new AnzahlPanel(ID, randAbstand, cnt, "Greater Possessed", 1, 2, getPts("Greater Possessed") + getPts("Daemonic mutations")));
        add(ico = new oc.Picture("oc/wh40k/images/Moschaboy.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mark of Khorne", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
        add(new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        complete();
    }


    @Override
    public void refreshen() {

        power = 4 +
                ((marines.getModelle() == 2) ? 4 : 0);
    }
}
