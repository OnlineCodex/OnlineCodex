package oc.wh40k.units.ab;

import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class ABSquadSergeant extends RuestkammerVater {

    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o3;
    OptionsZaehlerGruppe o2;

	public ABSquadSergeant() {
		grundkosten = 0;
	}

    @Override
	public void initButtons(boolean... defaults) {
    	ogE.addElement(new OptionsGruppeEintrag("Laspistol", 0));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
    	ogE.addElement(new OptionsGruppeEintrag("Close combat weapon", 0));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 2));
		ogE.addElement(new OptionsGruppeEintrag("Power sword", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE,0));

		o2.setAnzahl(0, 1);
		o3.setAnzahl(0, 1);

		sizeSetzen();
	}

    @Override
	public void refreshen() {
    	o1.setMaxAnzahl(2-o3.getAnzahl()-o2.getAnzahl());
    	
    	o1.setLegal((o1.getAnzahl()+o2.getAnzahl()+o3.getAnzahl())==2);
    	o2.setLegal((o1.getAnzahl()+o2.getAnzahl()+o3.getAnzahl())==2);
    	o3.setLegal((o1.getAnzahl()+o2.getAnzahl()+o3.getAnzahl())==2);
	}

}
