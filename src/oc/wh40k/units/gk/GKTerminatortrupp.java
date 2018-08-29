package oc.wh40k.units.gk;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class GKTerminatortrupp extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o1def;
    OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o2def;
    OptionsEinzelUpgrade stab;
    OptionsEinzelUpgrade banner;
    OptionsEinzelUpgrade thawn;
    RuestkammerStarter rkBoss;

    boolean thawnSelected = false;

    public GKTerminatortrupp() {
        name = "Terminatortrupp\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Terminatoren", 5, 10, 40);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/GKTerminatortrupp.jpg"));
        

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Psischwert", "Nemesis-Psischwert", 0));
        add(o1def = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        ogE.addElement(new OptionsGruppeEintrag("Psihellebarde", "Nemesis-Psihellebarde", 0));
        ogE.addElement(new OptionsGruppeEintrag("Dämonenhammer", "Nemesis-Dämonenhammer", 0));
        ogE.addElement(new OptionsGruppeEintrag("Falchions", "Paar Nemesis-Falchions", 5));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 0));
        add(o2def = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        ogE.addElement(new OptionsGruppeEintrag("Erlöser-Flamer", "Erlöser-Flammenwerfer", 5));
        ogE.addElement(new OptionsGruppeEintrag("Psipulser", 15));
        ogE.addElement(new OptionsGruppeEintrag("Psibolter", 25));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        add(stab = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Wehrstab", "1 x Nemesis-Wehrstab", 20));
        add(banner = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Bruderschaftsbanner", 25));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Psi-Aktive Munition", 20));

        seperator();
        add(thawn = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Justicar Thawn", "Upgrade zu Justicar Thawn", 75));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "GKTerminatorJusticar", "Upgrade zum Justicar");
        rkBoss.initKammer();
        rkBoss.setButtonText("Upgrade zum Justicar", false);
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss);
        rkBoss.setAbwaehlbar(false);

        complete();
    }

    @Override
    public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);

        int subtractor = (stab.isSelected() ? 1 : 0) + (banner.isSelected() ? 1 : 0) + 1; // last one is the boss

        o1.setMaxAnzahl(squad.getModelle() - subtractor); // heavy weapon
        o1def.setMaxAnzahl(squad.getModelle() - o1.getAnzahl() - subtractor);
        o1def.setAnzahl(0, squad.getModelle() - o1.getAnzahl() - subtractor);

        o2.setMaxAnzahl((int) Math.floor(squad.getModelle() / 5));
        o2def.setMaxAnzahl(squad.getModelle() - o2.getAnzahl() - 1); // last one is the boss
        o2def.setAnzahl(0, squad.getModelle() - o2.getAnzahl() - 1); // last one is the boss

        rkBoss.setAktiv(!thawn.isSelected());

        stab.setAktiv(!((Boolean) rkBoss.getKammer().getSpecialValue("WEHRSTAB")));
        banner.setAktiv(!((Boolean) rkBoss.getKammer().getSpecialValue("BANNER")));

        rkBoss.getKammer().switchEntry("WEHRSTAB", !stab.isSelected());
        rkBoss.getKammer().switchEntry("BANNER", !banner.isSelected());

        // Unique entry: Justicar Thawn
		boolean thawnGlobal = ( getCountFromInformationVector("GKThawn") > 0 ? true : false );
		if(thawnGlobal && !thawnSelected) thawn.setAktiv(false);
		else thawn.setAktiv(true);

		if(thawn.isSelected()) {
			thawnSelected = true;
			addToInformationVector("GKThawn", 1);
		} else {
			if(thawnSelected) {
				thawnSelected = false;
				setInformationVectorValue("GKThawn", 0);
				BuildaHQ.refreshEntries(1);
				BuildaHQ.refreshEntries(2);
				BuildaHQ.refreshEntries(3);
				BuildaHQ.refreshEntries(4);
				BuildaHQ.refreshEntries(5);
			}
		}
    }

}
