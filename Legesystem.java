import java.util.*;
import java.io.*;

public class Legesystem{
    // Opprett lister som lagrer objektene i legesystemet
    public static Stabel<Pasient> pasienten = new Stabel<Pasient>();
    public static Lenkeliste<Legemiddel> legemidler= new Lenkeliste<Legemiddel>();
    public static SortertLenkeliste<Lege> leger= new SortertLenkeliste<Lege>();
    // public static Iterator LegeSIt= Leger.iterator();
    public static Lenkeliste<Resept> Resepter= new Lenkeliste<Resept>();
    public static Lenkeliste<Resept> statistikk= new Lenkeliste<Resept>();


    public static void main(String[] args){
      File fil = new File("fil.txt");
      lesFraFil(fil);
      menyen();
      // Scanner valg = new Scanner(System.in);
      // int in = valg.nextInt();

    }
    public static void menyen(){
      System.out.println("\nHva ser du etter ? ");
      System.out.println("1 : Oversikt over alle resepter  \n");
      System.out.println("2 : Legge til nye objekter  \n");
      System.out.println("3 : Gaa til hovedmenyen  \n");
      System.out.println("4 : Gaa til undermenyen (statiistikk) \n");
      System.out.println("press 0 til aa avslutte programmet \n ");
      Scanner valg = new Scanner(System.in);
      int in = valg.nextInt();
      while(in != 0){
        if(in == 1){
          Resepter.skrivall();
          menyen();
        }else if (in ==2){
          leggTilObjekter();
          menyen();
        }else if(in == 3){
          hovedmeny();
          menyen();
        }else if(in == 4){
          undermeny();
          menyen();
        }else{
          System.out.println("ugyldig innput : ");
          menyen();
        }
        break;
      }
    }
    // D4: Legg til funksjonalitet for å la bruker legge til en lege, pasient, resept eller legemiddel.
    // Resepter skal opprettes via Lege sin skrivResept(). Pass på at du sjekker om det er mulig å
    // lage det ønskede objektet før det opprettes - for eksempel skal det ikke være tillatt å lage en
    // resept uten en gyldig utskrivende lege. Dersom brukeren oppgir ugyldig informasjon skal de
    // informeres om dette.

