package oc.wh40k.units.cd;


import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class CDSeuchendrohnen extends Eintrag {

	AnzahlPanel CDSeuchendrohnen;
	OptionsEinzelUpgrade Seuchenbringer, Chaosikone, Standarte;
	OptionsZaehlerGruppe o1,o2;
	OptionsUpgradeGruppe Totenkoepfe, o3;

	public CDSeuchendrohnen() {

		name = "Seuchendrohnen";

		grundkosten = 0;

		CDSeuchendrohnen = new AnzahlPanel(ID, randAbstand, cnt, "Seuchendrohnen", 3, 9, 42);

		add(CDSeuchendrohnen);

		add(ico = new oc.Picture("oc/wh40k/images/CDSeuchendrohnen.gif"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Instrument des Chaos", 10));
		add(Chaosikone = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ikone des Chaos", 15));
		add(Standarte  = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Seuchenbanner", 25));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Totenköpfe", "Totenköpfe", 5));
		add(Totenkoepfe = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Giftstachel", "Giftstachel", 5));
		ogE.addElement(new OptionsGruppeEintrag("Faulrüssel", "Faulrüssel", 5));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();

		add(Seuchenbringer = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Seuchenbringer", 5));
		
		ogE.addElement(new OptionsGruppeEintrag("Geringe Belohnung", 10));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));
		ogE.addElement(new OptionsGruppeEintrag("Mächtige Belohnung", 20));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 1));

		seperator();

		complete();

	}

	@Override
	public void refreshen() {	
		Standarte.setAktiv(Chaosikone.isSelected());
		o1.setAktiv(Seuchenbringer.isSelected());
		o2.setAktiv(Seuchenbringer.isSelected());
		
		if(o1.getAnzahl() > 0) {
			o2.setMaxAnzahl(0);
		} else {
			o2.setMaxAnzahl(1);
		}
		
		if(o2.getAnzahl() > 0) {
			o1.setMaxAnzahl(0);
		} else {
			o1.setMaxAnzahl(2);
		}
		
		int count = CDSeuchendrohnen.getModelle();
		Totenkoepfe.setPreis("Totenköpfe", 5 * count);
		o3.setPreis("Giftstachel", 5 * count);
		o3.setPreis("Faulrüssel", 5 * count);
	}
}
