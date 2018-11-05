package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.RuestkammerStarter;

import java.util.Vector;

public class IMDeathwatchIntercessors extends Eintrag {//Sternguard

    AnzahlPanel intercessors, inceptor, reiver, hellblaster, sergeant, aggressor;

    Vector<RuestkammerStarter> rkIntercessor;
    Vector<RuestkammerStarter> rkSergeant;
    Vector<RuestkammerStarter> rkHellblaster;
    Vector<RuestkammerStarter> rkInceptor;
    Vector<RuestkammerStarter> rkReiver;
    Vector<RuestkammerStarter> rkAggressor;

    int numIntercessor = 0;
    int numSergeant = 0;
    int numHellblaster = 0;
    int numInceptor = 0;
    int numReiver = 0;
    int numAggressor = 0;

    public IMDeathwatchIntercessors() {
        name = "Veterans\n";
        grundkosten = 0;
        überschriftSetzen = true;

        rkIntercessor = new Vector<RuestkammerStarter>();
        rkSergeant = new Vector<RuestkammerStarter>();
        rkHellblaster = new Vector<RuestkammerStarter>();
        rkInceptor = new Vector<RuestkammerStarter>();
        rkReiver = new Vector<RuestkammerStarter>();
        rkAggressor = new Vector<RuestkammerStarter>();

        intercessors = new AnzahlPanel(ID, randAbstand, cnt, "Intercessor", 4, 10, 0);
        add(intercessors);

        sergeant = new AnzahlPanel(ID, randAbstand, cnt, "Intercessor Sergeant", 1, 1, 0);
        add(sergeant);

        hellblaster = new AnzahlPanel(ID, randAbstand, cnt, "Hellblaster", 0, 5, 0);
        add(hellblaster);

        inceptor = new AnzahlPanel(ID, randAbstand, cnt, "Inceptor", 0, 5, 0);
        add(inceptor);

        reiver = new AnzahlPanel(ID, randAbstand, cnt, "Reiver", 0, 5, 0);
        add(reiver);

        aggressor = new AnzahlPanel(ID, randAbstand, cnt, "Aggressor", 0, 5, 0);
        add(aggressor);

        seperator();

        complete();
    }

