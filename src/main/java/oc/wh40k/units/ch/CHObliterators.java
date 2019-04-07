package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHObliterators extends Eintrag {

	private final AnzahlPanel marines;
	private final OptionsUpgradeGruppe mark;

    public CHObliterators() {

        kategorie = 1;

        name = "Obliterators";
        grundkosten = 0;
        add(marines = new AnzahlPanel(ID, randAbstand, cnt, "Obliterators", 1, 3, getPts("Obliterators") + getPts("Fleshmetal guns") + getPts("Crushing fists")));
        add(ico = new oc.Picture("oc/wh40k/images/Moschaboy.gif"));

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

        power = 6 * marines.getModelle();
    }
}
