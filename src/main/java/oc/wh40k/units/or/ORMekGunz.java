package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class ORMekGunz extends Eintrag {

	AnzahlPanel wummen;
	OptionsZaehlerGruppe FK2;

	public ORMekGunz() {
        grundkosten = 0;

        add(ico = new oc.Picture("oc/wh40k/images/MegawummeKanonae.gif"));
		

        add(wummen = new AnzahlPanel(ID, randAbstand, cnt, "Mek Gun","Mek Gunz", 1, 6, getPts("Mek Gunz") + getPts("Grot gunners") * 5));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Bubblechukka", getPts("Bubblechukka")));
		ogE.addElement(new OptionsGruppeEintrag("Kustom mega-kannon", getPts("Kustom mega-kannon")));
		ogE.addElement(new OptionsGruppeEintrag("Smasha gun", getPts("Smasha gun")));
		ogE.addElement(new OptionsGruppeEintrag("Traktor kannon", getPts("Traktor kannon")));
		add(FK2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
		FK2.setAnzahl(1, 1);
		
		complete();
	}
	int aktivesBild = 0;

	//@OVERRIDE
	public void refreshen() {
		FK2.setMaxAnzahl(wummen.getModelle());
		FK2.setLegal(FK2.getAnzahl() == wummen.getModelle());

		power = 1 + wummen.getModelle() * 2;
		
	}
}
