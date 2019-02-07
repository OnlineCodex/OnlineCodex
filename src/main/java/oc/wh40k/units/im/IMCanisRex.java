package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMCanisRex extends Eintrag {
    OptionsUpgradeGruppe o1, o2;
    OptionsUpgradeGruppe fk1;
    OptionsUpgradeGruppe fk2;

    public IMCanisRex() {
        name = "Canis Rex";
        grundkosten = getPts("Canis Rex") + getPts("Titanic feet");
        power = 23;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Las-impulsor", getPts("Las-impulsor")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Freedom's Hand", getPts("Freedom's Hand")));
        add(fk1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Multi-laser", getPts("Multi-laser (QI)")));
        add(fk2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        setInformationVectorValue("Knight selected", getCountFromInformationVector("Knight selected") + 1);
        
        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        fk1.alwaysSelected();
        fk2.alwaysSelected();
        o2.alwaysSelected();
    }
    
    //@OVERRIDE
    public void deleteYourself() {
        super.deleteYourself();

        setInformationVectorValue("Knight selected", getCountFromInformationVector("Knight selected") - 1);
    }
}
