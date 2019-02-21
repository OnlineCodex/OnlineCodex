package oc.wh40k.units.ta;

import oc.*;

//Stealth Shasvre

public class TAShasvreKammer extends RuestkammerVater {

	private OptionsEinzelUpgrade fb;
	public OptionsUpgradeGruppe o1;
	private OptionsUpgradeGruppe o3;
	private OptionsZaehlerGruppe o4;
	private OptionsZaehlerGruppe o5;

    public TAShasvreKammer() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {

        //Bewaffnung
        ogE.addElement(new OptionsGruppeEintrag("Burst cannon", getPts("Burst cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Fusion blaster", getPts("Fusion blaster")));
        add(o1 = new OptionsUpgradeGruppe(0, randAbstand, cnt, "", ogE, 1));

        seperator();

        // Unterstützungssysteme
        ogE.addElement(new OptionsGruppeEintrag("Advanced targeting system", getPts("Advanced targeting system (all other models)")));
        ogE.addElement(new OptionsGruppeEintrag("Counterfire defence system", getPts("Counterfire defence system")));
        ogE.addElement(new OptionsGruppeEintrag("Drone controller", getPts("Drone controller")));
        ogE.addElement(new OptionsGruppeEintrag("Early warning override", getPts("Early warning override (all other models)")));
        ogE.addElement(new OptionsGruppeEintrag("Multi-tracker", getPts("Multi-tracker")));
        ogE.addElement(new OptionsGruppeEintrag("Shield generator", getPts("Shield generator (all other models)")));
        ogE.addElement(new OptionsGruppeEintrag("Target lock", getPts("Target lock (all other units)")));
        ogE.addElement(new OptionsGruppeEintrag("Velocity tracker", getPts("Velocity tracker (all other units)")));
        add(o5 = new OptionsZaehlerGruppe(0, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "Markerlight and Target Lock", "Markerlight/Target Lock", getPts("Markerlight") + getPts("Target lock (all other units)")));


        sizeSetzen();
    }

    @Override
    public void refreshen() {
        if (!o1.isSelected()) {
            o1.setSelected(0, true);
        }
    }

}