    public static void leggTilLege(){
      System.out.println("Skriv legens navn : ");
      Scanner navn = new Scanner(System.in);
      String j = navn.next();
      for(Lege l: leger){
        if(l.hentNavn().equals(j) ){
          System.out.println("legen finnes allererde i listen ");
          leggTilObjekter();
        }else{
          Lege lege= new Lege(j);
          leger.leggTil(lege);
        }
        break;
      }
    }
    public static void leggTilSpesialist(){
      System.out.println("Skriv legens kontroll ID : ");
      Scanner kontrollID = new Scanner(System.in);
      int e = kontrollID.nextInt();
      System.out.println("Skriv legens navn : ");
      Scanner navn = new Scanner(System.in);
      String h = navn.next();
      for(Lege s: leger){
        if(s.hentNavn().equals(h) ){
          System.out.println("legen finnes allererde i listen ");
          leggTilObjekter();
        }else{
          Lege spesialisten = new Spesialist(h,e);
          leger.leggTil(spesialisten);
        }
        break;
      }
    }
    public static void leggTilPasient(){
      System.out.println("Skriv pasients navn : ");
      Scanner navn = new Scanner(System.in);
      String h = navn.next();
      System.out.println("Skriv pasients personNnummer : ");
      Scanner personNnummer = new Scanner(System.in);
      String e = personNnummer.next();
      for(Pasient s: pasienten){
        if(s.hentFaadselsnummer().equals(e) ){
          System.out.println("Psienten finnes allererde i listen ");
          leggTilObjekter();
        }else{
          Pasient pa = new Pasient(h,e);
          pasienten.leggTil(pa);
        }
        break;
      }
    }
    public static void leggTilLegemiddel(){
      System.out.println("Skriv naven til legemiddelet : ");
      Scanner navn = new Scanner(System.in);
      String j = navn.next();
      System.out.println("Skriv pris: ");
      Scanner pris = new Scanner(System.in);
      Double h = pris.nextDouble();
      System.out.println("Skriv virkestoff: ");
      Scanner virkestoff = new Scanner(System.in);
      Double n = virkestoff.nextDouble();
      System.out.println("Skriv styrke: ");
      Scanner styrke = new Scanner(System.in);
      int m = styrke.nextInt();
      System.out.println("Skriv legemiddelets type : ");
      Scanner legemiddelet = new Scanner(System.in);
      String type = legemiddelet.next();
      for(Legemiddel legM : legemidler){
        if(legM.hentNavn().equals(j)){
          System.out.println("Legemiddelet finnes allererde i listen ");
          leggTilObjekter();
        }else if (type.compareTo("a") == 0){
          Legemiddel leM = new PreparatA(j,type,h,n,m);
          legemidler.leggTil(leM);
        }else if (type.compareTo("b") == 0){
          Legemiddel leM = new PreparatB(j,type,h,n,m);
          legemidler.leggTil(leM);
        }else if(type.compareTo("c") == 0){
          System.out.println("Denne typen har ikke styrke ");
          Legemiddel leM = new PreparatC(j,type,h,n);
          legemidler.leggTil(leM);
        }
      }
    }
      // D4: Legg til funksjonalitet for å la bruker legge til en lege, pasient, resept eller legemiddel.
      // Resepter skal opprettes via Lege sin skrivResept(). Pass på at du sjekker om det er mulig å
      // lage det ønskede objektet før det opprettes - for eksempel skal det ikke være tillatt å lage en
      // resept uten en gyldig utskrivende lege. Dersom brukeren oppgir ugyldig informasjon skal de
      // informeres om dette.
    public static void leggTilObjekter(){
      System.out.println("1 : Hvis du vil legge til en lege press nummer 1  \n");
      System.out.println("2 : Hvis du vil legge til en Spesialist press nummer 2  \n");
      System.out.println("3 : Hvis du vil legge til en pasient press nummer 3  \n");
      System.out.println("4 : Hvis du vil legge til en resept press nummer 4  \n");
      System.out.println("5 : Hvis du vil legge til en legemiddel press nummer 5  \n");
      System.out.println(" Hvis du vil dra tibake til menyen press nummer 0  \n");


      Scanner scan = new Scanner(System.in);
      String i = scan.next();

      if (i.compareTo("1") == 0){
        leggTilLege();
        System.out.println("\nLegelisten naa er : \n");
        leger.skrivall();
      }else if (i.compareTo("2") == 0){
        leggTilSpesialist();
        System.out.println("\nLegelisten naa er : \n");
        leger.skrivall();
      }else if (i.compareTo("3") == 0){
        leggTilPasient();
        System.out.println("\nPasientslisten naa er : \n");
        pasienten.skrivall();
      }else if (i.compareTo("4") == 0){
        System.out.println("Skriv legemiddel for resepten : ");
        // System.out.println("1 - velg eksisterende legemiddel f : ");
        // System.out.println("2 - legge til en ny legemiddel : ");
        // Scanner legemid = new Scanner(System.in);
        // String velg = legemid.next();
        // if(velg.compareTo("1") == 0 ){
        //   System.out.println("\nHvilken legemiddel vil du se legge til ? skriv pasient ID \n");
        //   legemidler.skrivall();
        //   Scanner legemid1 = new Scanner(System.in);
        //   int velg1 = legemid1.next();
        //   for(Legemiddel leM : legemidler){
        //     if(leM.hentId().equals(velg1)){
        //
        //     }
        //   }
        //
        // }else if(velg.compareTo("2") == 0 ){
        //   leggTilLegemiddel();
        // }else{
        //   System.out.println(" ugyldig innput ");
          leggTilObjekter();
        // }

        System.out.println("\nSkriv legen for resepten : ");
        System.out.println("1 : Hvis du vil legge til en lege press nummer 1  \n");
        System.out.println("2 : Hvis du vil legge til en Spesialist press nummer 2  \n");
        Scanner scan2 = new Scanner(System.in);
        String q = scan2.next();
        if (q.compareTo("1") == 0){
          leggTilLege();
        }else if(q.compareTo("2") == 0){
          leggTilSpesialist();
        }

        System.out.println("Skriv Pasienten for resepten : ");
        leggTilPasient();

        System.out.println("Skriv reit for resepten : \n");
        System.out.println("skriv antall ganger som er igjen paa resepten : ");
        Scanner reit = new Scanner(System.in);
        Integer ant = reit.nextInt();

        System.out.println("1: Hvis det er en Hvit resept press nummer 1 ");
        System.out.println("2: Hvis det er en Blaa resept press nummer 2 ");
        System.out.println("3: Hvis det er en Militaar resept press nummer 3 ");
        System.out.println("4: Hvis det er en Presepte resept press nummer 4 ");
        Scanner res = new Scanner(System.in);
        String typ = res.next();

        Lege leg = (leger.hent(leger.stoerrelse()-1));
        Legemiddel legemidd =(legemidler.hent(legemidler.stoerrelse()-1));
        Pasient pasientiden = (pasienten.hent(pasienten.stoerrelse()-1));

        try{
          if(typ.compareTo("1") == 0){
            Resept resepten = leg.skrivHvitResept(legemidd,pasientiden,ant);
            Resepter.leggTil(resepten);
          }else if (typ.compareTo("2") == 0){
            Resept resepten = leg.skrivBlaaResept(legemidd,pasientiden,ant);
            Resepter.leggTil(resepten);
          }else if (typ.compareTo("3") == 0){
            Resept resepten = leg.skrivMillitaarResept(legemidd,pasientiden,ant);
            Resepter.leggTil(resepten);
          }else if (typ.compareTo("4") == 0){
            Resept resepten = leg.skrivPResept(legemidd,pasientiden,ant);
            Resepter.leggTil(resepten);
          }
        }
        catch(UlovligUtskrift u){
          System.out.print(u.getMessage());
        }
        Resepter.skrivall();

      }else if (i.compareTo("5") == 0){
        leggTilLegemiddel();
        legemidler.skrivall();
      }else if (i.compareTo("0") == 0){
        menyen();
      }else{
        System.out.println("------------::::::::::press den RIKTIG nummer::::::::.-------------- \n");
        leggTilObjekter();
      }
    }

