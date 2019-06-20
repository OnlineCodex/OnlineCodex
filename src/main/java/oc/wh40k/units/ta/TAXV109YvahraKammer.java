package oc.wh40k.units.ta;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class TAXV109YvahraKammer extends RuestkammerVater {

	private OptionsUpgradeGruppe o1, o2, o3;
	
    public TAXV109YvahraKammer() {
        name = "XV190 Y'vahra Battlesuit";
        grundkosten = getPts("XV190 Y'vahra Battlesuit");
    }

    @Override
    public void initButtons(boolean... defaults) {

        add(ico = new oc.Picture("oc/wh40k/images/Commander.gif"));

        ogE.addElement(new OptionsGruppeEintrag("Phased plasma-flamer", getPts("Phased plasma-flamer")));
        add(o1 = new OptionsUpgradeGruppe(0, randAbstand, cnt, "", ogE, 1));
        o1.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Ionic discharge cannone", "Ionic discharge cannone", getPts("Ionic discharge cannone")));
        add(o2 = new OptionsUpgradeGruppe(0, randAbstand, cnt, "", ogE, 1));
        o2.setSelected(0, true);

        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Flachette pod", "Flachette pod", getPts("Flachette pod")));
        add(o3 = new OptionsUpgradeGruppe(0, randAbstand, cnt, "", ogE, 1));
        o3.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Advanced targeting system", getPts("Advanced targeting system (Ghostkeel Riptide and Stormsurge)")));
        ogE.addElement(new OptionsGruppeEintrag("Counterfire defence system", getPts("Counterfire defence system")));
        ogE.addElement(new OptionsGruppeEintrag("Drone controller", getPts("Drone controller")));
        ogE.addElement(new OptionsGruppeEintrag("Early warning override", getPts("Early warning override (Ghostkeel Riptide and Stormsurge)")));
        ogE.addElement(new OptionsGruppeEintrag("Multi-tracker", getPts("Multi-tracker")));
        //ogE.addElement(new OptionsGruppeEintrag("Shield generator", getPts("Shield generator (all other units)")));
        ogE.addElement(new OptionsGruppeEintrag("Target lock", getPts("Target lock (Ghostkeel Riptide and Stormsurge)")));
        ogE.addElement(new OptionsGruppeEintrag("Velocity tracker", getPts("Velocity tracker (Ghostkeel Riptide and Stormsurge)")));
        add(new OptionsUpgradeGruppe(0, randAbstand, cnt, "", ogE, 2));

        sizeSetzen();
    }

    //@OVERRIDE
    @Override
	public void refreshen() {
        o1.setLegal(o1.isSelected());
        o2.setLegal(o2.isSelected());
        o3.setLegal(o3.isSelected());
    }

}
