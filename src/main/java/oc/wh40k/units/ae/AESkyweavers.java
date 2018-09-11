package oc.wh40k.units.ae;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class AESkyweavers extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1, o2;
	
	public AESkyweavers() {
		name = "Skyweavers";
		grundkosten = 0;
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Skyweavers", 2, 6, getPts("Skyweavers"));
		add(squad);

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Star bolas", getPts("Star bolas")));
		ogE.addElement(new OptionsGruppeEintrag("Zephyrglaive", getPts("Zephyrglaive")));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Shuriken cannon", getPts("Shuriken cannon (Harlequins)")));
		ogE.addElement(new OptionsGruppeEintrag("Haywire cannon", getPts("Haywire cannon")));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		complete();
	}

	@Override
	public void refreshen() {
		o1.setMaxAnzahl(squad.getModelle());
		o2.setMaxAnzahl(squad.getModelle());
		
		if(squad.getModelle() > 4){
			power = 15;
		} else if(squad.getModelle() > 2){
			power = 10;
		} else{
			power = 5;
		}
	}

}
