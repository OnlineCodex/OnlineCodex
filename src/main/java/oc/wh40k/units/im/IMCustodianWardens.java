package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class IMCustodianWardens extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	
	public IMCustodianWardens() {
		name = "Custodian Warden\n";
		grundkosten = 0;
		überschriftSetzen = true;
		

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Custodian Warden", 3, 10, getPts("Custodian Wardens") + getPts("Misericordia"));
		add(squad);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Guardian Spear", getPts("Guardian spear (AC)")));
		ogE.addElement(new OptionsGruppeEintrag("Castellan Axe", getPts("Castellan axe")));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setAnzahl(0, squad.getModelle());
		
		complete();
	}

	@Override
	public void refreshen() {
		o1.setMaxAnzahl(squad.getModelle());
		o1.setLegal(squad.getModelle() == o1.getAnzahl());
		
		power = 10 + ((squad.getModelle()-3)*4);
	}
}