    @Override
    public void refreshen() {

        //LOGGER.info("numVeterans" + numVeterans + "squad.getModelle()" + squad.getModelle() + "rk.size()" + rk.size());

        boolean intercessorChanged = numIntercessor != intercessors.getModelle();
        boolean sergeantChanged = numSergeant != sergeant.getModelle();
        boolean hellblasterChanged = numHellblaster != hellblaster.getModelle();
        boolean inceptorChanged = numInceptor != inceptor.getModelle();
        boolean reiverChanged = numReiver != reiver.getModelle();
        boolean aggressorChanged = numAggressor != aggressor.getModelle();

        boolean somethingChanged = intercessorChanged || sergeantChanged || hellblasterChanged || inceptorChanged
                || reiverChanged || aggressorChanged;

        //------------Veterans
        if (somethingChanged) {

            if (rkIntercessor.size() > 0) {
                for (int i = rkIntercessor.size(); i > 0; i--) {
                    remove(rkIntercessor.get(i - 1));
                    rkIntercessor.remove(i - 1);
                }
            }

            for (int i = 0; i < intercessors.getModelle(); i++) {
                double y = 0;
                double height = 0;

                if (i == 0) {
                    y = aggressor.getPanel().getLocation().getY();
                    height = aggressor.getPanel().getSize().height + 5;
                } else {
                    if (rkIntercessor.size() > 0) {
                        y = rkIntercessor.lastElement().getPanel().getLocation().getY();
                        height = rkIntercessor.lastElement().getPanel().getSize().height + 5;
                    }
                }

                rkIntercessor.add(new RuestkammerStarter(ID, randAbstand, cnt, "IMKillteamKammer", "Intercessor"));
                ((IMKillteamKammer) rkIntercessor.lastElement().getKammer()).setType("Intercessor");
                rkIntercessor.lastElement().initKammer();
                rkIntercessor.lastElement().setGrundkosten(getPts("Intercessor Squad"));
                add(rkIntercessor.lastElement());
                rkIntercessor.lastElement().setAbwaehlbar(false);

                rkIntercessor.lastElement().getPanel().setLocation(
                        (int) rkIntercessor.lastElement().getPanel().getLocation().getX(),
                        (int) (y + height)
                );
            }

            numIntercessor = intercessors.getModelle();
            //------------Veterans

            //------------Sergeant
            if (rkSergeant.size() > 0) {
                for (int i = rkSergeant.size(); i > 0; i--) {
                    remove(rkSergeant.get(i - 1));
                    rkSergeant.remove(i - 1);
                }
            }

            for (int i = 0; i < sergeant.getModelle(); i++) {
                double y = 0;
                double height = 0;

                if (rkIntercessor.size() > 0) {
                    y = rkIntercessor.lastElement().getPanel().getLocation().getY();
                    height = rkIntercessor.lastElement().getPanel().getSize().height + 5;
                }

                rkSergeant.add(new RuestkammerStarter(ID, randAbstand, cnt, "IMKillteamKammer", "Intercessor Sergeant"));
                ((IMKillteamKammer) rkSergeant.lastElement().getKammer()).setType("Intercessor Sergeant");
                rkSergeant.lastElement().initKammer();
                rkSergeant.lastElement().setGrundkosten(getPts("Intercessor Squad"));
                add(rkSergeant.lastElement());
                rkSergeant.lastElement().setAbwaehlbar(false);

                rkSergeant.lastElement().getPanel().setLocation(
                        (int) rkSergeant.lastElement().getPanel().getLocation().getX(),
                        (int) (y + height)
                );
            }

            numSergeant = sergeant.getModelle();
            //------------Sergeant

            //------------Blackshield
            if (rkHellblaster.size() > 0) {
                for (int i = rkHellblaster.size(); i > 0; i--) {
                    remove(rkHellblaster.get(i - 1));
                    rkHellblaster.remove(i - 1);
                }
            }

            for (int i = 0; i < hellblaster.getModelle(); i++) {
                double y = 0;
                double height = 0;

                if (rkIntercessor.size() > 0) {
                    y = rkIntercessor.lastElement().getPanel().getLocation().getY();
                    height = rkIntercessor.lastElement().getPanel().getSize().height + 5;
                }

                if (rkSergeant.size() > 0) {
                    y = rkSergeant.lastElement().getPanel().getLocation().getY();
                    height = rkSergeant.lastElement().getPanel().getSize().height + 5;
                }

                if (rkHellblaster.size() > 0) {
                    y = rkHellblaster.lastElement().getPanel().getLocation().getY();
                    height = rkHellblaster.lastElement().getPanel().getSize().height + 5;
                }

                rkHellblaster.add(new RuestkammerStarter(ID, randAbstand, cnt, "IMKillteamKammer", "Hellblaster"));
                ((IMKillteamKammer) rkHellblaster.lastElement().getKammer()).setType("Hellblaster");
                rkHellblaster.lastElement().initKammer();
                rkHellblaster.lastElement().setGrundkosten(getPts("Hellblaster Squad"));
                add(rkHellblaster.lastElement());
                rkHellblaster.lastElement().setAbwaehlbar(false);

                rkHellblaster.lastElement().getPanel().setLocation(
                        (int) rkHellblaster.lastElement().getPanel().getLocation().getX(),
                        (int) (y + height)
                );
            }

            numHellblaster = hellblaster.getModelle();
            //------------Blackshield

            //------------Terminators
            if (rkInceptor.size() > 0) {
                for (int i = rkInceptor.size(); i > 0; i--) {
                    remove(rkInceptor.get(i - 1));
                    rkInceptor.remove(i - 1);
                }
            }

            for (int i = 0; i < inceptor.getModelle(); i++) {
                double y = 0;
                double height = 0;

                if (rkIntercessor.size() > 0) {
                    y = rkIntercessor.lastElement().getPanel().getLocation().getY();
                    height = rkIntercessor.lastElement().getPanel().getSize().height + 5;
                }

                if (rkSergeant.size() > 0) {
                    y = rkSergeant.lastElement().getPanel().getLocation().getY();
                    height = rkSergeant.lastElement().getPanel().getSize().height + 5;
                }

                if (rkHellblaster.size() > 0) {
                    y = rkHellblaster.lastElement().getPanel().getLocation().getY();
                    height = rkHellblaster.lastElement().getPanel().getSize().height + 5;
                }

                if (rkInceptor.size() > 0) {
                    y = rkInceptor.lastElement().getPanel().getLocation().getY();
                    height = rkInceptor.lastElement().getPanel().getSize().height + 5;
                }

                rkInceptor.add(new RuestkammerStarter(ID, randAbstand, cnt, "IMKillteamKammer", "Inceptor"));
                ((IMKillteamKammer) rkInceptor.lastElement().getKammer()).setType("Inceptor");
                rkInceptor.lastElement().initKammer();
                rkInceptor.lastElement().setGrundkosten(getPts("Inceptor Squad"));
                add(rkInceptor.lastElement());
                rkInceptor.lastElement().setAbwaehlbar(false);

                rkInceptor.lastElement().getPanel().setLocation(
                        (int) rkInceptor.lastElement().getPanel().getLocation().getX(),
                        (int) (y + height)
                );
            }

            numInceptor = inceptor.getModelle();
            //------------Terminators

            //------------Bikers
            if (rkReiver.size() > 0) {
                for (int i = rkReiver.size(); i > 0; i--) {
                    remove(rkReiver.get(i - 1));
                    rkReiver.remove(i - 1);
                }
            }

            for (int i = 0; i < reiver.getModelle(); i++) {
                double y = 0;
                double height = 0;

                if (rkIntercessor.size() > 0) {
                    y = rkIntercessor.lastElement().getPanel().getLocation().getY();
                    height = rkIntercessor.lastElement().getPanel().getSize().height + 5;
                }

                if (rkSergeant.size() > 0) {
                    y = rkSergeant.lastElement().getPanel().getLocation().getY();
                    height = rkSergeant.lastElement().getPanel().getSize().height + 5;
                }

                if (rkHellblaster.size() > 0) {
                    y = rkHellblaster.lastElement().getPanel().getLocation().getY();
                    height = rkHellblaster.lastElement().getPanel().getSize().height + 5;
                }

                if (rkInceptor.size() > 0) {
                    y = rkInceptor.lastElement().getPanel().getLocation().getY();
                    height = rkInceptor.lastElement().getPanel().getSize().height + 5;
                }

                if (rkReiver.size() > 0) {
                    y = rkReiver.lastElement().getPanel().getLocation().getY();
                    height = rkReiver.lastElement().getPanel().getSize().height + 5;
                }

                rkReiver.add(new RuestkammerStarter(ID, randAbstand, cnt, "IMKillteamKammer", "Reiver"));
                ((IMKillteamKammer) rkReiver.lastElement().getKammer()).setType("Reiver");
                rkReiver.lastElement().initKammer();
                rkReiver.lastElement().setGrundkosten(getPts("Reiver Squad"));
                add(rkReiver.lastElement());
                rkReiver.lastElement().setAbwaehlbar(false);

                rkReiver.lastElement().getPanel().setLocation(
                        (int) rkReiver.lastElement().getPanel().getLocation().getX(),
                        (int) (y + height)
                );
            }

            numReiver = reiver.getModelle();
            //------------Bikers

            //------------Vanguards
            if (rkAggressor.size() > 0) {
                for (int i = rkAggressor.size(); i > 0; i--) {
                    remove(rkAggressor.get(i - 1));
                    rkAggressor.remove(i - 1);
                }
            }

            for (int i = 0; i < aggressor.getModelle(); i++) {
                double y = 0;
                double height = 0;

                if (rkIntercessor.size() > 0) {
                    y = rkIntercessor.lastElement().getPanel().getLocation().getY();
                    height = rkIntercessor.lastElement().getPanel().getSize().height + 5;
                }

                if (rkSergeant.size() > 0) {
                    y = rkSergeant.lastElement().getPanel().getLocation().getY();
                    height = rkSergeant.lastElement().getPanel().getSize().height + 5;
                }

                if (rkHellblaster.size() > 0) {
                    y = rkHellblaster.lastElement().getPanel().getLocation().getY();
                    height = rkHellblaster.lastElement().getPanel().getSize().height + 5;
                }

                if (rkInceptor.size() > 0) {
                    y = rkInceptor.lastElement().getPanel().getLocation().getY();
                    height = rkInceptor.lastElement().getPanel().getSize().height + 5;
                }

                if (rkReiver.size() > 0) {
                    y = rkReiver.lastElement().getPanel().getLocation().getY();
                    height = rkReiver.lastElement().getPanel().getSize().height + 5;
                }

                if (rkAggressor.size() > 0) {
                    y = rkAggressor.lastElement().getPanel().getLocation().getY();
                    height = rkAggressor.lastElement().getPanel().getSize().height + 5;
                }

                rkAggressor.add(new RuestkammerStarter(ID, randAbstand, cnt, "IMKillteamKammer", "Aggressor"));
                ((IMKillteamKammer) rkAggressor.lastElement().getKammer()).setType("Aggressor");
                rkAggressor.lastElement().initKammer();
                rkAggressor.lastElement().setGrundkosten(getPts("Aggressor Squad"));
                add(rkAggressor.lastElement());
                rkAggressor.lastElement().setAbwaehlbar(false);

                rkAggressor.lastElement().getPanel().setLocation(
                        (int) rkAggressor.lastElement().getPanel().getLocation().getX(),
                        (int) (y + height)
                );
            }


            numAggressor = aggressor.getModelle();
            //-----------Vanguards
        }

        super.refreshAction();
    }

    @Override
    public void deleteYourself() {
        super.deleteYourself();
    }

}
