package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class ORGargantuanSquiggoth extends Eintrag {

	private final OptionsZaehlerGruppe ozg;
	private final OptionsZaehlerGruppe ozgX;

    public ORGargantuanSquiggoth() {
        name = "Gargantuan Squiggoth";
        power = 21;
        grundkosten = getPts("Gargantuan Squiggoth") +
                getPts("Twin big shoota") * 2;

        add(ico = new oc.Picture("oc/wh40k/images/GigantischerSquiggofant.gif"));


        ogE.addElement(new OptionsGruppeEintrag("supa-lobba", getPts("supa-lobba")));
        ozgX = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE);
        add(ozgX);
        ogE.addElement(new OptionsGruppeEintrag("Killkannon", getPts("killkannon")));
        ogE.addElement(new OptionsGruppeEintrag("Big zzappa", getPts("big zzappa")));
        ozg = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE);
        add(ozg);

        seperator();

        add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Big shoota", 4, getPts("big shoota")));

        complete();

    }

    @Override
	public void refreshen() {
        ozgX.setMaxAnzahl(2 - ozg.getAnzahl());
        ozgX.setAnzahl(0, 2 - ozg.getAnzahl());
        ozg.setMaxAnzahl(2);
    }
}
