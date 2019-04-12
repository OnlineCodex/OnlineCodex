package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class ORMekboyJunka extends Eintrag {

	private final OptionsZaehlerGruppe o1;
	private final OptionsUpgradeGruppe o4;
	public ORMekboyJunka() {
        name = "Mekboy Junka";
        grundkosten = 65;


        add(ico = new oc.Picture("oc/wh40k/images/MekboyJunka.gif"));


        ogE.addElement(new OptionsGruppeEintrag("Reinforced Ram", 0));
        ogE.addElement(new OptionsGruppeEintrag("Deff Rolla", 0));
        ogE.addElement(new OptionsGruppeEintrag("Wreckin\' Ball", 0));
        ogE.addElement(new OptionsGruppeEintrag("Grabbin\' Klaw", 0));
        add(o4 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "\'Ard Case", 15));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "\'Eavy Plates", 20));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Big Shoota", 0));
        ogE.addElement(new OptionsGruppeEintrag("Skorcha", 0));
        ogE.addElement(new OptionsGruppeEintrag("Rokkit Launcha", 5));
        ogE.addElement(new OptionsGruppeEintrag("twin Big Shoota", "twin-linked Big Shoota", 10));
        ogE.addElement(new OptionsGruppeEintrag("twin Rokkit Launcha", "twin-linked Rokkit Launcha", 15));
        ogE.addElement(new OptionsGruppeEintrag("Kustom Mega-Blasta", 15));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Supa-Skorcha", 20));
        ogE.addElement(new OptionsGruppeEintrag("Big-Zzappa", 30));
        ogE.addElement(new OptionsGruppeEintrag("2 Grot Bomms", 30));
        ogE.addElement(new OptionsGruppeEintrag("Force Field Generator", "Junka Force Field Generator", 75));
        ogE.addElement(new OptionsGruppeEintrag("Shokk Attack Gun", "Junka Shokk Attack Gun", 100));
        ogE.addElement(new OptionsGruppeEintrag("Boom Gun", 70));
        add(new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        complete();

    }

    @Override
	public void refreshen() {
        o4.alwaysSelected();
        o1.setLegal(o1.getAnzahl() == o1.getMaxAnzahl());
    }
}
