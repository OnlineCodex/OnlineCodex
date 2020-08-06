package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class CHFallen extends Eintrag {

	private final AnzahlPanel squad;
	private final OptionsZaehlerGruppe pistol, claws, boltgun, special;
	private final OptionsUpgradeGruppe heavy;
	private final RuestkammerStarter champion;

    public CHFallen() {
        //name = "Auserkorene Chaos Space Marines\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Fallen", 5, 10, getPts("Fallen"));
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/ChaosSpaceMarines.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol")));
        add(pistol = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 4));
        pistol.setAnzahl(0, squad.getModelle() - 1);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun")));
        ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword")));
        add(boltgun = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));
        boltgun.setAnzahl(0, squad.getModelle() - 1);

        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol")));
        ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", getPts("Combi-bolter")));
        ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer")));
        ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta")));
        ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma")));
        ogE.addElement(new OptionsGruppeEintrag("Flamer", getPts("Flamer")));
        ogE.addElement(new OptionsGruppeEintrag("Meltagun", getPts("Meltagun")));
        ogE.addElement(new OptionsGruppeEintrag("Plasma gun", getPts("Plasma gun")));
        ogE.addElement(new OptionsGruppeEintrag("Chainaxe", getPts("Chainaxe")));
        ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword")));
        ogE.addElement(new OptionsGruppeEintrag("Lightning claw", getPts("Lightning claw single")));
        ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe")));
        ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist")));
        ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul")));
        ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword")));
        add(special = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 4));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Flamer", getPts("Flamer")));
        ogE.addElement(new OptionsGruppeEintrag("Meltagun", getPts("Meltagun")));
        ogE.addElement(new OptionsGruppeEintrag("Plasma gun", getPts("Plasma gun")));
        ogE.addElement(new OptionsGruppeEintrag("Autocannon", getPts("Autocannon")));
        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", getPts("Heavy bolter (INFANTRY)")));
        ogE.addElement(new OptionsGruppeEintrag("Lascannon", getPts("Lascannon (INFANTRY)")));
        ogE.addElement(new OptionsGruppeEintrag("Missile launcher", getPts("Missile launcher (INFANTRY)")));
        add(heavy = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Lightning claws", getPts("Lightning claw pair")));
        add(claws = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 4));

        seperator();

        champion = new RuestkammerStarter(ID, randAbstand, cnt, CHWaffenkammer.class, "Fallen Champion", 1);
        ((CHWaffenkammer) champion.getKammer()).setChampion(true);
        ((CHWaffenkammer) champion.getKammer()).setDefaultRanged("Boltgun");
        ((CHWaffenkammer) champion.getKammer()).setDefaultCloceCombat("Bolt pistol");
        champion.initKammer(true, true, true, true);
        champion.setUeberschriftTrotzNullKostenAusgeben(true);
        add(champion);
        champion.setAbwaehlbar(false);

        complete();
    }

    @Override
    public void refreshen() {

        final int boltguns = squad.getModelle() - 1 - special.getAnzahl() - claws.getAnzahl() - ((heavy.isSelected()) ? 1 : 0);
        boltgun.setMaxAnzahl(boltguns);

        final int pistols = squad.getModelle() - 1 - claws.getAnzahl() - special.getAnzahl("Plasma pistol");
        pistol.setMaxAnzahl(pistols);

        heavy.setAktiv((boltguns + ((heavy.isSelected()) ? 1 : 0)) > 0);

        special.setMaxAnzahl(4 - claws.getAnzahl() - ((heavy.isSelected()) ? 1 : 0));
        claws.setMaxAnzahl(4 - special.getAnzahl() - ((heavy.isSelected()) ? 1 : 0));

        power = 6 + ((squad.getModelle() == 10) ? 4 : 0);
    }
}
