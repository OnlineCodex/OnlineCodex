package oc.wh40k.units.im;

import oc.*;

public class IMInceptors extends Eintrag {
    OptionsEinzelUpgrade jump;
    RuestkammerStarter waffenUndReliquien;
    AnzahlPanel squad;
    OptionsUpgradeGruppe o1, o2;

    public IMInceptors() {
        name = "Inceptor Squad";
        squad = new AnzahlPanel(ID, randAbstand, cnt, "Inceptor", 3, 6, getPts("Inceptor Squad") + getPts("Heavy bolt pistol"));
        add(squad);

        ogE.addElement(new OptionsGruppeEintrag("Troops bolters", getPts("Troops bolter")));
        ogE.addElement(new OptionsGruppeEintrag("Plasma exterminator", getPts("Plasma exterminator")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o1.setPreis(0, squad.getModelle() * getPts("Troops bolter") * 2);
        o1.setPreis(1, squad.getModelle() * getPts("Plasma exterminator") * 2);

        if (squad.getModelle() <= 3)
            power = 10;
        else
            power = 20;
    }
}
