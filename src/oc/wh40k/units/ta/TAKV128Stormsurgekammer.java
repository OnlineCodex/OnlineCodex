package oc.wh40k.units.ta;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class TAKV128Stormsurgekammer extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;

	public TAKV128Stormsurgekammer() {
		name = "KV128 Stormsurge";
		grundkosten = getPts("KV128 Stormsurge")+getPts("Cluster rocket system")+getPts("Destroyer missile")*4+getPts("Smart missile system")*2;
	}

	@Override
	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/Hammerhai.gif"));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("2 Flamer", getPts("Flamer")*2));
		ogE.addElement(new OptionsGruppeEintrag("2 Burst cannons", getPts("Burst cannon")*2));
		ogE.addElement(new OptionsGruppeEintrag("2 Air. Frag. projectors", "2 Airbursting fragmentation projectors", getPts("Airbursting fragmentation projector")*2));
		add(o1 = new OptionsUpgradeGruppe(0, randAbstand, cnt, "", ogE, 1));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Pulse blastcannon", getPts("Pulse blastcannon")));
		ogE.addElement(new OptionsGruppeEintrag("Pulse driver cannon", getPts("Pulse driver cannon")));
		add(o2 = new OptionsUpgradeGruppe(0, randAbstand, cnt, "", ogE));
		

		seperator();
		
		// Unterstützungssysteme
		ogE.addElement(new OptionsGruppeEintrag("Advanced targeting system", getPts("Advanced targeting system (Ghostkeel Riptide and Stormsurge)")));
		ogE.addElement(new OptionsGruppeEintrag("Counterfire defence system", getPts("Counterfire defence system")));
		ogE.addElement(new OptionsGruppeEintrag("Drone controller", getPts("Drone controller")));
		ogE.addElement(new OptionsGruppeEintrag("Early warning override", getPts("Early warning override (Ghostkeel Riptide and Stormsurge)")));
		ogE.addElement(new OptionsGruppeEintrag("Multi-tracker", getPts("Multi-tracker")));
		ogE.addElement(new OptionsGruppeEintrag("Shield generator", getPts("Shield generator (Stormsurge)")));
		ogE.addElement(new OptionsGruppeEintrag("Target lock", getPts("Target lock (Ghostkeel Riptide and Stormsurge)")));
		ogE.addElement(new OptionsGruppeEintrag("Velocity tracker", getPts("Velocity tracker (Ghostkeel Riptide and Stormsurge)")));
		add(o3 = new OptionsUpgradeGruppe(0, randAbstand, cnt, "", ogE, 3));

		sizeSetzen();
	}

    @Override
	public void refreshen() {
		o1.alwaysSelected();
		o2.alwaysSelected();
		
		
		
	}
    
}
