package oc.wh40k.units.ch;


import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class CHChaosCultists extends Eintrag {

	private final AnzahlPanel kultisten;
	private final RuestkammerStarter champion;
	private final OptionsZaehlerGruppe schwereWaffe;
	private final OptionsZaehlerGruppe autogewehre, pistol;
	public CHChaosCultists() {
        //name = "Chaoskultisten\n";
        grundkosten = 0;

        kultisten = new AnzahlPanel(ID, randAbstand, cnt, "Chaos Cultists", 10, 40, getPts("Chaos Cultists"));
        add(kultisten);

        add(ico = new oc.Picture("oc/wh40k/images/ChaosKultisten.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Autogun", "Autogun", getPts("Autogun")));
        add(autogewehre = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        ogE.addElement(new OptionsGruppeEintrag("Pistol & Weapon", "Autopistol and brutal assault weapon", getPts("Auto pistol") + getPts("Brutal assault weapon")));
        add(pistol = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", getPts("Heavy stubber")));
        ogE.addElement(new OptionsGruppeEintrag("Flamer", getPts("Flamer")));
        schwereWaffe = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1);
        add(schwereWaffe);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mark of Khorne", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
        add(new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        seperator();

        champion = new RuestkammerStarter(ID, randAbstand, cnt, CHCultistkammer.class, "Champion");
        champion.initKammer(false);
        champion.setUeberschriftTrotzNullKostenAusgeben(true);
        champion.setGrundkosten(getPts("Cultist Champion"));
        add(champion);
        champion.setAbwaehlbar(false);

        seperator(0);

        complete();
    }

    @Override
    public void refreshen() {
        final int count = kultisten.getModelle();

        schwereWaffe.setMaxAnzahl(count / 10);

        final int subtractor = schwereWaffe.getAnzahl() + 1; // last one is the boss

        autogewehre.setMaxAnzahl(kultisten.getModelle() - subtractor);
        pistol.setMaxAnzahl(kultisten.getModelle() - subtractor);
        autogewehre.setAnzahl(0, count - subtractor - pistol.getAnzahl());

        power = 3 +
                ((kultisten.getModelle() == 20) ? 3 : 0) +
                ((kultisten.getModelle() == 20) ? 6 : 0) +
                ((kultisten.getModelle() == 30) ? 9 : 0);
    }
}
