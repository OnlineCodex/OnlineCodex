package oc.wh40k.units.ab;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class ABVultureGunshipSquadron extends Eintrag {

    RuestkammerStarter v1;
    RuestkammerStarter v2;
    RuestkammerStarter v3;

    public ABVultureGunshipSquadron() {
        name = "Vendetta Gunship Squadron";
        grundkosten = 0;
        überschriftSetzen = true;

        add(ico = new oc.Picture("oc/wh40k/images/ABVendettaGunshipSquadron.jpg"));

        v1 = new RuestkammerStarter(ID, randAbstand, cnt, "ABVulture", "Vulture");
        v1.initKammer();
        v1.setGrundkosten(105);
        add(v1);

        seperator();

        v2 = new RuestkammerStarter(ID, randAbstand, cnt, "ABVulture", "Vulture");
        v2.initKammer();
        v2.setGrundkosten(105);
        add(v2);

        seperator();

        v3 = new RuestkammerStarter(ID, randAbstand, cnt, "ABVulture", "Vulture");
        v3.initKammer();
        v3.setGrundkosten(105);
        add(v3);

        addToInformationVector("ABImperialNavyGunshipSuport", 1);

        complete();
    }

    @Override
    public void refreshen() {
        if (getCountFromInformationVector("ABImperialNavyGunshipSuport") > 1) {
            setFehlermeldung("0-1 Gunship Squadrons");
        } else {
            setFehlermeldung("");
        }
    }

    public void deleteYourself() {
        addToInformationVector("ABImperialNavyGunshipSuport", -1);
        super.deleteYourself();
    }

}
