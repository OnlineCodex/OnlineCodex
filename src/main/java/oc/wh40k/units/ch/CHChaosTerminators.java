package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class CHChaosTerminators extends Eintrag {

	private final AnzahlPanel marines;
	private final OptionsZaehlerGruppe combi;
	private final OptionsZaehlerGruppe melee;
	private final OptionsZaehlerGruppe claws;

	private final OptionsZaehlerGruppe heavy;
	private final RuestkammerStarter Boss;
	private final OptionsUpgradeGruppe mark;
	private final OptionsUpgradeGruppe icon;

    public CHChaosTerminators() {

        kategorie = 1;

        name = "Chaos Terminators";
        grundkosten = 0;
        add(marines = new AnzahlPanel(ID, randAbstand, cnt, "Chaos Terminators", 5, 10, getPts("Chaos Terminators")));
        add(ico = new oc.Picture("oc/wh40k/images/Moschaboy.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", getPts("Combi-Bolter")));
        ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer")));
        ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta")));
        ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma")));
        add(combi = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));
        combi.setAnzahl(0, marines.getModelle() - 1);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Chainaxe", getPts("Chainaxe")));
        ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe")));
        ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe")));
        ogE.addElement(new OptionsGruppeEintrag("Chainfist", getPts("Chainfist")));
        ogE.addElement(new OptionsGruppeEintrag("Lightning claw", getPts("Lightning claw single")));
        ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist")));
        ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul")));
        ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword")));
        add(melee = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));
        melee.setAnzahl(0, marines.getModelle() - 1);

        ogE.addElement(new OptionsGruppeEintrag("Lightning claws", getPts("Lightning claw pair")));
        add(claws = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));

        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", getPts("Heavy flamer")));
        ogE.addElement(new OptionsGruppeEintrag("Reaper autocannon", getPts("Reaper autocannon")));
        add(heavy = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

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

        Boss = new RuestkammerStarter(ID, randAbstand, cnt, CHWaffenkammer.class, "Terminator Champion");
        ((CHWaffenkammer) Boss.getKammer()).setTerminatorArmour(true);
        ((CHWaffenkammer) Boss.getKammer()).setChampion(true);
        ((CHWaffenkammer) Boss.getKammer()).setDefaultRanged("Combi-bolter");
        ((CHWaffenkammer) Boss.getKammer()).setDefaultCloceCombat("Power axe");
        Boss.initKammer(true, true, true, true);
        Boss.setGrundkosten(getPts("Terminator Champion"));
        Boss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(Boss);
        Boss.setAbwaehlbar(false);

        complete();
    }


    @Override
    public void refreshen() {
        combi.setMaxAnzahl(marines.getModelle() - 1 - claws.getAnzahl() - heavy.getAnzahl());
        melee.setMaxAnzahl(marines.getModelle() - 1 - claws.getAnzahl());
        heavy.setMaxAnzahl(marines.getModelle() / 5);

        power = 10 +
                ((marines.getModelle() == 10) ? 14 : 0);

        icon.setAktiv("Icon of Vengeance", !mark.isSelected());
        icon.setAktiv("Icon of Wrath", mark.isSelected("Mark of Khorne"));
        icon.setAktiv("Icon of Despair", mark.isSelected("Mark of Nurgle"));
        icon.setAktiv("Icon of Flame", mark.isSelected("Mark of Tzeentch"));
        icon.setAktiv("Icon of Excess", mark.isSelected("Mark of Slaanesh"));
    }
}
