package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMTelemonHeavyDreadnought extends Eintrag {
	private final OptionsUpgradeGruppe o1, o2, o3;

    public IMTelemonHeavyDreadnought() {
        name = "Telemon Heavy Dreadnought";
        grundkosten = getPts("Telemon Heavy Dreadnought");
        power = 17;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Casestus & Plasma", "Telemon Caestus and twin plasma ejectors", getPts("Telemon Caestus (single)") + getPts("Twin plasma ejector")));
        ogE.addElement(new OptionsGruppeEintrag("Arachnus las-storm", getPts("Arachnus las-storm")));
        ogE.addElement(new OptionsGruppeEintrag("Iliastus accelerator culverin", getPts("Iliastus accelerator culverin")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o1.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Casestus & Plasma", "Telemon Caestus and twin plasma ejectors", getPts("Telemon Caestus (single)") + getPts("Twin plasma ejector")));
        ogE.addElement(new OptionsGruppeEintrag("Arachnus las-storm", getPts("Arachnus las-storm")));
        ogE.addElement(new OptionsGruppeEintrag("Iliastus accelerator culverin", getPts("Iliastus accelerator culverin")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o2.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Spiculus bolt launcher", getPts("Spiculus bolt launcher")));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o3.setSelected(0, true);

        complete();

        setUnikat(true);
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
        o3.alwaysSelected();

        if(o1.isSelected("Telemon Caestus and twin plasma ejectors") && o2.isSelected("Telemon Caestus and twin plasma ejectors")){
        	o1.setPreis("Telemon Caestus and twin plasma ejectors", getPts("Telemon Caestus (pair)") + getPts("Twin plasma ejector"));
        	o2.setPreis("Telemon Caestus and twin plasma ejectors", getPts("Twin plasma ejector"));
        } else {
        	o1.setPreis("Telemon Caestus and twin plasma ejectors", getPts("Telemon Caestus (single)") + getPts("Twin plasma ejector"));
        	o2.setPreis("Telemon Caestus and twin plasma ejectors", getPts("Telemon Caestus (single)") + getPts("Twin plasma ejector"));
        }
    }
}