    public static void hentresepter(){
      Scanner scan = new Scanner(System.in);
      int i = scan.nextInt();
      Pasient valgetPasient = pasienten.hent(i);
      System.out.println("valget pasient er : \n" + valgetPasient);

      System.out.println("\nHvilken resept vil du bruke? skriv Reseptens ID");
      for(Pasient pa : pasienten){
        if(pa.hentId() == i){
          if(pa.lengden() <= 0){
          System.out.println(" Pasienten " + pa.hentNavn() + " har ingen resept :( " );
          hovedmeny();
          }
        break;
        }
      }
      for(Resept p: Resepter){
        if (p.hentPasient().hentId() == i){
          System.out.println("Reseptens ID er "+ p.hentId() + " : "+ p.hentLegemiddel().hentNavn() + ". Reit : " + p.hentReit());
          // break;
        }
      }
    }
    //     D5: Legg til mulighet for å bruke en resept. Illustrasjon av foreslått interaksjon med bruker
    // (fra bruker har indikert at de ønsker å bruke en resept) finner du nederst i oppgaven
    // (vedlegg 1).
    public static void hovedmeny(){
      System.out.println("\nHvilken pasient vil du se resepter for? skriv pasient ID \n");
      pasienten.skrivall();
      hentresepter();

      Scanner valgResept = new Scanner(System.in);
      int v = valgResept.nextInt();
      for(Resept r: Resepter){
        if (r.hentId() == v ){
          System.out.println(" Brukt resept paa  " +  r.hentLegemiddel().hentNavn() + ". Antall gjenvaerende reit : " + (r.hentReit()-1));
          if(!r.bruk()) {
            System.out.println("Kunne ikke bruke resept paa " +  r.hentLegemiddel().hentNavn() + " (ingen gjenvaerende reit).");
          }
        }
      }
      System.out.println(" \n\n\nTil aa dra til hovedmeny press 1 ");
      System.out.println("Til aa avslutte press 2 ");
      Scanner tibake = new Scanner(System.in);
      int z = tibake.nextInt();
      if(z == 1){
        hovedmeny();
      }else{
        return;
      }
    }

