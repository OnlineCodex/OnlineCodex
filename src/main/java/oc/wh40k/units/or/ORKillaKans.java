package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class ORKillaKans extends Eintrag {

	private final AnzahlPanel killabot;
	private final OptionsZaehlerGruppe killabotFK;
	private final OptionsZaehlerGruppe killabotNK;

    public ORKillaKans() {

        category = 5;
        grundkosten = 0;
        add(killabot = new AnzahlPanel(ID, randAbstand, cnt, "Killa Kan", "Killa Kans", 1, 6, getPts("Killa kans") + getPts("Kan klaw")));

        add(ico = new oc.Picture("oc/wh40k/images/Killabot.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Big shoota", getPts("Big shoota")));
        ogE.addElement(new OptionsGruppeEintrag("Rokkit launcha", getPts("Rokkit launcha")));
        ogE.addElement(new OptionsGruppeEintrag("Skorcha", getPts("skorcha")));
        ogE.addElement(new OptionsGruppeEintrag("Grotzooka", getPts("Grotzooka")));
        add(killabotFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Buzz saw", getPts("Buzz saw")));
        ogE.addElement(new OptionsGruppeEintrag("Kan klaw", getPts("Kan klaw")));
        ogE.addElement(new OptionsGruppeEintrag("Drilla", getPts("Drilla")));
        add(killabotNK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        complete();
    }

    //@OVERRIDE
    @Override
	public void refreshen() {
        killabotFK.setMaxAnzahl(killabot.getModelle());
        killabotFK.setLegal(killabot.getModelle() == killabotFK.getAnzahl());

        killabotNK.setMaxAnzahl(killabot.getModelle());
        killabotNK.setLegal(killabot.getModelle() == killabotNK.getAnzahl());

        if (killabot.getModelle() > 3) {
            power = 14;
        } else if (killabot.getModelle() > 1) {
            power = 7;
        } else {
            power = 2;
        }
    }
}
