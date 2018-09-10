package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class ORFlashGitz extends Eintrag {

	AnzahlPanel Gargbosse;
	OptionsZaehlerGruppe GargbosseFK;
	OptionsEinzelUpgrade captain;

	public ORFlashGitz() {

		grundkosten = 0;

		name = "Flash Gitz";
		
		add(Gargbosse = new AnzahlPanel(ID, randAbstand, cnt, "Flash Gitz", 5, 10, getPts("Flash Gitz") + getPts("Snazzgun") + getPts("Stikkbombs")));
		add(ico = new oc.Picture("oc/wh40k/images/Gargbosse.gif"));
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Ammo Runt", getPts("Ammo Runt")));
		add(GargbosseFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));

		seperator();
		
		add(captain = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Kaptin: Choppa + Slugga", getPts("Choppa") + getPts("Slugga")));
		captain.setSelected(true);
		
		complete();

	}

	
	//@OVERRIDE
	public void refreshen() {
		GargbosseFK.setMaxAnzahl(Gargbosse.getModelle());
		power = 7;
		if(Gargbosse.getModelle()>5){
			power = 13;
		}
	}
}
