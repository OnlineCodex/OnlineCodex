package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class IMPaladinAncient extends Eintrag {
	//TODO Ausrüstung in eine Kammer verlegen. Artefakte richtig handhaben
	OptionsUpgradeGruppe o1, o1x;
	OptionsUpgradeGruppe o2, reliquien;
	boolean grandmasterBool;
	OptionsEinzelUpgrade grandmaster;
	RuestkammerStarter psychicPowers;
	
	public IMPaladinAncient() {
		name = "Paladin Ancient";
		grundkosten = getPts("Paladin Ancient") + getPts("Frag grenades (SM)") + getPts("Krak grenades (SM)") + getPts("Psyk-out grenades (SM)");

		add(ico = new oc.Picture("oc/wh40k/images/GKBruderCaptainderGreyKnights.jpg"));
        seperator();

		ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (SM)")));
		ogE.addElement(new OptionsGruppeEintrag("Incinerator", getPts("Incinerator")));
		ogE.addElement(new OptionsGruppeEintrag("Psilencer", getPts("Psilencer")));
		ogE.addElement(new OptionsGruppeEintrag("Psycannon", getPts("Psycannon")));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Nemesis falchion", getPts("Nemesis falchion")));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();
		
		psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, "PsychicPowers", "Psychic Powers");
        ((PsychicPowers)psychicPowers.getKammer()).setNumberOfPowers(2);
		((PsychicPowers)psychicPowers.getKammer()).enableSanctic();
		psychicPowers.initKammer();
		psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
		add(psychicPowers);
		psychicPowers.setAbwaehlbar(true);
		
		complete();
	}

	@Override
	public void refreshen() {
		power = 7;
        o1.alwaysSelected();
	}
}
