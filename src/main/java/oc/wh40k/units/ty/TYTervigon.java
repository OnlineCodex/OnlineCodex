package oc.wh40k.units.ty;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class TYTervigon extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;

	RuestkammerStarter waffen;
	RuestkammerStarter psychicPowers;

	public TYTervigon() {
		name = "Tervigon";
		grundkosten = getPts("Tervigon") + getPts("Stinger salvo");
		power = 13;
		add(ico = new oc.Picture("oc/wh40k/images/TYTervigon.jpg"));
		
		ogE.addElement(new OptionsGruppeEintrag("Massive Scything Talons", getPts("Massive Scything Talons (Tervigon)")));
		ogE.addElement(new OptionsGruppeEintrag("Massive Crushing Claws", getPts("Massive Crushing Claws")));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Adrenal glands", getPts("Adrenal glands (Monsters)")));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Toxin sacs", getPts("Toxin sacs (Tervigon)")));
		
		seperator();
		
		psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, "PsychicPowers", "Psychic Powers");
        ((PsychicPowers)psychicPowers.getKammer()).setNumberOfPowers(1);
		((PsychicPowers)psychicPowers.getKammer()).enableHiveMind();
		psychicPowers.initKammer();
		psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
		add(psychicPowers);
		psychicPowers.setAbwaehlbar(true);
		
		complete();
	}

	@Override
	public void refreshen() {
		o1.alwaysSelected();
	}


}
