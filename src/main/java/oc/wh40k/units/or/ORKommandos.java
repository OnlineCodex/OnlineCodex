package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ORKommandos extends Eintrag {

	private final AnzahlPanel kommandoz;
	private final OptionsEinzelUpgrade boss;
	private final OptionsUpgradeGruppe krallä, slugga;

    public ORKommandos() {
        kategorie = 2;
        grundkosten = 0;

        kommandoz = new AnzahlPanel(ID, randAbstand, cnt, "Kommandos", 5, 15, getPts("Kommandos"));
        add(kommandoz);

        add(ico = new oc.Picture("oc/wh40k/images/Kommandoz.gif"));

        seperator();

        add(boss = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Boss Nob"));
        ogE.addElement(new OptionsGruppeEintrag("Power klaw", getPts("Power klaw")));
        add(krallä = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        ogE.addElement(new OptionsGruppeEintrag("Slugga", getPts("Slugga")));
        add(slugga = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        
        complete();
    }

    //@OVERRIDE
    @Override
	public void refreshen() {
        if (kommandoz.getModelle() > 10) {
            power = 6;
        } else if (kommandoz.getModelle() > 5) {
            power = 4;
        } else {
            power = 2;
        }
        
        krallä.alwaysSelected();
        slugga.alwaysSelected();
        
        krallä.setAktiv(boss.isSelected());
        slugga.setAktiv(boss.isSelected());
    }

}
