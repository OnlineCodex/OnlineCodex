package oc.wh40k.units.ch;


import oc.*;

import static oc.wh40k.units.ch.CHWaffenkammer.ChaosWeaponsOption.CHAMPION;

public class CHHavocs extends Eintrag {

    private final AnzahlPanel squad;
    private final OptionsZaehlerGruppe o2;
    private final OptionsZaehlerGruppe nahkampfwaffe;
    private final OptionsUpgradeGruppe icon;
    private final OptionsUpgradeGruppe mark;

    public CHHavocs() {
        name = "Havocs";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Havocs", 5, 10, getPts("Havocs"), "Havocs");
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/ChaosHavocs.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun")));
        ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword")));
        add(nahkampfwaffe = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));
        nahkampfwaffe.setAnzahl(0, squad.getModelle() - 1);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Autocannon", getPts("Autocannon")));
        ogE.addElement(new OptionsGruppeEintrag("Heavy Bolter", getPts("Heavy Bolter")));
        ogE.addElement(new OptionsGruppeEintrag("Lascannon", getPts("Lascannon")));
        ogE.addElement(new OptionsGruppeEintrag("Missile launcher", getPts("Missile launcher")));
        ogE.addElement(new OptionsGruppeEintrag("Flamer", getPts("Flamer")));
        ogE.addElement(new OptionsGruppeEintrag("Meltagun", getPts("Meltagun")));
        ogE.addElement(new OptionsGruppeEintrag("Plasma gun", getPts("Plasma gun")));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

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

        RuestkammerStarter rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, new CHWaffenkammer(name, "", "", true, true, true, true, CHAMPION), "Aspiring Champion", 1);
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        rkBoss.setGrundkosten(getPts("Aspiring Champion"));
        rkBoss.setAbwaehlbar(false);
        add(rkBoss);

        complete();
    }

    @Override
    public void refreshen() {

        int subtractor = 1; // boss
        nahkampfwaffe.setMaxAnzahl(squad.getModelle() - subtractor);

        nahkampfwaffe.setMaxAnzahl(squad.getModelle() - 1 - o2.getAnzahl());

        power = 7 +
                ((squad.getModelle() == 10) ? 3 : 0);
        
        icon.setAktiv("Icon of Vengeance", !mark.isSelected());
        icon.setAktiv("Icon of Wrath", mark.isSelected("Mark of Khorne"));
        icon.setAktiv("Icon of Despair", mark.isSelected("Mark of Nurgle"));
        icon.setAktiv("Icon of Flame", mark.isSelected("Mark of Tzeentch"));
        icon.setAktiv("Icon of Excess", mark.isSelected("Mark of Slaanesh"));
    }
}