package oc.wh40k.units.ch;

import oc.*;

public class CHChosen extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe pistol, claws, boltgun, special;
    OptionsUpgradeGruppe heavy;
    OptionsUpgradeGruppe icon;
    RuestkammerStarter champion;
    OptionsUpgradeGruppe mark;

    public CHChosen() {
        //name = "Auserkorene Chaos Space Marines\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Chosen", 5, 10, getPts("Chosen"));
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
        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", getPts("Heavy bolter")));
        ogE.addElement(new OptionsGruppeEintrag("Lascannon", getPts("Lascannon")));
        ogE.addElement(new OptionsGruppeEintrag("Missile launcher", getPts("Missile launcher")));
        add(heavy = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Lightning claws", getPts("Lightning claw pair")));
        add(claws = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 4));

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

        champion = new RuestkammerStarter(ID, randAbstand, cnt, CHWaffenkammer.class, "Chosen Champion", 1);
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

        int boltguns = squad.getModelle() - 1 - special.getAnzahl() - claws.getAnzahl() - ((heavy.isSelected()) ? 1 : 0);
        boltgun.setMaxAnzahl(boltguns);

        int pistols = squad.getModelle() - 1 - claws.getAnzahl() - special.getAnzahl("Plasma pistol");
        pistol.setMaxAnzahl(pistols);

        heavy.setAktiv((boltguns + ((heavy.isSelected()) ? 1 : 0)) > 0);

        special.setMaxAnzahl(4 - claws.getAnzahl());
        claws.setMaxAnzahl(4 - special.getAnzahl() - ((heavy.isSelected()) ? 1 : 0));

        power = 8 +
                ((squad.getModelle() == 10) ? 5 : 0);
        
        icon.setAktiv("Icon of Vengeance", !mark.isSelected());
        icon.setAktiv("Icon of Wrath", mark.isSelected("Mark of Khorne"));
        icon.setAktiv("Icon of Despair", mark.isSelected("Mark of Nurgle"));
        icon.setAktiv("Icon of Flame", mark.isSelected("Mark of Tzeentch"));
        icon.setAktiv("Icon of Excess", mark.isSelected("Mark of Slaanesh"));
    }
}
