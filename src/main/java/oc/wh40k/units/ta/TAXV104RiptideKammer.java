package oc.wh40k.units.ta;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class TAXV104RiptideKammer extends RuestkammerVater {

	private OptionsUpgradeGruppe o1, o2;
    public TAXV104RiptideKammer() {
        name = "XV104 Sturmflut ";
        grundkosten = 180;
    }

    @Override
    public void initButtons(boolean... defaults) {

        add(ico = new oc.Picture("oc/wh40k/images/Commander.gif"));

        ogE.addElement(new OptionsGruppeEintrag("2 Smart missile systems", getPts("Smart missile system") * 2));
        ogE.addElement(new OptionsGruppeEintrag("2 Plasma rifles", getPts("Plasma rifle") * 2));
        ogE.addElement(new OptionsGruppeEintrag("2 Fusion blaster", getPts("Fusion blaster") * 2));
        add(o1 = new OptionsUpgradeGruppe(0, randAbstand, cnt, "", ogE, 1));
        o1.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Burst cannon", "Heavy burst cannon", getPts("Heavy burst cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Ion accelerator", getPts("Ion accelerator")));
        add(o2 = new OptionsUpgradeGruppe(0, randAbstand, cnt, "", ogE, 1));
        o2.setSelected(0, true);

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
    }

}
