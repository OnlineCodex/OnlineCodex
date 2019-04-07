package oc.wh40k.units.ch;


import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class CHRaptors extends Eintrag {

	private final AnzahlPanel squad;
	private final RuestkammerStarter rkBoss;
	private final OptionsUpgradeGruppe icon;
	private final OptionsUpgradeGruppe mark;

    public CHRaptors() {
        //name = "Chaos Space Marines Raptoren\n";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Raptors", 5, 15, getPts("Raptors"), "Raptors");
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/ChaosBikers.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol & Sword", getPts("Plasma pistol") + getPts("Chainsword")));
        ogE.addElement(new OptionsGruppeEintrag("Flamer", getPts("Flamer")));
        ogE.addElement(new OptionsGruppeEintrag("Meltagun", getPts("Meltagun")));
        ogE.addElement(new OptionsGruppeEintrag("Plasma gun", getPts("Plasma gun")));
        add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

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

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, CHWaffenkammer.class, "Raptor Champion", 1);
        ((CHWaffenkammer) rkBoss.getKammer()).setDefaultRanged("Bolt pistol");
        ((CHWaffenkammer) rkBoss.getKammer()).setDefaultCloceCombat("Chainsword");
        ((CHWaffenkammer) rkBoss.getKammer()).setChampion(true);
        rkBoss.initKammer(true, true, true, true);
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        rkBoss.setGrundkosten(getPts("Raptor Champion"));
        add(rkBoss);
        rkBoss.setAbwaehlbar(false);
        seperator();

        complete();
    }

    @Override
    public void refreshen() {
        power = 7 +
                ((squad.getModelle() == 10) ? 5 : 0) +
                ((squad.getModelle() == 15) ? 10 : 0);

        icon.setAktiv("Icon of Vengeance", !mark.isSelected());
        icon.setAktiv("Icon of Wrath", mark.isSelected("Mark of Khorne"));
        icon.setAktiv("Icon of Despair", mark.isSelected("Mark of Nurgle"));
        icon.setAktiv("Icon of Flame", mark.isSelected("Mark of Tzeentch"));
        icon.setAktiv("Icon of Excess", mark.isSelected("Mark of Slaanesh"));
    }

}
