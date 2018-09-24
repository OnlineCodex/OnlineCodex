package oc.wh40k.units.ab;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class ABArmouredFistStormTrooperSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransport;

	public ABArmouredFistStormTrooperSquad() {
		name = "Storm Trooper Squad\n";
		grundkosten = 0;
        überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Storm Troopers", 5, 10, 16);
		squad.setGrundkosten(5);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/IGStormTrooperSquad.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Grenade launcher", 5));
		ogE.addElement(new OptionsGruppeEintrag("Meltagun", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma gun", 15));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "ABStormTrooperSergeantKammer", "Upgrade to Sergeant");
		rkBoss.initKammer();
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        rkBoss.setAbwaehlbar(false);
		add(rkBoss);

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "ABChimeraKammer", "Chimera Transport");
		rkTransport.initKammer();
		add(rkTransport);
		rkTransport.setAbwaehlbar(false);

		complete();
	}

	@Override
	public void refreshen() {
	}

}
