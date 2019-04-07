package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class CHChaosSpaceMarines extends Eintrag {

	private final AnzahlPanel marines;
	private final OptionsZaehlerGruppe o1;
	private final OptionsZaehlerGruppe o1x;

	private final OptionsZaehlerGruppe marinesfk;
	private final OptionsEinzelUpgrade pp;
	private final RuestkammerStarter Boss;
	private final OptionsUpgradeGruppe mark;
	private final OptionsUpgradeGruppe icon;

    public CHChaosSpaceMarines() {

        kategorie = 1;

        name = "Chaos Space Marines";
        grundkosten = 0;
        add(marines = new AnzahlPanel(ID, randAbstand, cnt, "Chaos Space Marines", 5, 20, getPts("Chaos Space Marines")));
        add(ico = new oc.Picture("oc/wh40k/images/Moschaboy.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun")));
        ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword")));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));
        o1x.setAnzahl(0, marines.getModelle() - 1);

        ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));

        add(pp = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Plasma pistol", getPts("Plasma pistol")));

        ogE.addElement(new OptionsGruppeEintrag("Flamer", getPts("Flamer")));
        ogE.addElement(new OptionsGruppeEintrag("Meltagun", getPts("Meltagun")));
        ogE.addElement(new OptionsGruppeEintrag("Plasma gun", getPts("Plasma gun")));
        ogE.addElement(new OptionsGruppeEintrag("Autocannon", getPts("Autocannon")));
        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", getPts("Heavy bolter")));
        ogE.addElement(new OptionsGruppeEintrag("Lascannon", getPts("Lascannon")));
        ogE.addElement(new OptionsGruppeEintrag("Missile launcher", getPts("Missile launcher")));
        ogE.addElement(new OptionsGruppeEintrag("Reaper Chaincannon", getPts("Reaper Chaincannon")));
        add(marinesfk = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Icon of Vengeance", getPts("Icon of Vengeance")));
        ogE.addElement(new OptionsGruppeEintrag("Icon of Wrath", getPts("Icon of Wrath")));
        ogE.addElement(new OptionsGruppeEintrag("Icon of Despair", getPts("Icon of Despair")));
        ogE.addElement(new OptionsGruppeEintrag("Icon of Flame", getPts("Icon of Flame")));
        ogE.addElement(new OptionsGruppeEintrag("Icon of Excess", getPts("Icon of Excess")));
        add(icon = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mark of Khorne", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
        add(mark = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        Boss = new RuestkammerStarter(ID, randAbstand, cnt, CHWaffenkammer.class, "Aspiring Champion");
        ((CHWaffenkammer) Boss.getKammer()).setChampion(true);
        Boss.initKammer(true, true, true, true);
        Boss.setGrundkosten(getPts("Aspiring Champion"));
        Boss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(Boss);
        Boss.setAbwaehlbar(false);

        complete();
    }


    @Override
    public void refreshen() {
        o1x.setMaxAnzahl(marines.getModelle() - (Boss.isSelected() ? 1 : 0) - marinesfk.getAnzahl());

        final int numberOfPistoles = marines.getModelle() - (Boss.isSelected() ? 1 : 0) - ((pp.isSelected()) ? 1 : 0);
        o1.setMaxAnzahl(numberOfPistoles);
        o1.setAnzahl(0, numberOfPistoles);

        if (marines.getModelle() <= 10) {
            marinesfk.setMaxAnzahl((marines.getModelle() / 5) - ((pp.isSelected()) ? 1 : 0));
        }

        power = 6 +
                ((marines.getModelle() == 10) ? 4 : 0) +
                ((marines.getModelle() == 15) ? 7 : 0) +
                ((marines.getModelle() == 20) ? 10 : 0);

        icon.setAktiv("Icon of Vengeance", !mark.isSelected());
        icon.setAktiv("Icon of Wrath", mark.isSelected("Mark of Khorne"));
        icon.setAktiv("Icon of Despair", mark.isSelected("Mark of Nurgle"));
        icon.setAktiv("Icon of Flame", mark.isSelected("Mark of Tzeentch"));
        icon.setAktiv("Icon of Excess", mark.isSelected("Mark of Slaanesh"));
    }
}
