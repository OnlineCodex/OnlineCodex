package oc.wh40k.units.im;

import oc.*;

public class IMReiverSquad extends Eintrag {
    OptionsEinzelUpgrade sergeant, grav, grapnel;
    RuestkammerStarter waffenUndReliquien;
    OptionsUpgradeGruppe o1, o2;
    AnzahlPanel squad;

    public IMReiverSquad() {
        name = "Reiver Squad";
        squad = new AnzahlPanel(ID, randAbstand, cnt, "Reiver", 5, 10, getPts("Reiver Squad") + getPts("Heavy bolt pistol") + getPts("Krak grenade (SM)") + getPts("Frag grenade (SM)") + getPts("Shock grenades"));
        add(squad);

        ogE.addElement(new OptionsGruppeEintrag("Bolt carbines", getPts("Bolt carbine")));
        ogE.addElement(new OptionsGruppeEintrag("Combat knifes", getPts("Combat knife")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(grav = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grav-chutes", getPts("Grav-chute")));

        seperator();

        add(grapnel = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grapnel launcher", getPts("Grapnel launcher")));

        seperator();

        add(sergeant = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Reiver Sergeant", getPts("Reiver Sergeant")));
        ogE.addElement(new OptionsGruppeEintrag("Bolt carbine & Bolt pistol", getPts("Bolt carbine") + getPts("Bolt pistol")));
        ogE.addElement(new OptionsGruppeEintrag("Bolt carbine & Combat knife", getPts("Bolt carbine") + getPts("Combat knife")));
        ogE.addElement(new OptionsGruppeEintrag("Bolt pistol & Combat knife", getPts("Bolt pistol") + getPts("Combat knife")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
    }

    @Override
    public void refreshen() {
        o1.setPreis(0, (squad.getModelle() - 1) * (getPts("Bolt carbine")));
        o1.setPreis(1, (squad.getModelle() - 1) * (getPts("Combat knife")));
        o1.alwaysSelected();
        o2.alwaysSelected();
        sergeant.setSelected(true);
        grav.setPreis((squad.getModelle() + (sergeant.isSelected() ? 1 : 0)) * getPts("Grav-chute"));
        grapnel.setPreis((squad.getModelle() + (sergeant.isSelected() ? 1 : 0)) * getPts("Grapnel launcher"));

        if (squad.getModelle() <= 5)
            power = 5;
        else
            power = 10;
    }
}