    // D6: Opprett funksjonalitet for å vise statistikk om elementene i systemet. Dette kan for
    // eksempel presenteres som en undermeny av brukermenyen.
    public static void undermeny(){
      int teller = 0;
      int teller1 = 0;
      for(Resept r : Resepter){
        if (r.hentLegemiddel().hentType().equals("b")){
          teller++;
          // System.out.println(r.hentPasient());
          // System.out.println("Antall ganger som er igjen paa resepten : " + r.hentReit());
          // System.out.println("leger som har skrevet ut minst en resept paa vanedannende legemidler : " + r.hentLege());
        }else if (r.hentLegemiddel().hentType().equals("a")){
          teller1++;
          //  Statistikk om mulig misbruk av narkotika skal vises på følgende måte:
          //  List opp navnene på alle leger (i alfabetisk rekkefølge) som har skrevet ut
          // minst en resept på narkotiske legemidler, og antallet slike resepter per lege
          // List opp navnene på alle pasienter som har minst en gyldig resept på
          // narkotiske legemidler, og for disse, skriv ut antallet per pasient.
          statistikk.leggTil(r);
        }
        // else if (r.hentLegemiddel().hentType().equals("c")){
        //   // Resept res = r.hentLege();
        //   // LAG EN ARREAYLIST HER !!!!!!!!!!!!!
        //     System.out.println("leger som har skrevet ut minst en resept paa narkotiske legemidler : " + r.hentLege());
        // }
        // System.out.println(r.hentLege());
      //   if(r.utskrivendeLege())
      }
      statistikken();
      System.out.println("\nTotalt antall utskrevne resepter paa narkotiske legemidler " + teller1);
      System.out.println("Totalt antall utskrevne resepter paa vanedannende legemidler er : " + teller);
    }

    public static void statistikken(){
      System.out.println("\nLeger som har skrevet ut minst en resept paa narkotiske legemidler : ");
      int teller = 0;
      for(Resept stat : statistikk ){
        if(stat.hentLege().compareTo(stat.hentLege())==0){
          teller++;
          // break;
        }
        System.out.println(stat.hentLege() + ".  Antall resepter " + teller);
      }
      // List opp navnene på alle pasienter som har minst en gyldig resept på
      // narkotiske legemidler, og for disse, skriv ut antallet per pasient.
      System.out.println("\nPasienter som har minst en gyldig resept paa narkotiske legemidler : ");
      for(Resept stat : statistikk ){
        System.out.print(stat.hentPasient().hentNavn());
        System.out.println(".  Antall ganger som er igjen paa resepten :  " + stat.hentReit());
      }
    }

    public static Pasient finnPasient(int id, Lenkeliste<Pasient> liste){
      for (Pasient p : liste){
        if (p.hentId() == id){
          return p;
        }
      }
      return null;
    }

    public static Lege finnLege(String navn, SortertLenkeliste<Lege> liste){
      for (Lege l : liste){
        if (l.hentNavn().equals(navn)){
          return l;
        }
      }
      return null;
    }

