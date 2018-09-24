package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class IMAllarusCustodians extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1, o2;
	OptionsZaehlerGruppe o3;
	
	public IMAllarusCustodians() {
		name = "Allarus Custodians\n";
		grundkosten = 0;
		überschriftSetzen = true;
		

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Allarus Custodians", 3, 10, getPts("Allarus Custodians"));
		add(squad);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Castellan axe", getPts("Castellan axe")));
		ogE.addElement(new OptionsGruppeEintrag("Guardian Spear", getPts("Guardian spear (AC)")));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setAnzahl(0, squad.getModelle());
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Balistus grenade launcher", getPts("Balistus grenade launcher")));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
		o3.setAnzahl(0, squad.getModelle());
		
		seperator();
        
		ogE.addElement(new OptionsGruppeEintrag("Misericordia", getPts("Misericordia")));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
		
		complete();
	}

	@Override
	public void refreshen() {
		o1.setMaxAnzahl(squad.getModelle());
		o2.setMaxAnzahl(squad.getModelle());
		
		o1.setLegal(squad.getModelle() == o1.getAnzahl());
		
		power = 13 + ((squad.getModelle()-3)*5);
		
		o3.setMaxAnzahl(squad.getModelle());
		o3.setAnzahl(0, squad.getModelle());
	}
}
