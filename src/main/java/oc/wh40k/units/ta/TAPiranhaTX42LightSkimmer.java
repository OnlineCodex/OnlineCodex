package oc.wh40k.units.ta;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class TAPiranhaTX42LightSkimmer extends Eintrag {

	private final AnzahlPanel squad;
	private final OptionsZaehlerGruppe o4;

    public TAPiranhaTX42LightSkimmer() {
        name = "Piranha TX-42 Light Skimmer";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Piranha", "Piranhas", 1, 5, getPts("Piranha TX-42 Light Skimmer"));
        add(squad);

        seperator();

        add(ico = new oc.Picture("oc/wh40k/images/PiranhaSchweberteam.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Fusion blaster", getPts("Fusion blaster")*2));
        ogE.addElement(new OptionsGruppeEintrag("2 Missile pods", getPts("Missile pod")*2));
        ogE.addElement(new OptionsGruppeEintrag("2 Plasma rifles", getPts("Plasma rifle")*2));
        ogE.addElement(new OptionsGruppeEintrag("2 Rail rifles", getPts("Rail rifle")*2));
        add(o4 = new OptionsZaehlerGruppe(0, randAbstand, cnt, "", ogE, 1));
        o4.setAnzahl(0, 1);
        
        seperator(5);

        complete();
    }

    @Override
    public void refreshen() {

        o4.setMaxAnzahl(squad.getModelle());
        if (o4.getAnzahl() < squad.getModelle()) {
            o4.setLegal(false);
        } else {
            o4.setLegal(true);
        }

        power = 5 * squad.getModelle() + 1;
    }

    @Override
    public void deleteYourself() {
    }

}
