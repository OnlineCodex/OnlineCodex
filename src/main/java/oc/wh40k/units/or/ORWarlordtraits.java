package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class ORWarlordtraits extends Eintrag {
	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe fk1;
	OptionsZaehlerGruppe fk2;
	AnzahlPanel squad;
	
	public ORWarlordtraits() {
		name = "Warlord Traits";
		grundkosten = 0;
		power = 0;

		ogE.addElement(new OptionsGruppeEintrag("Mir nach, Boyz!", getPts("")));
		ogE.addElement(new OptionsGruppeEintrag("Grosswildjäga", getPts("")));
		ogE.addElement(new OptionsGruppeEintrag("Zäh wie Suqigleda", getPts("")));
		ogE.addElement(new OptionsGruppeEintrag("Brutal, aba Kläva", getPts("")));
		ogE.addElement(new OptionsGruppeEintrag("Kläva, aber Brutal", getPts("")));
		ogE.addElement(new OptionsGruppeEintrag("Might is Right", getPts("")));
		
		ogE.addElement(new OptionsGruppeEintrag("Bad Moons: Da bestä Rüstung wo man für Zähnä kauf'n kann", getPts("")));
		ogE.addElement(new OptionsGruppeEintrag("Blood Axes: Ich hab 'ne Idee Boyz!", getPts("")));
		ogE.addElement(new OptionsGruppeEintrag("Deathskull: Opportunist", getPts("")));
		ogE.addElement(new OptionsGruppeEintrag("Freebooterz: Heftiga Ruf", getPts("")));
		ogE.addElement(new OptionsGruppeEintrag("Goofs: Übelst Moschig", getPts("")));
		ogE.addElement(new OptionsGruppeEintrag("Snakebites: Mürrisch wie'n Squigoth", getPts("")));
		add(fk1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		this.eintragsCNT = 0;
		
		complete();
	}

	//@OVERRIDE
	public void refreshen() {
		fk1.alwaysSelected();
	}
}
