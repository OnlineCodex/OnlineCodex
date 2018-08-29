package oc.wh40k.units.dk;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class DKQuartermasterCadre extends Eintrag {

	RuestkammerStarter rkTransport;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelZaehler oe2;
	OptionsZaehlerGruppe o1;

	public DKQuartermasterCadre() {
		name = "Death Korps Quartermaster Cadre";
		grundkosten = 55;

		add(ico = new oc.Picture("oc/wh40k/images/IGCompanyCommandSquad.jpg"));

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Quartermaster Revenant", 0));
		oe1.setSelected(true);
		
		//seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Melta bombs", 5));
		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 2));
		ogE.addElement(new OptionsGruppeEintrag("Power sword", 10));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));
		
		seperator();
		
		add(oe2 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Medicae-servitors", 4, 10));
		
		seperator();
		
		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "DKCentaur", "Centaur");
		rkTransport.initKammer();
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
		if(!oe1.isSelected()){
			oe1.setSelected(true);
		}
		
		if(oe2.getAnzahl()<2){
			oe2.setAnzahl(2);
		}
	}


}
