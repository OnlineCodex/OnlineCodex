package oc.wh40k.units.da;

import oc.AnzahlPanel;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class DATechmarineKammer extends RuestkammerVater {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;

	public DATechmarineKammer() {
	}

	@Override
	public void initButtons(boolean... defaults) {
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Servitoren", 1, 5, 10);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/Servitoren.gif"));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 10));
    	ogE.addElement(new OptionsGruppeEintrag("Multimelter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 20));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		int maxAnzahl = 0;
		if(squad.getModelle() < 2){
			maxAnzahl = squad.getModelle();
		} else {
			maxAnzahl = 2;
		}
		
		o1.setMaxAnzahl(maxAnzahl);
	}
	
}
