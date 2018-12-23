package oc.wh40k.units.ch;


import oc.*;

import static oc.wh40k.units.ch.CHWaffenkammer.ChaosWeaponsOption.CHAMPION;

public class CHChaosBikers extends Eintrag {

    private final AnzahlPanel squad;
    private final OptionsUpgradeGruppe icon;
    private final OptionsZaehlerGruppe bp;
    private final OptionsZaehlerGruppe special;
    private final OptionsZaehlerGruppe bike;
    private final OptionsZaehlerGruppe combi;
    private final OptionsUpgradeGruppe mark;

    public CHChaosBikers() {
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Chaos Bikers", 3, 9, getPts("Chaos Bikers"), "Chaos Bikers");
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/ChaosBikers.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol")));
        ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword")));
        add(bp = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));
        bp.setAnzahl(0, squad.getModelle() - 1);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Flamer", getPts("Flamer")));
        ogE.addElement(new OptionsGruppeEintrag("Meltagun", getPts("Meltagun")));
        ogE.addElement(new OptionsGruppeEintrag("Plasma gun", getPts("Plasma gun")));
        add(special = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", getPts("Combi-bolter")));
        add(combi = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
        combi.setAnzahl(0, squad.getModelle() - 1);

        ogE.addElement(new OptionsGruppeEintrag("Flamer", getPts("Flamer")));
        ogE.addElement(new OptionsGruppeEintrag("Meltagun", getPts("Meltagun")));
        ogE.addElement(new OptionsGruppeEintrag("Plasma gun", getPts("Plasma gun")));
        add(bike = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

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

        RuestkammerStarter rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, new CHWaffenkammer(name, "Bolt pistol", "no weapon", false, true, true, false, CHAMPION), "Chaos Biker Champion", 1);
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        rkBoss.setGrundkosten(getPts("Chaos Biker Champion") + getPts("Combi-bolter"));
        rkBoss.setAbwaehlbar(false);
        add(rkBoss);

        complete();
    }

    @Override
    public void refreshen() {
        bp.setMaxAnzahl(squad.getModelle() - 1 - special.getAnzahl());
        special.setMaxAnzahl(2 - bike.getAnzahl());
        bike.setMaxAnzahl(2 - special.getAnzahl());
        combi.setMaxAnzahl(squad.getModelle() - 1 - bike.getAnzahl());
        combi.setAnzahl(0, squad.getModelle() - 1 - bike.getAnzahl());

        power = 7 +
                ((squad.getModelle() == 6) ? 5 : 0) +
                ((squad.getModelle() == 9) ? 10 : 0);
        
        icon.setAktiv("Icon of Vengeance", !mark.isSelected());
        icon.setAktiv("Icon of Wrath", mark.isSelected("Mark of Khorne"));
        icon.setAktiv("Icon of Despair", mark.isSelected("Mark of Nurgle"));
        icon.setAktiv("Icon of Flame", mark.isSelected("Mark of Tzeentch"));
        icon.setAktiv("Icon of Excess", mark.isSelected("Mark of Slaanesh"));
    }
}