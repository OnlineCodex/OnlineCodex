package oc.wh40k.units.am;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class AMRapierCarrierwithLaserDestroyer extends Eintrag {

	OptionsZaehlerGruppe o2;
        AnzahlPanel squad;

	public AMRapierCarrierwithLaserDestroyer() {
                name = "Rapier Carrier with Laser Destroyer";
                grundkosten = 0;                
                
		add(ico = new oc.Picture("oc/wh40k/images/IGChimera.jpg"));
		
		add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Rapier", "Rapiers", 1, 3, 45));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Additional Crewman", 8));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
                
		complete();
	}

	// @OVERRIDE
	public void refreshen() {
            o2.setMaxAnzahl(squad.getModelle());
	}

}
