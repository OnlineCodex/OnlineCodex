package oc.wh40k.units.or;

import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class ORDeffDreadKammer extends RuestkammerVater {

	OptionsZaehlerGruppe w1, w2;

	public ORDeffDreadKammer() {
		grundkosten = getPts("Deff Dreads");
	}

	@Override
	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/IGLemanRuss.jpg"));
		
		ogE.addElement(new OptionsGruppeEintrag("Big shoota", getPts("Big shoota")));
		ogE.addElement(new OptionsGruppeEintrag("Rokkit launcha", getPts("Rokkit launcha")));
		ogE.addElement(new OptionsGruppeEintrag("Skorcha", getPts("skorcha")));
		ogE.addElement(new OptionsGruppeEintrag("Kustom mega-blasta", getPts("Kustom mega-blasta")));
		ogE.addElement(new OptionsGruppeEintrag("Dread saw", getPts("dread saw")));
		add(w1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
		w1.setAnzahl(0, 2);
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Dread klaw", getPts("Dread klaw")));
		ogE.addElement(new OptionsGruppeEintrag("Rokkit launcha", getPts("Rokkit launcha")));
		ogE.addElement(new OptionsGruppeEintrag("Skorcha", getPts("skorcha")));
		ogE.addElement(new OptionsGruppeEintrag("Kustom mega-blasta", getPts("Kustom mega-blasta")));
		ogE.addElement(new OptionsGruppeEintrag("Dread saw", getPts("Dread saw")));
		add(w2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
		w2.setAnzahl(0, 2);
		
		sizeSetzen();
	}

	@Override
	public void refreshen() {
	  
	}

}
