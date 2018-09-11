
package oc.wh40k.units.cm;

import oc.AnzahlPanel;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class CMAuserkoreneThousandSons extends RuestkammerVater {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o2;
        RuestkammerStarter t;
        OptionsEinzelUpgrade o1;

	public CMAuserkoreneThousandSons() {
            grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
            name = "Auserkorene Thousand Sons";
            grundkosten = 0;

            squad = new AnzahlPanel(ID, randAbstand, cnt, "Aufstrebende Hexer", 5, 10, 60);
            add(squad);

            add(ico = new oc.Picture("oc/wh40k/images/ChosenChaosSpaceMarines.gif"));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Strahl des Verderbens", 10));
            ogE.addElement(new OptionsGruppeEintrag("Warpzeit", 25));
            ogE.addElement(new OptionsGruppeEintrag("Chaoswind", 30));
            ogE.addElement(new OptionsGruppeEintrag("Geschenk des Chaos", 30));
            ogE.addElement(new OptionsGruppeEintrag("Blitz des Tzeentch", 25));
            add(o2 = new OptionsZaehlerGruppe(0, randAbstand, cnt, "", ogE, 5));

            seperator();

            add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Mal des Tzeentch", 0));

            seperator();

            t = new RuestkammerStarter(ID, randAbstand, cnt, "CMTransporter", "Transporter", 1);
            t.initKammer();
            t.setButtonText("Transporter");
            add(t);

            sizeSetzen();
	}

	@Override
	public void refreshen() {
            o1.setSelected(true);
            o2.setMaxAnzahl(squad.getModelle());
            o2.setLegal(o2.getAnzahl() == o2.getMaxAnzahl());
	}

}
