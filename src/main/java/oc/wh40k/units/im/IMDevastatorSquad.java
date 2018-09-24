package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class IMDevastatorSquad extends Eintrag {

	AnzahlPanel squad;
	RuestkammerStarter rkBoss;
	OptionsZaehlerGruppe o1, o1x;

	public IMDevastatorSquad() {
		name = "Devastator Squad\n";
		überschriftSetzen = true;
		add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Space Marines", 5, 10, getPts("Devastator Squad")));

		add(ico = new oc.Picture("oc/wh40k/images/SMDevastatorTrupp.jpg"));

		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Armorium Cherub", getPts("Devastator Squad - Armorium Cherub")));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (SM)")));
		add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));
		ogE.addAll(IMSpaceMarinesHeavyWeapons.createRK("", "", buildaVater));
		if(buildaVater.getFormationType().equals("Blood Angels"))
			ogE.addElement(new OptionsGruppeEintrag("Heavy Flamer", getPts("Heavy Flamer (SM)")));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));
		
		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "IMSergeant", "Sergeant");
		((IMSergeant)rkBoss.getKammer()).type = "Devastator Squad";
		rkBoss.initKammer();
		rkBoss.setGrundkosten(getPts("Sergeant"));
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);


		complete();
	}

	@Override
	public void refreshen() {
		o1x.setMaxAnzahl(squad.getModelle() - 1 - o1.getAnzahl());
		o1x.setAnzahl(0,squad.getModelle() - 1 - o1.getAnzahl());
	
		if(squad.getModelle()>=5) power = 8;
		if(squad.getModelle()>=10) power = 11;
	}
}