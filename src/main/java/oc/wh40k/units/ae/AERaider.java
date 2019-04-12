package oc.wh40k.units.ae;



import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;



public class AERaider extends Eintrag {



	private final OptionsUpgradeGruppe o1;



    public AERaider() {

        name = "Raider";

        grundkosten = getPts("Raider") + getPts("Bladevanes");



        power = 6;



        ogE.addElement(new OptionsGruppeEintrag("Dark lance", getPts("Dark lance")));

        ogE.addElement(new OptionsGruppeEintrag("Disintegrator cannon", getPts("Disintegrator cannon")));

        add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));



        seperator();



        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Splinter racks", getPts("Splinter racks")));



        seperator();



        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Chain-snares", getPts("Chain-snares")));

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grisly trophies", getPts("Grisly trophies")));

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Phantasm grenade launcher", getPts("Phantasm grenade launcher")));

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Shock prow", getPts("Shock prow")));



        seperator();



        complete();

    }



    @Override

    public void refreshen() {

        o1.alwaysSelected();

    }

}