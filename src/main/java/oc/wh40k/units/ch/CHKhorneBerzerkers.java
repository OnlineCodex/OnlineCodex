package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class CHKhorneBerzerkers extends Eintrag {

	private final AnzahlPanel marines;
	private final OptionsZaehlerGruppe o1;
	private final OptionsZaehlerGruppe o1x;

	private final OptionsZaehlerGruppe marinesfk;
	private final RuestkammerStarter Boss;

    public CHKhorneBerzerkers() {

        kategorie = 1;

        name = "Khorne Berzerkers";
        grundkosten = 0;
        add(marines = new AnzahlPanel(ID, randAbstand, cnt, "Khorne Berzerkers", 5, 20, getPts("Khorne Berzerkers")));
        add(ico = new oc.Picture("oc/wh40k/images/Moschaboy.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword")));
        ogE.addElement(new OptionsGruppeEintrag("Chainaxe", getPts("Chainaxe")));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));
        o1x.setAnzahl(0, marines.getModelle() - 1);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol")));
        ogE.addElement(new OptionsGruppeEintrag("Chainaxe", getPts("Chainaxe")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));
        o1.setAnzahl(0, marines.getModelle() - 1);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol")));
        add(marinesfk = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Icon of Wrath", getPts("Icon of Wrath")));

        seperator();

        Boss = new RuestkammerStarter(ID, randAbstand, cnt, CHWaffenkammer.class, "Berzerker Champion");
        ((CHWaffenkammer) Boss.getKammer()).setChampion(true);
        ((CHWaffenkammer) Boss.getKammer()).setDefaultRanged("Bolt pistole");
        ((CHWaffenkammer) Boss.getKammer()).setDefaultCloceCombat("Chainsword");
        Boss.initKammer(true, true, true, true);
        Boss.setGrundkosten(getPts("Berzerker Champion"));
        Boss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(Boss);
        Boss.setAbwaehlbar(false);

        complete();
    }


    @Override
    public void refreshen() {
        o1x.setMaxAnzahl(marines.getModelle() - (Boss.isSelected() ? 1 : 0) - marinesfk.getAnzahl());

        final int numberOfPistoles = marines.getModelle() - (Boss.isSelected() ? 1 : 0) - marinesfk.getAnzahl();
        o1.setMaxAnzahl(numberOfPistoles);

        marinesfk.setMaxAnzahl(2);

        power = 5 +
                ((marines.getModelle() == 10) ? 5 : 0) +
                ((marines.getModelle() == 15) ? 10 : 0) +
                ((marines.getModelle() == 20) ? 15 : 0);
    }
}
