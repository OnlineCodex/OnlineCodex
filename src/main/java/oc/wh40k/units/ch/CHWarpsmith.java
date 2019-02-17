package oc.wh40k.units.ch;

import oc.*;

public class CHWarpsmith extends Eintrag {

	private final RuestkammerStarter waffen;
	private final OptionsEinzelUpgrade flamer, melta, mecha;
	private final OptionsUpgradeGruppe mark;

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

        waffen = new RuestkammerStarter(ID, randAbstand, cnt, CHWaffenkammer.class, "");
        ((CHWaffenkammer) waffen.getKammer()).setDefaultRanged("Bolt pistol");
        ((CHWaffenkammer) waffen.getKammer()).setDefaultCloceCombat("Power axe");
        ((CHWaffenkammer) waffen.getKammer()).setSorcerer(true);
        waffen.initKammer(false, true, false, false);
        waffen.setButtonText("Waffenkammer");
        add(waffen);
        waffen.setAbwaehlbar(false);
        
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
