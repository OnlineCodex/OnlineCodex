package oc.wh40k.units.ch;

import oc.*;

public class CHPossessed extends Eintrag {

    AnzahlPanel marines;
    OptionsUpgradeGruppe mark;
    OptionsUpgradeGruppe icon;
    
    public CHPossessed() {

        name = "Possessed";
        grundkosten = 0;
        add(marines = new AnzahlPanel(ID, randAbstand, cnt, "Possessed", 5, 20, getPts("Possessed")));
        add(ico = new oc.Picture("oc/wh40k/images/Moschaboy.gif"));

        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Icon of Vengeance", getPts("Icon of Vengeance")));
        ogE.addElement(new OptionsGruppeEintrag("Icon of Wrath", getPts("Icon of Wrath")));
        ogE.addElement(new OptionsGruppeEintrag("Icon of Despair", getPts("Icon of Despair")));
        ogE.addElement(new OptionsGruppeEintrag("Icon of Flame", getPts("Icon of Flame")));
        ogE.addElement(new OptionsGruppeEintrag("Icon of Excess", getPts("Icon of Excess")));
        add(icon = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        
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
        
        icon.setAktiv("Icon of Vengeance", !mark.isSelected());
        icon.setAktiv("Icon of Wrath", mark.isSelected("Mark of Khorne"));
        icon.setAktiv("Icon of Despair", mark.isSelected("Mark of Nurgle"));
        icon.setAktiv("Icon of Flame", mark.isSelected("Mark of Tzeentch"));
        icon.setAktiv("Icon of Excess", mark.isSelected("Mark of Slaanesh"));
    }
}