    private static void lesFraFil(File fil){
        Scanner scanner = null;
        try{
            scanner = new Scanner(fil);
        }catch(FileNotFoundException e){
            System.out.println("Fant ikke filen, starter opp som et tomt Legesystem");
            return;
        }

        String innlest = scanner.nextLine();

        while(scanner.hasNextLine()){

            String[] info = innlest.split(" ");

            // Legger til alle pasientene i filen
            if(info[1].compareTo("Pasienter") == 0){
                while(scanner.hasNextLine()) {
                    innlest = scanner.nextLine();
                    //Om vi er ferdig med å legge til pasienter, bryter vi whileløkken,
                    //slik at vi fortsetter med koden for å legge til legemiddler
                    if(innlest.charAt(0) == '#'){
                        break;
                    }
                    String[] pasienter = innlest.split(", ");
                    Pasient pasient = new Pasient(pasienter[0],pasienter[1]);
                    pasienten.leggTil(pasient);
                    // System.out.println(pasient);
                    //
                    //MERK:  Her må du legge til pasienten i en lenkeliste
                    //
                }
                pasienten.skrivall();
            }
            //Legger inn Legemidlene
            else if(info[1].compareTo("Legemidler") == 0){
                while(scanner.hasNextLine()){
                    innlest = scanner.nextLine();
                    //Om vi er ferdig med å legge til legemidler, bryt whileløkken,
                    //slik at vi fortsetter til koden for å legge til leger
                    if(innlest.charAt(0) == '#'){
                        break;
                    }
                    String[] legemiddel = innlest.split(", ");
                    if(legemiddel[1].compareTo("a") == 0){

                      String navn = legemiddel[0];
                      String type = legemiddel[1];
                      double pris =Double.parseDouble(legemiddel[2]);
                      double virkestoff = Double.parseDouble(legemiddel[3]);
                      int styrke = Integer.parseInt(legemiddel[4]);

                      Legemiddel prA = new PreparatA(navn,type, pris, virkestoff,styrke);
                      legemidler.leggTil(prA);
                      // legemidler.skrivall();

                      // System.out.println(prA);
                        //
                        //MERK:  Her må du legge til et PreparatA i en lenkeliste
                        //
                    }
                    else if(legemiddel[1].compareTo("b") == 0){

                      String navn = legemiddel[0];
                      String type = legemiddel[1];
                      double pris =Double.parseDouble(legemiddel[2]);
                      double virkestoff = Double.parseDouble(legemiddel[3]);
                      int styrke = Integer.parseInt(legemiddel[4]);
                      Legemiddel prB = new PreparatB(navn,type, pris, virkestoff,styrke);
                      legemidler.leggTil(prB);
                      // legemidler.skrivall();
                      // System.out.println(prB);
                        //
                        //MERK:  Her må du legge til et PreparatB i en lenkeliste
                        //
                    }else if (legemiddel[1].compareTo("c") == 0){
                      String navn = legemiddel[0];
                      String type = legemiddel[1];
                      double pris =Double.parseDouble(legemiddel[2]);
                      double virkestoff = Double.parseDouble(legemiddel[3]);

                      Legemiddel prC = new PreparatC(navn,type, pris, virkestoff);
                      legemidler.leggTil(prC);

                      // System.out.println(prC);
                        //
                        //MERK:  Her må du legge til et PreparatC i en lenkeliste
                        //
                    }

                }
                System.out.println("\n ----------------- \n");
                legemidler.skrivall();
            }
            //Legger inn leger
            else if(info[1].compareTo("Leger") == 0){
                while(scanner.hasNextLine()){
                    innlest = scanner.nextLine();
                    //Om vi er ferdig med å legge til leger, bryt whileløkken,
                    //slik at vi fortsetter til koden for å legge til resepter
                    if(innlest.charAt(0) == '#'){
                        break;
                    }
                    info = innlest.split(", ");
                    int kontrollid = Integer.parseInt(info[1]);
                    if(kontrollid == 0){
                      String navn = info[0];
                      Lege lege = new Lege(navn);
                      leger.leggTil(lege);
                    }else{
                      String navn = info[0];
                      int kontrollID = Integer.parseInt(info[1]);

                      Lege spesialisten = new Spesialist(navn,kontrollID);
                      leger.leggTil(spesialisten);

                      // System.out.println(spesialisten);
                        //
                        //MERK:  Her må du legge til et spesialist objekt i en sortert lenkeliste
                        //
                    }
                }
                System.out.println("\n ----------------- \n");
                leger.skrivall();

            }
            //Legger inn Resepter
            else if(info[1].compareTo("Resepter") == 0){
                while(scanner.hasNextLine()){
                    innlest = scanner.nextLine();
                    info = innlest.split(", ");
                    // Her må du finne legen, legemiddelet, og pasienten som ligger
                    // i lenkelistene utifra informasjonen.
                    //
                    // System.out.println("-------------------------");
                    // leger.skrivall();
                    // System.out.println(info[1]);
                    Lege legen = finnLege(info[1], leger);
                    // System.out.println(legen);
                    Legemiddel legemiddelet =(legemidler.hent(Integer.parseInt(info[0])));
                    Pasient pasientiden = (pasienten.hent(Integer.parseInt(info[2])));
                    int reit = Integer.parseInt(info[3]);

                    try{
                      Resept resepten = legen.skrivResept(legemiddelet,pasientiden,reit);
                      Resepter.leggTil(resepten);
                      // Psient.leggTilResept(resepten);
                    }
                    catch(UlovligUtskrift u){
                      System.out.print(u.getMessage());
                    }
                    //
                    // Dette burde skilles ut i hjelpemetoder leter gjennom listene
                    // og returnerer riktig objekt, ut ifra informasjonen som ble lest inn
                    //
                    // Opprett et reseptobjekt med skrivResept funksjonen i legen,
                    // og legg det til i en lenkeliste
                    //
                    // Dersom legeobjektene dine oppretter PResepter, kan du ignorere reit
                    //
                    //
                }
            }
        }
        //D3: Implementer funksjonalitet for å skrive ut en ryddig oversikt om alle elementer i
        //legesystemet. Leger skal skrives ut i ordnet rekkefølge.
        // System.out.println("\n ----------------- \n");
        // Resepter.skrivall();
        System.out.println("\n ----------------- \n");
        System.out.println(" Storrelsen Til Listen Resepter er : " + Resepter.stoerrelse());
        System.out.println("\n ----------------- \n");
    }
}
