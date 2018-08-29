package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class IMVertusPraetors extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1, o2;
	OptionsZaehlerGruppe o3;
	
	public IMVertusPraetors() {
		name = "Vertus Praetors\n";
		grundkosten = 0;
		überschriftSetzen = true;
		

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Vertus Praetors", 3, 10, getPts("Vertus Praetors"));
		add(squad);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Hurrican bolter", getPts("Hurrican bolter (AC)")));
		ogE.addElement(new OptionsGruppeEintrag("Salvo launcher", getPts("Salvo launcher")));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setAnzahl(0, squad.getModelle());
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Interceptor lance", getPts("Interceptor lance")));
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
		
		power = 15 + ((squad.getModelle()-3)*5);
		
		o3.setMaxAnzahl(squad.getModelle());
		o3.setAnzahl(0, squad.getModelle());
	}
}
