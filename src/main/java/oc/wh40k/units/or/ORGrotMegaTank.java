package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class ORGrotMegaTank extends Eintrag {

	private final OptionsZaehlerGruppe o1, o2;

    public ORGrotMegaTank() {
        name = "Grot Mega Tank";
        grundkosten = getPts("Grot Mega Tank (FW)");
        power = 7;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Twin big Shoota", getPts("Twin big Shoota")));
        ogE.addElement(new OptionsGruppeEintrag("2 Skorchas", getPts("Skorcha") * 2));
        ogE.addElement(new OptionsGruppeEintrag("2 Grotzookas", getPts("Grotzooka") * 2));
        ogE.addElement(new OptionsGruppeEintrag("Rack of rokkits", getPts("Rack of rokkits")));
        ogE.addElement(new OptionsGruppeEintrag("2 Kustom Mega Blastas", getPts("Kustom Mega Blasta") * 2));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Big Shoota", getPts("Big Shoota")));
        ogE.addElement(new OptionsGruppeEintrag("Skorcha", getPts("Skorcha")));
        ogE.addElement(new OptionsGruppeEintrag("Grotzooka", getPts("Grotzooka")));
        ogE.addElement(new OptionsGruppeEintrag("Rokkit Launcha", getPts("Rokkit Launcha")));
        ogE.addElement(new OptionsGruppeEintrag("Kustom Mega Blasta", getPts("Kustom Mega Blasta")));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

        seperator();

        add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Shoota", 1, getPts("Shoota")));
        add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Boom kanister", 2, getPts("boom kanister")));
        add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "wreckin' ball", 1, getPts("wreckin' ball")));

        complete();
    }

    @Override
    public void refreshen() {
        o1.setLegal(o1.getAnzahl() == 2);
        o2.setLegal(o2.getAnzahl() == 3);
    }

}
