package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.im.IMAstraMilitarumRuestkammer;

import java.util.Vector;

public class TAXV8CrisisBattlesuits extends Eintrag {

	private RuestkammerStarter ob1;
	private RuestkammerStarter ob2;
	private Vector<RuestkammerStarter> rk;
	private OptionsZaehlerGruppe o4, o5;
	private boolean warscaper = false;

    public TAXV8CrisisBattlesuits() {
        name = "XV8 Crisis Battlesuits";
        überschriftSetzen = true;
        grundkosten = 0;

        ogE.addElement(new OptionsGruppeEintrag("MV1 Gun Drone", getPts("MV1 Gun Drone")));
        ogE.addElement(new OptionsGruppeEintrag("MV4 Shield Drone", getPts("MV4 Shield Drone")));
        ogE.addElement(new OptionsGruppeEintrag("MV7 Marker Drone", getPts("MV7 Marker Drone")));
        add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("XV8-02 Iridium battlesuite", getPts("XV8-02 Crisis Iridium battlesuite")));
        add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        ob1 = createTroopChampion(TAKampfanzugKammer.class, true, "Crisis Shas'vre", "Crisis Shas'vre");
        ob1.setGrundkosten(getPts("XV8 Crisis Battlesuits"));
        add(ob1);

        seperator();

        rk = new Vector<RuestkammerStarter>();
        for (int i = 0; i < 9; i++) {
            rk.add(createTroopChampion(TAKampfanzugKammer.class, false, "Crisis Shas'ui", "Crisis Shas'ui"));
            rk.lastElement().setGrundkosten(getPts("XV8 Crisis Battlesuits"));
            add(rk.lastElement());
        }

        complete();
    }

    @Override
    public void refreshen() {
        rk.get(8).setAktiv(!ob1.isSelected());
        int krisisNumber = (ob1.isSelected() && ob1.isAktiv() ? 1 : 0);
        for (int i = 0; i < 9; i++) {
            krisisNumber += (rk.get(i).isSelected() && rk.get(i).isAktiv() ? 1 : 0);
        }

        o4.setMaxAnzahl(krisisNumber * 2);

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

        o5.setMaxAnzahl(krisisNumber / 3);

        if (((TAKampfanzugKammer) ob1.getKammer()).uniqueError
                || error) {
            setFehlermeldung("Ausrüstung doppelt!");
        } else if (getCountFromInformationVector("FEWarscaper") > 1) {
            setFehlermeldung("Warscaper doppelt!");
        } else {
            setFehlermeldung("");
        }
    }
}
