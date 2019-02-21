package oc.wh40k.units.or;

import oc.*;

public class ORKustomBattleFortress extends Eintrag {

	private final OptionsZaehlerGruppe o1;
	private final OptionsEinzelZaehler grotbomm;
	private final OptionsEinzelZaehler suparokkit;

    public ORKustomBattleFortress() {
        name = "\'Kustom\' Battle Fortress";
        grundkosten = 355;


        add(ico = new oc.Picture("oc/wh40k/images/ORKustomBattleFortress.gif"));


        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "\'Ard Case", 25));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Boarding plank", 10));
        add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Grot Sponson", 4, 5));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Grabbin\' Klaw", 15));
        ogE.addElement(new OptionsGruppeEintrag("Wreckin\' Ball", 15));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(grotbomm = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Grot Bomm", 3, 20));
        add(suparokkit = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Supa-Rokkit", 3, 15));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Big Shoota", 5));
        ogE.addElement(new OptionsGruppeEintrag("Skorcha", 5));
        ogE.addElement(new OptionsGruppeEintrag("Rokkit Launcha", 10));
        ogE.addElement(new OptionsGruppeEintrag("twin Big Shoota", "twin-linked Big Shoota", 15));
        ogE.addElement(new OptionsGruppeEintrag("twin Rokkit Launcha", "twin-linked Rokkit Launcha", 20));
        add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Lobba", 0));
        ogE.addElement(new OptionsGruppeEintrag("Zzap gun", 0));
        ogE.addElement(new OptionsGruppeEintrag("Kannon", 0));
        ogE.addElement(new OptionsGruppeEintrag("Big-lobba", 25));
        ogE.addElement(new OptionsGruppeEintrag("Big-zzappa", 30));
        ogE.addElement(new OptionsGruppeEintrag("Killkannon", 35));
        ogE.addElement(new OptionsGruppeEintrag("Flakka-gun", 35));
        ogE.addElement(new OptionsGruppeEintrag("Supa-lobba", 45));
        ogE.addElement(new OptionsGruppeEintrag("Supa-kannon", 65));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

        complete();

    }

    public void refreshen() {
        o1.setLegal(o1.getAnzahl() == o1.getMaxAnzahl());

        if (grotbomm.isSelected()) {
            suparokkit.setAktiv(false);
        } else {
            suparokkit.setAktiv(true);
        }

        if (suparokkit.isSelected()) {
            grotbomm.setAktiv(false);
        } else {
            grotbomm.setAktiv(true);
        }
    }
}
