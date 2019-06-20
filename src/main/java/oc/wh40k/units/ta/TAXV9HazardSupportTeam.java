package oc.wh40k.units.ta;

import java.util.Vector;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class TAXV9HazardSupportTeam extends Eintrag {

	private final RuestkammerStarter ob1;
	private final Vector<RuestkammerStarter> rk;
	private OptionsZaehlerGruppe o4;
	public TAXV9HazardSupportTeam() {
        name = "XV9 Hazard Battlesuits";
        überschriftSetzen = true;
        grundkosten = 0;

        ogE.addElement(new OptionsGruppeEintrag("MV1 Gun Drone", getPts("MV1 Gun Drone")));
        ogE.addElement(new OptionsGruppeEintrag("MV4 Shield Drone", getPts("MV4 Shield Drone")));
        ogE.addElement(new OptionsGruppeEintrag("MV7 Marker Drone", getPts("MV7 Marker Drone")));
        add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        ob1 = createTroopChampion(TAKampfanzugKammer.class, true, "XV9 Hazard Battlesuit", "XV9 Hazard Battlesuit");
        ob1.setGrundkosten(getPts("XV9 Hazard Support Team"));
        add(ob1);

        seperator();

        rk = new Vector<RuestkammerStarter>();
        for (int i = 0; i < 9; i++) {
            rk.add(createTroopChampion(TAKampfanzugKammer.class, false, "XV9 Hazard Battlesuit", "XV9 Hazard Battlesuit"));
            rk.lastElement().setGrundkosten(getPts("XV9 Hazard Support Team"));
            add(rk.lastElement());
        }

        complete();
    }

    @Override
    public void refreshen() {
        rk.get(8).setAktiv(!ob1.isSelected());
        int krisisNumber = (ob1.isSelected() && ob1.isAktiv() ? 1 : 0);
        o4.setMaxAnzahl(4);

        if (!ob1.isSelected()) {
            ((TAKampfanzugKammer) ob1.getKammer()).clearEntries();
        }

        ((TAKampfanzugKammer) ob1.getKammer()).farsight = getCountFromInformationVector("Farsight Enclave") > 0;

        boolean error = false;
        for (int i = 0; i < 9; i++) {
            if (!rk.get(i).isSelected()) {
                ((TAKampfanzugKammer) rk.get(i).getKammer()).clearEntries();
            }
            if (((TAKampfanzugKammer) rk.get(i).getKammer()).uniqueError) {
                error = true;
            }
        }

        if (((TAKampfanzugKammer) ob1.getKammer()).uniqueError
                || error) {
            setFehlermeldung("Ausrüstung doppelt!");
        } else if (getCountFromInformationVector("FEWarscaper") > 1) {
            setFehlermeldung("Warscaper doppelt!");
        } else {
            setFehlermeldung("");
        }
        
        power = 5 * krisisNumber + 1 * o4.getAnzahl();
    }
}
