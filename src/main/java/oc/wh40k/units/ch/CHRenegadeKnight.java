package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHRenegadeKnight extends Eintrag {

	private final OptionsUpgradeGruppe fkwaffen, thunder, reaper, stubber;

    public CHRenegadeKnight() {

        kategorie = 1;

        name = "Renegade Knight";
        grundkosten = getPts("Renegade Knight");

        ogE.addElement(new OptionsGruppeEintrag("Ironstorm missile pod", getPts("Ironstorm missile pod")));
        ogE.addElement(new OptionsGruppeEintrag("Stormspear rocket pod", getPts("Stormspear rocket pod")));
        ogE.addElement(new OptionsGruppeEintrag("Twin Icarus autocannon", getPts("Twin Icarus autocannon")));
        add(fkwaffen = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Thunderstrike gauntlet", getPts("Thunderstrike gauntlet")));
        ogE.addElement(new OptionsGruppeEintrag("Gatling & Flamer", "Avenger gatling cannon and heavy flamer", getPts("Avenger gatling cannon") + getPts("Heavy flamer")));
        ogE.addElement(new OptionsGruppeEintrag("Battle cannon & Stubber", "Rapid-fire battle cannon and heavy flamer", getPts("Rapid-fire battle cannon") + getPts("Heavy flamer")));
        ogE.addElement(new OptionsGruppeEintrag("Thermal cannon", getPts("Thermal cannon")));
        add(thunder = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        thunder.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Reaper chainsword", getPts("Reaper chainsword")));
        ogE.addElement(new OptionsGruppeEintrag("Gatling & Flamer", "Avenger gatling cannon and heavy flamer", getPts("Avenger gatling cannon") + getPts("Heavy flamer")));
        ogE.addElement(new OptionsGruppeEintrag("Battle cannon & Stubber", "Rapid-fire battle cannon and heavy flamer", getPts("Rapid-fire battle cannon") + getPts("Heavy flamer")));
        ogE.addElement(new OptionsGruppeEintrag("Thermal cannon", getPts("Thermal cannon")));
        add(reaper = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        reaper.setSelected(0, true);
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", getPts("Heavy stubber")));
        ogE.addElement(new OptionsGruppeEintrag("Meltagun", getPts("Meltagun")));
        add(stubber = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        stubber.setSelected(0, true);

        power = 25;

        complete();
    }


    @Override
    public void refreshen() {

    }
}
