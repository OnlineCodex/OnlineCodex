package oc.wh40k.units.cm;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CMKyborgkult extends Eintrag {

    AnzahlPanel squad;
    OptionsUpgradeGruppe mal;
    OptionsUpgradeGruppe vdlk;

    public CMKyborgkult() {
        //name = "Kyborgkult";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Kyborg", "Kyborgs", 1, 3, 70);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/ObliteratorCult.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mal des Khorne", 4));
        ogE.addElement(new OptionsGruppeEintrag("Mal des Tzeentch", 8));
        ogE.addElement(new OptionsGruppeEintrag("Mal des Nurgle", 6));
        ogE.addElement(new OptionsGruppeEintrag("Mal des Slaanesh", 1));
        add(mal = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Veteranen", "Veteranen des Langen Krieges", 3));
        add(vdlk = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        complete();
    }

    @Override
    public void refreshen() {

        if (getCountFromInformationVector("BlackLegion") == 1) {
            vdlk.setSelected(0, true);
        }

        vdlk.setAktiv(getCountFromInformationVector("CrimsonSlaughter") == 0);

        int count = squad.getModelle();
        mal.setPreis("Mal des Khorne", 4 * count);
        mal.setPreis("Mal des Tzeentch", 8 * count);
        mal.setPreis("Mal des Nurgle", 6 * count);
        mal.setPreis("Mal des Slaanesh", 1 * count);

        vdlk.setPreis("Veteranen des Langen Krieges", 3 * count);
    }

}
