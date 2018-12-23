package oc.wh40k.units.or;

import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class ORDeffDreadKammer extends RuestkammerVater {

    private final OptionsZaehlerGruppe w1, w2, w1x, w2x;

    public ORDeffDreadKammer() {
        grundkosten = getPts("Deff Dreads");
        add(ico = new oc.Picture("oc/wh40k/images/IGLemanRuss.jpg"));

        ogE.addElement(new OptionsGruppeEintrag("Big shoota", getPts("Big shoota")));
        add(w1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
        ogE.addElement(new OptionsGruppeEintrag("Rokkit launcha", getPts("Rokkit launcha")));
        ogE.addElement(new OptionsGruppeEintrag("Skorcha", getPts("skorcha")));
        ogE.addElement(new OptionsGruppeEintrag("Kustom mega-blasta", getPts("Kustom mega-blasta")));
        ogE.addElement(new OptionsGruppeEintrag("Dread saw", getPts("dread saw")));
        add(w1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
        w1x.setAnzahl(0, 2);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Dread klaw", getPts("Dread klaw")));
        add(w2x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
        ogE.addElement(new OptionsGruppeEintrag("Rokkit launcha", getPts("Rokkit launcha")));
        ogE.addElement(new OptionsGruppeEintrag("Skorcha", getPts("skorcha")));
        ogE.addElement(new OptionsGruppeEintrag("Kustom mega-blasta", getPts("Kustom mega-blasta")));
        ogE.addElement(new OptionsGruppeEintrag("Dread saw", getPts("Dread saw")));
        add(w2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
        w2x.setAnzahl(0, 2);

        sizeSetzen();
    }

    @Override
    public void refreshen() {
    	w2x.setMaxAnzahl(2-w2.getAnzahl());
    	w2x.setAnzahl(0,2-w2.getAnzahl());
    	
    	w1x.setMaxAnzahl(2-w1.getAnzahl());
    	w1x.setAnzahl(0,2-w1.getAnzahl());
    }

}
