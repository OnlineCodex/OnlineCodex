package oc.wh40k.units.ch;

import oc.*;

import static oc.wh40k.units.ch.CHWaffenkammer.ChaosWeaponsOption.SORCERER;

public class CHWarpsmith extends Eintrag {

    RuestkammerStarter waffen;
    OptionsEinzelUpgrade flamer, melta, mecha;
    OptionsUpgradeGruppe mark;

    public CHWarpsmith() {

        name = "Warpsmith";
        grundkosten = getPts("Warpsmith");
        power = 6;

        add(flamer = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Flamer", getPts("Flamer")));
        add(melta = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Meltagun", getPts("Meltagun")));
        add(mecha = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Mechatendrils", getPts("Mechatendrils")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mark of Khorne", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
        add(mark = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        waffen = new RuestkammerStarter(ID, randAbstand, cnt, new CHWaffenkammer(name, "Bolt pistol", "Power axe", false, true, false, false, SORCERER), "");
        waffen.setButtonText("Waffenkammer");
        waffen.setAbwaehlbar(false);
        add(waffen);

        seperator();

        addWarlordTraits("", true);

        complete();

    }

    @Override
    public void refreshen() {
        if (!flamer.isSelected()) flamer.setSelected(true);
        if (!melta.isSelected()) melta.setSelected(true);
        if (!mecha.isSelected()) mecha.setSelected(true);
        
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) waffen.getPanel().getLocation().getY() + waffen.getPanel().getSize().height + 5
        );
    }
}
