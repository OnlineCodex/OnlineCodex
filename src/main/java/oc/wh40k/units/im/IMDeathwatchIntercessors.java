package oc.wh40k.units.im;

import java.util.Vector;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMDeathwatchIntercessors extends Eintrag {//Sternguard

	private final AnzahlPanel intercessors, inceptor, reiver, hellblaster, sergeant, aggressor;

	private final Vector<RuestkammerStarter> rkIntercessor;
	private final Vector<RuestkammerStarter> rkSergeant;
	private final Vector<RuestkammerStarter> rkHellblaster;
	private final Vector<RuestkammerStarter> rkInceptor;
	private final Vector<RuestkammerStarter> rkReiver;
    private final Vector<RuestkammerStarter> rkAggressor;

    private RuestkammerStarter intercessorSeargeant;

    private int numIntercessor = 0;
    private final int numSergeant = 0;
    private int numHellblaster = 0;
    private int numInceptor = 0;
    private int numReiver = 0;
    private int numAggressor = 0;

    public IMDeathwatchIntercessors() {
        name = "Veterans\n";
        grundkosten = 0;
        applyTitle = true;

        rkIntercessor = new Vector<RuestkammerStarter>();
        rkSergeant = new Vector<RuestkammerStarter>();
        rkHellblaster = new Vector<RuestkammerStarter>();
        rkInceptor = new Vector<RuestkammerStarter>();
        rkReiver = new Vector<RuestkammerStarter>();
        rkAggressor = new Vector<RuestkammerStarter>();

        sergeant = new AnzahlPanel(ID, randAbstand, cnt, "Intercessor Sergeant", 1, 1, 0);
        add(sergeant);

        intercessors = new AnzahlPanel(ID, randAbstand, cnt, "Intercessor", 4, 9, 0);
        add(intercessors);

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

        final boolean intercessorChanged = numIntercessor != intercessors.getModelle();
        final boolean sergeantChanged = numSergeant != sergeant.getModelle();
        final boolean hellblasterChanged = numHellblaster != hellblaster.getModelle();
        final boolean inceptorChanged = numInceptor != inceptor.getModelle();
        final boolean reiverChanged = numReiver != reiver.getModelle();
        final boolean aggressorChanged = numAggressor != aggressor.getModelle();

        final boolean somethingChanged = intercessorChanged || sergeantChanged || hellblasterChanged || inceptorChanged
                || reiverChanged || aggressorChanged;

        //------------Intercessors

        if(intercessorSeargeant == null) {
            intercessorSeargeant = new RuestkammerStarter(ID, randAbstand, cnt, IMKillteamKammer.class, "Intercessor Sergeant");
            ((IMKillteamKammer) intercessorSeargeant.getKammer()).setType("Intercessor Sergeant");
            intercessorSeargeant.initKammer();
            intercessorSeargeant.setGrundkosten(getPts("Intercessor Squad"));
            add(intercessorSeargeant);
            intercessorSeargeant.setAbwaehlbar(false);
        }

        if (somethingChanged) {

        	int diffIntercessor = 0;
        	diffIntercessor = intercessors.getModelle() - rkIntercessor.size();

        	if(diffIntercessor >= 0)
        	{
	            for (int i = 0; i < diffIntercessor; i++) {
	                double y = 0;
	                double height = 0;

	                if (i == 0) {
	                    y = intercessorSeargeant.getPanel().getLocation().getY();
	                    height = intercessorSeargeant.getPanel().getSize().height + 5;
	                } else {
	                    if (rkIntercessor.size() > 0) {
	                        y = rkIntercessor.lastElement().getPanel().getLocation().getY();
	                        height = rkIntercessor.lastElement().getPanel().getSize().height + 5;
	                    }
	                }

	                rkIntercessor.add(new RuestkammerStarter(ID, randAbstand, cnt, IMKillteamKammer.class, "Intercessor"));
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
        	} else {
        		for (int i = 0; i < -diffIntercessor; i++) {
                    remove(rkIntercessor.lastElement());
        			rkIntercessor.removeElement(rkIntercessor.lastElement());
        		}
        	}

            numIntercessor = intercessors.getModelle();

            //------------Intercessors

            //------------Hellblaster

        	int diffHellblaster = 0;
        	diffHellblaster = hellblaster.getModelle() - rkHellblaster.size();

        	if(diffHellblaster >= 0)
        	{
	            for (int i = 0; i < diffHellblaster; i++) {
	                double y = 0;
	                double height = 0;

	                if (rkHellblaster.size() > 0) {
	                    y = rkHellblaster.lastElement().getPanel().getLocation().getY();
	                    height = rkHellblaster.lastElement().getPanel().getSize().height + 5;
	                } else {
		                if (rkIntercessor.size() > 0) {
		                    y = rkIntercessor.lastElement().getPanel().getLocation().getY();
		                    height = rkIntercessor.lastElement().getPanel().getSize().height + 5;
		                }
	                }

	                rkHellblaster.add(new RuestkammerStarter(ID, randAbstand, cnt, IMKillteamKammer.class, "Hellblaster"));
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

	    	} else {
	    		for (int i = 0; i < -diffHellblaster; i++) {
	                remove(rkHellblaster.lastElement());
	                rkHellblaster.removeElement(rkHellblaster.lastElement());
	    		}
	    	}

            numHellblaster = hellblaster.getModelle();
            //------------Hellblaster

            //------------Inceptors

        	int diffInceptors = 0;
        	diffInceptors = inceptor.getModelle() - rkInceptor.size();

        	if(diffInceptors >= 0)
        	{

	            for (int i = 0; i < diffInceptors; i++) {
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

	                rkInceptor.add(new RuestkammerStarter(ID, randAbstand, cnt, IMKillteamKammer.class, "Inceptor"));
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
        	} else {
	    		for (int i = 0; i < -diffInceptors; i++) {
	                remove(rkInceptor.lastElement());
	                rkInceptor.removeElement(rkInceptor.lastElement());
	    		}
	    	}

            numInceptor = inceptor.getModelle();
            //------------Inceptors

            //------------Reiver

        	int diffReivers = 0;
        	diffReivers = reiver.getModelle() - rkReiver.size();

        	if(diffReivers >= 0)
        	{

	            for (int i = 0; i < diffReivers; i++) {
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

	                rkReiver.add(new RuestkammerStarter(ID, randAbstand, cnt, IMKillteamKammer.class, "Reiver"));
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
        	} else {
	    		for (int i = 0; i < -diffReivers; i++) {
	                remove(rkReiver.lastElement());
	                rkReiver.removeElement(rkReiver.lastElement());
	    		}
	    	}

            numReiver = reiver.getModelle();
            //------------Reiver

            //------------Aggressors

        	int diffAggressors = 0;
        	diffAggressors = aggressor.getModelle() - rkAggressor.size();

        	if(diffAggressors >= 0)
        	{
	            for (int i = 0; i < diffAggressors; i++) {
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

	                rkAggressor.add(new RuestkammerStarter(ID, randAbstand, cnt, IMKillteamKammer.class, "Aggressor"));
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
        	} else {
	    		for (int i = 0; i < -diffAggressors; i++) {
	                remove(rkAggressor.lastElement());
	                rkAggressor.removeElement(rkAggressor.lastElement());
	    		}
	    	}

            numAggressor = aggressor.getModelle();
            //-----------Aggressors
        }

        if(intercessors.getModelle() + inceptor.getModelle() + reiver.getModelle() + hellblaster.getModelle() +
        		sergeant.getModelle() + aggressor.getModelle() > 10)
        	setFehlermeldung("Zu viele Modelle");
        else
        	setFehlermeldung("");

        super.refreshAction();
    }

    @Override
    public void deleteYourself() {
        super.deleteYourself();
    }

}
