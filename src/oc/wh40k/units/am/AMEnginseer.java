package oc.wh40k.units.am;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class AMEnginseer extends Eintrag {

	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2;
	RuestkammerStarter tr1;

	public AMEnginseer() {
		name = "Maschinenseher";
		grundkosten = 40;
		this.setEintragsCNT(0);

		addToInformationVector("AMEnginseer", 1);

		add(ico = new oc.Picture("oc/wh40k/images/IGTechpriestEnginseer.jpg"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand + 10, cnt, "", "Melterbomben", 5));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Servitor", 10));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 15));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();
		
		tr1 = new RuestkammerStarter(ID, randAbstand, cnt, "AMTrojan", "Trojan");
		tr1.initKammer();
		add(tr1);
		
		addToInformationVector("IGMaschinenseher", 1);
		
		complete();
	}

	@Override
	public void refreshen() {
		
		if(getCountFromInformationVector("AMTakesHQSlot")>0 || getCountFromInformationVector("Grand Convocation Detachement")>0){
			this.setEintragsCNT(1);
		}
		
		if(getCountFromInformationVector("AMEnginseer") > 3) {
			setFehlermeldung("0-3 Auswahl!");
		} else {
			setFehlermeldung("");
		}

		o2.setMaxAnzahl( o1.getAnzahl() > 2 ? 2 : o1.getAnzahl() );
	}

	@Override
	public void deleteYourself() {
		addToInformationVector("AMEnginseer", -1);
	}

}
