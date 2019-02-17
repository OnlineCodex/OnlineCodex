package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class ORBigGunz extends Eintrag {

	private final AnzahlPanel wummen;
	private final OptionsZaehlerGruppe FK2;
	private final int aktivesBild = 0;

    public ORBigGunz() {
        grundkosten = 0;

        add(ico = new oc.Picture("oc/wh40k/images/MegawummeKanonae.gif"));

        add(wummen = new AnzahlPanel(ID, randAbstand, cnt, "Big Gun", "Big Gunz", 1, 6, getPts("Big Gunz") + getPts("Grot gunners") * 2));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Kannon", getPts("Kannon")));
        ogE.addElement(new OptionsGruppeEintrag("Lobba", getPts("Lobba")));
        ogE.addElement(new OptionsGruppeEintrag("Zzap gun", getPts("Zzap gun")));
        add(FK2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));

        complete();

    }

    //@OVERRIDE
    public void refreshen() {
        FK2.setMaxAnzahl(wummen.getModelle());
        FK2.setLegal(FK2.getAnzahl() == wummen.getModelle());

        power = 1 + wummen.getModelle() * 1;
    }
}
