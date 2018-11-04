package oc.wh40k.units.ch;

import oc.*;

public class CHPossessed extends Eintrag {

    AnzahlPanel marines;
    OptionsUpgradeGruppe mark;

    public CHPossessed() {

        kategorie = 1;

        name = "Possessed";
        grundkosten = 0;
        add(marines = new AnzahlPanel(ID, randAbstand, cnt, "Possessed", 5, 20, getPts("Possessed")));
        add(ico = new oc.Picture("oc/wh40k/images/Moschaboy.gif"));

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Chaosicon", getPts("Icon of Vengeance")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mark of Khorne", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
        add(mark = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();
    }


    @Override
    public void refreshen() {

        power = 6 +
                ((marines.getModelle() == 10) ? 5 : 0) +
                ((marines.getModelle() == 15) ? 10 : 0) +
                ((marines.getModelle() == 20) ? 15 : 0);
    }
}
