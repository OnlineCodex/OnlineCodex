package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class ORMekGunz extends Eintrag {

    AnzahlPanel wummen;
    OptionsZaehlerGruppe fk2;
    int aktivesBild = 0;

    public ORMekGunz() {
        grundkosten = 0;

        add(ico = new oc.Picture("oc/wh40k/images/MegawummeKanonae.gif"));


        add(wummen = new AnzahlPanel(ID, randAbstand, cnt, "Mek Gun", "Mek Gunz", 1, 6, getPts("Mek Gunz")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Bubblechukka", getPts("Bubblechukka")));
        ogE.addElement(new OptionsGruppeEintrag("Kustom mega-kannon", getPts("Kustom mega-kannon")));
        ogE.addElement(new OptionsGruppeEintrag("Smasha gun", getPts("Smasha gun")));
        ogE.addElement(new OptionsGruppeEintrag("Traktor kannon", getPts("Traktor kannon")));
        add(fk2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
        fk2.setAnzahl(1, 1);

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        fk2.setMaxAnzahl(wummen.getModelle());
        fk2.setLegal(fk2.getAnzahl() == wummen.getModelle());

        power = wummen.getModelle() * 2;

    }
}
