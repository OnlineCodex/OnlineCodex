package oc.wh40k.units.da;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class DARavenwingBlackKnights extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsEinzelUpgrade ej;

	boolean added = false;

	public DARavenwingBlackKnights() {
		name = "Schwarze Ritter des Ravenwing";
		grundkosten = 0;

		add(ico = new oc.Picture("oc/wh40k/images/DADeathwingTerminatorSquad.gif"));

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Schwarze Ritter des Ravenwing", 3, 10, 40);
		add(squad);
		
		seperator();
        
		ogE.addElement(new OptionsGruppeEintrag("Granatwerfer", "Ravenwing-Granatwerfer", 0));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		add(ej = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "Erster Jäger", "Erster Jäger", 0));
		ej.setSelected(true);
		
		ogE.addElement(new OptionsGruppeEintrag("Corvus-Hammer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 12));
		ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 12));
		ogE.addElement(new OptionsGruppeEintrag("Energielaxt", 12));
		ogE.addElement(new OptionsGruppeEintrag("Energielanze", 12));
		ogE.addElement(new OptionsGruppeEintrag("Energiestreitkolben", 12));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "Melterbomben", "Melterbomben", 5));

		addToInformationVector("DASchwarzeRitterDesRavenwing", 1);
		
		seperator();
	}

	@Override
	public void refreshen() {
		int count = squad.getModelle();
		o1.setMaxAnzahl(count/3);
		if(!o2.isSelected()){
			o2.setSelected(0, true);
		}
		ej.setSelected(true);
		
		if(getCountFromInformationVector("Ravenwing Huntmasters")>0 && getCountFromInformationVector("DASchwarzeRitterDesRavenwing")>1){
			setFehlermeldung("max. 1");
		}else{
			setFehlermeldung("");
		}
	}

	@Override
	public void deleteYourself() {
		addToInformationVector("DASchwarzeRitterDesRavenwing", -1);
		super.deleteYourself();
	}

}
