package oc.wh40k.units.am;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class AMDropSentinelSquadron extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1x;
	OptionsEinzelZaehler oe1;
	OptionsEinzelZaehler oe2;
	OptionsEinzelUpgrade oe3;
	OptionsEinzelUpgrade oe4;
    RuestkammerStarter rkTransport;

	public AMDropSentinelSquadron() {
		name = "Drop Sentinel Squadron";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Drop Sentinel", "Drop Sentinels", 1, 3, 55);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/IGScoutSentinelSquadron.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Heavy Bolter", 0));
		add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
		ogE.addElement(new OptionsGruppeEintrag("Heavy Flamer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 15));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

		seperator();

		add(oe1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "Searchlight", 3, 1));
		add(oe2 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "Hunter-killer missile", 3, 10));

		seperator();

		add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Smoke launchers", 0));
		add(oe4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Camo netting", 0));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "AMValkyrieST", "Valkyrie Sky Talon");
		rkTransport.initKammer(true);
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
		o1.setMaxAnzahl(squad.getModelle());
		o1x.setMaxAnzahl(squad.getModelle());
        o1x.setAnzahl(0, squad.getModelle() - o1.getAnzahl());

		oe1.setMaxAnzahl(squad.getModelle());
		oe2.setMaxAnzahl(squad.getModelle());
		oe3.setPreis(squad.getModelle() * 5);
		oe4.setPreis(squad.getModelle() * 10);
		
		rkTransport.setAktiv(squad.getModelle()<3);
	}

}
